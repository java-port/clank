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

package org.clang.codegen.impl;

import org.clank.support.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;


/// An emitter for assigning into an __unsafe_unretained context.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCUnsafeUnretainedExprEmitter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2990,
 FQN="(anonymous namespace)::ARCUnsafeUnretainedExprEmitter", NM="_ZN12_GLOBAL__N_130ARCUnsafeUnretainedExprEmitterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_130ARCUnsafeUnretainedExprEmitterE")
//</editor-fold>
public class/*struct*/ ARCUnsafeUnretainedExprEmitter extends /*public*/ ARCExprEmitter<ARCUnsafeUnretainedExprEmitter, Value /*P*/ > {
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCUnsafeUnretainedExprEmitter::ARCUnsafeUnretainedExprEmitter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2993,
   FQN="(anonymous namespace)::ARCUnsafeUnretainedExprEmitter::ARCUnsafeUnretainedExprEmitter", NM="_ZN12_GLOBAL__N_130ARCUnsafeUnretainedExprEmitterC1ERN5clang7CodeGen15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_130ARCUnsafeUnretainedExprEmitterC1ERN5clang7CodeGen15CodeGenFunctionE")
  //</editor-fold>
  public ARCUnsafeUnretainedExprEmitter(final CodeGenFunction /*&*/ CGF) {
    // : ARCExprEmitter<ARCUnsafeUnretainedExprEmitter, Value * >(CGF) 
    //START JInit
    super(CGF);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCUnsafeUnretainedExprEmitter::getValueOfResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2995,
   FQN="(anonymous namespace)::ARCUnsafeUnretainedExprEmitter::getValueOfResult", NM="_ZN12_GLOBAL__N_130ARCUnsafeUnretainedExprEmitter16getValueOfResultEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_130ARCUnsafeUnretainedExprEmitter16getValueOfResultEPN4llvm5ValueE")
  //</editor-fold>
  public Value /*P*/ getValueOfResult(Value /*P*/ value) {
    return value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCUnsafeUnretainedExprEmitter::emitBitCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2999,
   FQN="(anonymous namespace)::ARCUnsafeUnretainedExprEmitter::emitBitCast", NM="_ZN12_GLOBAL__N_130ARCUnsafeUnretainedExprEmitter11emitBitCastEPN4llvm5ValueEPNS1_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_130ARCUnsafeUnretainedExprEmitter11emitBitCastEPN4llvm5ValueEPNS1_4TypeE")
  //</editor-fold>
  public Value /*P*/ emitBitCast(Value /*P*/ value, org.llvm.ir.Type /*P*/ resultType) {
    return CGF.Builder.CreateBitCast(value, resultType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCUnsafeUnretainedExprEmitter::visitLValueToRValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 3003,
   FQN="(anonymous namespace)::ARCUnsafeUnretainedExprEmitter::visitLValueToRValue", NM="_ZN12_GLOBAL__N_130ARCUnsafeUnretainedExprEmitter19visitLValueToRValueEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_130ARCUnsafeUnretainedExprEmitter19visitLValueToRValueEPKN5clang4ExprE")
  //</editor-fold>
  public Value /*P*/ visitLValueToRValue(/*const*/ Expr /*P*/ e) {
    return CGF.EmitScalarExpr(e);
  }

  
  /// For consumptions, just emit the subexpression and perform the
  /// consumption like normal.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCUnsafeUnretainedExprEmitter::visitConsumeObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 3009,
   FQN="(anonymous namespace)::ARCUnsafeUnretainedExprEmitter::visitConsumeObject", NM="_ZN12_GLOBAL__N_130ARCUnsafeUnretainedExprEmitter18visitConsumeObjectEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_130ARCUnsafeUnretainedExprEmitter18visitConsumeObjectEPKN5clang4ExprE")
  //</editor-fold>
  public Value /*P*/ visitConsumeObject(/*const*/ Expr /*P*/ e) {
    Value /*P*/ value = CGF.EmitScalarExpr(e);
    return CGF.EmitObjCConsumeObject(e.getType(), value);
  }

  
  /// No special logic for block extensions.  (This probably can't
  /// actually happen in this emitter, though.)
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCUnsafeUnretainedExprEmitter::visitExtendBlockObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 3016,
   FQN="(anonymous namespace)::ARCUnsafeUnretainedExprEmitter::visitExtendBlockObject", NM="_ZN12_GLOBAL__N_130ARCUnsafeUnretainedExprEmitter22visitExtendBlockObjectEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_130ARCUnsafeUnretainedExprEmitter22visitExtendBlockObjectEPKN5clang4ExprE")
  //</editor-fold>
  public Value /*P*/ visitExtendBlockObject(/*const*/ Expr /*P*/ e) {
    return CGF.EmitARCExtendBlockObject(e);
  }

  
  /// For reclaims, perform an unsafeClaim if that's enabled.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCUnsafeUnretainedExprEmitter::visitReclaimReturnedObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 3021,
   FQN="(anonymous namespace)::ARCUnsafeUnretainedExprEmitter::visitReclaimReturnedObject", NM="_ZN12_GLOBAL__N_130ARCUnsafeUnretainedExprEmitter26visitReclaimReturnedObjectEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_130ARCUnsafeUnretainedExprEmitter26visitReclaimReturnedObjectEPKN5clang4ExprE")
  //</editor-fold>
  public Value /*P*/ visitReclaimReturnedObject(/*const*/ Expr /*P*/ e) {
    return CGF.EmitARCReclaimReturnedObject(e, /*unsafe*/ true);
  }

  
  /// When we have an undecorated call, just emit it without adding
  /// the unsafeClaim.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCUnsafeUnretainedExprEmitter::visitCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 3027,
   FQN="(anonymous namespace)::ARCUnsafeUnretainedExprEmitter::visitCall", NM="_ZN12_GLOBAL__N_130ARCUnsafeUnretainedExprEmitter9visitCallEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_130ARCUnsafeUnretainedExprEmitter9visitCallEPKN5clang4ExprE")
  //</editor-fold>
  public Value /*P*/ visitCall(/*const*/ Expr /*P*/ e) {
    return CGF.EmitScalarExpr(e);
  }

  
  /// Just do normal scalar emission in the default case.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCUnsafeUnretainedExprEmitter::visitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 3032,
   FQN="(anonymous namespace)::ARCUnsafeUnretainedExprEmitter::visitExpr", NM="_ZN12_GLOBAL__N_130ARCUnsafeUnretainedExprEmitter9visitExprEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_130ARCUnsafeUnretainedExprEmitter9visitExprEPKN5clang4ExprE")
  //</editor-fold>
  public Value /*P*/ visitExpr(/*const*/ Expr /*P*/ e) {
    return CGF.EmitScalarExpr(e);
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
