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

package org.llvm.ir;

import org.clank.support.*;
import org.llvm.adt.aliases.*;


/// ConstantFolder - Create constants with minimum, target independent, folding.
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 26,
 FQN="llvm::ConstantFolder", NM="_ZN4llvm14ConstantFolderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN4llvm14ConstantFolderE")
//</editor-fold>
public class ConstantFolder implements org.llvm.ir.java.IFolder<Constant, Constant> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::ConstantFolder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 28,
   FQN="llvm::ConstantFolder::ConstantFolder", NM="_ZN4llvm14ConstantFolderC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN4llvm14ConstantFolderC1Ev")
  //</editor-fold>
  public /*explicit*/ ConstantFolder() {
  }

  
  //===--------------------------------------------------------------------===//
  // Binary Operators
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 34,
   FQN="llvm::ConstantFolder::CreateAdd", NM="_ZNK4llvm14ConstantFolder9CreateAddEPNS_8ConstantES2_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder9CreateAddEPNS_8ConstantES2_bb")
  //</editor-fold>
  public Constant /*P*/ CreateAdd(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return CreateAdd(LHS, RHS, 
           false, false);
  }
  public Constant /*P*/ CreateAdd(Constant /*P*/ LHS, Constant /*P*/ RHS, 
           boolean HasNUW/*= false*/) /*const*/ {
    return CreateAdd(LHS, RHS, 
           HasNUW, false);
  }
  public Constant /*P*/ CreateAdd(Constant /*P*/ LHS, Constant /*P*/ RHS, 
           boolean HasNUW/*= false*/, boolean HasNSW/*= false*/) /*const*/ {
    return ConstantExpr.getAdd(LHS, RHS, HasNUW, HasNSW);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateFAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 38,
   FQN="llvm::ConstantFolder::CreateFAdd", NM="_ZNK4llvm14ConstantFolder10CreateFAddEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder10CreateFAddEPNS_8ConstantES2_")
  //</editor-fold>
  public Constant /*P*/ CreateFAdd(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return ConstantExpr.getFAdd(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 41,
   FQN="llvm::ConstantFolder::CreateSub", NM="_ZNK4llvm14ConstantFolder9CreateSubEPNS_8ConstantES2_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder9CreateSubEPNS_8ConstantES2_bb")
  //</editor-fold>
  public Constant /*P*/ CreateSub(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return CreateSub(LHS, RHS, 
           false, false);
  }
  public Constant /*P*/ CreateSub(Constant /*P*/ LHS, Constant /*P*/ RHS, 
           boolean HasNUW/*= false*/) /*const*/ {
    return CreateSub(LHS, RHS, 
           HasNUW, false);
  }
  public Constant /*P*/ CreateSub(Constant /*P*/ LHS, Constant /*P*/ RHS, 
           boolean HasNUW/*= false*/, boolean HasNSW/*= false*/) /*const*/ {
    return ConstantExpr.getSub(LHS, RHS, HasNUW, HasNSW);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateFSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 45,
   FQN="llvm::ConstantFolder::CreateFSub", NM="_ZNK4llvm14ConstantFolder10CreateFSubEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder10CreateFSubEPNS_8ConstantES2_")
  //</editor-fold>
  public Constant /*P*/ CreateFSub(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return ConstantExpr.getFSub(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 48,
   FQN="llvm::ConstantFolder::CreateMul", NM="_ZNK4llvm14ConstantFolder9CreateMulEPNS_8ConstantES2_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder9CreateMulEPNS_8ConstantES2_bb")
  //</editor-fold>
  public Constant /*P*/ CreateMul(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return CreateMul(LHS, RHS, 
           false, false);
  }
  public Constant /*P*/ CreateMul(Constant /*P*/ LHS, Constant /*P*/ RHS, 
           boolean HasNUW/*= false*/) /*const*/ {
    return CreateMul(LHS, RHS, 
           HasNUW, false);
  }
  public Constant /*P*/ CreateMul(Constant /*P*/ LHS, Constant /*P*/ RHS, 
           boolean HasNUW/*= false*/, boolean HasNSW/*= false*/) /*const*/ {
    return ConstantExpr.getMul(LHS, RHS, HasNUW, HasNSW);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateFMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 52,
   FQN="llvm::ConstantFolder::CreateFMul", NM="_ZNK4llvm14ConstantFolder10CreateFMulEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder10CreateFMulEPNS_8ConstantES2_")
  //</editor-fold>
  public Constant /*P*/ CreateFMul(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return ConstantExpr.getFMul(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateUDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 55,
   FQN="llvm::ConstantFolder::CreateUDiv", NM="_ZNK4llvm14ConstantFolder10CreateUDivEPNS_8ConstantES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder10CreateUDivEPNS_8ConstantES2_b")
  //</editor-fold>
  public Constant /*P*/ CreateUDiv(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return CreateUDiv(LHS, RHS, 
            false);
  }
  public Constant /*P*/ CreateUDiv(Constant /*P*/ LHS, Constant /*P*/ RHS, 
            boolean isExact/*= false*/) /*const*/ {
    return ConstantExpr.getUDiv(LHS, RHS, isExact);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateSDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 59,
   FQN="llvm::ConstantFolder::CreateSDiv", NM="_ZNK4llvm14ConstantFolder10CreateSDivEPNS_8ConstantES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder10CreateSDivEPNS_8ConstantES2_b")
  //</editor-fold>
  public Constant /*P*/ CreateSDiv(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return CreateSDiv(LHS, RHS, 
            false);
  }
  public Constant /*P*/ CreateSDiv(Constant /*P*/ LHS, Constant /*P*/ RHS, 
            boolean isExact/*= false*/) /*const*/ {
    return ConstantExpr.getSDiv(LHS, RHS, isExact);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateFDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 63,
   FQN="llvm::ConstantFolder::CreateFDiv", NM="_ZNK4llvm14ConstantFolder10CreateFDivEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder10CreateFDivEPNS_8ConstantES2_")
  //</editor-fold>
  public Constant /*P*/ CreateFDiv(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return ConstantExpr.getFDiv(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateURem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 66,
   FQN="llvm::ConstantFolder::CreateURem", NM="_ZNK4llvm14ConstantFolder10CreateURemEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder10CreateURemEPNS_8ConstantES2_")
  //</editor-fold>
  public Constant /*P*/ CreateURem(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return ConstantExpr.getURem(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateSRem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 69,
   FQN="llvm::ConstantFolder::CreateSRem", NM="_ZNK4llvm14ConstantFolder10CreateSRemEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder10CreateSRemEPNS_8ConstantES2_")
  //</editor-fold>
  public Constant /*P*/ CreateSRem(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return ConstantExpr.getSRem(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateFRem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 72,
   FQN="llvm::ConstantFolder::CreateFRem", NM="_ZNK4llvm14ConstantFolder10CreateFRemEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder10CreateFRemEPNS_8ConstantES2_")
  //</editor-fold>
  public Constant /*P*/ CreateFRem(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return ConstantExpr.getFRem(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateShl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 75,
   FQN="llvm::ConstantFolder::CreateShl", NM="_ZNK4llvm14ConstantFolder9CreateShlEPNS_8ConstantES2_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder9CreateShlEPNS_8ConstantES2_bb")
  //</editor-fold>
  public Constant /*P*/ CreateShl(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return CreateShl(LHS, RHS, 
           false, false);
  }
  public Constant /*P*/ CreateShl(Constant /*P*/ LHS, Constant /*P*/ RHS, 
           boolean HasNUW/*= false*/) /*const*/ {
    return CreateShl(LHS, RHS, 
           HasNUW, false);
  }
  public Constant /*P*/ CreateShl(Constant /*P*/ LHS, Constant /*P*/ RHS, 
           boolean HasNUW/*= false*/, boolean HasNSW/*= false*/) /*const*/ {
    return ConstantExpr.getShl(LHS, RHS, HasNUW, HasNSW);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateLShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 79,
   FQN="llvm::ConstantFolder::CreateLShr", NM="_ZNK4llvm14ConstantFolder10CreateLShrEPNS_8ConstantES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder10CreateLShrEPNS_8ConstantES2_b")
  //</editor-fold>
  public Constant /*P*/ CreateLShr(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return CreateLShr(LHS, RHS, 
            false);
  }
  public Constant /*P*/ CreateLShr(Constant /*P*/ LHS, Constant /*P*/ RHS, 
            boolean isExact/*= false*/) /*const*/ {
    return ConstantExpr.getLShr(LHS, RHS, isExact);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateAShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 83,
   FQN="llvm::ConstantFolder::CreateAShr", NM="_ZNK4llvm14ConstantFolder10CreateAShrEPNS_8ConstantES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder10CreateAShrEPNS_8ConstantES2_b")
  //</editor-fold>
  public Constant /*P*/ CreateAShr(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return CreateAShr(LHS, RHS, 
            false);
  }
  public Constant /*P*/ CreateAShr(Constant /*P*/ LHS, Constant /*P*/ RHS, 
            boolean isExact/*= false*/) /*const*/ {
    return ConstantExpr.getAShr(LHS, RHS, isExact);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateAnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 87,
   FQN="llvm::ConstantFolder::CreateAnd", NM="_ZNK4llvm14ConstantFolder9CreateAndEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder9CreateAndEPNS_8ConstantES2_")
  //</editor-fold>
  public Constant /*P*/ CreateAnd(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return ConstantExpr.getAnd(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateOr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 90,
   FQN="llvm::ConstantFolder::CreateOr", NM="_ZNK4llvm14ConstantFolder8CreateOrEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder8CreateOrEPNS_8ConstantES2_")
  //</editor-fold>
  public Constant /*P*/ CreateOr(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return ConstantExpr.getOr(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateXor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 93,
   FQN="llvm::ConstantFolder::CreateXor", NM="_ZNK4llvm14ConstantFolder9CreateXorEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder9CreateXorEPNS_8ConstantES2_")
  //</editor-fold>
  public Constant /*P*/ CreateXor(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return ConstantExpr.getXor(LHS, RHS);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateBinOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 97,
   FQN="llvm::ConstantFolder::CreateBinOp", NM="_ZNK4llvm14ConstantFolder11CreateBinOpENS_11Instruction9BinaryOpsEPNS_8ConstantES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder11CreateBinOpENS_11Instruction9BinaryOpsEPNS_8ConstantES4_")
  //</editor-fold>
  public Constant /*P*/ CreateBinOp(/*BinaryOps*/int Opc, 
             Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return ConstantExpr.get(Opc, LHS, RHS);
  }

  
  //===--------------------------------------------------------------------===//
  // Unary Operators
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateNeg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 106,
   FQN="llvm::ConstantFolder::CreateNeg", NM="_ZNK4llvm14ConstantFolder9CreateNegEPNS_8ConstantEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder9CreateNegEPNS_8ConstantEbb")
  //</editor-fold>
  public Constant /*P*/ CreateNeg(Constant /*P*/ C) /*const*/ {
    return CreateNeg(C, 
           false, false);
  }
  public Constant /*P*/ CreateNeg(Constant /*P*/ C, 
           boolean HasNUW/*= false*/) /*const*/ {
    return CreateNeg(C, 
           HasNUW, false);
  }
  public Constant /*P*/ CreateNeg(Constant /*P*/ C, 
           boolean HasNUW/*= false*/, boolean HasNSW/*= false*/) /*const*/ {
    return ConstantExpr.getNeg(C, HasNUW, HasNSW);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateFNeg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 110,
   FQN="llvm::ConstantFolder::CreateFNeg", NM="_ZNK4llvm14ConstantFolder10CreateFNegEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder10CreateFNegEPNS_8ConstantE")
  //</editor-fold>
  public Constant /*P*/ CreateFNeg(Constant /*P*/ C) /*const*/ {
    return ConstantExpr.getFNeg(C);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateNot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 113,
   FQN="llvm::ConstantFolder::CreateNot", NM="_ZNK4llvm14ConstantFolder9CreateNotEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder9CreateNotEPNS_8ConstantE")
  //</editor-fold>
  public Constant /*P*/ CreateNot(Constant /*P*/ C) /*const*/ {
    return ConstantExpr.getNot(C);
  }

  
  //===--------------------------------------------------------------------===//
  // Memory Instructions
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateGetElementPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 121,
   FQN="llvm::ConstantFolder::CreateGetElementPtr", NM="_ZNK4llvm14ConstantFolder19CreateGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIS4_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder19CreateGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIS4_EE")
  //</editor-fold>
  public Constant /*P*/ CreateGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P(Type /*P*/ Ty, Constant /*P*/ C, 
                                                           ArrayRef<Constant /*P*/ > IdxList) /*const*/ {
    return ConstantExpr.getGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P_bool_Type$P(Ty, C, new ArrayRef<Constant /*P*/ >(IdxList));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateGetElementPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 125,
   FQN="llvm::ConstantFolder::CreateGetElementPtr", NM="_ZNK4llvm14ConstantFolder19CreateGetElementPtrEPNS_4TypeEPNS_8ConstantES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder19CreateGetElementPtrEPNS_4TypeEPNS_8ConstantES4_")
  //</editor-fold>
  public Constant /*P*/ CreateGetElementPtr(Type /*P*/ Ty, Constant /*P*/ C, Constant /*P*/ Idx) /*const*/ {
    // This form of the function only exists to avoid ambiguous overload
    // warnings about whether to convert Idx to ArrayRef<Constant *> or
    // ArrayRef<Value *>.
    return ConstantExpr.getGetElementPtr(Ty, C, Idx);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateGetElementPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 131,
   FQN="llvm::ConstantFolder::CreateGetElementPtr", NM="_ZNK4llvm14ConstantFolder19CreateGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIPNS_5ValueEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder19CreateGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIPNS_5ValueEEE")
  //</editor-fold>
  public Constant /*P*/ CreateGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P(Type /*P*/ Ty, Constant /*P*/ C, 
                                                        ArrayRef<Value /*P*/ > IdxList) /*const*/ {
    return ConstantExpr.getGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P_bool_Type$P(Ty, C, new ArrayRef<Value /*P*/ >(IdxList));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateInBoundsGetElementPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 136,
   FQN="llvm::ConstantFolder::CreateInBoundsGetElementPtr", NM="_ZNK4llvm14ConstantFolder27CreateInBoundsGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIS4_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder27CreateInBoundsGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIS4_EE")
  //</editor-fold>
  public Constant /*P*/ CreateInBoundsGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P(Type /*P*/ Ty, Constant /*P*/ C, 
                                                                   ArrayRef<Constant /*P*/ > IdxList) /*const*/ {
    return ConstantExpr.getInBoundsGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P(Ty, C, new ArrayRef<Constant /*P*/ >(IdxList));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateInBoundsGetElementPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 140,
   FQN="llvm::ConstantFolder::CreateInBoundsGetElementPtr", NM="_ZNK4llvm14ConstantFolder27CreateInBoundsGetElementPtrEPNS_4TypeEPNS_8ConstantES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder27CreateInBoundsGetElementPtrEPNS_4TypeEPNS_8ConstantES4_")
  //</editor-fold>
  public Constant /*P*/ CreateInBoundsGetElementPtr(Type /*P*/ Ty, Constant /*P*/ C, 
                             Constant /*P*/ Idx) /*const*/ {
    // This form of the function only exists to avoid ambiguous overload
    // warnings about whether to convert Idx to ArrayRef<Constant *> or
    // ArrayRef<Value *>.
    return ConstantExpr.getInBoundsGetElementPtr(Ty, C, Idx);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateInBoundsGetElementPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 147,
   FQN="llvm::ConstantFolder::CreateInBoundsGetElementPtr", NM="_ZNK4llvm14ConstantFolder27CreateInBoundsGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIPNS_5ValueEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder27CreateInBoundsGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIPNS_5ValueEEE")
  //</editor-fold>
  public Constant /*P*/ CreateInBoundsGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P(Type /*P*/ Ty, Constant /*P*/ C, 
                                                                ArrayRef<Value /*P*/ > IdxList) /*const*/ {
    return ConstantExpr.getInBoundsGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P(Ty, C, new ArrayRef<Value /*P*/ >(IdxList));
  }

  
  //===--------------------------------------------------------------------===//
  // Cast/Conversion Operators
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 156,
   FQN="llvm::ConstantFolder::CreateCast", NM="_ZNK4llvm14ConstantFolder10CreateCastENS_11Instruction7CastOpsEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder10CreateCastENS_11Instruction7CastOpsEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public Constant /*P*/ CreateCast(/*CastOps*/int Op, Constant /*P*/ C, 
            Type /*P*/ DestTy) /*const*/ {
    return ConstantExpr.getCast(Op, C, DestTy);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreatePointerCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 160,
   FQN="llvm::ConstantFolder::CreatePointerCast", NM="_ZNK4llvm14ConstantFolder17CreatePointerCastEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder17CreatePointerCastEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public Constant /*P*/ CreatePointerCast(Constant /*P*/ C, Type /*P*/ DestTy) /*const*/ {
    return ConstantExpr.getPointerCast(C, DestTy);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreatePointerBitCastOrAddrSpaceCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 164,
   FQN="llvm::ConstantFolder::CreatePointerBitCastOrAddrSpaceCast", NM="_ZNK4llvm14ConstantFolder35CreatePointerBitCastOrAddrSpaceCastEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder35CreatePointerBitCastOrAddrSpaceCastEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public Constant /*P*/ CreatePointerBitCastOrAddrSpaceCast(Constant /*P*/ C, 
                                     Type /*P*/ DestTy) /*const*/ {
    return ConstantExpr.getPointerBitCastOrAddrSpaceCast(C, DestTy);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateIntCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 169,
   FQN="llvm::ConstantFolder::CreateIntCast", NM="_ZNK4llvm14ConstantFolder13CreateIntCastEPNS_8ConstantEPNS_4TypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder13CreateIntCastEPNS_8ConstantEPNS_4TypeEb")
  //</editor-fold>
  public Constant /*P*/ CreateIntCast(Constant /*P*/ C, Type /*P*/ DestTy, 
               boolean isSigned) /*const*/ {
    return ConstantExpr.getIntegerCast(C, DestTy, isSigned);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateFPCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 173,
   FQN="llvm::ConstantFolder::CreateFPCast", NM="_ZNK4llvm14ConstantFolder12CreateFPCastEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder12CreateFPCastEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public Constant /*P*/ CreateFPCast(Constant /*P*/ C, Type /*P*/ DestTy) /*const*/ {
    return ConstantExpr.getFPCast(C, DestTy);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateBitCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 177,
   FQN="llvm::ConstantFolder::CreateBitCast", NM="_ZNK4llvm14ConstantFolder13CreateBitCastEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder13CreateBitCastEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public Constant /*P*/ CreateBitCast(Constant /*P*/ C, Type /*P*/ DestTy) /*const*/ {
    return CreateCast(Instruction.CastOps.BitCast, C, DestTy);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateIntToPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 180,
   FQN="llvm::ConstantFolder::CreateIntToPtr", NM="_ZNK4llvm14ConstantFolder14CreateIntToPtrEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder14CreateIntToPtrEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public Constant /*P*/ CreateIntToPtr(Constant /*P*/ C, Type /*P*/ DestTy) /*const*/ {
    return CreateCast(Instruction.CastOps.IntToPtr, C, DestTy);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreatePtrToInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 183,
   FQN="llvm::ConstantFolder::CreatePtrToInt", NM="_ZNK4llvm14ConstantFolder14CreatePtrToIntEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder14CreatePtrToIntEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public Constant /*P*/ CreatePtrToInt(Constant /*P*/ C, Type /*P*/ DestTy) /*const*/ {
    return CreateCast(Instruction.CastOps.PtrToInt, C, DestTy);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateZExtOrBitCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 186,
   FQN="llvm::ConstantFolder::CreateZExtOrBitCast", NM="_ZNK4llvm14ConstantFolder19CreateZExtOrBitCastEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder19CreateZExtOrBitCastEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public Constant /*P*/ CreateZExtOrBitCast(Constant /*P*/ C, Type /*P*/ DestTy) /*const*/ {
    return ConstantExpr.getZExtOrBitCast(C, DestTy);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateSExtOrBitCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 189,
   FQN="llvm::ConstantFolder::CreateSExtOrBitCast", NM="_ZNK4llvm14ConstantFolder19CreateSExtOrBitCastEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder19CreateSExtOrBitCastEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public Constant /*P*/ CreateSExtOrBitCast(Constant /*P*/ C, Type /*P*/ DestTy) /*const*/ {
    return ConstantExpr.getSExtOrBitCast(C, DestTy);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateTruncOrBitCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 193,
   FQN="llvm::ConstantFolder::CreateTruncOrBitCast", NM="_ZNK4llvm14ConstantFolder20CreateTruncOrBitCastEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder20CreateTruncOrBitCastEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public Constant /*P*/ CreateTruncOrBitCast(Constant /*P*/ C, Type /*P*/ DestTy) /*const*/ {
    return ConstantExpr.getTruncOrBitCast(C, DestTy);
  }

  
  //===--------------------------------------------------------------------===//
  // Compare Instructions
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateICmp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 201,
   FQN="llvm::ConstantFolder::CreateICmp", NM="_ZNK4llvm14ConstantFolder10CreateICmpENS_7CmpInst9PredicateEPNS_8ConstantES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder10CreateICmpENS_7CmpInst9PredicateEPNS_8ConstantES4_")
  //</editor-fold>
  public Constant /*P*/ CreateICmp(CmpInst.Predicate P, Constant /*P*/ LHS, 
            Constant /*P*/ RHS) /*const*/ {
    return ConstantExpr.getCompare(P.getValue(), LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateFCmp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 205,
   FQN="llvm::ConstantFolder::CreateFCmp", NM="_ZNK4llvm14ConstantFolder10CreateFCmpENS_7CmpInst9PredicateEPNS_8ConstantES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder10CreateFCmpENS_7CmpInst9PredicateEPNS_8ConstantES4_")
  //</editor-fold>
  public Constant /*P*/ CreateFCmp(CmpInst.Predicate P, Constant /*P*/ LHS, 
            Constant /*P*/ RHS) /*const*/ {
    return ConstantExpr.getCompare(P.getValue(), LHS, RHS);
  }

  
  //===--------------------------------------------------------------------===//
  // Other Instructions
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateSelect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 214,
   FQN="llvm::ConstantFolder::CreateSelect", NM="_ZNK4llvm14ConstantFolder12CreateSelectEPNS_8ConstantES2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder12CreateSelectEPNS_8ConstantES2_S2_")
  //</editor-fold>
  public Constant /*P*/ CreateSelect(Constant /*P*/ C, Constant /*P*/ True, Constant /*P*/ False) /*const*/ {
    return ConstantExpr.getSelect(C, True, False);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateExtractElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 218,
   FQN="llvm::ConstantFolder::CreateExtractElement", NM="_ZNK4llvm14ConstantFolder20CreateExtractElementEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder20CreateExtractElementEPNS_8ConstantES2_")
  //</editor-fold>
  public Constant /*P*/ CreateExtractElement(Constant /*P*/ Vec, Constant /*P*/ Idx) /*const*/ {
    return ConstantExpr.getExtractElement(Vec, Idx);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateInsertElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 222,
   FQN="llvm::ConstantFolder::CreateInsertElement", NM="_ZNK4llvm14ConstantFolder19CreateInsertElementEPNS_8ConstantES2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder19CreateInsertElementEPNS_8ConstantES2_S2_")
  //</editor-fold>
  public Constant /*P*/ CreateInsertElement(Constant /*P*/ Vec, Constant /*P*/ NewElt, 
                     Constant /*P*/ Idx) /*const*/ {
    return ConstantExpr.getInsertElement(Vec, NewElt, Idx);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateShuffleVector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 227,
   FQN="llvm::ConstantFolder::CreateShuffleVector", NM="_ZNK4llvm14ConstantFolder19CreateShuffleVectorEPNS_8ConstantES2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder19CreateShuffleVectorEPNS_8ConstantES2_S2_")
  //</editor-fold>
  public Constant /*P*/ CreateShuffleVector(Constant /*P*/ V1, Constant /*P*/ V2, 
                     Constant /*P*/ Mask) /*const*/ {
    return ConstantExpr.getShuffleVector(V1, V2, Mask);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateExtractValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 232,
   FQN="llvm::ConstantFolder::CreateExtractValue", NM="_ZNK4llvm14ConstantFolder18CreateExtractValueEPNS_8ConstantENS_8ArrayRefIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder18CreateExtractValueEPNS_8ConstantENS_8ArrayRefIjEE")
  //</editor-fold>
  public Constant /*P*/ CreateExtractValue(Constant /*P*/ Agg, 
                    ArrayRefUInt IdxList) /*const*/ {
    return ConstantExpr.getExtractValue(Agg, new ArrayRefUInt(IdxList));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::CreateInsertValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 237,
   FQN="llvm::ConstantFolder::CreateInsertValue", NM="_ZNK4llvm14ConstantFolder17CreateInsertValueEPNS_8ConstantES2_NS_8ArrayRefIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZNK4llvm14ConstantFolder17CreateInsertValueEPNS_8ConstantES2_NS_8ArrayRefIjEE")
  //</editor-fold>
  public Constant /*P*/ CreateInsertValue(Constant /*P*/ Agg, Constant /*P*/ Val, 
                   ArrayRefUInt IdxList) /*const*/ {
    return ConstantExpr.getInsertValue(Agg, Val, new ArrayRefUInt(IdxList));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFolder::ConstantFolder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantFolder.h", line = 26,
   FQN="llvm::ConstantFolder::ConstantFolder", NM="_ZN4llvm14ConstantFolderC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN4llvm14ConstantFolderC1ERKS0_")
  //</editor-fold>
  public /*inline*/ ConstantFolder(final /*const*/ ConstantFolder /*&*/ $Prm0) {
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public ConstantFolder clone() {
    return new ConstantFolder(this);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
