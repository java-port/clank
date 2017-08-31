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
import org.llvm.adt.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::IntegerLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1264,
 FQN="clang::IntegerLiteral", NM="_ZN5clang14IntegerLiteralE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14IntegerLiteralE")
//</editor-fold>
public class IntegerLiteral extends /*public*/ Expr implements /*public*/ APIntStorage {
  private SourceLocation Loc;
  
  /// \brief Construct an empty integer literal.
  //<editor-fold defaultstate="collapsed" desc="clang::IntegerLiteral::IntegerLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1268,
   FQN="clang::IntegerLiteral::IntegerLiteral", NM="_ZN5clang14IntegerLiteralC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14IntegerLiteralC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  private /*explicit*/ IntegerLiteral(Stmt.EmptyShell Empty) {
    // : Expr(IntegerLiteralClass, Empty), APIntStorage(), Loc() 
    //START JInit
    super(StmtClass.IntegerLiteralClass, new Stmt.EmptyShell(Empty));
    this.APNumericStorage$Flds = $APIntStorage();
    this.Loc = new SourceLocation();
    //END JInit
  }

/*public:*/
  // type should be IntTy, LongTy, LongLongTy, UnsignedIntTy, UnsignedLongTy,
  // or UnsignedLongLongTy
  //<editor-fold defaultstate="collapsed" desc="clang::IntegerLiteral::IntegerLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 708,
   FQN="clang::IntegerLiteral::IntegerLiteral", NM="_ZN5clang14IntegerLiteralC1ERKNS_10ASTContextERKN4llvm5APIntENS_8QualTypeENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14IntegerLiteralC1ERKNS_10ASTContextERKN4llvm5APIntENS_8QualTypeENS_14SourceLocationE")
  //</editor-fold>
  public IntegerLiteral(final /*const*/ ASTContext /*&*/ C, final /*const*/ APInt /*&*/ V, 
      QualType type, SourceLocation l) {
    // : Expr(IntegerLiteralClass, type, VK_RValue, OK_Ordinary, false, false, false, false), APIntStorage(), Loc(l) 
    //START JInit
    super(StmtClass.IntegerLiteralClass, new QualType(type), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, false, false, 
        false, false);
    this.APNumericStorage$Flds = $APIntStorage();
    this.Loc = new SourceLocation(l);
    //END JInit
    assert (type.$arrow().isIntegerType()) : "Illegal type in IntegerLiteral";
    assert (V.getBitWidth() == C.getIntWidth(new QualType(type))) : "Integer type is not the correct size for constant.";
    setValue(C, V);
  }

  
  /// \brief Returns a new integer literal with value 'V' and type 'type'.
  /// \param type - either IntTy, LongTy, LongLongTy, UnsignedIntTy,
  /// UnsignedLongTy, or UnsignedLongLongTy which should match the size of V
  /// \param V - the value that the returned integer literal contains.
  //<editor-fold defaultstate="collapsed" desc="clang::IntegerLiteral::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 719,
   FQN="clang::IntegerLiteral::Create", NM="_ZN5clang14IntegerLiteral6CreateERKNS_10ASTContextERKN4llvm5APIntENS_8QualTypeENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14IntegerLiteral6CreateERKNS_10ASTContextERKN4llvm5APIntENS_8QualTypeENS_14SourceLocationE")
  //</editor-fold>
  public static IntegerLiteral /*P*/ Create(final /*const*/ ASTContext /*&*/ C, final /*const*/ APInt /*&*/ V, 
        QualType type, SourceLocation l) {
    return /*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> New$Mem)->{
        return new IntegerLiteral(C, V, new QualType(type), new SourceLocation(l));
     });
  }

  /// \brief Returns a new empty integer literal.
  //<editor-fold defaultstate="collapsed" desc="clang::IntegerLiteral::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 725,
   FQN="clang::IntegerLiteral::Create", NM="_ZN5clang14IntegerLiteral6CreateERKNS_10ASTContextENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14IntegerLiteral6CreateERKNS_10ASTContextENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public static IntegerLiteral /*P*/ Create(final /*const*/ ASTContext /*&*/ C, Stmt.EmptyShell Empty) {
    return /*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> New$Mem)->{
        return new IntegerLiteral(new Stmt.EmptyShell(Empty));
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::IntegerLiteral::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1286,
   FQN="clang::IntegerLiteral::getLocStart", NM="_ZNK5clang14IntegerLiteral11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14IntegerLiteral11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IntegerLiteral::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1287,
   FQN="clang::IntegerLiteral::getLocEnd", NM="_ZNK5clang14IntegerLiteral9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14IntegerLiteral9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(Loc);
  }

  
  /// \brief Retrieve the location of the literal.
  //<editor-fold defaultstate="collapsed" desc="clang::IntegerLiteral::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1290,
   FQN="clang::IntegerLiteral::getLocation", NM="_ZNK5clang14IntegerLiteral11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang14IntegerLiteral11getLocationEv")
  //</editor-fold>
  public SourceLocation getLocation() /*const*/ {
    return new SourceLocation(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::IntegerLiteral::setLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1292,
   FQN="clang::IntegerLiteral::setLocation", NM="_ZN5clang14IntegerLiteral11setLocationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14IntegerLiteral11setLocationENS_14SourceLocationE")
  //</editor-fold>
  public void setLocation(SourceLocation Location) {
    Loc.$assign(Location);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::IntegerLiteral::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1294,
   FQN="clang::IntegerLiteral::classof", NM="_ZN5clang14IntegerLiteral7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14IntegerLiteral7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.IntegerLiteralClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::IntegerLiteral::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1299,
   FQN="clang::IntegerLiteral::children", NM="_ZN5clang14IntegerLiteral8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang14IntegerLiteral8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  
  private final APNumericStorage$Fields APNumericStorage$Flds;// use return value of $APIntStorage();
  @Override public final APNumericStorage$Fields $APNumericStorage$Fields() { return APNumericStorage$Flds; }
  
  @Override public String toString() {
    return "" + "Loc=" + Loc // NOI18N
              + super.toString(); // NOI18N
  }
}
