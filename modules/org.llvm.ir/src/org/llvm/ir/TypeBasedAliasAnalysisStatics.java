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
package org.llvm.ir;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.cl.*;
import org.llvm.pass.*;
import org.llvm.cl.aliases.optBool;


//<editor-fold defaultstate="collapsed" desc="static type TypeBasedAliasAnalysisStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.TypeBasedAliasAnalysisStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZL10EnableTBAA;_ZL16isStructPathTBAAPKN4llvm6MDNodeE;_ZL40InitializeTypeBasedAAWrapperPassPassFlag;_ZL40initializeTypeBasedAAWrapperPassPassOnceRN4llvm12PassRegistryE; -static-type=TypeBasedAliasAnalysisStatics -package=org.llvm.ir")
//</editor-fold>
public final class TypeBasedAliasAnalysisStatics {


// A handy option for disabling TBAA functionality. The same effect can also be
// achieved by stripping the !tbaa tags from IR, but this option is sometimes
// more convenient.
//<editor-fold defaultstate="collapsed" desc="EnableTBAA">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 135,
 FQN="EnableTBAA", NM="_ZL10EnableTBAA",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZL10EnableTBAA")
//</editor-fold>
public static optBool EnableTBAA/*J*/= new optBool(opt.StorageKind.Internal, $("enable-tbaa"), ClGlobals.init$Bool(true));

/// Check the first operand of the tbaa tag node, if it is a MDNode, we treat
/// it as struct-path aware TBAA format, otherwise, we treat it as scalar TBAA
/// format.
//<editor-fold defaultstate="collapsed" desc="isStructPathTBAA">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 275,
 FQN="isStructPathTBAA", NM="_ZL16isStructPathTBAAPKN4llvm6MDNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZL16isStructPathTBAAPKN4llvm6MDNodeE")
//</editor-fold>
public static boolean isStructPathTBAA(/*const*/ MDNode /*P*/ MD) {
  // Anonymous TBAA root starts with a MDNode and dragonegg uses it as
  // a TBAA tag.
  return isa_MDNode(MD.getOperand(0)) && $greatereq_uint(MD.getNumOperands(), 3);
}

//<editor-fold defaultstate="collapsed" desc="initializeTypeBasedAAWrapperPassPassOnce">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 593,
 FQN="initializeTypeBasedAAWrapperPassPassOnce", NM="_ZL40initializeTypeBasedAAWrapperPassPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZL40initializeTypeBasedAAWrapperPassPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeTypeBasedAAWrapperPassPassOnce(final PassRegistry /*&*/ Registry) {
  Class<?> cls;
  try {
    cls = Class.forName("org.llvm.analysis.TypeBasedAAWrapperPass");
    PassInfo /*P*/ PI = new PassInfo($("Type-Based Alias Analysis"), $("tbaa"), 
            $AddrOf(cls), ()->{
              try {
                return (Pass)cls.newInstance();
              } catch (InstantiationException ex) {
                Logger.getLogger(TypeBasedAliasAnalysisStatics.class.getName()).log(Level.SEVERE, null, ex);
              } catch (IllegalAccessException ex) {
                Logger.getLogger(TypeBasedAliasAnalysisStatics.class.getName()).log(Level.SEVERE, null, ex);
              }
              return null;
            },
            //((NormalCtor_t)(/*FuncRef*/IrLlvmGlobals.<TypeBasedAAWrapperPass>callDefaultCtor)),
            false, true);
    Registry.registerPass($Deref(PI), true);
    return PI;
  } catch (ClassNotFoundException ex) {
    Logger.getLogger(TypeBasedAliasAnalysisStatics.class.getName()).log(Level.SEVERE, null, ex);
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="InitializeTypeBasedAAWrapperPassPassFlag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 593,
 FQN="InitializeTypeBasedAAWrapperPassPassFlag", NM="_ZL40InitializeTypeBasedAAWrapperPassPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZL40InitializeTypeBasedAAWrapperPassPassFlag")
//</editor-fold>
public static std.once_flag InitializeTypeBasedAAWrapperPassPassFlag/*J*/= new std.once_flag();
} // END OF class TypeBasedAliasAnalysisStatics
