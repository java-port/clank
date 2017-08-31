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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.llvmc.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IRFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.cl.*;
import org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.ir.java.IRMemberPointers.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;
import org.llvm.support.dwarf.Tag;
import org.llvm.support.sys.SmartRWMutex;
import org.llvm.ir.java.cst_pred_ty_Predicate;
import org.llvm.ir.legacy.PassManagerBase;
import org.llvm.ir.PassManagerGlobals.*;
import org.llvm.ir.java.MDNodeKeyImpl;
import static org.llvm.adt.HashingGlobals.*;


/// NoFolder - Create "constants" (actually, instructions) with no folding.
//<editor-fold defaultstate="collapsed" desc="llvm::NoFolder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 32,
 FQN="llvm::NoFolder", NM="_ZN4llvm8NoFolderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZN4llvm8NoFolderE")
//</editor-fold>
public class NoFolder implements org.llvm.ir.java.IFolder<Constant, Instruction> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::NoFolder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 34,
   FQN="llvm::NoFolder::NoFolder", NM="_ZN4llvm8NoFolderC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZN4llvm8NoFolderC1Ev")
  //</editor-fold>
  public /*explicit*/ NoFolder() {
  }


  //===--------------------------------------------------------------------===//
  // Binary Operators
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 40,
   FQN="llvm::NoFolder::CreateAdd", NM="_ZNK4llvm8NoFolder9CreateAddEPNS_8ConstantES2_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder9CreateAddEPNS_8ConstantES2_bb")
  //</editor-fold>
  public Instruction /*P*/ CreateAdd(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return CreateAdd(LHS, RHS,
           false, false);
  }
  public Instruction /*P*/ CreateAdd(Constant /*P*/ LHS, Constant /*P*/ RHS,
           boolean HasNUW/*= false*/) /*const*/ {
    return CreateAdd(LHS, RHS,
           HasNUW, false);
  }
  public Instruction /*P*/ CreateAdd(Constant /*P*/ LHS, Constant /*P*/ RHS,
           boolean HasNUW/*= false*/, boolean HasNSW/*= false*/) /*const*/ {
    BinaryOperator /*P*/ BO = BinaryOperator.CreateAdd(LHS, RHS);
    if (HasNUW) {
      BO.setHasNoUnsignedWrap();
    }
    if (HasNSW) {
      BO.setHasNoSignedWrap();
    }
    return BO;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateNSWAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 47,
   FQN="llvm::NoFolder::CreateNSWAdd", NM="_ZNK4llvm8NoFolder12CreateNSWAddEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder12CreateNSWAddEPNS_8ConstantES2_")
  //</editor-fold>
  public Instruction /*P*/ CreateNSWAdd(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return BinaryOperator.CreateNSWAdd(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateNUWAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 50,
   FQN="llvm::NoFolder::CreateNUWAdd", NM="_ZNK4llvm8NoFolder12CreateNUWAddEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder12CreateNUWAddEPNS_8ConstantES2_")
  //</editor-fold>
  public Instruction /*P*/ CreateNUWAdd(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return BinaryOperator.CreateNUWAdd(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateFAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 53,
   FQN="llvm::NoFolder::CreateFAdd", NM="_ZNK4llvm8NoFolder10CreateFAddEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder10CreateFAddEPNS_8ConstantES2_")
  //</editor-fold>
  public Instruction /*P*/ CreateFAdd(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return BinaryOperator.CreateFAdd(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 56,
   FQN="llvm::NoFolder::CreateSub", NM="_ZNK4llvm8NoFolder9CreateSubEPNS_8ConstantES2_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder9CreateSubEPNS_8ConstantES2_bb")
  //</editor-fold>
  public Instruction /*P*/ CreateSub(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return CreateSub(LHS, RHS,
           false, false);
  }
  public Instruction /*P*/ CreateSub(Constant /*P*/ LHS, Constant /*P*/ RHS,
           boolean HasNUW/*= false*/) /*const*/ {
    return CreateSub(LHS, RHS,
           HasNUW, false);
  }
  public Instruction /*P*/ CreateSub(Constant /*P*/ LHS, Constant /*P*/ RHS,
           boolean HasNUW/*= false*/, boolean HasNSW/*= false*/) /*const*/ {
    BinaryOperator /*P*/ BO = BinaryOperator.CreateSub(LHS, RHS);
    if (HasNUW) {
      BO.setHasNoUnsignedWrap();
    }
    if (HasNSW) {
      BO.setHasNoSignedWrap();
    }
    return BO;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateNSWSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 63,
   FQN="llvm::NoFolder::CreateNSWSub", NM="_ZNK4llvm8NoFolder12CreateNSWSubEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder12CreateNSWSubEPNS_8ConstantES2_")
  //</editor-fold>
  public Instruction /*P*/ CreateNSWSub(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return BinaryOperator.CreateNSWSub(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateNUWSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 66,
   FQN="llvm::NoFolder::CreateNUWSub", NM="_ZNK4llvm8NoFolder12CreateNUWSubEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder12CreateNUWSubEPNS_8ConstantES2_")
  //</editor-fold>
  public Instruction /*P*/ CreateNUWSub(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return BinaryOperator.CreateNUWSub(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateFSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 69,
   FQN="llvm::NoFolder::CreateFSub", NM="_ZNK4llvm8NoFolder10CreateFSubEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder10CreateFSubEPNS_8ConstantES2_")
  //</editor-fold>
  public Instruction /*P*/ CreateFSub(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return BinaryOperator.CreateFSub(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 72,
   FQN="llvm::NoFolder::CreateMul", NM="_ZNK4llvm8NoFolder9CreateMulEPNS_8ConstantES2_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder9CreateMulEPNS_8ConstantES2_bb")
  //</editor-fold>
  public Instruction /*P*/ CreateMul(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return CreateMul(LHS, RHS,
           false, false);
  }
  public Instruction /*P*/ CreateMul(Constant /*P*/ LHS, Constant /*P*/ RHS,
           boolean HasNUW/*= false*/) /*const*/ {
    return CreateMul(LHS, RHS,
           HasNUW, false);
  }
  public Instruction /*P*/ CreateMul(Constant /*P*/ LHS, Constant /*P*/ RHS,
           boolean HasNUW/*= false*/, boolean HasNSW/*= false*/) /*const*/ {
    BinaryOperator /*P*/ BO = BinaryOperator.CreateMul(LHS, RHS);
    if (HasNUW) {
      BO.setHasNoUnsignedWrap();
    }
    if (HasNSW) {
      BO.setHasNoSignedWrap();
    }
    return BO;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateNSWMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 79,
   FQN="llvm::NoFolder::CreateNSWMul", NM="_ZNK4llvm8NoFolder12CreateNSWMulEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder12CreateNSWMulEPNS_8ConstantES2_")
  //</editor-fold>
  public Instruction /*P*/ CreateNSWMul(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return BinaryOperator.CreateNSWMul(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateNUWMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 82,
   FQN="llvm::NoFolder::CreateNUWMul", NM="_ZNK4llvm8NoFolder12CreateNUWMulEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder12CreateNUWMulEPNS_8ConstantES2_")
  //</editor-fold>
  public Instruction /*P*/ CreateNUWMul(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return BinaryOperator.CreateNUWMul(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateFMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 85,
   FQN="llvm::NoFolder::CreateFMul", NM="_ZNK4llvm8NoFolder10CreateFMulEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder10CreateFMulEPNS_8ConstantES2_")
  //</editor-fold>
  public Instruction /*P*/ CreateFMul(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return BinaryOperator.CreateFMul(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateUDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 88,
   FQN="llvm::NoFolder::CreateUDiv", NM="_ZNK4llvm8NoFolder10CreateUDivEPNS_8ConstantES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder10CreateUDivEPNS_8ConstantES2_b")
  //</editor-fold>
  public Instruction /*P*/ CreateUDiv(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return CreateUDiv(LHS, RHS,
            false);
  }
  public Instruction /*P*/ CreateUDiv(Constant /*P*/ LHS, Constant /*P*/ RHS,
            boolean isExact/*= false*/) /*const*/ {
    if (!isExact) {
      return BinaryOperator.CreateUDiv(LHS, RHS);
    }
    return BinaryOperator.CreateExactUDiv(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateExactUDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 94,
   FQN="llvm::NoFolder::CreateExactUDiv", NM="_ZNK4llvm8NoFolder15CreateExactUDivEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder15CreateExactUDivEPNS_8ConstantES2_")
  //</editor-fold>
  public Instruction /*P*/ CreateExactUDiv(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return BinaryOperator.CreateExactUDiv(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateSDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 97,
   FQN="llvm::NoFolder::CreateSDiv", NM="_ZNK4llvm8NoFolder10CreateSDivEPNS_8ConstantES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder10CreateSDivEPNS_8ConstantES2_b")
  //</editor-fold>
  public Instruction /*P*/ CreateSDiv(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return CreateSDiv(LHS, RHS,
            false);
  }
  public Instruction /*P*/ CreateSDiv(Constant /*P*/ LHS, Constant /*P*/ RHS,
            boolean isExact/*= false*/) /*const*/ {
    if (!isExact) {
      return BinaryOperator.CreateSDiv(LHS, RHS);
    }
    return BinaryOperator.CreateExactSDiv(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateExactSDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 103,
   FQN="llvm::NoFolder::CreateExactSDiv", NM="_ZNK4llvm8NoFolder15CreateExactSDivEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder15CreateExactSDivEPNS_8ConstantES2_")
  //</editor-fold>
  public Instruction /*P*/ CreateExactSDiv(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return BinaryOperator.CreateExactSDiv(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateFDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 106,
   FQN="llvm::NoFolder::CreateFDiv", NM="_ZNK4llvm8NoFolder10CreateFDivEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder10CreateFDivEPNS_8ConstantES2_")
  //</editor-fold>
  public Instruction /*P*/ CreateFDiv(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return BinaryOperator.CreateFDiv(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateURem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 109,
   FQN="llvm::NoFolder::CreateURem", NM="_ZNK4llvm8NoFolder10CreateURemEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder10CreateURemEPNS_8ConstantES2_")
  //</editor-fold>
  public Instruction /*P*/ CreateURem(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return BinaryOperator.CreateURem(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateSRem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 112,
   FQN="llvm::NoFolder::CreateSRem", NM="_ZNK4llvm8NoFolder10CreateSRemEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder10CreateSRemEPNS_8ConstantES2_")
  //</editor-fold>
  public Instruction /*P*/ CreateSRem(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return BinaryOperator.CreateSRem(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateFRem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 115,
   FQN="llvm::NoFolder::CreateFRem", NM="_ZNK4llvm8NoFolder10CreateFRemEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder10CreateFRemEPNS_8ConstantES2_")
  //</editor-fold>
  public Instruction /*P*/ CreateFRem(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return BinaryOperator.CreateFRem(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateShl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 118,
   FQN="llvm::NoFolder::CreateShl", NM="_ZNK4llvm8NoFolder9CreateShlEPNS_8ConstantES2_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder9CreateShlEPNS_8ConstantES2_bb")
  //</editor-fold>
  public Instruction /*P*/ CreateShl(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return CreateShl(LHS, RHS, false,
           false);
  }
  public Instruction /*P*/ CreateShl(Constant /*P*/ LHS, Constant /*P*/ RHS, boolean HasNUW/*= false*/) /*const*/ {
    return CreateShl(LHS, RHS, HasNUW,
           false);
  }
  public Instruction /*P*/ CreateShl(Constant /*P*/ LHS, Constant /*P*/ RHS, boolean HasNUW/*= false*/,
           boolean HasNSW/*= false*/) /*const*/ {
    BinaryOperator /*P*/ BO = BinaryOperator.CreateShl(LHS, RHS);
    if (HasNUW) {
      BO.setHasNoUnsignedWrap();
    }
    if (HasNSW) {
      BO.setHasNoSignedWrap();
    }
    return BO;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateLShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 125,
   FQN="llvm::NoFolder::CreateLShr", NM="_ZNK4llvm8NoFolder10CreateLShrEPNS_8ConstantES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder10CreateLShrEPNS_8ConstantES2_b")
  //</editor-fold>
  public Instruction /*P*/ CreateLShr(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return CreateLShr(LHS, RHS,
            false);
  }
  public Instruction /*P*/ CreateLShr(Constant /*P*/ LHS, Constant /*P*/ RHS,
            boolean isExact/*= false*/) /*const*/ {
    if (!isExact) {
      return BinaryOperator.CreateLShr(LHS, RHS);
    }
    return BinaryOperator.CreateExactLShr(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateAShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 131,
   FQN="llvm::NoFolder::CreateAShr", NM="_ZNK4llvm8NoFolder10CreateAShrEPNS_8ConstantES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder10CreateAShrEPNS_8ConstantES2_b")
  //</editor-fold>
  public Instruction /*P*/ CreateAShr(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return CreateAShr(LHS, RHS,
            false);
  }
  public Instruction /*P*/ CreateAShr(Constant /*P*/ LHS, Constant /*P*/ RHS,
            boolean isExact/*= false*/) /*const*/ {
    if (!isExact) {
      return BinaryOperator.CreateAShr(LHS, RHS);
    }
    return BinaryOperator.CreateExactAShr(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateAnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 137,
   FQN="llvm::NoFolder::CreateAnd", NM="_ZNK4llvm8NoFolder9CreateAndEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder9CreateAndEPNS_8ConstantES2_")
  //</editor-fold>
  public Instruction /*P*/ CreateAnd(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return BinaryOperator.CreateAnd(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateOr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 140,
   FQN="llvm::NoFolder::CreateOr", NM="_ZNK4llvm8NoFolder8CreateOrEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder8CreateOrEPNS_8ConstantES2_")
  //</editor-fold>
  public Instruction /*P*/ CreateOr(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return BinaryOperator.CreateOr(LHS, RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateXor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 143,
   FQN="llvm::NoFolder::CreateXor", NM="_ZNK4llvm8NoFolder9CreateXorEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder9CreateXorEPNS_8ConstantES2_")
  //</editor-fold>
  public Instruction /*P*/ CreateXor(Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return BinaryOperator.CreateXor(LHS, RHS);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateBinOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 147,
   FQN="llvm::NoFolder::CreateBinOp", NM="_ZNK4llvm8NoFolder11CreateBinOpENS_11Instruction9BinaryOpsEPNS_8ConstantES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder11CreateBinOpENS_11Instruction9BinaryOpsEPNS_8ConstantES4_")
  //</editor-fold>
  public Instruction /*P*/ CreateBinOp(/*BinaryOps*/int Opc,
             Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return BinaryOperator.Create(Opc, LHS, RHS);
  }


  //===--------------------------------------------------------------------===//
  // Unary Operators
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateNeg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 156,
   FQN="llvm::NoFolder::CreateNeg", NM="_ZNK4llvm8NoFolder9CreateNegEPNS_8ConstantEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder9CreateNegEPNS_8ConstantEbb")
  //</editor-fold>
  public Instruction /*P*/ CreateNeg(Constant /*P*/ C) /*const*/ {
    return CreateNeg(C,
           false, false);
  }
  public Instruction /*P*/ CreateNeg(Constant /*P*/ C,
           boolean HasNUW/*= false*/) /*const*/ {
    return CreateNeg(C,
           HasNUW, false);
  }
  public Instruction /*P*/ CreateNeg(Constant /*P*/ C,
           boolean HasNUW/*= false*/, boolean HasNSW/*= false*/) /*const*/ {
    BinaryOperator /*P*/ BO = BinaryOperator.CreateNeg(C);
    if (HasNUW) {
      BO.setHasNoUnsignedWrap();
    }
    if (HasNSW) {
      BO.setHasNoSignedWrap();
    }
    return BO;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateNSWNeg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 163,
   FQN="llvm::NoFolder::CreateNSWNeg", NM="_ZNK4llvm8NoFolder12CreateNSWNegEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder12CreateNSWNegEPNS_8ConstantE")
  //</editor-fold>
  public Instruction /*P*/ CreateNSWNeg(Constant /*P*/ C) /*const*/ {
    return BinaryOperator.CreateNSWNeg(C);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateNUWNeg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 166,
   FQN="llvm::NoFolder::CreateNUWNeg", NM="_ZNK4llvm8NoFolder12CreateNUWNegEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder12CreateNUWNegEPNS_8ConstantE")
  //</editor-fold>
  public Instruction /*P*/ CreateNUWNeg(Constant /*P*/ C) /*const*/ {
    return BinaryOperator.CreateNUWNeg(C);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateFNeg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 169,
   FQN="llvm::NoFolder::CreateFNeg", NM="_ZNK4llvm8NoFolder10CreateFNegEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder10CreateFNegEPNS_8ConstantE")
  //</editor-fold>
  public Instruction /*P*/ CreateFNeg(Constant /*P*/ C) /*const*/ {
    return BinaryOperator.CreateFNeg(C);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateNot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 172,
   FQN="llvm::NoFolder::CreateNot", NM="_ZNK4llvm8NoFolder9CreateNotEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder9CreateNotEPNS_8ConstantE")
  //</editor-fold>
  public Instruction /*P*/ CreateNot(Constant /*P*/ C) /*const*/ {
    return BinaryOperator.CreateNot(C);
  }


  //===--------------------------------------------------------------------===//
  // Memory Instructions
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateGetElementPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 180,
   FQN="llvm::NoFolder::CreateGetElementPtr", NM="_ZNK4llvm8NoFolder19CreateGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIS4_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder19CreateGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIS4_EE")
  //</editor-fold>
  public Constant /*P*/ CreateGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P(Type /*P*/ Ty, Constant /*P*/ C,
                                                           ArrayRef<Constant /*P*/ > IdxList) /*const*/ {
    return ConstantExpr.getGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P_bool_Type$P(Ty, C, new ArrayRef<Constant /*P*/ >(IdxList));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateGetElementPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 184,
   FQN="llvm::NoFolder::CreateGetElementPtr", NM="_ZNK4llvm8NoFolder19CreateGetElementPtrEPNS_4TypeEPNS_8ConstantES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder19CreateGetElementPtrEPNS_4TypeEPNS_8ConstantES4_")
  //</editor-fold>
  public Constant /*P*/ CreateGetElementPtr(Type /*P*/ Ty, Constant /*P*/ C, Constant /*P*/ Idx) /*const*/ {
    // This form of the function only exists to avoid ambiguous overload
    // warnings about whether to convert Idx to ArrayRef<Constant *> or
    // ArrayRef<Value *>.
    return ConstantExpr.getGetElementPtr(Ty, C, Idx);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateGetElementPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 190,
   FQN="llvm::NoFolder::CreateGetElementPtr", NM="_ZNK4llvm8NoFolder19CreateGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIPNS_5ValueEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder19CreateGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIPNS_5ValueEEE")
  //</editor-fold>
  public Instruction /*P*/ CreateGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P(Type /*P*/ Ty, Constant /*P*/ C,
                                                        ArrayRef<Value /*P*/ > IdxList) /*const*/ {
    return GetElementPtrInst.Create1(Ty, C, new ArrayRef<Value /*P*/ >(IdxList));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateInBoundsGetElementPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 195,
   FQN="llvm::NoFolder::CreateInBoundsGetElementPtr", NM="_ZNK4llvm8NoFolder27CreateInBoundsGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIS4_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder27CreateInBoundsGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIS4_EE")
  //</editor-fold>
  public Constant /*P*/ CreateInBoundsGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P(Type /*P*/ Ty, Constant /*P*/ C,
                                                                   ArrayRef<Constant /*P*/ > IdxList) /*const*/ {
    return ConstantExpr.getInBoundsGetElementPtr_Type$P_Constant$P_ArrayRef$Constant$P(Ty, C, new ArrayRef<Constant /*P*/ >(IdxList));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateInBoundsGetElementPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 199,
   FQN="llvm::NoFolder::CreateInBoundsGetElementPtr", NM="_ZNK4llvm8NoFolder27CreateInBoundsGetElementPtrEPNS_4TypeEPNS_8ConstantES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder27CreateInBoundsGetElementPtrEPNS_4TypeEPNS_8ConstantES4_")
  //</editor-fold>
  public Constant /*P*/ CreateInBoundsGetElementPtr(Type /*P*/ Ty, Constant /*P*/ C,
                             Constant /*P*/ Idx) /*const*/ {
    // This form of the function only exists to avoid ambiguous overload
    // warnings about whether to convert Idx to ArrayRef<Constant *> or
    // ArrayRef<Value *>.
    return ConstantExpr.getInBoundsGetElementPtr(Ty, C, Idx);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateInBoundsGetElementPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 206,
   FQN="llvm::NoFolder::CreateInBoundsGetElementPtr", NM="_ZNK4llvm8NoFolder27CreateInBoundsGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIPNS_5ValueEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder27CreateInBoundsGetElementPtrEPNS_4TypeEPNS_8ConstantENS_8ArrayRefIPNS_5ValueEEE")
  //</editor-fold>
  public Instruction /*P*/ CreateInBoundsGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P(Type /*P*/ Ty, Constant /*P*/ C,
                                                                ArrayRef<Value /*P*/ > IdxList) /*const*/ {
    return GetElementPtrInst.CreateInBounds2(Ty, C, new ArrayRef<Value /*P*/ >(IdxList));
  }


  //===--------------------------------------------------------------------===//
  // Cast/Conversion Operators
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 215,
   FQN="llvm::NoFolder::CreateCast", NM="_ZNK4llvm8NoFolder10CreateCastENS_11Instruction7CastOpsEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder10CreateCastENS_11Instruction7CastOpsEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public Instruction /*P*/ CreateCast(/*CastOps*/int Op, Constant /*P*/ C,
            Type /*P*/ DestTy) /*const*/ {
    return CastInst.Create(Op, C, DestTy);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreatePointerCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 219,
   FQN="llvm::NoFolder::CreatePointerCast", NM="_ZNK4llvm8NoFolder17CreatePointerCastEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder17CreatePointerCastEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public Instruction /*P*/ CreatePointerCast(Constant /*P*/ C, Type /*P*/ DestTy) /*const*/ {
    return CastInst.CreatePointerCast(C, DestTy);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateIntCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 222,
   FQN="llvm::NoFolder::CreateIntCast", NM="_ZNK4llvm8NoFolder13CreateIntCastEPNS_8ConstantEPNS_4TypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder13CreateIntCastEPNS_8ConstantEPNS_4TypeEb")
  //</editor-fold>
  public Instruction /*P*/ CreateIntCast(Constant /*P*/ C, Type /*P*/ DestTy,
               boolean isSigned) /*const*/ {
    return CastInst.CreateIntegerCast(C, DestTy, isSigned);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateFPCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 226,
   FQN="llvm::NoFolder::CreateFPCast", NM="_ZNK4llvm8NoFolder12CreateFPCastEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder12CreateFPCastEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public Instruction /*P*/ CreateFPCast(Constant /*P*/ C, Type /*P*/ DestTy) /*const*/ {
    return CastInst.CreateFPCast(C, DestTy);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateBitCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 230,
   FQN="llvm::NoFolder::CreateBitCast", NM="_ZNK4llvm8NoFolder13CreateBitCastEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder13CreateBitCastEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public Instruction /*P*/ CreateBitCast(Constant /*P*/ C, Type /*P*/ DestTy) /*const*/ {
    return CreateCast(Instruction.CastOps.BitCast, C, DestTy);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateIntToPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 233,
   FQN="llvm::NoFolder::CreateIntToPtr", NM="_ZNK4llvm8NoFolder14CreateIntToPtrEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder14CreateIntToPtrEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public Instruction /*P*/ CreateIntToPtr(Constant /*P*/ C, Type /*P*/ DestTy) /*const*/ {
    return CreateCast(Instruction.CastOps.IntToPtr, C, DestTy);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreatePtrToInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 236,
   FQN="llvm::NoFolder::CreatePtrToInt", NM="_ZNK4llvm8NoFolder14CreatePtrToIntEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder14CreatePtrToIntEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public Instruction /*P*/ CreatePtrToInt(Constant /*P*/ C, Type /*P*/ DestTy) /*const*/ {
    return CreateCast(Instruction.CastOps.PtrToInt, C, DestTy);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateZExtOrBitCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 239,
   FQN="llvm::NoFolder::CreateZExtOrBitCast", NM="_ZNK4llvm8NoFolder19CreateZExtOrBitCastEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder19CreateZExtOrBitCastEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public Instruction /*P*/ CreateZExtOrBitCast(Constant /*P*/ C, Type /*P*/ DestTy) /*const*/ {
    return CastInst.CreateZExtOrBitCast(C, DestTy);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateSExtOrBitCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 242,
   FQN="llvm::NoFolder::CreateSExtOrBitCast", NM="_ZNK4llvm8NoFolder19CreateSExtOrBitCastEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder19CreateSExtOrBitCastEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public Instruction /*P*/ CreateSExtOrBitCast(Constant /*P*/ C, Type /*P*/ DestTy) /*const*/ {
    return CastInst.CreateSExtOrBitCast(C, DestTy);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateTruncOrBitCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 246,
   FQN="llvm::NoFolder::CreateTruncOrBitCast", NM="_ZNK4llvm8NoFolder20CreateTruncOrBitCastEPNS_8ConstantEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder20CreateTruncOrBitCastEPNS_8ConstantEPNS_4TypeE")
  //</editor-fold>
  public Instruction /*P*/ CreateTruncOrBitCast(Constant /*P*/ C, Type /*P*/ DestTy) /*const*/ {
    return CastInst.CreateTruncOrBitCast(C, DestTy);
  }


  //===--------------------------------------------------------------------===//
  // Compare Instructions
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateICmp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 254,
   FQN="llvm::NoFolder::CreateICmp", NM="_ZNK4llvm8NoFolder10CreateICmpENS_7CmpInst9PredicateEPNS_8ConstantES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder10CreateICmpENS_7CmpInst9PredicateEPNS_8ConstantES4_")
  //</editor-fold>
  public Instruction /*P*/ CreateICmp(CmpInst.Predicate P,
            Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return /*NEW_EXPR [CmpInst::new]*/CmpInst.$new_CmpInst((type$ptr<?> New$Mem)->{
        return new ICmpInst(P, LHS, RHS);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateFCmp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 258,
   FQN="llvm::NoFolder::CreateFCmp", NM="_ZNK4llvm8NoFolder10CreateFCmpENS_7CmpInst9PredicateEPNS_8ConstantES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder10CreateFCmpENS_7CmpInst9PredicateEPNS_8ConstantES4_")
  //</editor-fold>
  public Instruction /*P*/ CreateFCmp(CmpInst.Predicate P,
            Constant /*P*/ LHS, Constant /*P*/ RHS) /*const*/ {
    return /*NEW_EXPR [CmpInst::new]*/CmpInst.$new_CmpInst((type$ptr<?> New$Mem)->{
        return new FCmpInst(P, LHS, RHS);
     });
  }


  //===--------------------------------------------------------------------===//
  // Other Instructions
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateSelect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 267,
   FQN="llvm::NoFolder::CreateSelect", NM="_ZNK4llvm8NoFolder12CreateSelectEPNS_8ConstantES2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder12CreateSelectEPNS_8ConstantES2_S2_")
  //</editor-fold>
  public Instruction /*P*/ CreateSelect(Constant /*P*/ C,
              Constant /*P*/ True, Constant /*P*/ False) /*const*/ {
    return SelectInst.Create(C, True, False);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateExtractElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 272,
   FQN="llvm::NoFolder::CreateExtractElement", NM="_ZNK4llvm8NoFolder20CreateExtractElementEPNS_8ConstantES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder20CreateExtractElementEPNS_8ConstantES2_")
  //</editor-fold>
  public Instruction /*P*/ CreateExtractElement(Constant /*P*/ Vec, Constant /*P*/ Idx) /*const*/ {
    return ExtractElementInst.Create(Vec, Idx);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateInsertElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 276,
   FQN="llvm::NoFolder::CreateInsertElement", NM="_ZNK4llvm8NoFolder19CreateInsertElementEPNS_8ConstantES2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder19CreateInsertElementEPNS_8ConstantES2_S2_")
  //</editor-fold>
  public Instruction /*P*/ CreateInsertElement(Constant /*P*/ Vec, Constant /*P*/ NewElt,
                     Constant /*P*/ Idx) /*const*/ {
    return InsertElementInst.Create(Vec, NewElt, Idx);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateShuffleVector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 281,
   FQN="llvm::NoFolder::CreateShuffleVector", NM="_ZNK4llvm8NoFolder19CreateShuffleVectorEPNS_8ConstantES2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder19CreateShuffleVectorEPNS_8ConstantES2_S2_")
  //</editor-fold>
  public Instruction /*P*/ CreateShuffleVector(Constant /*P*/ V1, Constant /*P*/ V2,
                     Constant /*P*/ Mask) /*const*/ {
    return /*NEW_EXPR [ShuffleVectorInst::new]*/ShuffleVectorInst.$new_ShuffleVectorInst((type$ptr<?> New$Mem)->{
        return new ShuffleVectorInst(V1, V2, Mask);
     });
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateExtractValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 286,
   FQN="llvm::NoFolder::CreateExtractValue", NM="_ZNK4llvm8NoFolder18CreateExtractValueEPNS_8ConstantENS_8ArrayRefIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder18CreateExtractValueEPNS_8ConstantENS_8ArrayRefIjEE")
  //</editor-fold>
  public Instruction /*P*/ CreateExtractValue(Constant /*P*/ Agg,
                    ArrayRefUInt IdxList) /*const*/ {
    return ExtractValueInst.Create_Value1(Agg, new ArrayRefUInt(IdxList));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::NoFolder::CreateInsertValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/NoFolder.h", line = 291,
   FQN="llvm::NoFolder::CreateInsertValue", NM="_ZNK4llvm8NoFolder17CreateInsertValueEPNS_8ConstantES2_NS_8ArrayRefIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZNK4llvm8NoFolder17CreateInsertValueEPNS_8ConstantES2_NS_8ArrayRefIjEE")
  //</editor-fold>
  public Instruction /*P*/ CreateInsertValue(Constant /*P*/ Agg, Constant /*P*/ Val,
                   ArrayRefUInt IdxList) /*const*/ {
    return InsertValueInst.Create_Value$P_ArrayRefUInt_Twine$C_Instruction$P(Agg, Val, new ArrayRefUInt(IdxList));
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public /*explicit*/ NoFolder(NoFolder other) {
    throw new UnsupportedOperationException("EmptyBody");
  }
  @Override
  public NoFolder clone() {
    return new NoFolder(this);
  }
  @Override
  public Instruction CreatePointerBitCastOrAddrSpaceCast(Constant C, Type DestTy) {
    throw new UnsupportedOperationException("NoFolder does not support CreatePointerBitCastOrAddrSpaceCast");
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return ""; // NOI18N
  }
}
