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
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::CharacterLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1304,
 FQN="clang::CharacterLiteral", NM="_ZN5clang16CharacterLiteralE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16CharacterLiteralE")
//</editor-fold>
public class CharacterLiteral extends /*public*/ Expr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CharacterLiteral::CharacterKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1306,
   FQN="clang::CharacterLiteral::CharacterKind", NM="_ZN5clang16CharacterLiteral13CharacterKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16CharacterLiteral13CharacterKindE")
  //</editor-fold>
  public enum CharacterKind implements Native.ComparableLower {
    Ascii(0),
    Wide(Ascii.getValue() + 1),
    UTF8(Wide.getValue() + 1),
    UTF16(UTF8.getValue() + 1),
    UTF32(UTF16.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static CharacterKind valueOf(int val) {
      CharacterKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final CharacterKind[] VALUES;
      private static final CharacterKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (CharacterKind kind : CharacterKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new CharacterKind[min < 0 ? (1-min) : 0];
        VALUES = new CharacterKind[max >= 0 ? (1+max) : 0];
        for (CharacterKind kind : CharacterKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private CharacterKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((CharacterKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((CharacterKind)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private /*uint*/int Value;
  private SourceLocation Loc;
/*public:*/
  // type should be IntTy
  //<editor-fold defaultstate="collapsed" desc="clang::CharacterLiteral::CharacterLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1319,
   FQN="clang::CharacterLiteral::CharacterLiteral", NM="_ZN5clang16CharacterLiteralC1EjNS0_13CharacterKindENS_8QualTypeENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16CharacterLiteralC1EjNS0_13CharacterKindENS_8QualTypeENS_14SourceLocationE")
  //</editor-fold>
  public CharacterLiteral(/*uint*/int value, CharacterKind kind, QualType type, 
      SourceLocation l) {
    // : Expr(CharacterLiteralClass, type, VK_RValue, OK_Ordinary, false, false, false, false), Value(value), Loc(l) 
    //START JInit
    super(StmtClass.CharacterLiteralClass, new QualType(type), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, false, false, 
        false, false);
    this.Value = value;
    this.Loc = new SourceLocation(l);
    //END JInit
    Unnamed_field.CharacterLiteralBits.Kind = $uint2uint_3bits(kind.getValue());
  }

  
  /// \brief Construct an empty character literal.
  //<editor-fold defaultstate="collapsed" desc="clang::CharacterLiteral::CharacterLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1328,
   FQN="clang::CharacterLiteral::CharacterLiteral", NM="_ZN5clang16CharacterLiteralC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16CharacterLiteralC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public CharacterLiteral(EmptyShell Empty) {
    // : Expr(CharacterLiteralClass, Empty), Loc() 
    //START JInit
    super(StmtClass.CharacterLiteralClass, new EmptyShell(Empty));
    this.Loc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CharacterLiteral::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1330,
   FQN="clang::CharacterLiteral::getLocation", NM="_ZNK5clang16CharacterLiteral11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang16CharacterLiteral11getLocationEv")
  //</editor-fold>
  public SourceLocation getLocation() /*const*/ {
    return new SourceLocation(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharacterLiteral::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1331,
   FQN="clang::CharacterLiteral::getKind", NM="_ZNK5clang16CharacterLiteral7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang16CharacterLiteral7getKindEv")
  //</editor-fold>
  public CharacterKind getKind() /*const*/ {
    return /*static_cast*/CharacterKind.valueOf(Unnamed_field.CharacterLiteralBits.Kind);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CharacterLiteral::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1335,
   FQN="clang::CharacterLiteral::getLocStart", NM="_ZNK5clang16CharacterLiteral11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang16CharacterLiteral11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharacterLiteral::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1336,
   FQN="clang::CharacterLiteral::getLocEnd", NM="_ZNK5clang16CharacterLiteral9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang16CharacterLiteral9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CharacterLiteral::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1338,
   FQN="clang::CharacterLiteral::getValue", NM="_ZNK5clang16CharacterLiteral8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang16CharacterLiteral8getValueEv")
  //</editor-fold>
  public /*uint*/int getValue() /*const*/ {
    return Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CharacterLiteral::setLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1340,
   FQN="clang::CharacterLiteral::setLocation", NM="_ZN5clang16CharacterLiteral11setLocationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16CharacterLiteral11setLocationENS_14SourceLocationE")
  //</editor-fold>
  public void setLocation(SourceLocation Location) {
    Loc.$assign(Location);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharacterLiteral::setKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1341,
   FQN="clang::CharacterLiteral::setKind", NM="_ZN5clang16CharacterLiteral7setKindENS0_13CharacterKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16CharacterLiteral7setKindENS0_13CharacterKindE")
  //</editor-fold>
  public void setKind(CharacterKind kind) {
    Unnamed_field.CharacterLiteralBits.Kind = $uint2uint_3bits(kind.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharacterLiteral::setValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1342,
   FQN="clang::CharacterLiteral::setValue", NM="_ZN5clang16CharacterLiteral8setValueEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16CharacterLiteral8setValueEj")
  //</editor-fold>
  public void setValue(/*uint*/int Val) {
    Value = Val;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CharacterLiteral::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1344,
   FQN="clang::CharacterLiteral::classof", NM="_ZN5clang16CharacterLiteral7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16CharacterLiteral7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CharacterLiteralClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::CharacterLiteral::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1349,
   FQN="clang::CharacterLiteral::children", NM="_ZN5clang16CharacterLiteral8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16CharacterLiteral8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  
  @Override public String toString() {
    return "" + "Value=" + Value // NOI18N
              + ", Loc=" + Loc // NOI18N
              + super.toString(); // NOI18N
  }
}
