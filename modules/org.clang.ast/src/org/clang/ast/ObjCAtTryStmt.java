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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstSizeofAndAlignment.*;


/// \brief Represents Objective-C's \@try ... \@catch ... \@finally statement.
//<editor-fold defaultstate="collapsed" desc="clang::ObjCAtTryStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 154,
 FQN="clang::ObjCAtTryStmt", NM="_ZN5clang13ObjCAtTryStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang13ObjCAtTryStmtE")
//</editor-fold>
public class ObjCAtTryStmt extends /*public*/ Stmt {
/*private:*/
  // The location of the @ in the \@try.
  private SourceLocation AtTryLoc;
  
  // The number of catch blocks in this statement.
  private /*JCHAR unsigned int*/ char NumCatchStmts /*: 16*/;
  
  // Whether this statement has a \@finally statement.
  private /*JBIT bool*/ boolean HasFinally /*: 1*/;
  
  /// \brief Retrieve the statements that are stored after this \@try statement.
  ///
  /// The order of the statements in memory follows the order in the source,
  /// with the \@try body first, followed by the \@catch statements (if any)
  /// and, finally, the \@finally (if it exists).
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtTryStmt::getStmts">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 170,
   FQN="clang::ObjCAtTryStmt::getStmts", NM="_ZN5clang13ObjCAtTryStmt8getStmtsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang13ObjCAtTryStmt8getStmtsEv")
  //</editor-fold>
  private type$ptr<Stmt /*P*/ /*P*/> getStmts() {
    return $Stmts;//((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, this + 1));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtTryStmt::getStmts">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 171,
   FQN="clang::ObjCAtTryStmt::getStmts", NM="_ZNK5clang13ObjCAtTryStmt8getStmtsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang13ObjCAtTryStmt8getStmtsEv")
  //</editor-fold>
  private type$ptr</*const*/ Stmt /*P*/ /*const*/ /*P*/> getStmts$Const() /*const*/ {
    return $Stmts;//((type$ptr</*const*/ Stmt /*P*/ /*const*/ /*P*/>)reinterpret_cast(type$ptr.class, this + 1));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtTryStmt::ObjCAtTryStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp", line = 32,
   FQN="clang::ObjCAtTryStmt::ObjCAtTryStmt", NM="_ZN5clang13ObjCAtTryStmtC1ENS_14SourceLocationEPNS_4StmtEPS3_jS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang13ObjCAtTryStmtC1ENS_14SourceLocationEPNS_4StmtEPS3_jS3_")
  //</editor-fold>
  private ObjCAtTryStmt(SourceLocation atTryLoc, Stmt /*P*/ atTryStmt, 
      type$ptr<Stmt /*P*/ /*P*/> CatchStmts, /*uint*/int NumCatchStmts, 
      Stmt /*P*/ atFinallyStmt) {
    // : Stmt(ObjCAtTryStmtClass), AtTryLoc(atTryLoc), NumCatchStmts(NumCatchStmts), HasFinally(atFinallyStmt != null) 
    //START JInit
    super(StmtClass.ObjCAtTryStmtClass);
    this.AtTryLoc = new SourceLocation(atTryLoc);
    this.NumCatchStmts = $uint2uint_16bits(NumCatchStmts);
    this.HasFinally = atFinallyStmt != null;
    this.$Stmts = create_const_type$ptr(new Stmt[1 + NumCatchStmts + (HasFinally ? 1 : 0)]);
    //END JInit
    type$ptr<Stmt /*P*/ /*P*/> Stmts = $tryClone(getStmts());
    Stmts.$set(0, atTryStmt);
    for (/*uint*/int I = 0; I != NumCatchStmts; ++I)  {
      Stmts.$set(I + 1, CatchStmts.$at(I));
    }
    if (HasFinally) {
      Stmts.$set(NumCatchStmts + 1, atFinallyStmt);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtTryStmt::ObjCAtTryStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 179,
   FQN="clang::ObjCAtTryStmt::ObjCAtTryStmt", NM="_ZN5clang13ObjCAtTryStmtC1ENS_4Stmt10EmptyShellEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang13ObjCAtTryStmtC1ENS_4Stmt10EmptyShellEjb")
  //</editor-fold>
  private /*explicit*/ ObjCAtTryStmt(EmptyShell Empty, /*uint*/int NumCatchStmts, 
      boolean HasFinally) {
    // : Stmt(ObjCAtTryStmtClass, Empty), AtTryLoc(), NumCatchStmts(NumCatchStmts), HasFinally(HasFinally) 
    //START JInit
    super(StmtClass.ObjCAtTryStmtClass, new EmptyShell(Empty));
    this.AtTryLoc = new SourceLocation();
    this.NumCatchStmts = $uint2uint_16bits(NumCatchStmts);
    this.HasFinally = HasFinally;
    this.$Stmts = create_const_type$ptr(new Stmt[1 + NumCatchStmts + (HasFinally ? 1 : 0)]);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtTryStmt::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp", line = 46,
   FQN="clang::ObjCAtTryStmt::Create", NM="_ZN5clang13ObjCAtTryStmt6CreateERKNS_10ASTContextENS_14SourceLocationEPNS_4StmtEPS6_jS6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang13ObjCAtTryStmt6CreateERKNS_10ASTContextENS_14SourceLocationEPNS_4StmtEPS6_jS6_")
  //</editor-fold>
  public static ObjCAtTryStmt /*P*/ Create(final /*const*/ ASTContext /*&*/ Context, 
        SourceLocation atTryLoc, Stmt /*P*/ atTryStmt, 
        type$ptr<Stmt /*P*/ /*P*/> CatchStmts, /*uint*/int NumCatchStmts, 
        Stmt /*P*/ atFinallyStmt) {
    Object/*void P*/ _Mem;
    if (false) {
      /*uint*/int Size = $sizeof_ObjCAtTryStmt()
       + (1 + NumCatchStmts + ((atFinallyStmt != null) ? 1 : 0)) * $sizeof_ptr(/*Stmt  */);
      _Mem = Context.Allocate(Size, alignOf(ObjCAtTryStmt.class));
    } else {
      /*uint*/int Size = /*$sizeof_ObjCAtTryStmt()*/ 1
       + (1 + NumCatchStmts + ((atFinallyStmt != null) ? 1 : 0)) * /*$sizeof_ptr(Stmt *)*/ 1;
      _Mem = Context.Allocate$JavaRef(Size, alignOf(ObjCAtTryStmt.class));
    }
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(_Mem, (type$ptr<?> Mem)->{
        return new ObjCAtTryStmt(new SourceLocation(atTryLoc), atTryStmt, CatchStmts, NumCatchStmts, 
                atFinallyStmt);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtTryStmt::CreateEmpty">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp", line = 58,
   FQN="clang::ObjCAtTryStmt::CreateEmpty", NM="_ZN5clang13ObjCAtTryStmt11CreateEmptyERKNS_10ASTContextEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang13ObjCAtTryStmt11CreateEmptyERKNS_10ASTContextEjb")
  //</editor-fold>
  public static ObjCAtTryStmt /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ Context, 
             /*uint*/int NumCatchStmts, 
             boolean HasFinally) {
    Object/*void P*/ _Mem;
    if (false) {
      /*uint*/int Size = $sizeof_ObjCAtTryStmt() + (1 + NumCatchStmts + (HasFinally ? 1 : 0)) * $sizeof_ptr(/*Stmt  */);
      _Mem = Context.Allocate(Size, alignOf(ObjCAtTryStmt.class));
    } else {
      /*uint*/int Size = /*$sizeof_ObjCAtTryStmt()*/1 + (1 + NumCatchStmts + (HasFinally ? 1 : 0)) * /*$sizeof_ptr(Stmt *)*/ 1;
      _Mem = Context.Allocate$JavaRef(Size, alignOf(ObjCAtTryStmt.class));
    }
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(_Mem, (type$ptr<?> Mem)->{
        return new ObjCAtTryStmt(new EmptyShell(), NumCatchStmts, HasFinally);
     });
  }

  
  /// \brief Retrieve the location of the @ in the \@try.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtTryStmt::getAtTryLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 193,
   FQN="clang::ObjCAtTryStmt::getAtTryLoc", NM="_ZNK5clang13ObjCAtTryStmt11getAtTryLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang13ObjCAtTryStmt11getAtTryLocEv")
  //</editor-fold>
  public SourceLocation getAtTryLoc() /*const*/ {
    return new SourceLocation(AtTryLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtTryStmt::setAtTryLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 194,
   FQN="clang::ObjCAtTryStmt::setAtTryLoc", NM="_ZN5clang13ObjCAtTryStmt11setAtTryLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang13ObjCAtTryStmt11setAtTryLocENS_14SourceLocationE")
  //</editor-fold>
  public void setAtTryLoc(SourceLocation Loc) {
    AtTryLoc.$assign(Loc);
  }

  
  /// \brief Retrieve the \@try body.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtTryStmt::getTryBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 197,
   FQN="clang::ObjCAtTryStmt::getTryBody", NM="_ZNK5clang13ObjCAtTryStmt10getTryBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang13ObjCAtTryStmt10getTryBodyEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getTryBody$Const() /*const*/ {
    return getStmts$Const().$at(0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtTryStmt::getTryBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 198,
   FQN="clang::ObjCAtTryStmt::getTryBody", NM="_ZN5clang13ObjCAtTryStmt10getTryBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang13ObjCAtTryStmt10getTryBodyEv")
  //</editor-fold>
  public Stmt /*P*/ getTryBody() {
    return getStmts().$at(0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtTryStmt::setTryBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 199,
   FQN="clang::ObjCAtTryStmt::setTryBody", NM="_ZN5clang13ObjCAtTryStmt10setTryBodyEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang13ObjCAtTryStmt10setTryBodyEPNS_4StmtE")
  //</editor-fold>
  public void setTryBody(Stmt /*P*/ S) {
    getStmts().$set(0, S);
  }

  
  /// \brief Retrieve the number of \@catch statements in this try-catch-finally
  /// block.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtTryStmt::getNumCatchStmts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 203,
   FQN="clang::ObjCAtTryStmt::getNumCatchStmts", NM="_ZNK5clang13ObjCAtTryStmt16getNumCatchStmtsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang13ObjCAtTryStmt16getNumCatchStmtsEv")
  //</editor-fold>
  public /*uint*/int getNumCatchStmts() /*const*/ {
    return NumCatchStmts;
  }

  
  /// \brief Retrieve a \@catch statement.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtTryStmt::getCatchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 206,
   FQN="clang::ObjCAtTryStmt::getCatchStmt", NM="_ZNK5clang13ObjCAtTryStmt12getCatchStmtEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang13ObjCAtTryStmt12getCatchStmtEj")
  //</editor-fold>
  public /*const*/ ObjCAtCatchStmt /*P*/ getCatchStmt$Const(/*uint*/int I) /*const*/ {
    assert ($less_uint(I, NumCatchStmts)) : "Out-of-bounds @catch index";
    return cast_or_null_ObjCAtCatchStmt(getStmts$Const().$at(I + 1));
  }

  
  /// \brief Retrieve a \@catch statement.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtTryStmt::getCatchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 212,
   FQN="clang::ObjCAtTryStmt::getCatchStmt", NM="_ZN5clang13ObjCAtTryStmt12getCatchStmtEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang13ObjCAtTryStmt12getCatchStmtEj")
  //</editor-fold>
  public ObjCAtCatchStmt /*P*/ getCatchStmt(/*uint*/int I) {
    assert ($less_uint(I, NumCatchStmts)) : "Out-of-bounds @catch index";
    return cast_or_null_ObjCAtCatchStmt(getStmts().$at(I + 1));
  }

  
  /// \brief Set a particular catch statement.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtTryStmt::setCatchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 218,
   FQN="clang::ObjCAtTryStmt::setCatchStmt", NM="_ZN5clang13ObjCAtTryStmt12setCatchStmtEjPNS_15ObjCAtCatchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang13ObjCAtTryStmt12setCatchStmtEjPNS_15ObjCAtCatchStmtE")
  //</editor-fold>
  public void setCatchStmt(/*uint*/int I, ObjCAtCatchStmt /*P*/ S) {
    assert ($less_uint(I, NumCatchStmts)) : "Out-of-bounds @catch index";
    getStmts().$set(I + 1, S);
  }

  
  /// \brief Retrieve the \@finally statement, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtTryStmt::getFinallyStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 224,
   FQN="clang::ObjCAtTryStmt::getFinallyStmt", NM="_ZNK5clang13ObjCAtTryStmt14getFinallyStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang13ObjCAtTryStmt14getFinallyStmtEv")
  //</editor-fold>
  public /*const*/ ObjCAtFinallyStmt /*P*/ getFinallyStmt$Const() /*const*/ {
    if (!HasFinally) {
      return null;
    }
    
    return cast_or_null_ObjCAtFinallyStmt(getStmts$Const().$at(1 + NumCatchStmts));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtTryStmt::getFinallyStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 230,
   FQN="clang::ObjCAtTryStmt::getFinallyStmt", NM="_ZN5clang13ObjCAtTryStmt14getFinallyStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang13ObjCAtTryStmt14getFinallyStmtEv")
  //</editor-fold>
  public ObjCAtFinallyStmt /*P*/ getFinallyStmt() {
    if (!HasFinally) {
      return null;
    }
    
    return cast_or_null_ObjCAtFinallyStmt(getStmts().$at(1 + NumCatchStmts));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtTryStmt::setFinallyStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 236,
   FQN="clang::ObjCAtTryStmt::setFinallyStmt", NM="_ZN5clang13ObjCAtTryStmt14setFinallyStmtEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang13ObjCAtTryStmt14setFinallyStmtEPNS_4StmtE")
  //</editor-fold>
  public void setFinallyStmt(Stmt /*P*/ S) {
    assert (HasFinally) : "@try does not have a @finally slot!";
    getStmts().$set(1 + NumCatchStmts, S);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtTryStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 241,
   FQN="clang::ObjCAtTryStmt::getLocStart", NM="_ZNK5clang13ObjCAtTryStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang13ObjCAtTryStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(AtTryLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtTryStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp", line = 67,
   FQN="clang::ObjCAtTryStmt::getLocEnd", NM="_ZNK5clang13ObjCAtTryStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZNK5clang13ObjCAtTryStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    if (HasFinally) {
      return getFinallyStmt$Const().getLocEnd();
    }
    if ((NumCatchStmts != 0)) {
      return getCatchStmt$Const(NumCatchStmts - $int2uint_16bits(1)).getLocEnd();
    }
    return getTryBody$Const().getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtTryStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 244,
   FQN="clang::ObjCAtTryStmt::classof", NM="_ZN5clang13ObjCAtTryStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang13ObjCAtTryStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ObjCAtTryStmtClass;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCAtTryStmt::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtObjC.h", line = 248,
   FQN="clang::ObjCAtTryStmt::children", NM="_ZN5clang13ObjCAtTryStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtObjC.cpp -nm=_ZN5clang13ObjCAtTryStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(getStmts()), 
        new StmtIterator(getStmts().$add(1).$add(NumCatchStmts).$add((HasFinally ? 1 : 0))));
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final type$ptr</*const*/ Stmt /*P*/ /*const*/ /*P*/> $Stmts;

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "AtTryLoc=" + AtTryLoc // NOI18N
              + ", NumCatchStmts=" + $ushort2uint(NumCatchStmts) // NOI18N
              + ", HasFinally=" + HasFinally // NOI18N
              + super.toString(); // NOI18N
  }
}
