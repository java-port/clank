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
package org.llvm.ir.intrinsic.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.gen.IntrinsicsGlobals;
import org.llvm.ir.impl.*;
import static org.llvm.ir.impl.FunctionStatics.IntrinsicNameTable;
import static org.llvm.ir.impl.FunctionStatics.getMangledTypeStr;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IrRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type FunctionIntrinsicGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.intrinsic.impl.FunctionIntrinsicGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm9Intrinsic12isOverloadedENS0_2IDE;_ZN4llvm9Intrinsic14getDeclarationEPNS_6ModuleENS0_2IDENS_8ArrayRefIPNS_4TypeEEE;_ZN4llvm9Intrinsic18matchIntrinsicTypeEPNS_4TypeERNS_8ArrayRefINS0_13IITDescriptorEEERNS_15SmallVectorImplIS2_EE;_ZN4llvm9Intrinsic20matchIntrinsicVarArgEbRNS_8ArrayRefINS0_13IITDescriptorEEE;_ZN4llvm9Intrinsic25remangleIntrinsicFunctionEPNS_8FunctionE;_ZN4llvm9Intrinsic28getIntrinsicInfoTableEntriesENS0_2IDERNS_15SmallVectorImplINS0_13IITDescriptorEEE;_ZN4llvm9Intrinsic6isLeafENS0_2IDE;_ZN4llvm9Intrinsic7getNameB5cxx11ENS0_2IDENS_8ArrayRefIPNS_4TypeEEE;_ZN4llvm9Intrinsic7getTypeERNS_11LLVMContextENS0_2IDENS_8ArrayRefIPNS_4TypeEEE;_ZL9IIT_Table;_ZL21IIT_LongEncodingTable; -static-type=FunctionIntrinsicGlobals -package=org.llvm.ir.intrinsic.impl")
//</editor-fold>
public final class FunctionIntrinsicGlobals {


/// Return the LLVM name for an intrinsic, such as "llvm.ppc.altivec.lvx".
//<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::getName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 560,
 FQN="llvm::Intrinsic::getName", NM="_ZN4llvm9Intrinsic7getNameENS0_2IDENS_8ArrayRefIPNS_4TypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm9Intrinsic7getNameENS0_2IDENS_8ArrayRefIPNS_4TypeEEE")
//</editor-fold>
public static std.string getName(/*Intrinsic.ID*/int id) {
  return getName(id, new ArrayRef<Type /*P*/ >(None, true));
}
public static std.string getName(/*Intrinsic.ID*/int id, ArrayRef<Type /*P*/ > Tys/*= None*/) {
  assert ($less_int(id, ID.num_intrinsics)) : "Invalid intrinsic ID!";
  std.string Result/*J*/= new std.string(JD$T$C$P_T2$C$R.INSTANCE, IntrinsicNameTable.$at(id));
  for (Type /*P*/ Ty : Tys) {
    Result.$addassign($add_T$C$P_string(/*KEEP_STR*/".", getMangledTypeStr(Ty)));
  }
  return Result;
}


/// Return the function type for an intrinsic.
//<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::getType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 889,
 FQN="llvm::Intrinsic::getType", NM="_ZN4llvm9Intrinsic7getTypeERNS_11LLVMContextENS0_2IDENS_8ArrayRefIPNS_4TypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm9Intrinsic7getTypeERNS_11LLVMContextENS0_2IDENS_8ArrayRefIPNS_4TypeEEE")
