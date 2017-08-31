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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.impl.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.QualType.*;
import org.llvm.adt.java.TrailingObjectsUtils;


/// \brief Represents a template argument.
//<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 40,
 FQN="clang::TemplateArgument", NM="_ZN5clang16TemplateArgumentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgumentE")
//</editor-fold>
public class TemplateArgument implements NativePOD<TemplateArgument> {
/*public:*/
  /// \brief The kind of template argument we're storing.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::ArgKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 43,
   FQN="clang::TemplateArgument::ArgKind", NM="_ZN5clang16TemplateArgument7ArgKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgument7ArgKindE")
  //</editor-fold>
  public enum ArgKind implements Native.ComparableLower {
    /// \brief Represents an empty template argument, e.g., one that has not
    /// been deduced.
    Null(0),
    /// The template argument is a type.
    Type(Null.getValue() + 1),
    /// The template argument is a declaration that was provided for a pointer,
    /// reference, or pointer to member non-type template parameter.
    Declaration(Type.getValue() + 1),
    /// The template argument is a null pointer or null pointer to member that
    /// was provided for a non-type template parameter.
    NullPtr(Declaration.getValue() + 1),
    /// The template argument is an integral value stored in an llvm::APSInt
    /// that was provided for an integral non-type template parameter.
    Integral(NullPtr.getValue() + 1),
    /// The template argument is a template name that was provided for a
    /// template template parameter.
    Template(Integral.getValue() + 1),
    /// The template argument is a pack expansion of a template name that was
    /// provided for a template template parameter.
    TemplateExpansion(Template.getValue() + 1),
    /// The template argument is an expression, and we've not resolved it to one
    /// of the other forms yet, either because it's dependent or because we're
    /// representing a non-canonical template argument (for instance, in a
    /// TemplateSpecializationType). Also used to represent a non-dependent
    /// __uuidof expression (a Microsoft extension).
    Expression(TemplateExpansion.getValue() + 1),
    /// The template argument is actually a parameter pack. Arguments are stored
    /// in the Args struct.
    Pack(Expression.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ArgKind valueOf(int val) {
      ArgKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ArgKind[] VALUES;
      private static final ArgKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ArgKind kind : ArgKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ArgKind[min < 0 ? (1-min) : 0];
        VALUES = new ArgKind[max >= 0 ? (1+max) : 0];
        for (ArgKind kind : ArgKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private ArgKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ArgKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ArgKind)obj).value);}
    //</editor-fold>
  };
