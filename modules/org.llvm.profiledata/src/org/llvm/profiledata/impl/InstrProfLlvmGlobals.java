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
package org.llvm.profiledata.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.profiledata.*;
import org.llvm.support.llvm.support.endianness;
import org.llvm.support.Error;


//<editor-fold defaultstate="collapsed" desc="static type InstrProfLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm14getPGOFuncNameENS_9StringRefENS_11GlobalValue12LinkageTypesES0_y;_ZN4llvm14getPGOFuncNameERKNS_8FunctionEby;_ZN4llvm15make_error_codeENS_15instrprof_errorE;_ZN4llvm17annotateValueSiteERNS_6ModuleERNS_11InstructionENS_8ArrayRefI18InstrProfValueDataEEyNS_18InstrProfValueKindEj;_ZN4llvm17annotateValueSiteERNS_6ModuleERNS_11InstructionERKNS_15InstrProfRecordENS_18InstrProfValueKindEjj;_ZN4llvm17getHostEndiannessEv;_ZN4llvm18instrprof_categoryEv;_ZN4llvm20createPGOFuncNameVarERNS_6ModuleENS_11GlobalValue12LinkageTypesENS_9StringRefE;_ZN4llvm20createPGOFuncNameVarERNS_8FunctionENS_9StringRefE;_ZN4llvm21getPGOFuncNameVarNameENS_9StringRefENS_11GlobalValue12LinkageTypesE;_ZN4llvm22getPGOFuncNameMetadataERKNS_8FunctionE;_ZN4llvm22readPGOFuncNameStringsENS_9StringRefERNS_15InstrProfSymtabE;_ZN4llvm23getInstrProfRegFuncNameEv;_ZN4llvm24getFuncNameWithoutPrefixENS_9StringRefES0_;_ZN4llvm24getInstrProfComdatPrefixEv;_ZN4llvm24getInstrProfInitFuncNameEv;_ZN4llvm24getInstrProfNamesVarNameEv;_ZN4llvm24getInstrProfRegFuncsNameEv;_ZN4llvm24getValueProfDataFromInstERKNS_11InstructionENS_18InstrProfValueKindEjP18InstrProfValueDataRjRy;_ZN4llvm25collectPGOFuncNameStringsERKSt6vectorIPNS_14GlobalVariableESaIS2_EERSsb;_ZN4llvm25collectPGOFuncNameStringsERKSt6vectorISsSaISsEEbRSs;_ZN4llvm25createPGOFuncNameMetadataERNS_8FunctionENS_9StringRefE;_ZN4llvm25getCoverageMappingVarNameEv;_ZN4llvm25getInstrProfDataVarPrefixEv;_ZN4llvm25getInstrProfNameSeparatorEv;_ZN4llvm25getInstrProfNameVarPrefixEv;_ZN4llvm25getInstrProfVNodesVarNameEv;_ZN4llvm26getPGOFuncNameMetadataNameEv;_ZN4llvm27getInstrProfDataSectionNameEb;_ZN4llvm27getInstrProfNameSectionNameEb;_ZN4llvm27getInstrProfValuesVarPrefixEv;_ZN4llvm28getInstrProfNamesRegFuncNameEv;_ZN4llvm28getPGOFuncNameVarInitializerEPNS_14GlobalVariableE;_ZN4llvm29getCoverageUnusedNamesVarNameEv;_ZN4llvm29getInstrProfCountersVarPrefixEv;_ZN4llvm29getInstrProfVNodesSectionNameEb;_ZN4llvm29getInstrProfValueProfFuncNameEv;_ZN4llvm29getInstrProfValuesSectionNameEb;_ZN4llvm30getInstrProfRuntimeHookVarNameEv;_ZN4llvm31getInstrProfCountersSectionNameEb;_ZN4llvm31getInstrProfCoverageSectionNameEb;_ZN4llvm33getInstrProfFileOverriderFuncNameEv;_ZN4llvm37getInstrProfRuntimeHookVarUseFuncNameEv; -static-type=InstrProfLlvmGlobals -package=org.llvm.profiledata.impl")
//</editor-fold>
public final class InstrProfLlvmGlobals {


/// Return the name of data section containing profile counter variables.
//<editor-fold defaultstate="collapsed" desc="llvm::getInstrProfCountersSectionName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 42,
 FQN="llvm::getInstrProfCountersSectionName", NM="_ZN4llvm31getInstrProfCountersSectionNameEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm31getInstrProfCountersSectionNameEb")