//</editor-fold>
public static FunctionType /*P*/ getType(final LLVMContext /*&*/ Context, 
       /*Intrinsic.ID*/int id) {
  return getType(Context, 
       id, new ArrayRef<Type /*P*/ >(None, true));
}
public static FunctionType /*P*/ getType(final LLVMContext /*&*/ Context, 
       /*Intrinsic.ID*/int id, ArrayRef<Type /*P*/ > Tys/*= None*/) {
  SmallVector<IITDescriptor> Table/*J*/= new SmallVector<IITDescriptor>(8, new IITDescriptor());
  IntrinsicGlobals.getIntrinsicInfoTableEntries(id, Table);
  
  ArrayRef<IITDescriptor> TableRef = new ArrayRef<IITDescriptor>(Table, false);
  Type /*P*/ ResultTy = FunctionStatics.DecodeFixedType(TableRef, new ArrayRef<Type /*P*/ >(Tys), Context);
  
  SmallVector<Type /*P*/ > ArgTys/*J*/= new SmallVector<Type /*P*/ >(8, (Type /*P*/ )null);
  while (!TableRef.empty()) {
    ArgTys.push_back(FunctionStatics.DecodeFixedType(TableRef, new ArrayRef<Type /*P*/ >(Tys), Context));
  }
  
  // DecodeFixedType returns Void for IITDescriptor::Void and IITDescriptor::VarArg
  // If we see void type as the type of the last argument, it is vararg intrinsic
  if (!ArgTys.empty() && ArgTys.back().isVoidTy()) {
    ArgTys.pop_back();
    return FunctionType.get(ResultTy, new ArrayRef<Type /*P*/ >(ArgTys, true), true);
  }
  return FunctionType.get(ResultTy, new ArrayRef<Type /*P*/ >(ArgTys, true), false);
}


/// Returns true if the intrinsic can be overloaded.
//<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::isOverloaded">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 910,
 FQN="llvm::Intrinsic::isOverloaded", NM="_ZN4llvm9Intrinsic12isOverloadedENS0_2IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm9Intrinsic12isOverloadedENS0_2IDE")
//</editor-fold>
public static boolean isOverloaded(/*Intrinsic.ID*/int id) {
  final/*static*/ /*const*/byte/*uint8_t*/ OTable[/*761*/] = isOverloaded$$.OTable;
  
  return ($uchar2int(OTable[$div_int_uint(id, 8)]) & (1 << ($rem_int_uint(id, 8)))) != 0;
}
private static final class isOverloaded$$ {
  static final/*static*/ /*const*/byte/*uint8_t*/ OTable[/*761*/] = new$char(761, 
    0 | (1 << 2) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 7), 
    0, 
    0 | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 5) | (1 << 6), 
    0 | (1 << 0) | (1 << 1) | (1 << 6), 
    0 | (1 << 7), 
    0 | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 3) | (1 << 4) | (1 << 6) | (1 << 7), 
    0 | (1 << 2) | (1 << 3) | (1 << 4), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3), 
    0 | (1 << 2) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 4), 
    0, 
    0, 
    0, 
    0 | (1 << 1) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 5) | (1 << 6), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 7), 
    0 | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4), 
    0, 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 7), 
    0 | (1 << 0) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 4) | (1 << 5) | (1 << 6), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 5) | (1 << 7), 
    0 | (1 << 2) | (1 << 5) | (1 << 7), 
    0 | (1 << 0), 
    0 | (1 << 4) | (1 << 5), 
    0, 
    0, 
    0 | (1 << 3), 
    0 | (1 << 1), 
    0, 
    0, 
    0 | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 5) | (1 << 6), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5), 
    0, 
    0, 
    0 | (1 << 0) | (1 << 2) | (1 << 6) | (1 << 7), 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0 | (1 << 6) | (1 << 7), 
    0 | (1 << 0), 
    0, 
    0 | (1 << 1) | (1 << 2), 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0 | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0, 
    0, 
    0, 
    0 | (1 << 4), 
    0, 
    0, 
    0 | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2), 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0 | (1 << 2), 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0 | (1 << 0) | (1 << 1), 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0 | (1 << 3), 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0 | (1 << 5) | (1 << 6), 
    0 | (1 << 7), 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0 | (1 << 4) | (1 << 5), 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0, 
    0 | (1 << 0) | (1 << 2) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 6) | (1 << 7), 
    0 | (1 << 0) | (1 << 2) | (1 << 3) | (1 << 6) | (1 << 7), 
    0 | (1 << 0)
  );
}


/// Returns true if the intrinsic is a leaf, i.e. it does not make any calls
/// itself.  Most intrinsics are leafs, the exceptions being the patchpoint
/// and statepoint intrinsics. These call (or invoke) their "target" argument.
//<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::isLeaf">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 916,
 FQN="llvm::Intrinsic::isLeaf", NM="_ZN4llvm9Intrinsic6isLeafENS0_2IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm9Intrinsic6isLeafENS0_2IDE")
