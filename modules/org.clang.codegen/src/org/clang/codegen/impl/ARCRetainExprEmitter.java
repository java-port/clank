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
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.codegen.impl.CGObjCStatics.*;


/// An emitter for +1 results.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCRetainExprEmitter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2821,
 FQN="(anonymous namespace)::ARCRetainExprEmitter", NM="_ZN12_GLOBAL__N_120ARCRetainExprEmitterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_120ARCRetainExprEmitterE")
//</editor-fold>
public class/*struct*/ ARCRetainExprEmitter extends /*public*/ ARCExprEmitter<ARCRetainExprEmitter, PointerBoolPair<Value /*P*/ > > {
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCRetainExprEmitter::ARCRetainExprEmitter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2824,
   FQN="(anonymous namespace)::ARCRetainExprEmitter::ARCRetainExprEmitter", NM="_ZN12_GLOBAL__N_120ARCRetainExprEmitterC1ERN5clang7CodeGen15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_120ARCRetainExprEmitterC1ERN5clang7CodeGen15CodeGenFunctionE")
  //</editor-fold>
  public ARCRetainExprEmitter(final CodeGenFunction /*&*/ CGF) {
    // : ARCExprEmitter<ARCRetainExprEmitter, PointerIntPair<Value * , 1, bool, PointerLikeTypeTraitsValue *, PointerIntPairInfo<Value * , 1, PointerLikeTypeTraitsValue *> > >(CGF) 
    //START JInit
    super(CGF);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCRetainExprEmitter::getValueOfResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2826,
   FQN="(anonymous namespace)::ARCRetainExprEmitter::getValueOfResult", NM="_ZN12_GLOBAL__N_120ARCRetainExprEmitter16getValueOfResultEN4llvm14PointerIntPairIPNS1_5ValueELj1EbNS1_21PointerLikeTypeTraitsIS4_EENS1_18PointerIntPairInfoIS4_Lj1ES6_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_120ARCRetainExprEmitter16getValueOfResultEN4llvm14PointerIntPairIPNS1_5ValueELj1EbNS1_21PointerLikeTypeTraitsIS4_EENS1_18PointerIntPairInfoIS4_Lj1ES6_EEEE")
  //</editor-fold>
  public Value /*P*/ getValueOfResult(PointerBoolPair<Value /*P*/ > result) {
    return result.getPointer();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCRetainExprEmitter::emitBitCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2830,
   FQN="(anonymous namespace)::ARCRetainExprEmitter::emitBitCast", NM="_ZN12_GLOBAL__N_120ARCRetainExprEmitter11emitBitCastEN4llvm14PointerIntPairIPNS1_5ValueELj1EbNS1_21PointerLikeTypeTraitsIS4_EENS1_18PointerIntPairInfoIS4_Lj1ES6_EEEEPNS1_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_120ARCRetainExprEmitter11emitBitCastEN4llvm14PointerIntPairIPNS1_5ValueELj1EbNS1_21PointerLikeTypeTraitsIS4_EENS1_18PointerIntPairInfoIS4_Lj1ES6_EEEEPNS1_4TypeE")
  //</editor-fold>
  public PointerBoolPair<Value /*P*/ > emitBitCast(PointerBoolPair<Value /*P*/ > result, org.llvm.ir.Type /*P*/ resultType) {
    Value /*P*/ value = result.getPointer();
    value = CGF.Builder.CreateBitCast(value, resultType);
    result.setPointer(value);
    return new PointerBoolPair<Value /*P*/ >(JD$Move.INSTANCE, result);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCRetainExprEmitter::visitLValueToRValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2837,
   FQN="(anonymous namespace)::ARCRetainExprEmitter::visitLValueToRValue", NM="_ZN12_GLOBAL__N_120ARCRetainExprEmitter19visitLValueToRValueEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_120ARCRetainExprEmitter19visitLValueToRValueEPKN5clang4ExprE")
  //</editor-fold>
  public PointerBoolPair<Value /*P*/ > visitLValueToRValue(/*const*/ Expr /*P*/ e) {
    return tryEmitARCRetainLoadOfScalar(CGF, e);
  }

  
  /// For consumptions, just emit the subexpression and thus elide
  /// the retain/release pair.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCRetainExprEmitter::visitConsumeObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2843,
   FQN="(anonymous namespace)::ARCRetainExprEmitter::visitConsumeObject", NM="_ZN12_GLOBAL__N_120ARCRetainExprEmitter18visitConsumeObjectEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_120ARCRetainExprEmitter18visitConsumeObjectEPKN5clang4ExprE")
  //</editor-fold>
  public PointerBoolPair<Value /*P*/ > visitConsumeObject(/*const*/ Expr /*P*/ e) {
    Value /*P*/ result = CGF.EmitScalarExpr(e);
    return new PointerBoolPair<Value /*P*/ >(result, true);
  }

  
  /// Block extends are net +0.  Naively, we could just recurse on
  /// the subexpression, but actually we need to ensure that the
  /// value is copied as a block, so there's a little filter here.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCRetainExprEmitter::visitExtendBlockObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2851,
   FQN="(anonymous namespace)::ARCRetainExprEmitter::visitExtendBlockObject", NM="_ZN12_GLOBAL__N_120ARCRetainExprEmitter22visitExtendBlockObjectEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_120ARCRetainExprEmitter22visitExtendBlockObjectEPKN5clang4ExprE")
  //</editor-fold>
  public PointerBoolPair<Value /*P*/ > visitExtendBlockObject(/*const*/ Expr /*P*/ e) {
    Value /*P*/ result; // will be a +0 value
    
    // If we can't safely assume the sub-expression will produce a
    // block-copied value, emit the sub-expression at +0.
    if (shouldEmitSeparateBlockRetain(e)) {
      result = CGF.EmitScalarExpr(e);
      // Otherwise, try to emit the sub-expression at +1 recursively.
    } else {
      PointerBoolPair<Value /*P*/ > subresult = asImpl().visit(e);
      
      // If that produced a retained value, just use that.
      if (subresult.getInt()) {
        return subresult;
      }
      
      // Otherwise it's +0.
      result = subresult.getPointer();
    }
    
    // Retain the object as a block.
    result = CGF.EmitARCRetainBlock(result, /*mandatory*/ true);
    return new PointerBoolPair<Value /*P*/ >(result, true);
  }

  
  /// For reclaims, emit the subexpression as a retained call and
  /// skip the consumption.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCRetainExprEmitter::visitReclaimReturnedObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2879,
   FQN="(anonymous namespace)::ARCRetainExprEmitter::visitReclaimReturnedObject", NM="_ZN12_GLOBAL__N_120ARCRetainExprEmitter26visitReclaimReturnedObjectEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_120ARCRetainExprEmitter26visitReclaimReturnedObjectEPKN5clang4ExprE")
  //</editor-fold>
  public PointerBoolPair<Value /*P*/ > visitReclaimReturnedObject(/*const*/ Expr /*P*/ e) {
    Value /*P*/ result = emitARCRetainCallResult(CGF, e);
    return new PointerBoolPair<Value /*P*/ >(result, true);
  }

  
  /// When we have an undecorated call, retroactively do a claim.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCRetainExprEmitter::visitCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2885,
   FQN="(anonymous namespace)::ARCRetainExprEmitter::visitCall", NM="_ZN12_GLOBAL__N_120ARCRetainExprEmitter9visitCallEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_120ARCRetainExprEmitter9visitCallEPKN5clang4ExprE")
  //</editor-fold>
  public PointerBoolPair<Value /*P*/ > visitCall(/*const*/ Expr /*P*/ e) {
    Value /*P*/ result = emitARCRetainCallResult(CGF, e);
    return new PointerBoolPair<Value /*P*/ >(result, true);
  }

  
  // TODO: maybe special-case visitBinAssignWeak?
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCRetainExprEmitter::visitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2892,
   FQN="(anonymous namespace)::ARCRetainExprEmitter::visitExpr", NM="_ZN12_GLOBAL__N_120ARCRetainExprEmitter9visitExprEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_120ARCRetainExprEmitter9visitExprEPKN5clang4ExprE")
  //</editor-fold>
  public PointerBoolPair<Value /*P*/ > visitExpr(/*const*/ Expr /*P*/ e) {
    // We didn't find an obvious production, so emit what we've got and
    // tell the caller that we didn't manage to retain.
    Value /*P*/ result = CGF.EmitScalarExpr(e);
    return new PointerBoolPair<Value /*P*/ >(result, false);
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