//</editor-fold>
public static /*inline*/ StringRef getInstrProfCountersSectionName(boolean AddSegment) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the name of data section containing names of instrumented
/// functions.
//<editor-fold defaultstate="collapsed" desc="llvm::getInstrProfNameSectionName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 49,
 FQN="llvm::getInstrProfNameSectionName", NM="_ZN4llvm27getInstrProfNameSectionNameEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm27getInstrProfNameSectionNameEb")
//</editor-fold>
public static /*inline*/ StringRef getInstrProfNameSectionName(boolean AddSegment) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the name of the data section containing per-function control
/// data.
//<editor-fold defaultstate="collapsed" desc="llvm::getInstrProfDataSectionName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 56,
 FQN="llvm::getInstrProfDataSectionName", NM="_ZN4llvm27getInstrProfDataSectionNameEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm27getInstrProfDataSectionNameEb")
//</editor-fold>
public static /*inline*/ StringRef getInstrProfDataSectionName(boolean AddSegment) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the name of data section containing pointers to value profile
/// counters/nodes.
//<editor-fold defaultstate="collapsed" desc="llvm::getInstrProfValuesSectionName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 63,
 FQN="llvm::getInstrProfValuesSectionName", NM="_ZN4llvm29getInstrProfValuesSectionNameEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm29getInstrProfValuesSectionNameEb")
//</editor-fold>
public static /*inline*/ StringRef getInstrProfValuesSectionName(boolean AddSegment) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the name of data section containing nodes holdling value
/// profiling data.
//<editor-fold defaultstate="collapsed" desc="llvm::getInstrProfVNodesSectionName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 70,
 FQN="llvm::getInstrProfVNodesSectionName", NM="_ZN4llvm29getInstrProfVNodesSectionNameEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm29getInstrProfVNodesSectionNameEb")
//</editor-fold>
public static /*inline*/ StringRef getInstrProfVNodesSectionName(boolean AddSegment) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the name profile runtime entry point to do value profiling
/// for a given site.
//<editor-fold defaultstate="collapsed" desc="llvm::getInstrProfValueProfFuncName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 77,
 FQN="llvm::getInstrProfValueProfFuncName", NM="_ZN4llvm29getInstrProfValueProfFuncNameEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm29getInstrProfValueProfFuncNameEv")
//</editor-fold>
public static /*inline*/ StringRef getInstrProfValueProfFuncName() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the name of the section containing function coverage mapping
/// data.
//<editor-fold defaultstate="collapsed" desc="llvm::getInstrProfCoverageSectionName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 83,
 FQN="llvm::getInstrProfCoverageSectionName", NM="_ZN4llvm31getInstrProfCoverageSectionNameEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm31getInstrProfCoverageSectionNameEb")
//</editor-fold>
public static /*inline*/ StringRef getInstrProfCoverageSectionName(boolean AddSegment) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the name prefix of variables containing instrumented function names.
//<editor-fold defaultstate="collapsed" desc="llvm::getInstrProfNameVarPrefix">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 89,
 FQN="llvm::getInstrProfNameVarPrefix", NM="_ZN4llvm25getInstrProfNameVarPrefixEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm25getInstrProfNameVarPrefixEv")
//</editor-fold>
public static /*inline*/ StringRef getInstrProfNameVarPrefix() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the name prefix of variables containing per-function control data.
//<editor-fold defaultstate="collapsed" desc="llvm::getInstrProfDataVarPrefix">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 92,
 FQN="llvm::getInstrProfDataVarPrefix", NM="_ZN4llvm25getInstrProfDataVarPrefixEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm25getInstrProfDataVarPrefixEv")
//</editor-fold>
public static /*inline*/ StringRef getInstrProfDataVarPrefix() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the name prefix of profile counter variables.
//<editor-fold defaultstate="collapsed" desc="llvm::getInstrProfCountersVarPrefix">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 95,
 FQN="llvm::getInstrProfCountersVarPrefix", NM="_ZN4llvm29getInstrProfCountersVarPrefixEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm29getInstrProfCountersVarPrefixEv")
//</editor-fold>
public static /*inline*/ StringRef getInstrProfCountersVarPrefix() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the name prefix of value profile variables.
//<editor-fold defaultstate="collapsed" desc="llvm::getInstrProfValuesVarPrefix">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 98,
 FQN="llvm::getInstrProfValuesVarPrefix", NM="_ZN4llvm27getInstrProfValuesVarPrefixEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm27getInstrProfValuesVarPrefixEv")
