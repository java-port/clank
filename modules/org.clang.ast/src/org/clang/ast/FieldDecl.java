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
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

/// FieldDecl - An instance of this class is created by Sema::ActOnField to
/// represent a member of a struct/union/class.
//<editor-fold defaultstate="collapsed" desc="clang::FieldDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2293,
 FQN="clang::FieldDecl", NM="_ZN5clang9FieldDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9FieldDeclE")
//</editor-fold>
public class FieldDecl extends /*public*/ DeclaratorDecl implements /*public*/ Mergeable<FieldDecl>, Destructors.ClassWithDestructor {
  // FIXME: This can be packed into the bitfields in Decl.
  /*friend*/public /*JBIT unsigned int*/ boolean Mutable /*: 1*/;
  private /*mutable *//*uint*/int CachedFieldIndex /*: 31*/;
  
  /// The kinds of value we can store in InitializerOrBitWidth.
  ///
  /// Note that this is compatible with InClassInitStyle except for
  /// ISK_CapturedVLAType.
  //<editor-fold defaultstate="collapsed" desc="clang::FieldDecl::InitStorageKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2302,
   FQN="clang::FieldDecl::InitStorageKind", NM="_ZN5clang9FieldDecl15InitStorageKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9FieldDecl15InitStorageKindE")
  //</editor-fold>
  /*friend*/public enum InitStorageKind implements Native.ComparableLower {
    /// If the pointer is null, there's nothing special.  Otherwise,
    /// this is a bitfield and the pointer is the Expr* storing the
    /// bit-width.
    ISK_BitWidthOrNothing((/*uint*/int)InClassInitStyle.ICIS_NoInit.getValue()),
    
    /// The pointer is an (optional due to delayed parsing) Expr*
    /// holding the copy-initializer.
    ISK_InClassCopyInit((/*uint*/int)InClassInitStyle.ICIS_CopyInit.getValue()),
    
    /// The pointer is an (optional due to delayed parsing) Expr*
    /// holding the list-initializer.
    ISK_InClassListInit((/*uint*/int)InClassInitStyle.ICIS_ListInit.getValue()),
    
    /// The pointer is a VariableArrayType* that's been captured;
    /// the enclosing context is a lambda or captured statement.
    ISK_CapturedVLAType(ISK_InClassListInit.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static InitStorageKind valueOf(int val) {
      InitStorageKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final InitStorageKind[] VALUES;
      private static final InitStorageKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (InitStorageKind kind : InitStorageKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new InitStorageKind[min < 0 ? (1-min) : 0];
        VALUES = new InitStorageKind[max >= 0 ? (1+max) : 0];
        for (InitStorageKind kind : InitStorageKind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private InitStorageKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((InitStorageKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((InitStorageKind)obj).value);}
    //</editor-fold>
  };
  
  /// \brief Storage for either the bit-width, the in-class
  /// initializer, or the captured variable length array bound.
  ///
  /// We can safely combine these because in-class initializers are
  /// not permitted for bit-fields, and both are exclusive with VLA
  /// captures.
  ///
  /// If the storage kind is ISK_InClassCopyInit or
  /// ISK_InClassListInit, but the initializer is null, then this
  /// field has an in-class initializer which has not yet been parsed
  /// and attached.
  /*friend*/public PointerEnum2Pair<Object/*void P*/, InitStorageKind> InitStorage;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::FieldDecl::FieldDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2334,
   FQN="clang::FieldDecl::FieldDecl", NM="_ZN5clang9FieldDeclC1ENS_4Decl4KindEPNS_11DeclContextENS_14SourceLocationES5_PNS_14IdentifierInfoENS_8QualTypeEPNS_14TypeSourceInfoEPNS_4ExprEbNS_16InClassInitStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9FieldDeclC1ENS_4Decl4KindEPNS_11DeclContextENS_14SourceLocationES5_PNS_14IdentifierInfoENS_8QualTypeEPNS_14TypeSourceInfoEPNS_4ExprEbNS_16InClassInitStyleE")
  //</editor-fold>
  protected FieldDecl(Kind DK, DeclContext /*P*/ DC, SourceLocation StartLoc, 
      SourceLocation IdLoc, IdentifierInfo /*P*/ Id, 
      QualType T, TypeSourceInfo /*P*/ TInfo, Expr /*P*/ BW, boolean Mutable, 
      InClassInitStyle InitStyle) {
    // : DeclaratorDecl(DK, DC, IdLoc, Id, T, TInfo, StartLoc), Mergeable<FieldDecl>(), Mutable(Mutable), CachedFieldIndex(0), InitStorage(BW, (InitStorageKind)InitStyle) 
    //START JInit
    super(DK, DC, new SourceLocation(IdLoc), new DeclarationName(Id), new QualType(T), TInfo, new SourceLocation(StartLoc));
    $Mergeable();
    this.Mutable = Mutable;
    this.CachedFieldIndex = 0;
    this.InitStorage = new PointerEnum2Pair<Object/*void P*/, InitStorageKind>(BW, InitStorageKind.valueOf(InitStyle.getValue()));
    //END JInit
    assert ((!(BW != null) || InitStyle == InClassInitStyle.ICIS_NoInit)) : "got initializer for bitfield";
  }

/*public:*/
  
  //===----------------------------------------------------------------------===//
  // FieldDecl Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::FieldDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3443,
   FQN="clang::FieldDecl::Create", NM="_ZN5clang9FieldDecl6CreateERKNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES6_PNS_14IdentifierInfoENS_8QualTypeEPNS_14TypeSourceInfoEPNS_4ExprEbNS_16InClassInitStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9FieldDecl6CreateERKNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES6_PNS_14IdentifierInfoENS_8QualTypeEPNS_14TypeSourceInfoEPNS_4ExprEbNS_16InClassInitStyleE")
  //</editor-fold>
  public static FieldDecl /*P*/ Create(final /*const*/ ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation StartLoc, SourceLocation IdLoc, 
        IdentifierInfo /*P*/ Id, QualType T, 
        TypeSourceInfo /*P*/ TInfo, Expr /*P*/ BW, boolean Mutable, 
        InClassInitStyle InitStyle) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> New$Mem)->{
        return new FieldDecl(Decl.Kind.Field, DC, new SourceLocation(StartLoc), new SourceLocation(IdLoc), Id, new QualType(T), TInfo, 
                BW, Mutable, InitStyle);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FieldDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3452,
   FQN="clang::FieldDecl::CreateDeserialized", NM="_ZN5clang9FieldDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9FieldDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static FieldDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> New$Mem)->{
        return new FieldDecl(Kind.Field, (DeclContext /*P*/ )null, new SourceLocation(), 
                new SourceLocation(), (IdentifierInfo /*P*/ )null, new QualType(), (TypeSourceInfo /*P*/ )null, 
                (Expr /*P*/ )null, false, InClassInitStyle.ICIS_NoInit);
     });
  }

  
  /// getFieldIndex - Returns the index of this field within its record,
  /// as appropriate for passing to ASTRecordLayout::getFieldOffset.
  //<editor-fold defaultstate="collapsed" desc="clang::FieldDecl::getFieldIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3474,
   FQN="clang::FieldDecl::getFieldIndex", NM="_ZNK5clang9FieldDecl13getFieldIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9FieldDecl13getFieldIndexEv")
  //</editor-fold>
  public /*uint*/int getFieldIndex() /*const*/ {
    /*const*/ FieldDecl /*P*/ Canonical = getCanonicalDecl$Const();
    if (Canonical != this) {
      return Canonical.getFieldIndex();
    }
    if ((CachedFieldIndex != 0)) {
      return CachedFieldIndex - $int2uint_31bits(1);
    }
    
    /*uint*/int Index = 0;
    /*const*/ RecordDecl /*P*/ RD = getParent$Const();
    
    for (FieldDecl /*P*/ Field : RD.fields()) {
      Field.getCanonicalDecl().CachedFieldIndex = Index + 1;
      ++Index;
    }
    assert ((CachedFieldIndex != 0)) : "failed to find field in parent";
    return CachedFieldIndex - $int2uint_31bits(1);
  }

  
  /// isMutable - Determines whether this field is mutable (C++ only).
  //<editor-fold defaultstate="collapsed" desc="clang::FieldDecl::isMutable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2358,
   FQN="clang::FieldDecl::isMutable", NM="_ZNK5clang9FieldDecl9isMutableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9FieldDecl9isMutableEv")
  //</editor-fold>
  public boolean isMutable() /*const*/ {
    return Mutable;
  }

  
  /// \brief Determines whether this field is a bitfield.
  //<editor-fold defaultstate="collapsed" desc="clang::FieldDecl::isBitField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2361,
   FQN="clang::FieldDecl::isBitField", NM="_ZNK5clang9FieldDecl10isBitFieldEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9FieldDecl10isBitFieldEv")
  //</editor-fold>
  public boolean isBitField() /*const*/ {
    return InitStorage.getInt() == InitStorageKind.ISK_BitWidthOrNothing
       && $noteq_ptr(InitStorage.getPointer(), null);
  }

  
  /// @brief Determines whether this is an unnamed bitfield.
  //<editor-fold defaultstate="collapsed" desc="clang::FieldDecl::isUnnamedBitfield">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2367,
   FQN="clang::FieldDecl::isUnnamedBitfield", NM="_ZNK5clang9FieldDecl17isUnnamedBitfieldEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9FieldDecl17isUnnamedBitfieldEv")
  //</editor-fold>
  public boolean isUnnamedBitfield() /*const*/ {
    return isBitField() && !getDeclName().$bool();
  }

  
  /// isAnonymousStructOrUnion - Determines whether this field is a
  /// representative for an anonymous struct or union. Such fields are
  /// unnamed and are implicitly generated by the implementation to
  /// store the data for the anonymous union or struct.
  //<editor-fold defaultstate="collapsed" desc="clang::FieldDecl::isAnonymousStructOrUnion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3458,
   FQN="clang::FieldDecl::isAnonymousStructOrUnion", NM="_ZNK5clang9FieldDecl24isAnonymousStructOrUnionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9FieldDecl24isAnonymousStructOrUnionEv")
  //</editor-fold>
  public boolean isAnonymousStructOrUnion() /*const*/ {
    if (!isImplicit() || getDeclName().$bool()) {
      return false;
    }
    {
      
      /*const*/ RecordType /*P*/ Record = getType().$arrow().getAs$RecordType();
      if ((Record != null)) {
        return Record.getDecl().isAnonymousStructOrUnion();
      }
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FieldDecl::getBitWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2375,
   FQN="clang::FieldDecl::getBitWidth", NM="_ZNK5clang9FieldDecl11getBitWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9FieldDecl11getBitWidthEv")
  //</editor-fold>
  public Expr /*P*/ getBitWidth() /*const*/ {
    return isBitField() ? ((/*static_cast*/Expr /*P*/ )(InitStorage.getPointer())) : null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FieldDecl::getBitWidthValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3468,
   FQN="clang::FieldDecl::getBitWidthValue", NM="_ZNK5clang9FieldDecl16getBitWidthValueERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9FieldDecl16getBitWidthValueERKNS_10ASTContextE")
  //</editor-fold>
  public /*uint*/int getBitWidthValue(final /*const*/ ASTContext /*&*/ Ctx) /*const*/ {
    assert (isBitField()) : "not a bitfield";
    Expr /*P*/ BitWidth = ((/*static_cast*/Expr /*P*/ )(InitStorage.getPointer()));
    return $ulong2uint(BitWidth.EvaluateKnownConstInt(Ctx).getZExtValue());
  }

  
  /// setBitWidth - Set the bit-field width for this member.
  // Note: used by some clients (i.e., do not remove it).
  //<editor-fold defaultstate="collapsed" desc="clang::FieldDecl::setBitWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2384,
   FQN="clang::FieldDecl::setBitWidth", NM="_ZN5clang9FieldDecl11setBitWidthEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9FieldDecl11setBitWidthEPNS_4ExprE")
  //</editor-fold>
  public void setBitWidth(Expr /*P*/ Width) {
    assert (InitStorage.getInt() == InitStorageKind.ISK_BitWidthOrNothing && $eq_ptr(InitStorage.getPointer(), null)) : "bit width, initializer or captured type already set";
    InitStorage.setPointerAndInt(Width, InitStorageKind.ISK_BitWidthOrNothing);
  }

  
  /// removeBitWidth - Remove the bit-field width from this member.
  // Note: used by some clients (i.e., do not remove it).
  //<editor-fold defaultstate="collapsed" desc="clang::FieldDecl::removeBitWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2393,
   FQN="clang::FieldDecl::removeBitWidth", NM="_ZN5clang9FieldDecl14removeBitWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9FieldDecl14removeBitWidthEv")
  //</editor-fold>
  public void removeBitWidth() {
    assert (isBitField()) : "no bitfield width to remove";
    InitStorage.setPointerAndInt((Object/*void P*/ )null, InitStorageKind.ISK_BitWidthOrNothing);
  }

  
  /// getInClassInitStyle - Get the kind of (C++11) in-class initializer which
  /// this field has.
  //<editor-fold defaultstate="collapsed" desc="clang::FieldDecl::getInClassInitStyle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2400,
   FQN="clang::FieldDecl::getInClassInitStyle", NM="_ZNK5clang9FieldDecl19getInClassInitStyleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9FieldDecl19getInClassInitStyleEv")
  //</editor-fold>
  public InClassInitStyle getInClassInitStyle() /*const*/ {
    InitStorageKind storageKind = InitStorage.getInt();
    return (storageKind == InitStorageKind.ISK_CapturedVLAType ? InClassInitStyle.ICIS_NoInit : InClassInitStyle.valueOf(storageKind.getValue()));
  }

  
  /// hasInClassInitializer - Determine whether this member has a C++11 in-class
  /// initializer.
  //<editor-fold defaultstate="collapsed" desc="clang::FieldDecl::hasInClassInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2408,
   FQN="clang::FieldDecl::hasInClassInitializer", NM="_ZNK5clang9FieldDecl21hasInClassInitializerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9FieldDecl21hasInClassInitializerEv")
  //</editor-fold>
  public boolean hasInClassInitializer() /*const*/ {
    return getInClassInitStyle() != InClassInitStyle.ICIS_NoInit;
  }

  
  /// getInClassInitializer - Get the C++11 in-class initializer for this
  /// member, or null if one has not been set. If a valid declaration has an
  /// in-class initializer, but this returns null, then we have not parsed and
  /// attached it yet.
  //<editor-fold defaultstate="collapsed" desc="clang::FieldDecl::getInClassInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2416,
   FQN="clang::FieldDecl::getInClassInitializer", NM="_ZNK5clang9FieldDecl21getInClassInitializerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9FieldDecl21getInClassInitializerEv")
  //</editor-fold>
  public Expr /*P*/ getInClassInitializer() /*const*/ {
    return hasInClassInitializer() ? ((/*static_cast*/Expr /*P*/ )(InitStorage.getPointer())) : null;
  }

  
  /// setInClassInitializer - Set the C++11 in-class initializer for this
  /// member.
  //<editor-fold defaultstate="collapsed" desc="clang::FieldDecl::setInClassInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2424,
   FQN="clang::FieldDecl::setInClassInitializer", NM="_ZN5clang9FieldDecl21setInClassInitializerEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9FieldDecl21setInClassInitializerEPNS_4ExprE")
  //</editor-fold>
  public void setInClassInitializer(Expr /*P*/ Init) {
    assert (hasInClassInitializer() && $eq_ptr(InitStorage.getPointer(), null)) : "bit width, initializer or captured type already set";
    InitStorage.setPointer(Init);
  }

  
  /// removeInClassInitializer - Remove the C++11 in-class initializer from this
  /// member.
  //<editor-fold defaultstate="collapsed" desc="clang::FieldDecl::removeInClassInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2433,
   FQN="clang::FieldDecl::removeInClassInitializer", NM="_ZN5clang9FieldDecl24removeInClassInitializerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9FieldDecl24removeInClassInitializerEv")
  //</editor-fold>
  public void removeInClassInitializer() {
    assert (hasInClassInitializer()) : "no initializer to remove";
    InitStorage.setPointerAndInt((Object/*void P*/ )null, InitStorageKind.ISK_BitWidthOrNothing);
  }

  
  /// \brief Determine whether this member captures the variable length array
  /// type.
  //<editor-fold defaultstate="collapsed" desc="clang::FieldDecl::hasCapturedVLAType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2440,
   FQN="clang::FieldDecl::hasCapturedVLAType", NM="_ZNK5clang9FieldDecl18hasCapturedVLATypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9FieldDecl18hasCapturedVLATypeEv")
  //</editor-fold>
  public boolean hasCapturedVLAType() /*const*/ {
    return InitStorage.getInt() == InitStorageKind.ISK_CapturedVLAType;
  }

  
  /// \brief Get the captured variable length array type.
  //<editor-fold defaultstate="collapsed" desc="clang::FieldDecl::getCapturedVLAType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2445,
   FQN="clang::FieldDecl::getCapturedVLAType", NM="_ZNK5clang9FieldDecl18getCapturedVLATypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9FieldDecl18getCapturedVLATypeEv")
  //</editor-fold>
  public /*const*/ VariableArrayType /*P*/ getCapturedVLAType() /*const*/ {
    return hasCapturedVLAType() ? ((/*static_cast*//*const*/ VariableArrayType /*P*/ )(InitStorage.getPointer())) : null;
  }

  /// \brief Set the captured variable length array type for this field.
  //<editor-fold defaultstate="collapsed" desc="clang::FieldDecl::setCapturedVLAType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3509,
   FQN="clang::FieldDecl::setCapturedVLAType", NM="_ZN5clang9FieldDecl18setCapturedVLATypeEPKNS_17VariableArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9FieldDecl18setCapturedVLATypeEPKNS_17VariableArrayTypeE")
  //</editor-fold>
  public void setCapturedVLAType(/*const*/ VariableArrayType /*P*/ VLAType) {
    assert ((getParent().isLambda() || getParent().isCapturedRecord())) : "capturing type in non-lambda or captured record.";
    assert (InitStorage.getInt() == InitStorageKind.ISK_BitWidthOrNothing && $eq_ptr(InitStorage.getPointer(), null)) : "bit width, initializer or captured type already set";
    InitStorage.setPointerAndInt(((/*const_cast*/VariableArrayType /*P*/ )(VLAType)), 
        InitStorageKind.ISK_CapturedVLAType);
  }

  
  /// getParent - Returns the parent of this field declaration, which
  /// is the struct in which this method is defined.
  //<editor-fold defaultstate="collapsed" desc="clang::FieldDecl::getParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2455,
   FQN="clang::FieldDecl::getParent", NM="_ZNK5clang9FieldDecl9getParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9FieldDecl9getParentEv")
  //</editor-fold>
  public /*const*/ RecordDecl /*P*/ getParent$Const() /*const*/ {
    return cast_RecordDecl(getDeclContext$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FieldDecl::getParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2459,
   FQN="clang::FieldDecl::getParent", NM="_ZN5clang9FieldDecl9getParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9FieldDecl9getParentEv")
  //</editor-fold>
  public RecordDecl /*P*/ getParent() {
    return cast_RecordDecl(getDeclContext());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FieldDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3493,
   FQN="clang::FieldDecl::getSourceRange", NM="_ZNK5clang9FieldDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9FieldDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    switch (InitStorage.getInt()) {
     case ISK_BitWidthOrNothing:
     case ISK_InClassCopyInit:
     case ISK_InClassListInit:
      {
        // All three of these cases store an optional Expr*.
        /*const*/ Expr /*P*/ E = ((/*static_cast*//*const*/ Expr /*P*/ )(InitStorage.getPointer()));
        if ((E != null)) {
          return new SourceRange(getInnerLocStart(), E.getLocEnd());
        }
      }
     case ISK_CapturedVLAType:
      // FALLTHROUGH
      return super.getSourceRange();
    }
    throw new llvm_unreachable("bad init storage kind");
  }

  
  /// Retrieves the canonical declaration of this field.
  //<editor-fold defaultstate="collapsed" desc="clang::FieldDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2466,
   FQN="clang::FieldDecl::getCanonicalDecl", NM="_ZN5clang9FieldDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9FieldDecl16getCanonicalDeclEv")
  //</editor-fold>
  @Override public FieldDecl /*P*/ getCanonicalDecl()/* override*/ {
    return getFirstDecl();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FieldDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2467,
   FQN="clang::FieldDecl::getCanonicalDecl", NM="_ZNK5clang9FieldDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9FieldDecl16getCanonicalDeclEv")
  //</editor-fold>
  public /*const*/ FieldDecl /*P*/ getCanonicalDecl$Const() /*const*/ {
    return getFirstDecl$Const();
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::FieldDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2470,
   FQN="clang::FieldDecl::classof", NM="_ZN5clang9FieldDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9FieldDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FieldDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2471,
   FQN="clang::FieldDecl::classofKind", NM="_ZN5clang9FieldDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9FieldDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K.getValue() >= Kind.firstField.getValue() && K.getValue() <= Kind.lastField.getValue();
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::FieldDecl::~FieldDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2293,
   FQN="clang::FieldDecl::~FieldDecl", NM="_ZN5clang9FieldDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9FieldDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    Mergeable.super.$destroy$Mergeable();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  //public final FieldDecl /*P*/ getFirstDecl() { return Mergeable.super.getFirstDecl$Mergeable(); }
  
  //public final /*const*/ FieldDecl /*P*/ getFirstDecl$Const() /*const*/ { return Mergeable.super.getFirstDecl$Mergeable$Const(); }
  
  public final boolean isFirstDecl() /*const*/ { return Mergeable.super.isFirstDecl$Mergeable(); }
  
  public final Class<? extends FieldDecl> getDeclType$Mergeable() { return this.getClass(); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Mutable=" + Mutable // NOI18N
              + ", CachedFieldIndex=" + CachedFieldIndex // NOI18N
              + ", InitStorage=" + InitStorage // NOI18N
              + super.toString(); // NOI18N
  }
}
