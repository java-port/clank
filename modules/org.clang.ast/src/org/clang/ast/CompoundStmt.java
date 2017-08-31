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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;


/// CompoundStmt - This represents a group of statements like { stmt stmt }.
///
//<editor-fold defaultstate="collapsed" desc="clang::CompoundStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 551,
 FQN="clang::CompoundStmt", NM="_ZN5clang12CompoundStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang12CompoundStmtE")
//</editor-fold>
public class CompoundStmt extends /*public*/ Stmt {
  private type$ptr<Stmt /*P*/ /*P*/> Body;
  /*friend*/public SourceLocation LBraceLoc;
  /*friend*/public SourceLocation RBraceLoc;
  
  /*friend  class ASTStmtReader*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundStmt::CompoundStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*null pointer*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 282,
   FQN="clang::CompoundStmt::CompoundStmt", NM="_ZN5clang12CompoundStmtC1ERKNS_10ASTContextEN4llvm8ArrayRefIPNS_4StmtEEENS_14SourceLocationES9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang12CompoundStmtC1ERKNS_10ASTContextEN4llvm8ArrayRefIPNS_4StmtEEENS_14SourceLocationES9_")
  //</editor-fold>
  public CompoundStmt(final /*const*/ ASTContext /*&*/ C, ArrayRef<Stmt /*P*/ > Stmts, 
      SourceLocation LB, SourceLocation RB) {
    // : Stmt(CompoundStmtClass), LBraceLoc(LB), RBraceLoc(RB) 
    //START JInit
    super(StmtClass.CompoundStmtClass);
    this.LBraceLoc = new SourceLocation(LB);
    this.RBraceLoc = new SourceLocation(RB);
    //END JInit
    Unnamed_field.CompoundStmtBits.NumStmts = Stmts.size();
    assert (Unnamed_field.CompoundStmtBits.NumStmts == Stmts.size()) : "NumStmts doesn't fit in bits of CompoundStmtBits.NumStmts!";
    if (Stmts.size() == 0) {
      Body = create_const_type$const_ptr((Stmt /*P*/[])null); // JAVA
      return;
    }
    
    Body = create_const_type$ptr(/*NEW_EXPR [operator new[]] NM=_ZnajRKN5clang10ASTContextEj*/
    /*new (C)*/ /*FIXME 2: $array_new_uint_ASTContext$C_uint*/new Stmt /*P*/ [Stmts.size()]);
    std.copy(Stmts.begin(), Stmts.end(), Body);
  }

  
  // \brief Build an empty compound statement with a location.
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundStmt::CompoundStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*null pointer*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 562,
   FQN="clang::CompoundStmt::CompoundStmt", NM="_ZN5clang12CompoundStmtC1ENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang12CompoundStmtC1ENS_14SourceLocationE")
  //</editor-fold>
  public /*explicit*/ CompoundStmt(SourceLocation Loc) {
    // : Stmt(CompoundStmtClass), Body(null), LBraceLoc(Loc), RBraceLoc(Loc) 
    //START JInit
    super(StmtClass.CompoundStmtClass);
    this.Body = create_const_type$const_ptr((Stmt /*P*/[])null); // JAVA
    this.LBraceLoc = new SourceLocation(Loc);
    this.RBraceLoc = new SourceLocation(Loc);
    //END JInit
    Unnamed_field.CompoundStmtBits.NumStmts = 0;
  }

  
  // \brief Build an empty compound statement.
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundStmt::CompoundStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*null pointer*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 568,
   FQN="clang::CompoundStmt::CompoundStmt", NM="_ZN5clang12CompoundStmtC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang12CompoundStmtC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ CompoundStmt(EmptyShell Empty) {
    // : Stmt(CompoundStmtClass, Empty), Body(null), LBraceLoc(), RBraceLoc() 
    //START JInit
    super(StmtClass.CompoundStmtClass, new EmptyShell(Empty));
    this.Body = create_const_type$const_ptr((Stmt /*P*/[])null); // JAVA
    this.LBraceLoc = new SourceLocation();
    this.RBraceLoc = new SourceLocation();
    //END JInit
    Unnamed_field.CompoundStmtBits.NumStmts = 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundStmt::setStmts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 298,
   FQN="clang::CompoundStmt::setStmts", NM="_ZN5clang12CompoundStmt8setStmtsERKNS_10ASTContextEN4llvm8ArrayRefIPNS_4StmtEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang12CompoundStmt8setStmtsERKNS_10ASTContextEN4llvm8ArrayRefIPNS_4StmtEEE")
  //</editor-fold>
  public void setStmts(final /*const*/ ASTContext /*&*/ C, ArrayRef<Stmt /*P*/ > Stmts) {
    if (Native.$bool(Body)) {
      C.Deallocate(Body);
    }
    Unnamed_field.CompoundStmtBits.NumStmts = Stmts.size();
    assert (Unnamed_field.CompoundStmtBits.NumStmts == Stmts.size()) : "NumStmts doesn't fit in bits of CompoundStmtBits.NumStmts!";
    
    Body = create_const_type$ptr(/*NEW_EXPR [operator new[]] NM=_ZnajRKN5clang10ASTContextEj*/
      /*new (C)*/ /*FIXME 2: $array_new_uint_ASTContext$C_uint*/new Stmt /*P*/ [Stmts.size()]);    
    std.copy(Stmts.begin(), Stmts.end(), Body);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundStmt::body_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 575,
   FQN="clang::CompoundStmt::body_empty", NM="_ZNK5clang12CompoundStmt10body_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang12CompoundStmt10body_emptyEv")
  //</editor-fold>
  public boolean body_empty() /*const*/ {
    return Unnamed_field.CompoundStmtBits.NumStmts == $int2uint_24bits(0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompoundStmt::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 576,
   FQN="clang::CompoundStmt::size", NM="_ZNK5clang12CompoundStmt4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang12CompoundStmt4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return Unnamed_field.CompoundStmtBits.NumStmts;
  }

  
  /*typedef Stmt **body_iterator*/
//  public final class body_iterator extends type$ptr<Stmt /*P*/ /*P*/>{ };
  /*typedef llvm::iterator_range<body_iterator> body_range*/
//  public final class body_range extends iterator_range<Stmt /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundStmt::body">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 581,
   FQN="clang::CompoundStmt::body", NM="_ZN5clang12CompoundStmt4bodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang12CompoundStmt4bodyEv")
  //</editor-fold>
  public iterator_range<Stmt /*P*/ > body() {
    return new iterator_range<Stmt /*P*/ >(body_begin(), body_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompoundStmt::body_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 582,
   FQN="clang::CompoundStmt::body_begin", NM="_ZN5clang12CompoundStmt10body_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang12CompoundStmt10body_beginEv")
  //</editor-fold>
  public type$ptr<Stmt /*P*/ /*P*/> body_begin() {
    return Body;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompoundStmt::body_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 583,
   FQN="clang::CompoundStmt::body_end", NM="_ZN5clang12CompoundStmt8body_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang12CompoundStmt8body_endEv")
  //</editor-fold>
  public type$ptr<Stmt /*P*/ /*P*/> body_end() {
    return Body.$add(size());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompoundStmt::body_front">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 584,
   FQN="clang::CompoundStmt::body_front", NM="_ZN5clang12CompoundStmt10body_frontEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang12CompoundStmt10body_frontEv")
  //</editor-fold>
  public Stmt /*P*/ body_front() {
    return !body_empty() ? Body.$at(0) : null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompoundStmt::body_back">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 585,
   FQN="clang::CompoundStmt::body_back", NM="_ZN5clang12CompoundStmt9body_backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang12CompoundStmt9body_backEv")
  //</editor-fold>
  public Stmt /*P*/ body_back() {
    return !body_empty() ? Body.$at(size() - 1) : null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundStmt::setLastStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 587,
   FQN="clang::CompoundStmt::setLastStmt", NM="_ZN5clang12CompoundStmt11setLastStmtEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang12CompoundStmt11setLastStmtEPNS_4StmtE")
  //</editor-fold>
  public void setLastStmt(Stmt /*P*/ S) {
    assert (!body_empty()) : "setLastStmt";
    Body.$set(size() - 1, S);
  }

  
  /*typedef Stmt *const *const_body_iterator*/
//  public final class const_body_iterator extends type$ptr<Stmt /*P*/ /*const*/ /*P*/>{ };
  /*typedef llvm::iterator_range<const_body_iterator> body_const_range*/
//  public final class body_const_range extends iterator_range<Stmt /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundStmt::body">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 595,
   FQN="clang::CompoundStmt::body", NM="_ZNK5clang12CompoundStmt4bodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang12CompoundStmt4bodyEv")
  //</editor-fold>
  public iterator_range<Stmt /*P*/ /*const*/> body$Const() /*const*/ {
    return new iterator_range<Stmt /*P*/ /*const*/>(body_begin$Const(), body_end$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompoundStmt::body_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 598,
   FQN="clang::CompoundStmt::body_begin", NM="_ZNK5clang12CompoundStmt10body_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang12CompoundStmt10body_beginEv")
  //</editor-fold>
  public type$ptr<Stmt /*P*/ /*const*/ /*P*/> body_begin$Const() /*const*/ {
    return Body;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompoundStmt::body_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 599,
   FQN="clang::CompoundStmt::body_end", NM="_ZNK5clang12CompoundStmt8body_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang12CompoundStmt8body_endEv")
  //</editor-fold>
  public type$ptr<Stmt /*P*/ /*const*/ /*P*/> body_end$Const() /*const*/ {
    return Body.$add(size());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompoundStmt::body_front">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 600,
   FQN="clang::CompoundStmt::body_front", NM="_ZNK5clang12CompoundStmt10body_frontEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang12CompoundStmt10body_frontEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ body_front$Const() /*const*/ {
    return !body_empty() ? Body.$at(0) : null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompoundStmt::body_back">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 603,
   FQN="clang::CompoundStmt::body_back", NM="_ZNK5clang12CompoundStmt9body_backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang12CompoundStmt9body_backEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ body_back$Const() /*const*/ {
    return !body_empty() ? Body.$at(size() - 1) : null;
  }

  
  /*typedef std::reverse_iterator<body_iterator> reverse_body_iterator*/
//  public final class reverse_body_iterator extends std.reverse_iterator<Stmt /*P*/ >{ };
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundStmt::body_rbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 608,
   FQN="clang::CompoundStmt::body_rbegin", NM="_ZN5clang12CompoundStmt11body_rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang12CompoundStmt11body_rbeginEv")
  //</editor-fold>
  public std.reverse_iterator<Stmt /*P*/ > body_rbegin() {
    return new std.reverse_iterator<Stmt /*P*/ >(body_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompoundStmt::body_rend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 611,
   FQN="clang::CompoundStmt::body_rend", NM="_ZN5clang12CompoundStmt9body_rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang12CompoundStmt9body_rendEv")
  //</editor-fold>
  public std.reverse_iterator<Stmt /*P*/ > body_rend() {
    return new std.reverse_iterator<Stmt /*P*/ >(body_begin());
  }

  
  /*typedef std::reverse_iterator<const_body_iterator> const_reverse_body_iterator*/
//  public final class const_reverse_body_iterator extends std.reverse_iterator<Stmt /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundStmt::body_rbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 618,
   FQN="clang::CompoundStmt::body_rbegin", NM="_ZNK5clang12CompoundStmt11body_rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang12CompoundStmt11body_rbeginEv")
  //</editor-fold>
  public std.reverse_iterator<Stmt /*P*/ /*const*/> body_rbegin$Const() /*const*/ {
    return new std.reverse_iterator<Stmt /*P*/ /*const*/>(body_end$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundStmt::body_rend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 622,
   FQN="clang::CompoundStmt::body_rend", NM="_ZNK5clang12CompoundStmt9body_rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang12CompoundStmt9body_rendEv")
  //</editor-fold>
  public std.reverse_iterator<Stmt /*P*/ /*const*/> body_rend$Const() /*const*/ {
    return new std.reverse_iterator<Stmt /*P*/ /*const*/>(body_begin$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 626,
   FQN="clang::CompoundStmt::getLocStart", NM="_ZNK5clang12CompoundStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang12CompoundStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(LBraceLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompoundStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 627,
   FQN="clang::CompoundStmt::getLocEnd", NM="_ZNK5clang12CompoundStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang12CompoundStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(RBraceLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundStmt::getLBracLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 629,
   FQN="clang::CompoundStmt::getLBracLoc", NM="_ZNK5clang12CompoundStmt11getLBracLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang12CompoundStmt11getLBracLocEv")
  //</editor-fold>
  public SourceLocation getLBracLoc() /*const*/ {
    return new SourceLocation(LBraceLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompoundStmt::getRBracLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 630,
   FQN="clang::CompoundStmt::getRBracLoc", NM="_ZNK5clang12CompoundStmt11getRBracLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang12CompoundStmt11getRBracLocEv")
  //</editor-fold>
  public SourceLocation getRBracLoc() /*const*/ {
    return new SourceLocation(RBraceLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 632,
   FQN="clang::CompoundStmt::classof", NM="_ZN5clang12CompoundStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang12CompoundStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CompoundStmtClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundStmt::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 637,
   FQN="clang::CompoundStmt::children", NM="_ZN5clang12CompoundStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang12CompoundStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(Body), new StmtIterator(Body.$add(Unnamed_field.CompoundStmtBits.NumStmts)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompoundStmt::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 641,
   FQN="clang::CompoundStmt::children", NM="_ZNK5clang12CompoundStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang12CompoundStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children$Const() /*const*/ {
    return new iterator_range<Stmt/*P*/>(new ConstStmtIterator(new StmtIterator(Body)), 
        new ConstStmtIterator(new StmtIterator(Body.$add(Unnamed_field.CompoundStmtBits.NumStmts))));
  }

  
  @Override public String toString() {
    return "" + "Body=" + Body // NOI18N
              + ", LBraceLoc=" + LBraceLoc // NOI18N
              + ", RBraceLoc=" + RBraceLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
