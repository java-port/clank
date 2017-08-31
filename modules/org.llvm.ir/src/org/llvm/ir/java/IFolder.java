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

package org.llvm.ir.java;

import org.clank.support.NativeCloneable;
import org.llvm.adt.aliases.ArrayRef;
import org.llvm.adt.aliases.ArrayRefUInt;
import org.llvm.ir.CmpInst;
import org.llvm.ir.Constant;
import org.llvm.ir.Instruction;
import org.llvm.ir.Type;
import org.llvm.ir.User;
import org.llvm.ir.Value;

/**
 * A common interface for ConstantFolder, TargetFolder and NoFolder.
 * Only NoFolder (which is used veru rare) uses different ParamTy and RetTy.
 * For both ConstantFolder use Constant as both TargetFolder ParamTy and RetTy
 * @author vkvashin
 */
public interface IFolder<ParamTy extends Value, RetTy extends User> extends NativeCloneable<IFolder<ParamTy, RetTy>> {

  /** This method will be used instead of copy constructor */
  IFolder<ParamTy, RetTy> clone();

  default RetTy /*P*/ CreateAdd(ParamTy /*P*/ LHS, ParamTy /*P*/ RHS) /*const*/ {
    return CreateAdd(LHS, RHS, false, false);
  }
  default RetTy /*P*/ CreateAdd(ParamTy /*P*/ LHS, ParamTy /*P*/ RHS, boolean HasNUW/*= false*/) /*const*/ {
    return CreateAdd(LHS, RHS, HasNUW, false);
  }
  RetTy /*P*/ CreateAdd(ParamTy /*P*/ LHS, ParamTy /*P*/ RHS, boolean HasNUW/*= false*/, boolean HasNSW/*= false*/) /*const*/;

  
  ParamTy /*P*/ CreateGetElementPtr(Type /*P*/ Ty, ParamTy /*P*/ C, ParamTy /*P*/ Idx) /*const*/;


  default RetTy /*P*/ CreateSub(ParamTy /*P*/ LHS, ParamTy /*P*/ RHS) /*const*/ {
    return CreateSub(LHS, RHS, false, false);
  }
  default RetTy /*P*/ CreateSub(ParamTy /*P*/ LHS, ParamTy /*P*/ RHS, boolean HasNUW/*= false*/) /*const*/ {
    return CreateSub(LHS, RHS, HasNUW, false);
  }
  RetTy /*P*/ CreateSub(ParamTy /*P*/ LHS, ParamTy /*P*/ RHS, boolean HasNUW/*= false*/, boolean HasNSW/*= false*/) /*const*/;


  RetTy /*P*/ CreateFSub(ParamTy /*P*/ LHS, ParamTy /*P*/ RHS) /*const*/;


  default RetTy /*P*/ CreateMul(ParamTy /*P*/ LHS, ParamTy /*P*/ RHS) /*const*/ {
    return CreateMul(LHS, RHS, false, false);
  }
  default RetTy /*P*/ CreateMul(ParamTy /*P*/ LHS, ParamTy /*P*/ RHS,
                  boolean HasNUW/*= false*/) /*const*/ {
    return CreateMul(LHS, RHS, HasNUW, false);
  }
  RetTy /*P*/ CreateMul(ParamTy /*P*/ LHS, ParamTy /*P*/ RHS, boolean HasNUW/*= false*/, boolean HasNSW/*= false*/) /*const*/;

  RetTy /*P*/ CreateFMul(ParamTy /*P*/ LHS, ParamTy /*P*/ RHS) /*const*/;

  default RetTy /*P*/ CreateUDiv(ParamTy /*P*/ LHS, ParamTy /*P*/ RHS) /*const*/ {
    return CreateUDiv(LHS, RHS, false);
  }
  RetTy /*P*/ CreateUDiv(ParamTy /*P*/ LHS, ParamTy /*P*/ RHS, boolean isExact/*= false*/) /*const*/;

  
  default RetTy /*P*/ CreateSDiv(ParamTy /*P*/ LHS, ParamTy /*P*/ RHS) /*const*/ {
    return CreateSDiv(LHS, RHS, false);
  }
  RetTy /*P*/ CreateSDiv(ParamTy /*P*/ LHS, ParamTy /*P*/ RHS, boolean isExact/*= false*/) /*const*/;


  RetTy /*P*/ CreateFDiv(ParamTy /*P*/ LHS, ParamTy /*P*/ RHS) /*const*/;

  RetTy /*P*/ CreateURem(ParamTy /*P*/ LHS, ParamTy /*P*/ RHS) /*const*/;

  RetTy /*P*/ CreateSRem(ParamTy /*P*/ LHS, ParamTy /*P*/ RHS) /*const*/ ;

  RetTy /*P*/ CreateFRem(ParamTy /*P*/ LHS, ParamTy /*P*/ RHS) /*const*/;


  default RetTy /*P*/ CreateShl(ParamTy /*P*/ LHS, ParamTy /*P*/ RHS) /*const*/ {
    return CreateShl(LHS, RHS,
           false, false);
  }
  default RetTy /*P*/ CreateShl(ParamTy /*P*/ LHS, ParamTy /*P*/ RHS,
           boolean HasNUW/*= false*/) /*const*/ {
    return CreateShl(LHS, RHS,
           HasNUW, false);
  }
  RetTy /*P*/ CreateShl(ParamTy /*P*/ LHS, ParamTy /*P*/ RHS, boolean HasNUW/*= false*/, boolean HasNSW/*= false*/) /*const*/;


