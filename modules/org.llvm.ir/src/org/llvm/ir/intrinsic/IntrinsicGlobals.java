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
package org.llvm.ir.intrinsic;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;


//<editor-fold defaultstate="collapsed" desc="static type IntrinsicGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.intrinsic.IntrinsicGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/AsmParser/LLParser.cpp -nm=_ZN4llvm9Intrinsic12isOverloadedENS0_2IDE;_ZN4llvm9Intrinsic13getAttributesERNS_11LLVMContextENS0_2IDE;_ZN4llvm9Intrinsic14getDeclarationEPNS_6ModuleENS0_2IDENS_8ArrayRefIPNS_4TypeEEE;_ZN4llvm9Intrinsic18matchIntrinsicTypeEPNS_4TypeERNS_8ArrayRefINS0_13IITDescriptorEEERNS_15SmallVectorImplIS2_EE;_ZN4llvm9Intrinsic20matchIntrinsicVarArgEbRNS_8ArrayRefINS0_13IITDescriptorEEE;_ZN4llvm9Intrinsic24getIntrinsicForMSBuiltinEPKcS2_;_ZN4llvm9Intrinsic25getIntrinsicForGCCBuiltinEPKcS2_;_ZN4llvm9Intrinsic25lookupLLVMIntrinsicByNameENS_8ArrayRefIPKcEENS_9StringRefE;_ZN4llvm9Intrinsic25remangleIntrinsicFunctionEPNS_8FunctionE;_ZN4llvm9Intrinsic28getIntrinsicInfoTableEntriesENS0_2IDERNS_15SmallVectorImplINS0_13IITDescriptorEEE;_ZN4llvm9Intrinsic6isLeafENS0_2IDE;_ZN4llvm9Intrinsic7getNameB5cxx11ENS0_2IDENS_8ArrayRefIPNS_4TypeEEE;_ZN4llvm9Intrinsic7getTypeERNS_11LLVMContextENS0_2IDENS_8ArrayRefIPNS_4TypeEEE; -static-type=IntrinsicGlobals -package=org.llvm.ir.intrinsic")
//</editor-fold>
public final class IntrinsicGlobals {


/// Return the LLVM name for an intrinsic, such as "llvm.ppc.altivec.lvx".
//<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::getName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Intrinsics.h", line = 48,
 FQN="llvm::Intrinsic::getName", NM="_ZN4llvm9Intrinsic7getNameENS0_2IDENS_8ArrayRefIPNS_4TypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/AsmParser/LLParser.cpp -nm=_ZN4llvm9Intrinsic7getNameENS0_2IDENS_8ArrayRefIPNS_4TypeEEE")
//</editor-fold>
public static std.string getName(/*Intrinsic.ID*/int id) {
  return getName(id, new ArrayRef<Type /*P*/ >(None, true));
}
public static std.string getName(/*Intrinsic.ID*/int id, ArrayRef<Type /*P*/ > Tys/*= None*/) {
  throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
}


/// Return the function type for an intrinsic.
//<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::getType">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Intrinsics.h", line = 51,
 FQN="llvm::Intrinsic::getType", NM="_ZN4llvm9Intrinsic7getTypeERNS_11LLVMContextENS0_2IDENS_8ArrayRefIPNS_4TypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/AsmParser/LLParser.cpp -nm=_ZN4llvm9Intrinsic7getTypeERNS_11LLVMContextENS0_2IDENS_8ArrayRefIPNS_4TypeEEE")
//</editor-fold>
public static FunctionType /*P*/ getType(final LLVMContext /*&*/ Context, /*Intrinsic.ID*/int id) {
  return getType(Context, id, 
       new ArrayRef<Type /*P*/ >(None, true));
}
public static FunctionType /*P*/ getType(final LLVMContext /*&*/ Context, /*Intrinsic.ID*/int id, 
       ArrayRef<Type /*P*/ > Tys/*= None*/) {
  return /*delegate*/org.llvm.ir.intrinsic.impl.FunctionIntrinsicGlobals.
    getType(Context, id, 
       Tys);
}


/// Returns true if the intrinsic can be overloaded.
//<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::isOverloaded">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Intrinsics.h", line = 55,
 FQN="llvm::Intrinsic::isOverloaded", NM="_ZN4llvm9Intrinsic12isOverloadedENS0_2IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/AsmParser/LLParser.cpp -nm=_ZN4llvm9Intrinsic12isOverloadedENS0_2IDE")
//</editor-fold>
public static boolean isOverloaded(/*Intrinsic.ID*/int id) {
  return /*delegate*/org.llvm.ir.intrinsic.impl.FunctionIntrinsicGlobals.
    isOverloaded(id);
}


