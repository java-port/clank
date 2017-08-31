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

package org.llvm.analysis.target;

import org.clank.support.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;


/// TargetFolder - Create constants with target dependent folding.
//<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 32,
 FQN="llvm::TargetFolder", NM="_ZN4llvm12TargetFolderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZN4llvm12TargetFolderE")
//</editor-fold>
public class TargetFolder implements  org.llvm.ir.java.IFolder<Constant, Constant> {
  private final /*const*/ DataLayout /*&*/ DL;
  
  /// Fold - Fold the constant using target specific information.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::Fold">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 36,
   FQN="llvm::TargetFolder::Fold", NM="_ZNK4llvm12TargetFolder4FoldEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder4FoldEPNS_8ConstantE")
  //</editor-fold>
  private Constant /*P*/ Fold(Constant /*P*/ C) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::TargetFolder">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 44,
   FQN="llvm::TargetFolder::TargetFolder", NM="_ZN4llvm12TargetFolderC1ERKNS_10DataLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZN4llvm12TargetFolderC1ERKNS_10DataLayoutE")
  //</editor-fold>
  public /*explicit*/ TargetFolder(final /*const*/ DataLayout /*&*/ DL) {
    // : DL(DL) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //===--------------------------------------------------------------------===//
  // Binary Operators
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateAdd">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 50,
   FQN="llvm::TargetFolder::CreateAdd", NM="_ZNK4llvm12TargetFolder9CreateAddEPNS_8ConstantES2_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder9CreateAddEPNS_8ConstantES2_bb")
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
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateFAdd">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 54,
   FQN="llvm::TargetFolder::CreateFAdd", NM="_ZNK4llvm12TargetFolder10CreateFAddEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder10CreateFAddEPNS_8ConstantES2_")
  //</editor-fold>
  public Constant /*P*/ CreateFAdd(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateSub">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 57,
   FQN="llvm::TargetFolder::CreateSub", NM="_ZNK4llvm12TargetFolder9CreateSubEPNS_8ConstantES2_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder9CreateSubEPNS_8ConstantES2_bb")
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
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateFSub">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 61,
   FQN="llvm::TargetFolder::CreateFSub", NM="_ZNK4llvm12TargetFolder10CreateFSubEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder10CreateFSubEPNS_8ConstantES2_")
  //</editor-fold>
  public Constant /*P*/ CreateFSub(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateMul">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 64,
   FQN="llvm::TargetFolder::CreateMul", NM="_ZNK4llvm12TargetFolder9CreateMulEPNS_8ConstantES2_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder9CreateMulEPNS_8ConstantES2_bb")
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
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateFMul">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 68,
   FQN="llvm::TargetFolder::CreateFMul", NM="_ZNK4llvm12TargetFolder10CreateFMulEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder10CreateFMulEPNS_8ConstantES2_")
  //</editor-fold>
  public Constant /*P*/ CreateFMul(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateUDiv">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 71,
   FQN="llvm::TargetFolder::CreateUDiv", NM="_ZNK4llvm12TargetFolder10CreateUDivEPNS_8ConstantES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder10CreateUDivEPNS_8ConstantES2_b")
  //</editor-fold>
  public Constant /*P*/ CreateUDiv(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return CreateUDiv(LHS, RHS, false);
  }
  public Constant /*P*/ CreateUDiv(Constant /*P*/ LHS, Constant /*P*/ RHS, boolean isExact/*= false*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateSDiv">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 74,
   FQN="llvm::TargetFolder::CreateSDiv", NM="_ZNK4llvm12TargetFolder10CreateSDivEPNS_8ConstantES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder10CreateSDivEPNS_8ConstantES2_b")
  //</editor-fold>
  public Constant /*P*/ CreateSDiv(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return CreateSDiv(LHS, RHS, false);
  }
  public Constant /*P*/ CreateSDiv(Constant /*P*/ LHS, Constant /*P*/ RHS, boolean isExact/*= false*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateFDiv">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 77,
   FQN="llvm::TargetFolder::CreateFDiv", NM="_ZNK4llvm12TargetFolder10CreateFDivEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder10CreateFDivEPNS_8ConstantES2_")
  //</editor-fold>
  public Constant /*P*/ CreateFDiv(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateURem">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 80,
   FQN="llvm::TargetFolder::CreateURem", NM="_ZNK4llvm12TargetFolder10CreateURemEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder10CreateURemEPNS_8ConstantES2_")
  //</editor-fold>
  public Constant /*P*/ CreateURem(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateSRem">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 83,
   FQN="llvm::TargetFolder::CreateSRem", NM="_ZNK4llvm12TargetFolder10CreateSRemEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder10CreateSRemEPNS_8ConstantES2_")
  //</editor-fold>
  public Constant /*P*/ CreateSRem(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateFRem">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 86,
   FQN="llvm::TargetFolder::CreateFRem", NM="_ZNK4llvm12TargetFolder10CreateFRemEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder10CreateFRemEPNS_8ConstantES2_")
  //</editor-fold>
  public Constant /*P*/ CreateFRem(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateShl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 89,
   FQN="llvm::TargetFolder::CreateShl", NM="_ZNK4llvm12TargetFolder9CreateShlEPNS_8ConstantES2_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder9CreateShlEPNS_8ConstantES2_bb")
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
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateLShr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 93,
   FQN="llvm::TargetFolder::CreateLShr", NM="_ZNK4llvm12TargetFolder10CreateLShrEPNS_8ConstantES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder10CreateLShrEPNS_8ConstantES2_b")
  //</editor-fold>
  public Constant /*P*/ CreateLShr(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return CreateLShr(LHS, RHS, false);
  }
  public Constant /*P*/ CreateLShr(Constant /*P*/ LHS, Constant /*P*/ RHS, boolean isExact/*= false*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateAShr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 96,
   FQN="llvm::TargetFolder::CreateAShr", NM="_ZNK4llvm12TargetFolder10CreateAShrEPNS_8ConstantES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder10CreateAShrEPNS_8ConstantES2_b")
  //</editor-fold>
  public Constant /*P*/ CreateAShr(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return CreateAShr(LHS, RHS, false);
  }
  public Constant /*P*/ CreateAShr(Constant /*P*/ LHS, Constant /*P*/ RHS, boolean isExact/*= false*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateAnd">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 99,
   FQN="llvm::TargetFolder::CreateAnd", NM="_ZNK4llvm12TargetFolder9CreateAndEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder9CreateAndEPNS_8ConstantES2_")
  //</editor-fold>
  public Constant /*P*/ CreateAnd(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateOr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 102,
   FQN="llvm::TargetFolder::CreateOr", NM="_ZNK4llvm12TargetFolder8CreateOrEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder8CreateOrEPNS_8ConstantES2_")
  //</editor-fold>
  public Constant /*P*/ CreateOr(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateXor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 105,
   FQN="llvm::TargetFolder::CreateXor", NM="_ZNK4llvm12TargetFolder9CreateXorEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder9CreateXorEPNS_8ConstantES2_")
  //</editor-fold>
  public Constant /*P*/ CreateXor(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateBinOp">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 109,
   FQN="llvm::TargetFolder::CreateBinOp", NM="_ZNK4llvm12TargetFolder11CreateBinOpENS_11Instruction9BinaryOpsEPNS_8ConstantES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder11CreateBinOpENS_11Instruction9BinaryOpsEPNS_8ConstantES4_")
  //</editor-fold>
  public Constant /*P*/ CreateBinOp(/*BinaryOps*/int Opc, 
             Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //===--------------------------------------------------------------------===//
  // Unary Operators
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateNeg">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 118,
   FQN="llvm::TargetFolder::CreateNeg", NM="_ZNK4llvm12TargetFolder9CreateNegEPNS_8ConstantEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder9CreateNegEPNS_8ConstantEbb")
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
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateFNeg">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 122,
   FQN="llvm::TargetFolder::CreateFNeg", NM="_ZNK4llvm12TargetFolder10CreateFNegEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder10CreateFNegEPNS_8ConstantE")
  //</editor-fold>
  public Constant /*P*/ CreateFNeg(Constant /*P*/ C) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateNot">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 125,
   FQN="llvm::TargetFolder::CreateNot", NM="_ZNK4llvm12TargetFolder9CreateNotEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder9CreateNotEPNS_8ConstantE")
  //</editor-fold>
  public Constant /*P*/ CreateNot(Constant /*P*/ C) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //===--------------------------------------------------------------------===//
  // Memory Instructions
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateGetElementPtr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 133,
   FQN="llvm::TargetFolder::CreateGetElementPtr", NM="_ZNK4llvm12TargetFolder19CreateGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIS4_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder19CreateGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIS4_EE")
  //</editor-fold>
  public Constant /*P*/ CreateGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P(Type /*P*/ Ty, Constant /*P*/ C, 
                                                           ArrayRef<Constant /*P*/ > IdxList) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateGetElementPtr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 137,
   FQN="llvm::TargetFolder::CreateGetElementPtr", NM="_ZNK4llvm12TargetFolder19CreateGetElementPtrEPNS_4TypeEPNS_8ConstantES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder19CreateGetElementPtrEPNS_4TypeEPNS_8ConstantES4_")
  //</editor-fold>
  public Constant /*P*/ CreateGetElementPtr(Type /*P*/ Ty, Constant /*P*/ C, Constant /*P*/ Idx) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateGetElementPtr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 143,
   FQN="llvm::TargetFolder::CreateGetElementPtr", NM="_ZNK4llvm12TargetFolder19CreateGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIPNS_5ValueEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder19CreateGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIPNS_5ValueEEE")
  //</editor-fold>
  public Constant /*P*/ CreateGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P(Type /*P*/ Ty, Constant /*P*/ C, 
                                                        ArrayRef<Value /*P*/ > IdxList) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateInBoundsGetElementPtr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 148,
   FQN="llvm::TargetFolder::CreateInBoundsGetElementPtr", NM="_ZNK4llvm12TargetFolder27CreateInBoundsGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIS4_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder27CreateInBoundsGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIS4_EE")
  //</editor-fold>
  public Constant /*P*/ CreateInBoundsGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P(Type /*P*/ Ty, Constant /*P*/ C, 
                                                                   ArrayRef<Constant /*P*/ > IdxList) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateInBoundsGetElementPtr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 152,
   FQN="llvm::TargetFolder::CreateInBoundsGetElementPtr", NM="_ZNK4llvm12TargetFolder27CreateInBoundsGetElementPtrEPNS_4TypeEPNS_8ConstantES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder27CreateInBoundsGetElementPtrEPNS_4TypeEPNS_8ConstantES4_")
  //</editor-fold>
  public Constant /*P*/ CreateInBoundsGetElementPtr(Type /*P*/ Ty, Constant /*P*/ C, 
                             Constant /*P*/ Idx) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateInBoundsGetElementPtr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 159,
   FQN="llvm::TargetFolder::CreateInBoundsGetElementPtr", NM="_ZNK4llvm12TargetFolder27CreateInBoundsGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIPNS_5ValueEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder27CreateInBoundsGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIPNS_5ValueEEE")
  //</editor-fold>
  public Constant /*P*/ CreateInBoundsGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P(Type /*P*/ Ty, Constant /*P*/ C, 
                                                                ArrayRef<Value /*P*/ > IdxList) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //===--------------------------------------------------------------------===//
  // Cast/Conversion Operators
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateCast">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 168,
   FQN="llvm::TargetFolder::CreateCast", NM="_ZNK4llvm12TargetFolder10CreateCastENS_11Instruction7CastOpsEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder10CreateCastENS_11Instruction7CastOpsEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public Constant /*P*/ CreateCast(/*CastOps*/int Op, Constant /*P*/ C, 
            Type /*P*/ DestTy) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateIntCast">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 174,
   FQN="llvm::TargetFolder::CreateIntCast", NM="_ZNK4llvm12TargetFolder13CreateIntCastEPNS_8ConstantEPNS_4TypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder13CreateIntCastEPNS_8ConstantEPNS_4TypeEb")
  //</editor-fold>
  public Constant /*P*/ CreateIntCast(Constant /*P*/ C, Type /*P*/ DestTy, 
               boolean isSigned) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreatePointerCast">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 180,
   FQN="llvm::TargetFolder::CreatePointerCast", NM="_ZNK4llvm12TargetFolder17CreatePointerCastEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder17CreatePointerCastEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public Constant /*P*/ CreatePointerCast(Constant /*P*/ C, Type /*P*/ DestTy) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateFPCast">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 185,
   FQN="llvm::TargetFolder::CreateFPCast", NM="_ZNK4llvm12TargetFolder12CreateFPCastEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder12CreateFPCastEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public Constant /*P*/ CreateFPCast(Constant /*P*/ C, Type /*P*/ DestTy) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateBitCast">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 190,
   FQN="llvm::TargetFolder::CreateBitCast", NM="_ZNK4llvm12TargetFolder13CreateBitCastEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder13CreateBitCastEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public Constant /*P*/ CreateBitCast(Constant /*P*/ C, Type /*P*/ DestTy) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateIntToPtr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 193,
   FQN="llvm::TargetFolder::CreateIntToPtr", NM="_ZNK4llvm12TargetFolder14CreateIntToPtrEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder14CreateIntToPtrEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public Constant /*P*/ CreateIntToPtr(Constant /*P*/ C, Type /*P*/ DestTy) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreatePtrToInt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 196,
   FQN="llvm::TargetFolder::CreatePtrToInt", NM="_ZNK4llvm12TargetFolder14CreatePtrToIntEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder14CreatePtrToIntEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public Constant /*P*/ CreatePtrToInt(Constant /*P*/ C, Type /*P*/ DestTy) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateZExtOrBitCast">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 199,
   FQN="llvm::TargetFolder::CreateZExtOrBitCast", NM="_ZNK4llvm12TargetFolder19CreateZExtOrBitCastEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder19CreateZExtOrBitCastEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public Constant /*P*/ CreateZExtOrBitCast(Constant /*P*/ C, Type /*P*/ DestTy) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateSExtOrBitCast">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 204,
   FQN="llvm::TargetFolder::CreateSExtOrBitCast", NM="_ZNK4llvm12TargetFolder19CreateSExtOrBitCastEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder19CreateSExtOrBitCastEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public Constant /*P*/ CreateSExtOrBitCast(Constant /*P*/ C, Type /*P*/ DestTy) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateTruncOrBitCast">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 209,
   FQN="llvm::TargetFolder::CreateTruncOrBitCast", NM="_ZNK4llvm12TargetFolder20CreateTruncOrBitCastEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder20CreateTruncOrBitCastEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public Constant /*P*/ CreateTruncOrBitCast(Constant /*P*/ C, Type /*P*/ DestTy) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreatePointerBitCastOrAddrSpaceCast">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 215,
   FQN="llvm::TargetFolder::CreatePointerBitCastOrAddrSpaceCast", NM="_ZNK4llvm12TargetFolder35CreatePointerBitCastOrAddrSpaceCastEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder35CreatePointerBitCastOrAddrSpaceCastEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public Constant /*P*/ CreatePointerBitCastOrAddrSpaceCast(Constant /*P*/ C, 
                                     Type /*P*/ DestTy) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //===--------------------------------------------------------------------===//
  // Compare Instructions
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateICmp">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 226,
   FQN="llvm::TargetFolder::CreateICmp", NM="_ZNK4llvm12TargetFolder10CreateICmpENS_7CmpInst9PredicateEPNS_8ConstantES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder10CreateICmpENS_7CmpInst9PredicateEPNS_8ConstantES4_")
  //</editor-fold>
  public Constant /*P*/ CreateICmp(CmpInst.Predicate P, Constant /*P*/ LHS, 
            Constant /*P*/ RHS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateFCmp">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 230,
   FQN="llvm::TargetFolder::CreateFCmp", NM="_ZNK4llvm12TargetFolder10CreateFCmpENS_7CmpInst9PredicateEPNS_8ConstantES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder10CreateFCmpENS_7CmpInst9PredicateEPNS_8ConstantES4_")
  //</editor-fold>
  public Constant /*P*/ CreateFCmp(CmpInst.Predicate P, Constant /*P*/ LHS, 
            Constant /*P*/ RHS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //===--------------------------------------------------------------------===//
  // Other Instructions
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateSelect">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 239,
   FQN="llvm::TargetFolder::CreateSelect", NM="_ZNK4llvm12TargetFolder12CreateSelectEPNS_8ConstantES2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder12CreateSelectEPNS_8ConstantES2_S2_")
  //</editor-fold>
  public Constant /*P*/ CreateSelect(Constant /*P*/ C, Constant /*P*/ True, Constant /*P*/ False) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateExtractElement">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 243,
   FQN="llvm::TargetFolder::CreateExtractElement", NM="_ZNK4llvm12TargetFolder20CreateExtractElementEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder20CreateExtractElementEPNS_8ConstantES2_")
  //</editor-fold>
  public Constant /*P*/ CreateExtractElement(Constant /*P*/ Vec, Constant /*P*/ Idx) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateInsertElement">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 247,
   FQN="llvm::TargetFolder::CreateInsertElement", NM="_ZNK4llvm12TargetFolder19CreateInsertElementEPNS_8ConstantES2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder19CreateInsertElementEPNS_8ConstantES2_S2_")
  //</editor-fold>
  public Constant /*P*/ CreateInsertElement(Constant /*P*/ Vec, Constant /*P*/ NewElt, 
                     Constant /*P*/ Idx) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateShuffleVector">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 252,
   FQN="llvm::TargetFolder::CreateShuffleVector", NM="_ZNK4llvm12TargetFolder19CreateShuffleVectorEPNS_8ConstantES2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder19CreateShuffleVectorEPNS_8ConstantES2_S2_")
  //</editor-fold>
  public Constant /*P*/ CreateShuffleVector(Constant /*P*/ V1, Constant /*P*/ V2, 
                     Constant /*P*/ Mask) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateExtractValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 257,
   FQN="llvm::TargetFolder::CreateExtractValue", NM="_ZNK4llvm12TargetFolder18CreateExtractValueEPNS_8ConstantENS_8ArrayRefIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder18CreateExtractValueEPNS_8ConstantENS_8ArrayRefIjEE")
  //</editor-fold>
  public Constant /*P*/ CreateExtractValue(Constant /*P*/ Agg, 
                    ArrayRefUInt IdxList) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::CreateInsertValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 262,
   FQN="llvm::TargetFolder::CreateInsertValue", NM="_ZNK4llvm12TargetFolder17CreateInsertValueEPNS_8ConstantES2_NS_8ArrayRefIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZNK4llvm12TargetFolder17CreateInsertValueEPNS_8ConstantES2_NS_8ArrayRefIjEE")
  //</editor-fold>
  public Constant /*P*/ CreateInsertValue(Constant /*P*/ Agg, Constant /*P*/ Val, 
                   ArrayRefUInt IdxList) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetFolder::TargetFolder">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetFolder.h", line = 32,
   FQN="llvm::TargetFolder::TargetFolder", NM="_ZN4llvm12TargetFolderC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZN4llvm12TargetFolderC1ERKS0_")
  //</editor-fold>
  public /*inline*/ TargetFolder(final /*const*/ TargetFolder /*&*/ $Prm0) {
    // : DL(.DL) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public TargetFolder clone() {
    return new TargetFolder(this);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "DL=" + DL; // NOI18N
  }
}
