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

package org.clang.staticanalyzer.core.llvm.impl;

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.staticanalyzer.core.impl.ExprEngineStatics.*;
import static org.clang.ast.java.AstStatementsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<ExplodedNode * >">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 2515,
 FQN="llvm::DOTGraphTraits<ExplodedNode * >", NM="_ZN4llvm14DOTGraphTraitsIPN5clang4ento12ExplodedNodeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN4llvm14DOTGraphTraitsIPN5clang4ento12ExplodedNodeEEE")
//</editor-fold>
public class/*struct*/ DOTGraphTraitsExplodedNode$P extends /*public*/ DefaultDOTGraphTraits {
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<ExplodedNode * >::DOTGraphTraits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 2519,
   FQN="llvm::DOTGraphTraits<ExplodedNode * >::DOTGraphTraits", NM="_ZN4llvm14DOTGraphTraitsIPN5clang4ento12ExplodedNodeEEC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN4llvm14DOTGraphTraitsIPN5clang4ento12ExplodedNodeEEC1Eb")
  //</editor-fold>
  public DOTGraphTraitsExplodedNode$P() {
    this(false);
  }
  public DOTGraphTraitsExplodedNode$P(boolean isSimple/*= false*/) {
    // : DefaultDOTGraphTraits(isSimple) 
    //START JInit
    super(isSimple);
    //END JInit
  }

  
  // FIXME: Since we do not cache error nodes in ExprEngine now, this does not
  // work.
  //<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<ExplodedNode * >::getNodeAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 2523,
   FQN="llvm::DOTGraphTraits<ExplodedNode * >::getNodeAttributes", NM="_ZN4llvm14DOTGraphTraitsIPN5clang4ento12ExplodedNodeEE17getNodeAttributesEPKS3_Pv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN4llvm14DOTGraphTraitsIPN5clang4ento12ExplodedNodeEE17getNodeAttributesEPKS3_Pv")
  //</editor-fold>
  public static std.string getNodeAttributes(/*const*/ ExplodedNode /*P*/ N, Object/*void P*/ $Prm1) {
    return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<ExplodedNode * >::printLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 2544,
   FQN="llvm::DOTGraphTraits<ExplodedNode * >::printLocation", NM="_ZN4llvm14DOTGraphTraitsIPN5clang4ento12ExplodedNodeEE13printLocationERNS_11raw_ostreamENS1_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN4llvm14DOTGraphTraitsIPN5clang4ento12ExplodedNodeEE13printLocationERNS_11raw_ostreamENS1_14SourceLocationE")
  //</editor-fold>
  public static void printLocation(final raw_ostream /*&*/ Out, SourceLocation SLoc) {
    if (SLoc.isFileID()) {
      Out.$out(/*KEEP_STR*/"\\lline=").$out_uint(
          GraphPrintSourceManager.getExpansionLineNumber(/*NO_COPY*/SLoc)
      ).$out(
          /*KEEP_STR*/" col="
      ).$out_uint(
          GraphPrintSourceManager.getExpansionColumnNumber(/*NO_COPY*/SLoc)
      ).$out(
          /*KEEP_STR*/"\\l"
      );
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<ExplodedNode * >::getNodeLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 2554,
   FQN="llvm::DOTGraphTraits<ExplodedNode * >::getNodeLabel", NM="_ZN4llvm14DOTGraphTraitsIPN5clang4ento12ExplodedNodeEE12getNodeLabelEPKS3_Pv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN4llvm14DOTGraphTraitsIPN5clang4ento12ExplodedNodeEE12getNodeLabelEPKS3_Pv")
  //</editor-fold>
  public static std.string getNodeLabel(/*const*/ ExplodedNode /*P*/ N, Object/*void P*/ $Prm1) {
    raw_string_ostream Out = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    try {
      
      std.string sbuf/*J*/= new std.string();
      Out/*J*/= new raw_string_ostream(sbuf);
      
      // Program Location.
      ProgramPoint Loc = N.getLocation();
      switch (Loc.getKind()) {
       case BlockEntranceKind:
        {
          Out.$out(/*KEEP_STR*/"Block Entrance: B").$out_uint(
              Loc.castAs(BlockEntrance.class).getBlock().getBlockID()
          );
          {
            /*const*/ NamedDecl /*P*/ ND = dyn_cast_NamedDecl(Loc.getLocationContext().getDecl());
            if ((ND != null)) {
              Out.$out(/*KEEP_STR*/" (");
              ND.printName(Out);
              Out.$out(/*KEEP_STR*/$RPAREN);
            }
          }
          break;
        }
       case BlockExitKind:
        assert (false);
        break;
       case CallEnterKind:
        Out.$out(/*KEEP_STR*/"CallEnter");
        break;
       case CallExitBeginKind:
        Out.$out(/*KEEP_STR*/"CallExitBegin");
        break;
       case CallExitEndKind:
        Out.$out(/*KEEP_STR*/"CallExitEnd");
        break;
       case PostStmtPurgeDeadSymbolsKind:
        Out.$out(/*KEEP_STR*/"PostStmtPurgeDeadSymbols");
        break;
       case PreStmtPurgeDeadSymbolsKind:
        Out.$out(/*KEEP_STR*/"PreStmtPurgeDeadSymbols");
        break;
       case EpsilonKind:
        Out.$out(/*KEEP_STR*/"Epsilon Point");
        break;
       case PreImplicitCallKind:
        {
          ImplicitCallPoint PC = Loc.castAs(ImplicitCallPoint.class);
          Out.$out(/*KEEP_STR*/"PreCall: ");
          
          // FIXME: Get proper printing options.
          PC.getDecl().print(Out, new PrintingPolicy(new LangOptions()));
          DOTGraphTraitsExplodedNode$P.printLocation(Out, PC.getLocation());
          break;
        }
       case PostImplicitCallKind:
        {
          ImplicitCallPoint PC = Loc.castAs(ImplicitCallPoint.class);
          Out.$out(/*KEEP_STR*/"PostCall: ");
          
          // FIXME: Get proper printing options.
          PC.getDecl().print(Out, new PrintingPolicy(new LangOptions()));
          DOTGraphTraitsExplodedNode$P.printLocation(Out, PC.getLocation());
          break;
        }
       case PostInitializerKind:
        {
          Out.$out(/*KEEP_STR*/"PostInitializer: ");
          /*const*/ CXXCtorInitializer /*P*/ Init = Loc.castAs(PostInitializer.class).getInitializer();
          {
            /*const*/ FieldDecl /*P*/ FD = Init.getAnyMember();
            if ((FD != null)) {
              $out_raw_ostream_NamedDecl$C(Out, $Deref(FD));
            } else {
              QualType Ty = Init.getTypeSourceInfo().getType();
              Ty.$assignMove(Ty.getLocalUnqualifiedType());
              LangOptions LO/*J*/= new LangOptions(); // FIXME.
              Ty.print(Out, new PrintingPolicy(LO));
            }
          }
          break;
        }
       case BlockEdgeKind:
        {
          final /*const*/ BlockEdge /*&*/ E = Loc.castAs(BlockEdge.class);
          Out.$out(/*KEEP_STR*/"Edge: (B").$out_uint(E.getSrc().getBlockID()).$out(/*KEEP_STR*/", B").$out_uint(
              E.getDst().getBlockID()
          ).$out_char($$RPAREN);
          {
            
            /*const*/ Stmt /*P*/ T = E.getSrc().getTerminator$Const().$Stmt$C$P();
            if ((T != null)) {
              SourceLocation SLoc = T.getLocStart();
              
              Out.$out(/*KEEP_STR*/"\\|Terminator: ");
              LangOptions LO/*J*/= new LangOptions(); // FIXME.
              E.getSrc().printTerminator(Out, LO);
              if (SLoc.isFileID()) {
                Out.$out(/*KEEP_STR*/"\\lline=").$out_uint(
                    GraphPrintSourceManager.getExpansionLineNumber(/*NO_COPY*/SLoc)
                ).$out(
                    /*KEEP_STR*/" col="
                ).$out_uint(
                    GraphPrintSourceManager.getExpansionColumnNumber(/*NO_COPY*/SLoc)
                );
              }
              if (isa_SwitchStmt(T)) {
                /*const*/ Stmt /*P*/ Label = E.getDst().getLabel$Const();
                if ((Label != null)) {
                  {
                    /*const*/ CaseStmt /*P*/ C = dyn_cast_CaseStmt(Label);
                    if ((C != null)) {
                      Out.$out(/*KEEP_STR*/"\\lcase ");
                      LangOptions LO$1/*J*/= new LangOptions(); // FIXME.
                      if ((C.getLHS$Const() != null)) {
                        C.getLHS$Const().printPretty(Out, (PrinterHelper /*P*/ )null, new PrintingPolicy(LO$1));
                      }
                      {
                        
                        /*const*/ Stmt /*P*/ RHS = C.getRHS$Const();
                        if ((RHS != null)) {
                          Out.$out(/*KEEP_STR*/" .. ");
                          RHS.printPretty(Out, (PrinterHelper /*P*/ )null, new PrintingPolicy(LO$1));
                        }
                      }
                      
                      Out.$out(/*KEEP_STR*/$COLON);
                    } else {
                      assert (isa_DefaultStmt(Label));
                      Out.$out(/*KEEP_STR*/"\\ldefault:");
                    }
                  }
                } else {
                  Out.$out(/*KEEP_STR*/"\\l(implicit) default:");
                }
              } else if (isa_IndirectGotoStmt(T)) {
                // FIXME
              } else {
                Out.$out(/*KEEP_STR*/"\\lCondition: ");
                if (E.getSrc().succ_begin$Const().$star().$CFGBlock$P() == E.getDst()) {
                  Out.$out(/*KEEP_STR*/$true);
                } else {
                  Out.$out(/*KEEP_STR*/$false);
                }
              }
              
              Out.$out(/*KEEP_STR*/"\\l");
            }
          }
          break;
        }
       default:
        {
          /*const*/ Stmt /*P*/ S = Loc.castAs(StmtPoint.class).getStmt();
          assert (S != null) : "Expecting non-null Stmt";
          
          Out.$out(S.getStmtClassName()).$out_char($$SPACE).$out(reinterpret_cast(/*const*/Object/*void P*/ .class, S)).$out_char($$SPACE);
          LangOptions LO/*J*/= new LangOptions(); // FIXME.
          S.printPretty(Out, (PrinterHelper /*P*/ )null, new PrintingPolicy(LO));
          DOTGraphTraitsExplodedNode$P.printLocation(Out, S.getLocStart());
          if (Loc.getAs(org.clang.analysis.PreStmt.class).$bool()) {
            Out.$out(/*KEEP_STR*/"\\lPreStmt\\l;");
          } else if (Loc.getAs(PostLoad.class).$bool()) {
            Out.$out(/*KEEP_STR*/"\\lPostLoad\\l;");
          } else if (Loc.getAs(PostStore.class).$bool()) {
            Out.$out(/*KEEP_STR*/"\\lPostStore\\l");
          } else if (Loc.getAs(PostLValue.class).$bool()) {
            Out.$out(/*KEEP_STR*/"\\lPostLValue\\l");
          }
          
          break;
        }
      }
      
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(N.getState());
      Out.$out(/*KEEP_STR*/"\\|StateID: ").$out(reinterpret_cast(/*const*/Object/*void P*/ .class, state.get())).$out(
          /*KEEP_STR*/" NodeID: "
      ).$out(reinterpret_cast(/*const*/Object/*void P*/ .class, N)).$out(/*KEEP_STR*/"\\|");
      state.$arrow().printDOT(Out);
      
      Out.$out(/*KEEP_STR*/"\\l");
      {
        
        /*const*/ ProgramPointTag /*P*/ tag = Loc.getTag();
        if ((tag != null)) {
          Out.$out(/*KEEP_STR*/"\\|Tag: ").$out(tag.getTagDescription());
          Out.$out(/*KEEP_STR*/"\\l");
        }
      }
      return new std.string(Out.str());
    } finally {
      if (state != null) { state.$destroy(); }
      if (Out != null) { Out.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<ExplodedNode * >::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp", line = 2516,
   FQN="llvm::DOTGraphTraits<ExplodedNode * >::operator=", NM="_ZN4llvm14DOTGraphTraitsIPN5clang4ento12ExplodedNodeEEaSEOS5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN4llvm14DOTGraphTraitsIPN5clang4ento12ExplodedNodeEEaSEOS5_")
  //</editor-fold>
  public /*inline*/ DOTGraphTraitsExplodedNode$P /*&*/ $assignMove(final DOTGraphTraitsExplodedNode$P /*&&*/$Prm0) {
    /*J:ToBase*/super.$assignMove($Prm0);
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
