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

package org.clang.ast.impl;

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import org.clang.ast.comments.*;
import static org.clang.ast.java.AstFunctionPointers.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstAttributesRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.QualType.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.llvm.support.AdtsupportLlvmGlobals.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 95,
 FQN="(anonymous namespace)::ASTDumper", NM="_ZN12_GLOBAL__N_19ASTDumperE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumperE")
//</editor-fold>
public class ASTDumper implements /*public*/ ConstDeclVisitorVoid<ASTDumper>, /*public*/ ConstStmtVisitorVoid<ASTDumper>, /*public*/ ConstCommentVisitorVoid<ASTDumper>, /*public*/ TypeVisitorVoid<ASTDumper>, Destructors.ClassWithDestructor {
  private final raw_ostream /*&*/ OS;
  private /*const*/ CommandTraits /*P*/ Traits;
  private /*const*/ SourceManager /*P*/ SM;
  
  /// Pending[i] is an action to dump an entity at level i.
  private SmallVector<Bool2Void> Pending;
  
  /// Indicates whether we're at the top level.
  private boolean TopLevel;
  
  /// Indicates if we're handling the first child after entering a new depth.
  private boolean FirstChild;
  
  /// Prefix for currently-being-dumped entity.
  private std.string Prefix;
  
  /// Keep track of the last location we print out so that we can
  /// print out deltas from then on out.
  private /*const*/char$ptr/*char P*/ LastLocFilename;
  private /*uint*/int LastLocLine;
  
  /// The \c FullComment parent of the comment being dumped.
  private /*const*/ FullComment /*P*/ FC;
  
  private boolean ShowColors;
  
