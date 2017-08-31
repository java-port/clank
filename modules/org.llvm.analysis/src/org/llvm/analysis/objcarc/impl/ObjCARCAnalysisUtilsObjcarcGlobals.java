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


//<editor-fold defaultstate="collapsed" desc="static type ObjCARCAnalysisUtilsObjcarcGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.objcarc.impl.ObjCARCAnalysisUtilsObjcarcGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc12ModuleHasARCERKNS_6ModuleE;_ZN4llvm7objcarc13IsNullOrUndefEPKNS_5ValueE;_ZN4llvm7objcarc16GetCallSiteClassENS_17ImmutableCallSiteE;_ZN4llvm7objcarc17GetRCIdentityRootEPKNS_5ValueE;_ZN4llvm7objcarc17GetRCIdentityRootEPNS_5ValueE;_ZN4llvm7objcarc17IsNoopInstructionEPKNS_11InstructionE;_ZN4llvm7objcarc20GetArgRCIdentityRootEPNS_5ValueE;_ZN4llvm7objcarc20GetUnderlyingObjCPtrEPKNS_5ValueERKNS_10DataLayoutE;_ZN4llvm7objcarc22IsObjCIdentifiedObjectEPKNS_5ValueE;_ZN4llvm7objcarc27IsPotentialRetainableObjPtrEPKNS_5ValueE;_ZN4llvm7objcarc27IsPotentialRetainableObjPtrEPKNS_5ValueERNS_9AAResultsE; -static-type=ObjCARCAnalysisUtilsObjcarcGlobals -package=org.llvm.analysis.objcarc.impl")
//</editor-fold>
public final class ObjCARCAnalysisUtilsObjcarcGlobals {


/// \brief Test if the given module looks interesting to run ARC optimization
/// on.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::ModuleHasARC">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCAnalysisUtils.h", line = 51,
 FQN="llvm::objcarc::ModuleHasARC", NM="_ZN4llvm7objcarc12ModuleHasARCERKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc12ModuleHasARCERKNS_6ModuleE")
//</editor-fold>
public static /*inline*/ boolean ModuleHasARC(final /*const*/ Module /*&*/ M) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief This is a wrapper around getUnderlyingObject which also knows how to
/// look through objc_retain and objc_autorelease calls, which we know to return
/// their argument verbatim.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::GetUnderlyingObjCPtr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCAnalysisUtils.h", line = 77,
 FQN="llvm::objcarc::GetUnderlyingObjCPtr", NM="_ZN4llvm7objcarc20GetUnderlyingObjCPtrEPKNS_5ValueERKNS_10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc20GetUnderlyingObjCPtrEPKNS_5ValueERKNS_10DataLayoutE")
//</editor-fold>
public static /*inline*/ /*const*/ Value /*P*/ GetUnderlyingObjCPtr(/*const*/ Value /*P*/ V, 
                    final /*const*/ DataLayout /*&*/ DL) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCAnalysisUtils.h", line = 104,
 FQN="llvm::objcarc::GetRCIdentityRoot", NM="_ZN4llvm7objcarc17GetRCIdentityRootEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc17GetRCIdentityRootEPKNS_5ValueE")
//</editor-fold>
public static /*inline*/ /*const*/ Value /*P*/ GetRCIdentityRoot_Value$C$P(/*const*/ Value /*P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Helper which calls const Value *GetRCIdentityRoot(const Value *V) and just
/// casts away the const of the result. For documentation about what an
/// RCIdentityRoot (and by extension GetRCIdentityRoot is) look at that
/// function.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::GetRCIdentityRoot">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCAnalysisUtils.h", line = 118,
 FQN="llvm::objcarc::GetRCIdentityRoot", NM="_ZN4llvm7objcarc17GetRCIdentityRootEPNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc17GetRCIdentityRootEPNS_5ValueE")
//</editor-fold>
public static /*inline*/ Value /*P*/ GetRCIdentityRoot_Value$P(Value /*P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Assuming the given instruction is one of the special calls such as
/// objc_retain or objc_release, return the RCIdentity root of the argument of
/// the call.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::GetArgRCIdentityRoot">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCAnalysisUtils.h", line = 125,
 FQN="llvm::objcarc::GetArgRCIdentityRoot", NM="_ZN4llvm7objcarc20GetArgRCIdentityRootEPNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc20GetArgRCIdentityRootEPNS_5ValueE")
//</editor-fold>
public static /*inline*/ Value /*P*/ GetArgRCIdentityRoot(Value /*P*/ Inst) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::IsNullOrUndef">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCAnalysisUtils.h", line = 129,
 FQN="llvm::objcarc::IsNullOrUndef", NM="_ZN4llvm7objcarc13IsNullOrUndefEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc13IsNullOrUndefEPKNS_5ValueE")
//</editor-fold>
public static /*inline*/ boolean IsNullOrUndef(/*const*/ Value /*P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::IsNoopInstruction">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCAnalysisUtils.h", line = 133,
 FQN="llvm::objcarc::IsNoopInstruction", NM="_ZN4llvm7objcarc17IsNoopInstructionEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc17IsNoopInstructionEPKNS_11InstructionE")
//</editor-fold>
public static /*inline*/ boolean IsNoopInstruction(/*const*/ Instruction /*P*/ I) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Test whether the given value is possible a retainable object pointer.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::IsPotentialRetainableObjPtr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCAnalysisUtils.h", line = 140,
 FQN="llvm::objcarc::IsPotentialRetainableObjPtr", NM="_ZN4llvm7objcarc27IsPotentialRetainableObjPtrEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc27IsPotentialRetainableObjPtrEPKNS_5ValueE")
//</editor-fold>
public static /*inline*/ boolean IsPotentialRetainableObjPtr(/*const*/ Value /*P*/ Op) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::IsPotentialRetainableObjPtr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCAnalysisUtils.h", line = 165,
 FQN="llvm::objcarc::IsPotentialRetainableObjPtr", NM="_ZN4llvm7objcarc27IsPotentialRetainableObjPtrEPKNS_5ValueERNS_9AAResultsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc27IsPotentialRetainableObjPtrEPKNS_5ValueERNS_9AAResultsE")
//</editor-fold>
public static /*inline*/ boolean IsPotentialRetainableObjPtr(/*const*/ Value /*P*/ Op, 
                           final AAResults /*&*/ AA) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Helper for GetARCInstKind. Determines what kind of construct CS
/// is.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::GetCallSiteClass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCAnalysisUtils.h", line = 186,
 FQN="llvm::objcarc::GetCallSiteClass", NM="_ZN4llvm7objcarc16GetCallSiteClassENS_17ImmutableCallSiteE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc16GetCallSiteClassENS_17ImmutableCallSiteE")
//</editor-fold>
public static /*inline*/ ARCInstKind GetCallSiteClass(ImmutableCallSite CS) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Return true if this value refers to a distinct and identifiable
/// object.
///
/// This is similar to AliasAnalysis's isIdentifiedObject, except that it uses
/// special knowledge of ObjC conventions.
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::IsObjCIdentifiedObject">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCAnalysisUtils.h", line = 200,
 FQN="llvm::objcarc::IsObjCIdentifiedObject", NM="_ZN4llvm7objcarc22IsObjCIdentifiedObjectEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAnalysisUtils.cpp -nm=_ZN4llvm7objcarc22IsObjCIdentifiedObjectEPKNS_5ValueE")
//</editor-fold>
public static /*inline*/ boolean IsObjCIdentifiedObject(/*const*/ Value /*P*/ V) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class ObjCARCAnalysisUtilsObjcarcGlobals
