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
package org.llvm.analysis.objcarc;

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


//<editor-fold defaultstate="collapsed" desc="static type ObjcarcGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.analysis.objcarc.ObjcarcGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc11IsNeverTailENS0_11ARCInstKindE;_ZN4llvm7objcarc12IsAlwaysTailENS0_11ARCInstKindE;_ZN4llvm7objcarc12IsForwardingENS0_11ARCInstKindE;_ZN4llvm7objcarc12IsNoopOnNullENS0_11ARCInstKindE;_ZN4llvm7objcarc12ModuleHasARCERKNS_6ModuleE;_ZN4llvm7objcarc13EnableARCOptsE;_ZN4llvm7objcarc13IsAutoreleaseENS0_11ARCInstKindE;_ZN4llvm7objcarc13IsNullOrUndefEPKNS_5ValueE;_ZN4llvm7objcarc14CanInterruptRVENS0_11ARCInstKindE;_ZN4llvm7objcarc14GetARCInstKindEPKNS_5ValueE;_ZN4llvm7objcarc16GetCallSiteClassENS_17ImmutableCallSiteE;_ZN4llvm7objcarc16GetFunctionClassEPKNS_8FunctionE;_ZN4llvm7objcarc17GetRCIdentityRootEPKNS_5ValueE;_ZN4llvm7objcarc17GetRCIdentityRootEPNS_5ValueE;_ZN4llvm7objcarc17IsNoopInstructionEPKNS_11InstructionE;_ZN4llvm7objcarc19GetBasicARCInstKindEPKNS_5ValueE;_ZN4llvm7objcarc20CanDecrementRefCountENS0_11ARCInstKindE;_ZN4llvm7objcarc20GetArgRCIdentityRootEPNS_5ValueE;_ZN4llvm7objcarc20GetUnderlyingObjCPtrEPKNS_5ValueERKNS_10DataLayoutE;_ZN4llvm7objcarc22IsObjCIdentifiedObjectEPKNS_5ValueE;_ZN4llvm7objcarc27IsPotentialRetainableObjPtrEPKNS_5ValueE;_ZN4llvm7objcarc27IsPotentialRetainableObjPtrEPKNS_5ValueERNS_9AAResultsE;_ZN4llvm7objcarc6IsUserENS0_11ARCInstKindE;_ZN4llvm7objcarc8IsRetainENS0_11ARCInstKindE;_ZN4llvm7objcarc9IsNoThrowENS0_11ARCInstKindE;_ZN4llvm7objcarclsERNS_11raw_ostreamENS0_11ARCInstKindE; -static-type=ObjcarcGlobals -package=org.llvm.analysis.objcarc")
//</editor-fold>
public final class ObjcarcGlobals {

//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCInstKind.h", line = 58,
 FQN="llvm::objcarc::operator<<", NM="_ZN4llvm7objcarclsERNS_11raw_ostreamENS0_11ARCInstKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarclsERNS_11raw_ostreamENS0_11ARCInstKindE")
//</editor-fold>
public static raw_ostream /*&*/ $out_raw_ostream_ARCInstKind$C(final raw_ostream /*&*/ OS, /*const*/ ARCInstKind Class) {
  return /*delegate*/org.llvm.analysis.objcarc.impl.ObjCARCInstKindObjcarcGlobals.
    $out_raw_ostream_ARCInstKind$C(OS, Class);
}


/// \brief Test if the given class is a kind of user.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::IsUser">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCInstKind.h", line = 61,
 FQN="llvm::objcarc::IsUser", NM="_ZN4llvm7objcarc6IsUserENS0_11ARCInstKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc6IsUserENS0_11ARCInstKindE")
//</editor-fold>
public static boolean IsUser(ARCInstKind Class) {
  return /*delegate*/org.llvm.analysis.objcarc.impl.ObjCARCInstKindObjcarcGlobals.
    IsUser(Class);
}


/// \brief Test if the given class is objc_retain or equivalent.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::IsRetain">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCInstKind.h", line = 64,
 FQN="llvm::objcarc::IsRetain", NM="_ZN4llvm7objcarc8IsRetainENS0_11ARCInstKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc8IsRetainENS0_11ARCInstKindE")
