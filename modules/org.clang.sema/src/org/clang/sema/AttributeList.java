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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.basic.target.*;;
import static org.clang.sema.impl.AttributeListStatics.*;
import static org.clang.sema.AttrParsedAttrKindsGlobals.getAttrKind;


/// AttributeList - Represents a syntactic attribute.
///
/// For a GNU attribute, there are four forms of this construct:
///
/// 1: __attribute__(( const )). ParmName/Args/NumArgs will all be unused.
/// 2: __attribute__(( mode(byte) )). ParmName used, Args/NumArgs unused.
/// 3: __attribute__(( format(printf, 1, 2) )). ParmName/Args/NumArgs all used.
/// 4: __attribute__(( aligned(16) )). ParmName is unused, Args/Num used.
///
//<editor-fold defaultstate="collapsed" desc="clang::AttributeList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 94,
 FQN="clang::AttributeList", NM="_ZN5clang13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributeListE")
//</editor-fold>
public class AttributeList implements Destructors.ClassWithDestructor {
// TODO: This should really be called ParsedAttribute
  /*public:*/
  /// The style used to specify an attribute.
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::Syntax">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 97,
   FQN="clang::AttributeList::Syntax", NM="_ZN5clang13AttributeList6SyntaxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributeList6SyntaxE")
  //</editor-fold>
  public enum Syntax implements Native.ComparableLower {
    /// __attribute__((...))
    AS_GNU(0),
    /// [[...]]
    AS_CXX11(AS_GNU.getValue() + 1),
    /// __declspec(...)
    AS_Declspec(AS_CXX11.getValue() + 1),
    /// __ptr16, alignas(...), etc.
    AS_Keyword(AS_Declspec.getValue() + 1),
    /// Context-sensitive version of a keyword attribute.
    AS_ContextSensitiveKeyword(AS_Keyword.getValue() + 1),
    /// #pragma ...
    AS_Pragma(AS_ContextSensitiveKeyword.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Syntax valueOf(int val) {
      Syntax out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Syntax[] VALUES;
      private static final Syntax[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Syntax kind : Syntax.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Syntax[min < 0 ? (1-min) : 0];
        VALUES = new Syntax[max >= 0 ? (1+max) : 0];
        for (Syntax kind : Syntax.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Syntax(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Syntax)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Syntax)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private IdentifierInfo /*P*/ AttrName;
  private IdentifierInfo /*P*/ ScopeName;
  private SourceRange AttrRange;
  private SourceLocation ScopeLoc;
  private SourceLocation EllipsisLoc;
  
  private /*JCHAR unsigned int*/ char AttrKind /*: 16*/;
  
  /// The number of expression arguments this attribute has.
  /// The expressions themselves are stored after the object.
  private /*JCHAR unsigned int*/ char NumArgs /*: 16*/;
  
  /// Corresponds to the Syntax enum.
  private /*JBYTE unsigned int*/ byte SyntaxUsed /*: 3*/;
  
  /// True if already diagnosed as invalid.
  private /*mutable *//*JBIT unsigned int*/ boolean Invalid /*: 1*/;
  
  /// True if this attribute was used as a type attribute.
  private /*mutable *//*JBIT unsigned int*/ boolean UsedAsTypeAttr /*: 1*/;
  
  /// True if this has the extra information associated with an
  /// availability attribute.
  private /*JBIT unsigned int*/ boolean IsAvailability /*: 1*/;
  
  /// True if this has extra information associated with a
  /// type_tag_for_datatype attribute.
  private /*JBIT unsigned int*/ boolean IsTypeTagForDatatype /*: 1*/;
  
  /// True if this has extra information associated with a
  /// Microsoft __delcspec(property) attribute.
  private /*JBIT unsigned int*/ boolean IsProperty /*: 1*/;
  
  /// True if this has a ParsedType
  private /*JBIT unsigned int*/ boolean HasParsedType /*: 1*/;
  
  /// True if the processing cache is valid.
  private /*mutable *//*JBIT unsigned int*/ boolean HasProcessingCache /*: 1*/;
  
  /// A cached value.
  private /*mutable *//*JBYTE unsigned int*/ byte ProcessingCache /*: 8*/;
  
  /// \brief The location of the 'unavailable' keyword in an
  /// availability attribute.
  private SourceLocation UnavailableLoc;
  
  private /*const*/ Expr /*P*/ MessageExpr;
  
  /// The next attribute in the current position.
  private AttributeList /*P*/ NextInPosition;
  
  /// The next attribute allocated in the current Pool.
  /*friend*//*private*/ AttributeList /*P*/ NextInPool;
  
  /// Arguments, if any, are stored immediately following the object.
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getArgsBuffer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 168,
   FQN="clang::AttributeList::getArgsBuffer", NM="_ZN5clang13AttributeList13getArgsBufferEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributeList13getArgsBufferEv")
  //</editor-fold>
  private type$ptr<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >>/*P*/ getArgsBuffer() {    
    return ((type$ptr<PointerUnion<Expr /*P*/, IdentifierLoc /*P*/>>)$this$1);
    // return ((type$ptr<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >>/*P*/ )reinterpret_cast(type$ptr.class, this + 1));    
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getArgsBuffer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 169,
   FQN="clang::AttributeList::getArgsBuffer", NM="_ZNK5clang13AttributeList13getArgsBufferEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList13getArgsBufferEv")
  //</editor-fold>
  private /*const*/type$ptr<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >>/*P*/ getArgsBuffer$Const() /*const*/ {
    return ((type$ptr<PointerUnion<Expr /*P*/, IdentifierLoc /*P*/>>)$this$1);
    //return ((/*const*/type$ptr<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >>/*P*/ )reinterpret_cast(/*const*/type$ptr.class, this + 1));
  }

  
  /// Availability information is stored immediately following the arguments,
  /// if any, at the end of the object.
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getAvailabilityData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 175,
   FQN="clang::AttributeList::getAvailabilityData", NM="_ZN5clang13AttributeList19getAvailabilityDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributeList19getAvailabilityDataEv")
  //</editor-fold>
  private AvailabilityData /*P*/ getAvailabilityData() {
    return (AvailabilityData /*P*/)((type$ptr)getArgsBuffer().$add(NumArgs)).$star();
    // return reinterpret_cast(AvailabilityData /*P*/ .class, getArgsBuffer().$add(NumArgs));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getAvailabilityData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 178,
   FQN="clang::AttributeList::getAvailabilityData", NM="_ZNK5clang13AttributeList19getAvailabilityDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList19getAvailabilityDataEv")
  //</editor-fold>
  private /*const*/ AvailabilityData /*P*/ getAvailabilityData$Const() /*const*/ {
    return (AvailabilityData /*P*/)((type$ptr)getArgsBuffer$Const().$add(NumArgs)).$star();
    //return reinterpret_cast(/*const*/ AvailabilityData /*P*/ .class, getArgsBuffer$Const().$add(NumArgs));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::TypeTagForDatatypeData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 183,
   FQN="clang::AttributeList::TypeTagForDatatypeData", NM="_ZN5clang13AttributeList22TypeTagForDatatypeDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributeList22TypeTagForDatatypeDataE")
  //</editor-fold>
  public static class/*struct*/ TypeTagForDatatypeData {
    public OpaquePtr<QualType> /*P*/ MatchingCType;
    public /*JBIT unsigned int*/ boolean LayoutCompatible /*: 1*/;
    public /*JBIT unsigned int*/ boolean MustBeNull /*: 1*/;
    
    @Override public String toString() {
      return "" + "MatchingCType=" + MatchingCType // NOI18N
                + ", LayoutCompatible=" + LayoutCompatible // NOI18N
                + ", MustBeNull=" + MustBeNull; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::PropertyData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 188,
   FQN="clang::AttributeList::PropertyData", NM="_ZN5clang13AttributeList12PropertyDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributeList12PropertyDataE")
  //</editor-fold>
  public static class/*struct*/ PropertyData {
    public IdentifierInfo /*P*/ GetterId;
    public IdentifierInfo /*P*/ SetterId;
    //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::PropertyData::PropertyData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 190,
     FQN="clang::AttributeList::PropertyData::PropertyData", NM="_ZN5clang13AttributeList12PropertyDataC1EPNS_14IdentifierInfoES3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributeList12PropertyDataC1EPNS_14IdentifierInfoES3_")
    //</editor-fold>
    public PropertyData(IdentifierInfo /*P*/ getterId, IdentifierInfo /*P*/ setterId) {
      // : GetterId(getterId), SetterId(setterId) 
      //START JInit
      this.GetterId = getterId;
      this.SetterId = setterId;
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "GetterId=" + GetterId // NOI18N
                + ", SetterId=" + SetterId; // NOI18N
    }
  };
/*private:*/
  /// Type tag information is stored immediately following the arguments, if
  /// any, at the end of the object.  They are mutually exlusive with
  /// availability slots.
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getTypeTagForDatatypeDataSlot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 198,
   FQN="clang::AttributeList::getTypeTagForDatatypeDataSlot", NM="_ZN5clang13AttributeList29getTypeTagForDatatypeDataSlotEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributeList29getTypeTagForDatatypeDataSlotEv")
  //</editor-fold>
  private TypeTagForDatatypeData /*&*/ getTypeTagForDatatypeDataSlot() {
    return (TypeTagForDatatypeData /*&*/)((type$ptr)getArgsBuffer().$add(NumArgs)).$star();
    //return /*Deref*/reinterpret_cast(TypeTagForDatatypeData /*P*/ .class, getArgsBuffer().$add(NumArgs));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getTypeTagForDatatypeDataSlot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 202,
   FQN="clang::AttributeList::getTypeTagForDatatypeDataSlot", NM="_ZNK5clang13AttributeList29getTypeTagForDatatypeDataSlotEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList29getTypeTagForDatatypeDataSlotEv")
  //</editor-fold>
  private /*const*/ TypeTagForDatatypeData /*&*/ getTypeTagForDatatypeDataSlot$Const() /*const*/ {
    return (TypeTagForDatatypeData /*&*/)((type$ptr)getArgsBuffer$Const().$add(NumArgs)).$star();
    // return /*Deref*/reinterpret_cast(/*const*/ TypeTagForDatatypeData /*P*/ .class, getArgsBuffer$Const().$add(NumArgs));
  }

  
  /// The type buffer immediately follows the object and are mutually exclusive
  /// with arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getTypeBuffer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 209,
   FQN="clang::AttributeList::getTypeBuffer", NM="_ZN5clang13AttributeList13getTypeBufferEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributeList13getTypeBufferEv")
  //</editor-fold>
  private OpaquePtr<QualType> /*&*/ getTypeBuffer() {
    return $Deref(((OpaquePtr<QualType> /*P*/ )$this$1));
//    return /*Deref*/((OpaquePtr<QualType> /*P*/ )reinterpret_cast(OpaquePtr.class, $this$1));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getTypeBuffer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 213,
   FQN="clang::AttributeList::getTypeBuffer", NM="_ZNK5clang13AttributeList13getTypeBufferEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList13getTypeBufferEv")
  //</editor-fold>
  private /*const*/ OpaquePtr<QualType> /*&*/ getTypeBuffer$Const() /*const*/ {
    return $Deref(((/*const*/OpaquePtr<QualType> /*P*/ )$this$1));
//    return /*Deref*/((/*const*/ OpaquePtr<QualType> /*P*/ )reinterpret_cast(/*const*/ OpaquePtr.class, $this$1));
  }

  
  /// The property data immediately follows the object is is mutually exclusive
  /// with arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getPropertyDataBuffer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 219,
   FQN="clang::AttributeList::getPropertyDataBuffer", NM="_ZN5clang13AttributeList21getPropertyDataBufferEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributeList21getPropertyDataBufferEv")
  //</editor-fold>
  private PropertyData /*&*/ getPropertyDataBuffer() {
    assert (IsProperty);
    return $Deref(((PropertyData /*P*/ )$this$1));
//    return /*Deref*/reinterpret_cast(PropertyData /*P*/ .class, $this$1);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getPropertyDataBuffer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 224,
   FQN="clang::AttributeList::getPropertyDataBuffer", NM="_ZNK5clang13AttributeList21getPropertyDataBufferEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList21getPropertyDataBufferEv")
  //</editor-fold>
  private /*const*/ PropertyData /*&*/ getPropertyDataBuffer$Const() /*const*/ {
    assert (IsProperty);
    return $Deref(((/*const*/ PropertyData /*P*/ )$this$1));
    // return /*Deref*/reinterpret_cast(/*const*/ PropertyData /*P*/ .class, $this$1);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::AttributeList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 229,
   FQN="clang::AttributeList::AttributeList", NM="_ZN5clang13AttributeListC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributeListC1ERKS0_")
  //</editor-fold>
  /*friend*//*private*/ AttributeList(final /*const*/ AttributeList /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 230,
   FQN="clang::AttributeList::operator=", NM="_ZN5clang13AttributeListaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributeListaSERKS0_")
  //</editor-fold>
  private void $assign(final /*const*/ AttributeList /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::operator delete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 231,
   FQN="clang::AttributeList::operator delete", NM="_ZN5clang13AttributeListdlEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributeListdlEPv")
  //</editor-fold>
  private static void $delete(Object/*void P*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::~AttributeList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 232,
   FQN="clang::AttributeList::~AttributeList", NM="_ZN5clang13AttributeListD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributeListD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy() { throw new UnsupportedOperationException("Deleted");}

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::allocated_size">
  @Converted(kind = Converted.Kind.DUMMY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp", line = 34,
   FQN="clang::AttributeList::allocated_size", NM="_ZNK5clang13AttributeList14allocated_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList14allocated_sizeEv")
  //</editor-fold>
  /*friend*/ /*size_t*/int allocated_size() /*const*/ {
//    if (IsAvailability) {
//      return AttributeFactory.Unnamed_enum.AvailabilityAllocSize.getValue();
//    } else if (IsTypeTagForDatatype) {
//      return AttributeFactory.Unnamed_enum.TypeTagForDatatypeAllocSize.getValue();
//    } else if (IsProperty) {
//      return AttributeFactory.Unnamed_enum.PropertyAllocSize.getValue();
//    }
//    return ($sizeof_AttributeList() + NumArgs * $uint2uint_16bits($sizeof_PointerUnion$Expr$IdentifierLoc$P$P()));
    throw new UnsupportedOperationException("It does not make sense calling this method in Java");
  }

  
  /// Constructor for attributes with expression arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::AttributeList">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$tail$memory*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 237,
   FQN="clang::AttributeList::AttributeList", NM="_ZN5clang13AttributeListC1EPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationEPN4llvm12PointerUnionIPNS_4ExprEPNS_13IdentifierLocEEEjNS0_6SyntaxES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributeListC1EPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationEPN4llvm12PointerUnionIPNS_4ExprEPNS_13IdentifierLocEEEjNS0_6SyntaxES4_")
  //</editor-fold>
  /*friend*//*private*/ AttributeList(IdentifierInfo /*P*/ attrName, SourceRange attrRange, 
      IdentifierInfo /*P*/ scopeName, SourceLocation scopeLoc, 
      type$ptr<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >>/*P*/ args, /*uint*/int numArgs, 
      Syntax syntaxUsed, SourceLocation ellipsisLoc,
      type$ptr<PointerUnion<Expr /*P*/, IdentifierLoc /*P*/>> $this$tail) {
    // : AttrName(attrName), ScopeName(scopeName), AttrRange(attrRange), ScopeLoc(scopeLoc), EllipsisLoc(ellipsisLoc), NumArgs(numArgs), SyntaxUsed(syntaxUsed), Invalid(false), UsedAsTypeAttr(false), IsAvailability(false), IsTypeTagForDatatype(false), IsProperty(false), HasParsedType(false), HasProcessingCache(false), UnavailableLoc(), NextInPosition(null), NextInPool(null) 
    //START JInit
    this.AttrName = attrName;
    this.ScopeName = scopeName;
    this.AttrRange = new SourceRange(attrRange);
    this.ScopeLoc = new SourceLocation(scopeLoc);
    this.EllipsisLoc = new SourceLocation(ellipsisLoc);
    this.NumArgs = $uint2uint_16bits(numArgs);
    this.SyntaxUsed = $uint2uint_3bits(syntaxUsed.getValue());
    this.Invalid = false;
    this.UsedAsTypeAttr = false;
    this.IsAvailability = false;
    this.IsTypeTagForDatatype = false;
    this.IsProperty = false;
    this.HasParsedType = false;
    this.HasProcessingCache = false;
    this.UnavailableLoc = new SourceLocation();
    this.NextInPosition = null;
    this.NextInPool = null;
    //END JInit    
    $this$1 = $tryConstClone($this$tail);
    if ((numArgs != 0)) { 
      if (false) memcpy(getArgsBuffer(), args, numArgs/* $sizeof_PointerUnion$Expr$IdentifierLoc$P$P()*/, false);
      // JAVA:
      for (int i = 0; i < NumArgs; i++) {
        ((type$ptr<PointerUnion<Expr /*P*/, IdentifierLoc /*P*/>>)$this$1).$set(i, new PointerUnion(args.$at(i)));
      }
    }
    AttrKind = $uint2uint_16bits(getKind(getName(), getScopeName(), syntaxUsed).getValue());
  }

  
  /// Constructor for availability attributes.
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::AttributeList">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$tail$memory*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 252,
   FQN="clang::AttributeList::AttributeList", NM="_ZN5clang13AttributeListC1EPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationEPNS_13IdentifierLocERKNS_18AvailabilityChangeES9_S9_S4_PKNS_4ExprENS0_6SyntaxES4_SC_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributeListC1EPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationEPNS_13IdentifierLocERKNS_18AvailabilityChangeES9_S9_S4_PKNS_4ExprENS0_6SyntaxES4_SC_")
  //</editor-fold>
  /*friend*//*private*/ AttributeList(IdentifierInfo /*P*/ attrName, SourceRange attrRange, 
      IdentifierInfo /*P*/ scopeName, SourceLocation scopeLoc, 
      IdentifierLoc /*P*/ Parm, final /*const*/ AvailabilityChange /*&*/ introduced, 
      final /*const*/ AvailabilityChange /*&*/ deprecated, 
      final /*const*/ AvailabilityChange /*&*/ obsoleted, 
      SourceLocation unavailable, 
      /*const*/ Expr /*P*/ messageExpr, 
      Syntax syntaxUsed, SourceLocation strict, 
      /*const*/ Expr /*P*/ replacementExpr,
      type$ptr $tail$memory) {
    // : AttrName(attrName), ScopeName(scopeName), AttrRange(attrRange), ScopeLoc(scopeLoc), EllipsisLoc(), NumArgs(1), SyntaxUsed(syntaxUsed), Invalid(false), UsedAsTypeAttr(false), IsAvailability(true), IsTypeTagForDatatype(false), IsProperty(false), HasParsedType(false), HasProcessingCache(false), UnavailableLoc(unavailable), MessageExpr(messageExpr), NextInPosition(null), NextInPool(null) 
    //START JInit
    this.AttrName = attrName;
    this.ScopeName = scopeName;
    this.AttrRange = new SourceRange(attrRange);
    this.ScopeLoc = new SourceLocation(scopeLoc);
    this.EllipsisLoc = new SourceLocation();
    this.NumArgs = $uint2uint_16bits(1);
    this.SyntaxUsed = $uint2uint_3bits(syntaxUsed.getValue());
    this.Invalid = false;
    this.UsedAsTypeAttr = false;
    this.IsAvailability = true;
    this.IsTypeTagForDatatype = false;
    this.IsProperty = false;
    this.HasParsedType = false;
    this.HasProcessingCache = false;
    this.UnavailableLoc = new SourceLocation(unavailable);
    this.MessageExpr = messageExpr;
    this.NextInPosition = null;
    this.NextInPool = null;
    //END JInit
    $this$1 = $tryConstClone($tail$memory);
    PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ > PVal/*J*/= new PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >(JD$T1.INSTANCE, IdentifierLoc /*P*/ .class, Parm);
    if (false) {
      memcpy(getArgsBuffer(), $AddrOf(create_type$ptr(PVal)), 1/*$sizeof_PointerUnion$Expr$IdentifierLoc$P$P()*/, false);
      /*FIXME:NEW_EXPR*//*getAvailabilityData() = *//*new (getAvailabilityData())*/ new AvailabilityData(introduced, deprecated, obsoleted, new SourceLocation(strict), replacementExpr);
    } else {
      // JAVA:
      ((type$ptr)$this$1).$set(0, PVal);
      ((type$ptr)$this$1).$set(1, new AvailabilityData(introduced, deprecated, obsoleted, new SourceLocation(strict), replacementExpr));
    }
    AttrKind = $uint2uint_16bits(getKind(getName(), getScopeName(), syntaxUsed).getValue());
  }

  
  /// Constructor for objc_bridge_related attributes.
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::AttributeList">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$tail$memory*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 275,
   FQN="clang::AttributeList::AttributeList", NM="_ZN5clang13AttributeListC1EPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationEPNS_13IdentifierLocES6_S6_NS0_6SyntaxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributeListC1EPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationEPNS_13IdentifierLocES6_S6_NS0_6SyntaxE")
  //</editor-fold>
  /*friend*//*private*/ AttributeList(IdentifierInfo /*P*/ attrName, SourceRange attrRange, 
      IdentifierInfo /*P*/ scopeName, SourceLocation scopeLoc, 
      IdentifierLoc /*P*/ Parm1, 
      IdentifierLoc /*P*/ Parm2, 
      IdentifierLoc /*P*/ Parm3, 
      Syntax syntaxUsed,
      type$ptr<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >> $tail$memory) {
    // : AttrName(attrName), ScopeName(scopeName), AttrRange(attrRange), ScopeLoc(scopeLoc), EllipsisLoc(), NumArgs(3), SyntaxUsed(syntaxUsed), Invalid(false), UsedAsTypeAttr(false), IsAvailability(false), IsTypeTagForDatatype(false), IsProperty(false), HasParsedType(false), HasProcessingCache(false), UnavailableLoc(), NextInPosition(null), NextInPool(null) 
    //START JInit
    this.AttrName = attrName;
    this.ScopeName = scopeName;
    this.AttrRange = new SourceRange(attrRange);
    this.ScopeLoc = new SourceLocation(scopeLoc);
    this.EllipsisLoc = new SourceLocation();
    this.NumArgs = $uint2uint_16bits(3);
    this.SyntaxUsed = $uint2uint_3bits(syntaxUsed.getValue());
    this.Invalid = false;
    this.UsedAsTypeAttr = false;
    this.IsAvailability = false;
    this.IsTypeTagForDatatype = false;
    this.IsProperty = false;
    this.HasParsedType = false;
    this.HasProcessingCache = false;
    this.UnavailableLoc = new SourceLocation();
    this.NextInPosition = null;
    this.NextInPool = null;
    //END JInit
    $this$1 = $tryConstClone($tail$memory);
    type$ptr<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >>/*P*/ Args = $tryClone(getArgsBuffer());
    if (false) {
      Args.$at(0).$assign_T1$C$R(IdentifierLoc /*P*/.class, Parm1);
      Args.$at(1).$assign_T1$C$R(IdentifierLoc /*P*/.class, Parm2);
      Args.$at(2).$assign_T1$C$R(IdentifierLoc /*P*/.class, Parm3);
    } else {
      // JAVA: outer memory is not initialized
      Args.$set(0, new PointerUnion(JD$T1.INSTANCE, IdentifierLoc /*P*/.class, Parm1));
      Args.$set(1, new PointerUnion(JD$T1.INSTANCE, IdentifierLoc /*P*/.class, Parm2));
      Args.$set(2, new PointerUnion(JD$T1.INSTANCE, IdentifierLoc /*P*/.class, Parm3));
    }
    AttrKind = $uint2uint_16bits(getKind(getName(), getScopeName(), syntaxUsed).getValue());
  }

  
  /// Constructor for type_tag_for_datatype attribute.
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::AttributeList">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$tail$memory*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 294,
   FQN="clang::AttributeList::AttributeList", NM="_ZN5clang13AttributeListC1EPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationEPNS_13IdentifierLocENS_9OpaquePtrINS_8QualTypeEEEbbNS0_6SyntaxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributeListC1EPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationEPNS_13IdentifierLocENS_9OpaquePtrINS_8QualTypeEEEbbNS0_6SyntaxE")
  //</editor-fold>
  /*friend*//*private*/ AttributeList(IdentifierInfo /*P*/ attrName, SourceRange attrRange, 
      IdentifierInfo /*P*/ scopeName, SourceLocation scopeLoc, 
      IdentifierLoc /*P*/ ArgKind, OpaquePtr<QualType> matchingCType, 
      boolean layoutCompatible, boolean mustBeNull, Syntax syntaxUsed,
      type$ptr $tail$memory) {
    // : AttrName(attrName), ScopeName(scopeName), AttrRange(attrRange), ScopeLoc(scopeLoc), EllipsisLoc(), NumArgs(1), SyntaxUsed(syntaxUsed), Invalid(false), UsedAsTypeAttr(false), IsAvailability(false), IsTypeTagForDatatype(true), IsProperty(false), HasParsedType(false), HasProcessingCache(false), UnavailableLoc(), NextInPosition(null), NextInPool(null) 
    //START JInit
    this.AttrName = attrName;
    this.ScopeName = scopeName;
    this.AttrRange = new SourceRange(attrRange);
    this.ScopeLoc = new SourceLocation(scopeLoc);
    this.EllipsisLoc = new SourceLocation();
    this.NumArgs = $uint2uint_16bits(1);
    this.SyntaxUsed = $uint2uint_3bits(syntaxUsed.getValue());
    this.Invalid = false;
    this.UsedAsTypeAttr = false;
    this.IsAvailability = false;
    this.IsTypeTagForDatatype = true;
    this.IsProperty = false;
    this.HasParsedType = false;
    this.HasProcessingCache = false;
    this.UnavailableLoc = new SourceLocation();
    this.NextInPosition = null;
    this.NextInPool = null;
    //END JInit
    $this$1 = $tryConstClone($tail$memory);
    PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ > PVal/*J*/= new PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >(JD$T1.INSTANCE, IdentifierLoc /*P*/ .class, ArgKind);
    final TypeTagForDatatypeData /*&*/ ExtraData;
    if (false) {
      memcpy(getArgsBuffer(), $AddrOf(create_type$ptr(PVal)), 1/*$sizeof_PointerUnion$Expr$IdentifierLoc$P$P()*/, false);
      ExtraData = getTypeTagForDatatypeDataSlot();
      /*FIXME:NEW_EXPR*//*new (&ExtraData.MatchingCType)*/ new OpaquePtr<QualType>(matchingCType);
    } else {
      // JAVA: outer memory is not initialized
      getArgsBuffer().$set(PVal);
      ((type$ptr)$this$1).$set(1, ExtraData = new TypeTagForDatatypeData());
      ExtraData.MatchingCType = new OpaquePtr<QualType>(matchingCType);
    }
    ExtraData.LayoutCompatible = layoutCompatible;
    ExtraData.MustBeNull = mustBeNull;
    AttrKind = $uint2uint_16bits(getKind(getName(), getScopeName(), syntaxUsed).getValue());
  }

  
  /// Constructor for attributes with a single type argument.
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::AttributeList">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this$1*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 313,
   FQN="clang::AttributeList::AttributeList", NM="_ZN5clang13AttributeListC1EPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationENS_9OpaquePtrINS_8QualTypeEEENS0_6SyntaxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributeListC1EPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationENS_9OpaquePtrINS_8QualTypeEEENS0_6SyntaxE")
  //</editor-fold>
  /*friend*//*private*/ AttributeList(IdentifierInfo /*P*/ attrName, SourceRange attrRange, 
      IdentifierInfo /*P*/ scopeName, SourceLocation scopeLoc, 
      OpaquePtr<QualType> typeArg, Syntax syntaxUsed) {
    // : AttrName(attrName), ScopeName(scopeName), AttrRange(attrRange), ScopeLoc(scopeLoc), EllipsisLoc(), NumArgs(0), SyntaxUsed(syntaxUsed), Invalid(false), UsedAsTypeAttr(false), IsAvailability(false), IsTypeTagForDatatype(false), IsProperty(false), HasParsedType(true), HasProcessingCache(false), UnavailableLoc(), NextInPosition(null), NextInPool(null) 
    //START JInit
    this.AttrName = attrName;
    this.ScopeName = scopeName;
    this.AttrRange = new SourceRange(attrRange);
    this.ScopeLoc = new SourceLocation(scopeLoc);
    this.EllipsisLoc = new SourceLocation();
    this.NumArgs = $uint2uint_16bits(0);
    this.SyntaxUsed = $uint2uint_3bits(syntaxUsed.getValue());
    this.Invalid = false;
    this.UsedAsTypeAttr = false;
    this.IsAvailability = false;
    this.IsTypeTagForDatatype = false;
    this.IsProperty = false;
    this.HasParsedType = true;
    this.HasProcessingCache = false;
    this.UnavailableLoc = new SourceLocation();
    this.NextInPosition = null;
    this.NextInPool = null;
    //END JInit
    if (false) {
      /*FIXME:NEW_EXPR*/$AddrOf(getTypeBuffer()); /* = new (&getTypeBuffer())*/ new OpaquePtr<QualType>(typeArg);
    }
    $this$1 = new OpaquePtr<>(typeArg);
    AttrKind = $uint2uint_16bits(getKind(getName(), getScopeName(), syntaxUsed).getValue());
  }

  
  /// Constructor for microsoft __declspec(property) attribute.
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::AttributeList">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$tail$memory*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 326,
   FQN="clang::AttributeList::AttributeList", NM="_ZN5clang13AttributeListC1EPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationES2_S2_NS0_6SyntaxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributeListC1EPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationES2_S2_NS0_6SyntaxE")
  //</editor-fold>
  /*friend*//*private*/ AttributeList(IdentifierInfo /*P*/ attrName, SourceRange attrRange, 
      IdentifierInfo /*P*/ scopeName, SourceLocation scopeLoc, 
      IdentifierInfo /*P*/ getterId, IdentifierInfo /*P*/ setterId, 
      Syntax syntaxUsed) {
    // : AttrName(attrName), ScopeName(scopeName), AttrRange(attrRange), ScopeLoc(scopeLoc), EllipsisLoc(), NumArgs(0), SyntaxUsed(syntaxUsed), Invalid(false), UsedAsTypeAttr(false), IsAvailability(false), IsTypeTagForDatatype(false), IsProperty(true), HasParsedType(false), HasProcessingCache(false), UnavailableLoc(), NextInPosition(null), NextInPool(null) 
    //START JInit
    this.AttrName = attrName;
    this.ScopeName = scopeName;
    this.AttrRange = new SourceRange(attrRange);
    this.ScopeLoc = new SourceLocation(scopeLoc);
    this.EllipsisLoc = new SourceLocation();
    this.NumArgs = $uint2uint_16bits(0);
    this.SyntaxUsed = $uint2uint_3bits(syntaxUsed.getValue());
    this.Invalid = false;
    this.UsedAsTypeAttr = false;
    this.IsAvailability = false;
    this.IsTypeTagForDatatype = false;
    this.IsProperty = true;
    this.HasParsedType = false;
    this.HasProcessingCache = false;
    this.UnavailableLoc = new SourceLocation();
    this.NextInPosition = null;
    this.NextInPool = null;
    //END JInit
    if (false) {
      /*FIXME:NEW_EXPR*/$AddrOf(getPropertyDataBuffer()); /*= new (&getPropertyDataBuffer())*/ new PropertyData(getterId, setterId);
    }
    $this$1 = new PropertyData(getterId, setterId);
    AttrKind = $uint2uint_16bits(getKind(getName(), getScopeName(), syntaxUsed).getValue());
  }

  
  /*friend  class AttributePool*/
  /*friend  class AttributeFactory*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 343,
   FQN="clang::AttributeList::Kind", NM="_ZN5clang13AttributeList4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributeList4KindE")
  //</editor-fold>
  public enum Kind implements Native.ComparableLower {
    AT_AMDGPUNumSGPR(0),
    AT_AMDGPUNumVGPR(AT_AMDGPUNumSGPR.getValue() + 1),
    AT_Interrupt(AT_AMDGPUNumVGPR.getValue() + 1),
    AT_AbiTag(AT_Interrupt.getValue() + 1),
    AT_AcquireCapability(AT_AbiTag.getValue() + 1),
    AT_AcquiredAfter(AT_AcquireCapability.getValue() + 1),
    AT_AcquiredBefore(AT_AcquiredAfter.getValue() + 1),
    AT_AddressSpace(AT_AcquiredBefore.getValue() + 1),
    AT_Alias(AT_AddressSpace.getValue() + 1),
    AT_AlignValue(AT_Alias.getValue() + 1),
    AT_Aligned(AT_AlignValue.getValue() + 1),
    AT_AlwaysInline(AT_Aligned.getValue() + 1),
    AT_AnalyzerNoReturn(AT_AlwaysInline.getValue() + 1),
    AT_Annotate(AT_AnalyzerNoReturn.getValue() + 1),
    AT_ArcWeakrefUnavailable(AT_Annotate.getValue() + 1),
    AT_ArgumentWithTypeTag(AT_ArcWeakrefUnavailable.getValue() + 1),
    AT_AssertCapability(AT_ArgumentWithTypeTag.getValue() + 1),
    AT_AssertExclusiveLock(AT_AssertCapability.getValue() + 1),
    AT_AssertSharedLock(AT_AssertExclusiveLock.getValue() + 1),
    AT_AssumeAligned(AT_AssertSharedLock.getValue() + 1),
    AT_Availability(AT_AssumeAligned.getValue() + 1),
    AT_Blocks(AT_Availability.getValue() + 1),
    AT_CDecl(AT_Blocks.getValue() + 1),
    AT_CFAuditedTransfer(AT_CDecl.getValue() + 1),
    AT_CFConsumed(AT_CFAuditedTransfer.getValue() + 1),
    AT_CFReturnsNotRetained(AT_CFConsumed.getValue() + 1),
    AT_CFReturnsRetained(AT_CFReturnsNotRetained.getValue() + 1),
    AT_CFUnknownTransfer(AT_CFReturnsRetained.getValue() + 1),
    AT_CUDAConstant(AT_CFUnknownTransfer.getValue() + 1),
    AT_CUDADevice(AT_CUDAConstant.getValue() + 1),
    AT_CUDAGlobal(AT_CUDADevice.getValue() + 1),
    AT_CUDAHost(AT_CUDAGlobal.getValue() + 1),
    AT_CUDAInvalidTarget(AT_CUDAHost.getValue() + 1),
    AT_CUDALaunchBounds(AT_CUDAInvalidTarget.getValue() + 1),
    AT_CUDAShared(AT_CUDALaunchBounds.getValue() + 1),
    AT_CXX11NoReturn(AT_CUDAShared.getValue() + 1),
    AT_CallableWhen(AT_CXX11NoReturn.getValue() + 1),
    AT_Capability(AT_CallableWhen.getValue() + 1),
    AT_CarriesDependency(AT_Capability.getValue() + 1),
    AT_Cleanup(AT_CarriesDependency.getValue() + 1),
    AT_Cold(AT_Cleanup.getValue() + 1),
    AT_Common(AT_Cold.getValue() + 1),
    AT_Const(AT_Common.getValue() + 1),
    AT_Constructor(AT_Const.getValue() + 1),
    AT_Consumable(AT_Constructor.getValue() + 1),
    AT_ConsumableAutoCast(AT_Consumable.getValue() + 1),
    AT_ConsumableSetOnRead(AT_ConsumableAutoCast.getValue() + 1),
    AT_DLLExport(AT_ConsumableSetOnRead.getValue() + 1),
    AT_DLLImport(AT_DLLExport.getValue() + 1),
    AT_Deprecated(AT_DLLImport.getValue() + 1),
    AT_Destructor(AT_Deprecated.getValue() + 1),
    AT_DisableTailCalls(AT_Destructor.getValue() + 1),
    AT_EmptyBases(AT_DisableTailCalls.getValue() + 1),
    AT_EnableIf(AT_EmptyBases.getValue() + 1),
    AT_ExclusiveTrylockFunction(AT_EnableIf.getValue() + 1),
    AT_ExtVectorType(AT_ExclusiveTrylockFunction.getValue() + 1),
    AT_FallThrough(AT_ExtVectorType.getValue() + 1),
    AT_FastCall(AT_FallThrough.getValue() + 1),
    AT_FlagEnum(AT_FastCall.getValue() + 1),
    AT_Flatten(AT_FlagEnum.getValue() + 1),
    AT_Format(AT_Flatten.getValue() + 1),
    AT_FormatArg(AT_Format.getValue() + 1),
    AT_GNUInline(AT_FormatArg.getValue() + 1),
    AT_GuardedBy(AT_GNUInline.getValue() + 1),
    AT_GuardedVar(AT_GuardedBy.getValue() + 1),
    AT_Hot(AT_GuardedVar.getValue() + 1),
    AT_IBAction(AT_Hot.getValue() + 1),
    AT_IBOutlet(AT_IBAction.getValue() + 1),
    AT_IBOutletCollection(AT_IBOutlet.getValue() + 1),
    AT_IFunc(AT_IBOutletCollection.getValue() + 1),
    AT_InitPriority(AT_IFunc.getValue() + 1),
    AT_IntelOclBicc(AT_InitPriority.getValue() + 1),
    AT_InternalLinkage(AT_IntelOclBicc.getValue() + 1),
    AT_LTOVisibilityPublic(AT_InternalLinkage.getValue() + 1),
    AT_LayoutVersion(AT_LTOVisibilityPublic.getValue() + 1),
    AT_LockReturned(AT_LayoutVersion.getValue() + 1),
    AT_Lockable(AT_LockReturned.getValue() + 1),
    AT_LocksExcluded(AT_Lockable.getValue() + 1),
    AT_LoopHint(AT_LocksExcluded.getValue() + 1),
    AT_MSABI(AT_LoopHint.getValue() + 1),
    AT_MSInheritance(AT_MSABI.getValue() + 1),
    AT_MSNoVTable(AT_MSInheritance.getValue() + 1),
    AT_MSStruct(AT_MSNoVTable.getValue() + 1),
    AT_MayAlias(AT_MSStruct.getValue() + 1),
    AT_MinSize(AT_MayAlias.getValue() + 1),
    AT_Mips16(AT_MinSize.getValue() + 1),
    AT_Mode(AT_Mips16.getValue() + 1),
    AT_NSConsumed(AT_Mode.getValue() + 1),
    AT_NSConsumesSelf(AT_NSConsumed.getValue() + 1),
    AT_NSReturnsAutoreleased(AT_NSConsumesSelf.getValue() + 1),
    AT_NSReturnsNotRetained(AT_NSReturnsAutoreleased.getValue() + 1),
    AT_NSReturnsRetained(AT_NSReturnsNotRetained.getValue() + 1),
    AT_Naked(AT_NSReturnsRetained.getValue() + 1),
    AT_NeonPolyVectorType(AT_Naked.getValue() + 1),
    AT_NeonVectorType(AT_NeonPolyVectorType.getValue() + 1),
    AT_NoAlias(AT_NeonVectorType.getValue() + 1),
    AT_NoCommon(AT_NoAlias.getValue() + 1),
    AT_NoDebug(AT_NoCommon.getValue() + 1),
    AT_NoDuplicate(AT_NoDebug.getValue() + 1),
    AT_NoInline(AT_NoDuplicate.getValue() + 1),
    AT_NoInstrumentFunction(AT_NoInline.getValue() + 1),
    AT_NoMips16(AT_NoInstrumentFunction.getValue() + 1),
    AT_NoReturn(AT_NoMips16.getValue() + 1),
    AT_NoSanitize(AT_NoReturn.getValue() + 1),
    AT_NoSanitizeSpecific(AT_NoSanitize.getValue() + 1),
    AT_NoSplitStack(AT_NoSanitizeSpecific.getValue() + 1),
    AT_NoThreadSafetyAnalysis(AT_NoSplitStack.getValue() + 1),
    AT_NoThrow(AT_NoThreadSafetyAnalysis.getValue() + 1),
    AT_NonNull(AT_NoThrow.getValue() + 1),
    AT_NotTailCalled(AT_NonNull.getValue() + 1),
    AT_ObjCBoxable(AT_NotTailCalled.getValue() + 1),
    AT_ObjCBridge(AT_ObjCBoxable.getValue() + 1),
    AT_ObjCBridgeMutable(AT_ObjCBridge.getValue() + 1),
    AT_ObjCBridgeRelated(AT_ObjCBridgeMutable.getValue() + 1),
    AT_ObjCDesignatedInitializer(AT_ObjCBridgeRelated.getValue() + 1),
    AT_ObjCException(AT_ObjCDesignatedInitializer.getValue() + 1),
    AT_ObjCExplicitProtocolImpl(AT_ObjCException.getValue() + 1),
    AT_ObjCGC(AT_ObjCExplicitProtocolImpl.getValue() + 1),
    AT_ObjCIndependentClass(AT_ObjCGC.getValue() + 1),
    AT_ObjCKindOf(AT_ObjCIndependentClass.getValue() + 1),
    AT_ObjCMethodFamily(AT_ObjCKindOf.getValue() + 1),
    AT_ObjCNSObject(AT_ObjCMethodFamily.getValue() + 1),
    AT_ObjCOwnership(AT_ObjCNSObject.getValue() + 1),
    AT_ObjCPreciseLifetime(AT_ObjCOwnership.getValue() + 1),
    AT_ObjCRequiresPropertyDefs(AT_ObjCPreciseLifetime.getValue() + 1),
    AT_ObjCRequiresSuper(AT_ObjCRequiresPropertyDefs.getValue() + 1),
    AT_ObjCReturnsInnerPointer(AT_ObjCRequiresSuper.getValue() + 1),
    AT_ObjCRootClass(AT_ObjCReturnsInnerPointer.getValue() + 1),
    AT_ObjCRuntimeName(AT_ObjCRootClass.getValue() + 1),
    AT_ObjCRuntimeVisible(AT_ObjCRuntimeName.getValue() + 1),
    AT_OpenCLAccess(AT_ObjCRuntimeVisible.getValue() + 1),
    AT_OpenCLConstantAddressSpace(AT_OpenCLAccess.getValue() + 1),
    AT_OpenCLGenericAddressSpace(AT_OpenCLConstantAddressSpace.getValue() + 1),
    AT_OpenCLGlobalAddressSpace(AT_OpenCLGenericAddressSpace.getValue() + 1),
    AT_OpenCLKernel(AT_OpenCLGlobalAddressSpace.getValue() + 1),
    AT_OpenCLLocalAddressSpace(AT_OpenCLKernel.getValue() + 1),
    AT_OpenCLNoSVM(AT_OpenCLLocalAddressSpace.getValue() + 1),
    AT_OpenCLPrivateAddressSpace(AT_OpenCLNoSVM.getValue() + 1),
    AT_OpenCLUnrollHint(AT_OpenCLPrivateAddressSpace.getValue() + 1),
    AT_OptimizeNone(AT_OpenCLUnrollHint.getValue() + 1),
    AT_Overloadable(AT_OptimizeNone.getValue() + 1),
    AT_Ownership(AT_Overloadable.getValue() + 1),
    AT_Packed(AT_Ownership.getValue() + 1),
    AT_ParamTypestate(AT_Packed.getValue() + 1),
    AT_Pascal(AT_ParamTypestate.getValue() + 1),
    AT_PassObjectSize(AT_Pascal.getValue() + 1),
    AT_Pcs(AT_PassObjectSize.getValue() + 1),
    AT_PreserveAll(AT_Pcs.getValue() + 1),
    AT_PreserveMost(AT_PreserveAll.getValue() + 1),
    AT_PtGuardedBy(AT_PreserveMost.getValue() + 1),
    AT_PtGuardedVar(AT_PtGuardedBy.getValue() + 1),
    AT_Ptr32(AT_PtGuardedVar.getValue() + 1),
    AT_Ptr64(AT_Ptr32.getValue() + 1),
    AT_Pure(AT_Ptr64.getValue() + 1),
    AT_Regparm(AT_Pure.getValue() + 1),
    AT_ReleaseCapability(AT_Regparm.getValue() + 1),
    AT_RenderScriptKernel(AT_ReleaseCapability.getValue() + 1),
    AT_ReqdWorkGroupSize(AT_RenderScriptKernel.getValue() + 1),
    AT_RequiresCapability(AT_ReqdWorkGroupSize.getValue() + 1),
    AT_Restrict(AT_RequiresCapability.getValue() + 1),
    AT_ReturnTypestate(AT_Restrict.getValue() + 1),
    AT_ReturnsNonNull(AT_ReturnTypestate.getValue() + 1),
    AT_ReturnsTwice(AT_ReturnsNonNull.getValue() + 1),
    AT_SPtr(AT_ReturnsTwice.getValue() + 1),
    AT_ScopedLockable(AT_SPtr.getValue() + 1),
    AT_Section(AT_ScopedLockable.getValue() + 1),
    AT_SelectAny(AT_Section.getValue() + 1),
    AT_Sentinel(AT_SelectAny.getValue() + 1),
    AT_SetTypestate(AT_Sentinel.getValue() + 1),
    AT_SharedTrylockFunction(AT_SetTypestate.getValue() + 1),
    AT_StdCall(AT_SharedTrylockFunction.getValue() + 1),
    AT_SwiftCall(AT_StdCall.getValue() + 1),
    AT_SwiftContext(AT_SwiftCall.getValue() + 1),
    AT_SwiftErrorResult(AT_SwiftContext.getValue() + 1),
    AT_SwiftIndirectResult(AT_SwiftErrorResult.getValue() + 1),
    AT_SysVABI(AT_SwiftIndirectResult.getValue() + 1),
    AT_TLSModel(AT_SysVABI.getValue() + 1),
    AT_Target(AT_TLSModel.getValue() + 1),
    AT_TestTypestate(AT_Target.getValue() + 1),
    AT_ThisCall(AT_TestTypestate.getValue() + 1),
    AT_Thread(AT_ThisCall.getValue() + 1),
    AT_TransparentUnion(AT_Thread.getValue() + 1),
    AT_TryAcquireCapability(AT_TransparentUnion.getValue() + 1),
    AT_TypeNonNull(AT_TryAcquireCapability.getValue() + 1),
    AT_TypeNullUnspecified(AT_TypeNonNull.getValue() + 1),
    AT_TypeNullable(AT_TypeNullUnspecified.getValue() + 1),
    AT_TypeTagForDatatype(AT_TypeNullable.getValue() + 1),
    AT_TypeVisibility(AT_TypeTagForDatatype.getValue() + 1),
    AT_UPtr(AT_TypeVisibility.getValue() + 1),
    AT_Unavailable(AT_UPtr.getValue() + 1),
    AT_Unused(AT_Unavailable.getValue() + 1),
    AT_Used(AT_Unused.getValue() + 1),
    AT_Uuid(AT_Used.getValue() + 1),
    AT_VecReturn(AT_Uuid.getValue() + 1),
    AT_VecTypeHint(AT_VecReturn.getValue() + 1),
    AT_VectorCall(AT_VecTypeHint.getValue() + 1),
    AT_VectorSize(AT_VectorCall.getValue() + 1),
    AT_Visibility(AT_VectorSize.getValue() + 1),
    AT_WarnUnused(AT_Visibility.getValue() + 1),
    AT_WarnUnusedResult(AT_WarnUnused.getValue() + 1),
    AT_Weak(AT_WarnUnusedResult.getValue() + 1),
    AT_WeakImport(AT_Weak.getValue() + 1),
    AT_WeakRef(AT_WeakImport.getValue() + 1),
    AT_WorkGroupSizeHint(AT_WeakRef.getValue() + 1),
    AT_X86ForceAlignArgPointer(AT_WorkGroupSizeHint.getValue() + 1),
    AT_XRayInstrument(AT_X86ForceAlignArgPointer.getValue() + 1),
    IgnoredAttribute(AT_XRayInstrument.getValue() + 1),
    UnknownAttribute(IgnoredAttribute.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Kind valueOf(int val) {
      Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Kind[] VALUES;
      private static final Kind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Kind kind : Kind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Kind[min < 0 ? (1-min) : 0];
        VALUES = new Kind[max >= 0 ? (1+max) : 0];
        for (Kind kind : Kind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Kind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Kind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Kind)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 351,
   FQN="clang::AttributeList::getName", NM="_ZNK5clang13AttributeList7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList7getNameEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getName() /*const*/ {
    return AttrName;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 352,
   FQN="clang::AttributeList::getLoc", NM="_ZNK5clang13AttributeList6getLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList6getLocEv")
  //</editor-fold>
  public SourceLocation getLoc() /*const*/ {
    return AttrRange.getBegin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 353,
   FQN="clang::AttributeList::getRange", NM="_ZNK5clang13AttributeList8getRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList8getRangeEv")
  //</editor-fold>
  public SourceRange getRange() /*const*/ {
    return new SourceRange(AttrRange);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::hasScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 355,
   FQN="clang::AttributeList::hasScope", NM="_ZNK5clang13AttributeList8hasScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList8hasScopeEv")
  //</editor-fold>
  public boolean hasScope() /*const*/ {
    return (ScopeName != null);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getScopeName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 356,
   FQN="clang::AttributeList::getScopeName", NM="_ZNK5clang13AttributeList12getScopeNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList12getScopeNameEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getScopeName() /*const*/ {
    return ScopeName;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getScopeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 357,
   FQN="clang::AttributeList::getScopeLoc", NM="_ZNK5clang13AttributeList11getScopeLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList11getScopeLocEv")
  //</editor-fold>
  public SourceLocation getScopeLoc() /*const*/ {
    return new SourceLocation(ScopeLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::hasParsedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 359,
   FQN="clang::AttributeList::hasParsedType", NM="_ZNK5clang13AttributeList13hasParsedTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList13hasParsedTypeEv")
  //</editor-fold>
  public boolean hasParsedType() /*const*/ {
    return HasParsedType;
  }

  
  /// Is this the Microsoft __declspec(property) attribute?
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::isDeclspecPropertyAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 362,
   FQN="clang::AttributeList::isDeclspecPropertyAttribute", NM="_ZNK5clang13AttributeList27isDeclspecPropertyAttributeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList27isDeclspecPropertyAttributeEv")
  //</editor-fold>
  public boolean isDeclspecPropertyAttribute() /*const*/ {
    return IsProperty;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::isAlignasAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 366,
   FQN="clang::AttributeList::isAlignasAttribute", NM="_ZNK5clang13AttributeList18isAlignasAttributeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList18isAlignasAttributeEv")
  //</editor-fold>
  public boolean isAlignasAttribute() /*const*/ {
    // FIXME: Use a better mechanism to determine this.
    return getKind() == Kind.AT_Aligned && isKeywordAttribute();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::isDeclspecAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 371,
   FQN="clang::AttributeList::isDeclspecAttribute", NM="_ZNK5clang13AttributeList19isDeclspecAttributeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList19isDeclspecAttributeEv")
  //</editor-fold>
  public boolean isDeclspecAttribute() /*const*/ {
    return SyntaxUsed == $int2uint_3bits(Syntax.AS_Declspec.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::isCXX11Attribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 372,
   FQN="clang::AttributeList::isCXX11Attribute", NM="_ZNK5clang13AttributeList16isCXX11AttributeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList16isCXX11AttributeEv")
  //</editor-fold>
  public boolean isCXX11Attribute() /*const*/ {
    return SyntaxUsed == $int2uint_3bits(Syntax.AS_CXX11.getValue()) || isAlignasAttribute();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::isKeywordAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 375,
   FQN="clang::AttributeList::isKeywordAttribute", NM="_ZNK5clang13AttributeList18isKeywordAttributeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList18isKeywordAttributeEv")
  //</editor-fold>
  public boolean isKeywordAttribute() /*const*/ {
    return SyntaxUsed == $int2uint_3bits(Syntax.AS_Keyword.getValue()) || SyntaxUsed == $int2uint_3bits(Syntax.AS_ContextSensitiveKeyword.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::isContextSensitiveKeywordAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 379,
   FQN="clang::AttributeList::isContextSensitiveKeywordAttribute", NM="_ZNK5clang13AttributeList34isContextSensitiveKeywordAttributeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList34isContextSensitiveKeywordAttributeEv")
  //</editor-fold>
  public boolean isContextSensitiveKeywordAttribute() /*const*/ {
    return SyntaxUsed == $int2uint_3bits(Syntax.AS_ContextSensitiveKeyword.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::isInvalid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 383,
   FQN="clang::AttributeList::isInvalid", NM="_ZNK5clang13AttributeList9isInvalidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList9isInvalidEv")
  //</editor-fold>
  public boolean isInvalid() /*const*/ {
    return Invalid;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::setInvalid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 384,
   FQN="clang::AttributeList::setInvalid", NM="_ZNK5clang13AttributeList10setInvalidEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList10setInvalidEb")
  //</editor-fold>
  public void setInvalid() /*const*/ {
    setInvalid(true);
  }
  public void setInvalid(boolean b/*= true*/) /*const*/ {
    Invalid = b;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::hasProcessingCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 386,
   FQN="clang::AttributeList::hasProcessingCache", NM="_ZNK5clang13AttributeList18hasProcessingCacheEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList18hasProcessingCacheEv")
  //</editor-fold>
  public boolean hasProcessingCache() /*const*/ {
    return HasProcessingCache;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getProcessingCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 387,
   FQN="clang::AttributeList::getProcessingCache", NM="_ZNK5clang13AttributeList18getProcessingCacheEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList18getProcessingCacheEv")
  //</editor-fold>
  public /*uint*/int getProcessingCache() /*const*/ {
    assert (hasProcessingCache());
    return $8bits_uint2uint(ProcessingCache);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::setProcessingCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 391,
   FQN="clang::AttributeList::setProcessingCache", NM="_ZNK5clang13AttributeList18setProcessingCacheEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList18setProcessingCacheEj")
  //</editor-fold>
  public void setProcessingCache(/*uint*/int value) /*const*/ {
    ProcessingCache = $uint2uint_8bits(value);
    HasProcessingCache = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::isUsedAsTypeAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 396,
   FQN="clang::AttributeList::isUsedAsTypeAttr", NM="_ZNK5clang13AttributeList16isUsedAsTypeAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList16isUsedAsTypeAttrEv")
  //</editor-fold>
  public boolean isUsedAsTypeAttr() /*const*/ {
    return UsedAsTypeAttr;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::setUsedAsTypeAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 397,
   FQN="clang::AttributeList::setUsedAsTypeAttr", NM="_ZN5clang13AttributeList17setUsedAsTypeAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributeList17setUsedAsTypeAttrEv")
  //</editor-fold>
  public void setUsedAsTypeAttr() {
    UsedAsTypeAttr = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::isPackExpansion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 399,
   FQN="clang::AttributeList::isPackExpansion", NM="_ZNK5clang13AttributeList15isPackExpansionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList15isPackExpansionEv")
  //</editor-fold>
  public boolean isPackExpansion() /*const*/ {
    return EllipsisLoc.isValid();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getEllipsisLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 400,
   FQN="clang::AttributeList::getEllipsisLoc", NM="_ZNK5clang13AttributeList14getEllipsisLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList14getEllipsisLocEv")
  //</editor-fold>
  public SourceLocation getEllipsisLoc() /*const*/ {
    return new SourceLocation(EllipsisLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 402,
   FQN="clang::AttributeList::getKind", NM="_ZNK5clang13AttributeList7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList7getKindEv")
  //</editor-fold>
  public Kind getKind() /*const*/ {
    return Kind.valueOf(AttrKind);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp", line = 125,
   FQN="clang::AttributeList::getKind", NM="_ZN5clang13AttributeList7getKindEPKNS_14IdentifierInfoES3_NS0_6SyntaxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributeList7getKindEPKNS_14IdentifierInfoES3_NS0_6SyntaxE")
  //</editor-fold>
  public static AttributeList.Kind getKind(/*const*/ IdentifierInfo /*P*/ Name, 
         /*const*/ IdentifierInfo /*P*/ ScopeName, 
         Syntax SyntaxUsed) {
    StringRef AttrName = Name.getName();
    
    SmallString/*64*/ FullName/*J*/= new SmallString/*64*/(64);
    if ((ScopeName != null)) {
      FullName.$addassign(ScopeName.getName());
    }
    
    AttrName.$assignMove(normalizeAttrName(new StringRef(AttrName), FullName.$StringRef(), SyntaxUsed));
    
    // Ensure that in the case of C++11 attributes, we look for '::foo' if it is
    // unscoped.
    if ((ScopeName != null) || SyntaxUsed == Syntax.AS_CXX11) {
      FullName.$addassign(/*STRINGREF_STR*/"::");
    }
    FullName.$addassign(/*NO_COPY*/AttrName);
    
    return /*::*/getAttrKind(FullName.$StringRef(), SyntaxUsed);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getNext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 406,
   FQN="clang::AttributeList::getNext", NM="_ZNK5clang13AttributeList7getNextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList7getNextEv")
  //</editor-fold>
  public AttributeList /*P*/ getNext() /*const*/ {
    return NextInPosition;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::setNext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 407,
   FQN="clang::AttributeList::setNext", NM="_ZN5clang13AttributeList7setNextEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributeList7setNextEPS0_")
  //</editor-fold>
  public void setNext(AttributeList /*P*/ N) {
    NextInPosition = N;
  }

  
  /// getNumArgs - Return the number of actual arguments to this attribute.
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getNumArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 410,
   FQN="clang::AttributeList::getNumArgs", NM="_ZNK5clang13AttributeList10getNumArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList10getNumArgsEv")
  //</editor-fold>
  public /*uint*/int getNumArgs() /*const*/ {
    return NumArgs;
  }

  
  /// getArg - Return the specified argument.
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 413,
   FQN="clang::AttributeList::getArg", NM="_ZNK5clang13AttributeList6getArgEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList6getArgEj")
  //</editor-fold>
  public PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ > getArg(/*uint*/int Arg) /*const*/ {
    assert ($less_uint(Arg, NumArgs)) : "Arg access out of range!";
    return new PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >(getArgsBuffer$Const().$at(Arg));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::isArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 418,
   FQN="clang::AttributeList::isArgExpr", NM="_ZNK5clang13AttributeList9isArgExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList9isArgExprEj")
  //</editor-fold>
  public boolean isArgExpr(/*uint*/int Arg) /*const*/ {
    return $less_uint(Arg, NumArgs) && (getArg(Arg).is(Expr /*P*/ .class) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getArgAsExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 421,
   FQN="clang::AttributeList::getArgAsExpr", NM="_ZNK5clang13AttributeList12getArgAsExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList12getArgAsExprEj")
  //</editor-fold>
  public Expr /*P*/ getArgAsExpr(/*uint*/int Arg) /*const*/ {
    return getArg(Arg).get(Expr /*P*/ .class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::isArgIdent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 425,
   FQN="clang::AttributeList::isArgIdent", NM="_ZNK5clang13AttributeList10isArgIdentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList10isArgIdentEj")
  //</editor-fold>
  public boolean isArgIdent(/*uint*/int Arg) /*const*/ {
    return $less_uint(Arg, NumArgs) && (getArg(Arg).is(IdentifierLoc /*P*/ .class) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getArgAsIdent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 428,
   FQN="clang::AttributeList::getArgAsIdent", NM="_ZNK5clang13AttributeList13getArgAsIdentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList13getArgAsIdentEj")
  //</editor-fold>
  public IdentifierLoc /*P*/ getArgAsIdent(/*uint*/int Arg) /*const*/ {
    return getArg(Arg).get(IdentifierLoc /*P*/ .class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getAvailabilityIntroduced">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 432,
   FQN="clang::AttributeList::getAvailabilityIntroduced", NM="_ZNK5clang13AttributeList25getAvailabilityIntroducedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList25getAvailabilityIntroducedEv")
  //</editor-fold>
  public /*const*/ AvailabilityChange /*&*/ getAvailabilityIntroduced() /*const*/ {
    assert (getKind() == Kind.AT_Availability) : "Not an availability attribute";
    return getAvailabilityData$Const().Changes[AvailabilitySlot.IntroducedSlot.getValue()];
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getAvailabilityDeprecated">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 437,
   FQN="clang::AttributeList::getAvailabilityDeprecated", NM="_ZNK5clang13AttributeList25getAvailabilityDeprecatedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList25getAvailabilityDeprecatedEv")
  //</editor-fold>
  public /*const*/ AvailabilityChange /*&*/ getAvailabilityDeprecated() /*const*/ {
    assert (getKind() == Kind.AT_Availability) : "Not an availability attribute";
    return getAvailabilityData$Const().Changes[AvailabilitySlot.DeprecatedSlot.getValue()];
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getAvailabilityObsoleted">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 442,
   FQN="clang::AttributeList::getAvailabilityObsoleted", NM="_ZNK5clang13AttributeList24getAvailabilityObsoletedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList24getAvailabilityObsoletedEv")
  //</editor-fold>
  public /*const*/ AvailabilityChange /*&*/ getAvailabilityObsoleted() /*const*/ {
    assert (getKind() == Kind.AT_Availability) : "Not an availability attribute";
    return getAvailabilityData$Const().Changes[AvailabilitySlot.ObsoletedSlot.getValue()];
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getStrictLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 447,
   FQN="clang::AttributeList::getStrictLoc", NM="_ZNK5clang13AttributeList12getStrictLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList12getStrictLocEv")
  //</editor-fold>
  public SourceLocation getStrictLoc() /*const*/ {
    assert (getKind() == Kind.AT_Availability) : "Not an availability attribute";
    return new SourceLocation(getAvailabilityData$Const().StrictLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getUnavailableLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 452,
   FQN="clang::AttributeList::getUnavailableLoc", NM="_ZNK5clang13AttributeList17getUnavailableLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList17getUnavailableLocEv")
  //</editor-fold>
  public SourceLocation getUnavailableLoc() /*const*/ {
    assert (getKind() == Kind.AT_Availability) : "Not an availability attribute";
    return new SourceLocation(UnavailableLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getMessageExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 457,
   FQN="clang::AttributeList::getMessageExpr", NM="_ZNK5clang13AttributeList14getMessageExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList14getMessageExprEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getMessageExpr() /*const*/ {
    assert (getKind() == Kind.AT_Availability) : "Not an availability attribute";
    return MessageExpr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getReplacementExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 462,
   FQN="clang::AttributeList::getReplacementExpr", NM="_ZNK5clang13AttributeList18getReplacementExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList18getReplacementExprEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getReplacementExpr() /*const*/ {
    assert (getKind() == Kind.AT_Availability) : "Not an availability attribute";
    return getAvailabilityData$Const().Replacement;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getMatchingCType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 467,
   FQN="clang::AttributeList::getMatchingCType", NM="_ZNK5clang13AttributeList16getMatchingCTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList16getMatchingCTypeEv")
  //</editor-fold>
  public /*const*/ OpaquePtr<QualType> /*&*/ getMatchingCType() /*const*/ {
    assert (getKind() == Kind.AT_TypeTagForDatatype) : "Not a type_tag_for_datatype attribute";
    return $Deref(getTypeTagForDatatypeDataSlot$Const().MatchingCType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getLayoutCompatible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 473,
   FQN="clang::AttributeList::getLayoutCompatible", NM="_ZNK5clang13AttributeList19getLayoutCompatibleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList19getLayoutCompatibleEv")
  //</editor-fold>
  public boolean getLayoutCompatible() /*const*/ {
    assert (getKind() == Kind.AT_TypeTagForDatatype) : "Not a type_tag_for_datatype attribute";
    return getTypeTagForDatatypeDataSlot$Const().LayoutCompatible;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getMustBeNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 479,
   FQN="clang::AttributeList::getMustBeNull", NM="_ZNK5clang13AttributeList13getMustBeNullEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList13getMustBeNullEv")
  //</editor-fold>
  public boolean getMustBeNull() /*const*/ {
    assert (getKind() == Kind.AT_TypeTagForDatatype) : "Not a type_tag_for_datatype attribute";
    return getTypeTagForDatatypeDataSlot$Const().MustBeNull;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getTypeArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 485,
   FQN="clang::AttributeList::getTypeArg", NM="_ZNK5clang13AttributeList10getTypeArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList10getTypeArgEv")
  //</editor-fold>
  public /*const*/ OpaquePtr<QualType> /*&*/ getTypeArg() /*const*/ {
    assert (HasParsedType) : "Not a type attribute";
    return getTypeBuffer$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getPropertyData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 490,
   FQN="clang::AttributeList::getPropertyData", NM="_ZNK5clang13AttributeList15getPropertyDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList15getPropertyDataEv")
  //</editor-fold>
  public /*const*/ PropertyData /*&*/ getPropertyData() /*const*/ {
    assert (isDeclspecPropertyAttribute()) : "Not a __delcspec(property) attribute";
    return getPropertyDataBuffer$Const();
  }

  
  /// \brief Get an index into the attribute spelling list
  /// defined in Attr.td. This index is used by an attribute
  /// to pretty print itself.
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getAttributeSpellingListIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp", line = 145,
   FQN="clang::AttributeList::getAttributeSpellingListIndex", NM="_ZNK5clang13AttributeList29getAttributeSpellingListIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList29getAttributeSpellingListIndexEv")
  //</editor-fold>
  public /*uint*/int getAttributeSpellingListIndex() /*const*/ {
    // Both variables will be used in tablegen generated
    // attribute spell list index matching code.
    StringRef Scope = (ScopeName != null) ? ScopeName.getName() : new StringRef(/*KEEP_STR*/$EMPTY);
    StringRef Name = normalizeAttrName(AttrName.getName(), new StringRef(Scope), 
        AttributeList.Syntax.valueOf(SyntaxUsed));
    /*===- TableGen'erated file -------------------------------------*- C++ -*-===*\
    |*                                                                            *|
    |* Code to translate different attribute spellings into internal identifiers  *|
    |*                                                                            *|
    |* Automatically generated file, do not edit!                                 *|
    |*                                                                            *|
    \*===----------------------------------------------------------------------===*/
    switch (Kind.valueOf(AttrKind)) {
     case AT_AMDGPUNumSGPR:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"amdgpu_num_sgpr") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_AMDGPUNumVGPR:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"amdgpu_num_vgpr") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_Interrupt:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"interrupt") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_AbiTag:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"abi_tag") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"abi_tag") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_AcquireCapability:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"acquire_capability") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"acquire_capability") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"clang")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"acquire_shared_capability") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 2;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"acquire_shared_capability") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"clang")) {
          return 3;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"exclusive_lock_function") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 4;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"shared_lock_function") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 5;
        }
        break;
      }
     case AT_AcquiredAfter:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"acquired_after") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_AcquiredBefore:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"acquired_before") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_AddressSpace:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"address_space") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_Alias:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"alias") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"alias") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_AlignValue:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"align_value") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_Aligned:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"aligned") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"aligned") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"align") && SyntaxUsed == $int2uint_3bits(2) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 2;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"alignas") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 3;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"_Alignas") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 4;
        }
        break;
      }
     case AT_AlwaysInline:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"always_inline") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"always_inline") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"__forceinline") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 2;
        }
        break;
      }
     case AT_AnalyzerNoReturn:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"analyzer_noreturn") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_Annotate:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"annotate") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_ArcWeakrefUnavailable:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"objc_arc_weak_reference_unavailable") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_ArgumentWithTypeTag:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"argument_with_type_tag") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"pointer_with_type_tag") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 1;
        }
        break;
      }
     case AT_AssertCapability:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"assert_capability") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"assert_capability") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"clang")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"assert_shared_capability") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 2;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"assert_shared_capability") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"clang")) {
          return 3;
        }
        break;
      }
     case AT_AssertExclusiveLock:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"assert_exclusive_lock") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_AssertSharedLock:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"assert_shared_lock") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_AssumeAligned:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"assume_aligned") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"assume_aligned") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_Availability:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"availability") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_Blocks:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"blocks") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_CDecl:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"cdecl") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"cdecl") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"__cdecl") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 2;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"_cdecl") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 3;
        }
        break;
      }
     case AT_CFAuditedTransfer:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"cf_audited_transfer") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_CFConsumed:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"cf_consumed") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_CFReturnsNotRetained:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"cf_returns_not_retained") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_CFReturnsRetained:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"cf_returns_retained") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_CFUnknownTransfer:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"cf_unknown_transfer") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_CUDAConstant:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"constant") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_CUDADevice:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"device") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_CUDAGlobal:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"global") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_CUDAHost:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"host") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_CUDAInvalidTarget:
      {
        break;
      }
     case AT_CUDALaunchBounds:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"launch_bounds") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_CUDAShared:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"shared") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_CXX11NoReturn:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"noreturn") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_CallableWhen:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"callable_when") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_Capability:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"capability") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"capability") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"clang")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"shared_capability") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 2;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"shared_capability") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"clang")) {
          return 3;
        }
        break;
      }
     case AT_CarriesDependency:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"carries_dependency") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"carries_dependency") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 1;
        }
        break;
      }
     case AT_Cleanup:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"cleanup") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"cleanup") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_Cold:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"cold") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"cold") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_Common:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"common") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"common") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_Const:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"const") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"const") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"__const") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 2;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"__const") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 3;
        }
        break;
      }
     case AT_Constructor:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"constructor") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"constructor") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_Consumable:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"consumable") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_ConsumableAutoCast:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"consumable_auto_cast_state") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_ConsumableSetOnRead:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"consumable_set_state_on_read") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_DLLExport:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"dllexport") && SyntaxUsed == $int2uint_3bits(2) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"dllexport") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"dllexport") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 2;
        }
        break;
      }
     case AT_DLLImport:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"dllimport") && SyntaxUsed == $int2uint_3bits(2) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"dllimport") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"dllimport") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 2;
        }
        break;
      }
     case AT_Deprecated:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"deprecated") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"deprecated") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"deprecated") && SyntaxUsed == $int2uint_3bits(2) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 2;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"deprecated") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 3;
        }
        break;
      }
     case AT_Destructor:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"destructor") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"destructor") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_DisableTailCalls:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"disable_tail_calls") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"disable_tail_calls") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"clang")) {
          return 1;
        }
        break;
      }
     case AT_EmptyBases:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"empty_bases") && SyntaxUsed == $int2uint_3bits(2) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_EnableIf:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"enable_if") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_ExclusiveTrylockFunction:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"exclusive_trylock_function") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_ExtVectorType:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"ext_vector_type") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_FallThrough:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"fallthrough") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"fallthrough") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"clang")) {
          return 1;
        }
        break;
      }
     case AT_FastCall:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"fastcall") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"fastcall") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"__fastcall") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 2;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"_fastcall") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 3;
        }
        break;
      }
     case AT_FlagEnum:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"flag_enum") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_Flatten:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"flatten") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"flatten") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_Format:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"format") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"format") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_FormatArg:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"format_arg") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"format_arg") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_GNUInline:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"gnu_inline") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"gnu_inline") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_GuardedBy:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"guarded_by") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_GuardedVar:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"guarded_var") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_Hot:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"hot") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"hot") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_IBAction:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"ibaction") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_IBOutlet:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"iboutlet") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_IBOutletCollection:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"iboutletcollection") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_IFunc:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"ifunc") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"ifunc") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_InitPriority:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"init_priority") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_IntelOclBicc:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"intel_ocl_bicc") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_InternalLinkage:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"internal_linkage") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"internal_linkage") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"clang")) {
          return 1;
        }
        break;
      }
     case AT_LTOVisibilityPublic:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"lto_visibility_public") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"clang")) {
          return 0;
        }
        break;
      }
     case AT_LayoutVersion:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"layout_version") && SyntaxUsed == $int2uint_3bits(2) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_LockReturned:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"lock_returned") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_Lockable:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"lockable") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_LocksExcluded:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"locks_excluded") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_LoopHint:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"loop") && SyntaxUsed == $int2uint_3bits(4) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"clang")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"unroll") && SyntaxUsed == $int2uint_3bits(4) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"nounroll") && SyntaxUsed == $int2uint_3bits(4) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 2;
        }
        break;
      }
     case AT_MSABI:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"ms_abi") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"ms_abi") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_MSInheritance:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"__single_inheritance") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"__multiple_inheritance") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"__virtual_inheritance") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 2;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"__unspecified_inheritance") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 3;
        }
        break;
      }
     case AT_MSNoVTable:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"novtable") && SyntaxUsed == $int2uint_3bits(2) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_MSStruct:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"ms_struct") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"ms_struct") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_MayAlias:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"may_alias") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"may_alias") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_MinSize:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"minsize") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_Mips16:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"mips16") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"mips16") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_Mode:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"mode") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"mode") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_NSConsumed:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"ns_consumed") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_NSConsumesSelf:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"ns_consumes_self") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_NSReturnsAutoreleased:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"ns_returns_autoreleased") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_NSReturnsNotRetained:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"ns_returns_not_retained") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_NSReturnsRetained:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"ns_returns_retained") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_Naked:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"naked") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"naked") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"naked") && SyntaxUsed == $int2uint_3bits(2) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 2;
        }
        break;
      }
     case AT_NeonPolyVectorType:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"neon_polyvector_type") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_NeonVectorType:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"neon_vector_type") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_NoAlias:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"noalias") && SyntaxUsed == $int2uint_3bits(2) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_NoCommon:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"nocommon") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"nocommon") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_NoDebug:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"nodebug") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"nodebug") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_NoDuplicate:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"noduplicate") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"noduplicate") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"clang")) {
          return 1;
        }
        break;
      }
     case AT_NoInline:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"noinline") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"noinline") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"noinline") && SyntaxUsed == $int2uint_3bits(2) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 2;
        }
        break;
      }
     case AT_NoInstrumentFunction:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"no_instrument_function") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"no_instrument_function") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_NoMips16:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"nomips16") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"nomips16") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_NoReturn:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"noreturn") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"noreturn") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"noreturn") && SyntaxUsed == $int2uint_3bits(2) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 2;
        }
        break;
      }
     case AT_NoSanitize:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"no_sanitize") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"no_sanitize") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"clang")) {
          return 1;
        }
        break;
      }
     case AT_NoSanitizeSpecific:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"no_address_safety_analysis") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"no_address_safety_analysis") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"no_sanitize_address") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 2;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"no_sanitize_address") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 3;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"no_sanitize_thread") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 4;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"no_sanitize_thread") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 5;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"no_sanitize_memory") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 6;
        }
        break;
      }
     case AT_NoSplitStack:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"no_split_stack") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"no_split_stack") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_NoThreadSafetyAnalysis:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"no_thread_safety_analysis") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_NoThrow:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"nothrow") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"nothrow") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"nothrow") && SyntaxUsed == $int2uint_3bits(2) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 2;
        }
        break;
      }
     case AT_NonNull:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"nonnull") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"nonnull") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_NotTailCalled:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"not_tail_called") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"not_tail_called") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"clang")) {
          return 1;
        }
        break;
      }
     case AT_ObjCBoxable:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"objc_boxable") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_ObjCBridge:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"objc_bridge") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_ObjCBridgeMutable:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"objc_bridge_mutable") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_ObjCBridgeRelated:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"objc_bridge_related") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_ObjCDesignatedInitializer:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"objc_designated_initializer") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_ObjCException:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"objc_exception") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_ObjCExplicitProtocolImpl:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"objc_protocol_requires_explicit_implementation") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_ObjCGC:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"objc_gc") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_ObjCIndependentClass:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"objc_independent_class") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_ObjCKindOf:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"__kindof") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_ObjCMethodFamily:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"objc_method_family") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_ObjCNSObject:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"NSObject") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_ObjCOwnership:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"objc_ownership") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_ObjCPreciseLifetime:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"objc_precise_lifetime") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_ObjCRequiresPropertyDefs:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"objc_requires_property_definitions") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_ObjCRequiresSuper:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"objc_requires_super") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_ObjCReturnsInnerPointer:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"objc_returns_inner_pointer") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_ObjCRootClass:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"objc_root_class") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_ObjCRuntimeName:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"objc_runtime_name") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_ObjCRuntimeVisible:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"objc_runtime_visible") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_OpenCLAccess:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"__read_only") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"read_only") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"__write_only") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 2;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"write_only") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 3;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"__read_write") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 4;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"read_write") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 5;
        }
        break;
      }
     case AT_OpenCLConstantAddressSpace:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"__constant") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"constant") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 1;
        }
        break;
      }
     case AT_OpenCLGenericAddressSpace:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"__generic") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"generic") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 1;
        }
        break;
      }
     case AT_OpenCLGlobalAddressSpace:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"__global") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"global") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 1;
        }
        break;
      }
     case AT_OpenCLKernel:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"__kernel") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"kernel") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 1;
        }
        break;
      }
     case AT_OpenCLLocalAddressSpace:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"__local") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"local") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 1;
        }
        break;
      }
     case AT_OpenCLNoSVM:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"nosvm") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_OpenCLPrivateAddressSpace:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"__private") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"private") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 1;
        }
        break;
      }
     case AT_OpenCLUnrollHint:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"opencl_unroll_hint") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_OptimizeNone:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"optnone") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"optnone") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"clang")) {
          return 1;
        }
        break;
      }
     case AT_Overloadable:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"overloadable") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_Ownership:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"ownership_holds") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"ownership_returns") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"ownership_takes") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 2;
        }
        break;
      }
     case AT_Packed:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"packed") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"packed") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_ParamTypestate:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"param_typestate") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_Pascal:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"pascal") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"__pascal") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"_pascal") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 2;
        }
        break;
      }
     case AT_PassObjectSize:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"pass_object_size") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_Pcs:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"pcs") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"pcs") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_PreserveAll:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"preserve_all") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_PreserveMost:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"preserve_most") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_PtGuardedBy:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"pt_guarded_by") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_PtGuardedVar:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"pt_guarded_var") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_Ptr32:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"__ptr32") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_Ptr64:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"__ptr64") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_Pure:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"pure") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"pure") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_Regparm:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"regparm") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"regparm") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_ReleaseCapability:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"release_capability") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"release_capability") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"clang")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"release_shared_capability") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 2;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"release_shared_capability") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"clang")) {
          return 3;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"release_generic_capability") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 4;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"release_generic_capability") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"clang")) {
          return 5;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"unlock_function") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 6;
        }
        break;
      }
     case AT_RenderScriptKernel:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"kernel") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_ReqdWorkGroupSize:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"reqd_work_group_size") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_RequiresCapability:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"requires_capability") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"requires_capability") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"clang")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"exclusive_locks_required") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 2;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"requires_shared_capability") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 3;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"requires_shared_capability") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"clang")) {
          return 4;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"shared_locks_required") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 5;
        }
        break;
      }
     case AT_Restrict:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"restrict") && SyntaxUsed == $int2uint_3bits(2) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"malloc") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"malloc") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 2;
        }
        break;
      }
     case AT_ReturnTypestate:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"return_typestate") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_ReturnsNonNull:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"returns_nonnull") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"returns_nonnull") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_ReturnsTwice:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"returns_twice") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"returns_twice") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_SPtr:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"__sptr") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_ScopedLockable:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"scoped_lockable") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_Section:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"section") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"section") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"allocate") && SyntaxUsed == $int2uint_3bits(2) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 2;
        }
        break;
      }
     case AT_SelectAny:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"selectany") && SyntaxUsed == $int2uint_3bits(2) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_Sentinel:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sentinel") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sentinel") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_SetTypestate:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"set_typestate") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_SharedTrylockFunction:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"shared_trylock_function") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_StdCall:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"stdcall") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"stdcall") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"__stdcall") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 2;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"_stdcall") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 3;
        }
        break;
      }
     case AT_SwiftCall:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"swiftcall") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"swiftcall") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_SwiftContext:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"swift_context") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"swift_context") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_SwiftErrorResult:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"swift_error_result") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"swift_error_result") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_SwiftIndirectResult:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"swift_indirect_result") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"swift_indirect_result") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_SysVABI:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sysv_abi") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sysv_abi") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_TLSModel:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"tls_model") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"tls_model") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_Target:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"target") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"target") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_TestTypestate:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"test_typestate") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_ThisCall:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"thiscall") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"thiscall") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"__thiscall") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 2;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"_thiscall") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 3;
        }
        break;
      }
     case AT_Thread:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"thread") && SyntaxUsed == $int2uint_3bits(2) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_TransparentUnion:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"transparent_union") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"transparent_union") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_TryAcquireCapability:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"try_acquire_capability") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"try_acquire_capability") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"clang")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"try_acquire_shared_capability") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 2;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"try_acquire_shared_capability") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"clang")) {
          return 3;
        }
        break;
      }
     case AT_TypeNonNull:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"_Nonnull") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_TypeNullUnspecified:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"_Null_unspecified") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_TypeNullable:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"_Nullable") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_TypeTagForDatatype:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"type_tag_for_datatype") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_TypeVisibility:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"type_visibility") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"type_visibility") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"clang")) {
          return 1;
        }
        break;
      }
     case AT_UPtr:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"__uptr") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_Unavailable:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"unavailable") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_Unused:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"maybe_unused") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"unused") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"unused") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 2;
        }
        break;
      }
     case AT_Used:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"used") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"used") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_Uuid:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"uuid") && SyntaxUsed == $int2uint_3bits(2) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_VecReturn:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"vecreturn") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_VecTypeHint:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"vec_type_hint") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_VectorCall:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"vectorcall") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"__vectorcall") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"_vectorcall") && SyntaxUsed == $int2uint_3bits(3) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 2;
        }
        break;
      }
     case AT_VectorSize:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"vector_size") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"vector_size") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_Visibility:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"visibility") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"visibility") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_WarnUnused:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"warn_unused") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_WarnUnusedResult:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"nodiscard") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"warn_unused_result") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"clang")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"warn_unused_result") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 2;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"warn_unused_result") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 3;
        }
        break;
      }
     case AT_Weak:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"weak") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"weak") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_WeakImport:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"weak_import") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_WeakRef:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"weakref") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"weakref") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"gnu")) {
          return 1;
        }
        break;
      }
     case AT_WorkGroupSizeHint:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"work_group_size_hint") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_X86ForceAlignArgPointer:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"force_align_arg_pointer") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        break;
      }
     case AT_XRayInstrument:
      {
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"xray_always_instrument") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 0;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"xray_always_instrument") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"clang")) {
          return 1;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"xray_never_instrument") && SyntaxUsed == $int2uint_3bits(0) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"")) {
          return 2;
        }
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"xray_never_instrument") && SyntaxUsed == $int2uint_3bits(1) && $eq_StringRef(/*NO_COPY*/Scope, /*STRINGREF_STR*/"clang")) {
          return 3;
        }
        break;
      }
    }
    return 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::isTargetSpecificAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp", line = 200,
   FQN="clang::AttributeList::isTargetSpecificAttr", NM="_ZNK5clang13AttributeList20isTargetSpecificAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList20isTargetSpecificAttrEv")
  //</editor-fold>
  public boolean isTargetSpecificAttr() /*const*/ {
    return getInfo(/*Deref*/this).IsTargetSpecific;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::isTypeAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp", line = 204,
   FQN="clang::AttributeList::isTypeAttr", NM="_ZNK5clang13AttributeList10isTypeAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList10isTypeAttrEv")
  //</editor-fold>
  public boolean isTypeAttr() /*const*/ {
    return getInfo(/*Deref*/this).IsType;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::isStmtAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp", line = 208,
   FQN="clang::AttributeList::isStmtAttr", NM="_ZNK5clang13AttributeList10isStmtAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList10isStmtAttrEv")
  //</editor-fold>
  public boolean isStmtAttr() /*const*/ {
    return getInfo(/*Deref*/this).IsStmt;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::hasCustomParsing">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp", line = 188,
   FQN="clang::AttributeList::hasCustomParsing", NM="_ZNK5clang13AttributeList16hasCustomParsingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList16hasCustomParsingEv")
  //</editor-fold>
  public boolean hasCustomParsing() /*const*/ {
    return getInfo(/*Deref*/this).HasCustomParsing;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getMinArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp", line = 180,
   FQN="clang::AttributeList::getMinArgs", NM="_ZNK5clang13AttributeList10getMinArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList10getMinArgsEv")
  //</editor-fold>
  public /*uint*/int getMinArgs() /*const*/ {
    return getInfo(/*Deref*/this).NumArgs;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getMaxArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp", line = 184,
   FQN="clang::AttributeList::getMaxArgs", NM="_ZNK5clang13AttributeList10getMaxArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList10getMaxArgsEv")
  //</editor-fold>
  public /*uint*/int getMaxArgs() /*const*/ {
    return getMinArgs() + getInfo(/*Deref*/this).OptArgs;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::hasVariadicArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp", line = 224,
   FQN="clang::AttributeList::hasVariadicArg", NM="_ZNK5clang13AttributeList14hasVariadicArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList14hasVariadicArgEv")
  //</editor-fold>
  public boolean hasVariadicArg() /*const*/ {
    // If the attribute has the maximum number of optional arguments, we will
    // claim that as being variadic. If we someday get an attribute that
    // legitimately bumps up against that maximum, we can use another bit to track
    // whether it's truly variadic or not.
    return getInfo(/*Deref*/this).OptArgs == $int2uint_4bits(15);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::diagnoseAppertainsTo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp", line = 192,
   FQN="clang::AttributeList::diagnoseAppertainsTo", NM="_ZNK5clang13AttributeList20diagnoseAppertainsToERNS_4SemaEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList20diagnoseAppertainsToERNS_4SemaEPKNS_4DeclE")
  //</editor-fold>
  public boolean diagnoseAppertainsTo(final Sema /*&*/ S, /*const*/ Decl /*P*/ D) /*const*/ {
    return getInfo(/*Deref*/this).DiagAppertainsToDecl.$call(S, /*Deref*/this, D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::diagnoseLangOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp", line = 196,
   FQN="clang::AttributeList::diagnoseLangOpts", NM="_ZNK5clang13AttributeList16diagnoseLangOptsERNS_4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList16diagnoseLangOptsERNS_4SemaE")
  //</editor-fold>
  public boolean diagnoseLangOpts(final Sema /*&*/ S) /*const*/ {
    return getInfo(/*Deref*/this).DiagLangOpts.$call(S, /*Deref*/this);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::existsInTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp", line = 212,
   FQN="clang::AttributeList::existsInTarget", NM="_ZNK5clang13AttributeList14existsInTargetERKNS_10TargetInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList14existsInTargetERKNS_10TargetInfoE")
  //</editor-fold>
  public boolean existsInTarget(final /*const*/ TargetInfo /*&*/ Target) /*const*/ {
    return getInfo(/*Deref*/this).ExistsInTarget.$call(Target);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::isKnownToGCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp", line = 216,
   FQN="clang::AttributeList::isKnownToGCC", NM="_ZNK5clang13AttributeList12isKnownToGCCEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList12isKnownToGCCEv")
  //</editor-fold>
  public boolean isKnownToGCC() /*const*/ {
    return getInfo(/*Deref*/this).IsKnownToGCC;
  }

  
  /// \brief If the parsed attribute has a semantic equivalent, and it would
  /// have a semantic Spelling enumeration (due to having semantically-distinct
  /// spelling variations), return the value of that semantic spelling. If the
  /// parsed attribute does not have a semantic equivalent, or would not have
  /// a Spelling enumeration, the value UINT_MAX is returned.
  //<editor-fold defaultstate="collapsed" desc="clang::AttributeList::getSemanticSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp", line = 220,
   FQN="clang::AttributeList::getSemanticSpelling", NM="_ZNK5clang13AttributeList19getSemanticSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributeList19getSemanticSpellingEv")
  //</editor-fold>
  public /*uint*/int getSemanticSpelling() /*const*/ {
    return getInfo(/*Deref*/this).SpellingIndexToSemanticSpelling.$call(/*Deref*/this);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  /*this + 1*/ private final Object $this$1;

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "AttrName=" + AttrName // NOI18N
              + ", ScopeName=" + ScopeName // NOI18N
              + ", AttrRange=" + AttrRange // NOI18N
              + ", ScopeLoc=" + ScopeLoc // NOI18N
              + ", EllipsisLoc=" + EllipsisLoc // NOI18N
              + ", AttrKind=" + $ushort2uint(AttrKind) // NOI18N
              + ", NumArgs=" + $ushort2uint(NumArgs) // NOI18N
              + ", SyntaxUsed=" + $uchar2uint(SyntaxUsed) // NOI18N
              + ", Invalid=" + Invalid // NOI18N
              + ", UsedAsTypeAttr=" + UsedAsTypeAttr // NOI18N
              + ", IsAvailability=" + IsAvailability // NOI18N
              + ", IsTypeTagForDatatype=" + IsTypeTagForDatatype // NOI18N
              + ", IsProperty=" + IsProperty // NOI18N
              + ", HasParsedType=" + HasParsedType // NOI18N
              + ", HasProcessingCache=" + HasProcessingCache // NOI18N
              + ", ProcessingCache=" + $uchar2uint(ProcessingCache) // NOI18N
              + ", UnavailableLoc=" + UnavailableLoc // NOI18N
              + ", MessageExpr=" + MessageExpr // NOI18N
              + ", NextInPosition=" + NextInPosition // NOI18N
              + ", NextInPool=" + NextInPool; // NOI18N
  }
}