//</editor-fold>
public static boolean isLeaf(/*Intrinsic.ID*/int id) {
  switch (id) {
   default:
    return true;
   case ID.experimental_gc_statepoint:
   case ID.experimental_patchpoint_void:
   case ID.experimental_patchpoint_i64:
    return false;
  }
}


/// Create or insert an LLVM Function declaration for an intrinsic, and return
/// it.
///
/// The Tys parameter is for intrinsics with overloaded types (e.g., those
/// using iAny, fAny, vAny, or iPTRAny).  For a declaration of an overloaded
/// intrinsic, Tys must provide exactly one type for each overloaded type in
/// the intrinsic.
//<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::getDeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 933,
 FQN="llvm::Intrinsic::getDeclaration", NM="_ZN4llvm9Intrinsic14getDeclarationEPNS_6ModuleENS0_2IDENS_8ArrayRefIPNS_4TypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm9Intrinsic14getDeclarationEPNS_6ModuleENS0_2IDENS_8ArrayRefIPNS_4TypeEEE")
//</editor-fold>
public static Function /*P*/ getDeclaration(Module /*P*/ M, /*Intrinsic.ID*/int id) {
  return getDeclaration(M, id, new ArrayRef<Type /*P*/ >(None, true));
}
public static Function /*P*/ getDeclaration(Module /*P*/ M, /*Intrinsic.ID*/int id, ArrayRef<Type /*P*/ > Tys/*= None*/) {
  // There can never be multiple globals with the same name of different types,
  // because intrinsics must be a specific type.
  return cast_Function(M.getOrInsertFunction(new StringRef(getName(id, new ArrayRef<Type /*P*/ >(Tys))), 
    IntrinsicGlobals.getType(M.getContext(), id, new ArrayRef<Type /*P*/ >(Tys))));
}


/// Return the IIT table descriptor for the specified intrinsic into an array
/// of IITDescriptors.
//<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::getIntrinsicInfoTableEntries">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 776,
 FQN="llvm::Intrinsic::getIntrinsicInfoTableEntries", NM="_ZN4llvm9Intrinsic28getIntrinsicInfoTableEntriesENS0_2IDERNS_15SmallVectorImplINS0_13IITDescriptorEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm9Intrinsic28getIntrinsicInfoTableEntriesENS0_2IDERNS_15SmallVectorImplINS0_13IITDescriptorEEE")
//</editor-fold>
public static void getIntrinsicInfoTableEntries(/*Intrinsic.ID*/int id, 
                            final SmallVectorImpl<IITDescriptor> /*&*/ T) {
  // Check to see if the intrinsic's type was expressible by the table.
  /*uint*/int TableVal = IntrinsicsGlobals.IIT_Table[id - 1];
  
  // Decode the TableVal into an array of IITValues.
  SmallVectorUChar IITValues/*J*/= new SmallVectorUChar(8, (/*uchar*/byte)0);
  ArrayRefUChar IITEntries/*J*/= new ArrayRefUChar();
  uint$ref NextElt = create_uint$ref(0);
  if ((TableVal >>> 31) != 0) {
    // This is an offset into the IIT_LongEncodingTable.
    IITEntries.$assignMove(new ArrayRefUChar(IntrinsicsGlobals.IIT_LongEncodingTable));
    
    // Strip sentinel bit.
    NextElt.$set((TableVal << 1) >>> 1);
  } else {
    // Decode the TableVal into an array of IITValues.  If the entry was encoded
    // into a single word in the table itself, decode it now.
    do {
      IITValues.push_back($uint2uchar(TableVal & 0xF));
      TableVal >>>= 4;
    } while ((TableVal != 0));
    
    IITEntries.$assignMove(new ArrayRefUChar(IITValues));
    NextElt.$set(0);
  }
  
  // Okay, decode the table into the output vector of IITDescriptors.
  FunctionStatics.DecodeIITType(NextElt, new ArrayRefUChar(IITEntries), T);
  while (NextElt.$deref() != IITEntries.size() && $uchar2int(IITEntries.$at(NextElt.$deref())) != 0) {
    FunctionStatics.DecodeIITType(NextElt, new ArrayRefUChar(IITEntries), T);
  }
}


