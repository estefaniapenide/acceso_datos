/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactory.factories;

import AbstractFactory.buttons.Button;
import AbstractFactory.buttons.MacOSButton;
import AbstractFactory.checkboxes.Checkbox;
import AbstractFactory.checkboxes.MacOSCheckbox;

/**
 *
 * @author mrnov
 */

/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */

public class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