//</editor-fold>
public static /*inline*/ StringRef getInstrProfValuesVarPrefix() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the name of value profile node array variables:
//<editor-fold defaultstate="collapsed" desc="llvm::getInstrProfVNodesVarName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 101,
 FQN="llvm::getInstrProfVNodesVarName", NM="_ZN4llvm25getInstrProfVNodesVarNameEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm25getInstrProfVNodesVarNameEv")
//</editor-fold>
public static /*inline*/ StringRef getInstrProfVNodesVarName() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the name prefix of the COMDAT group for instrumentation variables
/// associated with a COMDAT function.
//<editor-fold defaultstate="collapsed" desc="llvm::getInstrProfComdatPrefix">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 105,
 FQN="llvm::getInstrProfComdatPrefix", NM="_ZN4llvm24getInstrProfComdatPrefixEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm24getInstrProfComdatPrefixEv")
//</editor-fold>
public static /*inline*/ StringRef getInstrProfComdatPrefix() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the name of the variable holding the strings (possibly compressed)
/// of all function's PGO names.
//<editor-fold defaultstate="collapsed" desc="llvm::getInstrProfNamesVarName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 109,
 FQN="llvm::getInstrProfNamesVarName", NM="_ZN4llvm24getInstrProfNamesVarNameEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm24getInstrProfNamesVarNameEv")
//</editor-fold>
public static /*inline*/ StringRef getInstrProfNamesVarName() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the name of a covarage mapping variable (internal linkage)
/// for each instrumented source module. Such variables are allocated
/// in the __llvm_covmap section.
//<editor-fold defaultstate="collapsed" desc="llvm::getCoverageMappingVarName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 116,
 FQN="llvm::getCoverageMappingVarName", NM="_ZN4llvm25getCoverageMappingVarNameEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm25getCoverageMappingVarNameEv")
//</editor-fold>
public static /*inline*/ StringRef getCoverageMappingVarName() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the name of the internal variable recording the array
/// of PGO name vars referenced by the coverage mapping. The owning
/// functions of those names are not emitted by FE (e.g, unused inline
/// functions.)
//<editor-fold defaultstate="collapsed" desc="llvm::getCoverageUnusedNamesVarName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 124,
 FQN="llvm::getCoverageUnusedNamesVarName", NM="_ZN4llvm29getCoverageUnusedNamesVarNameEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm29getCoverageUnusedNamesVarNameEv")
//</editor-fold>
public static /*inline*/ StringRef getCoverageUnusedNamesVarName() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the name of function that registers all the per-function control
/// data at program startup time by calling __llvm_register_function. This
/// function has internal linkage and is called by  __llvm_profile_init
/// runtime method. This function is not generated for these platforms:
/// Darwin, Linux, and FreeBSD.
//<editor-fold defaultstate="collapsed" desc="llvm::getInstrProfRegFuncsName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 133,
 FQN="llvm::getInstrProfRegFuncsName", NM="_ZN4llvm24getInstrProfRegFuncsNameEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm24getInstrProfRegFuncsNameEv")
//</editor-fold>
public static /*inline*/ StringRef getInstrProfRegFuncsName() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the name of the runtime interface that registers per-function control
/// data for one instrumented function.
//<editor-fold defaultstate="collapsed" desc="llvm::getInstrProfRegFuncName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 139,
 FQN="llvm::getInstrProfRegFuncName", NM="_ZN4llvm23getInstrProfRegFuncNameEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm23getInstrProfRegFuncNameEv")
//</editor-fold>
public static /*inline*/ StringRef getInstrProfRegFuncName() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the name of the runtime interface that registers the PGO name strings.
//<editor-fold defaultstate="collapsed" desc="llvm::getInstrProfNamesRegFuncName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 144,
 FQN="llvm::getInstrProfNamesRegFuncName", NM="_ZN4llvm28getInstrProfNamesRegFuncNameEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm28getInstrProfNamesRegFuncNameEv")
