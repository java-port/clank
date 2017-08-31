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
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::FloatingLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1354,
 FQN="clang::FloatingLiteral", NM="_ZN5clang15FloatingLiteralE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang15FloatingLiteralE")
//</editor-fold>
public class FloatingLiteral extends /*public*/ Expr implements /*private*/ APFloatStorage {
  private SourceLocation Loc;
  
  //<editor-fold defaultstate="collapsed" desc="clang::FloatingLiteral::FloatingLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 730,
   FQN="clang::FloatingLiteral::FloatingLiteral", NM="_ZN5clang15FloatingLiteralC1ERKNS_10ASTContextERKN4llvm7APFloatEbNS_8QualTypeENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang15FloatingLiteralC1ERKNS_10ASTContextERKN4llvm7APFloatEbNS_8QualTypeENS_14SourceLocationE")
  //</editor-fold>
  private FloatingLiteral(final /*const*/ ASTContext /*&*/ C, final /*const*/ APFloat /*&*/ V, 
      boolean isexact, QualType Type, SourceLocation L) {
    // : Expr(FloatingLiteralClass, Type, VK_RValue, OK_Ordinary, false, false, false, false), APFloatStorage(), Loc(L) 
    //START JInit
    super(StmtClass.FloatingLiteralClass, new QualType(Type), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, false, false, 
        false, false);
    this.APNumericStorage$Flds = $APFloatStorage();
    this.Loc = new SourceLocation(L);
    //END JInit
    setSemantics(V.getSemantics());
    Unnamed_field.FloatingLiteralBits.IsExact = isexact;
    setValue(C, V);
  }

  
  /// \brief Construct an empty floating-point literal.
  //<editor-fold defaultstate="collapsed" desc="clang::FloatingLiteral::FloatingLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 739,
   FQN="clang::FloatingLiteral::FloatingLiteral", NM="_ZN5clang15FloatingLiteralC1ERKNS_10ASTContextENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang15FloatingLiteralC1ERKNS_10ASTContextENS_4Stmt10EmptyShellE")
  //</editor-fold>
  private FloatingLiteral(final /*const*/ ASTContext /*&*/ C, Stmt.EmptyShell Empty) {
    // : Expr(FloatingLiteralClass, Empty), APFloatStorage(), Loc() 
    //START JInit
    super(StmtClass.FloatingLiteralClass, new Stmt.EmptyShell(Empty));
    this.APNumericStorage$Flds = $APFloatStorage();
    this.Loc = new SourceLocation();
    //END JInit
    setRawSemantics(APFloatSemantics.IEEEhalf);
    Unnamed_field.FloatingLiteralBits.IsExact = false;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::FloatingLiteral::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 745,
   FQN="clang::FloatingLiteral::Create", NM="_ZN5clang15FloatingLiteral6CreateERKNS_10ASTContextERKN4llvm7APFloatEbNS_8QualTypeENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang15FloatingLiteral6CreateERKNS_10ASTContextERKN4llvm7APFloatEbNS_8QualTypeENS_14SourceLocationE")
  //</editor-fold>
  public static FloatingLiteral /*P*/ Create(final /*const*/ ASTContext /*&*/ C, final /*const*/ APFloat /*&*/ V, 
        boolean isexact, QualType Type, SourceLocation L) {
    return /*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> New$Mem)->{
        return new FloatingLiteral(C, V, isexact, new QualType(Type), new SourceLocation(L));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FloatingLiteral::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 751,
   FQN="clang::FloatingLiteral::Create", NM="_ZN5clang15FloatingLiteral6CreateERKNS_10ASTContextENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang15FloatingLiteral6CreateERKNS_10ASTContextENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public static FloatingLiteral /*P*/ Create(final /*const*/ ASTContext /*&*/ C, Stmt.EmptyShell Empty) {
    return /*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> New$Mem)->{
        return new FloatingLiteral(C, new Stmt.EmptyShell(Empty));
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FloatingLiteral::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1368,
   FQN="clang::FloatingLiteral::getValue", NM="_ZNK5clang15FloatingLiteral8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang15FloatingLiteral8getValueEv")
  //</editor-fold>
  public APFloat getValue() /*const*/ {
    return APFloatStorage.super.getValue(getSemantics());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FloatingLiteral::setValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1371,
   FQN="clang::FloatingLiteral::setValue", NM="_ZN5clang15FloatingLiteral8setValueERKNS_10ASTContextERKN4llvm7APFloatE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang15FloatingLiteral8setValueERKNS_10ASTContextERKN4llvm7APFloatE")
  //</editor-fold>
  public void setValue(final /*const*/ ASTContext /*&*/ C, final /*const*/ APFloat /*&*/ Val) {
    assert ($AddrOf(getSemantics()) == $AddrOf(Val.getSemantics())) : "Inconsistent semantics";
    APFloatStorage.super.setValue(C, Val);
  }

  
  /// Get a raw enumeration value representing the floating-point semantics of
  /// this literal (32-bit IEEE, x87, ...), suitable for serialisation.
  //<editor-fold defaultstate="collapsed" desc="clang::FloatingLiteral::getRawSemantics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1378,
   FQN="clang::FloatingLiteral::getRawSemantics", NM="_ZNK5clang15FloatingLiteral15getRawSemanticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang15FloatingLiteral15getRawSemanticsEv")
  //</editor-fold>
  public APFloatSemantics getRawSemantics() /*const*/ {
    return /*static_cast*/APFloatSemantics.valueOf(Unnamed_field.FloatingLiteralBits.Semantics);
  }

  
  /// Set the raw enumeration value representing the floating-point semantics of
  /// this literal (32-bit IEEE, x87, ...), suitable for serialisation.
  //<editor-fold defaultstate="collapsed" desc="clang::FloatingLiteral::setRawSemantics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1384,
   FQN="clang::FloatingLiteral::setRawSemantics", NM="_ZN5clang15FloatingLiteral15setRawSemanticsENS_4Stmt16APFloatSemanticsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang15FloatingLiteral15setRawSemanticsENS_4Stmt16APFloatSemanticsE")
  //</editor-fold>
  public void setRawSemantics(APFloatSemantics Sem) {
    Unnamed_field.FloatingLiteralBits.Semantics = $uint2uint_3bits(Sem.getValue());
  }

  
  /// Return the APFloat semantics this literal uses.
  //<editor-fold defaultstate="collapsed" desc="clang::FloatingLiteral::getSemantics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 756,
   FQN="clang::FloatingLiteral::getSemantics", NM="_ZNK5clang15FloatingLiteral12getSemanticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang15FloatingLiteral12getSemanticsEv")
  //</editor-fold>
  public /*const*/ fltSemantics /*&*/ getSemantics() /*const*/ {
    switch (Stmt.APFloatSemantics.valueOf(Unnamed_field.FloatingLiteralBits.Semantics)) {
     case IEEEhalf:
      return APFloat.IEEEhalf;
     case IEEEsingle:
      return APFloat.IEEEsingle;
     case IEEEdouble:
      return APFloat.IEEEdouble;
     case x87DoubleExtended:
      return APFloat.x87DoubleExtended;
     case IEEEquad:
      return APFloat.IEEEquad;
     case PPCDoubleDouble:
      return APFloat.PPCDoubleDouble;
    }
    throw new llvm_unreachable("Unrecognised floating semantics");
  }

  
  /// Set the APFloat semantics this literal uses.
  //<editor-fold defaultstate="collapsed" desc="clang::FloatingLiteral::setSemantics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 774,
   FQN="clang::FloatingLiteral::setSemantics", NM="_ZN5clang15FloatingLiteral12setSemanticsERKN4llvm12fltSemanticsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang15FloatingLiteral12setSemanticsERKN4llvm12fltSemanticsE")
  //</editor-fold>
  public void setSemantics(final /*const*/ fltSemantics /*&*/ Sem) {
    if ($AddrOf(Sem) == $AddrOf(APFloat.IEEEhalf)) {
      Unnamed_field.FloatingLiteralBits.Semantics = $uint2uint_3bits(APFloatSemantics.IEEEhalf.getValue());
    } else if ($AddrOf(Sem) == $AddrOf(APFloat.IEEEsingle)) {
      Unnamed_field.FloatingLiteralBits.Semantics = $uint2uint_3bits(APFloatSemantics.IEEEsingle.getValue());
    } else if ($AddrOf(Sem) == $AddrOf(APFloat.IEEEdouble)) {
      Unnamed_field.FloatingLiteralBits.Semantics = $uint2uint_3bits(APFloatSemantics.IEEEdouble.getValue());
    } else if ($AddrOf(Sem) == $AddrOf(APFloat.x87DoubleExtended)) {
      Unnamed_field.FloatingLiteralBits.Semantics = $uint2uint_3bits(APFloatSemantics.x87DoubleExtended.getValue());
    } else if ($AddrOf(Sem) == $AddrOf(APFloat.IEEEquad)) {
      Unnamed_field.FloatingLiteralBits.Semantics = $uint2uint_3bits(APFloatSemantics.IEEEquad.getValue());
    } else if ($AddrOf(Sem) == $AddrOf(APFloat.PPCDoubleDouble)) {
      Unnamed_field.FloatingLiteralBits.Semantics = $uint2uint_3bits(APFloatSemantics.PPCDoubleDouble.getValue());
    } else {
      throw new llvm_unreachable("Unknown floating semantics");
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FloatingLiteral::isExact">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1394,
   FQN="clang::FloatingLiteral::isExact", NM="_ZNK5clang15FloatingLiteral7isExactEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang15FloatingLiteral7isExactEv")
  //</editor-fold>
  public boolean isExact() /*const*/ {
    return Unnamed_field.FloatingLiteralBits.IsExact;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FloatingLiteral::setExact">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1395,
   FQN="clang::FloatingLiteral::setExact", NM="_ZN5clang15FloatingLiteral8setExactEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang15FloatingLiteral8setExactEb")
  //</editor-fold>
  public void setExact(boolean E) {
    Unnamed_field.FloatingLiteralBits.IsExact = E;
  }

  
  /// getValueAsApproximateDouble - This returns the value as an inaccurate
  /// double.  Note that this may cause loss of precision, but is useful for
  /// debugging dumps, etc.
  
  /// getValueAsApproximateDouble - This returns the value as an inaccurate
  /// double.  Note that this may cause loss of precision, but is useful for
  /// debugging dumps, etc.
  //<editor-fold defaultstate="collapsed" desc="clang::FloatingLiteral::getValueAsApproximateDouble">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 794,
   FQN="clang::FloatingLiteral::getValueAsApproximateDouble", NM="_ZNK5clang15FloatingLiteral27getValueAsApproximateDoubleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang15FloatingLiteral27getValueAsApproximateDoubleEv")
  //</editor-fold>
  public double getValueAsApproximateDouble() /*const*/ {
    APFloat V = getValue();
    bool$ptr ignored = create_bool$ptr();
    V.convert(APFloat.IEEEdouble, APFloat.roundingMode.rmNearestTiesToEven, 
        $AddrOf(ignored));
    return V.convertToDouble();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FloatingLiteral::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1402,
   FQN="clang::FloatingLiteral::getLocation", NM="_ZNK5clang15FloatingLiteral11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang15FloatingLiteral11getLocationEv")
  //</editor-fold>
  public SourceLocation getLocation() /*const*/ {
    return new SourceLocation(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FloatingLiteral::setLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1403,
   FQN="clang::FloatingLiteral::setLocation", NM="_ZN5clang15FloatingLiteral11setLocationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang15FloatingLiteral11setLocationENS_14SourceLocationE")
  //</editor-fold>
  public void setLocation(SourceLocation L) {
    Loc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FloatingLiteral::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1405,
   FQN="clang::FloatingLiteral::getLocStart", NM="_ZNK5clang15FloatingLiteral11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang15FloatingLiteral11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FloatingLiteral::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1406,
   FQN="clang::FloatingLiteral::getLocEnd", NM="_ZNK5clang15FloatingLiteral9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang15FloatingLiteral9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FloatingLiteral::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1408,
   FQN="clang::FloatingLiteral::classof", NM="_ZN5clang15FloatingLiteral7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang15FloatingLiteral7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.FloatingLiteralClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::FloatingLiteral::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1413,
   FQN="clang::FloatingLiteral::children", NM="_ZN5clang15FloatingLiteral8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang15FloatingLiteral8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  
  private final APNumericStorage$Fields APNumericStorage$Flds;// use return value of $APFloatStorage();
  @Override public final APNumericStorage$Fields $APNumericStorage$Fields() { return APNumericStorage$Flds; }
  
  @Override public String toString() {
    return "" + "Loc=" + Loc // NOI18N
              + super.toString(); // NOI18N
  }
}