//</editor-fold>
public static boolean IsRetain(ARCInstKind Class) {
  return /*delegate*/org.llvm.analysis.objcarc.impl.ObjCARCInstKindObjcarcGlobals.
    IsRetain(Class);
}


/// \brief Test if the given class is objc_autorelease or equivalent.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::IsAutorelease">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCInstKind.h", line = 67,
 FQN="llvm::objcarc::IsAutorelease", NM="_ZN4llvm7objcarc13IsAutoreleaseENS0_11ARCInstKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc13IsAutoreleaseENS0_11ARCInstKindE")
//</editor-fold>
public static boolean IsAutorelease(ARCInstKind Class) {
  return /*delegate*/org.llvm.analysis.objcarc.impl.ObjCARCInstKindObjcarcGlobals.
    IsAutorelease(Class);
}


/// \brief Test if the given class represents instructions which return their
/// argument verbatim.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::IsForwarding">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCInstKind.h", line = 71,
 FQN="llvm::objcarc::IsForwarding", NM="_ZN4llvm7objcarc12IsForwardingENS0_11ARCInstKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc12IsForwardingENS0_11ARCInstKindE")
//</editor-fold>
public static boolean IsForwarding(ARCInstKind Class) {
  return /*delegate*/org.llvm.analysis.objcarc.impl.ObjCARCInstKindObjcarcGlobals.
    IsForwarding(Class);
}


/// \brief Test if the given class represents instructions which do nothing if
/// passed a null pointer.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::IsNoopOnNull">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCInstKind.h", line = 75,
 FQN="llvm::objcarc::IsNoopOnNull", NM="_ZN4llvm7objcarc12IsNoopOnNullENS0_11ARCInstKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc12IsNoopOnNullENS0_11ARCInstKindE")
//</editor-fold>
public static boolean IsNoopOnNull(ARCInstKind Class) {
  return /*delegate*/org.llvm.analysis.objcarc.impl.ObjCARCInstKindObjcarcGlobals.
    IsNoopOnNull(Class);
}


/// \brief Test if the given class represents instructions which are always safe
/// to mark with the "tail" keyword.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::IsAlwaysTail">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCInstKind.h", line = 79,
 FQN="llvm::objcarc::IsAlwaysTail", NM="_ZN4llvm7objcarc12IsAlwaysTailENS0_11ARCInstKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc12IsAlwaysTailENS0_11ARCInstKindE")
//</editor-fold>
public static boolean IsAlwaysTail(ARCInstKind Class) {
  return /*delegate*/org.llvm.analysis.objcarc.impl.ObjCARCInstKindObjcarcGlobals.
    IsAlwaysTail(Class);
}


/// \brief Test if the given class represents instructions which are never safe
/// to mark with the "tail" keyword.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::IsNeverTail">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCInstKind.h", line = 83,
 FQN="llvm::objcarc::IsNeverTail", NM="_ZN4llvm7objcarc11IsNeverTailENS0_11ARCInstKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc11IsNeverTailENS0_11ARCInstKindE")
//</editor-fold>
public static boolean IsNeverTail(ARCInstKind Class) {
  return /*delegate*/org.llvm.analysis.objcarc.impl.ObjCARCInstKindObjcarcGlobals.
    IsNeverTail(Class);
}


/// \brief Test if the given class represents instructions which are always safe
/// to mark with the nounwind attribute.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::IsNoThrow">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCInstKind.h", line = 87,
 FQN="llvm::objcarc::IsNoThrow", NM="_ZN4llvm7objcarc9IsNoThrowENS0_11ARCInstKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc9IsNoThrowENS0_11ARCInstKindE")
//</editor-fold>
public static boolean IsNoThrow(ARCInstKind Class) {
  return /*delegate*/org.llvm.analysis.objcarc.impl.ObjCARCInstKindObjcarcGlobals.
    IsNoThrow(Class);
}


