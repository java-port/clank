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

package org.clang.clangc;

import org.clank.support.*;


/**
* \brief Options to control the display of diagnostics.
*
* The values in this enum are meant to be combined to customize the
* behavior of \c clang_formatDiagnostic().
*/
//<editor-fold defaultstate="collapsed" desc="CXDiagnosticDisplayOptions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang-c/Index.h", line = 804,
 FQN="CXDiagnosticDisplayOptions", NM="_Z26CXDiagnosticDisplayOptions",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z26CXDiagnosticDisplayOptions")
//</editor-fold>
public final class/*enum*/ CXDiagnosticDisplayOptions {
  /**
  * \brief Display the source-location information where the
  * diagnostic was located.
  *
  * When set, diagnostics will be prefixed by the file, line, and
  * (optionally) column to which the diagnostic refers. For example,
  *
  * \code
  * test.c:28: warning: extra tokens at end of #endif directive
  * \endcode
  *
  * This option corresponds to the clang flag \c -fshow-source-location.
  */
  public static final /*uint*/int CXDiagnostic_DisplaySourceLocation = 0x01;
  
  /**
  * \brief If displaying the source-location information of the
  * diagnostic, also include the column number.
  *
  * This option corresponds to the clang flag \c -fshow-column.
  */
  public static final /*uint*/int CXDiagnostic_DisplayColumn = 0x02;
  
  /**
  * \brief If displaying the source-location information of the
  * diagnostic, also include information about source ranges in a
  * machine-parsable format.
  *
  * This option corresponds to the clang flag
  * \c -fdiagnostics-print-source-range-info.
  */
  public static final /*uint*/int CXDiagnostic_DisplaySourceRanges = 0x04;
  
  /**
  * \brief Display the option name associated with this diagnostic, if any.
  *
  * The option name displayed (e.g., -Wconversion) will be placed in brackets
  * after the diagnostic text. This option corresponds to the clang flag
  * \c -fdiagnostics-show-option.
  */
  public static final /*uint*/int CXDiagnostic_DisplayOption = 0x08;
  
  /**
  * \brief Display the category number associated with this diagnostic, if any.
  *
  * The category number is displayed within brackets after the diagnostic text.
  * This option corresponds to the clang flag 
  * \c -fdiagnostics-show-category=id.
  */
  public static final /*uint*/int CXDiagnostic_DisplayCategoryId = 0x10;
  
  /**
  * \brief Display the category name associated with this diagnostic, if any.
  *
  * The category name is displayed within brackets after the diagnostic text.
  * This option corresponds to the clang flag 
  * \c -fdiagnostics-show-category=name.
  */
  public static final /*uint*/int CXDiagnostic_DisplayCategoryName = 0x20;
}
