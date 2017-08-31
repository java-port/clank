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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.llvm.adt.java.TrailingObjectsUtils;

/// @brief Represents a C99 designated initializer expression.
///
/// A designated initializer expression (C99 6.7.8) contains one or
/// more designators (which can be field designators, array
/// designators, or GNU array-range designators) followed by an
/// expression that initializes the field or element(s) that the
/// designators refer to. For example, given:
///
/// @code
/// struct point {
///   double x;
///   double y;
/// };
/// struct point ptarray[10] = { [2].y = 1.0, [2].x = 2.0, [0].x = 1.0 };
/// @endcode
///
/// The InitListExpr contains three DesignatedInitExprs, the first of
/// which covers @c [2].y=1.0. This DesignatedInitExpr will have two
/// designators, one array designator for @c [2] followed by one field
/// designator for @c .y. The initialization expression will be 1.0.
//<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3953,
 FQN="clang::DesignatedInitExpr", NM="_ZN5clang18DesignatedInitExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang18DesignatedInitExprE")
//</editor-fold>
public final class DesignatedInitExpr extends /*public*/ Expr implements /*private*/ TrailingObjects<DesignatedInitExpr, Stmt /*P*/ > {
/*public:*/
  /// \brief Forward declaration of the Designator class.
  
  /// @brief Represents a single C99 designator.
  ///
  /// @todo This class is infuriatingly similar to clang::Designator,
  /// but minor differences (storing indices vs. storing pointers)
  /// keep us from reusing it. Try harder, later, to rectify these
  /// differences.
  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4028,
   FQN="clang::DesignatedInitExpr::Designator", NM="_ZN5clang18DesignatedInitExpr10DesignatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang18DesignatedInitExpr10DesignatorE")
  //</editor-fold>
  public static class Designator implements NativeCloneable<Designator>, Native.assignable<Designator>, NativeMoveable<Designator> {
    /// @brief The kind of designator this describes.
    //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4030,
     FQN="clang::DesignatedInitExpr::Designator::(anonymous)", NM="_ZN5clang18DesignatedInitExpr10DesignatorE_Unnamed_enum",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang18DesignatedInitExpr10DesignatorE_Unnamed_enum")
    //</editor-fold>
    private enum Unnamed_enum implements Native.ComparableLower {
      FieldDesignator(0),
      ArrayDesignator(FieldDesignator.getValue() + 1),
      ArrayRangeDesignator(ArrayDesignator.getValue() + 1);

      //<editor-fold defaultstate="collapsed" desc="hidden">
      public static Unnamed_enum valueOf(int val) {
        Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final Unnamed_enum[] VALUES;
        private static final Unnamed_enum[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (Unnamed_enum kind : Unnamed_enum.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
          VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
          for (Unnamed_enum kind : Unnamed_enum.values()) {
            if (kind.value < 0) {
              _VALUES[-kind.value] = kind;
            } else {
              VALUES[kind.value] = kind;
            }
          }
        }
      }

      private final /*uint*/int value;
      private Unnamed_enum(int val) { this.value = (/*uint*/int)val;}
      public /*uint*/int getValue() { return value;}
      @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Unnamed_enum)obj).value);}
      @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Unnamed_enum)obj).value);}
      //</editor-fold>
    };
    private Unnamed_enum Kind;
    //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4036,
     FQN="clang::DesignatedInitExpr::Designator::(anonymous)", NM="_ZN5clang18DesignatedInitExpr10DesignatorE_Unnamed_union1",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang18DesignatedInitExpr10DesignatorE_Unnamed_union1")
    //</editor-fold>
    private static class/*union*/ Unnamed_union1 {
      /// A field designator, e.g., ".x".
      public final FieldDesignator Field = new FieldDesignator();
      /// An array or GNU array-range designator, e.g., "[9]" or "[10..15]".
      public final ArrayOrRangeDesignator ArrayOrRange = new ArrayOrRangeDesignator();
      
      //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator::(anonymous union)::">
      @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*assign fields*/,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4036,
       FQN="clang::DesignatedInitExpr::Designator::(anonymous union)::", NM="_ZN5clang18DesignatedInitExpr10DesignatorUt0_C1ERKS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang18DesignatedInitExpr10DesignatorUt0_C1ERKS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_union1(final Unnamed_union1 $Prm0) {
        $assign($Prm0);
      }

      
      //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator::(anonymous union)::">
      @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*assign fields*/,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4036,
       FQN="clang::DesignatedInitExpr::Designator::(anonymous union)::", NM="_ZN5clang18DesignatedInitExpr10DesignatorUt0_C1EOS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang18DesignatedInitExpr10DesignatorUt0_C1EOS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_union1(JD$Move _dparam, final Unnamed_union1 $Prm0) {
        $assignMove($Prm0);
      }

      
      //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator::(anonymous union)::operator=">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4036,
       FQN="clang::DesignatedInitExpr::Designator::(anonymous union)::operator=", NM="_ZN5clang18DesignatedInitExpr10DesignatorUt0_aSEOS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang18DesignatedInitExpr10DesignatorUt0_aSEOS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_union1 $assignMove(final Unnamed_union1 $Prm0) {
        
        this.Field.$assignMove($Prm0.Field);
        
        this.ArrayOrRange.$assignMove($Prm0.ArrayOrRange);
        
        return /*Deref*/this;
      }


      //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator::(anonymous union)::operator=">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4036,
       FQN="clang::DesignatedInitExpr::Designator::(anonymous union)::operator=", NM="_ZN5clang18DesignatedInitExpr10DesignatorUt0_aSERKS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang18DesignatedInitExpr10DesignatorUt0_aSERKS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_union1 $assign(final Unnamed_union1 $Prm0) {
        
        this.Field.$assign($Prm0.Field);
        
        this.ArrayOrRange.$assign($Prm0.ArrayOrRange);
        
        return /*Deref*/this;
      }

      public Unnamed_union1() {
      }
      
      @Override public String toString() {
        return "" + "Field=" + Field // NOI18N
                  + ", ArrayOrRange=" + ArrayOrRange; // NOI18N
      }
    };
    private final Unnamed_union1 Unnamed_field1;
    /*friend  class DesignatedInitExpr*/
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator::Designator">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4045,
     FQN="clang::DesignatedInitExpr::Designator::Designator", NM="_ZN5clang18DesignatedInitExpr10DesignatorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang18DesignatedInitExpr10DesignatorC1Ev")
    //</editor-fold>
    public Designator() {
      this.Kind = Unnamed_enum.valueOf(0);
      this.Unnamed_field1 = new Unnamed_union1();
    }

    
    /// @brief Initializes a field designator.
    //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator::Designator">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4048,
     FQN="clang::DesignatedInitExpr::Designator::Designator", NM="_ZN5clang18DesignatedInitExpr10DesignatorC1EPKNS_14IdentifierInfoENS_14SourceLocationES5_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang18DesignatedInitExpr10DesignatorC1EPKNS_14IdentifierInfoENS_14SourceLocationES5_")
    //</editor-fold>
    public Designator(/*const*/ IdentifierInfo /*P*/ FieldName, SourceLocation DotLoc, 
        SourceLocation FieldLoc) {
      // : Kind(FieldDesignator) 
      //START JInit
      this.Kind = Unnamed_enum.FieldDesignator;
      //END JInit
      this.Unnamed_field1 = new Unnamed_union1();
      Unnamed_field1.Field.NameOrField.$assignMove(new PointerBoolPair<>/*uintptr_t*/(FieldName, true));// | 0x01;
      Unnamed_field1.Field.DotLoc = DotLoc.getRawEncoding();
      Unnamed_field1.Field.FieldLoc = FieldLoc.getRawEncoding();
    }

    
    /// @brief Initializes an array designator.
    //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator::Designator">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4057,
     FQN="clang::DesignatedInitExpr::Designator::Designator", NM="_ZN5clang18DesignatedInitExpr10DesignatorC1EjNS_14SourceLocationES2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang18DesignatedInitExpr10DesignatorC1EjNS_14SourceLocationES2_")
    //</editor-fold>
    public Designator(/*uint*/int Index, SourceLocation LBracketLoc, 
        SourceLocation RBracketLoc) {
      // : Kind(ArrayDesignator) 
      //START JInit
      this.Kind = Unnamed_enum.ArrayDesignator;
      //END JInit
      this.Unnamed_field1 = new Unnamed_union1();
      Unnamed_field1.ArrayOrRange.Index = Index;
      Unnamed_field1.ArrayOrRange.LBracketLoc = LBracketLoc.getRawEncoding();
      Unnamed_field1.ArrayOrRange.EllipsisLoc = new SourceLocation().getRawEncoding();
      Unnamed_field1.ArrayOrRange.RBracketLoc = RBracketLoc.getRawEncoding();
    }

    
    /// @brief Initializes a GNU array-range designator.
    //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator::Designator">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4067,
     FQN="clang::DesignatedInitExpr::Designator::Designator", NM="_ZN5clang18DesignatedInitExpr10DesignatorC1EjNS_14SourceLocationES2_S2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang18DesignatedInitExpr10DesignatorC1EjNS_14SourceLocationES2_S2_")
    //</editor-fold>
    public Designator(/*uint*/int Index, SourceLocation LBracketLoc, 
        SourceLocation EllipsisLoc, SourceLocation RBracketLoc) {
      // : Kind(ArrayRangeDesignator) 
      //START JInit
      this.Kind = Unnamed_enum.ArrayRangeDesignator;
      //END JInit
      this.Unnamed_field1 = new Unnamed_union1();
      Unnamed_field1.ArrayOrRange.Index = Index;
      Unnamed_field1.ArrayOrRange.LBracketLoc = LBracketLoc.getRawEncoding();
      Unnamed_field1.ArrayOrRange.EllipsisLoc = EllipsisLoc.getRawEncoding();
      Unnamed_field1.ArrayOrRange.RBracketLoc = RBracketLoc.getRawEncoding();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator::isFieldDesignator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4076,
     FQN="clang::DesignatedInitExpr::Designator::isFieldDesignator", NM="_ZNK5clang18DesignatedInitExpr10Designator17isFieldDesignatorEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZNK5clang18DesignatedInitExpr10Designator17isFieldDesignatorEv")
    //</editor-fold>
    public boolean isFieldDesignator() /*const*/ {
      return Kind == Unnamed_enum.FieldDesignator;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator::isArrayDesignator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4077,
     FQN="clang::DesignatedInitExpr::Designator::isArrayDesignator", NM="_ZNK5clang18DesignatedInitExpr10Designator17isArrayDesignatorEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZNK5clang18DesignatedInitExpr10Designator17isArrayDesignatorEv")
    //</editor-fold>
    public boolean isArrayDesignator() /*const*/ {
      return Kind == Unnamed_enum.ArrayDesignator;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator::isArrayRangeDesignator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4078,
     FQN="clang::DesignatedInitExpr::Designator::isArrayRangeDesignator", NM="_ZNK5clang18DesignatedInitExpr10Designator22isArrayRangeDesignatorEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZNK5clang18DesignatedInitExpr10Designator22isArrayRangeDesignatorEv")
    //</editor-fold>
    public boolean isArrayRangeDesignator() /*const*/ {
      return Kind == Unnamed_enum.ArrayRangeDesignator;
    }

    
    //===----------------------------------------------------------------------===//
    //  DesignatedInitExpr
    //===----------------------------------------------------------------------===//
    //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator::getFieldName">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3512,
     FQN="clang::DesignatedInitExpr::Designator::getFieldName", NM="_ZNK5clang18DesignatedInitExpr10Designator12getFieldNameEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang18DesignatedInitExpr10Designator12getFieldNameEv")
    //</editor-fold>
    public IdentifierInfo /*P*/ getFieldName() /*const*/ {
      assert (Kind == Unnamed_enum.FieldDesignator) : "Only valid on a field designator";
      if (/*((*/Unnamed_field1.Field.NameOrField.getBool()/* & 0x01) != 0)*/) {
        return (IdentifierInfo)Unnamed_field1.Field.NameOrField.getPointer(); //reinterpret_cast(IdentifierInfo /*P*/ .class, Unnamed_field1.Field.NameOrField & ~0x01);
      } else {
        return getField().getIdentifier();
      }
    }


    
    //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator::getField">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4082,
     FQN="clang::DesignatedInitExpr::Designator::getField", NM="_ZNK5clang18DesignatedInitExpr10Designator8getFieldEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZNK5clang18DesignatedInitExpr10Designator8getFieldEv")
    //</editor-fold>
    public FieldDecl /*P*/ getField() /*const*/ {
      assert (Kind == Unnamed_enum.FieldDesignator) : "Only valid on a field designator";
       if (/*((*/Unnamed_field1.Field.NameOrField.getBool()/* & 0x01) != 0)*/) {
        return null;
      } else {
        return reinterpret_cast(FieldDecl /*P*/ .class, Unnamed_field1.Field.NameOrField.getPointer());
      }
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator::setField">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4090,
     FQN="clang::DesignatedInitExpr::Designator::setField", NM="_ZN5clang18DesignatedInitExpr10Designator8setFieldEPNS_9FieldDeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang18DesignatedInitExpr10Designator8setFieldEPNS_9FieldDeclE")
    //</editor-fold>
    public void setField(FieldDecl /*P*/ FD) {
      assert (Kind == Unnamed_enum.FieldDesignator) : "Only valid on a field designator";
      Unnamed_field1.Field.NameOrField.$assignMove(new PointerBoolPair<>(FD, false));//reinterpret_cast_Object/*uintptr_t*/(FD);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator::getDotLoc">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4095,
     FQN="clang::DesignatedInitExpr::Designator::getDotLoc", NM="_ZNK5clang18DesignatedInitExpr10Designator9getDotLocEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZNK5clang18DesignatedInitExpr10Designator9getDotLocEv")
    //</editor-fold>
    public SourceLocation getDotLoc() /*const*/ {
      assert (Kind == Unnamed_enum.FieldDesignator) : "Only valid on a field designator";
      return SourceLocation.getFromRawEncoding(Unnamed_field1.Field.DotLoc);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator::getFieldLoc">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4100,
     FQN="clang::DesignatedInitExpr::Designator::getFieldLoc", NM="_ZNK5clang18DesignatedInitExpr10Designator11getFieldLocEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZNK5clang18DesignatedInitExpr10Designator11getFieldLocEv")
    //</editor-fold>
    public SourceLocation getFieldLoc() /*const*/ {
      assert (Kind == Unnamed_enum.FieldDesignator) : "Only valid on a field designator";
      return SourceLocation.getFromRawEncoding(Unnamed_field1.Field.FieldLoc);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator::getLBracketLoc">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4105,
     FQN="clang::DesignatedInitExpr::Designator::getLBracketLoc", NM="_ZNK5clang18DesignatedInitExpr10Designator14getLBracketLocEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZNK5clang18DesignatedInitExpr10Designator14getLBracketLocEv")
    //</editor-fold>
    public SourceLocation getLBracketLoc() /*const*/ {
      assert ((Kind == Unnamed_enum.ArrayDesignator || Kind == Unnamed_enum.ArrayRangeDesignator)) : "Only valid on an array or array-range designator";
      return SourceLocation.getFromRawEncoding(Unnamed_field1.ArrayOrRange.LBracketLoc);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator::getRBracketLoc">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4111,
     FQN="clang::DesignatedInitExpr::Designator::getRBracketLoc", NM="_ZNK5clang18DesignatedInitExpr10Designator14getRBracketLocEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZNK5clang18DesignatedInitExpr10Designator14getRBracketLocEv")
    //</editor-fold>
    public SourceLocation getRBracketLoc() /*const*/ {
      assert ((Kind == Unnamed_enum.ArrayDesignator || Kind == Unnamed_enum.ArrayRangeDesignator)) : "Only valid on an array or array-range designator";
      return SourceLocation.getFromRawEncoding(Unnamed_field1.ArrayOrRange.RBracketLoc);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator::getEllipsisLoc">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4117,
     FQN="clang::DesignatedInitExpr::Designator::getEllipsisLoc", NM="_ZNK5clang18DesignatedInitExpr10Designator14getEllipsisLocEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZNK5clang18DesignatedInitExpr10Designator14getEllipsisLocEv")
    //</editor-fold>
    public SourceLocation getEllipsisLoc() /*const*/ {
      assert (Kind == Unnamed_enum.ArrayRangeDesignator) : "Only valid on an array-range designator";
      return SourceLocation.getFromRawEncoding(Unnamed_field1.ArrayOrRange.EllipsisLoc);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator::getFirstExprIndex">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4123,
     FQN="clang::DesignatedInitExpr::Designator::getFirstExprIndex", NM="_ZNK5clang18DesignatedInitExpr10Designator17getFirstExprIndexEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZNK5clang18DesignatedInitExpr10Designator17getFirstExprIndexEv")
    //</editor-fold>
    public /*uint*/int getFirstExprIndex() /*const*/ {
      assert ((Kind == Unnamed_enum.ArrayDesignator || Kind == Unnamed_enum.ArrayRangeDesignator)) : "Only valid on an array or array-range designator";
      return Unnamed_field1.ArrayOrRange.Index;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator::getLocStart">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4129,
     FQN="clang::DesignatedInitExpr::Designator::getLocStart", NM="_ZNK5clang18DesignatedInitExpr10Designator11getLocStartEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZNK5clang18DesignatedInitExpr10Designator11getLocStartEv")
    //</editor-fold>
    public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
      if (Kind == Unnamed_enum.FieldDesignator) {
        return getDotLoc().isInvalid() ? getFieldLoc() : getDotLoc();
      } else {
        return getLBracketLoc();
      }
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator::getLocEnd">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4135,
     FQN="clang::DesignatedInitExpr::Designator::getLocEnd", NM="_ZNK5clang18DesignatedInitExpr10Designator9getLocEndEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZNK5clang18DesignatedInitExpr10Designator9getLocEndEv")
    //</editor-fold>
    public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
      return Kind == Unnamed_enum.FieldDesignator ? getFieldLoc() : getRBracketLoc();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator::getSourceRange">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4138,
     FQN="clang::DesignatedInitExpr::Designator::getSourceRange", NM="_ZNK5clang18DesignatedInitExpr10Designator14getSourceRangeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZNK5clang18DesignatedInitExpr10Designator14getSourceRangeEv")
    //</editor-fold>
    public SourceRange getSourceRange() /*const*//* __attribute__((pure))*/ {
      return new SourceRange(getLocStart(), getLocEnd());
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator::Designator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4028,
     FQN="clang::DesignatedInitExpr::Designator::Designator", NM="_ZN5clang18DesignatedInitExpr10DesignatorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang18DesignatedInitExpr10DesignatorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ Designator(final /*const*/ Designator /*&*/ $Prm0) {
      // : Kind(.Kind), Unnamed_field1(.) 
      //START JInit
      this.Kind = $Prm0.Kind;
      this.Unnamed_field1 = new Unnamed_union1($Prm0.Unnamed_field1);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator::Designator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4028,
     FQN="clang::DesignatedInitExpr::Designator::Designator", NM="_ZN5clang18DesignatedInitExpr10DesignatorC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang18DesignatedInitExpr10DesignatorC1EOS1_")
    //</editor-fold>
    public /*inline*/ Designator(JD$Move _dparam, final Designator /*&&*/$Prm0) {
      // : Kind(static_cast<Designator &&>().Kind), Unnamed_field1(static_cast<Designator &&>().) 
      //START JInit
      this.Kind = $Prm0.Kind;
      this.Unnamed_field1 = new Unnamed_union1(JD$Move.INSTANCE, $Prm0.Unnamed_field1);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4028,
     FQN="clang::DesignatedInitExpr::Designator::operator=", NM="_ZN5clang18DesignatedInitExpr10DesignatoraSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang18DesignatedInitExpr10DesignatoraSEOS1_")
    //</editor-fold>
    public /*inline*/ Designator /*&*/ $assignMove(final Designator /*&&*/$Prm0) {
      this.Kind = $Prm0.Kind;
      this.Unnamed_field1.$assignMove($Prm0.Unnamed_field1);
      return /*Deref*/this;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Designator::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4028,
     FQN="clang::DesignatedInitExpr::Designator::operator=", NM="_ZN5clang18DesignatedInitExpr10DesignatoraSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang18DesignatedInitExpr10DesignatoraSERKS1_")
    //</editor-fold>
    public /*inline*/ Designator /*&*/ $assign(final /*const*/ Designator /*&*/ $Prm0) {
      this.Kind = $Prm0.Kind;
      this.Unnamed_field1.$assign($Prm0.Unnamed_field1);
      return /*Deref*/this;
    }

    @Override
    public Designator clone() {
      return new Designator(this);
    }

    @Override
    public Designator move() {
      return new Designator(JD$Move.INSTANCE, this);
    }
    
    @Override public String toString() {
      return "" + "Kind=" + Kind // NOI18N
                + ", Unnamed_field1=" + Unnamed_field1; // NOI18N
    }
  };