/*private:*/
  /// \brief The kind of template argument we're storing.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::DA">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*non static, extracted field Kind*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 78,
   FQN="clang::TemplateArgument::DA", NM="_ZN5clang16TemplateArgument2DAE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgument2DAE")
  //</editor-fold>
  private class/*struct*/ DA {
    public Object/*void P*/ QT;
    public ValueDecl /*P*/ D;
    //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::DA::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*shared Kind*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 78,
     FQN="clang::TemplateArgument::DA::operator=", NM="_ZN5clang16TemplateArgument2DAaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgument2DAaSERKS1_")
    //</editor-fold>
    public /*inline*/ DA /*&*/ $assign(final /*const*/ DA /*&*/ $Prm0) {
      TemplateArgument.this.Kind = $Prm0.getKind();
      this.QT = $Prm0.QT;
      this.D = $Prm0.D;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::DA::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*shared Kind*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 78,
     FQN="clang::TemplateArgument::DA::operator=", NM="_ZN5clang16TemplateArgument2DAaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgument2DAaSEOS1_")
    //</editor-fold>
    public /*inline*/ DA /*&*/ $assignMove(final DA /*&&*/$Prm0) {
      TemplateArgument.this.Kind = $Prm0.getKind();
      this.QT = $Prm0.QT;
      this.D = $Prm0.D;
      return /*Deref*/this;
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public final int/*uint*/ getKind() {
      return TemplateArgument.this.Kind;
    }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Kind=" + Kind // NOI18N
                + ", QT=" + QT // NOI18N
                + ", D=" + D; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::I">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*non static, extracted field Kind*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 83,
   FQN="clang::TemplateArgument::I", NM="_ZN5clang16TemplateArgument1IE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgument1IE")
  //</editor-fold>
  private class/*struct*/ I {
    // We store a decomposed APSInt with the data allocated by ASTContext if
    // BitWidth > 64. The memory may be shared between multiple
    // TemplateArgument instances.
    public /*uint*/int BitWidth /*: 31*/;
    public /*JBIT unsigned int*/ boolean IsUnsigned /*: 1*/;
    //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::I::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 90,
     FQN="clang::TemplateArgument::I::(anonymous)", NM="_ZN5clang16TemplateArgument1IE_Unnamed_union1",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgument1IE_Unnamed_union1")
    //</editor-fold>
    public class/*union*/ Unnamed_union1 {
      public long/*uint64_t*/ VAL; ///< Used to store the <= 64 bits integer value.
      public /*const*/ulong$ptr/*uint64_t P*/ pVal; ///< Used to store the >64 bits integer value.
      //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::I::(anonymous union)::operator=">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 90,
       FQN="clang::TemplateArgument::I::(anonymous union)::operator=", NM="_ZN5clang16TemplateArgument1IUt_aSERKS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgument1IUt_aSERKS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_union1 $assign(final Unnamed_union1 $Prm0) {
        this.VAL = $Prm0.VAL;
        this.pVal = $tryClone($Prm0.pVal);
        return /*Deref*/this;
      }

      //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::I::(anonymous union)::operator=">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 90,
       FQN="clang::TemplateArgument::I::(anonymous union)::operator=", NM="_ZN5clang16TemplateArgument1IUt_aSEOS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgument1IUt_aSEOS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_union1 $assignMove(final Unnamed_union1 $Prm0) {
        this.VAL = $Prm0.VAL;
        this.pVal = $tryClone($Prm0.pVal);
        return /*Deref*/this;
      }

      
      @Override public String toString() {
        return "" + "VAL=" + VAL // NOI18N
                  + ", pVal=" + pVal; // NOI18N
      }
    };
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC) // JAVA: initialize
    public final Unnamed_union1 Unnamed_field3 = new Unnamed_union1();
    public Object/*void P*/ Type;
    //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::I::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 83,
     FQN="clang::TemplateArgument::I::operator=", NM="_ZN5clang16TemplateArgument1IaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgument1IaSERKS1_")
    //</editor-fold>
    public /*inline*/ I /*&*/ $assign(final /*const*/ I /*&*/ $Prm0) {
      TemplateArgument.this.Kind = $Prm0.getKind();
      this.BitWidth = $Prm0.BitWidth;
      this.IsUnsigned = $Prm0.IsUnsigned;
      this.Unnamed_field3.$assign($Prm0.Unnamed_field3);
      this.Type = $Prm0.Type;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::I::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 83,
     FQN="clang::TemplateArgument::I::operator=", NM="_ZN5clang16TemplateArgument1IaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgument1IaSEOS1_")
    //</editor-fold>
    public /*inline*/ I /*&*/ $assignMove(final I /*&&*/$Prm0) {
      TemplateArgument.this.Kind = $Prm0.getKind();
      this.BitWidth = $Prm0.BitWidth;
      this.IsUnsigned = $Prm0.IsUnsigned;
      this.Unnamed_field3.$assignMove($Prm0.Unnamed_field3);
      this.Type = $Prm0.Type;
      return /*Deref*/this;
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public final int/*uint*/ getKind() {
      return TemplateArgument.this.Kind;
    }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Kind=" + Kind // NOI18N
                + ", BitWidth=" + BitWidth // NOI18N
                + ", IsUnsigned=" + IsUnsigned // NOI18N
                + ", Unnamed_field3=" + Unnamed_field3 // NOI18N
                + ", Type=" + Type; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::A">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*non static, extracted field Kind*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 96,
   FQN="clang::TemplateArgument::A", NM="_ZN5clang16TemplateArgument1AE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgument1AE")
  //</editor-fold>
  private class/*struct*/ A {
    public /*uint*/int NumArgs;
    public /*const*/type$ptr<TemplateArgument/*P*/> Args;
    //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::A::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 96,
     FQN="clang::TemplateArgument::A::operator=", NM="_ZN5clang16TemplateArgument1AaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgument1AaSERKS1_")
    //</editor-fold>
    public /*inline*/ A /*&*/ $assign(final /*const*/ A /*&*/ $Prm0) {
      TemplateArgument.this.Kind = $Prm0.getKind();
      this.NumArgs = $Prm0.NumArgs;
      this.Args = $tryConstClone($Prm0.Args);
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::A::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 96,
     FQN="clang::TemplateArgument::A::operator=", NM="_ZN5clang16TemplateArgument1AaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgument1AaSEOS1_")
    //</editor-fold>
    public /*inline*/ A /*&*/ $assignMove(final A /*&&*/$Prm0) {
      assert this != $Prm0;
      TemplateArgument.this.Kind = $Prm0.getKind();
      this.NumArgs = $Prm0.NumArgs;
      this.Args = $Prm0.Args;
      $Prm0.NumArgs = 0;
      $Prm0.Args = null;
      return /*Deref*/this;
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public final int/*uint*/ getKind() {
      return TemplateArgument.this.Kind;
    }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Kind=" + Kind // NOI18N
                + ", NumArgs=" + NumArgs // NOI18N
                + ", Args=" + Args; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::TA">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*non static, extracted field Kind*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 101,
   FQN="clang::TemplateArgument::TA", NM="_ZN5clang16TemplateArgument2TAE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgument2TAE")
  //</editor-fold>
  private class/*struct*/ TA {
    public /*uint*/int NumExpansions;
    public Object/*void P*/ Name;
    //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::TA::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*shared field*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 101,
     FQN="clang::TemplateArgument::TA::operator=", NM="_ZN5clang16TemplateArgument2TAaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgument2TAaSERKS1_")
    //</editor-fold>
    public /*inline*/ TA /*&*/ $assign(final /*const*/ TA /*&*/ $Prm0) {
      TemplateArgument.this.Kind = $Prm0.getKind();
      this.NumExpansions = $Prm0.NumExpansions;
      this.Name = $Prm0.Name;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::TA::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*shared field*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 101,
     FQN="clang::TemplateArgument::TA::operator=", NM="_ZN5clang16TemplateArgument2TAaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgument2TAaSEOS1_")
    //</editor-fold>
    public /*inline*/ TA /*&*/ $assignMove(final TA /*&&*/$Prm0) {
      TemplateArgument.this.Kind = $Prm0.getKind();
      this.NumExpansions = $Prm0.NumExpansions;
      this.Name = $Prm0.Name;
      return /*Deref*/this;
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public final int/*uint*/ getKind() {
      return TemplateArgument.this.Kind;
    }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Kind=" + Kind // NOI18N
                + ", NumExpansions=" + NumExpansions // NOI18N
                + ", Name=" + Name; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::TV">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*non static, extracted field Kind*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 106,
   FQN="clang::TemplateArgument::TV", NM="_ZN5clang16TemplateArgument2TVE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgument2TVE")
  //</editor-fold>
  private class/*struct*/ TV {
    public Object/*uintptr_t*/ V;
    //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::TV::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*shared field*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 106,
     FQN="clang::TemplateArgument::TV::operator=", NM="_ZN5clang16TemplateArgument2TVaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgument2TVaSERKS1_")
    //</editor-fold>
    public /*inline*/ TV /*&*/ $assign(final /*const*/ TV /*&*/ $Prm0) {
      TemplateArgument.this.Kind = $Prm0.getKind();
      this.V = $Prm0.V;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::TV::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*shared field*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 106,
     FQN="clang::TemplateArgument::TV::operator=", NM="_ZN5clang16TemplateArgument2TVaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgument2TVaSEOS1_")
    //</editor-fold>
    public /*inline*/ TV /*&*/ $assignMove(final TV /*&&*/$Prm0) {
      TemplateArgument.this.Kind = $Prm0.getKind();
      this.V = $Prm0.V;
      return /*Deref*/this;
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public final int/*uint*/ getKind() {
      return TemplateArgument.this.Kind;
    }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Kind=" + Kind // NOI18N
                + ", V=" + V; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::(anonymous)">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 110,
   FQN="clang::TemplateArgument::(anonymous)", NM="_ZN5clang16TemplateArgumentE_Unnamed_union6",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgumentE_Unnamed_union6")
  //</editor-fold>
  private class/*union*/ Unnamed_union6 {
    public final DA DeclArg = new DA();
    public final I Integer = new I();
    public final A Args = new A();
    public final TA TemplateArg = new TA();
    public final TV TypeOrValue = new TV();
    //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::(anonymous union)::">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 110,
     FQN="clang::TemplateArgument::(anonymous union)::", NM="_ZN5clang16TemplateArgumentUt_C1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgumentUt_C1ERKS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union6(final Unnamed_union6 $Prm0) {
      this.$assign($Prm0);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 110,
     FQN="clang::TemplateArgument::(anonymous union)::", NM="_ZN5clang16TemplateArgumentUt_C1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgumentUt_C1EOS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union6(JD$Move _dparam, final Unnamed_union6 $Prm0) {
      this.$assignMove($Prm0);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::(anonymous union)::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 110,
     FQN="clang::TemplateArgument::(anonymous union)::operator=", NM="_ZN5clang16TemplateArgumentUt_aSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgumentUt_aSERKS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union6 $assign(final Unnamed_union6 $Prm0) {
      assert this != $Prm0;
      this.DeclArg.$assign($Prm0.DeclArg);
      this.Integer.$assign($Prm0.Integer);
      this.Args.$assign($Prm0.Args);
      this.TemplateArg.$assign($Prm0.TemplateArg);
      this.TypeOrValue.$assign($Prm0.TypeOrValue);
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::(anonymous union)::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 110,
     FQN="clang::TemplateArgument::(anonymous union)::operator=", NM="_ZN5clang16TemplateArgumentUt_aSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgumentUt_aSEOS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union6 $assignMove(final Unnamed_union6 $Prm0) {
      assert this != $Prm0;
      this.DeclArg.$assignMove($Prm0.DeclArg);
      this.Integer.$assignMove($Prm0.Integer);
      this.Args.$assignMove($Prm0.Args);
      this.TemplateArg.$assignMove($Prm0.TemplateArg);
      this.TypeOrValue.$assignMove($Prm0.TypeOrValue);
      return /*Deref*/this;
    }

    private Unnamed_union6() {
    }
    
    @Override public String toString() {
      return "" + "DeclArg=" + DeclArg // NOI18N
                + ", Integer=" + Integer // NOI18N
                + ", Args=" + Args // NOI18N
                + ", TemplateArg=" + TemplateArg // NOI18N
                + ", TypeOrValue=" + TypeOrValue; // NOI18N
    }
  };
  private Unnamed_union6 Unnamed_field = new Unnamed_union6();
  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::TemplateArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 118,
   FQN="clang::TemplateArgument::TemplateArgument", NM="_ZN5clang16TemplateArgumentC1ENS_12TemplateNameEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgumentC1ENS_12TemplateNameEb")
  //</editor-fold>
  private TemplateArgument(TemplateName $Prm0, boolean $Prm1) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  /// \brief Construct an empty, invalid template argument.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::TemplateArgument">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*shared field*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 122,
   FQN="clang::TemplateArgument::TemplateArgument", NM="_ZN5clang16TemplateArgumentC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgumentC1Ev")
  //</editor-fold>
  public TemplateArgument() {
    this.Kind = ArgKind.Null.getValue();
    Unnamed_field.TypeOrValue.V = null;
  }

  
  /// \brief Construct a template type argument.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::TemplateArgument">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*shared field*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 128,
   FQN="clang::TemplateArgument::TemplateArgument", NM="_ZN5clang16TemplateArgumentC1ENS_8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgumentC1ENS_8QualTypeEb")
  //</editor-fold>
  public TemplateArgument(QualType T) {
    this(T, false);
  }
  public TemplateArgument(QualType T, boolean isNullPtr/*= false*/) {
    this.Kind = isNullPtr ? ArgKind.NullPtr.getValue() : ArgKind.Type.getValue();
    Unnamed_field.TypeOrValue.V = reinterpret_cast_Object/*uintptr_t*/(T.getAsOpaquePtr());
  }

  
  /// \brief Construct a template argument that refers to a
  /// declaration, which is either an external declaration or a
  /// template declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::TemplateArgument">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*shared field*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 136,
   FQN="clang::TemplateArgument::TemplateArgument", NM="_ZN5clang16TemplateArgumentC1EPNS_9ValueDeclENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgumentC1EPNS_9ValueDeclENS_8QualTypeE")
  //</editor-fold>
  public TemplateArgument(ValueDecl /*P*/ D, QualType QT) {
    assert ((D != null)) : "Expected decl";
    this.Kind = ArgKind.Declaration.getValue();
    Unnamed_field.DeclArg.QT = QT.getAsOpaquePtr();
    Unnamed_field.DeclArg.D = D;
  }

  
  /// \brief Construct an integral constant template argument. The memory to
  /// store the value is allocated with Ctx.
  
  /// \brief Construct an integral constant template argument. The memory to
  /// store the value is allocated with Ctx.
  
  //===----------------------------------------------------------------------===//
  // TemplateArgument Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::TemplateArgument">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*shared field*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp", line = 72,
   FQN="clang::TemplateArgument::TemplateArgument", NM="_ZN5clang16TemplateArgumentC1ERNS_10ASTContextERKN4llvm6APSIntENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZN5clang16TemplateArgumentC1ERNS_10ASTContextERKN4llvm6APSIntENS_8QualTypeE")
  //</editor-fold>
  public TemplateArgument(final ASTContext /*&*/ Ctx, final /*const*/ APSInt /*&*/ Value, 
      QualType Type) {
    this.Kind = ArgKind.Integral.getValue();
    // Copy the APSInt value into our decomposed form.
    Unnamed_field.Integer.BitWidth = Value.getBitWidth();
    Unnamed_field.Integer.IsUnsigned = Value.isUnsigned();
    // If the value is large, we have to get additional memory from the ASTContext
    /*uint*/int NumWords = Value.getNumWords();
    if ($greater_uint(NumWords, 1)) {
      Object/*void P*/ Mem = Ctx.Allocate(NumWords * $sizeof_ULong());
      std.memcpy((ulong$ptr) Mem, Value.getRawData(), NumWords * $sizeof_ULong());
      Unnamed_field.Integer.Unnamed_field3.pVal = $tryClone((reinterpret_cast(/*static_cast*/ulong$ptr/*uint64_t P*/ .class, (Mem))));
    } else {
      Unnamed_field.Integer.Unnamed_field3.VAL = Value.getZExtValue();
    }
    
    Unnamed_field.Integer.Type = Type.getAsOpaquePtr();
  }


  
  /// \brief Construct an integral constant template argument with the same
  /// value as Other but a different type.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::TemplateArgument">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*shared field*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 149,
   FQN="clang::TemplateArgument::TemplateArgument", NM="_ZN5clang16TemplateArgumentC1ERKS0_NS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgumentC1ERKS0_NS_8QualTypeE")
  //</editor-fold>
  public TemplateArgument(final /*const*/ TemplateArgument /*&*/ Other, QualType Type) {
    Unnamed_field.Integer.$assign(Other.Unnamed_field.Integer);
    Unnamed_field.Integer.Type = Type.getAsOpaquePtr();
  }

  
  /// \brief Construct a template argument that is a template.
  ///
  /// This form of template argument is generally used for template template
  /// parameters. However, the template name could be a dependent template
  /// name that ends up being instantiated to a function template whose address
  /// is taken.
  ///
  /// \param Name The template name.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::TemplateArgument">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*shared field*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 162,
   FQN="clang::TemplateArgument::TemplateArgument", NM="_ZN5clang16TemplateArgumentC1ENS_12TemplateNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgumentC1ENS_12TemplateNameE")
  //</editor-fold>
  public TemplateArgument(TemplateName Name) {
    this.Kind = ArgKind.Template.getValue();
    Unnamed_field.TemplateArg.Name = Name.getAsVoidPointer();
    Unnamed_field.TemplateArg.NumExpansions = 0;
  }

  
  /// \brief Construct a template argument that is a template pack expansion.
  ///
  /// This form of template argument is generally used for template template
  /// parameters. However, the template name could be a dependent template
  /// name that ends up being instantiated to a function template whose address
  /// is taken.
  ///
  /// \param Name The template name.
  ///
  /// \param NumExpansions The number of expansions that will be generated by
  /// instantiating
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::TemplateArgument">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*shared field*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 179,
   FQN="clang::TemplateArgument::TemplateArgument", NM="_ZN5clang16TemplateArgumentC1ENS_12TemplateNameEN4llvm8OptionalIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgumentC1ENS_12TemplateNameEN4llvm8OptionalIjEE")
  //</editor-fold>
  public TemplateArgument(TemplateName Name, OptionalUInt NumExpansions) {
    this.Kind = ArgKind.TemplateExpansion.getValue();
    Unnamed_field.TemplateArg.Name = Name.getAsVoidPointer();
    if (NumExpansions.$bool()) {
      Unnamed_field.TemplateArg.NumExpansions = NumExpansions.$star() + 1;
    } else {
      Unnamed_field.TemplateArg.NumExpansions = 0;
    }
  }

  
  /// \brief Construct a template argument that is an expression.
  ///
  /// This form of template argument only occurs in template argument
  /// lists used for dependent types and for expression; it will not
  /// occur in a non-dependent, canonical template argument list.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::TemplateArgument">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*shared field*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 193,
   FQN="clang::TemplateArgument::TemplateArgument", NM="_ZN5clang16TemplateArgumentC1EPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgumentC1EPNS_4ExprE")
  //</editor-fold>
  public TemplateArgument(Expr /*P*/ E) {
    this.Kind = ArgKind.Expression.getValue();
    Unnamed_field.TypeOrValue.V = reinterpret_cast_Object/*uintptr_t*/(E);
  }

  
  /// \brief Construct a template argument that is a template argument pack.
  ///
  /// We assume that storage for the template arguments provided
  /// outlives the TemplateArgument itself.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::TemplateArgument">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*shared field*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 202,
   FQN="clang::TemplateArgument::TemplateArgument", NM="_ZN5clang16TemplateArgumentC1EN4llvm8ArrayRefIS0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgumentC1EN4llvm8ArrayRefIS0_EE")
  //</editor-fold>
  public /*explicit*/ TemplateArgument(ArrayRef<TemplateArgument> Args) {
    this.Kind = ArgKind.Pack.getValue();
    this.Unnamed_field.Args.Args = $tryConstClone(Args.data());
    this.Unnamed_field.Args.NumArgs = Args.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::getEmptyPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 208,
   FQN="clang::TemplateArgument::getEmptyPack", NM="_ZN5clang16TemplateArgument12getEmptyPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgument12getEmptyPackEv")
  //</editor-fold>
  public static TemplateArgument getEmptyPack() {
    return new TemplateArgument(new ArrayRef<TemplateArgument>(None, false));
  }

  
  /// \brief Create a new template argument pack by copying the given set of
  /// template arguments.
  
  /// \brief Create a new template argument pack by copying the given set of
  /// template arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::CreatePackCopy">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp", line = 91,
   FQN="clang::TemplateArgument::CreatePackCopy", NM="_ZN5clang16TemplateArgument14CreatePackCopyERNS_10ASTContextEN4llvm8ArrayRefIS0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZN5clang16TemplateArgument14CreatePackCopyERNS_10ASTContextEN4llvm8ArrayRefIS0_EE")
  //</editor-fold>
  public static TemplateArgument CreatePackCopy(final ASTContext /*&*/ Context, 
                ArrayRef<TemplateArgument> Args) {
    if (Args.empty()) {
      return getEmptyPack();
    }
    
    return new TemplateArgument(Args.copy(TemplateArgument.class, Context));
  }


  
  /// \brief Return the kind of stored template argument.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 216,
   FQN="clang::TemplateArgument::getKind", NM="_ZNK5clang16TemplateArgument7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang16TemplateArgument7getKindEv")
  //</editor-fold>
  public ArgKind getKind() /*const*/ {
    return ArgKind.valueOf(this.Kind);
  }

  
  /// \brief Determine whether this template argument has no value.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::isNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 219,
   FQN="clang::TemplateArgument::isNull", NM="_ZNK5clang16TemplateArgument6isNullEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang16TemplateArgument6isNullEv")
  //</editor-fold>
  public boolean isNull() /*const*/ {
    return getKind() == ArgKind.Null;
  }

  
  /// \brief Whether this template argument is dependent on a template
  /// parameter such that its result can change from one instantiation to
  /// another.
  
  /// \brief Whether this template argument is dependent on a template
  /// parameter such that its result can change from one instantiation to
  /// another.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::isDependent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp", line = 100,
   FQN="clang::TemplateArgument::isDependent", NM="_ZNK5clang16TemplateArgument11isDependentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZNK5clang16TemplateArgument11isDependentEv")
  //</editor-fold>
  public boolean isDependent() /*const*/ {
    switch (getKind()) {
     case Null:
      throw new llvm_unreachable("Should not have a NULL template argument");
     case Type:
      return getAsType().$arrow().isDependentType()
         || isa_PackExpansionType(getAsType());
     case Template:
      return getAsTemplate().isDependent();
     case TemplateExpansion:
      return true;
     case Declaration:
      {
        DeclContext /*P*/ DC = dyn_cast_DeclContext(getAsDecl());
        if ((DC != null)) {
          return DC.isDependentContext();
        }
      }
      return getAsDecl().getDeclContext().isDependentContext();
     case NullPtr:
      return false;
     case Integral:
      // Never dependent
      return false;
     case Expression:
      return (getAsExpr().isTypeDependent() || getAsExpr().isValueDependent()
         || isa_PackExpansionExpr(getAsExpr()));
     case Pack:
      for (final /*const*/ TemplateArgument /*&*/ P : pack_elements())  {
        if (P.isDependent()) {
          return true;
        }
      }
      return false;
    }
    throw new llvm_unreachable("Invalid TemplateArgument Kind!");
  }


  
  /// \brief Whether this template argument is dependent on a template
  /// parameter.
  
  /// \brief Whether this template argument is dependent on a template
  /// parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::isInstantiationDependent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp", line = 141,
   FQN="clang::TemplateArgument::isInstantiationDependent", NM="_ZNK5clang16TemplateArgument24isInstantiationDependentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZNK5clang16TemplateArgument24isInstantiationDependentEv")
  //</editor-fold>
  public boolean isInstantiationDependent() /*const*/ {
    switch (getKind()) {
     case Null:
      throw new llvm_unreachable("Should not have a NULL template argument");
     case Type:
      return getAsType().$arrow().isInstantiationDependentType();
     case Template:
      return getAsTemplate().isInstantiationDependent();
     case TemplateExpansion:
      return true;
     case Declaration:
      {
        DeclContext /*P*/ DC = dyn_cast_DeclContext(getAsDecl());
        if ((DC != null)) {
          return DC.isDependentContext();
        }
      }
      return getAsDecl().getDeclContext().isDependentContext();
     case NullPtr:
      return false;
     case Integral:
      // Never dependent
      return false;
     case Expression:
      return getAsExpr().isInstantiationDependent();
     case Pack:
      for (final /*const*/ TemplateArgument /*&*/ P : pack_elements())  {
        if (P.isInstantiationDependent()) {
          return true;
        }
      }
      return false;
    }
    throw new llvm_unreachable("Invalid TemplateArgument Kind!");
  }


  
  /// \brief Whether this template argument contains an unexpanded
  /// parameter pack.
  
  /// \brief Whether this template argument contains an unexpanded
  /// parameter pack.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::containsUnexpandedParameterPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp", line = 203,
   FQN="clang::TemplateArgument::containsUnexpandedParameterPack", NM="_ZNK5clang16TemplateArgument31containsUnexpandedParameterPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZNK5clang16TemplateArgument31containsUnexpandedParameterPackEv")
  //</editor-fold>
  public boolean containsUnexpandedParameterPack() /*const*/ {
    switch (getKind()) {
     case Null:
     case Declaration:
     case Integral:
     case TemplateExpansion:
     case NullPtr:
      break;
     case Type:
      if (getAsType().$arrow().containsUnexpandedParameterPack()) {
        return true;
      }
      break;
     case Template:
      if (getAsTemplate().containsUnexpandedParameterPack()) {
        return true;
      }
      break;
     case Expression:
      if (getAsExpr().containsUnexpandedParameterPack()) {
        return true;
      }
      break;
     case Pack:
      for (final /*const*/ TemplateArgument /*&*/ P : pack_elements())  {
        if (P.containsUnexpandedParameterPack()) {
          return true;
        }
      }
      
      break;
    }
    
    return false;
  }


  
  /// \brief Determine whether this template argument is a pack expansion.
  
  /// \brief Determine whether this template argument is a pack expansion.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::isPackExpansion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp", line = 180,
   FQN="clang::TemplateArgument::isPackExpansion", NM="_ZNK5clang16TemplateArgument15isPackExpansionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZNK5clang16TemplateArgument15isPackExpansionEv")
  //</editor-fold>
  public boolean isPackExpansion() /*const*/ {
    switch (getKind()) {
     case Null:
     case Declaration:
     case Integral:
     case Pack:
     case Template:
     case NullPtr:
      return false;
     case TemplateExpansion:
      return true;
     case Type:
      return isa_PackExpansionType(getAsType());
     case Expression:
      return isa_PackExpansionExpr(getAsExpr());
    }
    throw new llvm_unreachable("Invalid TemplateArgument Kind!");
  }


  
  /// \brief Retrieve the type for a type template argument.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::getAsType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 238,
   FQN="clang::TemplateArgument::getAsType", NM="_ZNK5clang16TemplateArgument9getAsTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang16TemplateArgument9getAsTypeEv")
  //</editor-fold>
  public QualType getAsType() /*const*/ {
    assert (getKind() == ArgKind.Type) : "Unexpected kind";
    return QualType.getFromOpaquePtr(reinterpret_cast(Object/*void P*/ .class, Unnamed_field.TypeOrValue.V));
  }

  
  /// \brief Retrieve the declaration for a declaration non-type
  /// template argument.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::getAsDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 245,
   FQN="clang::TemplateArgument::getAsDecl", NM="_ZNK5clang16TemplateArgument9getAsDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang16TemplateArgument9getAsDeclEv")
  //</editor-fold>
  public ValueDecl /*P*/ getAsDecl() /*const*/ {
    assert (getKind() == ArgKind.Declaration) : "Unexpected kind";
    return Unnamed_field.DeclArg.D;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::getParamTypeForDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 250,
   FQN="clang::TemplateArgument::getParamTypeForDecl", NM="_ZNK5clang16TemplateArgument19getParamTypeForDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang16TemplateArgument19getParamTypeForDeclEv")
  //</editor-fold>
  public QualType getParamTypeForDecl() /*const*/ {
    assert (getKind() == ArgKind.Declaration) : "Unexpected kind";
    return QualType.getFromOpaquePtr(Unnamed_field.DeclArg.QT);
  }

  
  /// \brief Retrieve the type for null non-type template argument.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::getNullPtrType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 256,
   FQN="clang::TemplateArgument::getNullPtrType", NM="_ZNK5clang16TemplateArgument14getNullPtrTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang16TemplateArgument14getNullPtrTypeEv")
  //</editor-fold>
  public QualType getNullPtrType() /*const*/ {
    assert (getKind() == ArgKind.NullPtr) : "Unexpected kind";
    return QualType.getFromOpaquePtr(reinterpret_cast(Object/*void P*/ .class, Unnamed_field.TypeOrValue.V));
  }

  
  /// \brief Retrieve the template name for a template name argument.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::getAsTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 262,
   FQN="clang::TemplateArgument::getAsTemplate", NM="_ZNK5clang16TemplateArgument13getAsTemplateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang16TemplateArgument13getAsTemplateEv")
  //</editor-fold>
  public TemplateName getAsTemplate() /*const*/ {
    assert (getKind() == ArgKind.Template) : "Unexpected kind";
    return TemplateName.getFromVoidPointer(Unnamed_field.TemplateArg.Name);
  }

  
  /// \brief Retrieve the template argument as a template name; if the argument
  /// is a pack expansion, return the pattern as a template name.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::getAsTemplateOrTemplatePattern">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 269,
   FQN="clang::TemplateArgument::getAsTemplateOrTemplatePattern", NM="_ZNK5clang16TemplateArgument30getAsTemplateOrTemplatePatternEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang16TemplateArgument30getAsTemplateOrTemplatePatternEv")
  //</editor-fold>
  public TemplateName getAsTemplateOrTemplatePattern() /*const*/ {
    assert ((getKind() == ArgKind.Template || getKind() == ArgKind.TemplateExpansion)) : "Unexpected kind";
    
    return TemplateName.getFromVoidPointer(Unnamed_field.TemplateArg.Name);
  }

  
  /// \brief Retrieve the number of expansions that a template template argument
  /// expansion will produce, if known.
  
  /// \brief Retrieve the number of expansions that a template template argument
  /// expansion will produce, if known.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::getNumTemplateExpansions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp", line = 238,
   FQN="clang::TemplateArgument::getNumTemplateExpansions", NM="_ZNK5clang16TemplateArgument24getNumTemplateExpansionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZNK5clang16TemplateArgument24getNumTemplateExpansionsEv")
  //</editor-fold>
  public OptionalUInt getNumTemplateExpansions() /*const*/ {
    assert (getKind() == ArgKind.TemplateExpansion);
    if ((Unnamed_field.TemplateArg.NumExpansions != 0)) {
      return new OptionalUInt(JD$T$RR.INSTANCE, Unnamed_field.TemplateArg.NumExpansions - 1);
    }
    
    return new OptionalUInt(None);
  }


  
  /// \brief Retrieve the template argument as an integral value.
  // FIXME: Provide a way to read the integral data without copying the value.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::getAsIntegral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 282,
   FQN="clang::TemplateArgument::getAsIntegral", NM="_ZNK5clang16TemplateArgument13getAsIntegralEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang16TemplateArgument13getAsIntegralEv")
  //</editor-fold>
  public APSInt getAsIntegral() /*const*/ {
    assert (getKind() == ArgKind.Integral) : "Unexpected kind";
    //JAVA: using namespace llvm;
    if (Unnamed_field.Integer.BitWidth <= $int2uint_31bits(64)) {
      return new APSInt(new APInt(Unnamed_field.Integer.BitWidth, Unnamed_field.Integer.Unnamed_field3.VAL), Unnamed_field.Integer.IsUnsigned);
    }
    
    /*uint*/int NumWords = APInt.getNumWords(Unnamed_field.Integer.BitWidth);
    return new APSInt(new APInt(Unnamed_field.Integer.BitWidth, makeArrayRef(Unnamed_field.Integer.Unnamed_field3.pVal, NumWords)), 
        Unnamed_field.Integer.IsUnsigned);
  }

  
  /// \brief Retrieve the type of the integral value.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::getIntegralType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 294,
   FQN="clang::TemplateArgument::getIntegralType", NM="_ZNK5clang16TemplateArgument15getIntegralTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang16TemplateArgument15getIntegralTypeEv")
  //</editor-fold>
  public QualType getIntegralType() /*const*/ {
    assert (getKind() == ArgKind.Integral) : "Unexpected kind";
    return QualType.getFromOpaquePtr(Unnamed_field.Integer.Type);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::setIntegralType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 299,
   FQN="clang::TemplateArgument::setIntegralType", NM="_ZN5clang16TemplateArgument15setIntegralTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgument15setIntegralTypeENS_8QualTypeE")
  //</editor-fold>
  public void setIntegralType(QualType T) {
    assert (getKind() == ArgKind.Integral) : "Unexpected kind";
    Unnamed_field.Integer.Type = T.getAsOpaquePtr();
  }

  
  /// \brief Retrieve the template argument as an expression.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::getAsExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 305,
   FQN="clang::TemplateArgument::getAsExpr", NM="_ZNK5clang16TemplateArgument9getAsExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang16TemplateArgument9getAsExprEv")
  //</editor-fold>
  public Expr /*P*/ getAsExpr() /*const*/ {
    assert (getKind() == ArgKind.Expression) : "Unexpected kind";
    return reinterpret_cast(Expr /*P*/ .class, Unnamed_field.TypeOrValue.V);
  }

  
  /// \brief Iterator that traverses the elements of a template argument pack.
  /*typedef const TemplateArgument *pack_iterator*/