//</editor-fold>
public static /*inline*/ StringRef getInstrProfNamesRegFuncName() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the name of the runtime initialization method that is generated by
/// the compiler. The function calls __llvm_profile_register_functions and
/// __llvm_profile_override_default_filename functions if needed. This function
/// has internal linkage and invoked at startup time via init_array.
//<editor-fold defaultstate="collapsed" desc="llvm::getInstrProfInitFuncName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 152,
 FQN="llvm::getInstrProfInitFuncName", NM="_ZN4llvm24getInstrProfInitFuncNameEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm24getInstrProfInitFuncNameEv")
//</editor-fold>
public static /*inline*/ StringRef getInstrProfInitFuncName() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the name of the hook variable defined in profile runtime library.
/// A reference to the variable causes the linker to link in the runtime
/// initialization module (which defines the hook variable).
//<editor-fold defaultstate="collapsed" desc="llvm::getInstrProfRuntimeHookVarName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 157,
 FQN="llvm::getInstrProfRuntimeHookVarName", NM="_ZN4llvm30getInstrProfRuntimeHookVarNameEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm30getInstrProfRuntimeHookVarNameEv")
//</editor-fold>
public static /*inline*/ StringRef getInstrProfRuntimeHookVarName() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the name of the compiler generated function that references the
/// runtime hook variable. The function is a weak global.
//<editor-fold defaultstate="collapsed" desc="llvm::getInstrProfRuntimeHookVarUseFuncName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 163,
 FQN="llvm::getInstrProfRuntimeHookVarUseFuncName", NM="_ZN4llvm37getInstrProfRuntimeHookVarUseFuncNameEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm37getInstrProfRuntimeHookVarUseFuncNameEv")
//</editor-fold>
public static /*inline*/ StringRef getInstrProfRuntimeHookVarUseFuncName() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the name of the profile runtime interface that overrides the default
/// profile data file name.
//<editor-fold defaultstate="collapsed" desc="llvm::getInstrProfFileOverriderFuncName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 169,
 FQN="llvm::getInstrProfFileOverriderFuncName", NM="_ZN4llvm33getInstrProfFileOverriderFuncNameEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm33getInstrProfFileOverriderFuncNameEv")
//</editor-fold>
public static /*inline*/ StringRef getInstrProfFileOverriderFuncName() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the marker used to separate PGO names during serialization.
//<editor-fold defaultstate="collapsed" desc="llvm::getInstrProfNameSeparator">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 174,
 FQN="llvm::getInstrProfNameSeparator", NM="_ZN4llvm25getInstrProfNameSeparatorEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm25getInstrProfNameSeparatorEv")
//</editor-fold>
public static /*inline*/ StringRef getInstrProfNameSeparator() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the modified name for function \c F suitable to be
/// used the key for profile lookup. Variable \c InLTO indicates if this
/// is called in LTO optimization passes.

// Return the PGOFuncName. This function has some special handling when called
// in LTO optimization. The following only applies when calling in LTO passes
// (when \c InLTO is true): LTO's internalization privatizes many global linkage
// symbols. This happens after value profile annotation, but those internal
// linkage functions should not have a source prefix.
// To differentiate compiler generated internal symbols from original ones,
// PGOFuncName meta data are created and attached to the original internal
// symbols in the value profile annotation step
// (PGOUseFunc::annotateIndirectCallSites). If a symbol does not have the meta
// data, its original linkage must be non-internal.
//<editor-fold defaultstate="collapsed" desc="llvm::getPGOFuncName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp", line = 143,
 FQN="llvm::getPGOFuncName", NM="_ZN4llvm14getPGOFuncNameERKNS_8FunctionEby",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm14getPGOFuncNameERKNS_8FunctionEby")
