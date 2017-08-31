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
package org.llvm.analysis.cflaa.impl;

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


//<editor-fold defaultstate="collapsed" desc="static type CflaaStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.cflaa.impl.CflaaStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaa11getAttrNoneEv;_ZN4llvm5cflaa12_GLOBAL__N_1L10AttrCallerE;_ZN4llvm5cflaa12_GLOBAL__N_1L10AttrGlobalE;_ZN4llvm5cflaa12_GLOBAL__N_1L11AttrEscapedE;_ZN4llvm5cflaa12_GLOBAL__N_1L11AttrUnknownE;_ZN4llvm5cflaa12_GLOBAL__N_1L14AttrMaxNumArgsE;_ZN4llvm5cflaa12_GLOBAL__N_1L15AttrCallerIndexE;_ZN4llvm5cflaa12_GLOBAL__N_1L15AttrGlobalIndexE;_ZN4llvm5cflaa12_GLOBAL__N_1L16AttrEscapedIndexE;_ZN4llvm5cflaa12_GLOBAL__N_1L16AttrLastArgIndexE;_ZN4llvm5cflaa12_GLOBAL__N_1L16AttrUnknownIndexE;_ZN4llvm5cflaa12_GLOBAL__N_1L16ExternalAttrMaskE;_ZN4llvm5cflaa12_GLOBAL__N_1L17AttrFirstArgIndexE;_ZN4llvm5cflaa12_GLOBAL__N_1L8AttrNoneE;_ZN4llvm5cflaa13getAttrCallerEv;_ZN4llvm5cflaa13hasCallerAttrESt6bitsetILj32EE;_ZN4llvm5cflaa14getAttrEscapedEv;_ZN4llvm5cflaa14getAttrUnknownEv;_ZN4llvm5cflaa14hasEscapedAttrESt6bitsetILj32EE;_ZN4llvm5cflaa14hasUnknownAttrESt6bitsetILj32EE;_ZN4llvm5cflaa17isGlobalOrArgAttrESt6bitsetILj32EE;_ZN4llvm5cflaa22hasUnknownOrCallerAttrESt6bitsetILj32EE;_ZN4llvm5cflaa25getExternallyVisibleAttrsESt6bitsetILj32EE;_ZN4llvm5cflaa25instantiateInterfaceValueENS0_14InterfaceValueENS_8CallSiteE;_ZN4llvm5cflaa27getGlobalOrArgAttrFromValueERKNS_5ValueE;_ZN4llvm5cflaa27instantiateExternalRelationENS0_16ExternalRelationENS_8CallSiteE;_ZN4llvm5cflaa28instantiateExternalAttributeENS0_17ExternalAttributeENS_8CallSiteE;_ZN4llvm5cflaaL13NumAliasAttrsE;_ZN4llvm5cflaaL15argNumberToAttrEj;_ZN4llvm5cflaaL25MaxSupportedArgsInSummaryE;_ZN4llvm5cflaaeqENS0_14InterfaceValueES1_;_ZN4llvm5cflaaeqENS0_17InstantiatedValueES1_;_ZN4llvm5cflaageENS0_17InstantiatedValueES1_;_ZN4llvm5cflaagtENS0_17InstantiatedValueES1_;_ZN4llvm5cflaaleENS0_17InstantiatedValueES1_;_ZN4llvm5cflaaltENS0_17InstantiatedValueES1_;_ZN4llvm5cflaaneENS0_14InterfaceValueES1_;_ZN4llvm5cflaaneENS0_17InstantiatedValueES1_; -static-type=CflaaStatics -package=org.llvm.analysis.cflaa.impl")
//</editor-fold>
public final class CflaaStatics {


//===----------------------------------------------------------------------===//
// AliasAttr related stuffs
//===----------------------------------------------------------------------===//

/// The number of attributes that AliasAttr should contain. Attributes are
/// described below, and 32 was an arbitrary choice because it fits nicely in 32
/// bits (because we use a bitset for AliasAttr).
//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::NumAliasAttrs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.h", line = 54,
 FQN="llvm::cflaa::NumAliasAttrs", NM="_ZN4llvm5cflaaL13NumAliasAttrsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaaL13NumAliasAttrsE")
