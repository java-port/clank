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
package org.llvm.ir.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type ValueStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.ValueStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=Tpl__ZN12_GLOBAL__N_1L27stripPointerCastsAndOffsetsEPN4llvm5ValueE;_ZL8containsPN4llvm5ValueES1_;_ZL8containsRN4llvm15SmallPtrSetImplIPNS_12ConstantExprEEES2_PNS_8ConstantE;_ZL9checkTypePN4llvm4TypeE;_ZL9getSymTabPN4llvm5ValueERPNS_16ValueSymbolTableE; -static-type=ValueStatics -package=org.llvm.ir.impl")
//</editor-fold>
public final class ValueStatics {


//===----------------------------------------------------------------------===//
//                                Value Class
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="checkType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 43,
 FQN="checkType", NM="_ZL9checkTypePN4llvm4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZL9checkTypePN4llvm4TypeE")
//</editor-fold>
public static /*inline*/ Type /*P*/ checkType(Type /*P*/ Ty) {
  assert ((Ty != null)) : "Value defined with a null type: Error!";
  return Ty;
}

//<editor-fold defaultstate="collapsed" desc="getSymTab">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 141,
 FQN="getSymTab", NM="_ZL9getSymTabPN4llvm5ValueERPNS_16ValueSymbolTableE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZL9getSymTabPN4llvm5ValueERPNS_16ValueSymbolTableE")
//</editor-fold>
public static boolean getSymTab(Value /*P*/ V, final type$ref<ValueSymbolTable /*P*/ /*&*/> ST) {
  ST.$set(null);
  {
    Instruction /*P*/ I = dyn_cast_Instruction(V);
    if ((I != null)) {
      {
        BasicBlock /*P*/ P = I.getParent();
        if ((P != null)) {
          {
            Function /*P*/ PP = P.getParent();
            if ((PP != null)) {
              ST.$set($AddrOf(PP.getValueSymbolTable()));
            }
          }
        }
      }
    } else {
      BasicBlock /*P*/ BB = dyn_cast_BasicBlock(V);
      if ((BB != null)) {
        {
          Function /*P*/ P = BB.getParent();
          if ((P != null)) {
            ST.$set($AddrOf(P.getValueSymbolTable()));
          }
        }
      } else {
        GlobalValue /*P*/ GV = dyn_cast_GlobalValue(V);
        if ((GV != null)) {
          {
            Module /*P*/ P = GV.getParent();
            if ((P != null)) {
              ST.$set($AddrOf(P.getValueSymbolTable()));
            }
          }
        } else {
          Argument /*P*/ A = dyn_cast_Argument(V);
          if ((A != null)) {
            {
              Function /*P*/ P = A.getParent();
              if ((P != null)) {
                ST.$set($AddrOf(P.getValueSymbolTable()));
              }
            }
          } else {
            assert (isa_Constant(V)) : "Unknown value type!";
            return true; // no name is setable for this.
          }
        }
      }
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="contains">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 336,
 FQN="contains", NM="_ZL8containsRN4llvm15SmallPtrSetImplIPNS_12ConstantExprEEES2_PNS_8ConstantE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZL8containsRN4llvm15SmallPtrSetImplIPNS_12ConstantExprEEES2_PNS_8ConstantE")
//</editor-fold>
public static boolean contains(final SmallPtrSetImpl<ConstantExpr /*P*/ > /*&*/ Cache, ConstantExpr /*P*/ Expr, 
        Constant /*P*/ C) {
  if (!Cache.insert(Expr).second) {
    return false;
  }
  
  for (final Use /*&*/ O : Expr.operands()) {
    if (O.$Value$P() == C) {
      return true;
    }
    ConstantExpr /*P*/ CE = dyn_cast_ConstantExpr(O);
    if (!(CE != null)) {
      continue;
    }
    if (contains(Cache, CE, C)) {
      return true;
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="contains">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 353,
 FQN="contains", NM="_ZL8containsPN4llvm5ValueES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZL8containsPN4llvm5ValueES1_")
//</editor-fold>
public static boolean contains(Value /*P*/ Expr, Value /*P*/ V) {
  if (Expr == V) {
    return true;
  }
  
  Constant /*P*/ C = dyn_cast_Constant(V);
  if (!(C != null)) {
    return false;
  }
  
  ConstantExpr /*P*/ CE = dyn_cast_ConstantExpr(Expr);
  if (!(CE != null)) {
    return false;
  }
  
  SmallPtrSet<ConstantExpr /*P*/ > Cache/*J*/= new SmallPtrSet<ConstantExpr /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
  return contains(Cache, CE, C);
}

/*template <PointerStripKind StripKind> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::stripPointerCastsAndOffsets">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Value.cpp", line = 432,
 FQN="(anonymous namespace)::stripPointerCastsAndOffsets", NM="Tpl__ZN12_GLOBAL__N_1L27stripPointerCastsAndOffsetsEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=Tpl__ZN12_GLOBAL__N_1L27stripPointerCastsAndOffsetsEPN4llvm5ValueE")
//</editor-fold>
public static Value /*P*/ stripPointerCastsAndOffsets(PointerStripKind StripKind, Value /*P*/ V) {
  if (!V.getType().isPointerTy()) {
    return V;
  }
  
  // Even though we don't look through PHI nodes, we could be called on an
  // instruction in an unreachable block, which may be on a cycle.
  SmallPtrSet<Value /*P*/ > Visited/*J*/= new SmallPtrSet<Value /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
  
  Visited.insert(V);
  do {
    {
      GEPOperator /*P*/ GEP = dyn_cast_GEPOperator(V);
      if ((GEP != null)) {
        switch (StripKind) {
         case PSK_ZeroIndicesAndAliases:
         case PSK_ZeroIndices:
          if (!GEP.hasAllZeroIndices()) {
            return V;
          }
          break;
         case PSK_InBoundsConstantIndices:
          if (!GEP.hasAllConstantIndices()) {
            return V;
          }
         case PSK_InBounds:
          // fallthrough
          if (!GEP.isInBounds()) {
            return V;
          }
          break;
        }
        V = GEP.getPointerOperand();
      } else if (Operator.getOpcode(V) == Instruction.CastOps.BitCast
         || Operator.getOpcode(V) == Instruction.CastOps.AddrSpaceCast) {
        //JAVA: cast_User is enough, because not all is Operator, but only getOperand(0)
        // is needed here. In C++ it's OK to const_cast to anything
        V = /*cast_Operator*/cast_User(V).getOperand(0);
      } else {
        GlobalAlias /*P*/ GA = dyn_cast_GlobalAlias(V);
        if ((GA != null)) {
          if (StripKind == PointerStripKind.PSK_ZeroIndices || GA.isInterposable()) {
            return V;
          }
          V = GA.getAliasee();
        } else {
          {
            CallSite CS = new CallSite(V);
            if (CS.$bool()) {
              {
                Value /*P*/ RV = CS.getReturnedArgOperand();
                if ((RV != null)) {
                  V = RV;
                  continue;
                }
              }
            }
          }
          
          return V;
        }
      }
    }
    assert (V.getType().isPointerTy()) : "Unexpected operand type!";
  } while (Visited.insert(V).second);
  
  return V;
}

} // END OF class ValueStatics
