/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import dto.ValidateError;
import java.util.List;

/**
 *
 * @author USER
 */
public interface ValiditionBase {
    List<ValidateError> validate();
}
