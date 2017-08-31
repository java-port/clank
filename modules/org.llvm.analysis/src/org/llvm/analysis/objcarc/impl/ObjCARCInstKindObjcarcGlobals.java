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
package org.llvm.analysis.objcarc.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import org.llvm.analysis.LibFunc.target.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;


//<editor-fold defaultstate="collapsed" desc="static type ObjCARCInstKindObjcarcGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.objcarc.impl.ObjCARCInstKindObjcarcGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCInstKind.cpp -nm=_ZN4llvm7objcarc11IsNeverTailENS0_11ARCInstKindE;_ZN4llvm7objcarc12IsAlwaysTailENS0_11ARCInstKindE;_ZN4llvm7objcarc12IsForwardingENS0_11ARCInstKindE;_ZN4llvm7objcarc12IsNoopOnNullENS0_11ARCInstKindE;_ZN4llvm7objcarc13IsAutoreleaseENS0_11ARCInstKindE;_ZN4llvm7objcarc14CanInterruptRVENS0_11ARCInstKindE;_ZN4llvm7objcarc14GetARCInstKindEPKNS_5ValueE;_ZN4llvm7objcarc16GetFunctionClassEPKNS_8FunctionE;_ZN4llvm7objcarc19GetBasicARCInstKindEPKNS_5ValueE;_ZN4llvm7objcarc20CanDecrementRefCountENS0_11ARCInstKindE;_ZN4llvm7objcarc6IsUserENS0_11ARCInstKindE;_ZN4llvm7objcarc8IsRetainENS0_11ARCInstKindE;_ZN4llvm7objcarc9IsNoThrowENS0_11ARCInstKindE;_ZN4llvm7objcarclsERNS_11raw_ostreamENS0_11ARCInstKindE; -static-type=ObjCARCInstKindObjcarcGlobals -package=org.llvm.analysis.objcarc.impl")
//</editor-fold>
public final class ObjCARCInstKindObjcarcGlobals {

//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::operator<<">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ObjCARCInstKind.cpp", line = 30,
 FQN="llvm::objcarc::operator<<", NM="_ZN4llvm7objcarclsERNS_11raw_ostreamENS0_11ARCInstKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCInstKind.cpp -nm=_ZN4llvm7objcarclsERNS_11raw_ostreamENS0_11ARCInstKindE")
//</editor-fold>
public static raw_ostream /*&*/ $out_raw_ostream_ARCInstKind$C(final raw_ostream /*&*/ OS, 
                              /*const*/ ARCInstKind Class) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Test if the given class is a kind of user.

/// \brief Test if the given class is a kind of user.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::IsUser">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ObjCARCInstKind.cpp", line = 330,
 FQN="llvm::objcarc::IsUser", NM="_ZN4llvm7objcarc6IsUserENS0_11ARCInstKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCInstKind.cpp -nm=_ZN4llvm7objcarc6IsUserENS0_11ARCInstKindE")
//</editor-fold>
public static boolean IsUser(ARCInstKind Class) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Test if the given class is objc_retain or equivalent.

/// \brief Test if the given class is objc_retain or equivalent.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::IsRetain">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ObjCARCInstKind.cpp", line = 364,
 FQN="llvm::objcarc::IsRetain", NM="_ZN4llvm7objcarc8IsRetainENS0_11ARCInstKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCInstKind.cpp -nm=_ZN4llvm7objcarc8IsRetainENS0_11ARCInstKindE")
//</editor-fold>
public static boolean IsRetain(ARCInstKind Class) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Test if the given class is objc_autorelease or equivalent.

/// \brief Test if the given class is objc_autorelease or equivalent.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::IsAutorelease">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ObjCARCInstKind.cpp", line = 400,
 FQN="llvm::objcarc::IsAutorelease", NM="_ZN4llvm7objcarc13IsAutoreleaseENS0_11ARCInstKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCInstKind.cpp -nm=_ZN4llvm7objcarc13IsAutoreleaseENS0_11ARCInstKindE")
//</editor-fold>
public static boolean IsAutorelease(ARCInstKind Class) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Test if the given class represents instructions which return their
/// argument verbatim.

/// \brief Test if the given class represents instructions which return their
/// argument verbatim.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::IsForwarding">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ObjCARCInstKind.cpp", line = 435,
 FQN="llvm::objcarc::IsForwarding", NM="_ZN4llvm7objcarc12IsForwardingENS0_11ARCInstKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCInstKind.cpp -nm=_ZN4llvm7objcarc12IsForwardingENS0_11ARCInstKindE")
//</editor-fold>
public static boolean IsForwarding(ARCInstKind Class) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Test if the given class represents instructions which do nothing if
/// passed a null pointer.

/// \brief Test if the given class represents instructions which do nothing if
/// passed a null pointer.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::IsNoopOnNull">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ObjCARCInstKind.cpp", line = 470,
 FQN="llvm::objcarc::IsNoopOnNull", NM="_ZN4llvm7objcarc12IsNoopOnNullENS0_11ARCInstKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCInstKind.cpp -nm=_ZN4llvm7objcarc12IsNoopOnNullENS0_11ARCInstKindE")
