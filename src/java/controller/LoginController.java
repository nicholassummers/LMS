/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AssignmentDao;
import dao.GradeDao;
import dao.TAssign;
import dao.TotalAssignment;
import dao.UserDao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import orm.Assignment;

import orm.TUser;
import orm.UserAssignment;

/**
 *
 * @author Damien
 */
public class LoginController implements Controller {// is extends AbstractControlller or this?------------------------

    private UserDao ud;
    private AssignmentDao ad;
    private GradeDao gd;

    public void setUserDao1(UserDao UserDao) {
        this.ud = UserDao;
    }

    public void setAssignmentDao1(AssignmentDao d) {
        ad = d;
    }

    public void setGradeDao1(GradeDao g) {
        gd = g;
    }
    //    @RequestMapping( method = RequestMethod.POST)
//    @RequestMapping(value = "/login")
//    public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
//        ModelAndView rmav = new ModelAndView();
//        System.out.println("Username " + request.getParameter("username"));
    //return rmav;
//    }

    // @RequestMapping(value = "/login")
//   public ModelAndView loggs() {
//        System.out.println("here1");
//      return new ModelAndView("login", "blank", new Object());
//   }
    // @RequestMapping(value = "/logo", method = RequestMethod.POST)
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String act = request.getParameter("action") + "";
        int forAssign = 0;
//        if(act.isEmpty()){
//            return new ModelAndView("performLogin", "invalidLogin", "");
//        }

        //System.out.println("act is" + act +"p");
        if (act.equals("login") || act.equals("")) {

            //       if (session.getAttribute("tUser") == null) {
            String username = request.getParameter("username");
            String pass = request.getParameter("password") + "";

            TUser tuser = ud.Login(username, pass);
            System.out.println("userid is " + tuser.getUserId());
            if (tuser.getUserId() == 0 || tuser.getUserId() == -1) {
                if (pass.equals("null")) {
                    //System.out.println("in here");
                    return new ModelAndView("performLogin", "invalidLogin", "");
                }
                return new ModelAndView("performLogin", "invalidLogin", "Invalid Username or password. Try Again");
            }

            session.setAttribute("tUser", tuser);
            return new ModelAndView("viewCourses", "courses", ud.GetCourses(tuser.getUserId(), tuser.getRoleId()));
        } //        } else {return new ModelAndView("performLogin", "invalidLogin", "");}
        else if (act.equals("people")) {
            return new ModelAndView("coursePeople", "people", ud.GetPeople(Integer.parseInt(request.getParameter("cid"))));
        } else if (act.equals("grades")) {
            return toviewGrades(session, Integer.parseInt(request.getParameter("cid")));
        } else if (act.equals("assignments")) {
            forAssign = Integer.parseInt(request.getParameter("cid"));
            session.setAttribute("num", forAssign);
            return new ModelAndView("courseAssignments", "retAssignments", ad.GetAssignments(forAssign));
        } else if (act.equals("assignment")) {
            ArrayList<Assignment> aa = ad.GetAssignments((int)session.getAttribute("num"));
            Assignment assign = new Assignment();
            System.out.println("out hur"+ forAssign);
            for (int i = 0; i < aa.size(); i++) {
                System.out.println("gaga " + assign.getAssignmentName());
                if (aa.get(i).getAssignmentId() == Integer.parseInt(request.getParameter("aid"))) {
                    assign = aa.get(i);
                }
            }
            return new ModelAndView("viewAssignment", "assignment", assign);
        }
        return new ModelAndView("performLogin", "invalidLogin", "");

    }

    @RequestMapping(value = "/people", method = RequestMethod.GET)
    public ModelAndView beep(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // System.out.println("in courseController");
        //int cid = Integer.parseInt(request.getParameter("action"));
        return new ModelAndView("coursePeople", "people", ud.GetPeople(1));
    }

    public void PeopleMethod() {
        //return new ModelAndView("coursePeople", "people", ud.GetPeople(WHATEVER COURSEID IS));
    }

    public void courseassignmentmethod() {
        //return new ModelAndView("courseAssignments", "retAssignments", ad.GetAssignments(1));
    }

    public void anAssignmentMethod() {
//            ArrayList<Assignment>  aa =ad.GetAssignments(1);
//            Assignment assign = aa.get(0);
//            return new ModelAndView("viewAssignment", "assignment", assign);
    }

    public ModelAndView toviewGrades(HttpSession session, int courseId) {

        TUser tu = (TUser) session.getAttribute("tUser");
        if (tu.getRoleId() == 1) {
            ArrayList<Assignment> assign = ad.GetAssignments(courseId);
            ArrayList<TUser> tuserarr = ud.GetPeople2(courseId);
            TotalAssignment ta = new TotalAssignment(assign, 90);
            ArrayList<TAssign> tassigntemp = new ArrayList<TAssign>();
            TAssign t = new TAssign();

            for (int i = 0; i < assign.size(); i++) {
                UserAssignment userAssign = gd.GetGrade(tu.getUserId(), courseId, assign.get(i).getAssignmentId());
                t.setUserAssign(userAssign);
                tassigntemp.add(t);
                System.out.println("out " + t.getUserAssign().getScore());
            }

            ta.setTassign(tassigntemp);

            session.setAttribute("tassign", ta.getTassign());
            return new ModelAndView("courseGrades", "ta", ta);
        } else {
            ArrayList<Assignment> assign = ad.GetAssignments(courseId);
            ArrayList<TUser> tuserarr = ud.GetPeople2(courseId);
            TotalAssignment ta = new TotalAssignment(assign, 90);
            ArrayList<TAssign> tassigntemp = new ArrayList<TAssign>();
            TAssign t = new TAssign();
            for (int j = 0; j < tuserarr.size(); j++) {
                int tempid = tuserarr.get(j).getUserId();
                for (int i = 0; i < assign.size(); i++) {
                    UserAssignment userAssign = gd.GetGrade(tempid, courseId, assign.get(i).getAssignmentId());
                    t.setUserAssign(userAssign);
                    t.settUser(tuserarr.get(j));
                    tassigntemp.add(t);
                    System.out.println("out " + t.gettUser().getUserName());
                }

            }
            ta.setTassign(tassigntemp);

            //System.out.println("tuserarr " + tuserarr.get(0).getUserName());
            return new ModelAndView("courseGrades", "ta", ta);
        }
    }

}
