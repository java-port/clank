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

package org.clang.sema;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.ast.*;
import org.clang.basic.*;


/// Designator - A designator in a C99 designated initializer.
///
/// This class is a discriminated union which holds the various
/// different sorts of designators possible.  A Designation is an array of
/// these.  An example of a designator are things like this:
///     [8] .field [47]        // C99 designation: 3 designators
///     [8 ... 47]  field:     // GNU extensions: 2 designators
/// These occur in initializers, e.g.:
///  int a[10] = {2, 4, [8]=9, 10};
///
//<editor-fold defaultstate="collapsed" desc="clang::Designator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 37,
 FQN="clang::Designator", NM="_ZN5clang10DesignatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZN5clang10DesignatorE")
//</editor-fold>
public class Designator implements NativeCloneable<Designator>, NativeMoveable<Designator> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Designator::DesignatorKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 39,
   FQN="clang::Designator::DesignatorKind", NM="_ZN5clang10Designator14DesignatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZN5clang10Designator14DesignatorKindE")
  //</editor-fold>
  public enum DesignatorKind implements Native.ComparableLower {
    FieldDesignator(0),
    ArrayDesignator(FieldDesignator.getValue() + 1),
    ArrayRangeDesignator(ArrayDesignator.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static DesignatorKind valueOf(int val) {
      DesignatorKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final DesignatorKind[] VALUES;
      private static final DesignatorKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (DesignatorKind kind : DesignatorKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new DesignatorKind[min < 0 ? (1-min) : 0];
        VALUES = new DesignatorKind[max >= 0 ? (1+max) : 0];
        for (DesignatorKind kind : DesignatorKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private DesignatorKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((DesignatorKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((DesignatorKind)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private DesignatorKind Kind;
  
  //<editor-fold defaultstate="collapsed" desc="clang::Designator::FieldDesignatorInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*assign fields*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 45,
   FQN="clang::Designator::FieldDesignatorInfo", NM="_ZN5clang10Designator19FieldDesignatorInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZN5clang10Designator19FieldDesignatorInfoE")
  //</editor-fold>
  private static class/*struct*/ FieldDesignatorInfo {
    public /*const*/ IdentifierInfo /*P*/ II;
    public /*uint*/int DotLoc;
    public /*uint*/int NameLoc;
    
    FieldDesignatorInfo $assignMove(final FieldDesignatorInfo $Prm0) {
      II = $Prm0.II;
      DotLoc = $Prm0.DotLoc;
      NameLoc = $Prm0.NameLoc;
      return this;
    }
    
    FieldDesignatorInfo $assign(final FieldDesignatorInfo $Prm0) {
      II = $Prm0.II;
      DotLoc = $Prm0.DotLoc;
      NameLoc = $Prm0.NameLoc;
      return this;
    }
    
    @Override public String toString() {
      return "" + "II=" + II // NOI18N
                + ", DotLoc=" + DotLoc // NOI18N
                + ", NameLoc=" + NameLoc; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::Designator::ArrayDesignatorInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*assign fields*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 50,
   FQN="clang::Designator::ArrayDesignatorInfo", NM="_ZN5clang10Designator19ArrayDesignatorInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZN5clang10Designator19ArrayDesignatorInfoE")
  //</editor-fold>
  private static class/*struct*/ ArrayDesignatorInfo {
    public Expr /*P*/ Index;
    public /*uint*/int LBracketLoc;
    public /*mutable *//*uint*/int RBracketLoc;
    
    ArrayDesignatorInfo $assignMove(final ArrayDesignatorInfo $Prm0) {
      Index = $Prm0.Index;
      LBracketLoc = $Prm0.LBracketLoc;
      RBracketLoc = $Prm0.RBracketLoc;
      return this;
    }
    
    ArrayDesignatorInfo $assign(final ArrayDesignatorInfo $Prm0) {
      Index = $Prm0.Index;
      LBracketLoc = $Prm0.LBracketLoc;
      RBracketLoc = $Prm0.RBracketLoc;
      return this;
    }
    
    @Override public String toString() {
      return "" + "Index=" + Index // NOI18N
                + ", LBracketLoc=" + LBracketLoc // NOI18N
                + ", RBracketLoc=" + RBracketLoc; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::Designator::ArrayRangeDesignatorInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*assign fields*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 55,
   FQN="clang::Designator::ArrayRangeDesignatorInfo", NM="_ZN5clang10Designator24ArrayRangeDesignatorInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZN5clang10Designator24ArrayRangeDesignatorInfoE")
  //</editor-fold>
  private static class/*struct*/ ArrayRangeDesignatorInfo {
    public Expr /*P*/ Start;
    public Expr /*P*/ End;
    public /*uint*/int LBracketLoc;
    public /*uint*/int EllipsisLoc;
    public /*mutable *//*uint*/int RBracketLoc;
    
    ArrayRangeDesignatorInfo $assignMove(final ArrayRangeDesignatorInfo $Prm0) {
      Start = $Prm0.Start;
      End = $Prm0.End;
      LBracketLoc = $Prm0.LBracketLoc;
      EllipsisLoc = $Prm0.EllipsisLoc;
      RBracketLoc = $Prm0.RBracketLoc;
      return this;
    }
    
    ArrayRangeDesignatorInfo $assign(final ArrayRangeDesignatorInfo $Prm0) {
      Start = $Prm0.Start;
      End = $Prm0.End;
      LBracketLoc = $Prm0.LBracketLoc;
      EllipsisLoc = $Prm0.EllipsisLoc;
      RBracketLoc = $Prm0.RBracketLoc;
      return this;
    }
    
    @Override public String toString() {
      return "" + "Start=" + Start // NOI18N
                + ", End=" + End // NOI18N
                + ", LBracketLoc=" + LBracketLoc // NOI18N
                + ", EllipsisLoc=" + EllipsisLoc // NOI18N
                + ", RBracketLoc=" + RBracketLoc; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::Designator::(anonymous)">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*assign fields*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 61,
   FQN="clang::Designator::(anonymous)", NM="_ZN5clang10DesignatorE_Unnamed_union4",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZN5clang10DesignatorE_Unnamed_union4")
  //</editor-fold>
  private static class/*union*/ Unnamed_union4 {
    public final FieldDesignatorInfo FieldInfo = new FieldDesignatorInfo();
    public final ArrayDesignatorInfo ArrayInfo = new ArrayDesignatorInfo();
    public final ArrayRangeDesignatorInfo ArrayRangeInfo = new ArrayRangeDesignatorInfo();
    
    //<editor-fold defaultstate="collapsed" desc="clang::Designator::(anonymous union)::">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*assign fields*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 61,
     FQN="clang::Designator::(anonymous union)::", NM="_ZN5clang10DesignatorUt_C1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZN5clang10DesignatorUt_C1EOS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union4(JD$Move _dparam, final Unnamed_union4 $Prm0) {
      $assignMove($Prm0);
    }

    public /*inline*/ Unnamed_union4 $assignMove(final Unnamed_union4 $Prm0) {
      FieldInfo.$assignMove($Prm0.FieldInfo);
      ArrayInfo.$assignMove($Prm0.ArrayInfo);
      ArrayRangeInfo.$assignMove($Prm0.ArrayRangeInfo);
      return this;
    }

    public /*inline*/ Unnamed_union4 $assign(final Unnamed_union4 $Prm0) {
      FieldInfo.$assign($Prm0.FieldInfo);
      ArrayInfo.$assign($Prm0.ArrayInfo);
      ArrayRangeInfo.$assign($Prm0.ArrayRangeInfo);
      return this;
    }

    public /*inline*/ Unnamed_union4(final Unnamed_union4 $Prm0) {
      $assign($Prm0);
    }
    
    Unnamed_union4() {
    }
    
    @Override public String toString() {
      return "" + "FieldInfo=" + FieldInfo // NOI18N
                + ", ArrayInfo=" + ArrayInfo // NOI18N
                + ", ArrayRangeInfo=" + ArrayRangeInfo; // NOI18N
    }
  };
  private final Unnamed_union4 Unnamed_field1;
/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::Designator::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 69,
   FQN="clang::Designator::getKind", NM="_ZNK5clang10Designator7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZNK5clang10Designator7getKindEv")
  //</editor-fold>
  public DesignatorKind getKind() /*const*/ {
    return Kind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Designator::isFieldDesignator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 70,
   FQN="clang::Designator::isFieldDesignator", NM="_ZNK5clang10Designator17isFieldDesignatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZNK5clang10Designator17isFieldDesignatorEv")
  //</editor-fold>
  public boolean isFieldDesignator() /*const*/ {
    return Kind == DesignatorKind.FieldDesignator;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Designator::isArrayDesignator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 71,
   FQN="clang::Designator::isArrayDesignator", NM="_ZNK5clang10Designator17isArrayDesignatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZNK5clang10Designator17isArrayDesignatorEv")
  //</editor-fold>
  public boolean isArrayDesignator() /*const*/ {
    return Kind == DesignatorKind.ArrayDesignator;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Designator::isArrayRangeDesignator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 72,
   FQN="clang::Designator::isArrayRangeDesignator", NM="_ZNK5clang10Designator22isArrayRangeDesignatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZNK5clang10Designator22isArrayRangeDesignatorEv")
  //</editor-fold>
  public boolean isArrayRangeDesignator() /*const*/ {
    return Kind == DesignatorKind.ArrayRangeDesignator;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Designator::getField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 74,
   FQN="clang::Designator::getField", NM="_ZNK5clang10Designator8getFieldEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZNK5clang10Designator8getFieldEv")
  //</editor-fold>
  public /*const*/ IdentifierInfo /*P*/ getField() /*const*/ {
    assert (isFieldDesignator()) : "Invalid accessor";
    return Unnamed_field1.FieldInfo.II;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Designator::getDotLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 79,
   FQN="clang::Designator::getDotLoc", NM="_ZNK5clang10Designator9getDotLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZNK5clang10Designator9getDotLocEv")
  //</editor-fold>
  public SourceLocation getDotLoc() /*const*/ {
    assert (isFieldDesignator()) : "Invalid accessor";
    return SourceLocation.getFromRawEncoding(Unnamed_field1.FieldInfo.DotLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Designator::getFieldLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 84,
   FQN="clang::Designator::getFieldLoc", NM="_ZNK5clang10Designator11getFieldLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZNK5clang10Designator11getFieldLocEv")
  //</editor-fold>
  public SourceLocation getFieldLoc() /*const*/ {
    assert (isFieldDesignator()) : "Invalid accessor";
    return SourceLocation.getFromRawEncoding(Unnamed_field1.FieldInfo.NameLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Designator::getArrayIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 89,
   FQN="clang::Designator::getArrayIndex", NM="_ZNK5clang10Designator13getArrayIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZNK5clang10Designator13getArrayIndexEv")
  //</editor-fold>
  public Expr /*P*/ getArrayIndex() /*const*/ {
    assert (isArrayDesignator()) : "Invalid accessor";
    return Unnamed_field1.ArrayInfo.Index;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Designator::getArrayRangeStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 94,
   FQN="clang::Designator::getArrayRangeStart", NM="_ZNK5clang10Designator18getArrayRangeStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZNK5clang10Designator18getArrayRangeStartEv")
  //</editor-fold>
  public Expr /*P*/ getArrayRangeStart() /*const*/ {
    assert (isArrayRangeDesignator()) : "Invalid accessor";
    return Unnamed_field1.ArrayRangeInfo.Start;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Designator::getArrayRangeEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 98,
   FQN="clang::Designator::getArrayRangeEnd", NM="_ZNK5clang10Designator16getArrayRangeEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZNK5clang10Designator16getArrayRangeEndEv")
  //</editor-fold>
  public Expr /*P*/ getArrayRangeEnd() /*const*/ {
    assert (isArrayRangeDesignator()) : "Invalid accessor";
    return Unnamed_field1.ArrayRangeInfo.End;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Designator::getLBracketLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 103,
   FQN="clang::Designator::getLBracketLoc", NM="_ZNK5clang10Designator14getLBracketLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZNK5clang10Designator14getLBracketLocEv")
  //</editor-fold>
  public SourceLocation getLBracketLoc() /*const*/ {
    assert ((isArrayDesignator() || isArrayRangeDesignator())) : "Invalid accessor";
    if (isArrayDesignator()) {
      return SourceLocation.getFromRawEncoding(Unnamed_field1.ArrayInfo.LBracketLoc);
    } else {
      return SourceLocation.getFromRawEncoding(Unnamed_field1.ArrayRangeInfo.LBracketLoc);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Designator::getRBracketLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 112,
   FQN="clang::Designator::getRBracketLoc", NM="_ZNK5clang10Designator14getRBracketLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZNK5clang10Designator14getRBracketLocEv")
  //</editor-fold>
  public SourceLocation getRBracketLoc() /*const*/ {
    assert ((isArrayDesignator() || isArrayRangeDesignator())) : "Invalid accessor";
    if (isArrayDesignator()) {
      return SourceLocation.getFromRawEncoding(Unnamed_field1.ArrayInfo.RBracketLoc);
    } else {
      return SourceLocation.getFromRawEncoding(Unnamed_field1.ArrayRangeInfo.RBracketLoc);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Designator::getEllipsisLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 121,
   FQN="clang::Designator::getEllipsisLoc", NM="_ZNK5clang10Designator14getEllipsisLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZNK5clang10Designator14getEllipsisLocEv")
  //</editor-fold>
  public SourceLocation getEllipsisLoc() /*const*/ {
    assert (isArrayRangeDesignator()) : "Invalid accessor";
    return SourceLocation.getFromRawEncoding(Unnamed_field1.ArrayRangeInfo.EllipsisLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Designator::getField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 126,
   FQN="clang::Designator::getField", NM="_ZN5clang10Designator8getFieldEPKNS_14IdentifierInfoENS_14SourceLocationES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZN5clang10Designator8getFieldEPKNS_14IdentifierInfoENS_14SourceLocationES4_")
  //</editor-fold>
  public static Designator getField(/*const*/ IdentifierInfo /*P*/ II, SourceLocation DotLoc, 
          SourceLocation NameLoc) {
    Designator D/*J*/= new Designator();
    D.Kind = DesignatorKind.FieldDesignator;
    D.Unnamed_field1.FieldInfo.II = II;
    D.Unnamed_field1.FieldInfo.DotLoc = DotLoc.getRawEncoding();
    D.Unnamed_field1.FieldInfo.NameLoc = NameLoc.getRawEncoding();
    return D;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Designator::getArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 136,
   FQN="clang::Designator::getArray", NM="_ZN5clang10Designator8getArrayEPNS_4ExprENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZN5clang10Designator8getArrayEPNS_4ExprENS_14SourceLocationE")
  //</editor-fold>
  public static Designator getArray(Expr /*P*/ Index, 
          SourceLocation LBracketLoc) {
    Designator D/*J*/= new Designator();
    D.Kind = DesignatorKind.ArrayDesignator;
    D.Unnamed_field1.ArrayInfo.Index = Index;
    D.Unnamed_field1.ArrayInfo.LBracketLoc = LBracketLoc.getRawEncoding();
    D.Unnamed_field1.ArrayInfo.RBracketLoc = 0;
    return D;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Designator::getArrayRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 146,
   FQN="clang::Designator::getArrayRange", NM="_ZN5clang10Designator13getArrayRangeEPNS_4ExprES2_NS_14SourceLocationES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZN5clang10Designator13getArrayRangeEPNS_4ExprES2_NS_14SourceLocationES3_")
  //</editor-fold>
  public static Designator getArrayRange(Expr /*P*/ Start, 
               Expr /*P*/ End, 
               SourceLocation LBracketLoc, 
               SourceLocation EllipsisLoc) {
    Designator D/*J*/= new Designator();
    D.Kind = DesignatorKind.ArrayRangeDesignator;
    D.Unnamed_field1.ArrayRangeInfo.Start = Start;
    D.Unnamed_field1.ArrayRangeInfo.End = End;
    D.Unnamed_field1.ArrayRangeInfo.LBracketLoc = LBracketLoc.getRawEncoding();
    D.Unnamed_field1.ArrayRangeInfo.EllipsisLoc = EllipsisLoc.getRawEncoding();
    D.Unnamed_field1.ArrayRangeInfo.RBracketLoc = 0;
    return D;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Designator::setRBracketLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 160,
   FQN="clang::Designator::setRBracketLoc", NM="_ZNK5clang10Designator14setRBracketLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZNK5clang10Designator14setRBracketLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRBracketLoc(SourceLocation RBracketLoc) /*const*/ {
    assert ((isArrayDesignator() || isArrayRangeDesignator())) : "Invalid accessor";
    if (isArrayDesignator()) {
      Unnamed_field1.ArrayInfo.RBracketLoc = RBracketLoc.getRawEncoding();
    } else {
      Unnamed_field1.ArrayRangeInfo.RBracketLoc = RBracketLoc.getRawEncoding();
    }
  }

  
  /// ClearExprs - Null out any expression references, which prevents
  /// them from being 'delete'd later.
  //<editor-fold defaultstate="collapsed" desc="clang::Designator::ClearExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 171,
   FQN="clang::Designator::ClearExprs", NM="_ZN5clang10Designator10ClearExprsERNS_4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZN5clang10Designator10ClearExprsERNS_4SemaE")
  //</editor-fold>
  public void ClearExprs(final Sema /*&*/ Actions) {
  }

  
  /// FreeExprs - Release any unclaimed memory for the expressions in
  /// this designator.
  //<editor-fold defaultstate="collapsed" desc="clang::Designator::FreeExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 175,
   FQN="clang::Designator::FreeExprs", NM="_ZN5clang10Designator9FreeExprsERNS_4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZN5clang10Designator9FreeExprsERNS_4SemaE")
  //</editor-fold>
  public void FreeExprs(final Sema /*&*/ Actions) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Designator::Designator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*init fields*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 37,
   FQN="clang::Designator::Designator", NM="_ZN5clang10DesignatorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZN5clang10DesignatorC1Ev")
  //</editor-fold>
  public /*inline*/ Designator() {
    this.Kind = DesignatorKind.valueOf(0);
    this.Unnamed_field1 = new Unnamed_union4();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Designator::Designator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 37,
   FQN="clang::Designator::Designator", NM="_ZN5clang10DesignatorC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZN5clang10DesignatorC1EOS0_")
  //</editor-fold>
  public /*inline*/ Designator(JD$Move _dparam, final Designator /*&&*/$Prm0) {
    // : Kind(static_cast<Designator &&>().Kind), Unnamed_field1(static_cast<Designator &&>().) 
    //START JInit
    this.Kind = $Prm0.Kind;
    this.Unnamed_field1 = new Unnamed_union4(JD$Move.INSTANCE, $Prm0.Unnamed_field1);
    //END JInit
  }

  public /*inline*/ Designator(final Designator /*&&*/$Prm0) {
    // : Kind(static_cast<Designator &&>().Kind), Unnamed_field1(static_cast<Designator &&>().) 
    //START JInit
    this.Kind = $Prm0.Kind;
    this.Unnamed_field1 = new Unnamed_union4($Prm0.Unnamed_field1);
    //END JInit
  }
  
  @Override public Designator clone() {
    return new Designator(this);
  }

  @Override public Designator move() {
    return new Designator(JD$Move.INSTANCE, this);
  }  
  
  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", Unnamed_field1=" + Unnamed_field1; // NOI18N
  }
}