//</editor-fold>
public static /*const*//*uint*/int NumAliasAttrs = 32;

/// Attr represent whether the said pointer comes from an unknown source
/// (such as opaque memory or an integer cast).
//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::getAttrNone">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp", line = 31,
 FQN="llvm::cflaa::getAttrNone", NM="_ZN4llvm5cflaa11getAttrNoneEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaa11getAttrNoneEv")
//</editor-fold>
public static std.bitset/*NumAliasAttrs*/ getAttrNone() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// AttrUnknown represent whether the said pointer comes from a source not known
/// to alias analyses (such as opaque memory or an integer cast).
//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::getAttrUnknown">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp", line = 33,
 FQN="llvm::cflaa::getAttrUnknown", NM="_ZN4llvm5cflaa14getAttrUnknownEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaa14getAttrUnknownEv")
//</editor-fold>
public static std.bitset/*NumAliasAttrs*/ getAttrUnknown() {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::hasUnknownAttr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp", line = 34,
 FQN="llvm::cflaa::hasUnknownAttr", NM="_ZN4llvm5cflaa14hasUnknownAttrESt6bitsetILj32EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaa14hasUnknownAttrESt6bitsetILj32EE")
//</editor-fold>
public static boolean hasUnknownAttr(std.bitset/*NumAliasAttrs*/ Attr) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// AttrCaller represent whether the said pointer comes from a source not known
/// to the current function but known to the caller. Values pointed to by the
/// arguments of the current function have this attribute set
//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::getAttrCaller">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp", line = 36,
 FQN="llvm::cflaa::getAttrCaller", NM="_ZN4llvm5cflaa13getAttrCallerEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaa13getAttrCallerEv")
//</editor-fold>
public static std.bitset/*NumAliasAttrs*/ getAttrCaller() {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::hasCallerAttr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp", line = 37,
 FQN="llvm::cflaa::hasCallerAttr", NM="_ZN4llvm5cflaa13hasCallerAttrESt6bitsetILj32EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaa13hasCallerAttrESt6bitsetILj32EE")
//</editor-fold>
public static boolean hasCallerAttr(std.bitset/*NumAliasAttrs*/ Attr) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::hasUnknownOrCallerAttr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp", line = 38,
 FQN="llvm::cflaa::hasUnknownOrCallerAttr", NM="_ZN4llvm5cflaa22hasUnknownOrCallerAttrESt6bitsetILj32EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaa22hasUnknownOrCallerAttrESt6bitsetILj32EE")
//</editor-fold>
public static boolean hasUnknownOrCallerAttr(std.bitset/*NumAliasAttrs*/ Attr) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// AttrEscaped represent whether the said pointer comes from a known source but
/// escapes to the unknown world (e.g. casted to an integer, or passed as an
/// argument to opaque function). Unlike non-escaped pointers, escaped ones may
/// alias pointers coming from unknown sources.
//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::getAttrEscaped">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp", line = 42,
 FQN="llvm::cflaa::getAttrEscaped", NM="_ZN4llvm5cflaa14getAttrEscapedEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaa14getAttrEscapedEv")
//</editor-fold>
public static std.bitset/*NumAliasAttrs*/ getAttrEscaped() {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::hasEscapedAttr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp", line = 43,
 FQN="llvm::cflaa::hasEscapedAttr", NM="_ZN4llvm5cflaa14hasEscapedAttrESt6bitsetILj32EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaa14hasEscapedAttrESt6bitsetILj32EE")
//</editor-fold>
public static boolean hasEscapedAttr(std.bitset/*NumAliasAttrs*/ Attr) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// AttrGlobal represent whether the said pointer is a global value.
/// AttrArg represent whether the said pointer is an argument, and if so, what
/// index the argument has.
//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::getGlobalOrArgAttrFromValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp", line = 53,
 FQN="llvm::cflaa::getGlobalOrArgAttrFromValue", NM="_ZN4llvm5cflaa27getGlobalOrArgAttrFromValueERKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaa27getGlobalOrArgAttrFromValueERKNS_5ValueE")
