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

package org.clang.basic.java;

import java.lang.reflect.Field;
import java.util.logging.Level;
import org.clang.basic.*;
import org.clang.basic.impl.DiagnosticIDsStatics;
import org.clang.basic.impl.StaticDiagCategoryRec;
import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;

/**
 *
 * @author Vladimir Voskresensky
 */
public final class diagJava {

  private diagJava() {
  }
  
  // JAVA: manuall added for tracing
  private static final String[] DIAG_NAMES;
  // JAVA: manually added for clank diagnostic integration
  private static final String[] CATEGORY_NAMES;

  static {
    Field[] fields = diag.class.getDeclaredFields();
    // first, go throughthe all fields and 
    // 1) replace irrelevant with nulls 
    // 2) find  maximum value
    int max = 0;
    boolean insideTheRange = false;
    for (int i = 0; i < fields.length; i++) {
      final Field f = fields[i];
      final String name = f.getName();      
      if ("__COMMONSTART".equals(name)) {
        insideTheRange = true;
      } else if ("NUM_BUILTIN_SERIALIZATION_DIAGNOSTICS".equals(f.getName())) {
        insideTheRange = false;
      }
      if (insideTheRange) {
        if (name.startsWith("__") && name.endsWith("START")) {
          fields[i] = null;
        } else if (name.startsWith("NUM_") && name.endsWith("_DIAGNOSTICS")) {
          fields[i] = null;
        } else {
          assert f.getType() == int.class;
          int value = -1;
          try {
            value = f.getInt(diag.class);
          } catch (IllegalArgumentException | IllegalAccessException ex) {
            fields[i] = null;
            NativeTrace.printStackTraceOnce(ex, Level.SEVERE, false);
          }
          if (value > 0) {
            max = (value > max) ? value : max;
          }
        }        
      } else {
        fields[i] = null;
      }              
    }
    DIAG_NAMES = new String[max+1];
    // now fill the table
    for (Field f : fields) {      
      if (f != null) {        
        assert f.getType() == int.class;
        try {
          int value = f.getInt(diag.class);
          DIAG_NAMES[value] = f.getName();
        } catch (IllegalArgumentException | IllegalAccessException ex) {
          NativeTrace.printStackTraceOnce(ex, Level.SEVERE, false);
        }
      }
    }

    CATEGORY_NAMES = new String[DiagnosticIDsStatics.CategoryNameTable.length];
    for (int i = 0; i < DiagnosticIDsStatics.CategoryNameTable.length; i++) {
      StaticDiagCategoryRec staticDiagCategoryRec = DiagnosticIDsStatics.CategoryNameTable[i];
      CATEGORY_NAMES[i] = staticDiagCategoryRec.getName().toJavaString();
    }
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public static String $name(/*uint*/int DiagID) {
    int id = DiagID;
    if (id >= 0 && id < DIAG_NAMES.length) {
      if (DIAG_NAMES[id] != null) {
        return DIAG_NAMES[id];
      }
    } 
    return "Unknown diagnostic ID " + DiagID;
  }  
  
  public static final String[] getDiagnosticNames() {
    return DIAG_NAMES;
  }

  public static final String[] getCategoryNames() {
    return CATEGORY_NAMES;
  }

  public static String $categoryName(/*uint*/byte Category) {
    StringRef Name = DiagnosticIDs.getCategoryNameFromID($uchar2uint(Category));
    return Name.toJavaString();
  }
  
  public static String $diagClass(/*uint*/int DiagClass) {
    switch (DiagClass) {
      case DiagnosticIDsStatics.CLASS_NOTE:
        return "CLASS_NOTE";
      case DiagnosticIDsStatics.CLASS_REMARK:
        return "CLASS_REMARK";
      case DiagnosticIDsStatics.CLASS_WARNING:
        return "CLASS_WARNING";
      case DiagnosticIDsStatics.CLASS_EXTENSION:
        return "CLASS_EXTENSION";
      case DiagnosticIDsStatics.CLASS_ERROR:
        return "CLASS_ERROR";
    }
    return "Unknown Class ID " + DiagClass;
  }
}