//  public final class pack_iterator extends /*const*/type$ptr<TemplateArgument/*P*/> { };
  
  /// \brief Iterator referencing the first argument of a template argument
  /// pack.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::pack_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 315,
   FQN="clang::TemplateArgument::pack_begin", NM="_ZNK5clang16TemplateArgument10pack_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang16TemplateArgument10pack_beginEv")
  //</editor-fold>
  public type$ptr<TemplateArgument>/*pack_iterator*/ pack_begin() /*const*/ {
    assert (getKind() == ArgKind.Pack);
    return Unnamed_field.Args.Args;
  }

  
  /// \brief Iterator referencing one past the last argument of a template
  /// argument pack.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::pack_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 322,
   FQN="clang::TemplateArgument::pack_end", NM="_ZNK5clang16TemplateArgument8pack_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang16TemplateArgument8pack_endEv")
  //</editor-fold>
  public type$ptr<TemplateArgument>/*pack_iterator*/ pack_end() /*const*/ {
    assert (getKind() == ArgKind.Pack);
    return Unnamed_field.Args.Args.$add(Unnamed_field.Args.NumArgs);
  }

  
  /// \brief Iterator range referencing all of the elements of a template
  /// argument pack.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::pack_elements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 329,
   FQN="clang::TemplateArgument::pack_elements", NM="_ZNK5clang16TemplateArgument13pack_elementsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang16TemplateArgument13pack_elementsEv")
  //</editor-fold>
  public iterator_range</*const*/ TemplateArgument> pack_elements() /*const*/ {
    return llvm.make_range(pack_begin(), pack_end());
  }

  
  /// \brief The number of template arguments in the given template argument
  /// pack.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::pack_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 335,
   FQN="clang::TemplateArgument::pack_size", NM="_ZNK5clang16TemplateArgument9pack_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang16TemplateArgument9pack_sizeEv")
  //</editor-fold>
  public /*uint*/int pack_size() /*const*/ {
    assert (getKind() == ArgKind.Pack);
    return Unnamed_field.Args.NumArgs;
  }

  
  /// \brief Return the array of arguments in this template argument pack.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::getPackAsArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 341,
   FQN="clang::TemplateArgument::getPackAsArray", NM="_ZNK5clang16TemplateArgument14getPackAsArrayEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang16TemplateArgument14getPackAsArrayEv")
  //</editor-fold>
  public ArrayRef<TemplateArgument> getPackAsArray() /*const*/ {
    assert (getKind() == ArgKind.Pack);
    return llvm.makeArrayRef(Unnamed_field.Args.Args, Unnamed_field.Args.NumArgs);
  }

  
  /// \brief Determines whether two template arguments are superficially the
  /// same.
  
  /// \brief Determines whether two template arguments are superficially the
  /// same.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::structurallyEquals">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*eq_ptr instead of ==*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp", line = 299,
   FQN="clang::TemplateArgument::structurallyEquals", NM="_ZNK5clang16TemplateArgument18structurallyEqualsERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZNK5clang16TemplateArgument18structurallyEqualsERKS0_")
  //</editor-fold>
  public boolean structurallyEquals(final /*const*/ TemplateArgument /*&*/ Other) /*const*/ {
    if (getKind() != Other.getKind()) {
      return false;
    }
    switch (getKind()) {
     case Null:
     case Type:
     case Expression:
     case Template:
     case TemplateExpansion:
     case NullPtr:
      return Native.$eq_ptr(Unnamed_field.TypeOrValue.V, Other.Unnamed_field.TypeOrValue.V);
     case Declaration:
      return getAsDecl() == Other.getAsDecl();
     case Integral:
      return $eq_QualType$C(getIntegralType(), Other.getIntegralType())
         && getAsIntegral().$eq(Other.getAsIntegral());
     case Pack:
      if (Unnamed_field.Args.NumArgs != Other.Unnamed_field.Args.NumArgs) {
        return false;
      }
      for (/*uint*/int I = 0, E = Unnamed_field.Args.NumArgs; I != E; ++I)  {
        if (!Unnamed_field.Args.Args.$at(I).structurallyEquals(Other.Unnamed_field.Args.Args.$at(I))) {
          return false;
        }
      }
      return true;
    }
    throw new llvm_unreachable("Invalid TemplateArgument Kind!");
  }


  
  /// \brief When the template argument is a pack expansion, returns
  /// the pattern of the pack expansion.
  
  /// \brief When the template argument is a pack expansion, returns
  /// the pattern of the pack expansion.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::getPackExpansionPattern">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp", line = 329,
   FQN="clang::TemplateArgument::getPackExpansionPattern", NM="_ZNK5clang16TemplateArgument23getPackExpansionPatternEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZNK5clang16TemplateArgument23getPackExpansionPatternEv")
  //</editor-fold>
  public TemplateArgument getPackExpansionPattern() /*const*/ {
    assert (isPackExpansion());
    switch (getKind()) {
     case Type:
      return new TemplateArgument(getAsType().$arrow().getAs(PackExpansionType.class).getPattern());
     case Expression:
      return new TemplateArgument(cast_PackExpansionExpr(getAsExpr()).getPattern());
     case TemplateExpansion:
      return new TemplateArgument(getAsTemplateOrTemplatePattern());
     case Declaration:
     case Integral:
     case Pack:
     case Null:
     case Template:
     case NullPtr:
      return new TemplateArgument();
    }
    throw new llvm_unreachable("Invalid TemplateArgument Kind!");
  }


  
  /// \brief Print this template argument to the given output stream.
  
  /// \brief Print this template argument to the given output stream.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::print">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp", line = 354,
   FQN="clang::TemplateArgument::print", NM="_ZNK5clang16TemplateArgument5printERKNS_14PrintingPolicyERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZNK5clang16TemplateArgument5printERKNS_14PrintingPolicyERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void print(final /*const*/ PrintingPolicy /*&*/ Policy, 
       final raw_ostream /*&*/ Out) /*const*/ {
    switch (getKind()) {
     case Null:
      Out.$out(/*KEEP_STR*/"(no value)");
      break;
     case Type:
      {
        PrintingPolicy SubPolicy/*J*/= new PrintingPolicy(Policy);
        SubPolicy.SuppressStrongLifetime = true;
        getAsType().print(Out, SubPolicy);
        break;
      }
     case Declaration:
      {
        NamedDecl /*P*/ ND = cast_NamedDecl(getAsDecl());
        Out.$out_char($$AMP);
        if (ND.getDeclName().$bool()) {
          // FIXME: distinguish between pointer and reference args?
          ND.printQualifiedName(Out);
        } else {
          Out.$out(/*KEEP_STR*/"(anonymous)");
        }
        break;
      }
     case NullPtr:
      Out.$out(/*KEEP_STR*/$nullptr);
      break;
     case Template:
      getAsTemplate().print(Out, Policy);
      break;
     case TemplateExpansion:
      getAsTemplateOrTemplatePattern().print(Out, Policy);
      Out.$out(/*KEEP_STR*/$ELLIPSIS);
      break;
     case Integral:
      {
        TemplateBaseStatics.printIntegral(/*Deref*/this, Out, Policy);
        break;
      }
     case Expression:
      getAsExpr().printPretty(Out, (PrinterHelper /*P*/ )null, Policy);
      break;
     case Pack:
      Out.$out(/*KEEP_STR*/$LT);
      boolean First = true;
      for (final /*const*/ TemplateArgument /*&*/ P : pack_elements()) {
        if (First) {
          First = false;
        } else {
          Out.$out(/*KEEP_STR*/$COMMA_SPACE);
        }
        
        P.print(Policy, Out);
      }
      Out.$out(/*KEEP_STR*/$GT);
      break;
    }
  }


  
  /// \brief Debugging aid that dumps the template argument.
  
  /// \brief Debugging aid that dumps the template argument.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp", line = 418,
   FQN="clang::TemplateArgument::dump", NM="_ZNK5clang16TemplateArgument4dumpERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZNK5clang16TemplateArgument4dumpERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void dump(final raw_ostream /*&*/ Out) /*const*/ {
    LangOptions LO/*J*/= new LangOptions(); // FIXME! see also TemplateName::dump().
    LO.CPlusPlus = true;
    LO.Bool = true;
    print(new PrintingPolicy(LO), Out);
  }


  
  /// \brief Debugging aid that dumps the template argument to standard error.
  
  /// \brief Debugging aid that dumps the template argument to standard error.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp", line = 425,
   FQN="clang::TemplateArgument::dump", NM="_ZNK5clang16TemplateArgument4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZNK5clang16TemplateArgument4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    dump(llvm.errs());
  }


  
  /// \brief Used to insert TemplateArguments into FoldingSets.
  
  /// \brief Used to insert TemplateArguments into FoldingSets.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp", line = 246,
   FQN="clang::TemplateArgument::Profile", NM="_ZNK5clang16TemplateArgument7ProfileERN4llvm16FoldingSetNodeIDERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZNK5clang16TemplateArgument7ProfileERN4llvm16FoldingSetNodeIDERKNS_10ASTContextE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID, 
         final /*const*/ ASTContext /*&*/ Context) /*const*/ {
    ID.AddInteger_int(getKind().getValue());
    switch (getKind()) {
     case Null:
      break;
     case Type:
      getAsType().Profile(ID);
      break;
     case NullPtr:
      getNullPtrType().Profile(ID);
      break;
     case Declaration:
      ID.AddPointer((getAsDecl() != null) ? getAsDecl().getCanonicalDecl() : (Decl /*P*/ )null);
      break;
     case Template:
     case TemplateExpansion:
      {
        TemplateName Template = getAsTemplateOrTemplatePattern();
        {
          TemplateTemplateParmDecl /*P*/ TTP = dyn_cast_or_null_TemplateTemplateParmDecl(Template.getAsTemplateDecl());
          if ((TTP != null)) {
            ID.AddBoolean(true);
            ID.AddInteger_uint(TTP.getDepth());
            ID.AddInteger_uint(TTP.getPosition());
            ID.AddBoolean(TTP.isParameterPack());
          } else {
            ID.AddBoolean(false);
            ID.AddPointer(Context.getCanonicalTemplateName(new TemplateName(Template)).
                    getAsVoidPointer());
          }
        }
        break;
      }
     case Integral:
      getAsIntegral().Profile(ID);
      getIntegralType().Profile(ID);
      break;
     case Expression:
      getAsExpr().Profile(ID, Context, true);
      break;
     case Pack:
      ID.AddInteger_uint(Unnamed_field.Args.NumArgs);
      for (/*uint*/int I = 0; I != Unnamed_field.Args.NumArgs; ++I)  {
        Unnamed_field.Args.Args.$at(I).Profile(ID, Context);
      }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::TemplateArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 40,
   FQN="clang::TemplateArgument::TemplateArgument", NM="_ZN5clang16TemplateArgumentC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgumentC1ERKS0_")
  //</editor-fold>
  public /*inline*/ TemplateArgument(final /*const*/ TemplateArgument /*&*/ $Prm0) {
    // : Unnamed_field(.) 
    //START JInit
    this.Unnamed_field = new Unnamed_union6($Prm0.Unnamed_field);
    //END JInit
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::TemplateArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 40,
   FQN="clang::TemplateArgument::TemplateArgument", NM="_ZN5clang16TemplateArgumentC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgumentC1EOS0_")
  //</editor-fold>
  public /*inline*/ TemplateArgument(JD$Move _dparam, final TemplateArgument /*&&*/$Prm0) {
    // : Unnamed_field(static_cast<TemplateArgument &&>().) 
    //START JInit
    this.Unnamed_field = new Unnamed_union6(JD$Move.INSTANCE, $Prm0.Unnamed_field);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 40,
   FQN="clang::TemplateArgument::operator=", NM="_ZN5clang16TemplateArgumentaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgumentaSERKS0_")
  //</editor-fold>
  public /*inline*/ TemplateArgument /*&*/ $assign(final /*const*/ TemplateArgument /*&*/ $Prm0) {
    this.Unnamed_field.$assign($Prm0.Unnamed_field);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgument::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 40,
   FQN="clang::TemplateArgument::operator=", NM="_ZN5clang16TemplateArgumentaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang16TemplateArgumentaSEOS0_")
  //</editor-fold>
  public /*inline*/ TemplateArgument /*&*/ $assignMove(final TemplateArgument /*&&*/$Prm0) {
    this.Unnamed_field.$assignMove($Prm0.Unnamed_field);
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private /*uint*/int Kind;
  
  @Override
  public TemplateArgument clone() {
    assert this.getClass() == TemplateArgument.class : "derived class must override clone " + this.getClass();
    return new TemplateArgument(this);
  }

  public /*inline*/ TemplateArgument(type$ptr<?> This$Mem, final /*const*/ TemplateArgument /*&*/ $Prm0) {
    // : Unnamed_field(.) 
    //START JInit
    TrailingObjectsUtils.$putThisAndShift(this, This$Mem);
    this.Unnamed_field = new Unnamed_union6($Prm0.Unnamed_field);
    //END JInit
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Unnamed_field=" + Unnamed_field; // NOI18N
  }
}