//</editor-fold>
public static std.string getPGOFuncName(final /*const*/ Function /*&*/ F) {
  return getPGOFuncName(F, false, 4/*INSTR_PROF_INDEX_VERSION*/);
}
public static std.string getPGOFuncName(final /*const*/ Function /*&*/ F, boolean InLTO/*= false*/) {
  return getPGOFuncName(F, InLTO, 4/*INSTR_PROF_INDEX_VERSION*/);
}
public static std.string getPGOFuncName(final /*const*/ Function /*&*/ F, boolean InLTO/*= false*/, long/*uint64_t*/ Version/*= 4*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the modified name for a function suitable to be
/// used the key for profile lookup. The function's original
/// name is \c RawFuncName and has linkage of type \c Linkage.
/// The function is defined in module \c FileName.
//<editor-fold defaultstate="collapsed" desc="llvm::getPGOFuncName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp", line = 126,
 FQN="llvm::getPGOFuncName", NM="_ZN4llvm14getPGOFuncNameENS_9StringRefENS_11GlobalValue12LinkageTypesES0_y",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm14getPGOFuncNameENS_9StringRefENS_11GlobalValue12LinkageTypesES0_y")
//</editor-fold>
public static std.string getPGOFuncName(StringRef RawFuncName, 
              GlobalValue.LinkageTypes Linkage, 
              StringRef FileName) {
  return getPGOFuncName(RawFuncName, 
              Linkage, 
              FileName, 
              4/*INSTR_PROF_INDEX_VERSION*/);
}
public static std.string getPGOFuncName(StringRef RawFuncName, 
              GlobalValue.LinkageTypes Linkage, 
              StringRef FileName, 
              long/*uint64_t*/ Version/*= 4*//* __attribute__((unused))*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the name of the global variable used to store a function
/// name in PGO instrumentation. \c FuncName is the name of the function
/// returned by the \c getPGOFuncName call.

// \p FuncName is the string used as profile lookup key for the function. A
// symbol is created to hold the name. Return the legalized symbol name.
//<editor-fold defaultstate="collapsed" desc="llvm::getPGOFuncNameVarName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp", line = 174,
 FQN="llvm::getPGOFuncNameVarName", NM="_ZN4llvm21getPGOFuncNameVarNameENS_9StringRefENS_11GlobalValue12LinkageTypesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm21getPGOFuncNameVarNameENS_9StringRefENS_11GlobalValue12LinkageTypesE")
//</editor-fold>
public static std.string getPGOFuncNameVarName(StringRef FuncName, 
                     GlobalValue.LinkageTypes Linkage) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Create and return the global variable for function name used in PGO
/// instrumentation. \c FuncName is the name of the function returned
/// by \c getPGOFuncName call.
//<editor-fold defaultstate="collapsed" desc="llvm::createPGOFuncNameVar">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp", line = 220,
 FQN="llvm::createPGOFuncNameVar", NM="_ZN4llvm20createPGOFuncNameVarERNS_8FunctionENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm20createPGOFuncNameVarERNS_8FunctionENS_9StringRefE")
//</editor-fold>
public static GlobalVariable /*P*/ createPGOFuncNameVar(final Function /*&*/ F, StringRef PGOFuncName) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Create and return the global variable for function name used in PGO
/// instrumentation.  /// \c FuncName is the name of the function
/// returned by \c getPGOFuncName call, \c M is the owning module,
/// and \c Linkage is the linkage of the instrumented function.
//<editor-fold defaultstate="collapsed" desc="llvm::createPGOFuncNameVar">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp", line = 192,
 FQN="llvm::createPGOFuncNameVar", NM="_ZN4llvm20createPGOFuncNameVarERNS_6ModuleENS_11GlobalValue12LinkageTypesENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm20createPGOFuncNameVarERNS_6ModuleENS_11GlobalValue12LinkageTypesENS_9StringRefE")
//</editor-fold>
public static GlobalVariable /*P*/ createPGOFuncNameVar(final Module /*&*/ M, 
                    GlobalValue.LinkageTypes Linkage, 
                    StringRef PGOFuncName) {
  throw new UnsupportedOperationException("EmptyBody");
}

/// Return the initializer in string of the PGO name var \c NameVar.
//<editor-fold defaultstate="collapsed" desc="llvm::getPGOFuncNameVarInitializer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp", line = 279,
 FQN="llvm::getPGOFuncNameVarInitializer", NM="_ZN4llvm28getPGOFuncNameVarInitializerEPNS_14GlobalVariableE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm28getPGOFuncNameVarInitializerEPNS_14GlobalVariableE")
//</editor-fold>
public static StringRef getPGOFuncNameVarInitializer(GlobalVariable /*P*/ NameVar) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given a PGO function name, remove the filename prefix and return
/// the original (static) function name.
//<editor-fold defaultstate="collapsed" desc="llvm::getFuncNameWithoutPrefix">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp", line = 163,
 FQN="llvm::getFuncNameWithoutPrefix", NM="_ZN4llvm24getFuncNameWithoutPrefixENS_9StringRefES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm24getFuncNameWithoutPrefixENS_9StringRefES0_")
