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

package org.clang.analysis.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.analysis.*;
import static org.clang.ast.java.AstStatementsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinterHelper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4006,
 FQN="(anonymous namespace)::StmtPrinterHelper", NM="_ZN12_GLOBAL__N_117StmtPrinterHelperE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_117StmtPrinterHelperE")
//</editor-fold>
public class StmtPrinterHelper extends /*public*/ PrinterHelper implements Destructors.ClassWithDestructor {
  /*typedef llvm::DenseMap<const Stmt *, std::pair<unsigned int, unsigned int> > StmtMapTy*/
//  public final class StmtMapTy extends DenseMap</*const*/ Stmt /*P*/ , std.pairUIntUInt>{ };
  /*typedef llvm::DenseMap<const Decl *, std::pair<unsigned int, unsigned int> > DeclMapTy*/
//  public final class DeclMapTy extends DenseMap</*const*/ Decl /*P*/ , std.pairUIntUInt>{ };
  private DenseMap</*const*/ Stmt /*P*/ , std.pairUIntUInt> StmtMap;
  private DenseMap</*const*/ Decl /*P*/ , std.pairUIntUInt> DeclMap;
  private int currentBlock;
  private /*uint*/int currStmt;
  private final /*const*/ LangOptions /*&*/ LangOpts;
/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinterHelper::StmtPrinterHelper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4016,
   FQN="(anonymous namespace)::StmtPrinterHelper::StmtPrinterHelper", NM="_ZN12_GLOBAL__N_117StmtPrinterHelperC1EPKN5clang3CFGERKNS1_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_117StmtPrinterHelperC1EPKN5clang3CFGERKNS1_11LangOptionsE")
  //</editor-fold>
  public StmtPrinterHelper(/*const*/ CFG /*P*/ cfg, final /*const*/ LangOptions /*&*/ LO) {
    // : PrinterHelper(), StmtMap(), DeclMap(), currentBlock(0), currStmt(0), LangOpts(LO) 
    //START JInit
    super();
    this.StmtMap = new DenseMap</*const*/ Stmt /*P*/ , std.pairUIntUInt>(DenseMapInfo$LikePtr.$Info(), new std.pairUIntUInt());
    this.DeclMap = new DenseMap</*const*/ Decl /*P*/ , std.pairUIntUInt>(DenseMapInfo$LikePtr.$Info(), new std.pairUIntUInt());
    this.currentBlock = 0;
    this.currStmt = 0;
    this./*&*/LangOpts=/*&*/LO;
    //END JInit
    for (type$ptr<CFGBlock> I = $tryClone(cfg.begin$Const()), /*P*/ E = $tryClone(cfg.end$Const()); $noteq_ptr(I, E); I.$preInc()) {
      /*uint*/int j = 1;
      for (std.reverse_iterator</*const*/ CFGElement> BI = new std.reverse_iterator</*const*/ CFGElement>(JD$Reverse_iterator$_Iter$C.INSTANCE, (I.$star()).begin()), BEnd = new std.reverse_iterator</*const*/ CFGElement>(JD$Reverse_iterator$_Iter$C.INSTANCE, (I.$star()).end());
           $noteq_reverse_iterator$C(BI, BEnd); BI.$preInc() , ++j) {
        {
          Optional<CFGStmt> SE = BI.$arrow().getAs(CFGStmt.class);
          if (SE.$bool()) {
            /*const*/ Stmt /*P*/ stmt = SE.$arrow().getStmt();
            std.pairUIntUInt P/*J*/= new std.pairUIntUInt(JD$T$RR_T1$RR.INSTANCE, (I.$star()).getBlockID(), j);
            StmtMap.$at_T1$C$R(stmt).$assign(P);
            switch (stmt.getStmtClass()) {
             case DeclStmtClass:
              DeclMap.$at_T1$RR(cast_DeclStmt(stmt).getSingleDecl$Const()).$assign(P);
              break;
             case IfStmtClass:
              {
                /*const*/ VarDecl /*P*/ var = cast_IfStmt(stmt).getConditionVariable();
                if ((var != null)) {
                  DeclMap.$at_T1$RR(var).$assign(P);
                }
                break;
              }
             case ForStmtClass:
              {
                /*const*/ VarDecl /*P*/ var = cast_ForStmt(stmt).getConditionVariable();
                if ((var != null)) {
                  DeclMap.$at_T1$RR(var).$assign(P);
                }
                break;
              }
             case WhileStmtClass:
              {
                /*const*/ VarDecl /*P*/ var = cast_WhileStmt(stmt).getConditionVariable();
                if ((var != null)) {
                  DeclMap.$at_T1$RR(var).$assign(P);
                }
                break;
              }
             case SwitchStmtClass:
              {
                /*const*/ VarDecl /*P*/ var = cast_SwitchStmt(stmt).getConditionVariable();
                if ((var != null)) {
                  DeclMap.$at_T1$RR(var).$assign(P);
                }
                break;
              }
             case CXXCatchStmtClass:
              {
                /*const*/ VarDecl /*P*/ var = cast_CXXCatchStmt(stmt).getExceptionDecl();
                if ((var != null)) {
                  DeclMap.$at_T1$RR(var).$assign(P);
                }
                break;
              }
             default:
              break;
            }
          }
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinterHelper::~StmtPrinterHelper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4073,
   FQN="(anonymous namespace)::StmtPrinterHelper::~StmtPrinterHelper", NM="_ZN12_GLOBAL__N_117StmtPrinterHelperD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_117StmtPrinterHelperD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    //START JDestroy
    DeclMap.$destroy();
    StmtMap.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinterHelper::getLangOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4075,
   FQN="(anonymous namespace)::StmtPrinterHelper::getLangOpts", NM="_ZNK12_GLOBAL__N_117StmtPrinterHelper11getLangOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK12_GLOBAL__N_117StmtPrinterHelper11getLangOptsEv")
  //</editor-fold>
  public /*const*/ LangOptions /*&*/ getLangOpts() /*const*/ {
    return LangOpts;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinterHelper::setBlockID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4076,
   FQN="(anonymous namespace)::StmtPrinterHelper::setBlockID", NM="_ZN12_GLOBAL__N_117StmtPrinterHelper10setBlockIDEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_117StmtPrinterHelper10setBlockIDEi")
  //</editor-fold>
  public void setBlockID(int i) {
    currentBlock = i;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinterHelper::setStmtID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4077,
   FQN="(anonymous namespace)::StmtPrinterHelper::setStmtID", NM="_ZN12_GLOBAL__N_117StmtPrinterHelper9setStmtIDEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_117StmtPrinterHelper9setStmtIDEj")
  //</editor-fold>
  public void setStmtID(/*uint*/int i) {
    currStmt = i;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinterHelper::handledStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4079,
   FQN="(anonymous namespace)::StmtPrinterHelper::handledStmt", NM="_ZN12_GLOBAL__N_117StmtPrinterHelper11handledStmtEPN5clang4StmtERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_117StmtPrinterHelper11handledStmtEPN5clang4StmtERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public boolean handledStmt(Stmt /*P*/ S, final raw_ostream /*&*/ OS)/* override*/ {
    DenseMapIterator</*const*/ Stmt /*P*/ , std.pairUIntUInt> I = StmtMap.find(S);
    if (I.$eq(/*NO_ITER_COPY*/StmtMap.end())) {
      return false;
    }
    if (currentBlock >= 0 && I.$arrow().second.first == (/*uint*/int)currentBlock
       && I.$arrow().second.second == currStmt) {
      return false;
    }
    
    OS.$out(/*KEEP_STR*/"[B").$out_uint(I.$arrow().second.first).$out(/*KEEP_STR*/$DOT).$out_uint(I.$arrow().second.second).$out(/*KEEP_STR*/$RSQUARE);
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtPrinterHelper::handleDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4094,
   FQN="(anonymous namespace)::StmtPrinterHelper::handleDecl", NM="_ZN12_GLOBAL__N_117StmtPrinterHelper10handleDeclEPKN5clang4DeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_117StmtPrinterHelper10handleDeclEPKN5clang4DeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  public boolean handleDecl(/*const*/ Decl /*P*/ D, final raw_ostream /*&*/ OS) {
    DenseMapIterator</*const*/ Decl /*P*/ , std.pairUIntUInt> I = DeclMap.find(D);
    if (I.$eq(/*NO_ITER_COPY*/DeclMap.end())) {
      return false;
    }
    if (currentBlock >= 0 && I.$arrow().second.first == (/*uint*/int)currentBlock
       && I.$arrow().second.second == currStmt) {
      return false;
    }
    
    OS.$out(/*KEEP_STR*/"[B").$out_uint(I.$arrow().second.first).$out(/*KEEP_STR*/$DOT).$out_uint(I.$arrow().second.second).$out(/*KEEP_STR*/$RSQUARE);
    return true;
  }

  
  @Override public String toString() {
    return "" + "StmtMap=" + StmtMap // NOI18N
              + ", DeclMap=" + DeclMap // NOI18N
              + ", currentBlock=" + currentBlock // NOI18N
              + ", currStmt=" + currStmt // NOI18N
              + ", LangOpts=" + LangOpts // NOI18N
              + super.toString(); // NOI18N
  }
}