//</editor-fold>
public static std.bitset/*NumAliasAttrs*/ getGlobalOrArgAttrFromValue(final /*const*/ Value /*&*/ Val) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::isGlobalOrArgAttr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp", line = 66,
 FQN="llvm::cflaa::isGlobalOrArgAttr", NM="_ZN4llvm5cflaa17isGlobalOrArgAttrESt6bitsetILj32EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaa17isGlobalOrArgAttrESt6bitsetILj32EE")
//</editor-fold>
public static boolean isGlobalOrArgAttr(std.bitset/*NumAliasAttrs*/ Attr) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given an AliasAttrs, return a new AliasAttrs that only contains attributes
/// meaningful to the caller. This function is primarily used for
/// interprocedural analysis
/// Currently, externally visible AliasAttrs include AttrUnknown, AttrGlobal,
/// and AttrEscaped
//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::getExternallyVisibleAttrs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp", line = 73,
 FQN="llvm::cflaa::getExternallyVisibleAttrs", NM="_ZN4llvm5cflaa25getExternallyVisibleAttrsESt6bitsetILj32EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaa25getExternallyVisibleAttrsESt6bitsetILj32EE")
//</editor-fold>
public static std.bitset/*NumAliasAttrs*/ getExternallyVisibleAttrs(std.bitset/*NumAliasAttrs*/ Attr) {
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
// Function summary related stuffs
//===----------------------------------------------------------------------===//

/// The maximum number of arguments we can put into a summary.
//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::MaxSupportedArgsInSummary">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.h", line = 102,
 FQN="llvm::cflaa::MaxSupportedArgsInSummary", NM="_ZN4llvm5cflaaL25MaxSupportedArgsInSummaryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaaL25MaxSupportedArgsInSummaryE")
//</editor-fold>
public static /*const*//*uint*/int MaxSupportedArgsInSummary = 50;
//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::operator==">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.h", line = 117,
 FQN="llvm::cflaa::operator==", NM="_ZN4llvm5cflaaeqENS0_14InterfaceValueES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaaeqENS0_14InterfaceValueES1_")
//</editor-fold>
public static /*inline*/ boolean $eq_InterfaceValue(InterfaceValue LHS, InterfaceValue RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::operator!=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.h", line = 120,
 FQN="llvm::cflaa::operator!=", NM="_ZN4llvm5cflaaneENS0_14InterfaceValueES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaaneENS0_14InterfaceValueES1_")
//</editor-fold>
public static /*inline*/ boolean $noteq_InterfaceValue(InterfaceValue LHS, InterfaceValue RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::instantiateInterfaceValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp", line = 77,
 FQN="llvm::cflaa::instantiateInterfaceValue", NM="_ZN4llvm5cflaa25instantiateInterfaceValueENS0_14InterfaceValueENS_8CallSiteE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaa25instantiateInterfaceValueENS0_14InterfaceValueENS_8CallSiteE")
//</editor-fold>
public static Optional<InstantiatedValue> instantiateInterfaceValue(InterfaceValue IValue, 
                         CallSite CS) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::operator==">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.h", line = 153,
 FQN="llvm::cflaa::operator==", NM="_ZN4llvm5cflaaeqENS0_17InstantiatedValueES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaaeqENS0_17InstantiatedValueES1_")
//</editor-fold>
public static /*inline*/ boolean $eq_InstantiatedValue(InstantiatedValue LHS, InstantiatedValue RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::operator!=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.h", line = 156,
 FQN="llvm::cflaa::operator!=", NM="_ZN4llvm5cflaaneENS0_17InstantiatedValueES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaaneENS0_17InstantiatedValueES1_")
//</editor-fold>
public static /*inline*/ boolean $noteq_InstantiatedValue(InstantiatedValue LHS, InstantiatedValue RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::operator<">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.h", line = 159,
 FQN="llvm::cflaa::operator<", NM="_ZN4llvm5cflaaltENS0_17InstantiatedValueES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaaltENS0_17InstantiatedValueES1_")
