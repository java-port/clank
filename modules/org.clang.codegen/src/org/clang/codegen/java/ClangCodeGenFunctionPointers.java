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
package org.clang.codegen.java;

import org.clang.ast.CharUnits;
import org.clang.ast.Expr;
import org.clang.ast.FieldDecl;
import org.clang.ast.OMPClauseMappableExprCommon;
import org.clang.ast.ObjCIvarDecl;
import org.clang.ast.ObjCPropertyDecl;
import org.clang.ast.ValueDecl;
import org.clang.basic.OpenMPMapClauseKind;
import org.clang.codegen.CodeGen.impl.Address;
import org.clang.codegen.CodeGen.impl.CodeGenFunction;
import org.clang.codegen.CodeGen.impl.PrePostActionTy;
import org.clang.codegen.CodeGen.impl.RValue;
import org.clang.codegen.CodeGen.target.impl.TargetCodeGenInfo;
import org.clang.codegen.impl.BinOpInfo;
import org.llvm.adt.StringRef;
import org.llvm.adt.Twine;
import org.llvm.adt.aliases.ArrayRef;
import org.llvm.ir.CallInst;
import org.llvm.ir.CmpInst;
import org.llvm.ir.ConstantAsMetadata;
import org.llvm.ir.DiagnosticInfo;
import org.llvm.ir.Function;
import org.llvm.ir.GlobalVariable;
import org.llvm.ir.MDString;
import org.llvm.ir.Value;


public final class ClangCodeGenFunctionPointers {
  
  // using EnumerationCallback =
  //  llvm::function_ref<void(CharUnits offset, llvm::Type *type)>;
  @FunctionalInterface public static interface EnumerationCallback {
    void $call(CharUnits cu, org.llvm.ir.Type /*P*/ t); 
  }
  
  private ClangCodeGenFunctionPointers() { }
  
  @FunctionalInterface public static interface UIntCharUintTwine2Address {
    Address $call(int i, CharUnits cu, Twine /*&*/ t); 
  }
  @FunctionalInterface public static interface ValueCharUintTwine2Void {
    void $call(Value v, CharUnits cu, Twine /*&*/ t); 
  }
  @FunctionalInterface public static interface ValueUIntCharUintTwine2Void {
    void $call(Value v, int i, CharUnits cu, Twine /*&*/ t); 
  }
  
  @FunctionalInterface
  public static interface Address2Value {
    Value /*P*/ $call(Address a);
  }  
  
  @FunctionalInterface
  public static interface IntUInt2CallInst {
    CallInst /*P*/ $call(/*Intrinsic.ID*/int ID, /*uint*/int I);
  }  
  
  @FunctionalInterface
  public static interface Predicate2Value {
    Value /*P*/ $call(CmpInst.Predicate P);
  }
  @FunctionalInterface
  public static interface UInt2CallInst {
    CallInst /*P*/ $call(/*uint*/int I);
  }
  @FunctionalInterface
  public static interface UInt2Address {
    Address $call(/*uint*/int I);
  }
  @FunctionalInterface
  public static interface Void2RValue {
    RValue $call();
  }
  @FunctionalInterface
  public static interface UIntExpr2Void {
    void $call(/*uint*/int I, /*const*/ Expr /*P*/ E);
  }
  @FunctionalInterface
  public static interface BinOpInfo2Value {
    Value /*P*/ $call(/*const*/ BinOpInfo /*&*/ I);
  }
  @FunctionalInterface
  public static interface CodeGenFunctionPrePostActionTy2Void {
    void /*P*/ $call(CodeGenFunction /*&*/ F, PrePostActionTy /*&*/ A);
  }
  @FunctionalInterface
  public static interface Void2ArrayRef<T> {
    ArrayRef<T> $call();
  }

  @FunctionalInterface
  public static interface TargetCodeGenInfo2TargetCodeGenInfo {
    /*const*/ TargetCodeGenInfo /*&*/ $call(TargetCodeGenInfo /*P*/ P1);
  }
  
  @FunctionalInterface
  public static interface Function2GlobalVariable {
    GlobalVariable $call(Function P1);
  }

  @FunctionalInterface
  public static interface ValueDeclArrayRefEtc2Void {
    void $call(ValueDecl /*P*/ D, ArrayRef<OMPClauseMappableExprCommon.MappableComponent> L, OpenMPMapClauseKind MapType, OpenMPMapClauseKind MapModifier);
  }  

  @FunctionalInterface
  public static interface ObjCPropertyDecl2Void {
    void $call(/*const*/ ObjCPropertyDecl /*P*/ P1);
  }

  @FunctionalInterface
  public static interface UInt2ConstantAsMetadata {
    ConstantAsMetadata /*P*/ $call(/*uint*/int P1);
  }

  @FunctionalInterface
  public static interface StringRef2MDString {
    MDString /*P*/ $call(StringRef P1);
  }

  @FunctionalInterface
  public static interface UInt2StringRef {
    StringRef $call(/*uint*/int P1);
  }

  @FunctionalInterface
  public static interface UInt2UInt64 {
    long $call(/*uint*/int P1);
  }

  @FunctionalInterface
  public static interface Value2Address {
    Address $call(Value /*P*/  P1);
  }
  
  @FunctionalInterface
  public static interface FieldDecl2CharUnits<T extends FieldDecl> {
    CharUnits $call(T /*P*/  P1);
  }
  
  @FunctionalInterface
  public static interface ObjCIvarDecl2CharUnits extends FieldDecl2CharUnits<ObjCIvarDecl>{
  }
  
  @FunctionalInterface
  public static interface DiagnosticInfo2Void {
    void $call(DiagnosticInfo /*P*/  P1);
  }

  public @FunctionalInterface interface SupplierEx<T> { 
    T $call(Object... A);  
  }  
}
