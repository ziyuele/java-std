package com.kangjian.designpattern.mediatormodule;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LonginFrame extends Frame implements ActionListener, Mediator {

    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;

    private ColleagueTextFiled textUser;
    private ColleagueTextFiled textPass;

    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;


    public LonginFrame(String title) throws HeadlessException {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new GridLayout(4, 2));
        createColleagues();

        add(checkGuest);
        add(checkLogin);
        add(new Label("UserName:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);

        colleagueChanged();

        pack();
        show();
    }

    @Override
    public void createColleagues() {
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", true, g);
        checkLogin = new ColleagueCheckbox("LogIn", false, g);

        textUser = new ColleagueTextFiled("", 10);
        textPass = new ColleagueTextFiled("", 10);
        textPass.setEchoChar('*');
        buttonOk = new ColleagueButton("Ok");
        buttonCancel = new ColleagueButton("Cancel");

        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonCancel.setMediator(this);
        buttonOk.setMediator(this);

        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);

        textPass.addTextListener(textPass);
        textUser.addTextListener(textUser);

        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    @Override
    public void colleagueChanged() {
        if (checkGuest.getState()) {
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);
        } else {
            textUser.setColleagueEnabled(true);
            userPassChanged();
        }
    }

    private void userPassChanged() {
        if (textUser.getText().length() > 0) {
            textPass.setColleagueEnabled(true);
            if (textPass.getText().length() > 0) {
                buttonOk.setColleagueEnabled(true);
            } else {
                buttonOk.setColleagueEnabled(false);
            }
        } else {
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(false);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(-1);
    }
}
