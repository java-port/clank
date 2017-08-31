/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.clang.tools.services.support;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 *
 * @author masha
 */
public class Utilitites {

  public static ResourceBundle getBundle(Class<?> clazz)
          throws MissingResourceException {
    String name = findName(clazz);

    return getBundle(name, Locale.getDefault(), clazz.getClassLoader());
  }

  /**
   * Finds package name for given class
   */
  private static String findName(Class<?> clazz) {
    String pref = clazz.getName();
    int last = pref.lastIndexOf('.');

    if (last >= 0) {
      pref = pref.substring(0, last + 1);

      return pref + "Bundle"; // NOI18N
    } else {
      // base package, search for bundle
      return "Bundle"; // NOI18N
    }
  }

  /**
   * Finds a localized and/or branded string in a bundle.
   *
   * @param clazz the class to use to locate the bundle (see
   * {@link #getBundle(Class)} for details)
   * @param resName name of the resource to look for
   * @return the string associated with the resource
   * @throws MissingResourceException if either the bundle or the string cannot
   * be found
   */
  public static String getMessage(Class<?> clazz, String resName)
          throws MissingResourceException {
    return getBundle(clazz).getString(resName);
  }

  public static ResourceBundle getBundle(String baseName, Locale locale, ClassLoader loader)
          throws MissingResourceException {
//        if (USE_DEBUG_LOADER) {
//            loader = DebugLoader.get(loader);
//        }

    // Could more simply use ResourceBundle.getBundle (plus some special logic
    // with MergedBundle to handle branding) instead of manually finding bundles.
    // However this code is faster and has some other desirable properties.
    // Cf. #13847.
    ResourceBundle b = ResourceBundle.getBundle(baseName, locale, loader);
    //getBundleFast(baseName, locale, loader);

    if (b != null) {
      return b;
    } else {
      MissingResourceException e = new MissingResourceException("No such bundle " + baseName, baseName, null); // NOI18N
//
//            if (Lookup.getDefault().lookup(ClassLoader.class) == null) {
//                //Exceptions.attachMessage(e,
//               //                          "Class loader not yet initialized in lookup"); // NOI18N
//            } else {
//               // Exceptions.attachMessage(e, "Offending classloader: " + loader); // NOI18N
//            }

      throw e;
    }
  }
}
