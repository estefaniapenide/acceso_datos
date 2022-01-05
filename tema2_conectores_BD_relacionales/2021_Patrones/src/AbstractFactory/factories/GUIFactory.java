/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactory.factories;

import AbstractFactory.buttons.Button;
import AbstractFactory.checkboxes.Checkbox;

/**
 *
 * @author mrnov
 */
/**
 * Abstract factory knows about all (abstract) product types.
 */

public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