/// Match the specified type (which comes from an intrinsic argument or return
/// value) with the type constraints specified by the .td file. If the given
/// type is an overloaded type it is pushed to the ArgTys vector.
///
/// Returns false if the given type matches with the constraints, true
/// otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::matchIntrinsicType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 951,
 FQN="llvm::Intrinsic::matchIntrinsicType", NM="_ZN4llvm9Intrinsic18matchIntrinsicTypeEPNS_4TypeERNS_8ArrayRefINS0_13IITDescriptorEEERNS_15SmallVectorImplIS2_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm9Intrinsic18matchIntrinsicTypeEPNS_4TypeERNS_8ArrayRefINS0_13IITDescriptorEEERNS_15SmallVectorImplIS2_EE")
//</editor-fold>
public static boolean matchIntrinsicType(Type /*P*/ Ty, final ArrayRef<IITDescriptor> /*&*/ Infos, 
                  final SmallVectorImpl<Type /*P*/ > /*&*/ ArgTys) {
  //JAVA: using namespace Intrinsic;
  
  // If we ran out of descriptors, there are too many arguments.
  if (Infos.empty()) {
    return true;
  }
  IITDescriptor D = new IITDescriptor(Infos.front());
  Infos.$assignMove(Infos.slice(1));
  switch (D.Kind) {
   case Void:
    return !Ty.isVoidTy();
   case VarArg:
    return true;
   case MMX:
    return !Ty.isX86_MMXTy();
   case Token:
    return !Ty.isTokenTy();
   case Metadata:
    return !Ty.isMetadataTy();
   case Half:
    return !Ty.isHalfTy();
   case Float:
    return !Ty.isFloatTy();
   case Double:
    return !Ty.isDoubleTy();
   case Integer:
    return !Ty.isIntegerTy(D.Unnamed_field1.Integer_Width);
   case Vector:
    {
      VectorType /*P*/ VT = dyn_cast_VectorType(Ty);
      return !(VT != null) || VT.getNumElements() != D.Unnamed_field1.Vector_Width
         || IntrinsicGlobals.matchIntrinsicType(VT.getElementType(), Infos, ArgTys);
    }
   case Pointer:
    {
      PointerType /*P*/ PT = dyn_cast_PointerType(Ty);
      return !(PT != null) || PT.getAddressSpace() != D.Unnamed_field1.Pointer_AddressSpace
         || IntrinsicGlobals.matchIntrinsicType(PT.getElementType(), Infos, ArgTys);
    }
   case Struct:
    {
      StructType /*P*/ ST = dyn_cast_StructType(Ty);
      if (!(ST != null) || ST.getNumElements() != D.Unnamed_field1.Struct_NumElements) {
        return true;
      }
      
      for (/*uint*/int i = 0, e = D.Unnamed_field1.Struct_NumElements; i != e; ++i)  {
        if (IntrinsicGlobals.matchIntrinsicType(ST.getElementType(i), Infos, ArgTys)) {
          return true;
        }
      }
      return false;
    }
   case Argument:
    // Two cases here - If this is the second occurrence of an argument, verify
    // that the later instance matches the previous instance.
    if ($less_uint(D.getArgumentNumber(), ArgTys.size())) {
      return Ty != ArgTys.$at(D.getArgumentNumber());
    }
    
    // Otherwise, if this is the first instance of an argument, record it and
    // verify the "Any" kind.
    assert (D.getArgumentNumber() == ArgTys.size()) : "Table consistency error";
    ArgTys.push_back(Ty);
    switch (D.getArgumentKind()) {
     case AK_Any:
      return false; // Success
     case AK_AnyInteger:
      return !Ty.isIntOrIntVectorTy();
     case AK_AnyFloat:
      return !Ty.isFPOrFPVectorTy();
     case AK_AnyVector:
      return !isa_VectorType(Ty);
     case AK_AnyPointer:
      return !isa_PointerType(Ty);
    }
    throw new llvm_unreachable("all argument kinds not covered");
   case ExtendArgument:
    {
      // This may only be used when referring to a previous vector argument.
      if ($greatereq_uint(D.getArgumentNumber(), ArgTys.size())) {
        return true;
      }
      
      Type /*P*/ NewTy = ArgTys.$at(D.getArgumentNumber());
      {
        VectorType /*P*/ VTy = dyn_cast_VectorType(NewTy);
        if ((VTy != null)) {
          NewTy = VectorType.getExtendedElementVectorType(VTy);
        } else {
          IntegerType /*P*/ ITy = dyn_cast_IntegerType(NewTy);
          if ((ITy != null)) {
            NewTy = IntegerType.get(ITy.getContext(), 2 * ITy.getBitWidth());
          } else {
            return true;
          }
        }
      }
      
      return Ty != NewTy;
    }
   case TruncArgument:
    {
      // This may only be used when referring to a previous vector argument.
      if ($greatereq_uint(D.getArgumentNumber(), ArgTys.size())) {
        return true;
      }
      
      Type /*P*/ NewTy = ArgTys.$at(D.getArgumentNumber());
      {
        VectorType /*P*/ VTy = dyn_cast_VectorType(NewTy);
        if ((VTy != null)) {
          NewTy = VectorType.getTruncatedElementVectorType(VTy);
        } else {
          IntegerType /*P*/ ITy = dyn_cast_IntegerType(NewTy);
          if ((ITy != null)) {
            NewTy = IntegerType.get(ITy.getContext(), $div_uint(ITy.getBitWidth(), 2));
          } else {
            return true;
          }
        }
      }
      
      return Ty != NewTy;
    }
   case HalfVecArgument:
    // This may only be used when referring to a previous vector argument.
    return $greatereq_uint(D.getArgumentNumber(), ArgTys.size())
       || !isa_VectorType(ArgTys.$at(D.getArgumentNumber()))
       || VectorType.getHalfElementsVectorType(cast_VectorType(ArgTys.$at(D.getArgumentNumber()))) != Ty;
   case SameVecWidthArgument:
    {
      if ($greatereq_uint(D.getArgumentNumber(), ArgTys.size())) {
        return true;
      }
      VectorType /*P*/ ReferenceType = dyn_cast_VectorType(ArgTys.$at(D.getArgumentNumber()));
      VectorType /*P*/ ThisArgType = dyn_cast_VectorType(Ty);
      if (!(ThisArgType != null) || !(ReferenceType != null)
         || (ReferenceType.getVectorNumElements()
         != ThisArgType.getVectorNumElements())) {
        return true;
      }
      return IntrinsicGlobals.matchIntrinsicType(ThisArgType.getVectorElementType(), 
          Infos, ArgTys);
    }
   case PtrToArgument:
    {
      if ($greatereq_uint(D.getArgumentNumber(), ArgTys.size())) {
        return true;
      }
      Type /*P*/ ReferenceType = ArgTys.$at(D.getArgumentNumber());
      PointerType /*P*/ ThisArgType = dyn_cast_PointerType(Ty);
      return (!(ThisArgType != null) || ThisArgType.getElementType() != ReferenceType);
    }
   case VecOfPtrsToElt:
    {
      if ($greatereq_uint(D.getArgumentNumber(), ArgTys.size())) {
        return true;
      }
      VectorType /*P*/ ReferenceType = dyn_cast_VectorType(ArgTys.$at(D.getArgumentNumber()));
      VectorType /*P*/ ThisArgVecTy = dyn_cast_VectorType(Ty);
      if (!(ThisArgVecTy != null) || !(ReferenceType != null)
         || (ReferenceType.getVectorNumElements()
         != ThisArgVecTy.getVectorNumElements())) {
        return true;
      }
      PointerType /*P*/ ThisArgEltTy = dyn_cast_PointerType(ThisArgVecTy.getVectorElementType());
      if (!(ThisArgEltTy != null)) {
        return true;
      }
      return ThisArgEltTy.getElementType()
         != ReferenceType.getVectorElementType();
    }
  }
  throw new llvm_unreachable("unhandled");
}