/// Returns true if the intrinsic is a leaf, i.e. it does not make any calls
/// itself.  Most intrinsics are leafs, the exceptions being the patchpoint
/// and statepoint intrinsics. These call (or invoke) their "target" argument.
//<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::isLeaf">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Intrinsics.h", line = 60,
 FQN="llvm::Intrinsic::isLeaf", NM="_ZN4llvm9Intrinsic6isLeafENS0_2IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/AsmParser/LLParser.cpp -nm=_ZN4llvm9Intrinsic6isLeafENS0_2IDE")
//</editor-fold>
public static boolean isLeaf(/*Intrinsic.ID*/int id) {
  return /*delegate*/org.llvm.ir.intrinsic.impl.FunctionIntrinsicGlobals.
    isLeaf(id);
}


/// Return the attributes for an intrinsic.
//<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::getAttributes">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Intrinsics.h", line = 63,
 FQN="llvm::Intrinsic::getAttributes", NM="_ZN4llvm9Intrinsic13getAttributesERNS_11LLVMContextENS0_2IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/AsmParser/LLParser.cpp -nm=_ZN4llvm9Intrinsic13getAttributesERNS_11LLVMContextENS0_2IDE")
//</editor-fold>
public static AttributeSet getAttributes(final LLVMContext /*&*/ C, /*Intrinsic.ID*/int id) {
  return /*delegate*/org.llvm.ir.intrinsic.impl.IntrinsicsIntrinsicGlobals.
    getAttributes(C, id);
}


/// Create or insert an LLVM Function declaration for an intrinsic, and return
/// it.
///
/// The Tys parameter is for intrinsics with overloaded types (e.g., those
/// using iAny, fAny, vAny, or iPTRAny).  For a declaration of an overloaded
/// intrinsic, Tys must provide exactly one type for each overloaded type in
/// the intrinsic.
//<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::getDeclaration">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Intrinsics.h", line = 72,
 FQN="llvm::Intrinsic::getDeclaration", NM="_ZN4llvm9Intrinsic14getDeclarationEPNS_6ModuleENS0_2IDENS_8ArrayRefIPNS_4TypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/AsmParser/LLParser.cpp -nm=_ZN4llvm9Intrinsic14getDeclarationEPNS_6ModuleENS0_2IDENS_8ArrayRefIPNS_4TypeEEE")
//</editor-fold>
public static Function /*P*/ getDeclaration(Module /*P*/ M, /*Intrinsic.ID*/int id) {
  return getDeclaration(M, id, new ArrayRef<Type /*P*/ >(None, true));
}
public static Function /*P*/ getDeclaration(Module /*P*/ M, /*Intrinsic.ID*/int id, ArrayRef<Type /*P*/ > Tys/*= None*/) {
  return /*delegate*/org.llvm.ir.intrinsic.impl.FunctionIntrinsicGlobals.
    getDeclaration(M, id, Tys);
}


/// Looks up Name in NameTable via binary search. NameTable must be sorted
/// and all entries must start with "llvm.".  If NameTable contains an exact
/// match for Name or a prefix of Name followed by a dot, its index in
/// NameTable is returned. Otherwise, -1 is returned.
//<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::lookupLLVMIntrinsicByName">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Intrinsics.h", line = 78,
 FQN="llvm::Intrinsic::lookupLLVMIntrinsicByName", NM="_ZN4llvm9Intrinsic25lookupLLVMIntrinsicByNameENS_8ArrayRefIPKcEENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/AsmParser/LLParser.cpp -nm=_ZN4llvm9Intrinsic25lookupLLVMIntrinsicByNameENS_8ArrayRefIPKcEENS_9StringRefE")
//</editor-fold>
public static int lookupLLVMIntrinsicByName(ArrayRef</*const*/char$ptr/*char P*/ > NameTable, 
                         StringRef Name) {
  return /*delegate*/org.llvm.ir.intrinsic.impl.IntrinsicInstIntrinsicGlobals.
    lookupLLVMIntrinsicByName(NameTable, 
                         Name);
}


/// Map a GCC builtin name to an intrinsic ID.
//<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::getIntrinsicForGCCBuiltin">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Intrinsics.h", line = 82,
 FQN="llvm::Intrinsic::getIntrinsicForGCCBuiltin", NM="_ZN4llvm9Intrinsic25getIntrinsicForGCCBuiltinEPKcS2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/AsmParser/LLParser.cpp -nm=_ZN4llvm9Intrinsic25getIntrinsicForGCCBuiltinEPKcS2_")
//</editor-fold>
public static /*Intrinsic.ID*/int getIntrinsicForGCCBuiltin(/*const*/char$ptr/*char P*/ Prefix, /*const*/char$ptr/*char P*/ BuiltinName) {
  return /*delegate*/org.llvm.ir.intrinsic.impl.IntrinsicsIntrinsicGlobals.
    getIntrinsicForGCCBuiltin(Prefix, BuiltinName);
}