//</editor-fold>
public static /*inline*/ boolean $less_InstantiatedValue(InstantiatedValue LHS, InstantiatedValue RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::operator>">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.h", line = 163,
 FQN="llvm::cflaa::operator>", NM="_ZN4llvm5cflaagtENS0_17InstantiatedValueES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaagtENS0_17InstantiatedValueES1_")
//</editor-fold>
public static /*inline*/ boolean $greater_InstantiatedValue(InstantiatedValue LHS, InstantiatedValue RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::operator<=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.h", line = 166,
 FQN="llvm::cflaa::operator<=", NM="_ZN4llvm5cflaaleENS0_17InstantiatedValueES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaaleENS0_17InstantiatedValueES1_")
//</editor-fold>
public static /*inline*/ boolean $lesseq_InstantiatedValue(InstantiatedValue LHS, InstantiatedValue RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::operator>=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.h", line = 169,
 FQN="llvm::cflaa::operator>=", NM="_ZN4llvm5cflaageENS0_17InstantiatedValueES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaageENS0_17InstantiatedValueES1_")
//</editor-fold>
public static /*inline*/ boolean $greatereq_InstantiatedValue(InstantiatedValue LHS, InstantiatedValue RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::instantiateExternalRelation">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp", line = 86,
 FQN="llvm::cflaa::instantiateExternalRelation", NM="_ZN4llvm5cflaa27instantiateExternalRelationENS0_16ExternalRelationENS_8CallSiteE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaa27instantiateExternalRelationENS0_16ExternalRelationENS_8CallSiteE")
//</editor-fold>
public static Optional<InstantiatedRelation> instantiateExternalRelation(ExternalRelation ERelation, CallSite CS) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::instantiateExternalAttribute">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp", line = 97,
 FQN="llvm::cflaa::instantiateExternalAttribute", NM="_ZN4llvm5cflaa28instantiateExternalAttributeENS0_17ExternalAttributeENS_8CallSiteE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaa28instantiateExternalAttributeENS0_17ExternalAttributeENS_8CallSiteE")
//</editor-fold>
public static Optional<InstantiatedAttr> instantiateExternalAttribute(ExternalAttribute EAttr, 
                            CallSite CS) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::(anonymous namespace)::AttrEscapedIndex">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp", line = 10,
 FQN="llvm::cflaa::(anonymous namespace)::AttrEscapedIndex", NM="_ZN4llvm5cflaa12_GLOBAL__N_1L16AttrEscapedIndexE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaa12_GLOBAL__N_1L16AttrEscapedIndexE")
//</editor-fold>
public static /*const*//*uint*/int AttrEscapedIndex = 0;
//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::(anonymous namespace)::AttrUnknownIndex">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp", line = 11,
 FQN="llvm::cflaa::(anonymous namespace)::AttrUnknownIndex", NM="_ZN4llvm5cflaa12_GLOBAL__N_1L16AttrUnknownIndexE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaa12_GLOBAL__N_1L16AttrUnknownIndexE")
//</editor-fold>
public static /*const*//*uint*/int AttrUnknownIndex = 1;
//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::(anonymous namespace)::AttrGlobalIndex">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp", line = 12,
 FQN="llvm::cflaa::(anonymous namespace)::AttrGlobalIndex", NM="_ZN4llvm5cflaa12_GLOBAL__N_1L15AttrGlobalIndexE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaa12_GLOBAL__N_1L15AttrGlobalIndexE")
//</editor-fold>
public static /*const*//*uint*/int AttrGlobalIndex = 2;
//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::(anonymous namespace)::AttrCallerIndex">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp", line = 13,
 FQN="llvm::cflaa::(anonymous namespace)::AttrCallerIndex", NM="_ZN4llvm5cflaa12_GLOBAL__N_1L15AttrCallerIndexE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaa12_GLOBAL__N_1L15AttrCallerIndexE")
//</editor-fold>
public static /*const*//*uint*/int AttrCallerIndex = 3;
//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::(anonymous namespace)::AttrFirstArgIndex">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp", line = 14,
 FQN="llvm::cflaa::(anonymous namespace)::AttrFirstArgIndex", NM="_ZN4llvm5cflaa12_GLOBAL__N_1L17AttrFirstArgIndexE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaa12_GLOBAL__N_1L17AttrFirstArgIndexE")
