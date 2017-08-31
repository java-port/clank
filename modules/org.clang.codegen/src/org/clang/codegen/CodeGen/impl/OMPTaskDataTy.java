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

package org.clang.codegen.CodeGen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.adt.ADTAliases.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::OMPTaskDataTy">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 91,
 FQN="clang::CodeGen::OMPTaskDataTy", NM="_ZN5clang7CodeGen13OMPTaskDataTyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen13OMPTaskDataTyE")
//</editor-fold>
public final class/*struct*/ OMPTaskDataTy implements Destructors.ClassWithDestructor {
  public SmallVector</*const*/ Expr /*P*/ > PrivateVars;
  public SmallVector</*const*/ Expr /*P*/ > PrivateCopies;
  public SmallVector</*const*/ Expr /*P*/ > FirstprivateVars;
  public SmallVector</*const*/ Expr /*P*/ > FirstprivateCopies;
  public SmallVector</*const*/ Expr /*P*/ > FirstprivateInits;
  public SmallVector</*const*/ Expr /*P*/ > LastprivateVars;
  public SmallVector</*const*/ Expr /*P*/ > LastprivateCopies;
  public SmallVector<std.pair<OpenMPDependClauseKind, /*const*/ Expr /*P*/ >> Dependences;
  public PointerBoolPair<Value /*P*/ > Final;
  public PointerBoolPair<Value /*P*/ > Schedule;
  public PointerBoolPair<Value /*P*/ > Priority;
  public /*uint*/int NumberOfParts/* = 0*/;
  public boolean Tied/* = true*/;
  public boolean Nogroup/* = false*/;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::OMPTaskDataTy::OMPTaskDataTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 91,
   FQN="clang::CodeGen::OMPTaskDataTy::OMPTaskDataTy", NM="_ZN5clang7CodeGen13OMPTaskDataTyC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen13OMPTaskDataTyC1Ev")
  //</editor-fold>
  public /*inline*/ OMPTaskDataTy() {
    // : PrivateVars(), PrivateCopies(), FirstprivateVars(), FirstprivateCopies(), FirstprivateInits(), LastprivateVars(), LastprivateCopies(), Dependences(), Final(), Schedule(), Priority(), NumberOfParts(0), Tied(true), Nogroup(false) 
    //START JInit
    this.PrivateVars = new SmallVector</*const*/ Expr /*P*/ >(4, (/*const*/ Expr /*P*/ )null);
    this.PrivateCopies = new SmallVector</*const*/ Expr /*P*/ >(4, (/*const*/ Expr /*P*/ )null);
    this.FirstprivateVars = new SmallVector</*const*/ Expr /*P*/ >(4, (/*const*/ Expr /*P*/ )null);
    this.FirstprivateCopies = new SmallVector</*const*/ Expr /*P*/ >(4, (/*const*/ Expr /*P*/ )null);
    this.FirstprivateInits = new SmallVector</*const*/ Expr /*P*/ >(4, (/*const*/ Expr /*P*/ )null);
    this.LastprivateVars = new SmallVector</*const*/ Expr /*P*/ >(4, (/*const*/ Expr /*P*/ )null);
    this.LastprivateCopies = new SmallVector</*const*/ Expr /*P*/ >(4, (/*const*/ Expr /*P*/ )null);
    this.Dependences = new SmallVector<std.pair<OpenMPDependClauseKind, /*const*/ Expr /*P*/ >>(4, new std.pairTypePtr<OpenMPDependClauseKind, /*const*/ Expr /*P*/ >(OpenMPDependClauseKind.valueOf(0), null));
    this.Final = new PointerBoolPair<Value /*P*/ >();
    this.Schedule = new PointerBoolPair<Value /*P*/ >();
    this.Priority = new PointerBoolPair<Value /*P*/ >();
    /*InClass*/this.NumberOfParts = 0;
    /*InClass*/this.Tied = true;
    /*InClass*/this.Nogroup = false;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::OMPTaskDataTy::~OMPTaskDataTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 91,
   FQN="clang::CodeGen::OMPTaskDataTy::~OMPTaskDataTy", NM="_ZN5clang7CodeGen13OMPTaskDataTyD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmtOpenMP.cpp -nm=_ZN5clang7CodeGen13OMPTaskDataTyD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Dependences.$destroy();
    LastprivateCopies.$destroy();
    LastprivateVars.$destroy();
    FirstprivateInits.$destroy();
    FirstprivateCopies.$destroy();
    FirstprivateVars.$destroy();
    PrivateCopies.$destroy();
    PrivateVars.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public uint$ref NumberOfParts_ref = new uint$ref(){
    @Override
    public int $deref() {
      return NumberOfParts;
    }
  
    @Override
    public int $set(int value) {
      NumberOfParts = value;
      return NumberOfParts;
    }
  };


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "PrivateVars=" + "[SmallVector$Expr]" // NOI18N
              + ", PrivateCopies=" + "[SmallVector$Expr]" // NOI18N
              + ", FirstprivateVars=" + "[SmallVector$Expr]" // NOI18N
              + ", FirstprivateCopies=" + "[SmallVector$Expr]" // NOI18N
              + ", FirstprivateInits=" + "[SmallVector$Expr]" // NOI18N
              + ", LastprivateVars=" + "[SmallVector$Expr]" // NOI18N
              + ", LastprivateCopies=" + "[SmallVector$Expr]" // NOI18N
              + ", Dependences=" + Dependences // NOI18N
              + ", Final=" + Final // NOI18N
              + ", Schedule=" + Schedule // NOI18N
              + ", Priority=" + Priority // NOI18N
              + ", NumberOfParts=" + NumberOfParts // NOI18N
              + ", Tied=" + Tied // NOI18N
              + ", Nogroup=" + Nogroup; // NOI18N
  }
}