/// Test whether the given instruction can autorelease any pointer or cause an
/// autoreleasepool pop.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::CanInterruptRV">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCInstKind.h", line = 91,
 FQN="llvm::objcarc::CanInterruptRV", NM="_ZN4llvm7objcarc14CanInterruptRVENS0_11ARCInstKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc14CanInterruptRVENS0_11ARCInstKindE")
//</editor-fold>
public static boolean CanInterruptRV(ARCInstKind Class) {
  return /*delegate*/org.llvm.analysis.objcarc.impl.ObjCARCInstKindObjcarcGlobals.
    CanInterruptRV(Class);
}


/// \brief Determine if F is one of the special known Functions.  If it isn't,
/// return ARCInstKind::CallOrUser.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::GetFunctionClass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCInstKind.h", line = 95,
 FQN="llvm::objcarc::GetFunctionClass", NM="_ZN4llvm7objcarc16GetFunctionClassEPKNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc16GetFunctionClassEPKNS_8FunctionE")
//</editor-fold>
public static ARCInstKind GetFunctionClass(/*const*/ Function /*P*/ F) {
  return /*delegate*/org.llvm.analysis.objcarc.impl.ObjCARCInstKindObjcarcGlobals.
    GetFunctionClass(F);
}


/// \brief Determine which objc runtime call instruction class V belongs to.
///
/// This is similar to GetARCInstKind except that it only detects objc
/// runtime calls. This allows it to be faster.
///
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::GetBasicARCInstKind">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCInstKind.h", line = 102,
 FQN="llvm::objcarc::GetBasicARCInstKind", NM="_ZN4llvm7objcarc19GetBasicARCInstKindEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc19GetBasicARCInstKindEPKNS_5ValueE")
//</editor-fold>
public static /*inline*/ ARCInstKind GetBasicARCInstKind(/*const*/ Value /*P*/ V) {
  return /*delegate*/org.llvm.analysis.objcarc.impl.ObjCARCInstKindObjcarcGlobals.
    GetBasicARCInstKind(V);
}


/// Map V to its ARCInstKind equivalence class.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::GetARCInstKind">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCInstKind.h", line = 115,
 FQN="llvm::objcarc::GetARCInstKind", NM="_ZN4llvm7objcarc14GetARCInstKindEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc14GetARCInstKindEPKNS_5ValueE")
//</editor-fold>
public static ARCInstKind GetARCInstKind(/*const*/ Value /*P*/ V) {
  return /*delegate*/org.llvm.analysis.objcarc.impl.ObjCARCInstKindObjcarcGlobals.
    GetARCInstKind(V);
}


/// Returns false if conservatively we can prove that any instruction mapped to
/// this kind can not decrement ref counts. Returns true otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::CanDecrementRefCount">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCInstKind.h", line = 119,
 FQN="llvm::objcarc::CanDecrementRefCount", NM="_ZN4llvm7objcarc20CanDecrementRefCountENS0_11ARCInstKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc20CanDecrementRefCountENS0_11ARCInstKindE")
//</editor-fold>
public static boolean CanDecrementRefCount(ARCInstKind Kind) {
  return /*delegate*/org.llvm.analysis.objcarc.impl.ObjCARCInstKindObjcarcGlobals.
    CanDecrementRefCount(Kind);
}


/// \brief Test if the given module looks interesting to run ARC optimization
/// on.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::ModuleHasARC">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCAnalysisUtils.h", line = 51,
 FQN="llvm::objcarc::ModuleHasARC", NM="_ZN4llvm7objcarc12ModuleHasARCERKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc12ModuleHasARCERKNS_6ModuleE")
//</editor-fold>
public static /*inline*/ boolean ModuleHasARC(final /*const*/ Module /*&*/ M) {
  return /*delegate*/org.llvm.analysis.objcarc.impl.ObjCARCAnalysisUtilsObjcarcGlobals.
    ModuleHasARC(M);
}


/// \brief This is a wrapper around getUnderlyingObject which also knows how to
/// look through objc_retain and objc_autorelease calls, which we know to return
/// their argument verbatim.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::GetUnderlyingObjCPtr">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCAnalysisUtils.h", line = 77,
 FQN="llvm::objcarc::GetUnderlyingObjCPtr", NM="_ZN4llvm7objcarc20GetUnderlyingObjCPtrEPKNS_5ValueERKNS_10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc20GetUnderlyingObjCPtrEPKNS_5ValueERKNS_10DataLayoutE")