/*private:*/
  /// The location of the '=' or ':' prior to the actual initializer
  /// expression.
  private SourceLocation EqualOrColonLoc;
  
  /// Whether this designated initializer used the GNU deprecated
  /// syntax rather than the C99 '=' syntax.
  private /*JBIT unsigned int*/ boolean GNUSyntax /*: 1*/;
  
  /// The number of designators in this initializer expression.
  private /*JCHAR unsigned int*/ char NumDesignators /*: 15*/;
  
  /// The number of subexpressions of this initializer expression,
  /// which contains both the initializer and any additional
  /// expressions used by array and array-range designators.
  private /*JCHAR unsigned int*/ char NumSubExprs /*: 16*/;
  
  /// \brief The designators in this designated initialization
  /// expression.
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private type$ptr<Designator /*P*/> Designators;
  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::DesignatedInitExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3520,
   FQN="clang::DesignatedInitExpr::DesignatedInitExpr", NM="_ZN5clang18DesignatedInitExprC1ERKNS_10ASTContextENS_8QualTypeEN4llvm8ArrayRefINS0_10DesignatorEEENS_14SourceLocationEbNS6_IPNS_4ExprEEESB_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang18DesignatedInitExprC1ERKNS_10ASTContextENS_8QualTypeEN4llvm8ArrayRefINS0_10DesignatorEEENS_14SourceLocationEbNS6_IPNS_4ExprEEESB_")
  //</editor-fold>
  private DesignatedInitExpr(final /*const*/ ASTContext /*&*/ C, QualType Ty, 
      ArrayRef<Designator> Designators, 
      SourceLocation EqualOrColonLoc, 
      boolean GNUSyntax, 
      ArrayRef<Expr /*P*/ > IndexExprs, 
      Expr /*P*/ Init) {
    // : Expr(DesignatedInitExprClass, Ty, Init->getValueKind(), Init->getObjectKind(), Init->isTypeDependent(), Init->isValueDependent(), Init->isInstantiationDependent(), Init->containsUnexpandedParameterPack()), TrailingObjects<DesignatedInitExpr, Stmt * >(), EqualOrColonLoc(EqualOrColonLoc), GNUSyntax(GNUSyntax), NumDesignators(Designators.size()), NumSubExprs(IndexExprs.size() + 1) 
    //START JInit
    super(StmtClass.DesignatedInitExprClass, new QualType(Ty), 
        Init.getValueKind(), Init.getObjectKind(), 
        Init.isTypeDependent(), Init.isValueDependent(), 
        Init.isInstantiationDependent(), 
        Init.containsUnexpandedParameterPack());
    $TrailingObjects();
    this.EqualOrColonLoc = new SourceLocation(EqualOrColonLoc);
    this.GNUSyntax = GNUSyntax;
    this.NumDesignators = $uint2uint_15bits(Designators.size());
    this.NumSubExprs = $uint2uint_16bits(IndexExprs.size() + 1);
    //END JInit
    if (false) {
      this.Designators = (type$ptr<Designator>) ASTContextGlobals.$array_new_uint_ASTContext$C_uint($15bits_uint2uint(NumDesignators), C);
//      /*NEW_EXPR [operator new[]] NM=_ZnajRKN5clang10ASTContextEj*/
//      /*new (C)*/ /*FIXME 2: $array_new_uint_ASTContext$C_uint*/new Designator [$15bits_uint2uint(NumDesignators)];    
    } else {
      int $Num = $15bits_uint2uint(NumDesignators);
      this.Designators = (type$ptr<Designator>) C.Allocate$JavaRef($Num);
      for (int i = 0; i < $Num; i++) {
        this.Designators.$set(i, new Designator());
      }
    }
    
    // Record the initializer itself.
    StmtIterator Child = child_begin();
    Child.star$ref().$set(Init); Child.$postInc(); 
    
    // Copy the designators and their subexpressions, computing
    // value-dependence along the way.
    /*uint*/int IndexIdx = 0;
    for (/*uint*/int I = 0; I != NumDesignators; ++I) {
      this.Designators.$at(I).$assign(Designators.$at(I));
      if (this.Designators.$at(I).isArrayDesignator()) {
        // Compute type- and value-dependence.
        Expr /*P*/ Index = IndexExprs.$at(IndexIdx);
        if (Index.isTypeDependent() || Index.isValueDependent()) {
          Unnamed_field.ExprBits.TypeDependent = Unnamed_field.ExprBits.ValueDependent = true;
        }
        if (Index.isInstantiationDependent()) {
          Unnamed_field.ExprBits.InstantiationDependent = true;
        }
        // Propagate unexpanded parameter packs.
        if (Index.containsUnexpandedParameterPack()) {
          Unnamed_field.ExprBits.ContainsUnexpandedParameterPack = true;
        }
        
        // Copy the index expressions into permanent storage.
        Child.star$ref().$set(IndexExprs.$at(IndexIdx++)); Child.$postInc(); 
      } else if (this.Designators.$at(I).isArrayRangeDesignator()) {
        // Compute type- and value-dependence.
        Expr /*P*/ Start = IndexExprs.$at(IndexIdx);
        Expr /*P*/ End = IndexExprs.$at(IndexIdx + 1);
        if (Start.isTypeDependent() || Start.isValueDependent()
           || End.isTypeDependent() || End.isValueDependent()) {
          Unnamed_field.ExprBits.TypeDependent = Unnamed_field.ExprBits.ValueDependent = true;
          Unnamed_field.ExprBits.InstantiationDependent = true;
        } else if (Start.isInstantiationDependent()
           || End.isInstantiationDependent()) {
          Unnamed_field.ExprBits.InstantiationDependent = true;
        }
        
        // Propagate unexpanded parameter packs.
        if (Start.containsUnexpandedParameterPack()
           || End.containsUnexpandedParameterPack()) {
          Unnamed_field.ExprBits.ContainsUnexpandedParameterPack = true;
        }
        
        // Copy the start/end expressions into permanent storage.
        Child.star$ref().$set(IndexExprs.$at(IndexIdx++)); Child.$postInc(); 
        Child.star$ref().$set(IndexExprs.$at(IndexIdx++)); Child.$postInc(); 
      }
    }
    assert (IndexIdx == IndexExprs.size()) : "Wrong number of index expressions";
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::DesignatedInitExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3986,
   FQN="clang::DesignatedInitExpr::DesignatedInitExpr", NM="_ZN5clang18DesignatedInitExprC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang18DesignatedInitExprC1Ej")
  //</editor-fold>
  private /*explicit*/ DesignatedInitExpr(/*uint*/int NumSubExprs) {
    // : Expr(DesignatedInitExprClass, EmptyShell()), TrailingObjects<DesignatedInitExpr, Stmt * >(), EqualOrColonLoc(), NumDesignators(0), NumSubExprs(NumSubExprs), Designators(null) 
    //START JInit
    super(StmtClass.DesignatedInitExprClass, new EmptyShell());
    $TrailingObjects();
    this.EqualOrColonLoc = new SourceLocation();
    this.NumDesignators = $uint2uint_15bits(0);
    this.NumSubExprs = $uint2uint_16bits(NumSubExprs);
    this.Designators = null;
    //END JInit
  }