//</editor-fold>
public static StringRef getFuncNameWithoutPrefix(StringRef PGOFuncName) {
  return getFuncNameWithoutPrefix(PGOFuncName, new StringRef(/*KEEP_STR*/"<unknown>"));
}
public static StringRef getFuncNameWithoutPrefix(StringRef PGOFuncName, StringRef FileName/*= "<unknown>"*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given a vector of strings (function PGO names) \c NameStrs, the
/// method generates a combined string \c Result thatis ready to be
/// serialized.  The \c Result string is comprised of three fields:
/// The first field is the legnth of the uncompressed strings, and the
/// the second field is the length of the zlib-compressed string.
/// Both fields are encoded in ULEB128.  If \c doCompress is false, the
///  third field is the uncompressed strings; otherwise it is the
/// compressed string. When the string compression is off, the
/// second field will have value zero.
//<editor-fold defaultstate="collapsed" desc="llvm::collectPGOFuncNameStrings">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp", line = 238,
 FQN="llvm::collectPGOFuncNameStrings", NM="_ZN4llvm25collectPGOFuncNameStringsERKSt6vectorISsSaISsEEbRSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm25collectPGOFuncNameStringsERKSt6vectorISsSaISsEEbRSs")
//</editor-fold>
public static Error collectPGOFuncNameStrings(final /*const*/std.vectorString/*&*/ NameStrs, 
                         boolean doCompression, final std.string/*&*/ Result) {
  throw new UnsupportedOperationException("EmptyBody");
}

/// Produce \c Result string with the same format described above. The input
/// is vector of PGO function name variables that are referenced.
//<editor-fold defaultstate="collapsed" desc="llvm::collectPGOFuncNameStrings">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp", line = 286,
 FQN="llvm::collectPGOFuncNameStrings", NM="_ZN4llvm25collectPGOFuncNameStringsERKSt6vectorIPNS_14GlobalVariableESaIS2_EERSsb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm25collectPGOFuncNameStringsERKSt6vectorIPNS_14GlobalVariableESaIS2_EERSsb")
//</editor-fold>
public static Error collectPGOFuncNameStrings(final /*const*/std.vector<GlobalVariable /*P*/ > /*&*/ NameVars, 
                         final std.string/*&*/ Result) {
  return collectPGOFuncNameStrings(NameVars, 
                         Result, true);
}
public static Error collectPGOFuncNameStrings(final /*const*/std.vector<GlobalVariable /*P*/ > /*&*/ NameVars, 
                         final std.string/*&*/ Result, boolean doCompression/*= true*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

/// \c NameStrings is a string composed of one of more sub-strings encoded in
/// the format described above. The substrings are seperated by 0 or more zero
/// bytes. This method decodes the string and populates the \c Symtab.
//<editor-fold defaultstate="collapsed" desc="llvm::readPGOFuncNameStrings">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp", line = 296,
 FQN="llvm::readPGOFuncNameStrings", NM="_ZN4llvm22readPGOFuncNameStringsENS_9StringRefERNS_15InstrProfSymtabE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm22readPGOFuncNameStringsENS_9StringRefERNS_15InstrProfSymtabE")
//</editor-fold>
public static Error readPGOFuncNameStrings(StringRef NameStrings, final InstrProfSymtab /*&*/ Symtab) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Get the value profile data for value site \p SiteIdx from \p InstrProfR
/// and annotate the instruction \p Inst with the value profile meta data.
/// Annotate up to \p MaxMDCount (default 3) number of records per value site.
//<editor-fold defaultstate="collapsed" desc="llvm::annotateValueSite">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp", line = 670,
 FQN="llvm::annotateValueSite", NM="_ZN4llvm17annotateValueSiteERNS_6ModuleERNS_11InstructionERKNS_15InstrProfRecordENS_18InstrProfValueKindEjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm17annotateValueSiteERNS_6ModuleERNS_11InstructionERKNS_15InstrProfRecordENS_18InstrProfValueKindEjj")
