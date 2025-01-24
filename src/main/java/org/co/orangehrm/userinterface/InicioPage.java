package org.co.orangehrm.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class InicioPage {
    public static final Target LINK_RECLUTAR = Target.the("permite ingresar al módulo recruiment").locatedBy("//a[contains(@href,'viewRecruitmentModule')]");
    public static final Target ELM_NOMBRE_ADMIN = Target.the("elemento del nombre del administrador").locatedBy("//span[@class='oxd-userdropdown-tab']//p[1]");

}