//</editor-fold>
public static /*const*//*uint*/int AttrFirstArgIndex = 4;
//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::(anonymous namespace)::AttrLastArgIndex">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp", line = 15,
 FQN="llvm::cflaa::(anonymous namespace)::AttrLastArgIndex", NM="_ZN4llvm5cflaa12_GLOBAL__N_1L16AttrLastArgIndexE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaa12_GLOBAL__N_1L16AttrLastArgIndexE")
//</editor-fold>
public static /*const*//*uint*/int AttrLastArgIndex = NumAliasAttrs;
//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::(anonymous namespace)::AttrMaxNumArgs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp", line = 16,
 FQN="llvm::cflaa::(anonymous namespace)::AttrMaxNumArgs", NM="_ZN4llvm5cflaa12_GLOBAL__N_1L14AttrMaxNumArgsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaa12_GLOBAL__N_1L14AttrMaxNumArgsE")
//</editor-fold>
public static /*const*//*uint*/int AttrMaxNumArgs = AttrLastArgIndex - AttrFirstArgIndex;
//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::(anonymous namespace)::AttrNone">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp", line = 22,
 FQN="llvm::cflaa::(anonymous namespace)::AttrNone", NM="_ZN4llvm5cflaa12_GLOBAL__N_1L8AttrNoneE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaa12_GLOBAL__N_1L8AttrNoneE")
//</editor-fold>
public static /*const*//*uint*/int AttrNone = 0;
//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::(anonymous namespace)::AttrEscaped">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp", line = 23,
 FQN="llvm::cflaa::(anonymous namespace)::AttrEscaped", NM="_ZN4llvm5cflaa12_GLOBAL__N_1L11AttrEscapedE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaa12_GLOBAL__N_1L11AttrEscapedE")
//</editor-fold>
public static /*const*//*uint*/int AttrEscaped = 1 << AttrEscapedIndex;
//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::(anonymous namespace)::AttrUnknown">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp", line = 24,
 FQN="llvm::cflaa::(anonymous namespace)::AttrUnknown", NM="_ZN4llvm5cflaa12_GLOBAL__N_1L11AttrUnknownE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaa12_GLOBAL__N_1L11AttrUnknownE")
//</editor-fold>
public static /*const*//*uint*/int AttrUnknown = 1 << AttrUnknownIndex;
//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::(anonymous namespace)::AttrGlobal">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp", line = 25,
 FQN="llvm::cflaa::(anonymous namespace)::AttrGlobal", NM="_ZN4llvm5cflaa12_GLOBAL__N_1L10AttrGlobalE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaa12_GLOBAL__N_1L10AttrGlobalE")
//</editor-fold>
public static /*const*//*uint*/int AttrGlobal = 1 << AttrGlobalIndex;
//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::(anonymous namespace)::AttrCaller">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp", line = 26,
 FQN="llvm::cflaa::(anonymous namespace)::AttrCaller", NM="_ZN4llvm5cflaa12_GLOBAL__N_1L10AttrCallerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaa12_GLOBAL__N_1L10AttrCallerE")
//</editor-fold>
public static /*const*//*uint*/int AttrCaller = 1 << AttrCallerIndex;
//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::(anonymous namespace)::ExternalAttrMask">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp", line = 27,
 FQN="llvm::cflaa::(anonymous namespace)::ExternalAttrMask", NM="_ZN4llvm5cflaa12_GLOBAL__N_1L16ExternalAttrMaskE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaa12_GLOBAL__N_1L16ExternalAttrMaskE")
//</editor-fold>
public static /*const*//*uint*/int ExternalAttrMask = AttrEscaped | AttrUnknown | AttrGlobal;
//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::argNumberToAttr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp", line = 45,
 FQN="llvm::cflaa::argNumberToAttr", NM="_ZN4llvm5cflaaL15argNumberToAttrEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisSummary.cpp -nm=_ZN4llvm5cflaaL15argNumberToAttrEj")
//</editor-fold>
public static /*uint*/int argNumberToAttr(/*uint*/int ArgNum) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class CflaaStatics