//</editor-fold>
public static void annotateValueSite(final Module /*&*/ M, final Instruction /*&*/ Inst, 
                 final /*const*/ InstrProfRecord /*&*/ InstrProfR, 
                 InstrProfValueKind ValueKind, /*uint32_t*/int SiteIdx) {
  annotateValueSite(M, Inst, 
                 InstrProfR, 
                 ValueKind, SiteIdx, 
                 3);
}
public static void annotateValueSite(final Module /*&*/ M, final Instruction /*&*/ Inst, 
                 final /*const*/ InstrProfRecord /*&*/ InstrProfR, 
                 InstrProfValueKind ValueKind, /*uint32_t*/int SiteIdx, 
                 /*uint32_t*/int MaxMDCount/*= 3*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

/// Same as the above interface but using an ArrayRef, as well as \p Sum.
//<editor-fold defaultstate="collapsed" desc="llvm::annotateValueSite">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp", line = 686,
 FQN="llvm::annotateValueSite", NM="_ZN4llvm17annotateValueSiteERNS_6ModuleERNS_11InstructionENS_8ArrayRefI18InstrProfValueDataEEyNS_18InstrProfValueKindEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm17annotateValueSiteERNS_6ModuleERNS_11InstructionENS_8ArrayRefI18InstrProfValueDataEEyNS_18InstrProfValueKindEj")
//</editor-fold>
public static void annotateValueSite(final Module /*&*/ M, final Instruction /*&*/ Inst, 
                 ArrayRef< InstrProfValueData> VDs, 
                 long/*uint64_t*/ Sum, InstrProfValueKind ValueKind, 
                 /*uint32_t*/int MaxMDCount) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Extract the value profile data from \p Inst which is annotated with
/// value profile meta data. Return false if there is no value data annotated,
/// otherwise  return true.
//<editor-fold defaultstate="collapsed" desc="llvm::getValueProfDataFromInst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp", line = 715,
 FQN="llvm::getValueProfDataFromInst", NM="_ZN4llvm24getValueProfDataFromInstERKNS_11InstructionENS_18InstrProfValueKindEjP18InstrProfValueDataRjRy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm24getValueProfDataFromInstERKNS_11InstructionENS_18InstrProfValueKindEjP18InstrProfValueDataRjRy")
//</editor-fold>
public static boolean getValueProfDataFromInst(final /*const*/ Instruction /*&*/ Inst, 
                        InstrProfValueKind ValueKind, 
                        /*uint32_t*/int MaxNumValueData, 
                        InstrProfValueData ValueData[], 
                        final /*uint32_t &*/uint$ref ActualNumValueData, final ulong$ref/*uint64_t &*/ TotalC) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::getPGOFuncNameMetadataName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 267,
 FQN="llvm::getPGOFuncNameMetadataName", NM="_ZN4llvm26getPGOFuncNameMetadataNameEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm26getPGOFuncNameMetadataNameEv")
//</editor-fold>
public static /*inline*/ StringRef getPGOFuncNameMetadataName() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return the PGOFuncName meta data associated with a function.
//<editor-fold defaultstate="collapsed" desc="llvm::getPGOFuncNameMetadata">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp", line = 767,
 FQN="llvm::getPGOFuncNameMetadata", NM="_ZN4llvm22getPGOFuncNameMetadataERKNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm22getPGOFuncNameMetadataERKNS_8FunctionE")
//</editor-fold>
public static MDNode /*P*/ getPGOFuncNameMetadata(final /*const*/ Function /*&*/ F) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Create the PGOFuncName meta data if PGOFuncName is different from
/// function's raw name. This should only apply to internal linkage functions
/// declared by users only.
//<editor-fold defaultstate="collapsed" desc="llvm::createPGOFuncNameMetadata">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp", line = 771,
 FQN="llvm::createPGOFuncNameMetadata", NM="_ZN4llvm25createPGOFuncNameMetadataERNS_8FunctionENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm25createPGOFuncNameMetadataERNS_8FunctionENS_9StringRefE")
//</editor-fold>
public static void createPGOFuncNameMetadata(final Function /*&*/ F, StringRef PGOFuncName) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::instrprof_category">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp", line = 89,
 FQN="llvm::instrprof_category", NM="_ZN4llvm18instrprof_categoryEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm18instrprof_categoryEv")
//</editor-fold>
public static /*const*/ std.error_category /*&*/ instrprof_category() {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::make_error_code">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 299,
 FQN="llvm::make_error_code", NM="_ZN4llvm15make_error_codeENS_15instrprof_errorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm15make_error_codeENS_15instrprof_errorE")
//</editor-fold>
public static /*inline*/ std.error_code make_error_code(instrprof_error E) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::getHostEndianness">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 733,
 FQN="llvm::getHostEndianness", NM="_ZN4llvm17getHostEndiannessEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm17getHostEndiannessEv")
//</editor-fold>
public static /*inline*/ endianness getHostEndianness() {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class InstrProfLlvmGlobals