/// Verify if the intrinsic has variable arguments. This method is intended to
/// be called after all the fixed arguments have been matched first.
///
/// This method returns true on error.
//<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::matchIntrinsicVarArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 1089,
 FQN="llvm::Intrinsic::matchIntrinsicVarArg", NM="_ZN4llvm9Intrinsic20matchIntrinsicVarArgEbRNS_8ArrayRefINS0_13IITDescriptorEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm9Intrinsic20matchIntrinsicVarArgEbRNS_8ArrayRefINS0_13IITDescriptorEEE")
//</editor-fold>
public static boolean matchIntrinsicVarArg(boolean isVarArg, 
                    final ArrayRef<IITDescriptor> /*&*/ Infos) {
  // If there are no descriptors left, then it can't be a vararg.
  if (Infos.empty()) {
    return isVarArg;
  }
  
  // There should be only one descriptor remaining at this point.
  if (Infos.size() != 1) {
    return true;
  }
  
  // Check and verify the descriptor.
  IITDescriptor D = new IITDescriptor(Infos.front());
  Infos.$assignMove(Infos.slice(1));
  if (D.Kind == IITDescriptor.IITDescriptorKind.VarArg) {
    return !isVarArg;
  }
  
  return true;
}


// Checks if the intrinsic name matches with its signature and if not
// returns the declaration with the same signature and remangled name.
//<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::remangleIntrinsicFunction">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 1109,
 FQN="llvm::Intrinsic::remangleIntrinsicFunction", NM="_ZN4llvm9Intrinsic25remangleIntrinsicFunctionEPNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm9Intrinsic25remangleIntrinsicFunctionEPNS_8FunctionE")
