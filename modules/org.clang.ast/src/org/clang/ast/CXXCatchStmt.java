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
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// CXXCatchStmt - This represents a C++ catch block.
///
//<editor-fold defaultstate="collapsed" desc="clang::CXXCatchStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 29,
 FQN="clang::CXXCatchStmt", NM="_ZN5clang12CXXCatchStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang12CXXCatchStmtE")
//</editor-fold>
public class CXXCatchStmt extends /*public*/ Stmt {
  /*friend*/public SourceLocation CatchLoc;
  /// The exception-declaration of the type.
  /*friend*/public VarDecl /*P*/ ExceptionDecl;
  /// The handler block.
  /*friend*/public Stmt /*P*/ HandlerBlock;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCatchStmt::CXXCatchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 37,
   FQN="clang::CXXCatchStmt::CXXCatchStmt", NM="_ZN5clang12CXXCatchStmtC1ENS_14SourceLocationEPNS_7VarDeclEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang12CXXCatchStmtC1ENS_14SourceLocationEPNS_7VarDeclEPNS_4StmtE")
  //</editor-fold>
  public CXXCatchStmt(SourceLocation catchLoc, VarDecl /*P*/ exDecl, Stmt /*P*/ handlerBlock) {
    // : Stmt(CXXCatchStmtClass), CatchLoc(catchLoc), ExceptionDecl(exDecl), HandlerBlock(handlerBlock) 
    //START JInit
    super(StmtClass.CXXCatchStmtClass);
    this.CatchLoc = new SourceLocation(catchLoc);
    this.ExceptionDecl = exDecl;
    this.HandlerBlock = handlerBlock;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCatchStmt::CXXCatchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 41,
   FQN="clang::CXXCatchStmt::CXXCatchStmt", NM="_ZN5clang12CXXCatchStmtC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang12CXXCatchStmtC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public CXXCatchStmt(EmptyShell Empty) {
    // : Stmt(CXXCatchStmtClass), CatchLoc(), ExceptionDecl(null), HandlerBlock(null) 
    //START JInit
    super(StmtClass.CXXCatchStmtClass);
    this.CatchLoc = new SourceLocation();
    this.ExceptionDecl = null;
    this.HandlerBlock = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCatchStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 44,
   FQN="clang::CXXCatchStmt::getLocStart", NM="_ZNK5clang12CXXCatchStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang12CXXCatchStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(CatchLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXCatchStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 45,
   FQN="clang::CXXCatchStmt::getLocEnd", NM="_ZNK5clang12CXXCatchStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang12CXXCatchStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return HandlerBlock.getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCatchStmt::getCatchLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 49,
   FQN="clang::CXXCatchStmt::getCatchLoc", NM="_ZNK5clang12CXXCatchStmt11getCatchLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang12CXXCatchStmt11getCatchLocEv")
  //</editor-fold>
  public SourceLocation getCatchLoc() /*const*/ {
    return new SourceLocation(CatchLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXCatchStmt::getExceptionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 50,
   FQN="clang::CXXCatchStmt::getExceptionDecl", NM="_ZNK5clang12CXXCatchStmt16getExceptionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang12CXXCatchStmt16getExceptionDeclEv")
  //</editor-fold>
  public VarDecl /*P*/ getExceptionDecl() /*const*/ {
    return ExceptionDecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXCatchStmt::getCaughtType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp", line = 20,
   FQN="clang::CXXCatchStmt::getCaughtType", NM="_ZNK5clang12CXXCatchStmt13getCaughtTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang12CXXCatchStmt13getCaughtTypeEv")
  //</editor-fold>
  public QualType getCaughtType() /*const*/ {
    if ((ExceptionDecl != null)) {
      return ExceptionDecl.getType();
    }
    return new QualType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXCatchStmt::getHandlerBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 52,
   FQN="clang::CXXCatchStmt::getHandlerBlock", NM="_ZNK5clang12CXXCatchStmt15getHandlerBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZNK5clang12CXXCatchStmt15getHandlerBlockEv")
  //</editor-fold>
  public Stmt /*P*/ getHandlerBlock() /*const*/ {
    return HandlerBlock;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCatchStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 54,
   FQN="clang::CXXCatchStmt::classof", NM="_ZN5clang12CXXCatchStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang12CXXCatchStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CXXCatchStmtClass;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXCatchStmt::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtCXX.h", line = 58,
   FQN="clang::CXXCatchStmt::children", NM="_ZN5clang12CXXCatchStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtCXX.cpp -nm=_ZN5clang12CXXCatchStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(HandlerBlock))), new StmtIterator(create_type$ptr($AddrOf(HandlerBlock)).$add(1)));
  }

  
  /*friend  class ASTStmtReader*/
  
  @Override public String toString() {
    return "" + "CatchLoc=" + CatchLoc // NOI18N
              + ", ExceptionDecl=" + ExceptionDecl // NOI18N
              + ", HandlerBlock=" + HandlerBlock // NOI18N
              + super.toString(); // NOI18N
  }
}
