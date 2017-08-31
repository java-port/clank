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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativeType.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstSizeofAndAlignment.*;
import org.llvm.support.ITrailingObjectsJavaBase;


/// CXXTryStmt - A C++ try block, including all handlers.
///
//<editor-fold defaultstate="collapsed" desc="clang::CXXTryStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 65,
 FQN="clang::CXXTryStmt", NM="_ZN5clang10CXXTryStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang10CXXTryStmtE")
//</editor-fold>
public class CXXTryStmt extends /*public*/ Stmt implements ITrailingObjectsJavaBase<CXXTryStmt> {
  /*friend*/public SourceLocation TryLoc;
  private /*uint*/int NumHandlers;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTryStmt::CXXTryStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp", line = 44,
   FQN="clang::CXXTryStmt::CXXTryStmt", NM="_ZN5clang10CXXTryStmtC1ENS_14SourceLocationEPNS_4StmtEN4llvm8ArrayRefIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang10CXXTryStmtC1ENS_14SourceLocationEPNS_4StmtEN4llvm8ArrayRefIS3_EE")
  //</editor-fold>
  private CXXTryStmt(SourceLocation tryLoc, Stmt /*P*/ tryBlock, 
      ArrayRef<Stmt /*P*/ > handlers) {
    // : Stmt(CXXTryStmtClass), TryLoc(tryLoc), NumHandlers(handlers.size()) 
    //START JInit
    super(StmtClass.CXXTryStmtClass);
    this.TryLoc = new SourceLocation(tryLoc);
    this.NumHandlers = handlers.size();
    //END JInit
    type$ptr<Stmt /*P*/ /*P*/> Stmts = $TrailingObjects();//((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, this + 1)));
    Stmts.$set(0, tryBlock);
    std.copy(handlers.begin(), handlers.end(), Stmts.$add(1), true);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTryStmt::CXXTryStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 71,
   FQN="clang::CXXTryStmt::CXXTryStmt", NM="_ZN5clang10CXXTryStmtC1ENS_4Stmt10EmptyShellEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang10CXXTryStmtC1ENS_4Stmt10EmptyShellEj")
  //</editor-fold>
  private CXXTryStmt(EmptyShell Empty, /*uint*/int numHandlers) {
    // : Stmt(CXXTryStmtClass), TryLoc(), NumHandlers(numHandlers) 
    //START JInit
    super(StmtClass.CXXTryStmtClass);
    this.TryLoc = new SourceLocation();
    this.NumHandlers = numHandlers;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTryStmt::getStmts">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 74,
   FQN="clang::CXXTryStmt::getStmts", NM="_ZNK5clang10CXXTryStmt8getStmtsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang10CXXTryStmt8getStmtsEv")
  //</editor-fold>
  private type$ptr</*const*/ Stmt /*P*/ /*const*/ /*P*/> getStmts$Const() /*const*/ {
    return $TrailingObjects();//((type$ptr</*const*/ Stmt /*P*/ /*const*/ /*P*/>)reinterpret_cast(type$ptr.class, this + 1));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXTryStmt::getStmts">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 77,
   FQN="clang::CXXTryStmt::getStmts", NM="_ZN5clang10CXXTryStmt8getStmtsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang10CXXTryStmt8getStmtsEv")
  //</editor-fold>
  /*friend*/public type$ptr<Stmt /*P*/ /*P*/> getStmts() {
    return $TrailingObjects();//((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, this + 1));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTryStmt::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp", line = 26,
   FQN="clang::CXXTryStmt::Create", NM="_ZN5clang10CXXTryStmt6CreateERKNS_10ASTContextENS_14SourceLocationEPNS_4StmtEN4llvm8ArrayRefIS6_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang10CXXTryStmt6CreateERKNS_10ASTContextENS_14SourceLocationEPNS_4StmtEN4llvm8ArrayRefIS6_EE")
  //</editor-fold>
  public static CXXTryStmt /*P*/ Create(final /*const*/ ASTContext /*&*/ C, SourceLocation tryLoc, 
        Stmt /*P*/ tryBlock, ArrayRef<Stmt /*P*/ > handlers) {
    Object/*void P*/ _Mem;
    if (false) {
      /*uint*/int Size = $sizeof_CXXTryStmt();
      Size += ((handlers.size() + 1) * $sizeof_ptr(/*Stmt  */));
      _Mem = C.Allocate(Size, alignOf(CXXTryStmt.class));
    } else {
      /*uint*/int Size = /*$sizeof_CXXTryStmt()*/ 1;
      Size += ((handlers.size() + 1) * /*$sizeof_ptr(Stmt *)*/1);
      _Mem = C.Allocate$JavaRef(Size, alignOf(CXXTryStmt.class));
    }
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(_Mem, (type$ptr<?> Mem)->{
        return new CXXTryStmt(new SourceLocation(tryLoc), tryBlock, new ArrayRef<Stmt /*P*/ >(handlers));
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTryStmt::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp", line = 35,
   FQN="clang::CXXTryStmt::Create", NM="_ZN5clang10CXXTryStmt6CreateERKNS_10ASTContextENS_4Stmt10EmptyShellEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang10CXXTryStmt6CreateERKNS_10ASTContextENS_4Stmt10EmptyShellEj")
  //</editor-fold>
  public static CXXTryStmt /*P*/ Create(final /*const*/ ASTContext /*&*/ C, EmptyShell Empty, 
        /*uint*/int numHandlers) {
    Object/*void P*/ _Mem;
    if (false) {
      /*uint*/int Size = $sizeof_CXXTryStmt();
      Size += ((numHandlers + 1) * $sizeof_ptr(/*Stmt */));
      _Mem = C.Allocate(Size, alignOf(CXXTryStmt.class));
    } else {
      /*uint*/int Size = /*$sizeof_CXXTryStmt()*/ 1;
      Size += ((numHandlers + 1) * /*$sizeof_ptr(Stmt *)*/1);
      _Mem = C.Allocate$JavaRef(Size, alignOf(CXXTryStmt.class));
    }
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(_Mem, (type$ptr<?> Mem)->{
        return new CXXTryStmt(new EmptyShell(Empty), numHandlers);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTryStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 88,
   FQN="clang::CXXTryStmt::getLocStart", NM="_ZNK5clang10CXXTryStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang10CXXTryStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return getTryLoc();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXTryStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 89,
   FQN="clang::CXXTryStmt::getLocEnd", NM="_ZNK5clang10CXXTryStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang10CXXTryStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return getEndLoc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTryStmt::getTryLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 91,
   FQN="clang::CXXTryStmt::getTryLoc", NM="_ZNK5clang10CXXTryStmt9getTryLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang10CXXTryStmt9getTryLocEv")
  //</editor-fold>
  public SourceLocation getTryLoc() /*const*/ {
    return new SourceLocation(TryLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXTryStmt::getEndLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 92,
   FQN="clang::CXXTryStmt::getEndLoc", NM="_ZNK5clang10CXXTryStmt9getEndLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang10CXXTryStmt9getEndLocEv")
  //</editor-fold>
  public SourceLocation getEndLoc() /*const*/ {
    return getStmts$Const().$at(NumHandlers).getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTryStmt::getTryBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 96,
   FQN="clang::CXXTryStmt::getTryBlock", NM="_ZN5clang10CXXTryStmt11getTryBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang10CXXTryStmt11getTryBlockEv")
  //</editor-fold>
  public CompoundStmt /*P*/ getTryBlock() {
    return cast_CompoundStmt(getStmts().$at(0));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXTryStmt::getTryBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 99,
   FQN="clang::CXXTryStmt::getTryBlock", NM="_ZNK5clang10CXXTryStmt11getTryBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang10CXXTryStmt11getTryBlockEv")
  //</editor-fold>
  public /*const*/ CompoundStmt /*P*/ getTryBlock$Const() /*const*/ {
    return cast_CompoundStmt(getStmts$Const().$at(0));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTryStmt::getNumHandlers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 103,
   FQN="clang::CXXTryStmt::getNumHandlers", NM="_ZNK5clang10CXXTryStmt14getNumHandlersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang10CXXTryStmt14getNumHandlersEv")
  //</editor-fold>
  public /*uint*/int getNumHandlers() /*const*/ {
    return NumHandlers;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXTryStmt::getHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 104,
   FQN="clang::CXXTryStmt::getHandler", NM="_ZN5clang10CXXTryStmt10getHandlerEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang10CXXTryStmt10getHandlerEj")
  //</editor-fold>
  public CXXCatchStmt /*P*/ getHandler(/*uint*/int i) {
    return cast_CXXCatchStmt(getStmts().$at(i + 1));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXTryStmt::getHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 107,
   FQN="clang::CXXTryStmt::getHandler", NM="_ZNK5clang10CXXTryStmt10getHandlerEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang10CXXTryStmt10getHandlerEj")
  //</editor-fold>
  public /*const*/ CXXCatchStmt /*P*/ getHandler$Const(/*uint*/int i) /*const*/ {
    return cast_CXXCatchStmt(getStmts$Const().$at(i + 1));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTryStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 111,
   FQN="clang::CXXTryStmt::classof", NM="_ZN5clang10CXXTryStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang10CXXTryStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CXXTryStmtClass;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXTryStmt::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 115,
   FQN="clang::CXXTryStmt::children", NM="_ZN5clang10CXXTryStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang10CXXTryStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(getStmts()), new StmtIterator(getStmts().$add(getNumHandlers()).$add(1)));
  }

  
  /*friend  class ASTStmtReader*/
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override public type$ptr<Stmt /*P*/ /*P*/> $TrailingObjects() {
    return (type$ptr<Stmt /*P*/ /*P*/>) super.$this$plus1(); 
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "TryLoc=" + TryLoc // NOI18N
            + ", NumHandlers=" + NumHandlers // NOI18N
            + super.toString(); // NOI18N
  }
}
