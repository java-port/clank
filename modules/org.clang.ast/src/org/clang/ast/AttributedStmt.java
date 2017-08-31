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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstSizeofAndAlignment.*;


/// \brief Represents an attribute applied to a statement.
///
/// Represents an attribute applied to a statement. For example:
///   [[omp::for(...)]] for (...) { ... }
///
//<editor-fold defaultstate="collapsed" desc="clang::AttributedStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 830,
 FQN="clang::AttributedStmt", NM="_ZN5clang14AttributedStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang14AttributedStmtE")
//</editor-fold>
public class AttributedStmt extends /*public*/ Stmt {
  /*friend*/public Stmt /*P*/ SubStmt;
  /*friend*/public SourceLocation AttrLoc;
  /*friend*/public /*uint*/int NumAttrs;
  
  /*friend  class ASTStmtReader*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedStmt::AttributedStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 837,
   FQN="clang::AttributedStmt::AttributedStmt", NM="_ZN5clang14AttributedStmtC1ENS_14SourceLocationEN4llvm8ArrayRefIPKNS_4AttrEEEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang14AttributedStmtC1ENS_14SourceLocationEN4llvm8ArrayRefIPKNS_4AttrEEEPNS_4StmtE")
  //</editor-fold>
  private AttributedStmt(SourceLocation Loc, ArrayRef</*const*/ Attr /*P*/ > Attrs, Stmt /*P*/ SubStmt) {
    // : Stmt(AttributedStmtClass), SubStmt(SubStmt), AttrLoc(Loc), NumAttrs(Attrs.size()) 
    //START JInit
    super(StmtClass.AttributedStmtClass);
    this.SubStmt = SubStmt;
    this.AttrLoc = new SourceLocation(Loc);
    this.NumAttrs = Attrs.size();
    $Attrs = create_const_type$ptr(new Attr[Attrs.size()]);
    //END JInit
    std.copy(Attrs.begin(), Attrs.end(), getAttrArrayPtr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedStmt::AttributedStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 843,
   FQN="clang::AttributedStmt::AttributedStmt", NM="_ZN5clang14AttributedStmtC1ENS_4Stmt10EmptyShellEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang14AttributedStmtC1ENS_4Stmt10EmptyShellEj")
  //</editor-fold>
  private /*explicit*/ AttributedStmt(EmptyShell Empty, /*uint*/int NumAttrs) {
    // : Stmt(AttributedStmtClass, Empty), AttrLoc(), NumAttrs(NumAttrs) 
    //START JInit
    super(StmtClass.AttributedStmtClass, new EmptyShell(Empty));
    this.AttrLoc = new SourceLocation();
    this.NumAttrs = NumAttrs;
    $Attrs = create_const_type$ptr(new Attr[NumAttrs]);
    //END JInit
    std.fill_n(getAttrArrayPtr(), NumAttrs, null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedStmt::getAttrArrayPtr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 848,
   FQN="clang::AttributedStmt::getAttrArrayPtr", NM="_ZNK5clang14AttributedStmt15getAttrArrayPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang14AttributedStmt15getAttrArrayPtrEv")
  //</editor-fold>
  private type$ptr</*const*/ Attr /*P*/ /*const*/ /*P*/> getAttrArrayPtr$Const() /*const*/ {
    return $Attrs;//((type$ptr</*const*/ Attr /*P*/ /*const*/ /*P*/>)reinterpret_cast(type$ptr.class, this + 1));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributedStmt::getAttrArrayPtr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 851,
   FQN="clang::AttributedStmt::getAttrArrayPtr", NM="_ZN5clang14AttributedStmt15getAttrArrayPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang14AttributedStmt15getAttrArrayPtrEv")
  //</editor-fold>
  /*friend*/public type$ptr</*const*/ Attr /*P*/ /*P*/> getAttrArrayPtr() {
    return $Attrs;//((type$ptr</*const*/ Attr /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, this + 1));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedStmt::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 313,
   FQN="clang::AttributedStmt::Create", NM="_ZN5clang14AttributedStmt6CreateERKNS_10ASTContextENS_14SourceLocationEN4llvm8ArrayRefIPKNS_4AttrEEEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang14AttributedStmt6CreateERKNS_10ASTContextENS_14SourceLocationEN4llvm8ArrayRefIPKNS_4AttrEEEPNS_4StmtE")
  //</editor-fold>
  public static AttributedStmt /*P*/ Create(final /*const*/ ASTContext /*&*/ C, SourceLocation Loc, 
        ArrayRef</*const*/ Attr /*P*/ > Attrs, 
        Stmt /*P*/ SubStmt) {
    assert (!Attrs.empty()) : "Attrs should not be empty";
    Object/*void P*/ _Mem;
    if (false) {
      _Mem = C.Allocate($sizeof_AttributedStmt() + $sizeof_ptr(/*Attr  */) * Attrs.size(), 
          alignOf(AttributedStmt.class));
    } else {
      _Mem = C.Allocate$JavaRef(/*$sizeof_AttributedStmt()*/1 + /*$sizeof_ptr(Attr)*/1 * Attrs.size(), 
          alignOf(AttributedStmt.class));
    }
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(_Mem, (type$ptr<?> Mem)->{
        return new AttributedStmt(new SourceLocation(Loc), new ArrayRef</*const*/ Attr /*P*/ >(Attrs), SubStmt);
     });
  }

  // \brief Build an empty attributed statement.
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedStmt::CreateEmpty">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 322,
   FQN="clang::AttributedStmt::CreateEmpty", NM="_ZN5clang14AttributedStmt11CreateEmptyERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang14AttributedStmt11CreateEmptyERKNS_10ASTContextEj")
  //</editor-fold>
  public static AttributedStmt /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, 
             /*uint*/int NumAttrs) {
    assert ($greater_uint(NumAttrs, 0)) : "NumAttrs should be greater than zero";
    Object/*void P*/ _Mem;
    if (false) {
      _Mem = C.Allocate($sizeof_AttributedStmt() + $sizeof_ptr(/*Attr  */) * NumAttrs, 
          alignOf(AttributedStmt.class));
    } else {
      _Mem = C.Allocate$JavaRef(/*$sizeof_AttributedStmt()*/1 + /*$sizeof_ptr(Attr)*/1 * NumAttrs, 
          alignOf(AttributedStmt.class));
    }
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(_Mem, (type$ptr<?> Mem)->{
        return new AttributedStmt(new EmptyShell(), NumAttrs);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedStmt::getAttrLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 861,
   FQN="clang::AttributedStmt::getAttrLoc", NM="_ZNK5clang14AttributedStmt10getAttrLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang14AttributedStmt10getAttrLocEv")
  //</editor-fold>
  public SourceLocation getAttrLoc() /*const*/ {
    return new SourceLocation(AttrLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributedStmt::getAttrs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 862,
   FQN="clang::AttributedStmt::getAttrs", NM="_ZNK5clang14AttributedStmt8getAttrsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang14AttributedStmt8getAttrsEv")
  //</editor-fold>
  public ArrayRef</*const*/ Attr /*P*/ > getAttrs() /*const*/ {
    return llvm.makeArrayRef(getAttrArrayPtr$Const(), NumAttrs);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributedStmt::getSubStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 865,
   FQN="clang::AttributedStmt::getSubStmt", NM="_ZN5clang14AttributedStmt10getSubStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang14AttributedStmt10getSubStmtEv")
  //</editor-fold>
  public Stmt /*P*/ getSubStmt() {
    return SubStmt;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributedStmt::getSubStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 866,
   FQN="clang::AttributedStmt::getSubStmt", NM="_ZNK5clang14AttributedStmt10getSubStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang14AttributedStmt10getSubStmtEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getSubStmt$Const() /*const*/ {
    return SubStmt;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 868,
   FQN="clang::AttributedStmt::getLocStart", NM="_ZNK5clang14AttributedStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang14AttributedStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(AttrLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributedStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 869,
   FQN="clang::AttributedStmt::getLocEnd", NM="_ZNK5clang14AttributedStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang14AttributedStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return SubStmt.getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedStmt::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 871,
   FQN="clang::AttributedStmt::children", NM="_ZN5clang14AttributedStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang14AttributedStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(SubStmt))), new StmtIterator(create_type$ptr($AddrOf(SubStmt)).$add(1)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 873,
   FQN="clang::AttributedStmt::classof", NM="_ZN5clang14AttributedStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang14AttributedStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.AttributedStmtClass;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private type$ptr</*const*/ Attr /*P*/ /*const*/ /*P*/> $Attrs;

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "SubStmt=" + SubStmt // NOI18N
              + ", AttrLoc=" + AttrLoc // NOI18N
              + ", NumAttrs=" + NumAttrs // NOI18N
              + super.toString(); // NOI18N
  }
}