//</editor-fold>
public static boolean IsNoopOnNull(ARCInstKind Class) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Test if the given class represents instructions which are always safe
/// to mark with the "tail" keyword.

/// \brief Test if the given class represents instructions which are always safe
/// to mark with the "tail" keyword.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::IsAlwaysTail">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ObjCARCInstKind.cpp", line = 505,
 FQN="llvm::objcarc::IsAlwaysTail", NM="_ZN4llvm7objcarc12IsAlwaysTailENS0_11ARCInstKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCInstKind.cpp -nm=_ZN4llvm7objcarc12IsAlwaysTailENS0_11ARCInstKindE")
//</editor-fold>
public static boolean IsAlwaysTail(ARCInstKind Class) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Test if the given class represents instructions which are never safe
/// to mark with the "tail" keyword.

/// \brief Test if the given class represents instructions which are never safe
/// to mark with the "tail" keyword.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::IsNeverTail">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ObjCARCInstKind.cpp", line = 541,
 FQN="llvm::objcarc::IsNeverTail", NM="_ZN4llvm7objcarc11IsNeverTailENS0_11ARCInstKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCInstKind.cpp -nm=_ZN4llvm7objcarc11IsNeverTailENS0_11ARCInstKindE")
//</editor-fold>
public static boolean IsNeverTail(ARCInstKind Class) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Test if the given class represents instructions which are always safe
/// to mark with the nounwind attribute.

/// \brief Test if the given class represents instructions which are always safe
/// to mark with the nounwind attribute.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::IsNoThrow">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ObjCARCInstKind.cpp", line = 580,
 FQN="llvm::objcarc::IsNoThrow", NM="_ZN4llvm7objcarc9IsNoThrowENS0_11ARCInstKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCInstKind.cpp -nm=_ZN4llvm7objcarc9IsNoThrowENS0_11ARCInstKindE")
//</editor-fold>
public static boolean IsNoThrow(ARCInstKind Class) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Test whether the given instruction can autorelease any pointer or cause an
/// autoreleasepool pop.

/// Test whether the given instruction can autorelease any pointer or cause an
/// autoreleasepool pop.
///
/// This means that it *could* interrupt the RV optimization.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::CanInterruptRV">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ObjCARCInstKind.cpp", line = 619,
 FQN="llvm::objcarc::CanInterruptRV", NM="_ZN4llvm7objcarc14CanInterruptRVENS0_11ARCInstKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCInstKind.cpp -nm=_ZN4llvm7objcarc14CanInterruptRVENS0_11ARCInstKindE")
//</editor-fold>
public static boolean CanInterruptRV(ARCInstKind Class) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Determine if F is one of the special known Functions.  If it isn't,
/// return ARCInstKind::CallOrUser.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::GetFunctionClass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ObjCARCInstKind.cpp", line = 87,
 FQN="llvm::objcarc::GetFunctionClass", NM="_ZN4llvm7objcarc16GetFunctionClassEPKNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCInstKind.cpp -nm=_ZN4llvm7objcarc16GetFunctionClassEPKNS_8FunctionE")
//</editor-fold>
public static ARCInstKind GetFunctionClass(/*const*/ Function /*P*/ F) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Determine which objc runtime call instruction class V belongs to.
///
/// This is similar to GetARCInstKind except that it only detects objc
/// runtime calls. This allows it to be faster.
///
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::GetBasicARCInstKind">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCInstKind.h", line = 102,
 FQN="llvm::objcarc::GetBasicARCInstKind", NM="_ZN4llvm7objcarc19GetBasicARCInstKindEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCInstKind.cpp -nm=_ZN4llvm7objcarc19GetBasicARCInstKindEPKNS_5ValueE")
//</editor-fold>
public static /*inline*/ ARCInstKind GetBasicARCInstKind(/*const*/ Value /*P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Map V to its ARCInstKind equivalence class.

/// \brief Determine what kind of construct V is.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::GetARCInstKind">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ObjCARCInstKind.cpp", line = 232,
 FQN="llvm::objcarc::GetARCInstKind", NM="_ZN4llvm7objcarc14GetARCInstKindEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCInstKind.cpp -nm=_ZN4llvm7objcarc14GetARCInstKindEPKNS_5ValueE")
//</editor-fold>
public static ARCInstKind GetARCInstKind(/*const*/ Value /*P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Returns false if conservatively we can prove that any instruction mapped to
/// this kind can not decrement ref counts. Returns true otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::CanDecrementRefCount">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ObjCARCInstKind.cpp", line = 652,
 FQN="llvm::objcarc::CanDecrementRefCount", NM="_ZN4llvm7objcarc20CanDecrementRefCountENS0_11ARCInstKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCInstKind.cpp -nm=_ZN4llvm7objcarc20CanDecrementRefCountENS0_11ARCInstKindE")
//</editor-fold>
public static boolean CanDecrementRefCount(ARCInstKind Kind) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class ObjCARCInstKindObjcarcGlobals
