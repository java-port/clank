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

package org.clang.ast;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// DeclStmt - Adaptor class for mixing declarations with statements and
/// expressions. For example, CompoundStmt mixes statements, expressions
/// and declarations (variables, types). Another example is ForStmt, where
/// the first statement can be an expression or a declaration.
///
//<editor-fold defaultstate="collapsed" desc="clang::DeclStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 443,
 FQN="clang::DeclStmt", NM="_ZN5clang8DeclStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8DeclStmtE")
//</editor-fold>
public class DeclStmt extends /*public*/ Stmt {
  private DeclGroupRef DG;
  private SourceLocation StartLoc;
  private SourceLocation EndLoc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DeclStmt::DeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 448,
   FQN="clang::DeclStmt::DeclStmt", NM="_ZN5clang8DeclStmtC1ENS_12DeclGroupRefENS_14SourceLocationES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8DeclStmtC1ENS_12DeclGroupRefENS_14SourceLocationES2_")
  //</editor-fold>
  public DeclStmt(DeclGroupRef dg, SourceLocation startLoc, 
      SourceLocation endLoc) {
    // : Stmt(DeclStmtClass), DG(dg), StartLoc(startLoc), EndLoc(endLoc) 
    //START JInit
    super(StmtClass.DeclStmtClass);
    this.DG = new DeclGroupRef(dg);
    this.StartLoc = new SourceLocation(startLoc);
    this.EndLoc = new SourceLocation(endLoc);
    //END JInit
  }

  
  /// \brief Build an empty declaration statement.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclStmt::DeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 453,
   FQN="clang::DeclStmt::DeclStmt", NM="_ZN5clang8DeclStmtC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8DeclStmtC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ DeclStmt(EmptyShell Empty) {
    // : Stmt(DeclStmtClass, Empty), DG(), StartLoc(), EndLoc() 
    //START JInit
    super(StmtClass.DeclStmtClass, new EmptyShell(Empty));
    this.DG = new DeclGroupRef();
    this.StartLoc = new SourceLocation();
    this.EndLoc = new SourceLocation();
    //END JInit
  }

  
  /// isSingleDecl - This method returns true if this DeclStmt refers
  /// to a single Decl.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclStmt::isSingleDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 457,
   FQN="clang::DeclStmt::isSingleDecl", NM="_ZNK5clang8DeclStmt12isSingleDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang8DeclStmt12isSingleDeclEv")
  //</editor-fold>
  public boolean isSingleDecl() /*const*/ {
    return DG.isSingleDecl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclStmt::getSingleDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 461,
   FQN="clang::DeclStmt::getSingleDecl", NM="_ZNK5clang8DeclStmt13getSingleDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang8DeclStmt13getSingleDeclEv")
  //</editor-fold>
  public /*const*/ Decl /*P*/ getSingleDecl$Const() /*const*/ {
    return DG.getSingleDecl$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclStmt::getSingleDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 462,
   FQN="clang::DeclStmt::getSingleDecl", NM="_ZN5clang8DeclStmt13getSingleDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8DeclStmt13getSingleDeclEv")
  //</editor-fold>
  public Decl /*P*/ getSingleDecl() {
    return DG.getSingleDecl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclStmt::getDeclGroup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 464,
   FQN="clang::DeclStmt::getDeclGroup", NM="_ZNK5clang8DeclStmt12getDeclGroupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang8DeclStmt12getDeclGroupEv")
  //</editor-fold>
  public /*const*/ DeclGroupRef getDeclGroup$Const() /*const*/ {
    return new DeclGroupRef(DG);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclStmt::getDeclGroup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 465,
   FQN="clang::DeclStmt::getDeclGroup", NM="_ZN5clang8DeclStmt12getDeclGroupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8DeclStmt12getDeclGroupEv")
  //</editor-fold>
  public DeclGroupRef getDeclGroup() {
    return new DeclGroupRef(DG);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclStmt::setDeclGroup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 466,
   FQN="clang::DeclStmt::setDeclGroup", NM="_ZN5clang8DeclStmt12setDeclGroupENS_12DeclGroupRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8DeclStmt12setDeclGroupENS_12DeclGroupRefE")
  //</editor-fold>
  public void setDeclGroup(DeclGroupRef DGR) {
    DG.$assign(DGR);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclStmt::getStartLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 468,
   FQN="clang::DeclStmt::getStartLoc", NM="_ZNK5clang8DeclStmt11getStartLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang8DeclStmt11getStartLocEv")
  //</editor-fold>
  public SourceLocation getStartLoc() /*const*/ {
    return new SourceLocation(StartLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclStmt::setStartLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 469,
   FQN="clang::DeclStmt::setStartLoc", NM="_ZN5clang8DeclStmt11setStartLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8DeclStmt11setStartLocENS_14SourceLocationE")
  //</editor-fold>
  public void setStartLoc(SourceLocation L) {
    StartLoc.$assign(L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclStmt::getEndLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 470,
   FQN="clang::DeclStmt::getEndLoc", NM="_ZNK5clang8DeclStmt9getEndLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang8DeclStmt9getEndLocEv")
  //</editor-fold>
  public SourceLocation getEndLoc() /*const*/ {
    return new SourceLocation(EndLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclStmt::setEndLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 471,
   FQN="clang::DeclStmt::setEndLoc", NM="_ZN5clang8DeclStmt9setEndLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8DeclStmt9setEndLocENS_14SourceLocationE")
  //</editor-fold>
  public void setEndLoc(SourceLocation L) {
    EndLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 473,
   FQN="clang::DeclStmt::getLocStart", NM="_ZNK5clang8DeclStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang8DeclStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(StartLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 474,
   FQN="clang::DeclStmt::getLocEnd", NM="_ZNK5clang8DeclStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang8DeclStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(EndLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 476,
   FQN="clang::DeclStmt::classof", NM="_ZN5clang8DeclStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8DeclStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.DeclStmtClass;
  }

  
  // Iterators over subexpressions.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclStmt::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 481,
   FQN="clang::DeclStmt::children", NM="_ZN5clang8DeclStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8DeclStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(DG.begin(), DG.end()), 
        new StmtIterator(DG.end(), DG.end()));
  }

  
  /*typedef DeclGroupRef::iterator decl_iterator*/
//  public final class decl_iterator extends type$ptr<Decl/*P*/>/*iterator*/{ };
  /*typedef DeclGroupRef::const_iterator const_decl_iterator*/
//  public final class const_decl_iterator extends type$ptr<Decl/*P*/>/*iterator*/{ };
  /*typedef llvm::iterator_range<decl_iterator> decl_range*/
//  public final class decl_range extends iterator_range<Decl /*P*/ >{ };
  /*typedef llvm::iterator_range<const_decl_iterator> decl_const_range*/
//  public final class decl_const_range extends iterator_range<Decl /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclStmt::decls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 491,
   FQN="clang::DeclStmt::decls", NM="_ZN5clang8DeclStmt5declsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8DeclStmt5declsEv")
  //</editor-fold>
  public iterator_range<Decl /*P*/ > decls() {
    return new iterator_range<Decl /*P*/ >(decl_begin(), decl_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclStmt::decls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 492,
   FQN="clang::DeclStmt::decls", NM="_ZNK5clang8DeclStmt5declsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang8DeclStmt5declsEv")
  //</editor-fold>
  public iterator_range<Decl /*P*/ /*const*/> decls$Const() /*const*/ {
    return new iterator_range<Decl /*P*/ /*const*/>(decl_begin$Const(), decl_end$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclStmt::decl_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 495,
   FQN="clang::DeclStmt::decl_begin", NM="_ZN5clang8DeclStmt10decl_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8DeclStmt10decl_beginEv")
  //</editor-fold>
  public type$ptr<Decl/*P*/>/*iterator*/ decl_begin() {
    return DG.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclStmt::decl_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 496,
   FQN="clang::DeclStmt::decl_end", NM="_ZN5clang8DeclStmt8decl_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8DeclStmt8decl_endEv")
  //</editor-fold>
  public type$ptr<Decl/*P*/>/*iterator*/ decl_end() {
    return DG.end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclStmt::decl_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 497,
   FQN="clang::DeclStmt::decl_begin", NM="_ZNK5clang8DeclStmt10decl_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang8DeclStmt10decl_beginEv")
  //</editor-fold>
  public type$ptr<Decl/*P*/>/*iterator*/ decl_begin$Const() /*const*/ {
    return DG.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclStmt::decl_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 498,
   FQN="clang::DeclStmt::decl_end", NM="_ZNK5clang8DeclStmt8decl_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang8DeclStmt8decl_endEv")
  //</editor-fold>
  public type$ptr<Decl/*P*/>/*iterator*/ decl_end$Const() /*const*/ {
    return DG.end$Const();
  }

  
  /*typedef std::reverse_iterator<decl_iterator> reverse_decl_iterator*/
//  public final class reverse_decl_iterator extends std.reverse_iterator<Decl /*P*/ >{ };
  //<editor-fold defaultstate="collapsed" desc="clang::DeclStmt::decl_rbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 501,
   FQN="clang::DeclStmt::decl_rbegin", NM="_ZN5clang8DeclStmt11decl_rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8DeclStmt11decl_rbeginEv")
  //</editor-fold>
  public std.reverse_iterator<Decl /*P*/ > decl_rbegin() {
    return new std.reverse_iterator<Decl /*P*/ >(decl_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclStmt::decl_rend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 504,
   FQN="clang::DeclStmt::decl_rend", NM="_ZN5clang8DeclStmt9decl_rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang8DeclStmt9decl_rendEv")
  //</editor-fold>
  public std.reverse_iterator<Decl /*P*/ > decl_rend() {
    return new std.reverse_iterator<Decl /*P*/ >(decl_begin());
  }

  
  @Override public String toString() {
    return "" + "DG=" + DG // NOI18N
              + ", StartLoc=" + StartLoc // NOI18N
              + ", EndLoc=" + EndLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