//</editor-fold>
public static OptionalPtr<Function /*P*/ > remangleIntrinsicFunction(Function /*P*/ F) {
  /*Intrinsic.ID*/int ID = F.getIntrinsicID();
  if (!(ID != 0)) {
    return new OptionalPtr<Function /*P*/ >(None);
  }
  
  FunctionType /*P*/ FTy = F.getFunctionType();
  // Accumulate an array of overloaded types for the given intrinsic
  SmallVector<Type /*P*/ > ArgTys/*J*/= new SmallVector<Type /*P*/ >(4, (Type /*P*/ )null);
  {
    SmallVector<IITDescriptor> Table/*J*/= new SmallVector<IITDescriptor>(8, new IITDescriptor());
    IntrinsicGlobals.getIntrinsicInfoTableEntries(ID, Table);
    ArrayRef<IITDescriptor> TableRef = new ArrayRef<IITDescriptor>(Table, false);
    
    // If we encounter any problems matching the signature with the descriptor
    // just give up remangling. It's up to verifier to report the discrepancy.
    if (matchIntrinsicType(FTy.getReturnType(), TableRef, ArgTys)) {
      return new OptionalPtr<Function /*P*/ >(None);
    }
    for (Type /*P*/ Ty : FTy.params())  {
      if (matchIntrinsicType(Ty, TableRef, ArgTys)) {
        return new OptionalPtr<Function /*P*/ >(None);
      }
    }
    if (matchIntrinsicVarArg(FTy.isVarArg(), TableRef)) {
      return new OptionalPtr<Function /*P*/ >(None);
    }
  }
  
  StringRef Name = F.getName();
  if ($eq_StringRef(/*NO_COPY*/Name, new StringRef(getName(ID, new ArrayRef<Type /*P*/ >(ArgTys, true))))) {
    return new OptionalPtr<Function /*P*/ >(None);
  }
  
  Function /*P*/ NewDecl = getDeclaration(F.getParent(), ID, new ArrayRef<Type /*P*/ >(ArgTys, true));
  NewDecl.setCallingConv(F.getCallingConv());
  assert (NewDecl.getFunctionType() == FTy) : "Shouldn't change the signature";
  return new OptionalPtr<Function /*P*/ >(JD$T$RR.INSTANCE, NewDecl);
}

} // END OF class FunctionIntrinsicGlobals