  default RetTy /*P*/ CreateLShr(ParamTy /*P*/ LHS, ParamTy /*P*/ RHS) /*const*/ {
    return CreateLShr(LHS, RHS,
            false);
  }
  RetTy /*P*/ CreateLShr(ParamTy /*P*/ LHS, ParamTy /*P*/ RHS, boolean isExact/*= false*/) /*const*/;
  

  default RetTy /*P*/ CreateAShr(ParamTy /*P*/ LHS, ParamTy /*P*/ RHS) /*const*/ {
    return CreateAShr(LHS, RHS,
            false);
  }
  public RetTy /*P*/ CreateAShr(ParamTy /*P*/ LHS, ParamTy /*P*/ RHS,
            boolean isExact/*= false*/) /*const*/;


  RetTy /*P*/ CreateAnd(ParamTy /*P*/ LHS, ParamTy /*P*/ RHS) /*const*/;

  RetTy /*P*/ CreateOr(ParamTy /*P*/ LHS, ParamTy /*P*/ RHS) /*const*/;

  RetTy /*P*/ CreateXor(ParamTy /*P*/ LHS, ParamTy /*P*/ RHS) /*const*/;

  RetTy /*P*/ CreateBinOp(/*BinaryOps*/int Opc, ParamTy /*P*/ LHS, ParamTy /*P*/ RHS) /*const*/;


  default RetTy /*P*/ CreateNeg(ParamTy /*P*/ C) /*const*/ {
    return CreateNeg(C, false, false);
  }
  default RetTy /*P*/ CreateNeg(ParamTy /*P*/ C, boolean HasNUW/*= false*/) /*const*/ {
    return CreateNeg(C, HasNUW, false);
  }
  public RetTy /*P*/ CreateNeg(ParamTy /*P*/ C, boolean HasNUW/*= false*/, boolean HasNSW/*= false*/) /*const*/;


  RetTy /*P*/ CreateFNeg(ParamTy /*P*/ C) /*const*/;

  RetTy /*P*/ CreateNot(ParamTy /*P*/ C) /*const*/;

  RetTy /*P*/ CreateGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P(
          Type /*P*/ Ty, Constant /*P*/ C, ArrayRef<Value /*P*/ > IdxList) /*const*/;

  ParamTy /*P*/ CreateInBoundsGetElementPtr(
          Type /*P*/ Ty, ParamTy /*P*/ C, ParamTy /*P*/ Idx) /*const*/;

  RetTy /*P*/ CreateZExtOrBitCast(ParamTy /*P*/ C, Type /*P*/ DestTy) /*const*/;

  RetTy /*P*/ CreateSExtOrBitCast(ParamTy /*P*/ C, Type /*P*/ DestTy) /*const*/;

  RetTy /*P*/ CreateTruncOrBitCast(ParamTy /*P*/ C, Type /*P*/ DestTy) /*const*/;

  RetTy /*P*/ CreateCast(/*CastOps*/int Op, ParamTy /*P*/ C, Type /*P*/ DestTy) /*const*/;

  RetTy /*P*/ CreatePointerCast(ParamTy /*P*/ C, Type /*P*/ DestTy) /*const*/;

  RetTy /*P*/ CreatePointerBitCastOrAddrSpaceCast(ParamTy /*P*/ C, Type /*P*/ DestTy) /*const*/;

  RetTy /*P*/ CreateIntCast(ParamTy /*P*/ C, Type /*P*/ DestTy, boolean isSigned) /*const*/;

  RetTy /*P*/ CreateFPCast(ParamTy /*P*/ C, Type /*P*/ DestTy) /*const*/;

  RetTy /*P*/ CreateICmp(CmpInst.Predicate P, ParamTy /*P*/ LHS, ParamTy /*P*/ RHS) /*const*/;

  RetTy /*P*/ CreateFCmp(CmpInst.Predicate P, ParamTy /*P*/ LHS, ParamTy /*P*/ RHS) /*const*/;

  RetTy /*P*/ CreateSelect(ParamTy /*P*/ C, ParamTy /*P*/ True, ParamTy /*P*/ False) /*const*/;

  RetTy /*P*/ CreateExtractElement(ParamTy /*P*/ Vec, ParamTy /*P*/ Idx) /*const*/;

  RetTy /*P*/ CreateInsertElement(ParamTy /*P*/ Vec, ParamTy /*P*/ NewElt, ParamTy /*P*/ Idx) /*const*/;

  RetTy /*P*/ CreateShuffleVector(ParamTy /*P*/ V1, ParamTy /*P*/ V2, ParamTy /*P*/ Mask) /*const*/;

  RetTy /*P*/ CreateExtractValue(ParamTy /*P*/ Agg, ArrayRefUInt IdxList) /*const*/;

  RetTy /*P*/ CreateInsertValue(ParamTy /*P*/ Agg, ParamTy /*P*/ Val, ArrayRefUInt IdxList) /*const*/;
}