  /// Dump a child of the current node.
  /*template <typename Fn> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::dumpChild">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 125,
   FQN="(anonymous namespace)::ASTDumper::dumpChild", NM="Tpl__ZN12_GLOBAL__N_19ASTDumper9dumpChildET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=Tpl__ZN12_GLOBAL__N_19ASTDumper9dumpChildET_")
  //</editor-fold>
  private void dumpChild(Void2Void doDumpChild) {
    // If we're at the top level, there's nothing interesting to do; just
    // run the dumper.
    if (TopLevel) {
      TopLevel = false;
      doDumpChild.$call();
      while (!Pending.empty()) {
        Pending.back().$call(/*KEEP_BOOL*/true);
        Pending.pop_back();
      }
      Prefix.clear();
      OS.$out(/*KEEP_STR*/$LF);
      TopLevel = true;
      return;
    }
    
    /*const*/ FullComment /*P*/ OrigFC = FC;
    FullComment L$OrigFC = OrigFC;
    Void2Void L$doDumpChild = doDumpChild;
    Bool2Void/*const*/ dumpWithIndent = /*[this, =L$doDumpChild(doDumpChild), =L$OrigFC(OrigFC)]*/ (boolean isLastChild) -> {
          {
            ColorScope Color = null;
            try {
              OS.$out_char($$LF);
              Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.IndentColor));
              OS.$out(Prefix).$out_char((isLastChild ? $$BACKQUOTE : $$PIPE)).$out_char($$MINUS);
              this.Prefix.push_back(isLastChild ? $$SPACE : $$PIPE);
              this.Prefix.push_back($$SPACE);
            } finally {
              if (Color != null) { Color.$destroy(); }
            }
          }
          
          FirstChild = true;
          /*uint*/int Depth = Pending.size();
          
          FC = L$OrigFC;
          L$doDumpChild.$call();
          
          // If any children are left, they're the last at their nesting level.
          // Dump those ones out now.
          while ($less_uint(Depth, Pending.size())) {
            Pending.back().$call(/*KEEP_BOOL*/true);
            this.Pending.pop_back();
          }
          
          // Restore the old prefix.
          this.Prefix.resize(Prefix.size() - 2);
        };
    if (FirstChild) {
      Pending.push_back_T$RR(std.move(dumpWithIndent));
    } else {
      Pending.back().$call(/*KEEP_BOOL*/false);
      Pending.ref$back().$set(dumpWithIndent);// = std.move(dumpWithIndent);
    }
    FirstChild = false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::ColorScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 189,
   FQN="(anonymous namespace)::ASTDumper::ColorScope", NM="_ZN12_GLOBAL__N_19ASTDumper10ColorScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper10ColorScopeE")
  //</editor-fold>
  private static class ColorScope implements Destructors.ClassWithDestructor {
    private final ASTDumper /*&*/ Dumper;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::ColorScope::ColorScope">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 192,
     FQN="(anonymous namespace)::ASTDumper::ColorScope::ColorScope", NM="_ZN12_GLOBAL__N_19ASTDumper10ColorScopeC1ERS0_NS_13TerminalColorE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper10ColorScopeC1ERS0_NS_13TerminalColorE")
    //</editor-fold>
    public ColorScope(final ASTDumper /*&*/ Dumper, TerminalColor Color) {
      // : Dumper(Dumper) 
      //START JInit
      this./*&*/Dumper=/*&*/Dumper;
      //END JInit
      if (Dumper.ShowColors) {
        Dumper.OS.changeColor(Color.Color, Color.Bold);
      }
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::ColorScope::~ColorScope">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 197,
     FQN="(anonymous namespace)::ASTDumper::ColorScope::~ColorScope", NM="_ZN12_GLOBAL__N_19ASTDumper10ColorScopeD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper10ColorScopeD0Ev")
    //</editor-fold>
    public void $destroy() {
      if (Dumper.ShowColors) {
        Dumper.OS.resetColor();
      }
    }

    
    @Override public String toString() {
      return "" + "Dumper=" + Dumper; // NOI18N
    }
  };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::ASTDumper">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 204,
   FQN="(anonymous namespace)::ASTDumper::ASTDumper", NM="_ZN12_GLOBAL__N_19ASTDumperC1ERN4llvm11raw_ostreamEPKN5clang8comments13CommandTraitsEPKNS4_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumperC1ERN4llvm11raw_ostreamEPKN5clang8comments13CommandTraitsEPKNS4_13SourceManagerE")
  //</editor-fold>
  public ASTDumper(final raw_ostream /*&*/ OS, /*const*/ CommandTraits /*P*/ Traits, 
      /*const*/ SourceManager /*P*/ SM) {
    // : ConstDeclVisitor<ASTDumper>(), ConstStmtVisitor<ASTDumper>(), ConstCommentVisitor<ASTDumper>(), TypeVisitor<ASTDumper>(), OS(OS), Traits(Traits), SM(SM), Pending(), TopLevel(true), FirstChild(true), Prefix(), LastLocFilename(""), LastLocLine(~0UU), FC(null), ShowColors(SM && SM->getDiagnostics().getShowColors()) 
    //START JInit
    $ConstDeclVisitor();
    $ConstStmtVisitor();
    $ConstCommentVisitor();
    $TypeVisitor();
    this./*&*/OS=/*&*/OS;
    this.Traits = Traits;
    this.SM = SM;
    this.Pending = new SmallVector<Bool2Void>(32, NativeCallback.Bool2Void$Default);
    this.TopLevel = true;
    this.FirstChild = true;
    this.Prefix = new std.string();
    this.LastLocFilename = $tryClone($EMPTY);
    this.LastLocLine = ~0/*U*/;
    this.FC = null;
    this.ShowColors = (SM != null) && SM.getDiagnostics().getShowColors();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::ASTDumper">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 210,
   FQN="(anonymous namespace)::ASTDumper::ASTDumper", NM="_ZN12_GLOBAL__N_19ASTDumperC1ERN4llvm11raw_ostreamEPKN5clang8comments13CommandTraitsEPKNS4_13SourceManagerEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumperC1ERN4llvm11raw_ostreamEPKN5clang8comments13CommandTraitsEPKNS4_13SourceManagerEb")
  //</editor-fold>
  public ASTDumper(final raw_ostream /*&*/ OS, /*const*/ CommandTraits /*P*/ Traits, 
      /*const*/ SourceManager /*P*/ SM, boolean ShowColors) {
    // : ConstDeclVisitor<ASTDumper>(), ConstStmtVisitor<ASTDumper>(), ConstCommentVisitor<ASTDumper>(), TypeVisitor<ASTDumper>(), OS(OS), Traits(Traits), SM(SM), Pending(), TopLevel(true), FirstChild(true), Prefix(), LastLocFilename(""), LastLocLine(~0UU), ShowColors(ShowColors) 
    //START JInit
    $ConstDeclVisitor();
    $ConstStmtVisitor();
    $ConstCommentVisitor();
    $TypeVisitor();
    this./*&*/OS=/*&*/OS;
    this.Traits = Traits;
    this.SM = SM;
    this.Pending = new SmallVector<Bool2Void>(32, NativeCallback.Bool2Void$Default);
    this.TopLevel = true;
    this.FirstChild = true;
    this.Prefix = new std.string();
    this.LastLocFilename = $tryClone($EMPTY);
    this.LastLocLine = ~0/*U*/;
    this.ShowColors = ShowColors;
    //END JInit
  }

  
  
  //===----------------------------------------------------------------------===//
  //  Decl dumping methods.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::dumpDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1010,
   FQN="(anonymous namespace)::ASTDumper::dumpDecl", NM="_ZN12_GLOBAL__N_19ASTDumper8dumpDeclEPKN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper8dumpDeclEPKN5clang4DeclE")
  //</editor-fold>
  public void dumpDecl(/*const*/ Decl /*P*/ D) {
    Decl L$D = D;
    dumpChild(/*[=, =L$D(D), this]*/() -> {
              if (!(L$D != null)) {
                ColorScope Color = null;
                try {
                  Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.NullColor));
                  OS.$out(/*KEEP_STR*/"<<<NULL>>>");
                  return;
                } finally {
                  if (Color != null) { Color.$destroy(); }
                }
              }
              {
                ColorScope Color = null;
                try {
                  Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.DeclKindNameColor));
                  OS.$out(L$D.getDeclKindName()).$out(/*KEEP_STR*/"Decl");
                } finally {
                  if (Color != null) { Color.$destroy(); }
                }
              }
              dumpPointer(L$D);
              if (L$D.getLexicalDeclContext$Const() != L$D.getDeclContext$Const()) {
                OS.$out(/*KEEP_STR*/" parent ").$out(cast_Decl(L$D.getDeclContext$Const()));
              }
              ASTDumperStatics.dumpPreviousDecl(OS, L$D);
              dumpSourceRange(L$D.getSourceRange());
              OS.$out_char($$SPACE);
              dumpLocation(L$D.getLocation());
              {
                Module /*P*/ M = L$D.getImportedOwningModule();
                if ((M != null)) {
                  OS.$out(/*KEEP_STR*/" in ").$out(M.getFullModuleName());
                } else {
                  Module /*P*/ M$1 = L$D.getLocalOwningModule();
                  if ((M$1 != null)) {
                    OS.$out(/*KEEP_STR*/" in (local) ").$out(M$1.getFullModuleName());
                  }
                }
              }
              {
                /*const*/ NamedDecl /*P*/ ND = dyn_cast_NamedDecl(L$D);
                if ((ND != null)) {
                  for (Module /*P*/ M : L$D.getASTContext().getModulesWithMergedDefinition(((/*const_cast*/NamedDecl /*P*/ )(ND))))  {
                    Module L$M = M;
                    dumpChild(/*[=, this, =L$M(M)]*/() -> {
                              OS.$out(/*KEEP_STR*/"also in ").$out(L$M.getFullModuleName());
                            });
                  }
                }
              }
              {
                /*const*/ NamedDecl /*P*/ ND = dyn_cast_NamedDecl(L$D);
                if ((ND != null)) {
                  if (ND.isHidden()) {
                    OS.$out(/*KEEP_STR*/" hidden");
                  }
                }
              }
              if (L$D.isImplicit()) {
                OS.$out(/*KEEP_STR*/" implicit");
              }
              if (L$D.isUsed()) {
                OS.$out(/*KEEP_STR*/" used");
              } else if (L$D.isThisDeclarationReferenced()) {
                OS.$out(/*KEEP_STR*/" referenced");
              }
              if (L$D.isInvalidDecl()) {
                OS.$out(/*KEEP_STR*/" invalid");
              }
              {
                /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(L$D);
                if ((FD != null)) {
                  if (FD.isConstexpr()) {
                    OS.$out(/*KEEP_STR*/" constexpr");
                  }
                }
              }
              
              ConstDeclVisitorVoid.super.Visit(L$D);
              
              for (type$ptr<Attr /*P*/> I = $tryClone(L$D.attr_begin()), /*P*/ E = $tryClone(L$D.attr_end()); $noteq_ptr(I, E);
                   I.$preInc())  {
                dumpAttr(I.$star());
              }
              {
                
                /*const*/ FullComment /*P*/ Comment = L$D.getASTContext().getLocalCommentForDeclUncached(L$D);
                if ((Comment != null)) {
                  dumpFullComment(Comment);
                }
              }
              
              // Decls within functions are visited by the body.
              if (!isa_FunctionDecl($Deref(L$D)) && !isa_ObjCMethodDecl($Deref(L$D))
                 && hasNodes(dyn_cast_DeclContext(L$D))) {
                dumpDeclContext(cast_DeclContext(L$D));
              }
            });
  }

  
  //===----------------------------------------------------------------------===//
  //  Stmt dumping methods.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::dumpStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1747,
   FQN="(anonymous namespace)::ASTDumper::dumpStmt", NM="_ZN12_GLOBAL__N_19ASTDumper8dumpStmtEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper8dumpStmtEPKN5clang4StmtE")
  //</editor-fold>
  public void dumpStmt(/*const*/ Stmt /*P*/ S) {
    Stmt L$S = S;
    dumpChild(/*[=, =L$S(S), this]*/() -> {
              if (!(L$S != null)) {
                ColorScope Color = null;
                try {
                  Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.NullColor));
                  OS.$out(/*KEEP_STR*/"<<<NULL>>>");
                  return;
                } finally {
                  if (Color != null) { Color.$destroy(); }
                }
              }
              {
                
                /*const*/ DeclStmt /*P*/ DS = dyn_cast_DeclStmt(L$S);
                if ((DS != null)) {
                  VisitDeclStmt(DS);
                  return;
                }
              }
              
              ConstStmtVisitorVoid.super.Visit(L$S);
              
              for (/*const*/ Stmt /*P*/ SubStmt : L$S.children$Const())  {
                dumpStmt(SubStmt);
              }
            });
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::dumpFullComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2314,
   FQN="(anonymous namespace)::ASTDumper::dumpFullComment", NM="_ZN12_GLOBAL__N_19ASTDumper15dumpFullCommentEPKN5clang8comments11FullCommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper15dumpFullCommentEPKN5clang8comments11FullCommentE")
  //</editor-fold>
  public void dumpFullComment(/*const*/ FullComment /*P*/ C) {
    if (!(C != null)) {
      return;
    }
    
    FC = C;
    dumpComment(C);
    FC = null;
  }

  
  // Utilities
  
  //===----------------------------------------------------------------------===//
  //  Utilities
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::dumpPointer">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 583,
   FQN="(anonymous namespace)::ASTDumper::dumpPointer", NM="_ZN12_GLOBAL__N_19ASTDumper11dumpPointerEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper11dumpPointerEPKv")
  //</editor-fold>
  public void dumpPointer(/*const*/Object/*void P*/ Ptr) {
    ColorScope Color = null;
    try {
      Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.AddressColor));
      OS.$out_char($$SPACE).$out(Ptr);
    } finally {
      if (Color != null) { Color.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::dumpSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 618,
   FQN="(anonymous namespace)::ASTDumper::dumpSourceRange", NM="_ZN12_GLOBAL__N_19ASTDumper15dumpSourceRangeEN5clang11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper15dumpSourceRangeEN5clang11SourceRangeE")
  //</editor-fold>
  public void dumpSourceRange(SourceRange R) {
    // Can't translate locations if a SourceManager isn't available.
    if (!(SM != null)) {
      return;
    }
    
    OS.$out(/*KEEP_STR*/" <");
    dumpLocation(R.getBegin());
    if ($noteq_SourceLocation$C(R.getBegin(), R.getEnd())) {
      OS.$out(/*KEEP_STR*/$COMMA_SPACE);
      dumpLocation(R.getEnd());
    }
    OS.$out(/*KEEP_STR*/$GT);
    // <t2.c:123:421[blah], t2.c:412:321>
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::dumpLocation">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 588,
   FQN="(anonymous namespace)::ASTDumper::dumpLocation", NM="_ZN12_GLOBAL__N_19ASTDumper12dumpLocationEN5clang14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper12dumpLocationEN5clang14SourceLocationE")
  //</editor-fold>
  public void dumpLocation(SourceLocation Loc) {
    ColorScope Color = null;
    try {
      if (!(SM != null)) {
        return;
      }
      
      Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.LocationColor));
      SourceLocation SpellingLoc = SM.getSpellingLoc(/*NO_COPY*/Loc);
      
      // The general format we print out is filename:line:col, but we drop pieces
      // that haven't changed since the last loc printed.
      PresumedLoc PLoc = SM.getPresumedLoc(/*NO_COPY*/SpellingLoc);
      if (PLoc.isInvalid()) {
        OS.$out(/*KEEP_STR*/"<invalid sloc>");
        return;
      }
      if (strcmp(PLoc.getFilename(), LastLocFilename) != 0) {
        OS.$out(PLoc.getFilename()).$out_char($$COLON).$out_uint(PLoc.getLine()).$out_char(
            $$COLON
        ).$out_uint(PLoc.getColumn());
        LastLocFilename = $tryClone(PLoc.getFilename());
        LastLocLine = PLoc.getLine();
      } else if (PLoc.getLine() != LastLocLine) {
        OS.$out(/*KEEP_STR*/$line).$out_char($$COLON).$out_uint(PLoc.getLine()).$out_char(
            $$COLON
        ).$out_uint(PLoc.getColumn());
        LastLocLine = PLoc.getLine();
      } else {
        OS.$out(/*KEEP_STR*/"col").$out_char($$COLON).$out_uint(PLoc.getColumn());
      }
    } finally {
      if (Color != null) { Color.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::dumpBareType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 635,
   FQN="(anonymous namespace)::ASTDumper::dumpBareType", NM="_ZN12_GLOBAL__N_19ASTDumper12dumpBareTypeEN5clang8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper12dumpBareTypeEN5clang8QualTypeEb")
  //</editor-fold>
  public void dumpBareType(QualType T) {
    dumpBareType(T, true);
  }
  public void dumpBareType(QualType T, boolean Desugar/*= true*/) {
    ColorScope Color = null;
    try {
      Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.TypeColor));
      
      SplitQualType T_split = T.split();
      OS.$out(/*KEEP_STR*/$SGL_QUOTE).$out(QualType.getAsString(new SplitQualType(T_split))).$out(/*KEEP_STR*/$SGL_QUOTE);
      if (Desugar && !T.isNull()) {
        // If the type is sugared, also dump a (shallow) desugared type.
        SplitQualType D_split = T.getSplitDesugaredType();
        if (SplitQualType.$noteq_SplitQualType(/*NO_COPY*/T_split, /*NO_COPY*/D_split)) {
          OS.$out(/*KEEP_STR*/":'").$out(QualType.getAsString(new SplitQualType(D_split))).$out(/*KEEP_STR*/$SGL_QUOTE);
        }
      }
    } finally {
      if (Color != null) { Color.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::dumpType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 649,
   FQN="(anonymous namespace)::ASTDumper::dumpType", NM="_ZN12_GLOBAL__N_19ASTDumper8dumpTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper8dumpTypeEN5clang8QualTypeE")
  //</editor-fold>
  public void dumpType(QualType T) {
    OS.$out_char($$SPACE);
    dumpBareType(new QualType(T));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::dumpTypeAsChild">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 654,
   FQN="(anonymous namespace)::ASTDumper::dumpTypeAsChild", NM="_ZN12_GLOBAL__N_19ASTDumper15dumpTypeAsChildEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper15dumpTypeAsChildEN5clang8QualTypeE")
  //</editor-fold>
  public void dumpTypeAsChild(QualType T) {
    SplitQualType SQT = T.split();
    if (!SQT.Quals.hasQualifiers()) {
      dumpTypeAsChild(SQT.Ty);
      /*JAVA:return*/return;
    }
    QualType L$T = $tryClone(T);
    
    dumpChild(/*[=, this, =L$T(T)]*/() -> {
              OS.$out(/*KEEP_STR*/"QualType");
              dumpPointer(L$T.getAsOpaquePtr());
              OS.$out(/*KEEP_STR*/$SPACE);
              dumpBareType(new QualType(L$T), false);
              OS.$out(/*KEEP_STR*/$SPACE).$out(L$T.split().Quals.getAsString());
              dumpTypeAsChild(L$T.split().Ty);
            });
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::dumpTypeAsChild">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 669,
   FQN="(anonymous namespace)::ASTDumper::dumpTypeAsChild", NM="_ZN12_GLOBAL__N_19ASTDumper15dumpTypeAsChildEPKN5clang4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper15dumpTypeAsChildEPKN5clang4TypeE")
  //</editor-fold>
  public void dumpTypeAsChild(/*const*/ Type /*P*/ T) {
    Type L$T = T;
    dumpChild(/*[=, =L$T(T), this]*/() -> {
              if (!(L$T != null)) {
                ColorScope Color = null;
                try {
                  Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.NullColor));
                  OS.$out(/*KEEP_STR*/"<<<NULL>>>");
                  return;
                } finally {
                  if (Color != null) { Color.$destroy(); }
                }
              }
              {
                /*const*/ LocInfoType /*P*/ LIT = dyn_cast_LocInfoType(L$T);
                if ((LIT != null)) {
                  {
                    ColorScope Color = null;
                    try {
                      Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.TypeColor));
                      OS.$out(/*KEEP_STR*/"LocInfo Type");
                    } finally {
                      if (Color != null) { Color.$destroy(); }
                    }
                  }
                  dumpPointer(L$T);
                  dumpTypeAsChild(LIT.getTypeSourceInfo().getType());
                  return;
                }
              }
              {
                ColorScope Color = null;
                try {
                  Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.TypeColor));
                  OS.$out(L$T.getTypeClassName()).$out(/*KEEP_STR*/"Type");
                } finally {
                  if (Color != null) { Color.$destroy(); }
                }
              }
              dumpPointer(L$T);
              OS.$out(/*KEEP_STR*/$SPACE);
              dumpBareType(new QualType(L$T, 0), false);
              
              QualType SingleStepDesugar = L$T.getLocallyUnqualifiedSingleStepDesugaredType();
              if ($noteq_QualType$C(SingleStepDesugar, new QualType(L$T, 0))) {
                OS.$out(/*KEEP_STR*/" sugar");
              }
              if (L$T.isDependentType()) {
                OS.$out(/*KEEP_STR*/" dependent");
              } else if (L$T.isInstantiationDependentType()) {
                OS.$out(/*KEEP_STR*/" instantiation_dependent");
              }
              if (L$T.isVariablyModifiedType()) {
                OS.$out(/*KEEP_STR*/" variably_modified");
              }
              if (L$T.containsUnexpandedParameterPack()) {
                OS.$out(/*KEEP_STR*/" contains_unexpanded_pack");
              }
              if (L$T.isFromAST()) {
                OS.$out(/*KEEP_STR*/" imported");
              }
              
              TypeVisitorVoid.super.Visit(L$T);
              if ($noteq_QualType$C(SingleStepDesugar, new QualType(L$T, 0))) {
                dumpTypeAsChild(new QualType(SingleStepDesugar));
              }
            });
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::dumpBareDeclRef">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 716,
   FQN="(anonymous namespace)::ASTDumper::dumpBareDeclRef", NM="_ZN12_GLOBAL__N_19ASTDumper15dumpBareDeclRefEPKN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper15dumpBareDeclRefEPKN5clang4DeclE")
  //</editor-fold>
  public void dumpBareDeclRef(/*const*/ Decl /*P*/ D) {
    if (!(D != null)) {
      ColorScope Color = null;
      try {
        Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.NullColor));
        OS.$out(/*KEEP_STR*/"<<<NULL>>>");
        return;
      } finally {
        if (Color != null) { Color.$destroy(); }
      }
    }
    {
      ColorScope Color = null;
      try {
        Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.DeclKindNameColor));
        OS.$out(D.getDeclKindName());
      } finally {
        if (Color != null) { Color.$destroy(); }
      }
    }
    dumpPointer(D);
    {
      
      /*const*/ NamedDecl /*P*/ ND = dyn_cast_NamedDecl(D);
      if ((ND != null)) {
        ColorScope Color = null;
        try {
          Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.DeclNameColor));
          $out_raw_ostream_DeclarationName(OS.$out(/*KEEP_STR*/" '"), ND.getDeclName()).$out_char($$SGL_QUOTE);
        } finally {
          if (Color != null) { Color.$destroy(); }
        }
      }
    }
    {
      
      /*const*/ ValueDecl /*P*/ VD = dyn_cast_ValueDecl(D);
      if ((VD != null)) {
        dumpType(VD.getType());
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::dumpDeclRef">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 738,
   FQN="(anonymous namespace)::ASTDumper::dumpDeclRef", NM="_ZN12_GLOBAL__N_19ASTDumper11dumpDeclRefEPKN5clang4DeclEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper11dumpDeclRefEPKN5clang4DeclEPKc")
  //</editor-fold>
  public void dumpDeclRef(/*const*/ Decl /*P*/ D) {
    dumpDeclRef(D, (/*const*/char$ptr/*char P*/ )null);
  }
  public void dumpDeclRef(/*const*/ Decl /*P*/ D, /*const*/char$ptr/*char P*/ Label/*= null*/) {
    if (!(D != null)) {
      return;
    }
    char$ptr L$Label = $tryClone(Label);
    Decl L$D = D;
    
    dumpChild(/*[=, =L$Label(Label), this, =L$D(D)]*/() -> {
              if (Native.$bool(L$Label)) {
                OS.$out(L$Label).$out_char($$SPACE);
              }
              dumpBareDeclRef(L$D);
            });
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::dumpName">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 749,
   FQN="(anonymous namespace)::ASTDumper::dumpName", NM="_ZN12_GLOBAL__N_19ASTDumper8dumpNameEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper8dumpNameEPKN5clang9NamedDeclE")
  //</editor-fold>
  public void dumpName(/*const*/ NamedDecl /*P*/ ND) {
    if (ND.getDeclName().$bool()) {
      ColorScope Color = null;
      try {
        Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.DeclNameColor));
        OS.$out_char($$SPACE).$out(ND.getNameAsString());
      } finally {
        if (Color != null) { Color.$destroy(); }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::hasNodes">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 756,
   FQN="(anonymous namespace)::ASTDumper::hasNodes", NM="_ZN12_GLOBAL__N_19ASTDumper8hasNodesEPKN5clang11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper8hasNodesEPKN5clang11DeclContextE")
  //</editor-fold>
  public boolean hasNodes(/*const*/ DeclContext /*P*/ DC) {
    if (!(DC != null)) {
      return false;
    }
    
    return DC.hasExternalLexicalStorage()
       || DeclContext.decl_iterator.$noteq_decl_iterator(DC.noload_decls_begin(), DC.noload_decls_end());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::dumpDeclContext">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 764,
   FQN="(anonymous namespace)::ASTDumper::dumpDeclContext", NM="_ZN12_GLOBAL__N_19ASTDumper15dumpDeclContextEPKN5clang11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper15dumpDeclContextEPKN5clang11DeclContextE")
  //</editor-fold>
  public void dumpDeclContext(/*const*/ DeclContext /*P*/ DC) {
    if (!(DC != null)) {
      return;
    }
    
    for (Decl /*P*/ D : DC.noload_decls())  {
      dumpDecl(D);
    }
    if (DC.hasExternalLexicalStorage()) {
      dumpChild(/*[=, this]*/() -> {
                ColorScope Color = null;
                try {
                  Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.UndeserializedColor));
                  OS.$out(/*KEEP_STR*/"<undeserialized declarations>");
                } finally {
                  if (Color != null) { Color.$destroy(); }
                }
              });
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::dumpLookups">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 779,
   FQN="(anonymous namespace)::ASTDumper::dumpLookups", NM="_ZN12_GLOBAL__N_19ASTDumper11dumpLookupsEPKN5clang11DeclContextEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper11dumpLookupsEPKN5clang11DeclContextEb")
  //</editor-fold>
  public void dumpLookups(/*const*/ DeclContext /*P*/ DC, boolean DumpDecls) {
    DeclContext L$DC = DC;
    boolean L$DumpDecls= DumpDecls;
    dumpChild(/*[=, this, =L$DC(DC), =L$DumpDecls(DumpDecls)]*/() -> {
              OS.$out(/*KEEP_STR*/"StoredDeclsMap ");
              dumpBareDeclRef(cast_Decl(L$DC));
              
              /*const*/ DeclContext /*P*/ Primary = L$DC.getPrimaryContext$Const();
              if (Primary != L$DC) {
                OS.$out(/*KEEP_STR*/" primary");
                dumpPointer(cast_Decl(Primary));
              }
              
              boolean HasUndeserializedLookups = Primary.hasExternalVisibleStorage();
              
              DeclContext.all_lookups_iterator I = Primary.noload_lookups_begin();
              DeclContext.all_lookups_iterator E = Primary.noload_lookups_end();
              while (DeclContext.all_lookups_iterator.$noteq_all_lookups_iterator(/*NO_COPY*/I, /*NO_COPY*/E)) {
                DeclarationName Name = I.getLookupName();
                DeclarationName L$Name = Name;
                DeclContextLookupResult R = I.$postInc(0).$star();
                DeclContextLookupResult L$R = R;
                
                dumpChild(/*[=, this, =L$Name(Name), =L$R(R), =L$L$DumpDecls(L$DumpDecls)]*/() -> {
                          OS.$out(/*KEEP_STR*/"DeclarationName ");
                          {
                            ColorScope Color = null;
                            try {
                              Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.DeclNameColor));
                              $out_raw_ostream_DeclarationName(OS.$out_char($$SGL_QUOTE), /*NO_COPY*/L$Name).$out_char($$SGL_QUOTE);
                            } finally {
                              if (Color != null) { Color.$destroy(); }
                            }
                          }
                          
                          for (DeclContextLookupResult.iterator RI = L$R.begin(), RE = L$R.end();
                               RI.$noteq(RE); RI.$preInc()) {
                            DeclContextLookupResult.iterator L$RI = $tryClone(RI);
                            dumpChild(/*[=, this, =L$RI(RI), =L$L$DumpDecls(L$DumpDecls)]*/() -> {
                                      dumpBareDeclRef(L$RI.$star());
                                      if ((L$RI.$star()).isHidden()) {
                                        OS.$out(/*KEEP_STR*/" hidden");
                                      }
                                      
                                      // If requested, dump the redecl chain for this lookup.
                                      if (L$DumpDecls) {
                                        // Dump earliest decl first.
                                        
                                        Decl2Void DumpWithPrev = new finlDecl2Void();
                                        DumpWithPrev.$call(L$RI.$star());
                                      }
                                    });
                          }
                        });
              }
              if (HasUndeserializedLookups) {
                dumpChild(/*[=, this]*/() -> {
                          ColorScope Color = null;
                          try {
                            Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.UndeserializedColor));
                            OS.$out(/*KEEP_STR*/"<undeserialized lookups>");
                          } finally {
                            if (Color != null) { Color.$destroy(); }
                          }
                        });
              }
            });
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::dumpAttr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 837,
   FQN="(anonymous namespace)::ASTDumper::dumpAttr", NM="_ZN12_GLOBAL__N_19ASTDumper8dumpAttrEPKN5clang4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper8dumpAttrEPKN5clang4AttrE")
  //</editor-fold>
  public void dumpAttr(/*const*/ Attr /*P*/ A) {
    Attr L$A = A;
    dumpChild(/*[=, this, =L$A(A)]*/() -> {
              {
                ColorScope Color = null;
                try {
                  Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.AttrColor));
                  switch (L$A.getKind()) {
                   case FallThrough:
                    OS.$out(/*KEEP_STR*/"FallThrough");
                    break;
                   case SwiftContext:
                    OS.$out(/*KEEP_STR*/"SwiftContext");
                    break;
                   case SwiftErrorResult:
                    OS.$out(/*KEEP_STR*/"SwiftErrorResult");
                    break;
                   case SwiftIndirectResult:
                    OS.$out(/*KEEP_STR*/"SwiftIndirectResult");
                    break;
                   case Annotate:
                    OS.$out(/*KEEP_STR*/"Annotate");
                    break;
                   case CFConsumed:
                    OS.$out(/*KEEP_STR*/"CFConsumed");
                    break;
                   case CarriesDependency:
                    OS.$out(/*KEEP_STR*/"CarriesDependency");
                    break;
                   case NSConsumed:
                    OS.$out(/*KEEP_STR*/"NSConsumed");
                    break;
                   case PassObjectSize:
                    OS.$out(/*KEEP_STR*/"PassObjectSize");
                    break;
                   case AMDGPUNumSGPR:
                    OS.$out(/*KEEP_STR*/"AMDGPUNumSGPR");
                    break;
                   case AMDGPUNumVGPR:
                    OS.$out(/*KEEP_STR*/"AMDGPUNumVGPR");
                    break;
                   case ARMInterrupt:
                    OS.$out(/*KEEP_STR*/"ARMInterrupt");
                    break;
                   case AcquireCapability:
                    OS.$out(/*KEEP_STR*/"AcquireCapability");
                    break;
                   case AcquiredAfter:
                    OS.$out(/*KEEP_STR*/"AcquiredAfter");
                    break;
                   case AcquiredBefore:
                    OS.$out(/*KEEP_STR*/"AcquiredBefore");
                    break;
                   case AlignMac68k:
                    OS.$out(/*KEEP_STR*/"AlignMac68k");
                    break;
                   case Aligned:
                    OS.$out(/*KEEP_STR*/"Aligned");
                    break;
                   case AlwaysInline:
                    OS.$out(/*KEEP_STR*/"AlwaysInline");
                    break;
                   case AnalyzerNoReturn:
                    OS.$out(/*KEEP_STR*/"AnalyzerNoReturn");
                    break;
                   case AnyX86Interrupt:
                    OS.$out(/*KEEP_STR*/"AnyX86Interrupt");
                    break;
                   case ArcWeakrefUnavailable:
                    OS.$out(/*KEEP_STR*/"ArcWeakrefUnavailable");
                    break;
                   case ArgumentWithTypeTag:
                    OS.$out(/*KEEP_STR*/"ArgumentWithTypeTag");
                    break;
                   case AsmLabel:
                    OS.$out(/*KEEP_STR*/"AsmLabel");
                    break;
                   case AssertCapability:
                    OS.$out(/*KEEP_STR*/"AssertCapability");
                    break;
                   case AssertExclusiveLock:
                    OS.$out(/*KEEP_STR*/"AssertExclusiveLock");
                    break;
                   case AssertSharedLock:
                    OS.$out(/*KEEP_STR*/"AssertSharedLock");
                    break;
                   case AssumeAligned:
                    OS.$out(/*KEEP_STR*/"AssumeAligned");
                    break;
                   case Availability:
                    OS.$out(/*KEEP_STR*/"Availability");
                    break;
                   case Blocks:
                    OS.$out(/*KEEP_STR*/"Blocks");
                    break;
                   case C11NoReturn:
                    OS.$out(/*KEEP_STR*/"C11NoReturn");
                    break;
                   case CDecl:
                    OS.$out(/*KEEP_STR*/"CDecl");
                    break;
                   case CFAuditedTransfer:
                    OS.$out(/*KEEP_STR*/"CFAuditedTransfer");
                    break;
                   case CFReturnsNotRetained:
                    OS.$out(/*KEEP_STR*/"CFReturnsNotRetained");
                    break;
                   case CFReturnsRetained:
                    OS.$out(/*KEEP_STR*/"CFReturnsRetained");
                    break;
                   case CFUnknownTransfer:
                    OS.$out(/*KEEP_STR*/"CFUnknownTransfer");
                    break;
                   case CUDAConstant:
                    OS.$out(/*KEEP_STR*/"CUDAConstant");
                    break;
                   case CUDADevice:
                    OS.$out(/*KEEP_STR*/"CUDADevice");
                    break;
                   case CUDAGlobal:
                    OS.$out(/*KEEP_STR*/"CUDAGlobal");
                    break;
                   case CUDAHost:
                    OS.$out(/*KEEP_STR*/"CUDAHost");
                    break;
                   case CUDAInvalidTarget:
                    OS.$out(/*KEEP_STR*/"CUDAInvalidTarget");
                    break;
                   case CUDALaunchBounds:
                    OS.$out(/*KEEP_STR*/"CUDALaunchBounds");
                    break;
                   case CUDAShared:
                    OS.$out(/*KEEP_STR*/"CUDAShared");
                    break;
                   case CXX11NoReturn:
                    OS.$out(/*KEEP_STR*/"CXX11NoReturn");
                    break;
                   case CallableWhen:
                    OS.$out(/*KEEP_STR*/"CallableWhen");
                    break;
                   case Capability:
                    OS.$out(/*KEEP_STR*/"Capability");
                    break;
                   case CapturedRecord:
                    OS.$out(/*KEEP_STR*/"CapturedRecord");
                    break;
                   case Cleanup:
                    OS.$out(/*KEEP_STR*/"Cleanup");
                    break;
                   case Cold:
                    OS.$out(/*KEEP_STR*/"Cold");
                    break;
                   case Common:
                    OS.$out(/*KEEP_STR*/"Common");
                    break;
                   case Const:
                    OS.$out(/*KEEP_STR*/"Const");
                    break;
                   case Constructor:
                    OS.$out(/*KEEP_STR*/"Constructor");
                    break;
                   case Consumable:
                    OS.$out(/*KEEP_STR*/"Consumable");
                    break;
                   case ConsumableAutoCast:
                    OS.$out(/*KEEP_STR*/"ConsumableAutoCast");
                    break;
                   case ConsumableSetOnRead:
                    OS.$out(/*KEEP_STR*/"ConsumableSetOnRead");
                    break;
                   case DLLExport:
                    OS.$out(/*KEEP_STR*/"DLLExport");
                    break;
                   case DLLImport:
                    OS.$out(/*KEEP_STR*/"DLLImport");
                    break;
                   case Deprecated:
                    OS.$out(/*KEEP_STR*/"Deprecated");
                    break;
                   case Destructor:
                    OS.$out(/*KEEP_STR*/"Destructor");
                    break;
                   case DisableTailCalls:
                    OS.$out(/*KEEP_STR*/"DisableTailCalls");
                    break;
                   case EmptyBases:
                    OS.$out(/*KEEP_STR*/"EmptyBases");
                    break;
                   case EnableIf:
                    OS.$out(/*KEEP_STR*/"EnableIf");
                    break;
                   case ExclusiveTrylockFunction:
                    OS.$out(/*KEEP_STR*/"ExclusiveTrylockFunction");
                    break;
                   case FastCall:
                    OS.$out(/*KEEP_STR*/"FastCall");
                    break;
                   case Final:
                    OS.$out(/*KEEP_STR*/"Final");
                    break;
                   case FlagEnum:
                    OS.$out(/*KEEP_STR*/"FlagEnum");
                    break;
                   case Flatten:
                    OS.$out(/*KEEP_STR*/"Flatten");
                    break;
                   case Format:
                    OS.$out(/*KEEP_STR*/"Format");
                    break;
                   case FormatArg:
                    OS.$out(/*KEEP_STR*/"FormatArg");
                    break;
                   case GNUInline:
                    OS.$out(/*KEEP_STR*/"GNUInline");
                    break;
                   case GuardedBy:
                    OS.$out(/*KEEP_STR*/"GuardedBy");
                    break;
                   case GuardedVar:
                    OS.$out(/*KEEP_STR*/"GuardedVar");
                    break;
                   case Hot:
                    OS.$out(/*KEEP_STR*/"Hot");
                    break;
                   case IBAction:
                    OS.$out(/*KEEP_STR*/"IBAction");
                    break;
                   case IBOutlet:
                    OS.$out(/*KEEP_STR*/"IBOutlet");
                    break;
                   case IBOutletCollection:
                    OS.$out(/*KEEP_STR*/"IBOutletCollection");
                    break;
                   case InitPriority:
                    OS.$out(/*KEEP_STR*/"InitPriority");
                    break;
                   case IntelOclBicc:
                    OS.$out(/*KEEP_STR*/"IntelOclBicc");
                    break;
                   case InternalLinkage:
                    OS.$out(/*KEEP_STR*/"InternalLinkage");
                    break;
                   case LTOVisibilityPublic:
                    OS.$out(/*KEEP_STR*/"LTOVisibilityPublic");
                    break;
                   case LayoutVersion:
                    OS.$out(/*KEEP_STR*/"LayoutVersion");
                    break;
                   case LockReturned:
                    OS.$out(/*KEEP_STR*/"LockReturned");
                    break;
                   case LocksExcluded:
                    OS.$out(/*KEEP_STR*/"LocksExcluded");
                    break;
                   case MSABI:
                    OS.$out(/*KEEP_STR*/"MSABI");
                    break;
                   case MSInheritance:
                    OS.$out(/*KEEP_STR*/"MSInheritance");
                    break;
                   case MSNoVTable:
                    OS.$out(/*KEEP_STR*/"MSNoVTable");
                    break;
                   case MSP430Interrupt:
                    OS.$out(/*KEEP_STR*/"MSP430Interrupt");
                    break;
                   case MSStruct:
                    OS.$out(/*KEEP_STR*/"MSStruct");
                    break;
                   case MSVtorDisp:
                    OS.$out(/*KEEP_STR*/"MSVtorDisp");
                    break;
                   case MaxFieldAlignment:
                    OS.$out(/*KEEP_STR*/"MaxFieldAlignment");
                    break;
                   case MayAlias:
                    OS.$out(/*KEEP_STR*/"MayAlias");
                    break;
                   case MinSize:
                    OS.$out(/*KEEP_STR*/"MinSize");
                    break;
                   case Mips16:
                    OS.$out(/*KEEP_STR*/"Mips16");
                    break;
                   case MipsInterrupt:
                    OS.$out(/*KEEP_STR*/"MipsInterrupt");
                    break;
                   case NSConsumesSelf:
                    OS.$out(/*KEEP_STR*/"NSConsumesSelf");
                    break;
                   case NSReturnsAutoreleased:
                    OS.$out(/*KEEP_STR*/"NSReturnsAutoreleased");
                    break;
                   case NSReturnsNotRetained:
                    OS.$out(/*KEEP_STR*/"NSReturnsNotRetained");
                    break;
                   case NSReturnsRetained:
                    OS.$out(/*KEEP_STR*/"NSReturnsRetained");
                    break;
                   case Naked:
                    OS.$out(/*KEEP_STR*/"Naked");
                    break;
                   case NoAlias:
                    OS.$out(/*KEEP_STR*/"NoAlias");
                    break;
                   case NoCommon:
                    OS.$out(/*KEEP_STR*/"NoCommon");
                    break;
                   case NoDebug:
                    OS.$out(/*KEEP_STR*/"NoDebug");
                    break;
                   case NoDuplicate:
                    OS.$out(/*KEEP_STR*/"NoDuplicate");
                    break;
                   case NoInline:
                    OS.$out(/*KEEP_STR*/"NoInline");
                    break;
                   case NoInstrumentFunction:
                    OS.$out(/*KEEP_STR*/"NoInstrumentFunction");
                    break;
                   case NoMips16:
                    OS.$out(/*KEEP_STR*/"NoMips16");
                    break;
                   case NoReturn:
                    OS.$out(/*KEEP_STR*/"NoReturn");
                    break;
                   case NoSanitize:
                    OS.$out(/*KEEP_STR*/"NoSanitize");
                    break;
                   case NoSplitStack:
                    OS.$out(/*KEEP_STR*/"NoSplitStack");
                    break;
                   case NoThreadSafetyAnalysis:
                    OS.$out(/*KEEP_STR*/"NoThreadSafetyAnalysis");
                    break;
                   case NoThrow:
                    OS.$out(/*KEEP_STR*/"NoThrow");
                    break;
                   case NonNull:
                    OS.$out(/*KEEP_STR*/"NonNull");
                    break;
                   case NotTailCalled:
                    OS.$out(/*KEEP_STR*/"NotTailCalled");
                    break;
                   case OMPCaptureNoInit:
                    OS.$out(/*KEEP_STR*/"OMPCaptureNoInit");
                    break;
                   case OMPThreadPrivateDecl:
                    OS.$out(/*KEEP_STR*/"OMPThreadPrivateDecl");
                    break;
                   case ObjCBridge:
                    OS.$out(/*KEEP_STR*/"ObjCBridge");
                    break;
                   case ObjCBridgeMutable:
                    OS.$out(/*KEEP_STR*/"ObjCBridgeMutable");
                    break;
                   case ObjCBridgeRelated:
                    OS.$out(/*KEEP_STR*/"ObjCBridgeRelated");
                    break;
                   case ObjCException:
                    OS.$out(/*KEEP_STR*/"ObjCException");
                    break;
                   case ObjCExplicitProtocolImpl:
                    OS.$out(/*KEEP_STR*/"ObjCExplicitProtocolImpl");
                    break;
                   case ObjCIndependentClass:
                    OS.$out(/*KEEP_STR*/"ObjCIndependentClass");
                    break;
                   case ObjCMethodFamily:
                    OS.$out(/*KEEP_STR*/"ObjCMethodFamily");
                    break;
                   case ObjCNSObject:
                    OS.$out(/*KEEP_STR*/"ObjCNSObject");
                    break;
                   case ObjCPreciseLifetime:
                    OS.$out(/*KEEP_STR*/"ObjCPreciseLifetime");
                    break;
                   case ObjCRequiresPropertyDefs:
                    OS.$out(/*KEEP_STR*/"ObjCRequiresPropertyDefs");
                    break;
                   case ObjCRequiresSuper:
                    OS.$out(/*KEEP_STR*/"ObjCRequiresSuper");
                    break;
                   case ObjCReturnsInnerPointer:
                    OS.$out(/*KEEP_STR*/"ObjCReturnsInnerPointer");
                    break;
                   case ObjCRootClass:
                    OS.$out(/*KEEP_STR*/"ObjCRootClass");
                    break;
                   case OpenCLKernel:
                    OS.$out(/*KEEP_STR*/"OpenCLKernel");
                    break;
                   case OpenCLUnrollHint:
                    OS.$out(/*KEEP_STR*/"OpenCLUnrollHint");
                    break;
                   case OptimizeNone:
                    OS.$out(/*KEEP_STR*/"OptimizeNone");
                    break;
                   case Override:
                    OS.$out(/*KEEP_STR*/"Override");
                    break;
                   case Ownership:
                    OS.$out(/*KEEP_STR*/"Ownership");
                    break;
                   case Packed:
                    OS.$out(/*KEEP_STR*/"Packed");
                    break;
                   case ParamTypestate:
                    OS.$out(/*KEEP_STR*/"ParamTypestate");
                    break;
                   case Pascal:
                    OS.$out(/*KEEP_STR*/"Pascal");
                    break;
                   case Pcs:
                    OS.$out(/*KEEP_STR*/"Pcs");
                    break;
                   case PreserveAll:
                    OS.$out(/*KEEP_STR*/"PreserveAll");
                    break;
                   case PreserveMost:
                    OS.$out(/*KEEP_STR*/"PreserveMost");
                    break;
                   case PtGuardedBy:
                    OS.$out(/*KEEP_STR*/"PtGuardedBy");
                    break;
                   case PtGuardedVar:
                    OS.$out(/*KEEP_STR*/"PtGuardedVar");
                    break;
                   case Pure:
                    OS.$out(/*KEEP_STR*/"Pure");
                    break;
                   case ReleaseCapability:
                    OS.$out(/*KEEP_STR*/"ReleaseCapability");
                    break;
                   case ReqdWorkGroupSize:
                    OS.$out(/*KEEP_STR*/"ReqdWorkGroupSize");
                    break;
                   case RequiresCapability:
                    OS.$out(/*KEEP_STR*/"RequiresCapability");
                    break;
                   case Restrict:
                    OS.$out(/*KEEP_STR*/"Restrict");
                    break;
                   case ReturnTypestate:
                    OS.$out(/*KEEP_STR*/"ReturnTypestate");
                    break;
                   case ReturnsNonNull:
                    OS.$out(/*KEEP_STR*/"ReturnsNonNull");
                    break;
                   case ReturnsTwice:
                    OS.$out(/*KEEP_STR*/"ReturnsTwice");
                    break;
                   case ScopedLockable:
                    OS.$out(/*KEEP_STR*/"ScopedLockable");
                    break;
                   case Section:
                    OS.$out(/*KEEP_STR*/"Section");
                    break;
                   case SelectAny:
                    OS.$out(/*KEEP_STR*/"SelectAny");
                    break;
                   case Sentinel:
                    OS.$out(/*KEEP_STR*/"Sentinel");
                    break;
                   case SetTypestate:
                    OS.$out(/*KEEP_STR*/"SetTypestate");
                    break;
                   case SharedTrylockFunction:
                    OS.$out(/*KEEP_STR*/"SharedTrylockFunction");
                    break;
                   case StdCall:
                    OS.$out(/*KEEP_STR*/"StdCall");
                    break;
                   case SwiftCall:
                    OS.$out(/*KEEP_STR*/"SwiftCall");
                    break;
                   case SysVABI:
                    OS.$out(/*KEEP_STR*/"SysVABI");
                    break;
                   case TLSModel:
                    OS.$out(/*KEEP_STR*/"TLSModel");
                    break;
                   case Target:
                    OS.$out(/*KEEP_STR*/"Target");
                    break;
                   case TestTypestate:
                    OS.$out(/*KEEP_STR*/"TestTypestate");
                    break;
                   case ThisCall:
                    OS.$out(/*KEEP_STR*/"ThisCall");
                    break;
                   case TransparentUnion:
                    OS.$out(/*KEEP_STR*/"TransparentUnion");
                    break;
                   case TryAcquireCapability:
                    OS.$out(/*KEEP_STR*/"TryAcquireCapability");
                    break;
                   case TypeTagForDatatype:
                    OS.$out(/*KEEP_STR*/"TypeTagForDatatype");
                    break;
                   case TypeVisibility:
                    OS.$out(/*KEEP_STR*/"TypeVisibility");
                    break;
                   case Unavailable:
                    OS.$out(/*KEEP_STR*/"Unavailable");
                    break;
                   case Unused:
                    OS.$out(/*KEEP_STR*/"Unused");
                    break;
                   case Used:
                    OS.$out(/*KEEP_STR*/"Used");
                    break;
                   case Uuid:
                    OS.$out(/*KEEP_STR*/"Uuid");
                    break;
                   case VecReturn:
                    OS.$out(/*KEEP_STR*/"VecReturn");
                    break;
                   case VecTypeHint:
                    OS.$out(/*KEEP_STR*/"VecTypeHint");
                    break;
                   case VectorCall:
                    OS.$out(/*KEEP_STR*/"VectorCall");
                    break;
                   case Visibility:
                    OS.$out(/*KEEP_STR*/"Visibility");
                    break;
                   case WarnUnused:
                    OS.$out(/*KEEP_STR*/"WarnUnused");
                    break;
                   case WarnUnusedResult:
                    OS.$out(/*KEEP_STR*/"WarnUnusedResult");
                    break;
                   case Weak:
                    OS.$out(/*KEEP_STR*/"Weak");
                    break;
                   case WeakImport:
                    OS.$out(/*KEEP_STR*/"WeakImport");
                    break;
                   case WeakRef:
                    OS.$out(/*KEEP_STR*/"WeakRef");
                    break;
                   case WorkGroupSizeHint:
                    OS.$out(/*KEEP_STR*/"WorkGroupSizeHint");
                    break;
                   case X86ForceAlignArgPointer:
                    OS.$out(/*KEEP_STR*/"X86ForceAlignArgPointer");
                    break;
                   case XRayInstrument:
                    OS.$out(/*KEEP_STR*/"XRayInstrument");
                    break;
                   case AbiTag:
                    OS.$out(/*KEEP_STR*/"AbiTag");
                    break;
                   case Alias:
                    OS.$out(/*KEEP_STR*/"Alias");
                    break;
                   case AlignValue:
                    OS.$out(/*KEEP_STR*/"AlignValue");
                    break;
                   case IFunc:
                    OS.$out(/*KEEP_STR*/"IFunc");
                    break;
                   case InitSeg:
                    OS.$out(/*KEEP_STR*/"InitSeg");
                    break;
                   case LoopHint:
                    OS.$out(/*KEEP_STR*/"LoopHint");
                    break;
                   case Mode:
                    OS.$out(/*KEEP_STR*/"Mode");
                    break;
                   case OMPDeclareSimdDecl:
                    OS.$out(/*KEEP_STR*/"OMPDeclareSimdDecl");
                    break;
                   case OMPDeclareTargetDecl:
                    OS.$out(/*KEEP_STR*/"OMPDeclareTargetDecl");
                    break;
                   case ObjCBoxable:
                    OS.$out(/*KEEP_STR*/"ObjCBoxable");
                    break;
                   case ObjCDesignatedInitializer:
                    OS.$out(/*KEEP_STR*/"ObjCDesignatedInitializer");
                    break;
                   case ObjCRuntimeName:
                    OS.$out(/*KEEP_STR*/"ObjCRuntimeName");
                    break;
                   case ObjCRuntimeVisible:
                    OS.$out(/*KEEP_STR*/"ObjCRuntimeVisible");
                    break;
                   case OpenCLAccess:
                    OS.$out(/*KEEP_STR*/"OpenCLAccess");
                    break;
                   case Overloadable:
                    OS.$out(/*KEEP_STR*/"Overloadable");
                    break;
                   case RenderScriptKernel:
                    OS.$out(/*KEEP_STR*/"RenderScriptKernel");
                    break;
                   case Thread:
                    OS.$out(/*KEEP_STR*/"Thread");
                    break;
                  }
                  OS.$out(/*KEEP_STR*/"Attr");
                } finally {
                  if (Color != null) { Color.$destroy(); }
                }
              }
              dumpPointer(L$A);
              dumpSourceRange(L$A.getRange());
              if (L$A.isInherited()) {
                OS.$out(/*KEEP_STR*/" Inherited");
              }
              if (L$A.isImplicit()) {
                OS.$out(/*KEEP_STR*/" Implicit");
              }
              /*===- TableGen'erated file -------------------------------------*- C++ -*-===*\
              |*                                                                            *|
              |* Attribute dumper                                                           *|
              |*                                                                            *|
              |* Automatically generated file, do not edit!                                 *|
              |*                                                                            *|
              \*===----------------------------------------------------------------------===*/
              switch (L$A.getKind()) {
               case AMDGPUNumSGPR:
                {
                  /*const*/ AMDGPUNumSGPRAttr /*P*/ SA = cast_AMDGPUNumSGPRAttr(L$A);
                  OS.$out(/*KEEP_STR*/$SPACE).$out_uint(SA.getNumSGPR());
                  break;
                }
               case AMDGPUNumVGPR:
                {
                  /*const*/ AMDGPUNumVGPRAttr /*P*/ SA = cast_AMDGPUNumVGPRAttr(L$A);
                  OS.$out(/*KEEP_STR*/$SPACE).$out_uint(SA.getNumVGPR());
                  break;
                }
               case ARMInterrupt:
                {
                  /*const*/ ARMInterruptAttr /*P*/ SA = cast_ARMInterruptAttr(L$A);
                  switch (SA.getInterrupt()) {
                   case IRQ:
                    OS.$out(/*KEEP_STR*/" IRQ");
                    break;
                   case FIQ:
                    OS.$out(/*KEEP_STR*/" FIQ");
                    break;
                   case SWI:
                    OS.$out(/*KEEP_STR*/" SWI");
                    break;
                   case ABORT:
                    OS.$out(/*KEEP_STR*/" ABORT");
                    break;
                   case UNDEF:
                    OS.$out(/*KEEP_STR*/" UNDEF");
                    break;
                   case Generic:
                    OS.$out(/*KEEP_STR*/" Generic");
                    break;
                  }
                  break;
                }
               case AbiTag:
                {
                  /*const*/ AbiTagAttr /*P*/ SA = cast_AbiTagAttr(L$A);
                  for (final /*const*/ StringRef /*&*/ Val : SA.tags())  {
                    OS.$out(/*KEEP_STR*/$SPACE).$out(/*NO_COPY*/Val);
                  }
                  break;
                }
               case AcquireCapability:
                {
                  OS.$out(/*KEEP_STR*/$SPACE).$out(L$A.getSpelling());
                  /*const*/ AcquireCapabilityAttr /*P*/ SA = cast_AcquireCapabilityAttr(L$A);
                  for (type$ptr<Expr /*P*/ /*P*/> I = $tryClone(SA.args_begin()), /*P*/ /*P*/ E = $tryClone(SA.args_end()); $noteq_ptr(I, E); I.$preInc())  {
                    dumpStmt(I.$star());
                  }
                  break;
                }
               case AcquiredAfter:
                {
                  /*const*/ AcquiredAfterAttr /*P*/ SA = cast_AcquiredAfterAttr(L$A);
                  for (type$ptr<Expr /*P*/ /*P*/> I = $tryClone(SA.args_begin()), /*P*/ /*P*/ E = $tryClone(SA.args_end()); $noteq_ptr(I, E); I.$preInc())  {
                    dumpStmt(I.$star());
                  }
                  break;
                }
               case AcquiredBefore:
                {
                  /*const*/ AcquiredBeforeAttr /*P*/ SA = cast_AcquiredBeforeAttr(L$A);
                  for (type$ptr<Expr /*P*/ /*P*/> I = $tryClone(SA.args_begin()), /*P*/ /*P*/ E = $tryClone(SA.args_end()); $noteq_ptr(I, E); I.$preInc())  {
                    dumpStmt(I.$star());
                  }
                  break;
                }
               case Alias:
                {
                  /*const*/ AliasAttr /*P*/ SA = cast_AliasAttr(L$A);
                  OS.$out(/*KEEP_STR*/" \"").$out(SA.getAliasee()).$out(/*KEEP_STR*/$DBL_QUOTE);
                  break;
                }
               case AlignMac68k:
                {
                  break;
                }
               case AlignValue:
                {
                  /*const*/ AlignValueAttr /*P*/ SA = cast_AlignValueAttr(L$A);
                  dumpStmt(SA.getAlignment());
                  break;
                }
               case Aligned:
                {
                  OS.$out(/*KEEP_STR*/$SPACE).$out(L$A.getSpelling());
                  /*const*/ AlignedAttr /*P*/ SA = cast_AlignedAttr(L$A);
                  if (SA.isAlignmentExpr()) {
                    dumpStmt(SA.getAlignmentExpr());
                  } else {
                    dumpType(SA.getAlignmentType().getType());
                  }
                  break;
                }
               case AlwaysInline:
                {
                  OS.$out(/*KEEP_STR*/$SPACE).$out(L$A.getSpelling());
                  break;
                }
               case AnalyzerNoReturn:
                {
                  break;
                }
               case Annotate:
                {
                  /*const*/ AnnotateAttr /*P*/ SA = cast_AnnotateAttr(L$A);
                  OS.$out(/*KEEP_STR*/" \"").$out(SA.getAnnotation()).$out(/*KEEP_STR*/$DBL_QUOTE);
                  break;
                }
               case AnyX86Interrupt:
                {
                  break;
                }
               case ArcWeakrefUnavailable:
                {
                  break;
                }
               case ArgumentWithTypeTag:
                {
                  OS.$out(/*KEEP_STR*/$SPACE).$out(L$A.getSpelling());
                  /*const*/ ArgumentWithTypeTagAttr /*P*/ SA = cast_ArgumentWithTypeTagAttr(L$A);
                  OS.$out(/*KEEP_STR*/$SPACE).$out(SA.getArgumentKind().getName());
                  OS.$out(/*KEEP_STR*/$SPACE).$out_uint(SA.getArgumentIdx());
                  OS.$out(/*KEEP_STR*/$SPACE).$out_uint(SA.getTypeTagIdx());
                  if (SA.getIsPointer()) {
                    OS.$out(/*KEEP_STR*/" IsPointer");
                  }
                  break;
                }
               case AsmLabel:
                {
                  /*const*/ AsmLabelAttr /*P*/ SA = cast_AsmLabelAttr(L$A);
                  OS.$out(/*KEEP_STR*/" \"").$out(SA.getLabel()).$out(/*KEEP_STR*/$DBL_QUOTE);
                  break;
                }
               case AssertCapability:
                {
                  OS.$out(/*KEEP_STR*/$SPACE).$out(L$A.getSpelling());
                  /*const*/ AssertCapabilityAttr /*P*/ SA = cast_AssertCapabilityAttr(L$A);
                  dumpStmt(SA.getExpr());
                  break;
                }
               case AssertExclusiveLock:
                {
                  /*const*/ AssertExclusiveLockAttr /*P*/ SA = cast_AssertExclusiveLockAttr(L$A);
                  for (type$ptr<Expr /*P*/ /*P*/> I = $tryClone(SA.args_begin()), /*P*/ /*P*/ E = $tryClone(SA.args_end()); $noteq_ptr(I, E); I.$preInc())  {
                    dumpStmt(I.$star());
                  }
                  break;
                }
               case AssertSharedLock:
                {
                  /*const*/ AssertSharedLockAttr /*P*/ SA = cast_AssertSharedLockAttr(L$A);
                  for (type$ptr<Expr /*P*/ /*P*/> I = $tryClone(SA.args_begin()), /*P*/ /*P*/ E = $tryClone(SA.args_end()); $noteq_ptr(I, E); I.$preInc())  {
                    dumpStmt(I.$star());
                  }
                  break;
                }
               case AssumeAligned:
                {
                  /*const*/ AssumeAlignedAttr /*P*/ SA = cast_AssumeAlignedAttr(L$A);
                  dumpStmt(SA.getAlignment());
                  dumpStmt(SA.getOffset());
                  break;
                }
               case Availability:
                {
                  /*const*/ AvailabilityAttr /*P*/ SA = cast_AvailabilityAttr(L$A);
                  OS.$out(/*KEEP_STR*/$SPACE).$out(SA.getPlatform().getName());
                  $out_raw_ostream_VersionTuple$C(OS.$out(/*KEEP_STR*/$SPACE), SA.getIntroduced());
                  $out_raw_ostream_VersionTuple$C(OS.$out(/*KEEP_STR*/$SPACE), SA.getDeprecated());
                  $out_raw_ostream_VersionTuple$C(OS.$out(/*KEEP_STR*/$SPACE), SA.getObsoleted());
                  if (SA.getUnavailable()) {
                    OS.$out(/*KEEP_STR*/" Unavailable");
                  }
                  OS.$out(/*KEEP_STR*/" \"").$out(SA.getMessage()).$out(/*KEEP_STR*/$DBL_QUOTE);
                  if (SA.getStrict()) {
                    OS.$out(/*KEEP_STR*/" Strict");
                  }
                  OS.$out(/*KEEP_STR*/" \"").$out(SA.getReplacement()).$out(/*KEEP_STR*/$DBL_QUOTE);
                  break;
                }
               case Blocks:
                {
                  /*const*/ BlocksAttr /*P*/ SA = cast_BlocksAttr(L$A);
                  switch (SA.getType()) {
                   case ByRef:
                    OS.$out(/*KEEP_STR*/" ByRef");
                    break;
                  }
                  break;
                }
               case C11NoReturn:
                {
                  break;
                }
               case CDecl:
                {
                  break;
                }
               case CFAuditedTransfer:
                {
                  break;
                }
               case CFConsumed:
                {
                  break;
                }
               case CFReturnsNotRetained:
                {
                  break;
                }
               case CFReturnsRetained:
                {
                  break;
                }
               case CFUnknownTransfer:
                {
                  break;
                }
               case CUDAConstant:
                {
                  break;
                }
               case CUDADevice:
                {
                  break;
                }
               case CUDAGlobal:
                {
                  break;
                }
               case CUDAHost:
                {
                  break;
                }
               case CUDAInvalidTarget:
                {
                  break;
                }
               case CUDALaunchBounds:
                {
                  /*const*/ CUDALaunchBoundsAttr /*P*/ SA = cast_CUDALaunchBoundsAttr(L$A);
                  dumpStmt(SA.getMaxThreads());
                  dumpStmt(SA.getMinBlocks());
                  break;
                }
               case CUDAShared:
                {
                  break;
                }
               case CXX11NoReturn:
                {
                  break;
                }
               case CallableWhen:
                {
                  /*const*/ CallableWhenAttr /*P*/ SA = cast_CallableWhenAttr(L$A);
                  for (type$ptr<CallableWhenAttr.ConsumedState /*P*/ > I = $tryClone(SA.callableStates_begin()), /*P*/ E = $tryClone(SA.callableStates_end()); $noteq_ptr(I, E); I.$preInc()) {
                    switch (I.$star()) {
                     case Unknown:
                      OS.$out(/*KEEP_STR*/" Unknown");
                      break;
                     case Consumed:
                      OS.$out(/*KEEP_STR*/" Consumed");
                      break;
                     case Unconsumed:
                      OS.$out(/*KEEP_STR*/" Unconsumed");
                      break;
                    }
                  }
                  break;
                }
               case Capability:
                {
                  OS.$out(/*KEEP_STR*/$SPACE).$out(L$A.getSpelling());
                  /*const*/ CapabilityAttr /*P*/ SA = cast_CapabilityAttr(L$A);
                  OS.$out(/*KEEP_STR*/" \"").$out(SA.getName()).$out(/*KEEP_STR*/$DBL_QUOTE);
                  break;
                }
               case CapturedRecord:
                {
                  break;
                }
               case CarriesDependency:
                {
                  break;
                }
               case Cleanup:
                {
                  /*const*/ CleanupAttr /*P*/ SA = cast_CleanupAttr(L$A);
                  OS.$out(/*KEEP_STR*/$SPACE);
                  dumpBareDeclRef(SA.getFunctionDecl());
                  break;
                }
               case Cold:
                {
                  break;
                }
               case Common:
                {
                  break;
                }
               case Const:
                {
                  break;
                }
               case Constructor:
                {
                  /*const*/ ConstructorAttr /*P*/ SA = cast_ConstructorAttr(L$A);
                  OS.$out(/*KEEP_STR*/$SPACE).$out_int(SA.getPriority());
                  break;
                }
               case Consumable:
                {
                  /*const*/ ConsumableAttr /*P*/ SA = cast_ConsumableAttr(L$A);
                  switch (SA.getDefaultState()) {
                   case Unknown:
                    OS.$out(/*KEEP_STR*/" Unknown");
                    break;
                   case Consumed:
                    OS.$out(/*KEEP_STR*/" Consumed");
                    break;
                   case Unconsumed:
                    OS.$out(/*KEEP_STR*/" Unconsumed");
                    break;
                  }
                  break;
                }
               case ConsumableAutoCast:
                {
                  break;
                }
               case ConsumableSetOnRead:
                {
                  break;
                }
               case DLLExport:
                {
                  break;
                }
               case DLLImport:
                {
                  break;
                }
               case Deprecated:
                {
                  /*const*/ DeprecatedAttr /*P*/ SA = cast_DeprecatedAttr(L$A);
                  OS.$out(/*KEEP_STR*/" \"").$out(SA.getMessage()).$out(/*KEEP_STR*/$DBL_QUOTE);
                  OS.$out(/*KEEP_STR*/" \"").$out(SA.getReplacement()).$out(/*KEEP_STR*/$DBL_QUOTE);
                  break;
                }
               case Destructor:
                {
                  /*const*/ DestructorAttr /*P*/ SA = cast_DestructorAttr(L$A);
                  OS.$out(/*KEEP_STR*/$SPACE).$out_int(SA.getPriority());
                  break;
                }
               case DisableTailCalls:
                {
                  break;
                }
               case EmptyBases:
                {
                  break;
                }
               case EnableIf:
                {
                  /*const*/ EnableIfAttr /*P*/ SA = cast_EnableIfAttr(L$A);
                  OS.$out(/*KEEP_STR*/" \"").$out(SA.getMessage()).$out(/*KEEP_STR*/$DBL_QUOTE);
                  dumpStmt(SA.getCond());
                  break;
                }
               case ExclusiveTrylockFunction:
                {
                  /*const*/ ExclusiveTrylockFunctionAttr /*P*/ SA = cast_ExclusiveTrylockFunctionAttr(L$A);
                  dumpStmt(SA.getSuccessValue());
                  for (type$ptr<Expr /*P*/ /*P*/> I = $tryClone(SA.args_begin()), /*P*/ /*P*/ E = $tryClone(SA.args_end()); $noteq_ptr(I, E); I.$preInc())  {
                    dumpStmt(I.$star());
                  }
                  break;
                }
               case FallThrough:
                {
                  break;
                }
               case FastCall:
                {
                  break;
                }
               case Final:
                {
                  OS.$out(/*KEEP_STR*/$SPACE).$out(L$A.getSpelling());
                  break;
                }
               case FlagEnum:
                {
                  break;
                }
               case Flatten:
                {
                  break;
                }
               case Format:
                {
                  /*const*/ FormatAttr /*P*/ SA = cast_FormatAttr(L$A);
                  OS.$out(/*KEEP_STR*/$SPACE).$out(SA.getType().getName());
                  OS.$out(/*KEEP_STR*/$SPACE).$out_int(SA.getFormatIdx());
                  OS.$out(/*KEEP_STR*/$SPACE).$out_int(SA.getFirstArg());
                  break;
                }
               case FormatArg:
                {
                  /*const*/ FormatArgAttr /*P*/ SA = cast_FormatArgAttr(L$A);
                  OS.$out(/*KEEP_STR*/$SPACE).$out_int(SA.getFormatIdx());
                  break;
                }
               case GNUInline:
                {
                  break;
                }
               case GuardedBy:
                {
                  /*const*/ GuardedByAttr /*P*/ SA = cast_GuardedByAttr(L$A);
                  dumpStmt(SA.getArg());
                  break;
                }
               case GuardedVar:
                {
                  break;
                }
               case Hot:
                {
                  break;
                }
               case IBAction:
                {
                  break;
                }
               case IBOutlet:
                {
                  break;
                }
               case IBOutletCollection:
                {
                  /*const*/ IBOutletCollectionAttr /*P*/ SA = cast_IBOutletCollectionAttr(L$A);
                  OS.$out(/*KEEP_STR*/$SPACE).$out(SA.getInterface().getAsString());
                  break;
                }
               case IFunc:
                {
                  /*const*/ IFuncAttr /*P*/ SA = cast_IFuncAttr(L$A);
                  OS.$out(/*KEEP_STR*/" \"").$out(SA.getResolver()).$out(/*KEEP_STR*/$DBL_QUOTE);
                  break;
                }
               case InitPriority:
                {
                  /*const*/ InitPriorityAttr /*P*/ SA = cast_InitPriorityAttr(L$A);
                  OS.$out(/*KEEP_STR*/$SPACE).$out_uint(SA.getPriority());
                  break;
                }
               case InitSeg:
                {
                  /*const*/ InitSegAttr /*P*/ SA = cast_InitSegAttr(L$A);
                  OS.$out(/*KEEP_STR*/" \"").$out(SA.getSection()).$out(/*KEEP_STR*/$DBL_QUOTE);
                  break;
                }
               case IntelOclBicc:
                {
                  break;
                }
               case InternalLinkage:
                {
                  break;
                }
               case LTOVisibilityPublic:
                {
                  break;
                }
               case LayoutVersion:
                {
                  /*const*/ LayoutVersionAttr /*P*/ SA = cast_LayoutVersionAttr(L$A);
                  OS.$out(/*KEEP_STR*/$SPACE).$out_uint(SA.getVersion());
                  break;
                }
               case LockReturned:
                {
                  /*const*/ LockReturnedAttr /*P*/ SA = cast_LockReturnedAttr(L$A);
                  dumpStmt(SA.getArg());
                  break;
                }
               case LocksExcluded:
                {
                  /*const*/ LocksExcludedAttr /*P*/ SA = cast_LocksExcludedAttr(L$A);
                  for (type$ptr<Expr /*P*/ /*P*/> I = $tryClone(SA.args_begin()), /*P*/ /*P*/ E = $tryClone(SA.args_end()); $noteq_ptr(I, E); I.$preInc())  {
                    dumpStmt(I.$star());
                  }
                  break;
                }
               case LoopHint:
                {
                  OS.$out(/*KEEP_STR*/$SPACE).$out(L$A.getSpelling());
                  /*const*/ LoopHintAttr /*P*/ SA = cast_LoopHintAttr(L$A);
                  switch (SA.getOption()) {
                   case Vectorize:
                    OS.$out(/*KEEP_STR*/" Vectorize");
                    break;
                   case VectorizeWidth:
                    OS.$out(/*KEEP_STR*/" VectorizeWidth");
                    break;
                   case Interleave:
                    OS.$out(/*KEEP_STR*/" Interleave");
                    break;
                   case InterleaveCount:
                    OS.$out(/*KEEP_STR*/" InterleaveCount");
                    break;
                   case Unroll:
                    OS.$out(/*KEEP_STR*/" Unroll");
                    break;
                   case UnrollCount:
                    OS.$out(/*KEEP_STR*/" UnrollCount");
                    break;
                   case Distribute:
                    OS.$out(/*KEEP_STR*/" Distribute");
                    break;
                  }
                  switch (SA.getState()) {
                   case Enable:
                    OS.$out(/*KEEP_STR*/" Enable");
                    break;
                   case Disable:
                    OS.$out(/*KEEP_STR*/" Disable");
                    break;
                   case Numeric:
                    OS.$out(/*KEEP_STR*/" Numeric");
                    break;
                   case AssumeSafety:
                    OS.$out(/*KEEP_STR*/" AssumeSafety");
                    break;
                   case Full:
                    OS.$out(/*KEEP_STR*/" Full");
                    break;
                  }
                  dumpStmt(SA.getValue());
                  break;
                }
               case MSABI:
                {
                  break;
                }
               case MSInheritance:
                {
                  OS.$out(/*KEEP_STR*/$SPACE).$out(L$A.getSpelling());
                  /*const*/ MSInheritanceAttr /*P*/ SA = cast_MSInheritanceAttr(L$A);
                  if (SA.getBestCase()) {
                    OS.$out(/*KEEP_STR*/" BestCase");
                  }
                  break;
                }
               case MSNoVTable:
                {
                  break;
                }
               case MSP430Interrupt:
                {
                  /*const*/ MSP430InterruptAttr /*P*/ SA = cast_MSP430InterruptAttr(L$A);
                  OS.$out(/*KEEP_STR*/$SPACE).$out_uint(SA.getNumber());
                  break;
                }
               case MSStruct:
                {
                  break;
                }
               case MSVtorDisp:
                {
                  /*const*/ MSVtorDispAttr /*P*/ SA = cast_MSVtorDispAttr(L$A);
                  OS.$out(/*KEEP_STR*/$SPACE).$out_uint(SA.getVdm());
                  break;
                }
               case MaxFieldAlignment:
                {
                  /*const*/ MaxFieldAlignmentAttr /*P*/ SA = cast_MaxFieldAlignmentAttr(L$A);
                  OS.$out(/*KEEP_STR*/$SPACE).$out_uint(SA.getAlignment());
                  break;
                }
               case MayAlias:
                {
                  break;
                }
               case MinSize:
                {
                  break;
                }
               case Mips16:
                {
                  break;
                }
               case MipsInterrupt:
                {
                  /*const*/ MipsInterruptAttr /*P*/ SA = cast_MipsInterruptAttr(L$A);
                  switch (SA.getInterrupt()) {
                   case sw0:
                    OS.$out(/*KEEP_STR*/" sw0");
                    break;
                   case sw1:
                    OS.$out(/*KEEP_STR*/" sw1");
                    break;
                   case hw0:
                    OS.$out(/*KEEP_STR*/" hw0");
                    break;
                   case hw1:
                    OS.$out(/*KEEP_STR*/" hw1");
                    break;
                   case hw2:
                    OS.$out(/*KEEP_STR*/" hw2");
                    break;
                   case hw3:
                    OS.$out(/*KEEP_STR*/" hw3");
                    break;
                   case hw4:
                    OS.$out(/*KEEP_STR*/" hw4");
                    break;
                   case hw5:
                    OS.$out(/*KEEP_STR*/" hw5");
                    break;
                   case eic:
                    OS.$out(/*KEEP_STR*/" eic");
                    break;
                  }
                  break;
                }
               case Mode:
                {
                  /*const*/ ModeAttr /*P*/ SA = cast_ModeAttr(L$A);
                  OS.$out(/*KEEP_STR*/$SPACE).$out(SA.getMode().getName());
                  break;
                }
               case NSConsumed:
                {
                  break;
                }
               case NSConsumesSelf:
                {
                  break;
                }
               case NSReturnsAutoreleased:
                {
                  break;
                }
               case NSReturnsNotRetained:
                {
                  break;
                }
               case NSReturnsRetained:
                {
                  break;
                }
               case Naked:
                {
                  break;
                }
               case NoAlias:
                {
                  break;
                }
               case NoCommon:
                {
                  break;
                }
               case NoDebug:
                {
                  break;
                }
               case NoDuplicate:
                {
                  break;
                }
               case NoInline:
                {
                  break;
                }
               case NoInstrumentFunction:
                {
                  break;
                }
               case NoMips16:
                {
                  break;
                }
               case NoReturn:
                {
                  break;
                }
               case NoSanitize:
                {
                  /*const*/ NoSanitizeAttr /*P*/ SA = cast_NoSanitizeAttr(L$A);
                  for (final /*const*/ StringRef /*&*/ Val : SA.sanitizers())  {
                    OS.$out(/*KEEP_STR*/$SPACE).$out(/*NO_COPY*/Val);
                  }
                  break;
                }
               case NoSplitStack:
                {
                  break;
                }
               case NoThreadSafetyAnalysis:
                {
                  break;
                }
               case NoThrow:
                {
                  break;
                }
               case NonNull:
                {
                  /*const*/ NonNullAttr /*P*/ SA = cast_NonNullAttr(L$A);
                  for (final /*const*/int/*uint &*/ Val : SA.args())  {
                    OS.$out(/*KEEP_STR*/$SPACE).$out_uint(Val);
                  }
                  break;
                }
               case NotTailCalled:
                {
                  break;
                }
               case OMPCaptureNoInit:
                {
                  break;
                }
               case OMPDeclareSimdDecl:
                {
                  /*const*/ OMPDeclareSimdDeclAttr /*P*/ SA = cast_OMPDeclareSimdDeclAttr(L$A);
                  switch (SA.getBranchState()) {
                   case BS_Undefined:
                    OS.$out(/*KEEP_STR*/" BS_Undefined");
                    break;
                   case BS_Inbranch:
                    OS.$out(/*KEEP_STR*/" BS_Inbranch");
                    break;
                   case BS_Notinbranch:
                    OS.$out(/*KEEP_STR*/" BS_Notinbranch");
                    break;
                  }
                  for (final /*const*/int/*uint &*/ Val : SA.modifiers())  {
                    OS.$out(/*KEEP_STR*/$SPACE).$out_uint(Val);
                  }
                  dumpStmt(SA.getSimdlen());
                  for (type$ptr<Expr /*P*/ /*P*/> I = $tryClone(SA.uniforms_begin()), /*P*/ /*P*/ E = $tryClone(SA.uniforms_end()); $noteq_ptr(I, E); I.$preInc())  {
                    dumpStmt(I.$star());
                  }
                  for (type$ptr<Expr /*P*/ /*P*/> I = $tryClone(SA.aligneds_begin()), /*P*/ /*P*/ E = $tryClone(SA.aligneds_end()); $noteq_ptr(I, E); I.$preInc())  {
                    dumpStmt(I.$star());
                  }
                  for (type$ptr<Expr /*P*/ /*P*/> I = $tryClone(SA.alignments_begin()), /*P*/ /*P*/ E = $tryClone(SA.alignments_end()); $noteq_ptr(I, E); I.$preInc())  {
                    dumpStmt(I.$star());
                  }
                  for (type$ptr<Expr /*P*/ /*P*/> I = $tryClone(SA.linears_begin()), /*P*/ /*P*/ E = $tryClone(SA.linears_end()); $noteq_ptr(I, E); I.$preInc())  {
                    dumpStmt(I.$star());
                  }
                  for (type$ptr<Expr /*P*/ /*P*/> I = $tryClone(SA.steps_begin()), /*P*/ /*P*/ E = $tryClone(SA.steps_end()); $noteq_ptr(I, E); I.$preInc())  {
                    dumpStmt(I.$star());
                  }
                  break;
                }
               case OMPDeclareTargetDecl:
                {
                  /*const*/ OMPDeclareTargetDeclAttr /*P*/ SA = cast_OMPDeclareTargetDeclAttr(L$A);
                  switch (SA.getMapType()) {
                   case MT_To:
                    OS.$out(/*KEEP_STR*/" MT_To");
                    break;
                   case MT_Link:
                    OS.$out(/*KEEP_STR*/" MT_Link");
                    break;
                  }
                  break;
                }
               case OMPThreadPrivateDecl:
                {
                  break;
                }
               case ObjCBoxable:
                {
                  break;
                }
               case ObjCBridge:
                {
                  /*const*/ ObjCBridgeAttr /*P*/ SA = cast_ObjCBridgeAttr(L$A);
                  OS.$out(/*KEEP_STR*/$SPACE).$out(SA.getBridgedType().getName());
                  break;
                }
               case ObjCBridgeMutable:
                {
                  /*const*/ ObjCBridgeMutableAttr /*P*/ SA = cast_ObjCBridgeMutableAttr(L$A);
                  OS.$out(/*KEEP_STR*/$SPACE).$out(SA.getBridgedType().getName());
                  break;
                }
               case ObjCBridgeRelated:
                {
                  /*const*/ ObjCBridgeRelatedAttr /*P*/ SA = cast_ObjCBridgeRelatedAttr(L$A);
                  OS.$out(/*KEEP_STR*/$SPACE).$out(SA.getRelatedClass().getName());
                  if ((SA.getClassMethod() != null)) {
                    OS.$out(/*KEEP_STR*/$SPACE).$out(SA.getClassMethod().getName());
                  }
                  if ((SA.getInstanceMethod() != null)) {
                    OS.$out(/*KEEP_STR*/$SPACE).$out(SA.getInstanceMethod().getName());
                  }
                  break;
                }
               case ObjCDesignatedInitializer:
                {
                  break;
                }
               case ObjCException:
                {
                  break;
                }
               case ObjCExplicitProtocolImpl:
                {
                  break;
                }
               case ObjCIndependentClass:
                {
                  break;
                }
               case ObjCMethodFamily:
                {
                  /*const*/ ObjCMethodFamilyAttr /*P*/ SA = cast_ObjCMethodFamilyAttr(L$A);
                  switch (SA.getFamily()) {
                   case OMF_None:
                    OS.$out(/*KEEP_STR*/" OMF_None");
                    break;
                   case OMF_alloc:
                    OS.$out(/*KEEP_STR*/" OMF_alloc");
                    break;
                   case OMF_copy:
                    OS.$out(/*KEEP_STR*/" OMF_copy");
                    break;
                   case OMF_init:
                    OS.$out(/*KEEP_STR*/" OMF_init");
                    break;
                   case OMF_mutableCopy:
                    OS.$out(/*KEEP_STR*/" OMF_mutableCopy");
                    break;
                   case OMF_new:
                    OS.$out(/*KEEP_STR*/" OMF_new");
                    break;
                  }
                  break;
                }
               case ObjCNSObject:
                {
                  break;
                }
               case ObjCPreciseLifetime:
                {
                  break;
                }
               case ObjCRequiresPropertyDefs:
                {
                  break;
                }
               case ObjCRequiresSuper:
                {
                  break;
                }
               case ObjCReturnsInnerPointer:
                {
                  break;
                }
               case ObjCRootClass:
                {
                  break;
                }
               case ObjCRuntimeName:
                {
                  /*const*/ ObjCRuntimeNameAttr /*P*/ SA = cast_ObjCRuntimeNameAttr(L$A);
                  OS.$out(/*KEEP_STR*/" \"").$out(SA.getMetadataName()).$out(/*KEEP_STR*/$DBL_QUOTE);
                  break;
                }
               case ObjCRuntimeVisible:
                {
                  break;
                }
               case OpenCLAccess:
                {
                  OS.$out(/*KEEP_STR*/$SPACE).$out(L$A.getSpelling());
                  break;
                }
               case OpenCLKernel:
                {
                  break;
                }
               case OpenCLUnrollHint:
                {
                  /*const*/ OpenCLUnrollHintAttr /*P*/ SA = cast_OpenCLUnrollHintAttr(L$A);
                  OS.$out(/*KEEP_STR*/$SPACE).$out_uint(SA.getUnrollHint());
                  break;
                }
               case OptimizeNone:
                {
                  break;
                }
               case Overloadable:
                {
                  break;
                }
               case Override:
                {
                  break;
                }
               case Ownership:
                {
                  OS.$out(/*KEEP_STR*/$SPACE).$out(L$A.getSpelling());
                  /*const*/ OwnershipAttr /*P*/ SA = cast_OwnershipAttr(L$A);
                  OS.$out(/*KEEP_STR*/$SPACE).$out(SA.getModule().getName());
                  for (final /*const*/int/*uint &*/ Val : SA.args())  {
                    OS.$out(/*KEEP_STR*/$SPACE).$out_uint(Val);
                  }
                  break;
                }
               case Packed:
                {
                  break;
                }
               case ParamTypestate:
                {
                  /*const*/ ParamTypestateAttr /*P*/ SA = cast_ParamTypestateAttr(L$A);
                  switch (SA.getParamState()) {
                   case Unknown:
                    OS.$out(/*KEEP_STR*/" Unknown");
                    break;
                   case Consumed:
                    OS.$out(/*KEEP_STR*/" Consumed");
                    break;
                   case Unconsumed:
                    OS.$out(/*KEEP_STR*/" Unconsumed");
                    break;
                  }
                  break;
                }
               case Pascal:
                {
                  break;
                }
               case PassObjectSize:
                {
                  /*const*/ PassObjectSizeAttr /*P*/ SA = cast_PassObjectSizeAttr(L$A);
                  OS.$out(/*KEEP_STR*/$SPACE).$out_int(SA.getType());
                  break;
                }
               case Pcs:
                {
                  /*const*/ PcsAttr /*P*/ SA = cast_PcsAttr(L$A);
                  switch (SA.getPCS()) {
                   case AAPCS:
                    OS.$out(/*KEEP_STR*/" AAPCS");
                    break;
                   case AAPCS_VFP:
                    OS.$out(/*KEEP_STR*/" AAPCS_VFP");
                    break;
                  }
                  break;
                }
               case PreserveAll:
                {
                  break;
                }
               case PreserveMost:
                {
                  break;
                }
               case PtGuardedBy:
                {
                  /*const*/ PtGuardedByAttr /*P*/ SA = cast_PtGuardedByAttr(L$A);
                  dumpStmt(SA.getArg());
                  break;
                }
               case PtGuardedVar:
                {
                  break;
                }
               case Pure:
                {
                  break;
                }
               case ReleaseCapability:
                {
                  OS.$out(/*KEEP_STR*/$SPACE).$out(L$A.getSpelling());
                  /*const*/ ReleaseCapabilityAttr /*P*/ SA = cast_ReleaseCapabilityAttr(L$A);
                  for (type$ptr<Expr /*P*/ /*P*/> I = $tryClone(SA.args_begin()), /*P*/ /*P*/ E = $tryClone(SA.args_end()); $noteq_ptr(I, E); I.$preInc())  {
                    dumpStmt(I.$star());
                  }
                  break;
                }
               case RenderScriptKernel:
                {
                  break;
                }
               case ReqdWorkGroupSize:
                {
                  /*const*/ ReqdWorkGroupSizeAttr /*P*/ SA = cast_ReqdWorkGroupSizeAttr(L$A);
                  OS.$out(/*KEEP_STR*/$SPACE).$out_uint(SA.getXDim());
                  OS.$out(/*KEEP_STR*/$SPACE).$out_uint(SA.getYDim());
                  OS.$out(/*KEEP_STR*/$SPACE).$out_uint(SA.getZDim());
                  break;
                }
               case RequiresCapability:
                {
                  OS.$out(/*KEEP_STR*/$SPACE).$out(L$A.getSpelling());
                  /*const*/ RequiresCapabilityAttr /*P*/ SA = cast_RequiresCapabilityAttr(L$A);
                  for (type$ptr<Expr /*P*/ /*P*/> I = $tryClone(SA.args_begin()), /*P*/ /*P*/ E = $tryClone(SA.args_end()); $noteq_ptr(I, E); I.$preInc())  {
                    dumpStmt(I.$star());
                  }
                  break;
                }
               case Restrict:
                {
                  OS.$out(/*KEEP_STR*/$SPACE).$out(L$A.getSpelling());
                  break;
                }
               case ReturnTypestate:
                {
                  /*const*/ ReturnTypestateAttr /*P*/ SA = cast_ReturnTypestateAttr(L$A);
                  switch (SA.getState()) {
                   case Unknown:
                    OS.$out(/*KEEP_STR*/" Unknown");
                    break;
                   case Consumed:
                    OS.$out(/*KEEP_STR*/" Consumed");
                    break;
                   case Unconsumed:
                    OS.$out(/*KEEP_STR*/" Unconsumed");
                    break;
                  }
                  break;
                }
               case ReturnsNonNull:
                {
                  break;
                }
               case ReturnsTwice:
                {
                  break;
                }
               case ScopedLockable:
                {
                  break;
                }
               case Section:
                {
                  OS.$out(/*KEEP_STR*/$SPACE).$out(L$A.getSpelling());
                  /*const*/ SectionAttr /*P*/ SA = cast_SectionAttr(L$A);
                  OS.$out(/*KEEP_STR*/" \"").$out(SA.getName()).$out(/*KEEP_STR*/$DBL_QUOTE);
                  break;
                }
               case SelectAny:
                {
                  break;
                }
               case Sentinel:
                {
                  /*const*/ SentinelAttr /*P*/ SA = cast_SentinelAttr(L$A);
                  OS.$out(/*KEEP_STR*/$SPACE).$out_int(SA.getSentinel());
                  OS.$out(/*KEEP_STR*/$SPACE).$out_int(SA.getNullPos());
                  break;
                }
               case SetTypestate:
                {
                  /*const*/ SetTypestateAttr /*P*/ SA = cast_SetTypestateAttr(L$A);
                  switch (SA.getNewState()) {
                   case Unknown:
                    OS.$out(/*KEEP_STR*/" Unknown");
                    break;
                   case Consumed:
                    OS.$out(/*KEEP_STR*/" Consumed");
                    break;
                   case Unconsumed:
                    OS.$out(/*KEEP_STR*/" Unconsumed");
                    break;
                  }
                  break;
                }
               case SharedTrylockFunction:
                {
                  /*const*/ SharedTrylockFunctionAttr /*P*/ SA = cast_SharedTrylockFunctionAttr(L$A);
                  dumpStmt(SA.getSuccessValue());
                  for (type$ptr<Expr /*P*/ /*P*/> I = $tryClone(SA.args_begin()), /*P*/ /*P*/ E = $tryClone(SA.args_end()); $noteq_ptr(I, E); I.$preInc())  {
                    dumpStmt(I.$star());
                  }
                  break;
                }
               case StdCall:
                {
                  break;
                }
               case SwiftCall:
                {
                  break;
                }
               case SwiftContext:
                {
                  break;
                }
               case SwiftErrorResult:
                {
                  break;
                }
               case SwiftIndirectResult:
                {
                  break;
                }
               case SysVABI:
                {
                  break;
                }
               case TLSModel:
                {
                  /*const*/ TLSModelAttr /*P*/ SA = cast_TLSModelAttr(L$A);
                  OS.$out(/*KEEP_STR*/" \"").$out(SA.getModel()).$out(/*KEEP_STR*/$DBL_QUOTE);
                  break;
                }
               case Target:
                {
                  /*const*/ TargetAttr /*P*/ SA = cast_TargetAttr(L$A);
                  OS.$out(/*KEEP_STR*/" \"").$out(SA.getFeaturesStr()).$out(/*KEEP_STR*/$DBL_QUOTE);
                  break;
                }
               case TestTypestate:
                {
                  /*const*/ TestTypestateAttr /*P*/ SA = cast_TestTypestateAttr(L$A);
                  switch (SA.getTestState()) {
                   case Consumed:
                    OS.$out(/*KEEP_STR*/" Consumed");
                    break;
                   case Unconsumed:
                    OS.$out(/*KEEP_STR*/" Unconsumed");
                    break;
                  }
                  break;
                }
               case ThisCall:
                {
                  break;
                }
               case Thread:
                {
                  break;
                }
               case TransparentUnion:
                {
                  break;
                }
               case TryAcquireCapability:
                {
                  OS.$out(/*KEEP_STR*/$SPACE).$out(L$A.getSpelling());
                  /*const*/ TryAcquireCapabilityAttr /*P*/ SA = cast_TryAcquireCapabilityAttr(L$A);
                  dumpStmt(SA.getSuccessValue());
                  for (type$ptr<Expr /*P*/ /*P*/> I = $tryClone(SA.args_begin()), /*P*/ /*P*/ E = $tryClone(SA.args_end()); $noteq_ptr(I, E); I.$preInc())  {
                    dumpStmt(I.$star());
                  }
                  break;
                }
               case TypeTagForDatatype:
                {
                  /*const*/ TypeTagForDatatypeAttr /*P*/ SA = cast_TypeTagForDatatypeAttr(L$A);
                  OS.$out(/*KEEP_STR*/$SPACE).$out(SA.getArgumentKind().getName());
                  OS.$out(/*KEEP_STR*/$SPACE).$out(SA.getMatchingCType().getAsString());
                  if (SA.getLayoutCompatible()) {
                    OS.$out(/*KEEP_STR*/" LayoutCompatible");
                  }
                  if (SA.getMustBeNull()) {
                    OS.$out(/*KEEP_STR*/" MustBeNull");
                  }
                  break;
                }
               case TypeVisibility:
                {
                  /*const*/ TypeVisibilityAttr /*P*/ SA = cast_TypeVisibilityAttr(L$A);
                  switch (SA.getVisibility()) {
                   case Default:
                    OS.$out(/*KEEP_STR*/" Default");
                    break;
                   case Hidden:
                    OS.$out(/*KEEP_STR*/" Hidden");
                    break;
                   case Protected:
                    OS.$out(/*KEEP_STR*/" Protected");
                    break;
                  }
                  break;
                }
               case Unavailable:
                {
                  /*const*/ UnavailableAttr /*P*/ SA = cast_UnavailableAttr(L$A);
                  OS.$out(/*KEEP_STR*/" \"").$out(SA.getMessage()).$out(/*KEEP_STR*/$DBL_QUOTE);
                  switch (SA.getImplicitReason()) {
                   case IR_None:
                    OS.$out(/*KEEP_STR*/" IR_None");
                    break;
                   case IR_ARCForbiddenType:
                    OS.$out(/*KEEP_STR*/" IR_ARCForbiddenType");
                    break;
                   case IR_ForbiddenWeak:
                    OS.$out(/*KEEP_STR*/" IR_ForbiddenWeak");
                    break;
                   case IR_ARCForbiddenConversion:
                    OS.$out(/*KEEP_STR*/" IR_ARCForbiddenConversion");
                    break;
                   case IR_ARCInitReturnsUnrelated:
                    OS.$out(/*KEEP_STR*/" IR_ARCInitReturnsUnrelated");
                    break;
                   case IR_ARCFieldWithOwnership:
                    OS.$out(/*KEEP_STR*/" IR_ARCFieldWithOwnership");
                    break;
                  }
                  break;
                }
               case Unused:
                {
                  OS.$out(/*KEEP_STR*/$SPACE).$out(L$A.getSpelling());
                  break;
                }
               case Used:
                {
                  break;
                }
               case Uuid:
                {
                  /*const*/ UuidAttr /*P*/ SA = cast_UuidAttr(L$A);
                  OS.$out(/*KEEP_STR*/" \"").$out(SA.getGuid()).$out(/*KEEP_STR*/$DBL_QUOTE);
                  break;
                }
               case VecReturn:
                {
                  break;
                }
               case VecTypeHint:
                {
                  /*const*/ VecTypeHintAttr /*P*/ SA = cast_VecTypeHintAttr(L$A);
                  OS.$out(/*KEEP_STR*/$SPACE).$out(SA.getTypeHint().getAsString());
                  break;
                }
               case VectorCall:
                {
                  break;
                }
               case Visibility:
                {
                  /*const*/ VisibilityAttr /*P*/ SA = cast_VisibilityAttr(L$A);
                  switch (SA.getVisibility()) {
                   case Default:
                    OS.$out(/*KEEP_STR*/" Default");
                    break;
                   case Hidden:
                    OS.$out(/*KEEP_STR*/" Hidden");
                    break;
                   case Protected:
                    OS.$out(/*KEEP_STR*/" Protected");
                    break;
                  }
                  break;
                }
               case WarnUnused:
                {
                  break;
                }
               case WarnUnusedResult:
                {
                  OS.$out(/*KEEP_STR*/$SPACE).$out(L$A.getSpelling());
                  break;
                }
               case Weak:
                {
                  break;
                }
               case WeakImport:
                {
                  break;
                }
               case WeakRef:
                {
                  /*const*/ WeakRefAttr /*P*/ SA = cast_WeakRefAttr(L$A);
                  OS.$out(/*KEEP_STR*/" \"").$out(SA.getAliasee()).$out(/*KEEP_STR*/$DBL_QUOTE);
                  break;
                }
               case WorkGroupSizeHint:
                {
                  /*const*/ WorkGroupSizeHintAttr /*P*/ SA = cast_WorkGroupSizeHintAttr(L$A);
                  OS.$out(/*KEEP_STR*/$SPACE).$out_uint(SA.getXDim());
                  OS.$out(/*KEEP_STR*/$SPACE).$out_uint(SA.getYDim());
                  OS.$out(/*KEEP_STR*/$SPACE).$out_uint(SA.getZDim());
                  break;
                }
               case X86ForceAlignArgPointer:
                {
                  break;
                }
               case XRayInstrument:
                {
                  OS.$out(/*KEEP_STR*/$SPACE).$out(L$A.getSpelling());
                  break;
                }
              }
            });
  }

  
  // C++ Utilities
  
  //===----------------------------------------------------------------------===//
  //  C++ Utilities
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::dumpAccessSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 891,
   FQN="(anonymous namespace)::ASTDumper::dumpAccessSpecifier", NM="_ZN12_GLOBAL__N_19ASTDumper19dumpAccessSpecifierEN5clang15AccessSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper19dumpAccessSpecifierEN5clang15AccessSpecifierE")
  //</editor-fold>
  public void dumpAccessSpecifier(AccessSpecifier AS) {
    switch (AS) {
     case AS_none:
      break;
     case AS_public:
      OS.$out(/*KEEP_STR*/$public);
      break;
     case AS_protected:
      OS.$out(/*KEEP_STR*/$protected);
      break;
     case AS_private:
      OS.$out(/*KEEP_STR*/$private);
      break;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::dumpCXXCtorInitializer">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 907,
   FQN="(anonymous namespace)::ASTDumper::dumpCXXCtorInitializer", NM="_ZN12_GLOBAL__N_19ASTDumper22dumpCXXCtorInitializerEPKN5clang18CXXCtorInitializerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper22dumpCXXCtorInitializerEPKN5clang18CXXCtorInitializerE")
  //</editor-fold>
  public void dumpCXXCtorInitializer(/*const*/ CXXCtorInitializer /*P*/ Init) {
    CXXCtorInitializer L$Init = Init;
    dumpChild(/*[=, this, =L$Init(Init)]*/() -> {
              OS.$out(/*KEEP_STR*/"CXXCtorInitializer");
              if (L$Init.isAnyMemberInitializer()) {
                OS.$out_char($$SPACE);
                dumpBareDeclRef(L$Init.getAnyMember());
              } else if (L$Init.isBaseInitializer()) {
                dumpType(new QualType(L$Init.getBaseClass(), 0));
              } else if (L$Init.isDelegatingInitializer()) {
                dumpType(L$Init.getTypeSourceInfo().getType());
              } else {
                throw new llvm_unreachable("Unknown initializer type");
              }
              dumpStmt(L$Init.getInit());
            });
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::dumpTemplateParameters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 924,
   FQN="(anonymous namespace)::ASTDumper::dumpTemplateParameters", NM="_ZN12_GLOBAL__N_19ASTDumper22dumpTemplateParametersEPKN5clang21TemplateParameterListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper22dumpTemplateParametersEPKN5clang21TemplateParameterListE")
  //</editor-fold>
  public void dumpTemplateParameters(/*const*/ TemplateParameterList /*P*/ TPL) {
    if (!(TPL != null)) {
      return;
    }
    
    for (type$ptr<NamedDecl /*P*/ /*const*/ /*P*/> I = $tryClone(TPL.begin$Const()), /*P*/ /*const*/ /*P*/ E = $tryClone(TPL.end$Const());
         $noteq_ptr(I, E); I.$preInc())  {
      dumpDecl(I.$star());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::dumpTemplateArgumentListInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 933,
   FQN="(anonymous namespace)::ASTDumper::dumpTemplateArgumentListInfo", NM="_ZN12_GLOBAL__N_19ASTDumper28dumpTemplateArgumentListInfoERKN5clang24TemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper28dumpTemplateArgumentListInfoERKN5clang24TemplateArgumentListInfoE")
  //</editor-fold>
  public void dumpTemplateArgumentListInfo(final /*const*/ TemplateArgumentListInfo /*&*/ TALI) {
    for (/*uint*/int i = 0, e = TALI.size(); $less_uint(i, e); ++i)  {
      dumpTemplateArgumentLoc(TALI.$at$Const(i));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::dumpTemplateArgumentLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 939,
   FQN="(anonymous namespace)::ASTDumper::dumpTemplateArgumentLoc", NM="_ZN12_GLOBAL__N_19ASTDumper23dumpTemplateArgumentLocERKN5clang19TemplateArgumentLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper23dumpTemplateArgumentLocERKN5clang19TemplateArgumentLocE")
  //</editor-fold>
  public void dumpTemplateArgumentLoc(final /*const*/ TemplateArgumentLoc /*&*/ A) {
    dumpTemplateArgument(A.getArgument(), A.getSourceRange());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::dumpTemplateArgumentList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 943,
   FQN="(anonymous namespace)::ASTDumper::dumpTemplateArgumentList", NM="_ZN12_GLOBAL__N_19ASTDumper24dumpTemplateArgumentListERKN5clang20TemplateArgumentListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper24dumpTemplateArgumentListERKN5clang20TemplateArgumentListE")
  //</editor-fold>
  public void dumpTemplateArgumentList(final /*const*/ TemplateArgumentList /*&*/ TAL) {
    for (/*uint*/int i = 0, e = TAL.size(); $less_uint(i, e); ++i)  {
      dumpTemplateArgument(TAL.$at(i));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::dumpTemplateArgument">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 948,
   FQN="(anonymous namespace)::ASTDumper::dumpTemplateArgument", NM="_ZN12_GLOBAL__N_19ASTDumper20dumpTemplateArgumentERKN5clang16TemplateArgumentENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper20dumpTemplateArgumentERKN5clang16TemplateArgumentENS1_11SourceRangeE")
  //</editor-fold>
  public void dumpTemplateArgument(final /*const*/ TemplateArgument /*&*/ A) {
    dumpTemplateArgument(A, new SourceRange());
  }
  public void dumpTemplateArgument(final /*const*/ TemplateArgument /*&*/ A, SourceRange R/*= SourceRange()*/) {
    TemplateArgument L$A = A;
    SourceRange L$R = $tryClone(R);
    dumpChild(/*[=, this, =L$R(R), =L$A(A)]*/() -> {
              OS.$out(/*KEEP_STR*/"TemplateArgument");
              if (L$R.isValid()) {
                dumpSourceRange(new SourceRange(L$R));
              }
              switch (L$A.getKind()) {
               case Null:
                OS.$out(/*KEEP_STR*/" null");
                break;
               case Type:
                OS.$out(/*KEEP_STR*/" type");
                dumpType(L$A.getAsType());
                break;
               case Declaration:
                OS.$out(/*KEEP_STR*/" decl");
                dumpDeclRef(L$A.getAsDecl());
                break;
               case NullPtr:
                OS.$out(/*KEEP_STR*/" nullptr");
                break;
               case Integral:
                $out_raw_ostream_APSInt$C(OS.$out(/*KEEP_STR*/" integral "), L$A.getAsIntegral());
                break;
               case Template:
                OS.$out(/*KEEP_STR*/" template ");
                L$A.getAsTemplate().dump(OS);
                break;
               case TemplateExpansion:
                OS.$out(/*KEEP_STR*/" template expansion");
                L$A.getAsTemplateOrTemplatePattern().dump(OS);
                break;
               case Expression:
                OS.$out(/*KEEP_STR*/" expr");
                dumpStmt(L$A.getAsExpr());
                break;
               case Pack:
                OS.$out(/*KEEP_STR*/" pack");
                for (type$ptr<TemplateArgument>/*pack_iterator*/ I = $tryClone(L$A.pack_begin()), /*P*/ E = $tryClone(L$A.pack_end());
                     $noteq_ptr(I, E); I.$preInc())  {
                  dumpTemplateArgument(I.$star());
                }
                break;
              }
            });
  }

  
  // Objective-C utilities.
  
  //===----------------------------------------------------------------------===//
  //  Objective-C Utilities
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::dumpObjCTypeParamList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 997,
   FQN="(anonymous namespace)::ASTDumper::dumpObjCTypeParamList", NM="_ZN12_GLOBAL__N_19ASTDumper21dumpObjCTypeParamListEPKN5clang17ObjCTypeParamListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper21dumpObjCTypeParamListEPKN5clang17ObjCTypeParamListE")
  //</editor-fold>
  public void dumpObjCTypeParamList(/*const*/ ObjCTypeParamList /*P*/ typeParams) {
    if (!(typeParams != null)) {
      return;
    }
    
    for (ObjCTypeParamDecl /*P*/ typeParam : $Deref(typeParams)) {
      dumpDecl(typeParam);
    }
  }

  
  // Types
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitComplexType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 250,
   FQN="(anonymous namespace)::ASTDumper::VisitComplexType", NM="_ZN12_GLOBAL__N_19ASTDumper16VisitComplexTypeEPKN5clang11ComplexTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper16VisitComplexTypeEPKN5clang11ComplexTypeE")
  //</editor-fold>
  public void VisitComplexType(/*const*/ ComplexType /*P*/ T) {
    dumpTypeAsChild(T.getElementType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 253,
   FQN="(anonymous namespace)::ASTDumper::VisitPointerType", NM="_ZN12_GLOBAL__N_19ASTDumper16VisitPointerTypeEPKN5clang11PointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper16VisitPointerTypeEPKN5clang11PointerTypeE")
  //</editor-fold>
  public void VisitPointerType(/*const*/ PointerType /*P*/ T) {
    dumpTypeAsChild(T.getPointeeType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitBlockPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 256,
   FQN="(anonymous namespace)::ASTDumper::VisitBlockPointerType", NM="_ZN12_GLOBAL__N_19ASTDumper21VisitBlockPointerTypeEPKN5clang16BlockPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper21VisitBlockPointerTypeEPKN5clang16BlockPointerTypeE")
  //</editor-fold>
  public void VisitBlockPointerType(/*const*/ BlockPointerType /*P*/ T) {
    dumpTypeAsChild(T.getPointeeType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitReferenceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 259,
   FQN="(anonymous namespace)::ASTDumper::VisitReferenceType", NM="_ZN12_GLOBAL__N_19ASTDumper18VisitReferenceTypeEPKN5clang13ReferenceTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper18VisitReferenceTypeEPKN5clang13ReferenceTypeE")
  //</editor-fold>
  public void VisitReferenceType(/*const*/ ReferenceType /*P*/ T) {
    dumpTypeAsChild(T.getPointeeType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitRValueReferenceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 262,
   FQN="(anonymous namespace)::ASTDumper::VisitRValueReferenceType", NM="_ZN12_GLOBAL__N_19ASTDumper24VisitRValueReferenceTypeEPKN5clang13ReferenceTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper24VisitRValueReferenceTypeEPKN5clang13ReferenceTypeE")
  //</editor-fold>
  public void VisitRValueReferenceType(/*const*/ ReferenceType /*P*/ T) {
    if (T.isSpelledAsLValue()) {
      OS.$out(/*KEEP_STR*/" written as lvalue reference");
    }
    VisitReferenceType(T);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitMemberPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 267,
   FQN="(anonymous namespace)::ASTDumper::VisitMemberPointerType", NM="_ZN12_GLOBAL__N_19ASTDumper22VisitMemberPointerTypeEPKN5clang17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper22VisitMemberPointerTypeEPKN5clang17MemberPointerTypeE")
  //</editor-fold>
  public void VisitMemberPointerType(/*const*/ MemberPointerType /*P*/ T) {
    dumpTypeAsChild(T.__getClass());
    dumpTypeAsChild(T.getPointeeType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 271,
   FQN="(anonymous namespace)::ASTDumper::VisitArrayType", NM="_ZN12_GLOBAL__N_19ASTDumper14VisitArrayTypeEPKN5clang9ArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper14VisitArrayTypeEPKN5clang9ArrayTypeE")
  //</editor-fold>
  public void VisitArrayType(/*const*/ ArrayType /*P*/ T) {
    switch (T.getSizeModifier()) {
     case Normal:
      break;
     case Static:
      OS.$out(/*KEEP_STR*/" static");
      break;
     case Star:
      OS.$out(/*KEEP_STR*/" *");
      break;
    }
    OS.$out(/*KEEP_STR*/$SPACE).$out(T.getIndexTypeQualifiers().getAsString());
    dumpTypeAsChild(T.getElementType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitConstantArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 280,
   FQN="(anonymous namespace)::ASTDumper::VisitConstantArrayType", NM="_ZN12_GLOBAL__N_19ASTDumper22VisitConstantArrayTypeEPKN5clang17ConstantArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper22VisitConstantArrayTypeEPKN5clang17ConstantArrayTypeE")
  //</editor-fold>
  public void VisitConstantArrayType(/*const*/ ConstantArrayType /*P*/ T) {
    $out_raw_ostream_APInt$C(OS.$out(/*KEEP_STR*/$SPACE), T.getSize());
    VisitArrayType(T);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitVariableArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 284,
   FQN="(anonymous namespace)::ASTDumper::VisitVariableArrayType", NM="_ZN12_GLOBAL__N_19ASTDumper22VisitVariableArrayTypeEPKN5clang17VariableArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper22VisitVariableArrayTypeEPKN5clang17VariableArrayTypeE")
  //</editor-fold>
  public void VisitVariableArrayType(/*const*/ VariableArrayType /*P*/ T) {
    OS.$out(/*KEEP_STR*/$SPACE);
    dumpSourceRange(T.getBracketsRange());
    VisitArrayType(T);
    dumpStmt(T.getSizeExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitDependentSizedArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 290,
   FQN="(anonymous namespace)::ASTDumper::VisitDependentSizedArrayType", NM="_ZN12_GLOBAL__N_19ASTDumper28VisitDependentSizedArrayTypeEPKN5clang23DependentSizedArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper28VisitDependentSizedArrayTypeEPKN5clang23DependentSizedArrayTypeE")
  //</editor-fold>
  public void VisitDependentSizedArrayType(/*const*/ DependentSizedArrayType /*P*/ T) {
    VisitArrayType(T);
    OS.$out(/*KEEP_STR*/$SPACE);
    dumpSourceRange(T.getBracketsRange());
    dumpStmt(T.getSizeExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitDependentSizedExtVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 296,
   FQN="(anonymous namespace)::ASTDumper::VisitDependentSizedExtVectorType", NM="_ZN12_GLOBAL__N_19ASTDumper32VisitDependentSizedExtVectorTypeEPKN5clang27DependentSizedExtVectorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper32VisitDependentSizedExtVectorTypeEPKN5clang27DependentSizedExtVectorTypeE")
  //</editor-fold>
  public void VisitDependentSizedExtVectorType(/*const*/ DependentSizedExtVectorType /*P*/ T) {
    OS.$out(/*KEEP_STR*/$SPACE);
    dumpLocation(T.getAttributeLoc());
    dumpTypeAsChild(T.getElementType());
    dumpStmt(T.getSizeExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 303,
   FQN="(anonymous namespace)::ASTDumper::VisitVectorType", NM="_ZN12_GLOBAL__N_19ASTDumper15VisitVectorTypeEPKN5clang10VectorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper15VisitVectorTypeEPKN5clang10VectorTypeE")
  //</editor-fold>
  public void VisitVectorType(/*const*/ VectorType /*P*/ T) {
    switch (T.getVectorKind()) {
     case GenericVector:
      break;
     case AltiVecVector:
      OS.$out(/*KEEP_STR*/" altivec");
      break;
     case AltiVecPixel:
      OS.$out(/*KEEP_STR*/" altivec pixel");
      break;
     case AltiVecBool:
      OS.$out(/*KEEP_STR*/" altivec bool");
      break;
     case NeonVector:
      OS.$out(/*KEEP_STR*/" neon");
      break;
     case NeonPolyVector:
      OS.$out(/*KEEP_STR*/" neon poly");
      break;
    }
    OS.$out(/*KEEP_STR*/$SPACE).$out_uint(T.getNumElements());
    dumpTypeAsChild(T.getElementType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitFunctionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 315,
   FQN="(anonymous namespace)::ASTDumper::VisitFunctionType", NM="_ZN12_GLOBAL__N_19ASTDumper17VisitFunctionTypeEPKN5clang12FunctionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper17VisitFunctionTypeEPKN5clang12FunctionTypeE")
  //</editor-fold>
  public void VisitFunctionType(/*const*/ FunctionType /*P*/ T) {
    FunctionType.ExtInfo EI = T.getExtInfo();
    if (EI.getNoReturn()) {
      OS.$out(/*KEEP_STR*/" noreturn");
    }
    if (EI.getProducesResult()) {
      OS.$out(/*KEEP_STR*/" produces_result");
    }
    if (EI.getHasRegParm()) {
      OS.$out(/*KEEP_STR*/" regparm ").$out_uint(EI.getRegParm());
    }
    OS.$out(/*KEEP_STR*/$SPACE).$out(FunctionType.getNameForCallConv(EI.getCC()));
    dumpTypeAsChild(T.getReturnType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitFunctionProtoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 323,
   FQN="(anonymous namespace)::ASTDumper::VisitFunctionProtoType", NM="_ZN12_GLOBAL__N_19ASTDumper22VisitFunctionProtoTypeEPKN5clang17FunctionProtoTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper22VisitFunctionProtoTypeEPKN5clang17FunctionProtoTypeE")
  //</editor-fold>
  public void VisitFunctionProtoType(/*const*/ FunctionProtoType /*P*/ T) {
    FunctionProtoType.ExtProtoInfo EPI = T.getExtProtoInfo();
    if (EPI.HasTrailingReturn) {
      OS.$out(/*KEEP_STR*/" trailing_return");
    }
    if (T.isConst()) {
      OS.$out(/*KEEP_STR*/" const");
    }
    if (T.isVolatile()) {
      OS.$out(/*KEEP_STR*/" volatile");
    }
    if (T.isRestrict()) {
      OS.$out(/*KEEP_STR*/" restrict");
    }
    switch (EPI.RefQualifier) {
     case RQ_None:
      break;
     case RQ_LValue:
      OS.$out(/*KEEP_STR*/" &");
      break;
     case RQ_RValue:
      OS.$out(/*KEEP_STR*/" &&");
      break;
    }
    // FIXME: Exception specification.
    // FIXME: Consumed parameters.
    VisitFunctionType(T);
    for (QualType PT : T.getParamTypes())  {
      dumpTypeAsChild(new QualType(PT));
    }
    if (EPI.Variadic) {
      dumpChild(/*[=, this]*/() -> {
                OS.$out(/*KEEP_STR*/$ELLIPSIS);
              });
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitUnresolvedUsingType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 342,
   FQN="(anonymous namespace)::ASTDumper::VisitUnresolvedUsingType", NM="_ZN12_GLOBAL__N_19ASTDumper24VisitUnresolvedUsingTypeEPKN5clang19UnresolvedUsingTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper24VisitUnresolvedUsingTypeEPKN5clang19UnresolvedUsingTypeE")
  //</editor-fold>
  public void VisitUnresolvedUsingType(/*const*/ UnresolvedUsingType /*P*/ T) {
    dumpDeclRef(T.getDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitTypedefType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 345,
   FQN="(anonymous namespace)::ASTDumper::VisitTypedefType", NM="_ZN12_GLOBAL__N_19ASTDumper16VisitTypedefTypeEPKN5clang11TypedefTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper16VisitTypedefTypeEPKN5clang11TypedefTypeE")
  //</editor-fold>
  public void VisitTypedefType(/*const*/ TypedefType /*P*/ T) {
    dumpDeclRef(T.getDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitTypeOfExprType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 348,
   FQN="(anonymous namespace)::ASTDumper::VisitTypeOfExprType", NM="_ZN12_GLOBAL__N_19ASTDumper19VisitTypeOfExprTypeEPKN5clang14TypeOfExprTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper19VisitTypeOfExprTypeEPKN5clang14TypeOfExprTypeE")
  //</editor-fold>
  public void VisitTypeOfExprType(/*const*/ TypeOfExprType /*P*/ T) {
    dumpStmt(T.getUnderlyingExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitDecltypeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 351,
   FQN="(anonymous namespace)::ASTDumper::VisitDecltypeType", NM="_ZN12_GLOBAL__N_19ASTDumper17VisitDecltypeTypeEPKN5clang12DecltypeTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper17VisitDecltypeTypeEPKN5clang12DecltypeTypeE")
  //</editor-fold>
  public void VisitDecltypeType(/*const*/ DecltypeType /*P*/ T) {
    dumpStmt(T.getUnderlyingExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitUnaryTransformType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 354,
   FQN="(anonymous namespace)::ASTDumper::VisitUnaryTransformType", NM="_ZN12_GLOBAL__N_19ASTDumper23VisitUnaryTransformTypeEPKN5clang18UnaryTransformTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper23VisitUnaryTransformTypeEPKN5clang18UnaryTransformTypeE")
  //</editor-fold>
  public void VisitUnaryTransformType(/*const*/ UnaryTransformType /*P*/ T) {
    switch (T.getUTTKind()) {
     case EnumUnderlyingType:
      OS.$out(/*KEEP_STR*/" underlying_type");
      break;
    }
    dumpTypeAsChild(T.getBaseType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitTagType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 362,
   FQN="(anonymous namespace)::ASTDumper::VisitTagType", NM="_ZN12_GLOBAL__N_19ASTDumper12VisitTagTypeEPKN5clang7TagTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper12VisitTagTypeEPKN5clang7TagTypeE")
  //</editor-fold>
  public void VisitTagType(/*const*/ TagType /*P*/ T) {
    dumpDeclRef(T.getDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitAttributedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 365,
   FQN="(anonymous namespace)::ASTDumper::VisitAttributedType", NM="_ZN12_GLOBAL__N_19ASTDumper19VisitAttributedTypeEPKN5clang14AttributedTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper19VisitAttributedTypeEPKN5clang14AttributedTypeE")
  //</editor-fold>
  public void VisitAttributedType(/*const*/ AttributedType /*P*/ T) {
    // FIXME: AttrKind
    dumpTypeAsChild(T.getModifiedType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitTemplateTypeParmType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 369,
   FQN="(anonymous namespace)::ASTDumper::VisitTemplateTypeParmType", NM="_ZN12_GLOBAL__N_19ASTDumper25VisitTemplateTypeParmTypeEPKN5clang20TemplateTypeParmTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper25VisitTemplateTypeParmTypeEPKN5clang20TemplateTypeParmTypeE")
  //</editor-fold>
  public void VisitTemplateTypeParmType(/*const*/ TemplateTypeParmType /*P*/ T) {
    OS.$out(/*KEEP_STR*/" depth ").$out_uint(T.getDepth()).$out(/*KEEP_STR*/" index ").$out_uint(T.getIndex());
    if (T.isParameterPack()) {
      OS.$out(/*KEEP_STR*/" pack");
    }
    dumpDeclRef(T.getDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitSubstTemplateTypeParmType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 374,
   FQN="(anonymous namespace)::ASTDumper::VisitSubstTemplateTypeParmType", NM="_ZN12_GLOBAL__N_19ASTDumper30VisitSubstTemplateTypeParmTypeEPKN5clang25SubstTemplateTypeParmTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper30VisitSubstTemplateTypeParmTypeEPKN5clang25SubstTemplateTypeParmTypeE")
  //</editor-fold>
  public void VisitSubstTemplateTypeParmType(/*const*/ SubstTemplateTypeParmType /*P*/ T) {
    dumpTypeAsChild(T.getReplacedParameter());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitSubstTemplateTypeParmPackType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 377,
   FQN="(anonymous namespace)::ASTDumper::VisitSubstTemplateTypeParmPackType", NM="_ZN12_GLOBAL__N_19ASTDumper34VisitSubstTemplateTypeParmPackTypeEPKN5clang29SubstTemplateTypeParmPackTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper34VisitSubstTemplateTypeParmPackTypeEPKN5clang29SubstTemplateTypeParmPackTypeE")
  //</editor-fold>
  public void VisitSubstTemplateTypeParmPackType(/*const*/ SubstTemplateTypeParmPackType /*P*/ T) {
    dumpTypeAsChild(T.getReplacedParameter());
    dumpTemplateArgument(T.getArgumentPack());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitAutoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 382,
   FQN="(anonymous namespace)::ASTDumper::VisitAutoType", NM="_ZN12_GLOBAL__N_19ASTDumper13VisitAutoTypeEPKN5clang8AutoTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper13VisitAutoTypeEPKN5clang8AutoTypeE")
  //</editor-fold>
  public void VisitAutoType(/*const*/ AutoType /*P*/ T) {
    if (T.isDecltypeAuto()) {
      OS.$out(/*KEEP_STR*/" decltype(auto)");
    }
    if (!T.isDeduced()) {
      OS.$out(/*KEEP_STR*/" undeduced");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitTemplateSpecializationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 387,
   FQN="(anonymous namespace)::ASTDumper::VisitTemplateSpecializationType", NM="_ZN12_GLOBAL__N_19ASTDumper31VisitTemplateSpecializationTypeEPKN5clang26TemplateSpecializationTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper31VisitTemplateSpecializationTypeEPKN5clang26TemplateSpecializationTypeE")
  //</editor-fold>
  public void VisitTemplateSpecializationType(/*const*/ TemplateSpecializationType /*P*/ T) {
    if (T.isTypeAlias()) {
      OS.$out(/*KEEP_STR*/" alias");
    }
    OS.$out(/*KEEP_STR*/$SPACE);
    T.getTemplateName().dump(OS);
    for (final /*const*/ TemplateArgument /*&*/ Arg : $Deref(T))  {
      dumpTemplateArgument(Arg);
    }
    if (T.isTypeAlias()) {
      dumpTypeAsChild(T.getAliasedType());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitInjectedClassNameType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 395,
   FQN="(anonymous namespace)::ASTDumper::VisitInjectedClassNameType", NM="_ZN12_GLOBAL__N_19ASTDumper26VisitInjectedClassNameTypeEPKN5clang21InjectedClassNameTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper26VisitInjectedClassNameTypeEPKN5clang21InjectedClassNameTypeE")
  //</editor-fold>
  public void VisitInjectedClassNameType(/*const*/ InjectedClassNameType /*P*/ T) {
    dumpDeclRef(T.getDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitObjCInterfaceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 398,
   FQN="(anonymous namespace)::ASTDumper::VisitObjCInterfaceType", NM="_ZN12_GLOBAL__N_19ASTDumper22VisitObjCInterfaceTypeEPKN5clang17ObjCInterfaceTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper22VisitObjCInterfaceTypeEPKN5clang17ObjCInterfaceTypeE")
  //</editor-fold>
  public void VisitObjCInterfaceType(/*const*/ ObjCInterfaceType /*P*/ T) {
    dumpDeclRef(T.getDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitObjCObjectPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 401,
   FQN="(anonymous namespace)::ASTDumper::VisitObjCObjectPointerType", NM="_ZN12_GLOBAL__N_19ASTDumper26VisitObjCObjectPointerTypeEPKN5clang21ObjCObjectPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper26VisitObjCObjectPointerTypeEPKN5clang21ObjCObjectPointerTypeE")
  //</editor-fold>
  public void VisitObjCObjectPointerType(/*const*/ ObjCObjectPointerType /*P*/ T) {
    dumpTypeAsChild(T.getPointeeType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitAtomicType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 404,
   FQN="(anonymous namespace)::ASTDumper::VisitAtomicType", NM="_ZN12_GLOBAL__N_19ASTDumper15VisitAtomicTypeEPKN5clang10AtomicTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper15VisitAtomicTypeEPKN5clang10AtomicTypeE")
  //</editor-fold>
  public void VisitAtomicType(/*const*/ AtomicType /*P*/ T) {
    dumpTypeAsChild(T.getValueType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitPipeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 407,
   FQN="(anonymous namespace)::ASTDumper::VisitPipeType", NM="_ZN12_GLOBAL__N_19ASTDumper13VisitPipeTypeEPKN5clang8PipeTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper13VisitPipeTypeEPKN5clang8PipeTypeE")
  //</editor-fold>
  public void VisitPipeType(/*const*/ PipeType /*P*/ T) {
    dumpTypeAsChild(T.getElementType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitAdjustedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 410,
   FQN="(anonymous namespace)::ASTDumper::VisitAdjustedType", NM="_ZN12_GLOBAL__N_19ASTDumper17VisitAdjustedTypeEPKN5clang12AdjustedTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper17VisitAdjustedTypeEPKN5clang12AdjustedTypeE")
  //</editor-fold>
  public void VisitAdjustedType(/*const*/ AdjustedType /*P*/ T) {
    dumpTypeAsChild(T.getOriginalType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitPackExpansionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 413,
   FQN="(anonymous namespace)::ASTDumper::VisitPackExpansionType", NM="_ZN12_GLOBAL__N_19ASTDumper22VisitPackExpansionTypeEPKN5clang17PackExpansionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper22VisitPackExpansionTypeEPKN5clang17PackExpansionTypeE")
  //</editor-fold>
  public void VisitPackExpansionType(/*const*/ PackExpansionType /*P*/ T) {
    {
      OptionalUInt N = T.getNumExpansions();
      if (N.$bool()) {
        OS.$out(/*KEEP_STR*/" expansions ").$out_uint(N.$star());
      }
    }
    if (!T.isSugared()) {
      dumpTypeAsChild(T.getPattern());
    }
  }

  // FIXME: ElaboratedType, DependentNameType,
  // DependentTemplateSpecializationType, ObjCObjectType
  
  // Decls
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitLabelDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1070,
   FQN="(anonymous namespace)::ASTDumper::VisitLabelDecl", NM="_ZN12_GLOBAL__N_19ASTDumper14VisitLabelDeclEPKN5clang9LabelDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper14VisitLabelDeclEPKN5clang9LabelDeclE")
  //</editor-fold>
  public void VisitLabelDecl(/*const*/ LabelDecl /*P*/ D) {
    dumpName(D);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitTypedefDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1074,
   FQN="(anonymous namespace)::ASTDumper::VisitTypedefDecl", NM="_ZN12_GLOBAL__N_19ASTDumper16VisitTypedefDeclEPKN5clang11TypedefDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper16VisitTypedefDeclEPKN5clang11TypedefDeclE")
  //</editor-fold>
  public void VisitTypedefDecl(/*const*/ TypedefDecl /*P*/ D) {
    dumpName(D);
    dumpType(D.getUnderlyingType());
    if (D.isModulePrivate()) {
      OS.$out(/*KEEP_STR*/" __module_private__");
    }
    dumpTypeAsChild(D.getUnderlyingType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitEnumDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1082,
   FQN="(anonymous namespace)::ASTDumper::VisitEnumDecl", NM="_ZN12_GLOBAL__N_19ASTDumper13VisitEnumDeclEPKN5clang8EnumDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper13VisitEnumDeclEPKN5clang8EnumDeclE")
  //</editor-fold>
  public void VisitEnumDecl(/*const*/ EnumDecl /*P*/ D) {
    if (D.isScoped()) {
      if (D.isScopedUsingClassTag()) {
        OS.$out(/*KEEP_STR*/" class");
      } else {
        OS.$out(/*KEEP_STR*/" struct");
      }
    }
    dumpName(D);
    if (D.isModulePrivate()) {
      OS.$out(/*KEEP_STR*/" __module_private__");
    }
    if (D.isFixed()) {
      dumpType(D.getIntegerType());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitRecordDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1096,
   FQN="(anonymous namespace)::ASTDumper::VisitRecordDecl", NM="_ZN12_GLOBAL__N_19ASTDumper15VisitRecordDeclEPKN5clang10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper15VisitRecordDeclEPKN5clang10RecordDeclE")
  //</editor-fold>
  public void VisitRecordDecl(/*const*/ RecordDecl /*P*/ D) {
    OS.$out_char($$SPACE).$out(D.getKindName());
    dumpName(D);
    if (D.isModulePrivate()) {
      OS.$out(/*KEEP_STR*/" __module_private__");
    }
    if (D.isCompleteDefinition()) {
      OS.$out(/*KEEP_STR*/" definition");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitEnumConstantDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1105,
   FQN="(anonymous namespace)::ASTDumper::VisitEnumConstantDecl", NM="_ZN12_GLOBAL__N_19ASTDumper21VisitEnumConstantDeclEPKN5clang16EnumConstantDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper21VisitEnumConstantDeclEPKN5clang16EnumConstantDeclE")
  //</editor-fold>
  public void VisitEnumConstantDecl(/*const*/ EnumConstantDecl /*P*/ D) {
    dumpName(D);
    dumpType(D.getType());
    {
      /*const*/ Expr /*P*/ Init = D.getInitExpr$Const();
      if ((Init != null)) {
        dumpStmt(Init);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitIndirectFieldDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1112,
   FQN="(anonymous namespace)::ASTDumper::VisitIndirectFieldDecl", NM="_ZN12_GLOBAL__N_19ASTDumper22VisitIndirectFieldDeclEPKN5clang17IndirectFieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper22VisitIndirectFieldDeclEPKN5clang17IndirectFieldDeclE")
  //</editor-fold>
  public void VisitIndirectFieldDecl(/*const*/ IndirectFieldDecl /*P*/ D) {
    dumpName(D);
    dumpType(D.getType());
    
    for (NamedDecl /*P*/ Child : D.chain())  {
      dumpDeclRef(Child);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitFunctionDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1120,
   FQN="(anonymous namespace)::ASTDumper::VisitFunctionDecl", NM="_ZN12_GLOBAL__N_19ASTDumper17VisitFunctionDeclEPKN5clang12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper17VisitFunctionDeclEPKN5clang12FunctionDeclE")
  //</editor-fold>
  public void VisitFunctionDecl(/*const*/ FunctionDecl /*P*/ D) {
    dumpName(D);
    dumpType(D.getType());
    
    StorageClass SC = D.getStorageClass();
    if (SC != StorageClass.SC_None) {
      OS.$out_char($$SPACE).$out(VarDecl.getStorageClassSpecifierString(SC));
    }
    if (D.isInlineSpecified()) {
      OS.$out(/*KEEP_STR*/" inline");
    }
    if (D.isVirtualAsWritten()) {
      OS.$out(/*KEEP_STR*/" virtual");
    }
    if (D.isModulePrivate()) {
      OS.$out(/*KEEP_STR*/" __module_private__");
    }
    if (D.isPure()) {
      OS.$out(/*KEEP_STR*/" pure");
    } else if (D.isDeletedAsWritten()) {
      OS.$out(/*KEEP_STR*/" delete");
    }
    {
      
      /*const*/ FunctionProtoType /*P*/ FPT = D.getType().$arrow().getAs(FunctionProtoType.class);
      if ((FPT != null)) {
        FunctionProtoType.ExtProtoInfo EPI = FPT.getExtProtoInfo();
        switch (EPI.ExceptionSpec.Type) {
         default:
          break;
         case EST_Unevaluated:
          OS.$out(/*KEEP_STR*/" noexcept-unevaluated ").$out(EPI.ExceptionSpec.SourceDecl);
          break;
         case EST_Uninstantiated:
          OS.$out(/*KEEP_STR*/" noexcept-uninstantiated ").$out(EPI.ExceptionSpec.SourceTemplate);
          break;
        }
      }
    }
    {
      
      /*const*/ FunctionTemplateSpecializationInfo /*P*/ FTSI = D.getTemplateSpecializationInfo();
      if ((FTSI != null)) {
        dumpTemplateArgumentList($Deref(FTSI.TemplateArguments));
      }
    }
    
    for (type$ptr<NamedDecl /*P*/ /*P*/> I = $tryClone(D.getDeclsInPrototypeScope().begin()), 
        /*P*/ E = $tryClone(D.getDeclsInPrototypeScope().end()); $noteq_ptr(I, E); I.$preInc())  {
      dumpDecl(I.$star());
    }
    if (!Native.$bool(D.param_begin$Const()) && (D.getNumParams() != 0)) {
      FunctionDecl L$D = D;
      dumpChild(/*[=, this, =L$D(D)]*/() -> {
                OS.$out(/*KEEP_STR*/"<<NULL params x ").$out_uint(L$D.getNumParams()).$out(/*KEEP_STR*/$GT_GT);
              });
    } else {
      for (/*const*/ ParmVarDecl /*P*/ Parameter : D.parameters$Const())  {
        dumpDecl(Parameter);
      }
    }
    {
      
      /*const*/ CXXConstructorDecl /*P*/ C = dyn_cast_CXXConstructorDecl(D);
      if ((C != null)) {
        for (type$ptr<CXXCtorInitializer/*P*/> I = $tryClone(C.init_begin$Const()), 
            /*P*/ /*const*/ /*P*/ E = $tryClone(C.init_end$Const());
             $noteq_ptr(I, E); I.$preInc())  {
          dumpCXXCtorInitializer(I.$star());
        }
      }
    }
    if (D.doesThisDeclarationHaveABody()) {
      dumpStmt(D.getBody());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitFieldDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1177,
   FQN="(anonymous namespace)::ASTDumper::VisitFieldDecl", NM="_ZN12_GLOBAL__N_19ASTDumper14VisitFieldDeclEPKN5clang9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper14VisitFieldDeclEPKN5clang9FieldDeclE")
  //</editor-fold>
  public void VisitFieldDecl(/*const*/ FieldDecl /*P*/ D) {
    dumpName(D);
    dumpType(D.getType());
    if (D.isMutable()) {
      OS.$out(/*KEEP_STR*/" mutable");
    }
    if (D.isModulePrivate()) {
      OS.$out(/*KEEP_STR*/" __module_private__");
    }
    if (D.isBitField()) {
      dumpStmt(D.getBitWidth());
    }
    {
      Expr /*P*/ Init = D.getInClassInitializer();
      if ((Init != null)) {
        dumpStmt(Init);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitVarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1191,
   FQN="(anonymous namespace)::ASTDumper::VisitVarDecl", NM="_ZN12_GLOBAL__N_19ASTDumper12VisitVarDeclEPKN5clang7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper12VisitVarDeclEPKN5clang7VarDeclE")
  //</editor-fold>
  public void VisitVarDecl(/*const*/ VarDecl /*P*/ D) {
    dumpName(D);
    dumpType(D.getType());
    StorageClass SC = D.getStorageClass();
    if (SC != StorageClass.SC_None) {
      OS.$out_char($$SPACE).$out(VarDecl.getStorageClassSpecifierString(SC));
    }
    switch (D.getTLSKind()) {
     case TLS_None:
      break;
     case TLS_Static:
      OS.$out(/*KEEP_STR*/" tls");
      break;
     case TLS_Dynamic:
      OS.$out(/*KEEP_STR*/" tls_dynamic");
      break;
    }
    if (D.isModulePrivate()) {
      OS.$out(/*KEEP_STR*/" __module_private__");
    }
    if (D.isNRVOVariable()) {
      OS.$out(/*KEEP_STR*/" nrvo");
    }
    if (D.isInline()) {
      OS.$out(/*KEEP_STR*/" inline");
    }
    if (D.isConstexpr()) {
      OS.$out(/*KEEP_STR*/" constexpr");
    }
    if (D.hasInit()) {
      switch (D.getInitStyle()) {
       case CInit:
        OS.$out(/*KEEP_STR*/" cinit");
        break;
       case CallInit:
        OS.$out(/*KEEP_STR*/" callinit");
        break;
       case ListInit:
        OS.$out(/*KEEP_STR*/" listinit");
        break;
      }
      dumpStmt(D.getInit$Const());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitFileScopeAsmDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1220,
   FQN="(anonymous namespace)::ASTDumper::VisitFileScopeAsmDecl", NM="_ZN12_GLOBAL__N_19ASTDumper21VisitFileScopeAsmDeclEPKN5clang16FileScopeAsmDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper21VisitFileScopeAsmDeclEPKN5clang16FileScopeAsmDeclE")
  //</editor-fold>
  public void VisitFileScopeAsmDecl(/*const*/ FileScopeAsmDecl /*P*/ D) {
    dumpStmt(D.getAsmString$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitImportDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1224,
   FQN="(anonymous namespace)::ASTDumper::VisitImportDecl", NM="_ZN12_GLOBAL__N_19ASTDumper15VisitImportDeclEPKN5clang10ImportDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper15VisitImportDeclEPKN5clang10ImportDeclE")
  //</editor-fold>
  public void VisitImportDecl(/*const*/ ImportDecl /*P*/ D) {
    OS.$out_char($$SPACE).$out(D.getImportedModule().getFullModuleName());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitPragmaCommentDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1228,
   FQN="(anonymous namespace)::ASTDumper::VisitPragmaCommentDecl", NM="_ZN12_GLOBAL__N_19ASTDumper22VisitPragmaCommentDeclEPKN5clang17PragmaCommentDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper22VisitPragmaCommentDeclEPKN5clang17PragmaCommentDeclE")
  //</editor-fold>
  public void VisitPragmaCommentDecl(/*const*/ PragmaCommentDecl /*P*/ D) {
    OS.$out_char($$SPACE);
    switch (D.getCommentKind()) {
     case PCK_Unknown:
      throw new llvm_unreachable("unexpected pragma comment kind");
     case PCK_Compiler:
      OS.$out(/*KEEP_STR*/"compiler");
      break;
     case PCK_ExeStr:
      OS.$out(/*KEEP_STR*/"exestr");
      break;
     case PCK_Lib:
      OS.$out(/*KEEP_STR*/"lib");
      break;
     case PCK_Linker:
      OS.$out(/*KEEP_STR*/"linker");
      break;
     case PCK_User:
      OS.$out(/*KEEP_STR*/"user");
      break;
    }
    StringRef Arg = D.getArg();
    if (!Arg.empty()) {
      OS.$out(/*KEEP_STR*/" \"").$out(/*NO_COPY*/Arg).$out(/*KEEP_STR*/$DBL_QUOTE);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitPragmaDetectMismatchDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1243,
   FQN="(anonymous namespace)::ASTDumper::VisitPragmaDetectMismatchDecl", NM="_ZN12_GLOBAL__N_19ASTDumper29VisitPragmaDetectMismatchDeclEPKN5clang24PragmaDetectMismatchDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper29VisitPragmaDetectMismatchDeclEPKN5clang24PragmaDetectMismatchDeclE")
  //</editor-fold>
  public void VisitPragmaDetectMismatchDecl(/*const*/ PragmaDetectMismatchDecl /*P*/ D) {
    OS.$out(/*KEEP_STR*/" \"").$out(D.getName()).$out(/*KEEP_STR*/"\" \"").$out(D.getValue()).$out(/*KEEP_STR*/$DBL_QUOTE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitCapturedDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1248,
   FQN="(anonymous namespace)::ASTDumper::VisitCapturedDecl", NM="_ZN12_GLOBAL__N_19ASTDumper17VisitCapturedDeclEPKN5clang12CapturedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper17VisitCapturedDeclEPKN5clang12CapturedDeclE")
  //</editor-fold>
  public void VisitCapturedDecl(/*const*/ CapturedDecl /*P*/ D) {
    dumpStmt(D.getBody());
  }

  
  // OpenMP decls
  
  //===----------------------------------------------------------------------===//
  // OpenMP Declarations
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitOMPThreadPrivateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1256,
   FQN="(anonymous namespace)::ASTDumper::VisitOMPThreadPrivateDecl", NM="_ZN12_GLOBAL__N_19ASTDumper25VisitOMPThreadPrivateDeclEPKN5clang20OMPThreadPrivateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper25VisitOMPThreadPrivateDeclEPKN5clang20OMPThreadPrivateDeclE")
  //</editor-fold>
  public void VisitOMPThreadPrivateDecl(/*const*/ OMPThreadPrivateDecl /*P*/ D) {
    for (/*const*/ Expr /*P*/ E : D.varlists$Const())  {
      dumpStmt(E);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitOMPDeclareReductionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1261,
   FQN="(anonymous namespace)::ASTDumper::VisitOMPDeclareReductionDecl", NM="_ZN12_GLOBAL__N_19ASTDumper28VisitOMPDeclareReductionDeclEPKN5clang23OMPDeclareReductionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper28VisitOMPDeclareReductionDeclEPKN5clang23OMPDeclareReductionDeclE")
  //</editor-fold>
  public void VisitOMPDeclareReductionDecl(/*const*/ OMPDeclareReductionDecl /*P*/ D) {
    dumpName(D);
    dumpType(D.getType());
    OS.$out(/*KEEP_STR*/" combiner");
    dumpStmt(D.getCombiner$Const());
    {
      /*const*/ Expr /*P*/ Initializer = D.getInitializer$Const();
      if ((Initializer != null)) {
        OS.$out(/*KEEP_STR*/" initializer");
        dumpStmt(Initializer);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitOMPCapturedExprDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1272,
   FQN="(anonymous namespace)::ASTDumper::VisitOMPCapturedExprDecl", NM="_ZN12_GLOBAL__N_19ASTDumper24VisitOMPCapturedExprDeclEPKN5clang19OMPCapturedExprDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper24VisitOMPCapturedExprDeclEPKN5clang19OMPCapturedExprDeclE")
  //</editor-fold>
  public void VisitOMPCapturedExprDecl(/*const*/ OMPCapturedExprDecl /*P*/ D) {
    dumpName(D);
    dumpType(D.getType());
    dumpStmt(D.getInit$Const());
  }

  
  // C++ Decls
  
  //===----------------------------------------------------------------------===//
  // C++ Declarations
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitNamespaceDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1282,
   FQN="(anonymous namespace)::ASTDumper::VisitNamespaceDecl", NM="_ZN12_GLOBAL__N_19ASTDumper18VisitNamespaceDeclEPKN5clang13NamespaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper18VisitNamespaceDeclEPKN5clang13NamespaceDeclE")
  //</editor-fold>
  public void VisitNamespaceDecl(/*const*/ NamespaceDecl /*P*/ D) {
    dumpName(D);
    if (D.isInline()) {
      OS.$out(/*KEEP_STR*/" inline");
    }
    if (!D.isOriginalNamespace()) {
      dumpDeclRef(D.getOriginalNamespace$Const(), $("original"));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitUsingDirectiveDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1290,
   FQN="(anonymous namespace)::ASTDumper::VisitUsingDirectiveDecl", NM="_ZN12_GLOBAL__N_19ASTDumper23VisitUsingDirectiveDeclEPKN5clang18UsingDirectiveDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper23VisitUsingDirectiveDeclEPKN5clang18UsingDirectiveDeclE")
  //</editor-fold>
  public void VisitUsingDirectiveDecl(/*const*/ UsingDirectiveDecl /*P*/ D) {
    OS.$out_char($$SPACE);
    dumpBareDeclRef(D.getNominatedNamespace$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitNamespaceAliasDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1295,
   FQN="(anonymous namespace)::ASTDumper::VisitNamespaceAliasDecl", NM="_ZN12_GLOBAL__N_19ASTDumper23VisitNamespaceAliasDeclEPKN5clang18NamespaceAliasDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper23VisitNamespaceAliasDeclEPKN5clang18NamespaceAliasDeclE")
  //</editor-fold>
  public void VisitNamespaceAliasDecl(/*const*/ NamespaceAliasDecl /*P*/ D) {
    dumpName(D);
    dumpDeclRef(D.getAliasedNamespace());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitTypeAliasDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1300,
   FQN="(anonymous namespace)::ASTDumper::VisitTypeAliasDecl", NM="_ZN12_GLOBAL__N_19ASTDumper18VisitTypeAliasDeclEPKN5clang13TypeAliasDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper18VisitTypeAliasDeclEPKN5clang13TypeAliasDeclE")
  //</editor-fold>
  public void VisitTypeAliasDecl(/*const*/ TypeAliasDecl /*P*/ D) {
    dumpName(D);
    dumpType(D.getUnderlyingType());
    dumpTypeAsChild(D.getUnderlyingType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitTypeAliasTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1306,
   FQN="(anonymous namespace)::ASTDumper::VisitTypeAliasTemplateDecl", NM="_ZN12_GLOBAL__N_19ASTDumper26VisitTypeAliasTemplateDeclEPKN5clang21TypeAliasTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper26VisitTypeAliasTemplateDeclEPKN5clang21TypeAliasTemplateDeclE")
  //</editor-fold>
  public void VisitTypeAliasTemplateDecl(/*const*/ TypeAliasTemplateDecl /*P*/ D) {
    dumpName(D);
    dumpTemplateParameters(D.getTemplateParameters());
    dumpDecl(D.getTemplatedDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitCXXRecordDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1312,
   FQN="(anonymous namespace)::ASTDumper::VisitCXXRecordDecl", NM="_ZN12_GLOBAL__N_19ASTDumper18VisitCXXRecordDeclEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper18VisitCXXRecordDeclEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  public void VisitCXXRecordDecl(/*const*/ CXXRecordDecl /*P*/ D) {
    VisitRecordDecl(D);
    if (!D.isCompleteDefinition()) {
      return;
    }
    
    for (final /*const*/ CXXBaseSpecifier /*&*/ I : D.bases$Const()) {
      CXXBaseSpecifier L$I = I;
      dumpChild(/*[=, =L$I(I), this]*/() -> {
                if (L$I.isVirtual()) {
                  OS.$out(/*KEEP_STR*/"virtual ");
                }
                dumpAccessSpecifier(L$I.getAccessSpecifier());
                dumpType(L$I.getType());
                if (L$I.isPackExpansion()) {
                  OS.$out(/*KEEP_STR*/$ELLIPSIS);
                }
              });
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitStaticAssertDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1329,
   FQN="(anonymous namespace)::ASTDumper::VisitStaticAssertDecl", NM="_ZN12_GLOBAL__N_19ASTDumper21VisitStaticAssertDeclEPKN5clang16StaticAssertDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper21VisitStaticAssertDeclEPKN5clang16StaticAssertDeclE")
  //</editor-fold>
  public void VisitStaticAssertDecl(/*const*/ StaticAssertDecl /*P*/ D) {
    dumpStmt(D.getAssertExpr$Const());
    dumpStmt(D.getMessage$Const());
  }

  //</*typename*/ SpecializationDecl/* = FunctionDecl*/> 
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitTemplateDeclSpecialization">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1335,
   FQN="(anonymous namespace)::ASTDumper::VisitTemplateDeclSpecialization", NM="_ZN12_GLOBAL__N_19ASTDumper31VisitTemplateDeclSpecializationIN5clang12FunctionDeclEEEvPKT_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper31VisitTemplateDeclSpecializationIN5clang12FunctionDeclEEEvPKT_bb")
  //</editor-fold>
  public void VisitTemplateDeclSpecialization(/*const*/ FunctionDecl /*P*/ D, 
                                 boolean DumpExplicitInst, 
                                 boolean DumpRefOnly) {
    boolean DumpedAny = false;
    for (FunctionDecl /*P*/ RedeclWithBadType : D.redeclarable_redecls()) {
      // FIXME: The redecls() range sometimes has elements of a less-specific
      // type. (In particular, ClassTemplateSpecializationDecl::redecls() gives
      // us TagDecls, and should give CXXRecordDecls).
      FunctionDecl /*P*/ Redecl = dyn_cast_FunctionDecl(RedeclWithBadType);
      if (!(Redecl != null)) {
        // Found the injected-class-name for a class template. This will be dumped
        // as part of its surrounding class so we don't need to dump it here.
        assert (isa_CXXRecordDecl(RedeclWithBadType)) : "expected an injected-class-name";
        continue;
      }
      switch (Redecl.getTemplateSpecializationKind()) {
       case TSK_ExplicitInstantiationDeclaration:
       case TSK_ExplicitInstantiationDefinition:
        if (!DumpExplicitInst) {
          break;
        }
       case TSK_Undeclared:
       case TSK_ImplicitInstantiation:
        // Fall through.
        if (DumpRefOnly) {
          dumpDeclRef(Redecl);
        } else {
          dumpDecl(Redecl);
        }
        DumpedAny = true;
        break;
       case TSK_ExplicitSpecialization:
        break;
      }
    }

    // Ensure we dump at least one decl for each specialization.
    if (!DumpedAny) {
      dumpDeclRef(D);
    }
  }
    //</*typename*/ SpecializationDecl/* = ClassTemplateSpecializationDecl*/> 
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitTemplateDeclSpecialization">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1335,
   FQN="(anonymous namespace)::ASTDumper::VisitTemplateDeclSpecialization", NM="_ZN12_GLOBAL__N_19ASTDumper31VisitTemplateDeclSpecializationIN5clang31ClassTemplateSpecializationDeclEEEvPKT_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper31VisitTemplateDeclSpecializationIN5clang31ClassTemplateSpecializationDeclEEEvPKT_bb")
  //</editor-fold>
  public void VisitTemplateDeclSpecialization(/*const*/ ClassTemplateSpecializationDecl /*P*/ D, 
                                 boolean DumpExplicitInst, 
                                 boolean DumpRefOnly) {
    boolean DumpedAny = false;
    for (TagDecl /*P*/ RedeclWithBadType : D.redeclarable_redecls()) {
      ClassTemplateSpecializationDecl /*P*/ Redecl = dyn_cast_ClassTemplateSpecializationDecl(RedeclWithBadType);
      if (!(Redecl != null)) {
        assert (isa_CXXRecordDecl(RedeclWithBadType)) : "expected an injected-class-name";
        continue;
      }
      switch (Redecl.getTemplateSpecializationKind()) {
       case TSK_ExplicitInstantiationDeclaration:
       case TSK_ExplicitInstantiationDefinition:
        if (!DumpExplicitInst) {
          break;
        }
       case TSK_Undeclared:
       case TSK_ImplicitInstantiation:
        if (DumpRefOnly) {
          dumpDeclRef(Redecl);
        } else {
          dumpDecl(Redecl);
        }
        DumpedAny = true;
        break;
       case TSK_ExplicitSpecialization:
        break;
      }
    }
    if (!DumpedAny) {
      dumpDeclRef(D);
    }
  }
    //</*typename*/ SpecializationDecl/* = VarTemplateSpecializationDecl*/> 
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitTemplateDeclSpecialization">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1335,
   FQN="(anonymous namespace)::ASTDumper::VisitTemplateDeclSpecialization", NM="_ZN12_GLOBAL__N_19ASTDumper31VisitTemplateDeclSpecializationIN5clang29VarTemplateSpecializationDeclEEEvPKT_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper31VisitTemplateDeclSpecializationIN5clang29VarTemplateSpecializationDeclEEEvPKT_bb")
  //</editor-fold>
  public void VisitTemplateDeclSpecialization(/*const*/ VarTemplateSpecializationDecl /*P*/ D, 
                                 boolean DumpExplicitInst, 
                                 boolean DumpRefOnly) {
    boolean DumpedAny = false;
    for (VarDecl /*P*/ RedeclWithBadType : D.redeclarable_redecls()) {
      VarTemplateSpecializationDecl /*P*/ Redecl = dyn_cast_VarTemplateSpecializationDecl(RedeclWithBadType);
      if (!(Redecl != null)) {
        assert (isa_CXXRecordDecl(RedeclWithBadType)) : "expected an injected-class-name";
        continue;
      }
      switch (Redecl.getTemplateSpecializationKind()) {
       case TSK_ExplicitInstantiationDeclaration:
       case TSK_ExplicitInstantiationDefinition:
        if (!DumpExplicitInst) {
          break;
        }
       case TSK_Undeclared:
       case TSK_ImplicitInstantiation:
        if (DumpRefOnly) {
          dumpDeclRef(Redecl);
        } else {
          dumpDecl(Redecl);
        }
        DumpedAny = true;
        break;
       case TSK_ExplicitSpecialization:
        break;
      }
    }
    if (!DumpedAny) {
      dumpDeclRef(D);
    }
  }

  //</*typename*/ TemplateDecl/* = FunctionTemplateDecl*/> 
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitTemplateDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1377,
   FQN="(anonymous namespace)::ASTDumper::VisitTemplateDecl", NM="_ZN12_GLOBAL__N_19ASTDumper17VisitTemplateDeclIN5clang20FunctionTemplateDeclEEEvPKT_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper17VisitTemplateDeclIN5clang20FunctionTemplateDeclEEEvPKT_b")
  //</editor-fold>
  public void VisitTemplateDecl(/*const*/ FunctionTemplateDecl /*P*/ D, 
                   boolean DumpExplicitInst) {
    dumpName(D);
    dumpTemplateParameters(D.getTemplateParameters());

    dumpDecl(D.getTemplatedDecl());

    for (FunctionDecl /*P*/ Child : D.specializations())  {
      VisitTemplateDeclSpecialization(Child, DumpExplicitInst, 
          !D.isCanonicalDecl());
    }
  }
  //</*typename*/ TemplateDecl/* = ClassTemplateDecl*/>
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitTemplateDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1377,
   FQN="(anonymous namespace)::ASTDumper::VisitTemplateDecl", NM="_ZN12_GLOBAL__N_19ASTDumper17VisitTemplateDeclIN5clang17ClassTemplateDeclEEEvPKT_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper17VisitTemplateDeclIN5clang17ClassTemplateDeclEEEvPKT_b")
  //</editor-fold>
  public void VisitTemplateDecl(/*const*/ ClassTemplateDecl /*P*/ D, 
                   boolean DumpExplicitInst) {
    dumpName(D);
    dumpTemplateParameters(D.getTemplateParameters());

    dumpDecl(D.getTemplatedDecl());

    for (ClassTemplateSpecializationDecl /*P*/ Child : D.specializations())  {
      VisitTemplateDeclSpecialization(Child, DumpExplicitInst, 
          !D.isCanonicalDecl());
    }
  }
  //</*typename*/ TemplateDecl/* = VarTemplateDecl*/>
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitTemplateDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1377,
   FQN="(anonymous namespace)::ASTDumper::VisitTemplateDecl", NM="_ZN12_GLOBAL__N_19ASTDumper17VisitTemplateDeclIN5clang15VarTemplateDeclEEEvPKT_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper17VisitTemplateDeclIN5clang15VarTemplateDeclEEEvPKT_b")
  //</editor-fold>
  public void VisitTemplateDecl(/*const*/ VarTemplateDecl /*P*/ D, 
                   boolean DumpExplicitInst) {
    dumpName(D);
    dumpTemplateParameters(D.getTemplateParameters());

    dumpDecl(D.getTemplatedDecl());

    for (VarTemplateSpecializationDecl /*P*/ Child : D.specializations())  {
      VisitTemplateDeclSpecialization(Child, DumpExplicitInst, 
          !D.isCanonicalDecl());
    }
  }
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitFunctionTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1389,
   FQN="(anonymous namespace)::ASTDumper::VisitFunctionTemplateDecl", NM="_ZN12_GLOBAL__N_19ASTDumper25VisitFunctionTemplateDeclEPKN5clang20FunctionTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper25VisitFunctionTemplateDeclEPKN5clang20FunctionTemplateDeclE")
  //</editor-fold>
  public void VisitFunctionTemplateDecl(/*const*/ FunctionTemplateDecl /*P*/ D) {
    // FIXME: We don't add a declaration of a function template specialization
    // to its context when it's explicitly instantiated, so dump explicit
    // instantiations when we dump the template itself.
    VisitTemplateDecl(D, true);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitClassTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1396,
   FQN="(anonymous namespace)::ASTDumper::VisitClassTemplateDecl", NM="_ZN12_GLOBAL__N_19ASTDumper22VisitClassTemplateDeclEPKN5clang17ClassTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper22VisitClassTemplateDeclEPKN5clang17ClassTemplateDeclE")
  //</editor-fold>
  public void VisitClassTemplateDecl(/*const*/ ClassTemplateDecl /*P*/ D) {
    VisitTemplateDecl(D, false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitClassTemplateSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1400,
   FQN="(anonymous namespace)::ASTDumper::VisitClassTemplateSpecializationDecl", NM="_ZN12_GLOBAL__N_19ASTDumper36VisitClassTemplateSpecializationDeclEPKN5clang31ClassTemplateSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper36VisitClassTemplateSpecializationDeclEPKN5clang31ClassTemplateSpecializationDeclE")
  //</editor-fold>
  public void VisitClassTemplateSpecializationDecl(/*const*/ ClassTemplateSpecializationDecl /*P*/ D) {
    VisitCXXRecordDecl(D);
    dumpTemplateArgumentList(D.getTemplateArgs());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitClassTemplatePartialSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1406,
   FQN="(anonymous namespace)::ASTDumper::VisitClassTemplatePartialSpecializationDecl", NM="_ZN12_GLOBAL__N_19ASTDumper43VisitClassTemplatePartialSpecializationDeclEPKN5clang38ClassTemplatePartialSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper43VisitClassTemplatePartialSpecializationDeclEPKN5clang38ClassTemplatePartialSpecializationDeclE")
  //</editor-fold>
  public void VisitClassTemplatePartialSpecializationDecl(/*const*/ ClassTemplatePartialSpecializationDecl /*P*/ D) {
    VisitClassTemplateSpecializationDecl(D);
    dumpTemplateParameters(D.getTemplateParameters());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitClassScopeFunctionSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1412,
   FQN="(anonymous namespace)::ASTDumper::VisitClassScopeFunctionSpecializationDecl", NM="_ZN12_GLOBAL__N_19ASTDumper41VisitClassScopeFunctionSpecializationDeclEPKN5clang36ClassScopeFunctionSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper41VisitClassScopeFunctionSpecializationDeclEPKN5clang36ClassScopeFunctionSpecializationDeclE")
  //</editor-fold>
  public void VisitClassScopeFunctionSpecializationDecl(/*const*/ ClassScopeFunctionSpecializationDecl /*P*/ D) {
    dumpDeclRef(D.getSpecialization());
    if (D.hasExplicitTemplateArgs()) {
      dumpTemplateArgumentListInfo(D.templateArgs());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitBuiltinTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1423,
   FQN="(anonymous namespace)::ASTDumper::VisitBuiltinTemplateDecl", NM="_ZN12_GLOBAL__N_19ASTDumper24VisitBuiltinTemplateDeclEPKN5clang19BuiltinTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper24VisitBuiltinTemplateDeclEPKN5clang19BuiltinTemplateDeclE")
  //</editor-fold>
  public void VisitBuiltinTemplateDecl(/*const*/ BuiltinTemplateDecl /*P*/ D) {
    dumpName(D);
    dumpTemplateParameters(D.getTemplateParameters());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitVarTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1419,
   FQN="(anonymous namespace)::ASTDumper::VisitVarTemplateDecl", NM="_ZN12_GLOBAL__N_19ASTDumper20VisitVarTemplateDeclEPKN5clang15VarTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper20VisitVarTemplateDeclEPKN5clang15VarTemplateDeclE")
  //</editor-fold>
  public void VisitVarTemplateDecl(/*const*/ VarTemplateDecl /*P*/ D) {
    VisitTemplateDecl(D, false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitVarTemplateSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1428,
   FQN="(anonymous namespace)::ASTDumper::VisitVarTemplateSpecializationDecl", NM="_ZN12_GLOBAL__N_19ASTDumper34VisitVarTemplateSpecializationDeclEPKN5clang29VarTemplateSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper34VisitVarTemplateSpecializationDeclEPKN5clang29VarTemplateSpecializationDeclE")
  //</editor-fold>
  public void VisitVarTemplateSpecializationDecl(/*const*/ VarTemplateSpecializationDecl /*P*/ D) {
    dumpTemplateArgumentList(D.getTemplateArgs());
    VisitVarDecl(D);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitVarTemplatePartialSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1434,
   FQN="(anonymous namespace)::ASTDumper::VisitVarTemplatePartialSpecializationDecl", NM="_ZN12_GLOBAL__N_19ASTDumper41VisitVarTemplatePartialSpecializationDeclEPKN5clang36VarTemplatePartialSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper41VisitVarTemplatePartialSpecializationDeclEPKN5clang36VarTemplatePartialSpecializationDeclE")
  //</editor-fold>
  public void VisitVarTemplatePartialSpecializationDecl(/*const*/ VarTemplatePartialSpecializationDecl /*P*/ D) {
    dumpTemplateParameters(D.getTemplateParameters());
    VisitVarTemplateSpecializationDecl(D);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitTemplateTypeParmDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1440,
   FQN="(anonymous namespace)::ASTDumper::VisitTemplateTypeParmDecl", NM="_ZN12_GLOBAL__N_19ASTDumper25VisitTemplateTypeParmDeclEPKN5clang20TemplateTypeParmDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper25VisitTemplateTypeParmDeclEPKN5clang20TemplateTypeParmDeclE")
  //</editor-fold>
  public void VisitTemplateTypeParmDecl(/*const*/ TemplateTypeParmDecl /*P*/ D) {
    if (D.wasDeclaredWithTypename()) {
      OS.$out(/*KEEP_STR*/" typename");
    } else {
      OS.$out(/*KEEP_STR*/" class");
    }
    if (D.isParameterPack()) {
      OS.$out(/*KEEP_STR*/" ...");
    }
    dumpName(D);
    if (D.hasDefaultArgument()) {
      dumpTemplateArgument(new TemplateArgument(D.getDefaultArgument()));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitNonTypeTemplateParmDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1452,
   FQN="(anonymous namespace)::ASTDumper::VisitNonTypeTemplateParmDecl", NM="_ZN12_GLOBAL__N_19ASTDumper28VisitNonTypeTemplateParmDeclEPKN5clang23NonTypeTemplateParmDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper28VisitNonTypeTemplateParmDeclEPKN5clang23NonTypeTemplateParmDeclE")
  //</editor-fold>
  public void VisitNonTypeTemplateParmDecl(/*const*/ NonTypeTemplateParmDecl /*P*/ D) {
    dumpType(D.getType());
    if (D.isParameterPack()) {
      OS.$out(/*KEEP_STR*/" ...");
    }
    dumpName(D);
    if (D.hasDefaultArgument()) {
      dumpTemplateArgument(new TemplateArgument(D.getDefaultArgument()));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitTemplateTemplateParmDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1461,
   FQN="(anonymous namespace)::ASTDumper::VisitTemplateTemplateParmDecl", NM="_ZN12_GLOBAL__N_19ASTDumper29VisitTemplateTemplateParmDeclEPKN5clang24TemplateTemplateParmDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper29VisitTemplateTemplateParmDeclEPKN5clang24TemplateTemplateParmDeclE")
  //</editor-fold>
  public void VisitTemplateTemplateParmDecl(/*const*/ TemplateTemplateParmDecl /*P*/ D) {
    if (D.isParameterPack()) {
      OS.$out(/*KEEP_STR*/" ...");
    }
    dumpName(D);
    dumpTemplateParameters(D.getTemplateParameters());
    if (D.hasDefaultArgument()) {
      dumpTemplateArgumentLoc(D.getDefaultArgument());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitUsingDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1471,
   FQN="(anonymous namespace)::ASTDumper::VisitUsingDecl", NM="_ZN12_GLOBAL__N_19ASTDumper14VisitUsingDeclEPKN5clang9UsingDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper14VisitUsingDeclEPKN5clang9UsingDeclE")
  //</editor-fold>
  public void VisitUsingDecl(/*const*/ UsingDecl /*P*/ D) {
    OS.$out_char($$SPACE);
    if ((D.getQualifier() != null)) {
      D.getQualifier().print(OS, D.getASTContext().getPrintingPolicy());
    }
    OS.$out(D.getNameAsString());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitUnresolvedUsingTypenameDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1478,
   FQN="(anonymous namespace)::ASTDumper::VisitUnresolvedUsingTypenameDecl", NM="_ZN12_GLOBAL__N_19ASTDumper32VisitUnresolvedUsingTypenameDeclEPKN5clang27UnresolvedUsingTypenameDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper32VisitUnresolvedUsingTypenameDeclEPKN5clang27UnresolvedUsingTypenameDeclE")
  //</editor-fold>
  public void VisitUnresolvedUsingTypenameDecl(/*const*/ UnresolvedUsingTypenameDecl /*P*/ D) {
    OS.$out_char($$SPACE);
    if ((D.getQualifier() != null)) {
      D.getQualifier().print(OS, D.getASTContext().getPrintingPolicy());
    }
    OS.$out(D.getNameAsString());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitUnresolvedUsingValueDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1486,
   FQN="(anonymous namespace)::ASTDumper::VisitUnresolvedUsingValueDecl", NM="_ZN12_GLOBAL__N_19ASTDumper29VisitUnresolvedUsingValueDeclEPKN5clang24UnresolvedUsingValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper29VisitUnresolvedUsingValueDeclEPKN5clang24UnresolvedUsingValueDeclE")
  //</editor-fold>
  public void VisitUnresolvedUsingValueDecl(/*const*/ UnresolvedUsingValueDecl /*P*/ D) {
    OS.$out_char($$SPACE);
    if ((D.getQualifier() != null)) {
      D.getQualifier().print(OS, D.getASTContext().getPrintingPolicy());
    }
    OS.$out(D.getNameAsString());
    dumpType(D.getType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitUsingShadowDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1494,
   FQN="(anonymous namespace)::ASTDumper::VisitUsingShadowDecl", NM="_ZN12_GLOBAL__N_19ASTDumper20VisitUsingShadowDeclEPKN5clang15UsingShadowDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper20VisitUsingShadowDeclEPKN5clang15UsingShadowDeclE")
  //</editor-fold>
  public void VisitUsingShadowDecl(/*const*/ UsingShadowDecl /*P*/ D) {
    OS.$out_char($$SPACE);
    dumpBareDeclRef(D.getTargetDecl());
    {
      /*const*/ TypeDecl /*P*/ TD = dyn_cast_TypeDecl(D.getUnderlyingDecl$Const());
      if ((TD != null)) {
        dumpTypeAsChild(TD.getTypeForDecl());
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitConstructorUsingShadowDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1501,
   FQN="(anonymous namespace)::ASTDumper::VisitConstructorUsingShadowDecl", NM="_ZN12_GLOBAL__N_19ASTDumper31VisitConstructorUsingShadowDeclEPKN5clang26ConstructorUsingShadowDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper31VisitConstructorUsingShadowDeclEPKN5clang26ConstructorUsingShadowDeclE")
  //</editor-fold>
  public void VisitConstructorUsingShadowDecl(/*const*/ ConstructorUsingShadowDecl /*P*/ D) {
    if (D.constructsVirtualBase()) {
      OS.$out(/*KEEP_STR*/" virtual");
    }
    ConstructorUsingShadowDecl L$D = D;
    dumpChild(/*[=, this, =L$D(D)]*/() -> {
              OS.$out(/*KEEP_STR*/"target ");
              dumpBareDeclRef(L$D.getTargetDecl());
            });
    
    dumpChild(/*[=, this, =L$D(D)]*/() -> {
              OS.$out(/*KEEP_STR*/"nominated ");
              dumpBareDeclRef(L$D.getNominatedBaseClass());
              OS.$out_char($$SPACE);
              dumpBareDeclRef(L$D.getNominatedBaseClassShadowDecl());
            });
    
    dumpChild(/*[=, this, =L$D(D)]*/() -> {
              OS.$out(/*KEEP_STR*/"constructed ");
              dumpBareDeclRef(L$D.getConstructedBaseClass());
              OS.$out_char($$SPACE);
              dumpBareDeclRef(L$D.getConstructedBaseClassShadowDecl());
            });
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitLinkageSpecDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1526,
   FQN="(anonymous namespace)::ASTDumper::VisitLinkageSpecDecl", NM="_ZN12_GLOBAL__N_19ASTDumper20VisitLinkageSpecDeclEPKN5clang15LinkageSpecDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper20VisitLinkageSpecDeclEPKN5clang15LinkageSpecDeclE")
  //</editor-fold>
  public void VisitLinkageSpecDecl(/*const*/ LinkageSpecDecl /*P*/ D) {
    switch (D.getLanguage()) {
     case LinkageSpecDecl.LanguageIDs.lang_c:
      OS.$out(/*KEEP_STR*/" C");
      break;
     case LinkageSpecDecl.LanguageIDs.lang_cxx:
      OS.$out(/*KEEP_STR*/" C++");
      break;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitAccessSpecDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1533,
   FQN="(anonymous namespace)::ASTDumper::VisitAccessSpecDecl", NM="_ZN12_GLOBAL__N_19ASTDumper19VisitAccessSpecDeclEPKN5clang14AccessSpecDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper19VisitAccessSpecDeclEPKN5clang14AccessSpecDeclE")
  //</editor-fold>
  public void VisitAccessSpecDecl(/*const*/ AccessSpecDecl /*P*/ D) {
    OS.$out_char($$SPACE);
    dumpAccessSpecifier(D.getAccess());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitFriendDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1538,
   FQN="(anonymous namespace)::ASTDumper::VisitFriendDecl", NM="_ZN12_GLOBAL__N_19ASTDumper15VisitFriendDeclEPKN5clang10FriendDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper15VisitFriendDeclEPKN5clang10FriendDeclE")
  //</editor-fold>
  public void VisitFriendDecl(/*const*/ FriendDecl /*P*/ D) {
    {
      TypeSourceInfo /*P*/ T = D.getFriendType();
      if ((T != null)) {
        dumpType(T.getType());
      } else {
        dumpDecl(D.getFriendDecl());
      }
    }
  }

  
  // ObjC Decls
  
  //===----------------------------------------------------------------------===//
  // Obj-C Declarations
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitObjCIvarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1549,
   FQN="(anonymous namespace)::ASTDumper::VisitObjCIvarDecl", NM="_ZN12_GLOBAL__N_19ASTDumper17VisitObjCIvarDeclEPKN5clang12ObjCIvarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper17VisitObjCIvarDeclEPKN5clang12ObjCIvarDeclE")
  //</editor-fold>
  public void VisitObjCIvarDecl(/*const*/ ObjCIvarDecl /*P*/ D) {
    dumpName(D);
    dumpType(D.getType());
    if (D.getSynthesize()) {
      OS.$out(/*KEEP_STR*/" synthesize");
    }
    switch (D.getAccessControl()) {
     case None:
      OS.$out(/*KEEP_STR*/" none");
      break;
     case Private:
      OS.$out(/*KEEP_STR*/" private");
      break;
     case Protected:
      OS.$out(/*KEEP_STR*/" protected");
      break;
     case Public:
      OS.$out(/*KEEP_STR*/" public");
      break;
     case Package:
      OS.$out(/*KEEP_STR*/" package");
      break;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitObjCMethodDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1574,
   FQN="(anonymous namespace)::ASTDumper::VisitObjCMethodDecl", NM="_ZN12_GLOBAL__N_19ASTDumper19VisitObjCMethodDeclEPKN5clang14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper19VisitObjCMethodDeclEPKN5clang14ObjCMethodDeclE")
  //</editor-fold>
  public void VisitObjCMethodDecl(/*const*/ ObjCMethodDecl /*P*/ D) {
    if (D.isInstanceMethod()) {
      OS.$out(/*KEEP_STR*/" -");
    } else {
      OS.$out(/*KEEP_STR*/" +");
    }
    dumpName(D);
    dumpType(D.getReturnType());
    if (D.isThisDeclarationADefinition()) {
      dumpDeclContext(D);
    } else {
      for (/*const*/ ParmVarDecl /*P*/ Parameter : D.parameters())  {
        dumpDecl(Parameter);
      }
    }
    if (D.isVariadic()) {
      dumpChild(/*[=, this]*/() -> {
                OS.$out(/*KEEP_STR*/$ELLIPSIS);
              });
    }
    if (D.hasBody()) {
      dumpStmt(D.getBody());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitObjCTypeParamDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1596,
   FQN="(anonymous namespace)::ASTDumper::VisitObjCTypeParamDecl", NM="_ZN12_GLOBAL__N_19ASTDumper22VisitObjCTypeParamDeclEPKN5clang17ObjCTypeParamDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper22VisitObjCTypeParamDeclEPKN5clang17ObjCTypeParamDeclE")
  //</editor-fold>
  public void VisitObjCTypeParamDecl(/*const*/ ObjCTypeParamDecl /*P*/ D) {
    dumpName(D);
    switch (D.getVariance()) {
     case Invariant:
      break;
     case Covariant:
      OS.$out(/*KEEP_STR*/" covariant");
      break;
     case Contravariant:
      OS.$out(/*KEEP_STR*/" contravariant");
      break;
    }
    if (D.hasExplicitBound()) {
      OS.$out(/*KEEP_STR*/" bounded");
    }
    dumpType(D.getUnderlyingType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitObjCCategoryDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1616,
   FQN="(anonymous namespace)::ASTDumper::VisitObjCCategoryDecl", NM="_ZN12_GLOBAL__N_19ASTDumper21VisitObjCCategoryDeclEPKN5clang16ObjCCategoryDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper21VisitObjCCategoryDeclEPKN5clang16ObjCCategoryDeclE")
  //</editor-fold>
  public void VisitObjCCategoryDecl(/*const*/ ObjCCategoryDecl /*P*/ D) {
    dumpName(D);
    dumpDeclRef(D.getClassInterface$Const());
    dumpObjCTypeParamList(D.getTypeParamList());
    dumpDeclRef(D.getImplementation());
    for (type$ptr<ObjCProtocolDecl /*P*/ /*const*/ /*P*/> I = $tryClone(D.protocol_begin()), 
        /*P*/ /*const*/ /*P*/ E = $tryClone(D.protocol_end());
         $noteq_ptr(I, E); I.$preInc())  {
      dumpDeclRef(I.$star());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitObjCCategoryImplDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1627,
   FQN="(anonymous namespace)::ASTDumper::VisitObjCCategoryImplDecl", NM="_ZN12_GLOBAL__N_19ASTDumper25VisitObjCCategoryImplDeclEPKN5clang20ObjCCategoryImplDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper25VisitObjCCategoryImplDeclEPKN5clang20ObjCCategoryImplDeclE")
  //</editor-fold>
  public void VisitObjCCategoryImplDecl(/*const*/ ObjCCategoryImplDecl /*P*/ D) {
    dumpName(D);
    dumpDeclRef(D.getClassInterface$Const());
    dumpDeclRef(D.getCategoryDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitObjCProtocolDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1633,
   FQN="(anonymous namespace)::ASTDumper::VisitObjCProtocolDecl", NM="_ZN12_GLOBAL__N_19ASTDumper21VisitObjCProtocolDeclEPKN5clang16ObjCProtocolDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper21VisitObjCProtocolDeclEPKN5clang16ObjCProtocolDeclE")
  //</editor-fold>
  public void VisitObjCProtocolDecl(/*const*/ ObjCProtocolDecl /*P*/ D) {
    dumpName(D);
    
    for (ObjCProtocolDecl /*P*/ Child : D.protocols())  {
      dumpDeclRef(Child);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitObjCInterfaceDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1640,
   FQN="(anonymous namespace)::ASTDumper::VisitObjCInterfaceDecl", NM="_ZN12_GLOBAL__N_19ASTDumper22VisitObjCInterfaceDeclEPKN5clang17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper22VisitObjCInterfaceDeclEPKN5clang17ObjCInterfaceDeclE")
  //</editor-fold>
  public void VisitObjCInterfaceDecl(/*const*/ ObjCInterfaceDecl /*P*/ D) {
    dumpName(D);
    dumpObjCTypeParamList(D.getTypeParamListAsWritten());
    dumpDeclRef(D.getSuperClass(), $("super"));
    
    dumpDeclRef(D.getImplementation());
    for (ObjCProtocolDecl /*P*/ Child : D.protocols())  {
      dumpDeclRef(Child);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitObjCImplementationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1650,
   FQN="(anonymous namespace)::ASTDumper::VisitObjCImplementationDecl", NM="_ZN12_GLOBAL__N_19ASTDumper27VisitObjCImplementationDeclEPKN5clang22ObjCImplementationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper27VisitObjCImplementationDeclEPKN5clang22ObjCImplementationDeclE")
  //</editor-fold>
  public void VisitObjCImplementationDecl(/*const*/ ObjCImplementationDecl /*P*/ D) {
    dumpName(D);
    dumpDeclRef(D.getSuperClass$Const(), $("super"));
    dumpDeclRef(D.getClassInterface$Const());
    for (type$ptr<CXXCtorInitializer/*P*/>/*iterator*/ I = $tryClone(D.init_begin$Const()), 
        /*P*/ /*const*/ /*P*/ E = $tryClone(D.init_end$Const());
         $noteq_ptr(I, E); I.$preInc())  {
      dumpCXXCtorInitializer(I.$star());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitObjCCompatibleAliasDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1660,
   FQN="(anonymous namespace)::ASTDumper::VisitObjCCompatibleAliasDecl", NM="_ZN12_GLOBAL__N_19ASTDumper28VisitObjCCompatibleAliasDeclEPKN5clang23ObjCCompatibleAliasDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper28VisitObjCCompatibleAliasDeclEPKN5clang23ObjCCompatibleAliasDeclE")
  //</editor-fold>
  public void VisitObjCCompatibleAliasDecl(/*const*/ ObjCCompatibleAliasDecl /*P*/ D) {
    dumpName(D);
    dumpDeclRef(D.getClassInterface$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitObjCPropertyDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1665,
   FQN="(anonymous namespace)::ASTDumper::VisitObjCPropertyDecl", NM="_ZN12_GLOBAL__N_19ASTDumper21VisitObjCPropertyDeclEPKN5clang16ObjCPropertyDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper21VisitObjCPropertyDeclEPKN5clang16ObjCPropertyDeclE")
  //</editor-fold>
  public void VisitObjCPropertyDecl(/*const*/ ObjCPropertyDecl /*P*/ D) {
    dumpName(D);
    dumpType(D.getType());
    if (D.getPropertyImplementation() == ObjCPropertyDecl.PropertyControl.Required) {
      OS.$out(/*KEEP_STR*/" required");
    } else if (D.getPropertyImplementation() == ObjCPropertyDecl.PropertyControl.Optional) {
      OS.$out(/*KEEP_STR*/" optional");
    }
    
    /*ObjCPropertyDecl::PropertyAttributeKind*//*uint*/int Attrs = D.getPropertyAttributes();
    if (Attrs != ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_noattr) {
      if (((Attrs & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_readonly) != 0)) {
        OS.$out(/*KEEP_STR*/" readonly");
      }
      if (((Attrs & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_assign) != 0)) {
        OS.$out(/*KEEP_STR*/" assign");
      }
      if (((Attrs & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_readwrite) != 0)) {
        OS.$out(/*KEEP_STR*/" readwrite");
      }
      if (((Attrs & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_retain) != 0)) {
        OS.$out(/*KEEP_STR*/" retain");
      }
      if (((Attrs & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_copy) != 0)) {
        OS.$out(/*KEEP_STR*/" copy");
      }
      if (((Attrs & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_nonatomic) != 0)) {
        OS.$out(/*KEEP_STR*/" nonatomic");
      }
      if (((Attrs & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_atomic) != 0)) {
        OS.$out(/*KEEP_STR*/" atomic");
      }
      if (((Attrs & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_weak) != 0)) {
        OS.$out(/*KEEP_STR*/" weak");
      }
      if (((Attrs & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_strong) != 0)) {
        OS.$out(/*KEEP_STR*/" strong");
      }
      if (((Attrs & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_unsafe_unretained) != 0)) {
        OS.$out(/*KEEP_STR*/" unsafe_unretained");
      }
      if (((Attrs & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_class) != 0)) {
        OS.$out(/*KEEP_STR*/" class");
      }
      if (((Attrs & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_getter) != 0)) {
        dumpDeclRef(D.getGetterMethodDecl(), $("getter"));
      }
      if (((Attrs & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_setter) != 0)) {
        dumpDeclRef(D.getSetterMethodDecl(), $("setter"));
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitObjCPropertyImplDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1705,
   FQN="(anonymous namespace)::ASTDumper::VisitObjCPropertyImplDecl", NM="_ZN12_GLOBAL__N_19ASTDumper25VisitObjCPropertyImplDeclEPKN5clang20ObjCPropertyImplDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper25VisitObjCPropertyImplDeclEPKN5clang20ObjCPropertyImplDeclE")
  //</editor-fold>
  public void VisitObjCPropertyImplDecl(/*const*/ ObjCPropertyImplDecl /*P*/ D) {
    dumpName(D.getPropertyDecl());
    if (D.getPropertyImplementation() == ObjCPropertyImplDecl.Kind.Synthesize) {
      OS.$out(/*KEEP_STR*/" synthesize");
    } else {
      OS.$out(/*KEEP_STR*/" dynamic");
    }
    dumpDeclRef(D.getPropertyDecl());
    dumpDeclRef(D.getPropertyIvarDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitBlockDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1715,
   FQN="(anonymous namespace)::ASTDumper::VisitBlockDecl", NM="_ZN12_GLOBAL__N_19ASTDumper14VisitBlockDeclEPKN5clang9BlockDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper14VisitBlockDeclEPKN5clang9BlockDeclE")
  //</editor-fold>
  public void VisitBlockDecl(/*const*/ BlockDecl /*P*/ D) {
    for (ParmVarDecl /*P*/ I : D.parameters$Const())  {
      dumpDecl(I);
    }
    if (D.isVariadic()) {
      dumpChild(/*[=, this]*/() -> {
                OS.$out(/*KEEP_STR*/$ELLIPSIS);
              });
    }
    if (D.capturesCXXThis()) {
      dumpChild(/*[=, this]*/() -> {
                OS.$out(/*KEEP_STR*/"capture this");
              });
    }
    
    for (final /*const*/ BlockDecl.Capture /*&*/ I : D.captures()) {
      BlockDecl.Capture L$I = I;
      dumpChild(/*[=, this, =L$I(I)]*/() -> {
                OS.$out(/*KEEP_STR*/"capture");
                if (L$I.isByRef()) {
                  OS.$out(/*KEEP_STR*/" byref");
                }
                if (L$I.isNested()) {
                  OS.$out(/*KEEP_STR*/" nested");
                }
                if ((L$I.getVariable() != null)) {
                  OS.$out_char($$SPACE);
                  dumpBareDeclRef(L$I.getVariable());
                }
                if (L$I.hasCopyExpr()) {
                  dumpStmt(L$I.getCopyExpr());
                }
              });
    }
    dumpStmt(D.getBody());
  }

  
  // Stmts.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1767,
   FQN="(anonymous namespace)::ASTDumper::VisitStmt", NM="_ZN12_GLOBAL__N_19ASTDumper9VisitStmtEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper9VisitStmtEPKN5clang4StmtE")
  //</editor-fold>
  public void VisitStmt(/*const*/ Stmt /*P*/ Node) {
    {
      ColorScope Color = null;
      try {
        Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.StmtColor));
        OS.$out(Node.getStmtClassName());
      } finally {
        if (Color != null) { Color.$destroy(); }
      }
    }
    dumpPointer(Node);
    dumpSourceRange(Node.getSourceRange());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitDeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1776,
   FQN="(anonymous namespace)::ASTDumper::VisitDeclStmt", NM="_ZN12_GLOBAL__N_19ASTDumper13VisitDeclStmtEPKN5clang8DeclStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper13VisitDeclStmtEPKN5clang8DeclStmtE")
  //</editor-fold>
  public void VisitDeclStmt(/*const*/ DeclStmt /*P*/ Node) {
    VisitStmt(Node);
    for (type$ptr<Decl/*P*/>/*iterator*/ I = $tryClone(Node.decl_begin$Const()), 
        /*P*/ /*const*/ /*P*/ E = $tryClone(Node.decl_end$Const());
         $noteq_ptr(I, E); I.$preInc())  {
      dumpDecl(I.$star());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitAttributedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1784,
   FQN="(anonymous namespace)::ASTDumper::VisitAttributedStmt", NM="_ZN12_GLOBAL__N_19ASTDumper19VisitAttributedStmtEPKN5clang14AttributedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper19VisitAttributedStmtEPKN5clang14AttributedStmtE")
  //</editor-fold>
  public void VisitAttributedStmt(/*const*/ AttributedStmt /*P*/ Node) {
    VisitStmt(Node);
    for (type$ptr</*const*/ Attr /*P*/ /*P*/> I = $tryClone(Node.getAttrs().begin()), 
        /*P*/ E = $tryClone(Node.getAttrs().end());
         $noteq_ptr(I, E); I.$preInc())  {
      dumpAttr(I.$star());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitLabelStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1792,
   FQN="(anonymous namespace)::ASTDumper::VisitLabelStmt", NM="_ZN12_GLOBAL__N_19ASTDumper14VisitLabelStmtEPKN5clang9LabelStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper14VisitLabelStmtEPKN5clang9LabelStmtE")
  //</editor-fold>
  public void VisitLabelStmt(/*const*/ LabelStmt /*P*/ Node) {
    VisitStmt(Node);
    OS.$out(/*KEEP_STR*/" '").$out(Node.getName()).$out(/*KEEP_STR*/$SGL_QUOTE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitGotoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1797,
   FQN="(anonymous namespace)::ASTDumper::VisitGotoStmt", NM="_ZN12_GLOBAL__N_19ASTDumper13VisitGotoStmtEPKN5clang8GotoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper13VisitGotoStmtEPKN5clang8GotoStmtE")
  //</editor-fold>
  public void VisitGotoStmt(/*const*/ GotoStmt /*P*/ Node) {
    VisitStmt(Node);
    OS.$out(/*KEEP_STR*/" '").$out(Node.getLabel().getName()).$out(/*KEEP_STR*/$SGL_QUOTE);
    dumpPointer(Node.getLabel());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitCXXCatchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1803,
   FQN="(anonymous namespace)::ASTDumper::VisitCXXCatchStmt", NM="_ZN12_GLOBAL__N_19ASTDumper17VisitCXXCatchStmtEPKN5clang12CXXCatchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper17VisitCXXCatchStmtEPKN5clang12CXXCatchStmtE")
  //</editor-fold>
  public void VisitCXXCatchStmt(/*const*/ CXXCatchStmt /*P*/ Node) {
    VisitStmt(Node);
    dumpDecl(Node.getExceptionDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitCapturedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1808,
   FQN="(anonymous namespace)::ASTDumper::VisitCapturedStmt", NM="_ZN12_GLOBAL__N_19ASTDumper17VisitCapturedStmtEPKN5clang12CapturedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper17VisitCapturedStmtEPKN5clang12CapturedStmtE")
  //</editor-fold>
  public void VisitCapturedStmt(/*const*/ CapturedStmt /*P*/ Node) {
    VisitStmt(Node);
    dumpDecl(Node.getCapturedDecl$Const());
  }

  
  // OpenMP
  
  //===----------------------------------------------------------------------===//
  //  OpenMP dumping methods.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitOMPExecutableDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1817,
   FQN="(anonymous namespace)::ASTDumper::VisitOMPExecutableDirective", NM="_ZN12_GLOBAL__N_19ASTDumper27VisitOMPExecutableDirectiveEPKN5clang22OMPExecutableDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper27VisitOMPExecutableDirectiveEPKN5clang22OMPExecutableDirectiveE")
  //</editor-fold>
  public void VisitOMPExecutableDirective(/*const*/ OMPExecutableDirective /*P*/ Node) {
    VisitStmt(Node);
    for (OMPClause /*P*/ C : Node.clauses$Const()) {
      OMPClause L$C = C;
      dumpChild(/*[=, =L$C(C), this]*/() -> {
                if (!(L$C != null)) {
                  ColorScope Color = null;
                  try {
                    Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.NullColor));
                    OS.$out(/*KEEP_STR*/"<<<NULL>>> OMPClause");
                    return;
                  } finally {
                    if (Color != null) { Color.$destroy(); }
                  }
                }
                {
                  ColorScope Color = null;
                  try {
                    Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.AttrColor));
                    StringRef ClauseName/*J*/= new StringRef(getOpenMPClauseName(L$C.getClauseKind()));
                    OS.$out(/*KEEP_STR*/"OMP").$out(ClauseName.substr(/*Start=*/ 0, /*N=*/ 1).upper()).$out(
                        ClauseName.drop_front()
                    ).$out(/*KEEP_STR*/"Clause");
                  } finally {
                    if (Color != null) { Color.$destroy(); }
                  }
                }
                dumpPointer(L$C);
                dumpSourceRange(new SourceRange(L$C.getLocStart(), L$C.getLocEnd()));
                if (L$C.isImplicit()) {
                  OS.$out(/*KEEP_STR*/" <implicit>");
                }
                for (Stmt /*P*/ S : L$C.children())  {
                  dumpStmt(S);
                }
              });
    }
  }

  
  // Exprs
  
  //===----------------------------------------------------------------------===//
  //  Expr dumping methods.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1847,
   FQN="(anonymous namespace)::ASTDumper::VisitExpr", NM="_ZN12_GLOBAL__N_19ASTDumper9VisitExprEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper9VisitExprEPKN5clang4ExprE")
  //</editor-fold>
  public void VisitExpr(/*const*/ Expr /*P*/ Node) {
    VisitStmt(Node);
    dumpType(Node.getType());
    {
      ColorScope Color = null;
      try {
        Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.ValueKindColor));
        switch (Node.getValueKind()) {
         case VK_RValue:
          break;
         case VK_LValue:
          OS.$out(/*KEEP_STR*/" lvalue");
          break;
         case VK_XValue:
          OS.$out(/*KEEP_STR*/" xvalue");
          break;
        }
      } finally {
        if (Color != null) { Color.$destroy(); }
      }
    }
    {
      ColorScope Color = null;
      try {
        Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.ObjectKindColor));
        switch (Node.getObjectKind()) {
         case OK_Ordinary:
          break;
         case OK_BitField:
          OS.$out(/*KEEP_STR*/" bitfield");
          break;
         case OK_ObjCProperty:
          OS.$out(/*KEEP_STR*/" objcproperty");
          break;
         case OK_ObjCSubscript:
          OS.$out(/*KEEP_STR*/" objcsubscript");
          break;
         case OK_VectorComponent:
          OS.$out(/*KEEP_STR*/" vectorcomponent");
          break;
        }
      } finally {
        if (Color != null) { Color.$destroy(); }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitCastExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1911,
   FQN="(anonymous namespace)::ASTDumper::VisitCastExpr", NM="_ZN12_GLOBAL__N_19ASTDumper13VisitCastExprEPKN5clang8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper13VisitCastExprEPKN5clang8CastExprE")
  //</editor-fold>
  public void VisitCastExpr(/*const*/ CastExpr /*P*/ Node) {
    VisitExpr(Node);
    OS.$out(/*KEEP_STR*/" <");
    {
      ColorScope Color = null;
      try {
        Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.CastColor));
        OS.$out(Node.getCastKindName());
      } finally {
        if (Color != null) { Color.$destroy(); }
      }
    }
    ASTDumperStatics.dumpBasePath(OS, Node);
    OS.$out(/*KEEP_STR*/$GT);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1922,
   FQN="(anonymous namespace)::ASTDumper::VisitDeclRefExpr", NM="_ZN12_GLOBAL__N_19ASTDumper16VisitDeclRefExprEPKN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper16VisitDeclRefExprEPKN5clang11DeclRefExprE")
  //</editor-fold>
  public void VisitDeclRefExpr(/*const*/ DeclRefExpr /*P*/ Node) {
    VisitExpr(Node);
    
    OS.$out(/*KEEP_STR*/$SPACE);
    dumpBareDeclRef(Node.getDecl$Const());
    if (Node.getDecl$Const() != Node.getFoundDecl$Const()) {
      OS.$out(/*KEEP_STR*/" (");
      dumpBareDeclRef(Node.getFoundDecl$Const());
      OS.$out(/*KEEP_STR*/$RPAREN);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitPredefinedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1962,
   FQN="(anonymous namespace)::ASTDumper::VisitPredefinedExpr", NM="_ZN12_GLOBAL__N_19ASTDumper19VisitPredefinedExprEPKN5clang14PredefinedExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper19VisitPredefinedExprEPKN5clang14PredefinedExprE")
  //</editor-fold>
  public void VisitPredefinedExpr(/*const*/ PredefinedExpr /*P*/ Node) {
    VisitExpr(Node);
    OS.$out(/*KEEP_STR*/$SPACE).$out(PredefinedExpr.getIdentTypeName(Node.getIdentType()));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitCharacterLiteral">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1967,
   FQN="(anonymous namespace)::ASTDumper::VisitCharacterLiteral", NM="_ZN12_GLOBAL__N_19ASTDumper21VisitCharacterLiteralEPKN5clang16CharacterLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper21VisitCharacterLiteralEPKN5clang16CharacterLiteralE")
  //</editor-fold>
  public void VisitCharacterLiteral(/*const*/ CharacterLiteral /*P*/ Node) {
    ColorScope Color = null;
    try {
      VisitExpr(Node);
      Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.ValueColor));
      OS.$out(/*KEEP_STR*/$SPACE).$out_uint(Node.getValue());
    } finally {
      if (Color != null) { Color.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitIntegerLiteral">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1973,
   FQN="(anonymous namespace)::ASTDumper::VisitIntegerLiteral", NM="_ZN12_GLOBAL__N_19ASTDumper19VisitIntegerLiteralEPKN5clang14IntegerLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper19VisitIntegerLiteralEPKN5clang14IntegerLiteralE")
  //</editor-fold>
  public void VisitIntegerLiteral(/*const*/ IntegerLiteral /*P*/ Node) {
    ColorScope Color = null;
    try {
      VisitExpr(Node);
      
      boolean isSigned = Node.getType().$arrow().isSignedIntegerType();
      Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.ValueColor));
      OS.$out(/*KEEP_STR*/$SPACE).$out(Node.getValue().__toString(10, isSigned));
    } finally {
      if (Color != null) { Color.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitFloatingLiteral">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1981,
   FQN="(anonymous namespace)::ASTDumper::VisitFloatingLiteral", NM="_ZN12_GLOBAL__N_19ASTDumper20VisitFloatingLiteralEPKN5clang15FloatingLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper20VisitFloatingLiteralEPKN5clang15FloatingLiteralE")
  //</editor-fold>
  public void VisitFloatingLiteral(/*const*/ FloatingLiteral /*P*/ Node) {
    ColorScope Color = null;
    try {
      VisitExpr(Node);
      Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.ValueColor));
      OS.$out(/*KEEP_STR*/$SPACE).$out_double(Node.getValueAsApproximateDouble());
    } finally {
      if (Color != null) { Color.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitStringLiteral">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1987,
   FQN="(anonymous namespace)::ASTDumper::VisitStringLiteral", NM="_ZN12_GLOBAL__N_19ASTDumper18VisitStringLiteralEPKN5clang13StringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper18VisitStringLiteralEPKN5clang13StringLiteralE")
  //</editor-fold>
  public void VisitStringLiteral(/*const*/ StringLiteral /*P*/ Str) {
    ColorScope Color = null;
    try {
      VisitExpr(Str);
      Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.ValueColor));
      OS.$out(/*KEEP_STR*/$SPACE);
      Str.outputString(OS);
    } finally {
      if (Color != null) { Color.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitInitListExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1994,
   FQN="(anonymous namespace)::ASTDumper::VisitInitListExpr", NM="_ZN12_GLOBAL__N_19ASTDumper17VisitInitListExprEPKN5clang12InitListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper17VisitInitListExprEPKN5clang12InitListExprE")
  //</editor-fold>
  public void VisitInitListExpr(/*const*/ InitListExpr /*P*/ ILE) {
    VisitExpr(ILE);
    {
      /*const*/ Expr /*P*/ Filler = ILE.getArrayFiller$Const();
      if ((Filler != null)) {
        Expr L$Filler = Filler;
        dumpChild(/*[=, this, =L$Filler(Filler)]*/() -> {
                  OS.$out(/*KEEP_STR*/"array filler");
                  dumpStmt(L$Filler);
                });
      }
    }
    {
      /*const*/ FieldDecl /*P*/ Field = ILE.getInitializedFieldInUnion$Const();
      if ((Field != null)) {
        OS.$out(/*KEEP_STR*/" field ");
        dumpBareDeclRef(Field);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitUnaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2008,
   FQN="(anonymous namespace)::ASTDumper::VisitUnaryOperator", NM="_ZN12_GLOBAL__N_19ASTDumper18VisitUnaryOperatorEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper18VisitUnaryOperatorEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public void VisitUnaryOperator(/*const*/ UnaryOperator /*P*/ Node) {
    VisitExpr(Node);
    OS.$out(/*KEEP_STR*/$SPACE).$out((Node.isPostfix() ? $("postfix") : $("prefix"))).$out(
        /*KEEP_STR*/" '"
    ).$out(UnaryOperator.getOpcodeStr(Node.getOpcode())).$out(/*KEEP_STR*/$SGL_QUOTE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitUnaryExprOrTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2014,
   FQN="(anonymous namespace)::ASTDumper::VisitUnaryExprOrTypeTraitExpr", NM="_ZN12_GLOBAL__N_19ASTDumper29VisitUnaryExprOrTypeTraitExprEPKN5clang24UnaryExprOrTypeTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper29VisitUnaryExprOrTypeTraitExprEPKN5clang24UnaryExprOrTypeTraitExprE")
  //</editor-fold>
  public void VisitUnaryExprOrTypeTraitExpr(/*const*/ UnaryExprOrTypeTraitExpr /*P*/ Node) {
    VisitExpr(Node);
    switch (Node.getKind()) {
     case UETT_SizeOf:
      OS.$out(/*KEEP_STR*/" sizeof");
      break;
     case UETT_AlignOf:
      OS.$out(/*KEEP_STR*/" alignof");
      break;
     case UETT_VecStep:
      OS.$out(/*KEEP_STR*/" vec_step");
      break;
     case UETT_OpenMPRequiredSimdAlign:
      OS.$out(/*KEEP_STR*/" __builtin_omp_required_simd_align");
      break;
    }
    if (Node.isArgumentType()) {
      dumpType(Node.getArgumentType());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2035,
   FQN="(anonymous namespace)::ASTDumper::VisitMemberExpr", NM="_ZN12_GLOBAL__N_19ASTDumper15VisitMemberExprEPKN5clang10MemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper15VisitMemberExprEPKN5clang10MemberExprE")
  //</editor-fold>
  public void VisitMemberExpr(/*const*/ MemberExpr /*P*/ Node) {
    VisitExpr(Node);
    $out_raw_ostream_NamedDecl$C(OS.$out(/*KEEP_STR*/$SPACE).$out((Node.isArrow() ? $ARROW : $DOT)), $Deref(Node.getMemberDecl()));
    dumpPointer(Node.getMemberDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitExtVectorElementExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2041,
   FQN="(anonymous namespace)::ASTDumper::VisitExtVectorElementExpr", NM="_ZN12_GLOBAL__N_19ASTDumper25VisitExtVectorElementExprEPKN5clang20ExtVectorElementExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper25VisitExtVectorElementExprEPKN5clang20ExtVectorElementExprE")
  //</editor-fold>
  public void VisitExtVectorElementExpr(/*const*/ ExtVectorElementExpr /*P*/ Node) {
    VisitExpr(Node);
    OS.$out(/*KEEP_STR*/$SPACE).$out(Node.getAccessor().getNameStart());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2046,
   FQN="(anonymous namespace)::ASTDumper::VisitBinaryOperator", NM="_ZN12_GLOBAL__N_19ASTDumper19VisitBinaryOperatorEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper19VisitBinaryOperatorEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public void VisitBinaryOperator(/*const*/ BinaryOperator /*P*/ Node) {
    VisitExpr(Node);
    OS.$out(/*KEEP_STR*/" '").$out(BinaryOperator.getOpcodeStr(Node.getOpcode())).$out(/*KEEP_STR*/$SGL_QUOTE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitCompoundAssignOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2051,
   FQN="(anonymous namespace)::ASTDumper::VisitCompoundAssignOperator", NM="_ZN12_GLOBAL__N_19ASTDumper27VisitCompoundAssignOperatorEPKN5clang22CompoundAssignOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper27VisitCompoundAssignOperatorEPKN5clang22CompoundAssignOperatorE")
  //</editor-fold>
  public void VisitCompoundAssignOperator(/*const*/ CompoundAssignOperator /*P*/ Node) {
    VisitExpr(Node);
    OS.$out(/*KEEP_STR*/" '").$out(BinaryOperator.getOpcodeStr(Node.getOpcode())).$out(
        /*KEEP_STR*/"' ComputeLHSTy="
    );
    dumpBareType(Node.getComputationLHSType());
    OS.$out(/*KEEP_STR*/" ComputeResultTy=");
    dumpBareType(Node.getComputationResultType());
  }

  
  // GNU extensions.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitAddrLabelExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2075,
   FQN="(anonymous namespace)::ASTDumper::VisitAddrLabelExpr", NM="_ZN12_GLOBAL__N_19ASTDumper18VisitAddrLabelExprEPKN5clang13AddrLabelExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper18VisitAddrLabelExprEPKN5clang13AddrLabelExprE")
  //</editor-fold>
  public void VisitAddrLabelExpr(/*const*/ AddrLabelExpr /*P*/ Node) {
    VisitExpr(Node);
    OS.$out(/*KEEP_STR*/$SPACE).$out(Node.getLabel().getName());
    dumpPointer(Node.getLabel());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitBlockExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2061,
   FQN="(anonymous namespace)::ASTDumper::VisitBlockExpr", NM="_ZN12_GLOBAL__N_19ASTDumper14VisitBlockExprEPKN5clang9BlockExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper14VisitBlockExprEPKN5clang9BlockExprE")
  //</editor-fold>
  public void VisitBlockExpr(/*const*/ BlockExpr /*P*/ Node) {
    VisitExpr(Node);
    dumpDecl(Node.getBlockDecl$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitOpaqueValueExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2066,
   FQN="(anonymous namespace)::ASTDumper::VisitOpaqueValueExpr", NM="_ZN12_GLOBAL__N_19ASTDumper20VisitOpaqueValueExprEPKN5clang15OpaqueValueExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper20VisitOpaqueValueExprEPKN5clang15OpaqueValueExprE")
  //</editor-fold>
  public void VisitOpaqueValueExpr(/*const*/ OpaqueValueExpr /*P*/ Node) {
    VisitExpr(Node);
    {
      
      Expr /*P*/ Source = Node.getSourceExpr();
      if ((Source != null)) {
        dumpStmt(Source);
      }
    }
  }

  
  // C++
  
  //===----------------------------------------------------------------------===//
  // C++ Expressions
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitCXXNamedCastExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2085,
   FQN="(anonymous namespace)::ASTDumper::VisitCXXNamedCastExpr", NM="_ZN12_GLOBAL__N_19ASTDumper21VisitCXXNamedCastExprEPKN5clang16CXXNamedCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper21VisitCXXNamedCastExprEPKN5clang16CXXNamedCastExprE")
  //</editor-fold>
  public void VisitCXXNamedCastExpr(/*const*/ CXXNamedCastExpr /*P*/ Node) {
    VisitExpr(Node);
    OS.$out(/*KEEP_STR*/$SPACE).$out(Node.getCastName()).$out(
        /*KEEP_STR*/$LT
    ).$out(Node.getTypeAsWritten().getAsString()).$out(/*KEEP_STR*/$GT).$out(
        /*KEEP_STR*/" <"
    ).$out(Node.getCastKindName());
    ASTDumperStatics.dumpBasePath(OS, Node);
    OS.$out(/*KEEP_STR*/$GT);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitCXXBoolLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2094,
   FQN="(anonymous namespace)::ASTDumper::VisitCXXBoolLiteralExpr", NM="_ZN12_GLOBAL__N_19ASTDumper23VisitCXXBoolLiteralExprEPKN5clang18CXXBoolLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper23VisitCXXBoolLiteralExprEPKN5clang18CXXBoolLiteralExprE")
  //</editor-fold>
  public void VisitCXXBoolLiteralExpr(/*const*/ CXXBoolLiteralExpr /*P*/ Node) {
    VisitExpr(Node);
    OS.$out(/*KEEP_STR*/$SPACE).$out((Node.getValue() ? $true : $false));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitCXXThisExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2099,
   FQN="(anonymous namespace)::ASTDumper::VisitCXXThisExpr", NM="_ZN12_GLOBAL__N_19ASTDumper16VisitCXXThisExprEPKN5clang11CXXThisExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper16VisitCXXThisExprEPKN5clang11CXXThisExprE")
  //</editor-fold>
  public void VisitCXXThisExpr(/*const*/ CXXThisExpr /*P*/ Node) {
    VisitExpr(Node);
    OS.$out(/*KEEP_STR*/" this");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitCXXFunctionalCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2104,
   FQN="(anonymous namespace)::ASTDumper::VisitCXXFunctionalCastExpr", NM="_ZN12_GLOBAL__N_19ASTDumper26VisitCXXFunctionalCastExprEPKN5clang21CXXFunctionalCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper26VisitCXXFunctionalCastExprEPKN5clang21CXXFunctionalCastExprE")
  //</editor-fold>
  public void VisitCXXFunctionalCastExpr(/*const*/ CXXFunctionalCastExpr /*P*/ Node) {
    VisitExpr(Node);
    OS.$out(/*KEEP_STR*/" functional cast to ").$out(Node.getTypeAsWritten().getAsString()).$out(
        /*KEEP_STR*/" <"
    ).$out(Node.getCastKindName()).$out(/*KEEP_STR*/$GT);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitCXXConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2110,
   FQN="(anonymous namespace)::ASTDumper::VisitCXXConstructExpr", NM="_ZN12_GLOBAL__N_19ASTDumper21VisitCXXConstructExprEPKN5clang16CXXConstructExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper21VisitCXXConstructExprEPKN5clang16CXXConstructExprE")
  //</editor-fold>
  public void VisitCXXConstructExpr(/*const*/ CXXConstructExpr /*P*/ Node) {
    VisitExpr(Node);
    CXXConstructorDecl /*P*/ Ctor = Node.getConstructor();
    dumpType(Ctor.getType());
    if (Node.isElidable()) {
      OS.$out(/*KEEP_STR*/" elidable");
    }
    if (Node.requiresZeroInitialization()) {
      OS.$out(/*KEEP_STR*/" zeroing");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitCXXBindTemporaryExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2120,
   FQN="(anonymous namespace)::ASTDumper::VisitCXXBindTemporaryExpr", NM="_ZN12_GLOBAL__N_19ASTDumper25VisitCXXBindTemporaryExprEPKN5clang20CXXBindTemporaryExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper25VisitCXXBindTemporaryExprEPKN5clang20CXXBindTemporaryExprE")
  //</editor-fold>
  public void VisitCXXBindTemporaryExpr(/*const*/ CXXBindTemporaryExpr /*P*/ Node) {
    VisitExpr(Node);
    OS.$out(/*KEEP_STR*/$SPACE);
    dumpCXXTemporary(Node.getTemporary$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitCXXNewExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2126,
   FQN="(anonymous namespace)::ASTDumper::VisitCXXNewExpr", NM="_ZN12_GLOBAL__N_19ASTDumper15VisitCXXNewExprEPKN5clang10CXXNewExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper15VisitCXXNewExprEPKN5clang10CXXNewExprE")
  //</editor-fold>
  public void VisitCXXNewExpr(/*const*/ CXXNewExpr /*P*/ Node) {
    VisitExpr(Node);
    if (Node.isGlobalNew()) {
      OS.$out(/*KEEP_STR*/" global");
    }
    if (Node.isArray()) {
      OS.$out(/*KEEP_STR*/" array");
    }
    if ((Node.getOperatorNew() != null)) {
      OS.$out_char($$SPACE);
      dumpBareDeclRef(Node.getOperatorNew());
    }
    // We could dump the deallocation function used in case of error, but it's
    // usually not that interesting.
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitCXXDeleteExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2140,
   FQN="(anonymous namespace)::ASTDumper::VisitCXXDeleteExpr", NM="_ZN12_GLOBAL__N_19ASTDumper18VisitCXXDeleteExprEPKN5clang13CXXDeleteExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper18VisitCXXDeleteExprEPKN5clang13CXXDeleteExprE")
  //</editor-fold>
  public void VisitCXXDeleteExpr(/*const*/ CXXDeleteExpr /*P*/ Node) {
    VisitExpr(Node);
    if (Node.isGlobalDelete()) {
      OS.$out(/*KEEP_STR*/" global");
    }
    if (Node.isArrayForm()) {
      OS.$out(/*KEEP_STR*/" array");
    }
    if ((Node.getOperatorDelete() != null)) {
      OS.$out_char($$SPACE);
      dumpBareDeclRef(Node.getOperatorDelete());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitMaterializeTemporaryExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2152,
   FQN="(anonymous namespace)::ASTDumper::VisitMaterializeTemporaryExpr", NM="_ZN12_GLOBAL__N_19ASTDumper29VisitMaterializeTemporaryExprEPKN5clang24MaterializeTemporaryExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper29VisitMaterializeTemporaryExprEPKN5clang24MaterializeTemporaryExprE")
  //</editor-fold>
  public void VisitMaterializeTemporaryExpr(/*const*/ MaterializeTemporaryExpr /*P*/ Node) {
    VisitExpr(Node);
    {
      /*const*/ ValueDecl /*P*/ VD = Node.getExtendingDecl();
      if ((VD != null)) {
        OS.$out(/*KEEP_STR*/" extended by ");
        dumpBareDeclRef(VD);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitExprWithCleanups">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2161,
   FQN="(anonymous namespace)::ASTDumper::VisitExprWithCleanups", NM="_ZN12_GLOBAL__N_19ASTDumper21VisitExprWithCleanupsEPKN5clang16ExprWithCleanupsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper21VisitExprWithCleanupsEPKN5clang16ExprWithCleanupsE")
  //</editor-fold>
  public void VisitExprWithCleanups(/*const*/ ExprWithCleanups /*P*/ Node) {
    VisitExpr(Node);
    for (/*uint*/int i = 0, e = Node.getNumObjects(); i != e; ++i)  {
      dumpDeclRef(Node.getObject(i), $("cleanup"));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitUnresolvedLookupExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1934,
   FQN="(anonymous namespace)::ASTDumper::VisitUnresolvedLookupExpr", NM="_ZN12_GLOBAL__N_19ASTDumper25VisitUnresolvedLookupExprEPKN5clang20UnresolvedLookupExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper25VisitUnresolvedLookupExprEPKN5clang20UnresolvedLookupExprE")
  //</editor-fold>
  public void VisitUnresolvedLookupExpr(/*const*/ UnresolvedLookupExpr /*P*/ Node) {
    VisitExpr(Node);
    OS.$out(/*KEEP_STR*/" (");
    if (!Node.requiresADL()) {
      OS.$out(/*KEEP_STR*/"no ");
    }
    $out_raw_ostream_DeclarationName(OS.$out(/*KEEP_STR*/"ADL) = '"), Node.getName()).$out_char($$SGL_QUOTE);
    
    UnresolvedSetIterator I = Node.decls_begin();
    UnresolvedSetIterator E = Node.decls_end();
    if (I.$eq(E)) {
      OS.$out(/*KEEP_STR*/" empty");
    }
    for (; I.$noteq(E); I.$preInc())  {
      dumpPointer(I.$star());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::dumpCXXTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2167,
   FQN="(anonymous namespace)::ASTDumper::dumpCXXTemporary", NM="_ZN12_GLOBAL__N_19ASTDumper16dumpCXXTemporaryEPKN5clang12CXXTemporaryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper16dumpCXXTemporaryEPKN5clang12CXXTemporaryE")
  //</editor-fold>
  public void dumpCXXTemporary(/*const*/ CXXTemporary /*P*/ Temporary) {
    OS.$out(/*KEEP_STR*/"(CXXTemporary");
    dumpPointer(Temporary);
    OS.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitLambdaExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 541,
   FQN="(anonymous namespace)::ASTDumper::VisitLambdaExpr", NM="_ZN12_GLOBAL__N_19ASTDumper15VisitLambdaExprEPKN5clang10LambdaExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper15VisitLambdaExprEPKN5clang10LambdaExprE")
  //</editor-fold>
  public void VisitLambdaExpr(/*const*/ LambdaExpr /*P*/ Node) {
    VisitExpr(Node);
    dumpDecl(Node.getLambdaClass());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitSizeOfPackExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2173,
   FQN="(anonymous namespace)::ASTDumper::VisitSizeOfPackExpr", NM="_ZN12_GLOBAL__N_19ASTDumper19VisitSizeOfPackExprEPKN5clang14SizeOfPackExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper19VisitSizeOfPackExprEPKN5clang14SizeOfPackExprE")
  //</editor-fold>
  public void VisitSizeOfPackExpr(/*const*/ SizeOfPackExpr /*P*/ Node) {
    VisitExpr(Node);
    dumpPointer(Node.getPack());
    dumpName(Node.getPack());
    if (Node.isPartiallySubstituted()) {
      for (final /*const*/ TemplateArgument /*&*/ A : Node.getPartialArguments())  {
        dumpTemplateArgument(A);
      }
    }
  }

  
  // ObjC
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitObjCAtCatchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2218,
   FQN="(anonymous namespace)::ASTDumper::VisitObjCAtCatchStmt", NM="_ZN12_GLOBAL__N_19ASTDumper20VisitObjCAtCatchStmtEPKN5clang15ObjCAtCatchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper20VisitObjCAtCatchStmtEPKN5clang15ObjCAtCatchStmtE")
  //</editor-fold>
  public void VisitObjCAtCatchStmt(/*const*/ ObjCAtCatchStmt /*P*/ Node) {
    VisitStmt(Node);
    {
      /*const*/ VarDecl /*P*/ CatchParam = Node.getCatchParamDecl$Const();
      if ((CatchParam != null)) {
        dumpDecl(CatchParam);
      } else {
        OS.$out(/*KEEP_STR*/" catch all");
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitObjCEncodeExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2226,
   FQN="(anonymous namespace)::ASTDumper::VisitObjCEncodeExpr", NM="_ZN12_GLOBAL__N_19ASTDumper19VisitObjCEncodeExprEPKN5clang14ObjCEncodeExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper19VisitObjCEncodeExprEPKN5clang14ObjCEncodeExprE")
  //</editor-fold>
  public void VisitObjCEncodeExpr(/*const*/ ObjCEncodeExpr /*P*/ Node) {
    VisitExpr(Node);
    dumpType(Node.getEncodedType());
  }

  
  //===----------------------------------------------------------------------===//
  // Obj-C Expressions
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitObjCMessageExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2187,
   FQN="(anonymous namespace)::ASTDumper::VisitObjCMessageExpr", NM="_ZN12_GLOBAL__N_19ASTDumper20VisitObjCMessageExprEPKN5clang15ObjCMessageExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper20VisitObjCMessageExprEPKN5clang15ObjCMessageExprE")
  //</editor-fold>
  public void VisitObjCMessageExpr(/*const*/ ObjCMessageExpr /*P*/ Node) {
    VisitExpr(Node);
    OS.$out(/*KEEP_STR*/" selector=");
    Node.getSelector().print(OS);
    switch (Node.getReceiverKind()) {
     case Instance:
      break;
     case Class:
      OS.$out(/*KEEP_STR*/" class=");
      dumpBareType(Node.getClassReceiver());
      break;
     case SuperInstance:
      OS.$out(/*KEEP_STR*/" super (instance)");
      break;
     case SuperClass:
      OS.$out(/*KEEP_STR*/" super (class)");
      break;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitObjCBoxedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2210,
   FQN="(anonymous namespace)::ASTDumper::VisitObjCBoxedExpr", NM="_ZN12_GLOBAL__N_19ASTDumper18VisitObjCBoxedExprEPKN5clang13ObjCBoxedExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper18VisitObjCBoxedExprEPKN5clang13ObjCBoxedExprE")
  //</editor-fold>
  public void VisitObjCBoxedExpr(/*const*/ ObjCBoxedExpr /*P*/ Node) {
    VisitExpr(Node);
    {
      ObjCMethodDecl /*P*/ BoxingMethod = Node.getBoxingMethod();
      if ((BoxingMethod != null)) {
        OS.$out(/*KEEP_STR*/" selector=");
        BoxingMethod.getSelector().print(OS);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitObjCSelectorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2231,
   FQN="(anonymous namespace)::ASTDumper::VisitObjCSelectorExpr", NM="_ZN12_GLOBAL__N_19ASTDumper21VisitObjCSelectorExprEPKN5clang16ObjCSelectorExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper21VisitObjCSelectorExprEPKN5clang16ObjCSelectorExprE")
  //</editor-fold>
  public void VisitObjCSelectorExpr(/*const*/ ObjCSelectorExpr /*P*/ Node) {
    VisitExpr(Node);
    
    OS.$out(/*KEEP_STR*/$SPACE);
    Node.getSelector().print(OS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitObjCProtocolExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2238,
   FQN="(anonymous namespace)::ASTDumper::VisitObjCProtocolExpr", NM="_ZN12_GLOBAL__N_19ASTDumper21VisitObjCProtocolExprEPKN5clang16ObjCProtocolExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper21VisitObjCProtocolExprEPKN5clang16ObjCProtocolExprE")
  //</editor-fold>
  public void VisitObjCProtocolExpr(/*const*/ ObjCProtocolExpr /*P*/ Node) {
    VisitExpr(Node);
    
    $out_raw_ostream_NamedDecl$C(OS.$out_char($$SPACE), $Deref(Node.getProtocol()));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitObjCPropertyRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2244,
   FQN="(anonymous namespace)::ASTDumper::VisitObjCPropertyRefExpr", NM="_ZN12_GLOBAL__N_19ASTDumper24VisitObjCPropertyRefExprEPKN5clang19ObjCPropertyRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper24VisitObjCPropertyRefExprEPKN5clang19ObjCPropertyRefExprE")
  //</editor-fold>
  public void VisitObjCPropertyRefExpr(/*const*/ ObjCPropertyRefExpr /*P*/ Node) {
    VisitExpr(Node);
    if (Node.isImplicitProperty()) {
      OS.$out(/*KEEP_STR*/" Kind=MethodRef Getter=\"");
      if ((Node.getImplicitPropertyGetter() != null)) {
        Node.getImplicitPropertyGetter().getSelector().print(OS);
      } else {
        OS.$out(/*KEEP_STR*/"(null)");
      }
      
      OS.$out(/*KEEP_STR*/"\" Setter=\"");
      {
        ObjCMethodDecl /*P*/ Setter = Node.getImplicitPropertySetter();
        if ((Setter != null)) {
          Setter.getSelector().print(OS);
        } else {
          OS.$out(/*KEEP_STR*/"(null)");
        }
      }
      OS.$out(/*KEEP_STR*/$DBL_QUOTE);
    } else {
      $out_raw_ostream_NamedDecl$C(OS.$out(/*KEEP_STR*/" Kind=PropertyRef Property=\""), $Deref(Node.getExplicitProperty())).$out_char($$DBL_QUOTE);
    }
    if (Node.isSuperReceiver()) {
      OS.$out(/*KEEP_STR*/" super");
    }
    
    OS.$out(/*KEEP_STR*/" Messaging=");
    if (Node.isMessagingGetter() && Node.isMessagingSetter()) {
      OS.$out(/*KEEP_STR*/"Getter&Setter");
    } else if (Node.isMessagingGetter()) {
      OS.$out(/*KEEP_STR*/"Getter");
    } else if (Node.isMessagingSetter()) {
      OS.$out(/*KEEP_STR*/"Setter");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitObjCSubscriptRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2275,
   FQN="(anonymous namespace)::ASTDumper::VisitObjCSubscriptRefExpr", NM="_ZN12_GLOBAL__N_19ASTDumper25VisitObjCSubscriptRefExprEPKN5clang20ObjCSubscriptRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper25VisitObjCSubscriptRefExprEPKN5clang20ObjCSubscriptRefExprE")
  //</editor-fold>
  public void VisitObjCSubscriptRefExpr(/*const*/ ObjCSubscriptRefExpr /*P*/ Node) {
    VisitExpr(Node);
    if (Node.isArraySubscriptRefExpr()) {
      OS.$out(/*KEEP_STR*/" Kind=ArraySubscript GetterForArray=\"");
    } else {
      OS.$out(/*KEEP_STR*/" Kind=DictionarySubscript GetterForDictionary=\"");
    }
    if ((Node.getAtIndexMethodDecl() != null)) {
      Node.getAtIndexMethodDecl().getSelector().print(OS);
    } else {
      OS.$out(/*KEEP_STR*/"(null)");
    }
    if (Node.isArraySubscriptRefExpr()) {
      OS.$out(/*KEEP_STR*/"\" SetterForArray=\"");
    } else {
      OS.$out(/*KEEP_STR*/"\" SetterForDictionary=\"");
    }
    if ((Node.setAtIndexMethodDecl() != null)) {
      Node.setAtIndexMethodDecl().getSelector().print(OS);
    } else {
      OS.$out(/*KEEP_STR*/"(null)");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitObjCIvarRefExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1949,
   FQN="(anonymous namespace)::ASTDumper::VisitObjCIvarRefExpr", NM="_ZN12_GLOBAL__N_19ASTDumper20VisitObjCIvarRefExprEPKN5clang15ObjCIvarRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper20VisitObjCIvarRefExprEPKN5clang15ObjCIvarRefExprE")
  //</editor-fold>
  public void VisitObjCIvarRefExpr(/*const*/ ObjCIvarRefExpr /*P*/ Node) {
    VisitExpr(Node);
    {
      ColorScope Color = null;
      try {
        Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.DeclKindNameColor));
        OS.$out(/*KEEP_STR*/$SPACE).$out(Node.getDecl$Const().getDeclKindName()).$out(/*KEEP_STR*/"Decl");
      } finally {
        if (Color != null) { Color.$destroy(); }
      }
    }
    $out_raw_ostream_NamedDecl$C(OS.$out(/*KEEP_STR*/"='"), $Deref(Node.getDecl$Const())).$out(/*KEEP_STR*/$SGL_QUOTE);
    dumpPointer(Node.getDecl$Const());
    if (Node.isFreeIvar()) {
      OS.$out(/*KEEP_STR*/" isFreeIvar");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::VisitObjCBoolLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2296,
   FQN="(anonymous namespace)::ASTDumper::VisitObjCBoolLiteralExpr", NM="_ZN12_GLOBAL__N_19ASTDumper24VisitObjCBoolLiteralExprEPKN5clang19ObjCBoolLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper24VisitObjCBoolLiteralExprEPKN5clang19ObjCBoolLiteralExprE")
  //</editor-fold>
  public void VisitObjCBoolLiteralExpr(/*const*/ ObjCBoolLiteralExpr /*P*/ Node) {
    VisitExpr(Node);
    OS.$out(/*KEEP_STR*/$SPACE).$out((Node.getValue() ? $__objc_yes : $__objc_no));
  }

  
  // Comments.
  
  //===----------------------------------------------------------------------===//
  // Comments
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::getCommandName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2305,
   FQN="(anonymous namespace)::ASTDumper::getCommandName", NM="_ZN12_GLOBAL__N_19ASTDumper14getCommandNameEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper14getCommandNameEj")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getCommandName(/*uint*/int CommandID) {
    if ((Traits != null)) {
      return Traits.getCommandInfo(CommandID).Name;
    }
    /*const*/ CommandInfo /*P*/ Info = CommandTraits.getBuiltinCommandInfo(CommandID);
    if ((Info != null)) {
      return Info.Name;
    }
    return $("<not a builtin command>");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::dumpComment">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2323,
   FQN="(anonymous namespace)::ASTDumper::dumpComment", NM="_ZN12_GLOBAL__N_19ASTDumper11dumpCommentEPKN5clang8comments7CommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper11dumpCommentEPKN5clang8comments7CommentE")
  //</editor-fold>
  public void dumpComment(/*const*/ Comment /*P*/ C) {
    Comment L$C = C;
    dumpChild(/*[=, =L$C(C), this]*/() -> {
              if (!(L$C != null)) {
                ColorScope Color = null;
                try {
                  Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.NullColor));
                  OS.$out(/*KEEP_STR*/"<<<NULL>>>");
                  return;
                } finally {
                  if (Color != null) { Color.$destroy(); }
                }
              }
              {
                ColorScope Color = null;
                try {
                  Color/*J*/= new ColorScope(/*Deref*/this, new TerminalColor(ASTDumperStatics.CommentColor));
                  OS.$out(L$C.getCommentKindName());
                } finally {
                  if (Color != null) { Color.$destroy(); }
                }
              }
              dumpPointer(L$C);
              dumpSourceRange(L$C.getSourceRange());
              ConstCommentVisitorVoid.super.visit(L$C);
              for (type$ptr<Comment/*P*/> I = $tryClone(L$C.child_begin()), E = $tryClone(L$C.child_end());
                   $noteq_ptr(I, E); I.$preInc())  {
                dumpComment(I.$star());
              }
            });
  }

  
  // Inline comments.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::visitTextComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2344,
   FQN="(anonymous namespace)::ASTDumper::visitTextComment", NM="_ZN12_GLOBAL__N_19ASTDumper16visitTextCommentEPKN5clang8comments11TextCommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper16visitTextCommentEPKN5clang8comments11TextCommentE")
  //</editor-fold>
  public void visitTextComment(/*const*/ TextComment /*P*/ C) {
    OS.$out(/*KEEP_STR*/" Text=\"").$out(C.getText()).$out(/*KEEP_STR*/$DBL_QUOTE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::visitInlineCommandComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2348,
   FQN="(anonymous namespace)::ASTDumper::visitInlineCommandComment", NM="_ZN12_GLOBAL__N_19ASTDumper25visitInlineCommandCommentEPKN5clang8comments20InlineCommandCommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper25visitInlineCommandCommentEPKN5clang8comments20InlineCommandCommentE")
  //</editor-fold>
  public void visitInlineCommandComment(/*const*/ InlineCommandComment /*P*/ C) {
    OS.$out(/*KEEP_STR*/" Name=\"").$out(getCommandName(C.getCommandID())).$out(/*KEEP_STR*/$DBL_QUOTE);
    switch (C.getRenderKind()) {
     case RenderNormal:
      OS.$out(/*KEEP_STR*/" RenderNormal");
      break;
     case RenderBold:
      OS.$out(/*KEEP_STR*/" RenderBold");
      break;
     case RenderMonospaced:
      OS.$out(/*KEEP_STR*/" RenderMonospaced");
      break;
     case RenderEmphasized:
      OS.$out(/*KEEP_STR*/" RenderEmphasized");
      break;
    }
    
    for (/*uint*/int i = 0, e = C.getNumArgs(); i != e; ++i)  {
      OS.$out(/*KEEP_STR*/" Arg[").$out_uint(i).$out(/*KEEP_STR*/"]=\"").$out(C.getArgText(i)).$out(/*KEEP_STR*/$DBL_QUOTE);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::visitHTMLStartTagComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2369,
   FQN="(anonymous namespace)::ASTDumper::visitHTMLStartTagComment", NM="_ZN12_GLOBAL__N_19ASTDumper24visitHTMLStartTagCommentEPKN5clang8comments19HTMLStartTagCommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper24visitHTMLStartTagCommentEPKN5clang8comments19HTMLStartTagCommentE")
  //</editor-fold>
  public void visitHTMLStartTagComment(/*const*/ HTMLStartTagComment /*P*/ C) {
    OS.$out(/*KEEP_STR*/" Name=\"").$out(C.getTagName()).$out(/*KEEP_STR*/$DBL_QUOTE);
    if (C.getNumAttrs() != 0) {
      OS.$out(/*KEEP_STR*/" Attrs: ");
      for (/*uint*/int i = 0, e = C.getNumAttrs(); i != e; ++i) {
        final /*const*/ HTMLStartTagComment.Attribute /*&*/ Attr = C.getAttr(i);
        OS.$out(/*KEEP_STR*/" \"").$out(/*NO_COPY*/Attr.Name).$out(/*KEEP_STR*/"=\"").$out(/*NO_COPY*/Attr.Value).$out(/*KEEP_STR*/$DBL_QUOTE);
      }
    }
    if (C.isSelfClosing()) {
      OS.$out(/*KEEP_STR*/" SelfClosing");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::visitHTMLEndTagComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2382,
   FQN="(anonymous namespace)::ASTDumper::visitHTMLEndTagComment", NM="_ZN12_GLOBAL__N_19ASTDumper22visitHTMLEndTagCommentEPKN5clang8comments17HTMLEndTagCommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper22visitHTMLEndTagCommentEPKN5clang8comments17HTMLEndTagCommentE")
  //</editor-fold>
  public void visitHTMLEndTagComment(/*const*/ HTMLEndTagComment /*P*/ C) {
    OS.$out(/*KEEP_STR*/" Name=\"").$out(C.getTagName()).$out(/*KEEP_STR*/$DBL_QUOTE);
  }

  
  // Block comments.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::visitBlockCommandComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2386,
   FQN="(anonymous namespace)::ASTDumper::visitBlockCommandComment", NM="_ZN12_GLOBAL__N_19ASTDumper24visitBlockCommandCommentEPKN5clang8comments19BlockCommandCommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper24visitBlockCommandCommentEPKN5clang8comments19BlockCommandCommentE")
  //</editor-fold>
  public void visitBlockCommandComment(/*const*/ BlockCommandComment /*P*/ C) {
    OS.$out(/*KEEP_STR*/" Name=\"").$out(getCommandName(C.getCommandID())).$out(/*KEEP_STR*/$DBL_QUOTE);
    for (/*uint*/int i = 0, e = C.getNumArgs(); i != e; ++i)  {
      OS.$out(/*KEEP_STR*/" Arg[").$out_uint(i).$out(/*KEEP_STR*/"]=\"").$out(C.getArgText(i)).$out(/*KEEP_STR*/$DBL_QUOTE);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::visitParamCommandComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2392,
   FQN="(anonymous namespace)::ASTDumper::visitParamCommandComment", NM="_ZN12_GLOBAL__N_19ASTDumper24visitParamCommandCommentEPKN5clang8comments19ParamCommandCommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper24visitParamCommandCommentEPKN5clang8comments19ParamCommandCommentE")
  //</editor-fold>
  public void visitParamCommandComment(/*const*/ ParamCommandComment /*P*/ C) {
    OS.$out(/*KEEP_STR*/$SPACE).$out(ParamCommandComment.getDirectionAsString(C.getDirection()));
    if (C.isDirectionExplicit()) {
      OS.$out(/*KEEP_STR*/" explicitly");
    } else {
      OS.$out(/*KEEP_STR*/" implicitly");
    }
    if (C.hasParamName()) {
      if (C.isParamIndexValid()) {
        OS.$out(/*KEEP_STR*/" Param=\"").$out(C.getParamName(FC)).$out(/*KEEP_STR*/$DBL_QUOTE);
      } else {
        OS.$out(/*KEEP_STR*/" Param=\"").$out(C.getParamNameAsWritten()).$out(/*KEEP_STR*/$DBL_QUOTE);
      }
    }
    if (C.isParamIndexValid() && !C.isVarArgParam()) {
      OS.$out(/*KEEP_STR*/" ParamIndex=").$out_uint(C.getParamIndex());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::visitTParamCommandComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2411,
   FQN="(anonymous namespace)::ASTDumper::visitTParamCommandComment", NM="_ZN12_GLOBAL__N_19ASTDumper25visitTParamCommandCommentEPKN5clang8comments20TParamCommandCommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper25visitTParamCommandCommentEPKN5clang8comments20TParamCommandCommentE")
  //</editor-fold>
  public void visitTParamCommandComment(/*const*/ TParamCommandComment /*P*/ C) {
    if (C.hasParamName()) {
      if (C.isPositionValid()) {
        OS.$out(/*KEEP_STR*/" Param=\"").$out(C.getParamName(FC)).$out(/*KEEP_STR*/$DBL_QUOTE);
      } else {
        OS.$out(/*KEEP_STR*/" Param=\"").$out(C.getParamNameAsWritten()).$out(/*KEEP_STR*/$DBL_QUOTE);
      }
    }
    if (C.isPositionValid()) {
      OS.$out(/*KEEP_STR*/" Position=<");
      for (/*uint*/int i = 0, e = C.getDepth(); i != e; ++i) {
        OS.$out_uint(C.getIndex(i));
        if (i != e - 1) {
          OS.$out(/*KEEP_STR*/$COMMA_SPACE);
        }
      }
      OS.$out(/*KEEP_STR*/$GT);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::visitVerbatimBlockComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2430,
   FQN="(anonymous namespace)::ASTDumper::visitVerbatimBlockComment", NM="_ZN12_GLOBAL__N_19ASTDumper25visitVerbatimBlockCommentEPKN5clang8comments20VerbatimBlockCommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper25visitVerbatimBlockCommentEPKN5clang8comments20VerbatimBlockCommentE")
  //</editor-fold>
  public void visitVerbatimBlockComment(/*const*/ VerbatimBlockComment /*P*/ C) {
    OS.$out(/*KEEP_STR*/" Name=\"").$out(getCommandName(C.getCommandID())).$out(/*KEEP_STR*/"\" CloseName=\"").$out(C.getCloseName()).$out(/*KEEP_STR*/$DBL_QUOTE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::visitVerbatimBlockLineComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2435,
   FQN="(anonymous namespace)::ASTDumper::visitVerbatimBlockLineComment", NM="_ZN12_GLOBAL__N_19ASTDumper29visitVerbatimBlockLineCommentEPKN5clang8comments24VerbatimBlockLineCommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper29visitVerbatimBlockLineCommentEPKN5clang8comments24VerbatimBlockLineCommentE")
  //</editor-fold>
  public void visitVerbatimBlockLineComment(/*const*/ VerbatimBlockLineComment /*P*/ C) {
    OS.$out(/*KEEP_STR*/" Text=\"").$out(C.getText()).$out(/*KEEP_STR*/$DBL_QUOTE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::visitVerbatimLineComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2440,
   FQN="(anonymous namespace)::ASTDumper::visitVerbatimLineComment", NM="_ZN12_GLOBAL__N_19ASTDumper24visitVerbatimLineCommentEPKN5clang8comments19VerbatimLineCommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumper24visitVerbatimLineCommentEPKN5clang8comments19VerbatimLineCommentE")
  //</editor-fold>
  public void visitVerbatimLineComment(/*const*/ VerbatimLineComment /*P*/ C) {
    OS.$out(/*KEEP_STR*/" Text=\"").$out(C.getText()).$out(/*KEEP_STR*/$DBL_QUOTE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTDumper::~ASTDumper">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 95,
   FQN="(anonymous namespace)::ASTDumper::~ASTDumper", NM="_ZN12_GLOBAL__N_19ASTDumperD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_19ASTDumperD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Prefix.$destroy();
    Pending.$destroy();
    ConstDeclVisitorVoid.super.$destroy$ConstDeclVisitor();
    ConstStmtVisitorVoid.super.$destroy$ConstStmtVisitor();
    ConstCommentVisitorVoid.super.$destroy$ConstCommentVisitor();
    TypeVisitorVoid.super.$destroy$TypeVisitor();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private class finlDecl2Void implements Decl2Void {
    private finlDecl2Void() {}
  
    @Override
    public void $call(Decl D) {
      {
        Decl /*P*/ Prev = D.getPreviousDecl$Decl();
        if ((Prev != null)) {
          this.$call(Prev);
        }
      }
      dumpDecl(D);
    }
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "OS=" + OS // NOI18N
              + ", Traits=" + Traits // NOI18N
              + ", SM=" + "[SourceManager]" // NOI18N
              + ", Pending=" + Pending // NOI18N
              + ", TopLevel=" + TopLevel // NOI18N
              + ", FirstChild=" + FirstChild // NOI18N
              + ", Prefix=" + Prefix // NOI18N
              + ", LastLocFilename=" + LastLocFilename // NOI18N
              + ", LastLocLine=" + LastLocLine // NOI18N
              + ", FC=" + FC // NOI18N
              + ", ShowColors=" + ShowColors // NOI18N
              + super.toString(); // NOI18N
  }
}