//</editor-fold>
public static /*inline*/ /*const*/ Value /*P*/ GetUnderlyingObjCPtr(/*const*/ Value /*P*/ V, 
                    final /*const*/ DataLayout /*&*/ DL) {
  return /*delegate*/org.llvm.analysis.objcarc.impl.ObjCARCAnalysisUtilsObjcarcGlobals.
    GetUnderlyingObjCPtr(V, 
                    DL);
}


/// The RCIdentity root of a value \p V is a dominating value U for which
/// retaining or releasing U is equivalent to retaining or releasing V. In other
/// words, ARC operations on \p V are equivalent to ARC operations on \p U.
///
/// We use this in the ARC optimizer to make it easier to match up ARC
/// operations by always mapping ARC operations to RCIdentityRoots instead of
/// pointers themselves.
///
/// The two ways that we see RCIdentical values in ObjC are via:
///
///   1. PointerCasts
///   2. Forwarding Calls that return their argument verbatim.
///
/// Thus this function strips off pointer casts and forwarding calls. *NOTE*
/// This implies that two RCIdentical values must alias.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::GetRCIdentityRoot">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCAnalysisUtils.h", line = 104,
 FQN="llvm::objcarc::GetRCIdentityRoot", NM="_ZN4llvm7objcarc17GetRCIdentityRootEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc17GetRCIdentityRootEPKNS_5ValueE")
//</editor-fold>
public static /*inline*/ /*const*/ Value /*P*/ GetRCIdentityRoot_Value$C$P(/*const*/ Value /*P*/ V) {
  return /*delegate*/org.llvm.analysis.objcarc.impl.ObjCARCAnalysisUtilsObjcarcGlobals.
    GetRCIdentityRoot_Value$C$P(V);
}


/// Helper which calls const Value *GetRCIdentityRoot(const Value *V) and just
/// casts away the const of the result. For documentation about what an
/// RCIdentityRoot (and by extension GetRCIdentityRoot is) look at that
/// function.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::GetRCIdentityRoot">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCAnalysisUtils.h", line = 118,
 FQN="llvm::objcarc::GetRCIdentityRoot", NM="_ZN4llvm7objcarc17GetRCIdentityRootEPNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc17GetRCIdentityRootEPNS_5ValueE")
//</editor-fold>
public static /*inline*/ Value /*P*/ GetRCIdentityRoot_Value$P(Value /*P*/ V) {
  return /*delegate*/org.llvm.analysis.objcarc.impl.ObjCARCAnalysisUtilsObjcarcGlobals.
    GetRCIdentityRoot_Value$P(V);
}


/// \brief Assuming the given instruction is one of the special calls such as
/// objc_retain or objc_release, return the RCIdentity root of the argument of
/// the call.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::GetArgRCIdentityRoot">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCAnalysisUtils.h", line = 125,
 FQN="llvm::objcarc::GetArgRCIdentityRoot", NM="_ZN4llvm7objcarc20GetArgRCIdentityRootEPNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc20GetArgRCIdentityRootEPNS_5ValueE")
//</editor-fold>
public static /*inline*/ Value /*P*/ GetArgRCIdentityRoot(Value /*P*/ Inst) {
  return /*delegate*/org.llvm.analysis.objcarc.impl.ObjCARCAnalysisUtilsObjcarcGlobals.
    GetArgRCIdentityRoot(Inst);
}

//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::IsNullOrUndef">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCAnalysisUtils.h", line = 129,
 FQN="llvm::objcarc::IsNullOrUndef", NM="_ZN4llvm7objcarc13IsNullOrUndefEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc13IsNullOrUndefEPKNS_5ValueE")
//</editor-fold>
public static /*inline*/ boolean IsNullOrUndef(/*const*/ Value /*P*/ V) {
  return /*delegate*/org.llvm.analysis.objcarc.impl.ObjCARCAnalysisUtilsObjcarcGlobals.
    IsNullOrUndef(V);
}