/*public:*/
  /// A field designator, e.g., ".x".
  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::FieldDesignator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3992,
   FQN="clang::DesignatedInitExpr::FieldDesignator", NM="_ZN5clang18DesignatedInitExpr15FieldDesignatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang18DesignatedInitExpr15FieldDesignatorE")
  //</editor-fold>
  public static class/*struct*/ FieldDesignator {
    /// Refers to the field that is being initialized. The low bit
    /// of this field determines whether this is actually a pointer
    /// to an IdentifierInfo (if 1) or a FieldDecl (if 0). When
    /// initially constructed, a field designator will store an
    /// IdentifierInfo*. After semantic analysis has resolved that
    /// name, the field designator will instead store a FieldDecl*.
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
    public final PointerBoolPair<Object>/*uintptr_t*/ NameOrField = new PointerBoolPair<>(); 
    
    /// The location of the '.' in the designated initializer.
    public /*uint*/int DotLoc;
    
    /// The location of the field name in the designated initializer.
    public /*uint*/int FieldLoc;
    //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::FieldDesignator::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3992,
     FQN="clang::DesignatedInitExpr::FieldDesignator::operator=", NM="_ZN5clang18DesignatedInitExpr15FieldDesignatoraSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang18DesignatedInitExpr15FieldDesignatoraSEOS1_")
    //</editor-fold>
    public /*inline*/ FieldDesignator /*&*/ $assignMove(final FieldDesignator /*&&*/$Prm0) {
      this.NameOrField.$assignMove($Prm0.NameOrField);
      this.DotLoc = $Prm0.DotLoc;
      this.FieldLoc = $Prm0.FieldLoc;
      return /*Deref*/this;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::FieldDesignator::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 3992,
     FQN="clang::DesignatedInitExpr::FieldDesignator::operator=", NM="_ZN5clang18DesignatedInitExpr15FieldDesignatoraSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang18DesignatedInitExpr15FieldDesignatoraSERKS1_")
    //</editor-fold>
    public /*inline*/ FieldDesignator /*&*/ $assign(final /*const*/ FieldDesignator /*&*/ $Prm0) {
      this.NameOrField.$assign($Prm0.NameOrField);
      this.DotLoc = $Prm0.DotLoc;
      this.FieldLoc = $Prm0.FieldLoc;
      return /*Deref*/this;
    }

    
    @Override public String toString() {
      return "" + "NameOrField=" + NameOrField // NOI18N
                + ", DotLoc=" + DotLoc // NOI18N
                + ", FieldLoc=" + FieldLoc; // NOI18N
    }
  };
  
  /// An array or GNU array-range designator, e.g., "[9]" or "[10..15]".
  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::ArrayOrRangeDesignator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4009,
   FQN="clang::DesignatedInitExpr::ArrayOrRangeDesignator", NM="_ZN5clang18DesignatedInitExpr22ArrayOrRangeDesignatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang18DesignatedInitExpr22ArrayOrRangeDesignatorE")
  //</editor-fold>
  public static class/*struct*/ ArrayOrRangeDesignator {
    /// Location of the first index expression within the designated
    /// initializer expression's list of subexpressions.
    public /*uint*/int Index;
    /// The location of the '[' starting the array range designator.
    public /*uint*/int LBracketLoc;
    /// The location of the ellipsis separating the start and end
    /// indices. Only valid for GNU array-range designators.
    public /*uint*/int EllipsisLoc;
    /// The location of the ']' terminating the array range designator.
    public /*uint*/int RBracketLoc;
    //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::ArrayOrRangeDesignator::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4009,
     FQN="clang::DesignatedInitExpr::ArrayOrRangeDesignator::operator=", NM="_ZN5clang18DesignatedInitExpr22ArrayOrRangeDesignatoraSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang18DesignatedInitExpr22ArrayOrRangeDesignatoraSEOS1_")
    //</editor-fold>
    public /*inline*/ ArrayOrRangeDesignator /*&*/ $assignMove(final ArrayOrRangeDesignator /*&&*/$Prm0) {
      this.Index = $Prm0.Index;
      this.LBracketLoc = $Prm0.LBracketLoc;
      this.EllipsisLoc = $Prm0.EllipsisLoc;
      this.RBracketLoc = $Prm0.RBracketLoc;
      return /*Deref*/this;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::ArrayOrRangeDesignator::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4009,
     FQN="clang::DesignatedInitExpr::ArrayOrRangeDesignator::operator=", NM="_ZN5clang18DesignatedInitExpr22ArrayOrRangeDesignatoraSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang18DesignatedInitExpr22ArrayOrRangeDesignatoraSERKS1_")
    //</editor-fold>
    public /*inline*/ ArrayOrRangeDesignator /*&*/ $assign(final /*const*/ ArrayOrRangeDesignator /*&*/ $Prm0) {
      this.Index = $Prm0.Index;
      this.LBracketLoc = $Prm0.LBracketLoc;
      this.EllipsisLoc = $Prm0.EllipsisLoc;
      this.RBracketLoc = $Prm0.RBracketLoc;
      return /*Deref*/this;
    }

    
    @Override public String toString() {
      return "" + "Index=" + Index // NOI18N
                + ", LBracketLoc=" + LBracketLoc // NOI18N
                + ", EllipsisLoc=" + EllipsisLoc // NOI18N
                + ", RBracketLoc=" + RBracketLoc; // NOI18N
    }
  };
  ;
  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3585,
   FQN="clang::DesignatedInitExpr::Create", NM="_ZN5clang18DesignatedInitExpr6CreateERKNS_10ASTContextEN4llvm8ArrayRefINS0_10DesignatorEEENS5_IPNS_4ExprEEENS_14SourceLocationEbS9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang18DesignatedInitExpr6CreateERKNS_10ASTContextEN4llvm8ArrayRefINS0_10DesignatorEEENS5_IPNS_4ExprEEENS_14SourceLocationEbS9_")
  //</editor-fold>
  public static DesignatedInitExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ C, 
        ArrayRef<Designator> Designators, 
        ArrayRef<Expr /*P*/ > IndexExprs, 
        SourceLocation ColonOrEqualLoc, 
        boolean UsesColonSyntax, Expr /*P*/ Init) {
    Object/*void P*/ _Mem = C.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(Stmt.class, IndexExprs.size() + 1), 
        alignOf(DesignatedInitExpr.class));
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(_Mem, (type$ptr<?> Mem)->{
        return new DesignatedInitExpr(C, C.VoidTy.$QualType(), new ArrayRef<Designator>(Designators), 
                new SourceLocation(ColonOrEqualLoc), UsesColonSyntax, 
                new ArrayRef<Expr /*P*/ >(IndexExprs), Init);
     });
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::CreateEmpty">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3598,
   FQN="clang::DesignatedInitExpr::CreateEmpty", NM="_ZN5clang18DesignatedInitExpr11CreateEmptyERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang18DesignatedInitExpr11CreateEmptyERKNS_10ASTContextEj")
  //</editor-fold>
  public static DesignatedInitExpr /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, 
             /*uint*/int NumIndexExprs) {
    Object/*void P*/ _Mem = C.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(Stmt.class, NumIndexExprs + 1), 
        alignOf(DesignatedInitExpr.class));
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(_Mem, (type$ptr<?> Mem)->{
        return new DesignatedInitExpr(NumIndexExprs + 1);
     });
  }


  
  /// @brief Returns the number of designators in this initializer.
  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4153,
   FQN="clang::DesignatedInitExpr::size", NM="_ZNK5clang18DesignatedInitExpr4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZNK5clang18DesignatedInitExpr4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return NumDesignators;
  }

  
  // Iterator access to the designators.
  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::designators">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4156,
   FQN="clang::DesignatedInitExpr::designators", NM="_ZN5clang18DesignatedInitExpr11designatorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang18DesignatedInitExpr11designatorsEv")
  //</editor-fold>
  public MutableArrayRef<Designator> designators() {
    return /*{ */new MutableArrayRef<Designator>(Designators, NumDesignators, false)/* }*/;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::designators">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4160,
   FQN="clang::DesignatedInitExpr::designators", NM="_ZNK5clang18DesignatedInitExpr11designatorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZNK5clang18DesignatedInitExpr11designatorsEv")
  //</editor-fold>
  public ArrayRef<Designator> designators$Const() /*const*/ {
    return /*{ */new ArrayRef<Designator>(Designators, NumDesignators, false)/* }*/;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::getDesignator">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4164,
   FQN="clang::DesignatedInitExpr::getDesignator", NM="_ZN5clang18DesignatedInitExpr13getDesignatorEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang18DesignatedInitExpr13getDesignatorEj")
  //</editor-fold>
  public Designator /*P*/ getDesignator(/*uint*/int Idx) {
    return $AddrOf(designators().$at(Idx));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::setDesignators">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3605,
   FQN="clang::DesignatedInitExpr::setDesignators", NM="_ZN5clang18DesignatedInitExpr14setDesignatorsERKNS_10ASTContextEPKNS0_10DesignatorEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang18DesignatedInitExpr14setDesignatorsERKNS_10ASTContextEPKNS0_10DesignatorEj")
  //</editor-fold>
  public void setDesignators(final /*const*/ ASTContext /*&*/ C, 
                /*const*/ type$ptr<Designator /*P*/> Desigs, 
                /*uint*/int NumDesigs) {
    if (false) {
      Designators = create_type$ptr(/*FIXME:NEW_EXPR*//*new (C)*/ new Designator [NumDesigs]);
    } else {
      int $Num = $15bits_uint2uint(NumDesignators);
      this.Designators = (type$ptr<Designator>) C.Allocate$JavaRef($Num);
      for (int i = 0; i < $Num; i++) {
        this.Designators.$set(i, new Designator());
      }    
    }
    NumDesignators = $uint2uint_15bits(NumDesigs);
    for (/*uint*/int I = 0; I != NumDesigs; ++I)  {
      Designators.$at(I).$assign(Desigs.$at(I));
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::getArrayIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3641,
   FQN="clang::DesignatedInitExpr::getArrayIndex", NM="_ZNK5clang18DesignatedInitExpr13getArrayIndexERKNS0_10DesignatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang18DesignatedInitExpr13getArrayIndexERKNS0_10DesignatorE")
  //</editor-fold>
  public Expr /*P*/ getArrayIndex(final /*const*/ Designator /*&*/ D) /*const*/ {
    assert (D.Kind == Designator.Unnamed_enum.ArrayDesignator) : "Requires array designator";
    return getSubExpr(D.Unnamed_field1.ArrayOrRange.Index + 1);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::getArrayRangeStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3646,
   FQN="clang::DesignatedInitExpr::getArrayRangeStart", NM="_ZNK5clang18DesignatedInitExpr18getArrayRangeStartERKNS0_10DesignatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang18DesignatedInitExpr18getArrayRangeStartERKNS0_10DesignatorE")
  //</editor-fold>
  public Expr /*P*/ getArrayRangeStart(final /*const*/ Designator /*&*/ D) /*const*/ {
    assert (D.Kind == Designator.Unnamed_enum.ArrayRangeDesignator) : "Requires array range designator";
    return getSubExpr(D.Unnamed_field1.ArrayOrRange.Index + 1);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::getArrayRangeEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3652,
   FQN="clang::DesignatedInitExpr::getArrayRangeEnd", NM="_ZNK5clang18DesignatedInitExpr16getArrayRangeEndERKNS0_10DesignatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang18DesignatedInitExpr16getArrayRangeEndERKNS0_10DesignatorE")
  //</editor-fold>
  public Expr /*P*/ getArrayRangeEnd(final /*const*/ Designator /*&*/ D) /*const*/ {
    assert (D.Kind == Designator.Unnamed_enum.ArrayRangeDesignator) : "Requires array range designator";
    return getSubExpr(D.Unnamed_field1.ArrayOrRange.Index + 2);
  }


  
  /// @brief Retrieve the location of the '=' that precedes the
  /// initializer value itself, if present.
  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::getEqualOrColonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4175,
   FQN="clang::DesignatedInitExpr::getEqualOrColonLoc", NM="_ZNK5clang18DesignatedInitExpr18getEqualOrColonLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZNK5clang18DesignatedInitExpr18getEqualOrColonLocEv")
  //</editor-fold>
  public SourceLocation getEqualOrColonLoc() /*const*/ {
    return new SourceLocation(EqualOrColonLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::setEqualOrColonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4176,
   FQN="clang::DesignatedInitExpr::setEqualOrColonLoc", NM="_ZN5clang18DesignatedInitExpr18setEqualOrColonLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang18DesignatedInitExpr18setEqualOrColonLocENS_14SourceLocationE")
  //</editor-fold>
  public void setEqualOrColonLoc(SourceLocation L) {
    EqualOrColonLoc.$assign(L);
  }

  
  /// @brief Determines whether this designated initializer used the
  /// deprecated GNU syntax for designated initializers.
  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::usesGNUSyntax">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4180,
   FQN="clang::DesignatedInitExpr::usesGNUSyntax", NM="_ZNK5clang18DesignatedInitExpr13usesGNUSyntaxEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZNK5clang18DesignatedInitExpr13usesGNUSyntaxEv")
  //</editor-fold>
  public boolean usesGNUSyntax() /*const*/ {
    return GNUSyntax;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::setGNUSyntax">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4181,
   FQN="clang::DesignatedInitExpr::setGNUSyntax", NM="_ZN5clang18DesignatedInitExpr12setGNUSyntaxEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang18DesignatedInitExpr12setGNUSyntaxEb")
  //</editor-fold>
  public void setGNUSyntax(boolean GNU) {
    GNUSyntax = GNU;
  }

  
  /// @brief Retrieve the initializer value.
  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::getInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4184,
   FQN="clang::DesignatedInitExpr::getInit", NM="_ZNK5clang18DesignatedInitExpr7getInitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZNK5clang18DesignatedInitExpr7getInitEv")
  //</editor-fold>
  public Expr /*P*/ getInit() /*const*/ {
    return cast_Expr(((/*const_cast*/DesignatedInitExpr /*P*/ )(this)).child_begin().$star());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::setInit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4188,
   FQN="clang::DesignatedInitExpr::setInit", NM="_ZN5clang18DesignatedInitExpr7setInitEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang18DesignatedInitExpr7setInitEPNS_4ExprE")
  //</editor-fold>
  public void setInit(Expr /*P*/ init) {
    child_begin().star$ref().$set(init);
  }

  
  /// \brief Retrieve the total number of subexpressions in this
  /// designated initializer expression, including the actual
  /// initialized value and any expressions that occur within array
  /// and array-range designators.
  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::getNumSubExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4196,
   FQN="clang::DesignatedInitExpr::getNumSubExprs", NM="_ZNK5clang18DesignatedInitExpr14getNumSubExprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZNK5clang18DesignatedInitExpr14getNumSubExprsEv")
  //</editor-fold>
  public /*uint*/int getNumSubExprs() /*const*/ {
    return NumSubExprs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::getSubExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4198,
   FQN="clang::DesignatedInitExpr::getSubExpr", NM="_ZNK5clang18DesignatedInitExpr10getSubExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZNK5clang18DesignatedInitExpr10getSubExprEj")
  //</editor-fold>
  public Expr /*P*/ getSubExpr(/*uint*/int Idx) /*const*/ {
    assert ($less_uint(Idx, NumSubExprs)) : "Subscript out of range";
    return cast_Expr(this.<Stmt /*P*/ >getTrailingObjects$Const(Stmt.class).$at(Idx));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::setSubExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4203,
   FQN="clang::DesignatedInitExpr::setSubExpr", NM="_ZN5clang18DesignatedInitExpr10setSubExprEjPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang18DesignatedInitExpr10setSubExprEjPNS_4ExprE")
  //</editor-fold>
  public void setSubExpr(/*uint*/int Idx, Expr /*P*/ E) {
    assert ($less_uint(Idx, NumSubExprs)) : "Subscript out of range";
    this.<Stmt /*P*/ >getTrailingObjects(Stmt.class).$set(Idx, E);
  }

  
  /// \brief Replaces the designator at index @p Idx with the series
  /// of designators in [First, Last).
  
  /// \brief Replaces the designator at index @p Idx with the series
  /// of designators in [First, Last).
  
  /// \brief Replaces the designator at index @p Idx with the series
  /// of designators in [First, Last).
  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::ExpandDesignator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3660,
   FQN="clang::DesignatedInitExpr::ExpandDesignator", NM="_ZN5clang18DesignatedInitExpr16ExpandDesignatorERKNS_10ASTContextEjPKNS0_10DesignatorES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang18DesignatedInitExpr16ExpandDesignatorERKNS_10ASTContextEjPKNS0_10DesignatorES6_")
  //</editor-fold>
  public void ExpandDesignator(final /*const*/ ASTContext /*&*/ C, /*uint*/int Idx, 
                  /*const*/ type$ptr<Designator /*P*/> First, 
                  /*const*/ type$ptr<Designator /*P*/> Last) {
    /*uint*/int NumNewDesignators = Last.$sub(First);
    if (NumNewDesignators == 0) {
      std.copy_backward(Designators.$add(Idx + 1), 
          Designators.$add(NumDesignators), 
          Designators.$add(Idx));
      --NumNewDesignators;
      return;
    } else if (NumNewDesignators == 1) {
      Designators.$set(Idx, $Deref(First.$star()));
      return;
    }
    
    type$ptr<Designator /*P*/> NewDesignators;
    if (false) {
      NewDesignators = create_type$ptr(/*FIXME:NEW_EXPR*//*new (C)*/ new Designator [NumDesignators - $int2uint_15bits(1) + NumNewDesignators]);
    } else {
      /*uint*/int $Num = NumDesignators - 1 + NumNewDesignators;
      NewDesignators = (type$ptr<Designator>) C.Allocate$JavaRef($Num);
      for (int i = 0; i < $Num; i++) {
        NewDesignators.$set(i, new Designator());
      }      
    }
    std.copy(Designators, Designators.$add(Idx), NewDesignators, false);
    std.copy(First, Last, NewDesignators.$add(Idx), false);
    std.copy(Designators.$add(Idx + 1), Designators.$add(NumDesignators), 
        NewDesignators.$add(Idx + NumNewDesignators), false);
    Designators = NewDesignators;
    NumDesignators = $uint2uint_15bits(NumDesignators - $int2uint_15bits(1) + NumNewDesignators);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::getDesignatorsSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3614,
   FQN="clang::DesignatedInitExpr::getDesignatorsSourceRange", NM="_ZNK5clang18DesignatedInitExpr25getDesignatorsSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang18DesignatedInitExpr25getDesignatorsSourceRangeEv")
  //</editor-fold>
  public SourceRange getDesignatorsSourceRange() /*const*/ {
    DesignatedInitExpr /*P*/ DIE = ((/*const_cast*/DesignatedInitExpr /*P*/ )(this));
    if (size() == 1) {
      return DIE.getDesignator(0).getSourceRange();
    }
    return new SourceRange(DIE.getDesignator(0).getLocStart(), 
        DIE.getDesignator(size() - 1).getLocEnd());
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3622,
   FQN="clang::DesignatedInitExpr::getLocStart", NM="_ZNK5clang18DesignatedInitExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang18DesignatedInitExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    SourceLocation StartLoc/*J*/= new SourceLocation();
    DesignatedInitExpr /*P*/ DIE = ((/*const_cast*/DesignatedInitExpr /*P*/ )(this));
    final Designator /*&*/ First = $Deref(DIE.getDesignator(0));
    if (First.isFieldDesignator()) {
      if (GNUSyntax) {
        StartLoc.$assignMove(SourceLocation.getFromRawEncoding(First.Unnamed_field1.Field.FieldLoc));
      } else {
        StartLoc.$assignMove(SourceLocation.getFromRawEncoding(First.Unnamed_field1.Field.DotLoc));
      }
    } else {
      StartLoc.$assignMove(
          SourceLocation.getFromRawEncoding(First.Unnamed_field1.ArrayOrRange.LBracketLoc)
      );
    }
    return StartLoc;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3637,
   FQN="clang::DesignatedInitExpr::getLocEnd", NM="_ZNK5clang18DesignatedInitExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang18DesignatedInitExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return getInit().getLocEnd();
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4218,
   FQN="clang::DesignatedInitExpr::classof", NM="_ZN5clang18DesignatedInitExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang18DesignatedInitExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.DesignatedInitExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::DesignatedInitExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4223,
   FQN="clang::DesignatedInitExpr::children", NM="_ZN5clang18DesignatedInitExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang18DesignatedInitExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    type$ptr<Stmt /*P*/ /*P*/> begin = $tryClone(this.<Stmt /*P*/ >getTrailingObjects(Stmt.class));
    return new iterator_range<Stmt/*P*/>(new StmtIterator(begin), new StmtIterator(begin.$add(NumSubExprs)));
  }

  
  /*friend  TrailingObjects<DesignatedInitExpr, Stmt *>*/
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override
  public final type$ptr<?> $TrailingObjects() {
    return super.$this$plus1();
  }
  
  @Override
  public final int getTrailingObjects$Offset(Class<?> clazz) {
    assert clazz == Stmt.class;
    return 0;
  }
  
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "EqualOrColonLoc=" + EqualOrColonLoc // NOI18N
              + ", GNUSyntax=" + GNUSyntax // NOI18N
              + ", NumDesignators=" + $ushort2uint(NumDesignators) // NOI18N
              + ", NumSubExprs=" + $ushort2uint(NumSubExprs) // NOI18N
              + ", Designators=" + Designators // NOI18N
              + super.toString(); // NOI18N
  }
}
