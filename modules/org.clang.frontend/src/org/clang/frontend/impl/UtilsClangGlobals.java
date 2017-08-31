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
package org.clang.frontend.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clang.frontend.FrontendClangGlobals.*;
import org.clang.basic.*;
import org.llvm.option.*;


//<editor-fold defaultstate="collapsed" desc="static type UtilsClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ARCMT.cpp -nm=Tpl__ZN5clang11BuryPointerESt10unique_ptrIT_St14default_deleteIS1_EE;_ZN5clang18getLastArgIntValueERKN4llvm3opt7ArgListENS1_12OptSpecifierEiRNS_17DiagnosticsEngineE;_ZN5clang21getLastArgUInt64ValueERKN4llvm3opt7ArgListENS1_12OptSpecifierEyRNS_17DiagnosticsEngineE; -static-type=UtilsClangGlobals -package=org.clang.frontend.impl")
//</editor-fold>
public final class UtilsClangGlobals {

//<editor-fold defaultstate="collapsed" desc="clang::getLastArgIntValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", line = 198,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", old_line = 193,
 FQN="clang::getLastArgIntValue", NM="_ZN5clang18getLastArgIntValueERKN4llvm3opt7ArgListENS1_12OptSpecifierEiRNS_17DiagnosticsEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ARCMT.cpp -nm=_ZN5clang18getLastArgIntValueERKN4llvm3opt7ArgListENS1_12OptSpecifierEiRNS_17DiagnosticsEngineE")
//</editor-fold>
public static /*inline*/ int getLastArgIntValue$R(/*const*/ ArgList /*&*/ Args, 
                    OptSpecifier Id, int Default, 
                    DiagnosticsEngine /*&*/ Diags) {
  return getLastArgIntValue$P(Args, /*NO_COPY*/Id, Default, /*AddrOf*/Diags);
}

//<editor-fold defaultstate="collapsed" desc="clang::getLastArgUInt64Value">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", line = 208,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", old_line = 203,
 FQN="clang::getLastArgUInt64Value", NM="_ZN5clang21getLastArgUInt64ValueERKN4llvm3opt7ArgListENS1_12OptSpecifierEyRNS_17DiagnosticsEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ARCMT.cpp -nm=_ZN5clang21getLastArgUInt64ValueERKN4llvm3opt7ArgListENS1_12OptSpecifierEyRNS_17DiagnosticsEngineE")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ getLastArgUInt64Value$R(/*const*/ ArgList /*&*/ Args, 
                       OptSpecifier Id, 
                       long/*uint64_t*/ Default, 
                       DiagnosticsEngine /*&*/ Diags) {
  return getLastArgUInt64Value$P(Args, new OptSpecifier(Id), Default, /*AddrOf*/Diags);
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::BuryPointer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", line = 219,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", old_line = 214,
 FQN="clang::BuryPointer", NM="Tpl__ZN5clang11BuryPointerESt10unique_ptrIT_St14default_deleteIS1_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ARCMT.cpp -nm=Tpl__ZN5clang11BuryPointerESt10unique_ptrIT_St14default_deleteIS1_EE")
//</editor-fold>
public static </*typename*/ T> void BuryPointer$T(std.unique_ptr<T> Ptr) {
  BuryPointer(Ptr.release());
}

} // END OF class UtilsClangGlobals