/// Map a MS builtin name to an intrinsic ID.
//<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::getIntrinsicForMSBuiltin">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Intrinsics.h", line = 85,
 FQN="llvm::Intrinsic::getIntrinsicForMSBuiltin", NM="_ZN4llvm9Intrinsic24getIntrinsicForMSBuiltinEPKcS2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/AsmParser/LLParser.cpp -nm=_ZN4llvm9Intrinsic24getIntrinsicForMSBuiltinEPKcS2_")
//</editor-fold>
public static /*Intrinsic.ID*/int getIntrinsicForMSBuiltin(/*const*/char$ptr/*char P*/ Prefix, /*const*/char$ptr/*char P*/ BuiltinName) {
  return /*delegate*/org.llvm.ir.intrinsic.impl.IntrinsicsIntrinsicGlobals.
    getIntrinsicForMSBuiltin(Prefix, BuiltinName);
}


/// Return the IIT table descriptor for the specified intrinsic into an array
/// of IITDescriptors.
//<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::getIntrinsicInfoTableEntries">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Intrinsics.h", line = 136,
 FQN="llvm::Intrinsic::getIntrinsicInfoTableEntries", NM="_ZN4llvm9Intrinsic28getIntrinsicInfoTableEntriesENS0_2IDERNS_15SmallVectorImplINS0_13IITDescriptorEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/AsmParser/LLParser.cpp -nm=_ZN4llvm9Intrinsic28getIntrinsicInfoTableEntriesENS0_2IDERNS_15SmallVectorImplINS0_13IITDescriptorEEE")
//</editor-fold>
public static void getIntrinsicInfoTableEntries(/*Intrinsic.ID*/int id, final SmallVectorImpl<IITDescriptor> /*&*/ T) {
  /*delegate*/org.llvm.ir.intrinsic.impl.FunctionIntrinsicGlobals.
    getIntrinsicInfoTableEntries(id, T);
}


/// Match the specified type (which comes from an intrinsic argument or return
/// value) with the type constraints specified by the .td file. If the given
/// type is an overloaded type it is pushed to the ArgTys vector.
///
/// Returns false if the given type matches with the constraints, true
/// otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::matchIntrinsicType">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Intrinsics.h", line = 144,
 FQN="llvm::Intrinsic::matchIntrinsicType", NM="_ZN4llvm9Intrinsic18matchIntrinsicTypeEPNS_4TypeERNS_8ArrayRefINS0_13IITDescriptorEEERNS_15SmallVectorImplIS2_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/AsmParser/LLParser.cpp -nm=_ZN4llvm9Intrinsic18matchIntrinsicTypeEPNS_4TypeERNS_8ArrayRefINS0_13IITDescriptorEEERNS_15SmallVectorImplIS2_EE")
//</editor-fold>
public static boolean matchIntrinsicType(Type /*P*/ Ty, final ArrayRef<IITDescriptor> /*&*/ Infos, 
                  final SmallVectorImpl<Type /*P*/ > /*&*/ ArgTys) {
  return /*delegate*/org.llvm.ir.intrinsic.impl.FunctionIntrinsicGlobals.
    matchIntrinsicType(Ty, Infos, 
                  ArgTys);
}


/// Verify if the intrinsic has variable arguments. This method is intended to
/// be called after all the fixed arguments have been matched first.
///
/// This method returns true on error.
//<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::matchIntrinsicVarArg">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Intrinsics.h", line = 151,
 FQN="llvm::Intrinsic::matchIntrinsicVarArg", NM="_ZN4llvm9Intrinsic20matchIntrinsicVarArgEbRNS_8ArrayRefINS0_13IITDescriptorEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/AsmParser/LLParser.cpp -nm=_ZN4llvm9Intrinsic20matchIntrinsicVarArgEbRNS_8ArrayRefINS0_13IITDescriptorEEE")
//</editor-fold>
public static boolean matchIntrinsicVarArg(boolean isVarArg, final ArrayRef<IITDescriptor> /*&*/ Infos) {
  return /*delegate*/org.llvm.ir.intrinsic.impl.FunctionIntrinsicGlobals.
    matchIntrinsicVarArg(isVarArg, Infos);
}


// Checks if the intrinsic name matches with its signature and if not
// returns the declaration with the same signature and remangled name.
//<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::remangleIntrinsicFunction">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Intrinsics.h", line = 155,
 FQN="llvm::Intrinsic::remangleIntrinsicFunction", NM="_ZN4llvm9Intrinsic25remangleIntrinsicFunctionEPNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/AsmParser/LLParser.cpp -nm=_ZN4llvm9Intrinsic25remangleIntrinsicFunctionEPNS_8FunctionE")
//</editor-fold>
public static OptionalPtr<Function /*P*/ > remangleIntrinsicFunction(Function /*P*/ F) {
  return /*delegate*/org.llvm.ir.intrinsic.impl.FunctionIntrinsicGlobals.
    remangleIntrinsicFunction(F);
}

} // END OF class IntrinsicGlobals