//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::IsNoopInstruction">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCAnalysisUtils.h", line = 133,
 FQN="llvm::objcarc::IsNoopInstruction", NM="_ZN4llvm7objcarc17IsNoopInstructionEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc17IsNoopInstructionEPKNS_11InstructionE")
//</editor-fold>
public static /*inline*/ boolean IsNoopInstruction(/*const*/ Instruction /*P*/ I) {
  return /*delegate*/org.llvm.analysis.objcarc.impl.ObjCARCAnalysisUtilsObjcarcGlobals.
    IsNoopInstruction(I);
}


/// \brief Test whether the given value is possible a retainable object pointer.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::IsPotentialRetainableObjPtr">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCAnalysisUtils.h", line = 140,
 FQN="llvm::objcarc::IsPotentialRetainableObjPtr", NM="_ZN4llvm7objcarc27IsPotentialRetainableObjPtrEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc27IsPotentialRetainableObjPtrEPKNS_5ValueE")
//</editor-fold>
public static /*inline*/ boolean IsPotentialRetainableObjPtr(/*const*/ Value /*P*/ Op) {
  return /*delegate*/org.llvm.analysis.objcarc.impl.ObjCARCAnalysisUtilsObjcarcGlobals.
    IsPotentialRetainableObjPtr(Op);
}

//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::IsPotentialRetainableObjPtr">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCAnalysisUtils.h", line = 165,
 FQN="llvm::objcarc::IsPotentialRetainableObjPtr", NM="_ZN4llvm7objcarc27IsPotentialRetainableObjPtrEPKNS_5ValueERNS_9AAResultsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc27IsPotentialRetainableObjPtrEPKNS_5ValueERNS_9AAResultsE")
//</editor-fold>
public static /*inline*/ boolean IsPotentialRetainableObjPtr(/*const*/ Value /*P*/ Op, 
                           final AAResults /*&*/ AA) {
  return /*delegate*/org.llvm.analysis.objcarc.impl.ObjCARCAnalysisUtilsObjcarcGlobals.
    IsPotentialRetainableObjPtr(Op, 
                           AA);
}


/// \brief Helper for GetARCInstKind. Determines what kind of construct CS
/// is.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::GetCallSiteClass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCAnalysisUtils.h", line = 186,
 FQN="llvm::objcarc::GetCallSiteClass", NM="_ZN4llvm7objcarc16GetCallSiteClassENS_17ImmutableCallSiteE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc16GetCallSiteClassENS_17ImmutableCallSiteE")
//</editor-fold>
public static /*inline*/ ARCInstKind GetCallSiteClass(ImmutableCallSite CS) {
  return /*delegate*/org.llvm.analysis.objcarc.impl.ObjCARCAnalysisUtilsObjcarcGlobals.
    GetCallSiteClass(CS);
}


/// \brief Return true if this value refers to a distinct and identifiable
/// object.
///
/// This is similar to AliasAnalysis's isIdentifiedObject, except that it uses
/// special knowledge of ObjC conventions.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::IsObjCIdentifiedObject">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCAnalysisUtils.h", line = 200,
 FQN="llvm::objcarc::IsObjCIdentifiedObject", NM="_ZN4llvm7objcarc22IsObjCIdentifiedObjectEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc22IsObjCIdentifiedObjectEPKNS_5ValueE")
//</editor-fold>
public static /*inline*/ boolean IsObjCIdentifiedObject(/*const*/ Value /*P*/ V) {
  return /*delegate*/org.llvm.analysis.objcarc.impl.ObjCARCAnalysisUtilsObjcarcGlobals.
    IsObjCIdentifiedObject(V);
}


/// \brief A handy option to enable/disable all ARC Optimizations.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::EnableARCOpts">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp", line = 23,
 FQN="llvm::objcarc::EnableARCOpts", NM="_ZN4llvm7objcarc13EnableARCOptsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc13EnableARCOptsE")
//</editor-fold>
public static boolean EnableARCOpts;
} // END OF class ObjcarcGlobals
