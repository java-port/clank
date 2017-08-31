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
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.lex.llvm.SmallVectorToken;
import static org.clang.sema.java.SemaSizeofAndAlignment.$sizeof_ParamInfo;

/// \brief One instance of this struct is used for each type in a
/// declarator that is parsed.
///
/// This is intended to be a small value object.
//<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1101,
 FQN="clang::DeclaratorChunk", NM="_ZN5clang15DeclaratorChunkE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunkE")
//</editor-fold>
public class/*struct*/ DeclaratorChunk implements NativePOD<DeclaratorChunk> {

  @Override
  public DeclaratorChunk clone() {
    return new DeclaratorChunk(this);
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1102,
   FQN="clang::DeclaratorChunk::(anonymous)", NM="_ZN5clang15DeclaratorChunkE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunkE_Unnamed_enum")
  //</editor-fold>
  public enum Unnamed_enum implements Native.ComparableLower {
    Pointer(0),
    Reference(Pointer.getValue() + 1),
    Array(Reference.getValue() + 1),
    Function(Array.getValue() + 1),
    BlockPointer(Function.getValue() + 1),
    MemberPointer(BlockPointer.getValue() + 1),
    Paren(MemberPointer.getValue() + 1),
    Pipe(Paren.getValue() + 1);

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
  public Unnamed_enum Kind;
  
  /// Loc - The place where this type was defined.
  public SourceLocation Loc;
  /// EndLoc - If valid, the place where this chunck ends.
  public SourceLocation EndLoc;
  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1111,
   FQN="clang::DeclaratorChunk::getSourceRange", NM="_ZNK5clang15DeclaratorChunk14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang15DeclaratorChunk14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*/ {
    if (EndLoc.isInvalid()) {
      return new SourceRange(/*NO_COPY*/Loc, /*NO_COPY*/Loc);
    }
    return new SourceRange(/*NO_COPY*/Loc, /*NO_COPY*/EndLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::TypeInfoCommon">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Access to AttrList*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1117,
   FQN="clang::DeclaratorChunk::TypeInfoCommon", NM="_ZN5clang15DeclaratorChunk14TypeInfoCommonE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk14TypeInfoCommonE")
  //</editor-fold>
  public static interface/*struct*/ TypeInfoCommon {
    
    //Field AttributeList /*P*/ AttrList
    public AttributeList /*P*/ $getAttrList();
    public AttributeList /*P*/ $setAttrList(AttributeList /*P*/ AttrList);
    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::TypeInfoCommon::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1117,
     FQN="clang::DeclaratorChunk::TypeInfoCommon::operator=", NM="_ZN5clang15DeclaratorChunk14TypeInfoCommonaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk14TypeInfoCommonaSERKS1_")
    //</editor-fold>
    public /*inline*/ TypeInfoCommon /*&*/ $assign(final /*const*/ TypeInfoCommon /*&*/ $Prm0);

    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::TypeInfoCommon::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1117,
     FQN="clang::DeclaratorChunk::TypeInfoCommon::operator=", NM="_ZN5clang15DeclaratorChunk14TypeInfoCommonaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk14TypeInfoCommonaSEOS1_")
    //</editor-fold>
    public /*inline*/ TypeInfoCommon /*&*/ $assignMove(final TypeInfoCommon /*&&*/$Prm0);

  };
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public static class/*struct*/ TypeInfoCommonImpl implements TypeInfoCommon {
    public AttributeList /*P*/ AttrList;
    public type$ref<AttributeList /*P*/>/*&*/ AttrList$Ref = new type$ref<AttributeList>() {
      @Override public AttributeList $deref() { return AttrList; }
      @Override public AttributeList $set(AttributeList value) { return AttrList = value; }
    };

    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    @Override
    public AttributeList/*P*/ $getAttrList() {
      return AttrList;
    }

    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    @Override
    public AttributeList/*P*/ $setAttrList(AttributeList/*P*/ AttrList) {
      return (this.AttrList = AttrList);
    }    
    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::TypeInfoCommon::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1117,
     FQN="clang::DeclaratorChunk::TypeInfoCommon::operator=", NM="_ZN5clang15DeclaratorChunk14TypeInfoCommonaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk14TypeInfoCommonaSERKS1_")
    //</editor-fold>
    public /*inline*/ TypeInfoCommon /*&*/ $assign(final /*const*/ TypeInfoCommon /*&*/ $Prm0) {
      this.AttrList = ((TypeInfoCommonImpl) $Prm0).AttrList;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::TypeInfoCommon::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1117,
     FQN="clang::DeclaratorChunk::TypeInfoCommon::operator=", NM="_ZN5clang15DeclaratorChunk14TypeInfoCommonaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk14TypeInfoCommonaSEOS1_")
    //</editor-fold>
    public /*inline*/ TypeInfoCommon /*&*/ $assignMove(final TypeInfoCommon /*&&*/$Prm0) {
      this.AttrList = ((TypeInfoCommonImpl) $Prm0).AttrList;
      return /*Deref*/this;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::TypeInfoCommon::TypeInfoCommon">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1117,
     FQN="clang::DeclaratorChunk::TypeInfoCommon::TypeInfoCommon", NM="_ZN5clang15DeclaratorChunk14TypeInfoCommonC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang15DeclaratorChunk14TypeInfoCommonC1ERKS1_")
    //</editor-fold>
    public /*inline*/ TypeInfoCommonImpl(final /*const*/ TypeInfoCommon /*&*/ $Prm0) {
      // : AttrList(.AttrList) 
      //START JInit
      this.AttrList = ((TypeInfoCommonImpl) $Prm0).AttrList;
      //END JInit
    }

    protected TypeInfoCommonImpl() {}
    
    @Override public String toString() {
      return "" + "AttrList=" + AttrList; // NOI18N
    }
  };
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private static class/*struct*/ DelegatingTypeInfoCommon implements TypeInfoCommon {
    protected final TypeInfoCommonImpl delegate;

    public DelegatingTypeInfoCommon(TypeInfoCommonImpl delegate) {
      this.delegate = delegate;
    }

    @Override
    public AttributeList $getAttrList() {
      return delegate.$getAttrList();
    }

    @Override
    public AttributeList $setAttrList(AttributeList AttrList) {
      return delegate.$setAttrList(AttrList);
    }

    @Override
    public TypeInfoCommon $assign(TypeInfoCommon $Prm0) {
      assert $Prm0 instanceof DelegatingTypeInfoCommon;
      return delegate.$assign(((DelegatingTypeInfoCommon) $Prm0).delegate);
    }

    @Override
    public TypeInfoCommon $assignMove(TypeInfoCommon $Prm0) {
      assert $Prm0 instanceof DelegatingTypeInfoCommon;
      return delegate.$assignMove(((DelegatingTypeInfoCommon) $Prm0).delegate);
    }
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::PointerTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1121,
   FQN="clang::DeclaratorChunk::PointerTypeInfo", NM="_ZN5clang15DeclaratorChunk15PointerTypeInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk15PointerTypeInfoE")
  //</editor-fold>
  public static class/*struct*/ PointerTypeInfo extends /**/ DelegatingTypeInfoCommon {
    /// The type qualifiers: const/volatile/restrict/unaligned/atomic.
    public /*JBYTE unsigned int*/ byte TypeQuals /*: 5*/;
    
    /// The location of the const-qualifier, if any.
    public /*uint*/int ConstQualLoc;
    
    /// The location of the volatile-qualifier, if any.
    public /*uint*/int VolatileQualLoc;
    
    /// The location of the restrict-qualifier, if any.
    public /*uint*/int RestrictQualLoc;
    
    /// The location of the _Atomic-qualifier, if any.
    public /*uint*/int AtomicQualLoc;
    
    /// The location of the __unaligned-qualifier, if any.
    public /*uint*/int UnalignedQualLoc;
    
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    private PointerTypeInfo(TypeInfoCommonImpl $Prm0) {
      super($Prm0);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::PointerTypeInfo::destroy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1140,
     FQN="clang::DeclaratorChunk::PointerTypeInfo::destroy", NM="_ZN5clang15DeclaratorChunk15PointerTypeInfo7destroyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk15PointerTypeInfo7destroyEv")
    //</editor-fold>
    public void destroy() {
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::PointerTypeInfo::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*call super*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1121,
     FQN="clang::DeclaratorChunk::PointerTypeInfo::operator=", NM="_ZN5clang15DeclaratorChunk15PointerTypeInfoaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk15PointerTypeInfoaSERKS1_")
    //</editor-fold>
    public /*inline*/ PointerTypeInfo /*&*/ $assign(final /*const*/ PointerTypeInfo /*&*/ $Prm0) {
      /*Deref*/super.$assign($Prm0);
      this.TypeQuals = $uint2uint_5bits($Prm0.TypeQuals);
      this.ConstQualLoc = $Prm0.ConstQualLoc;
      this.VolatileQualLoc = $Prm0.VolatileQualLoc;
      this.RestrictQualLoc = $Prm0.RestrictQualLoc;
      this.AtomicQualLoc = $Prm0.AtomicQualLoc;
      this.UnalignedQualLoc = $Prm0.UnalignedQualLoc;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::PointerTypeInfo::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*call super*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1121,
     FQN="clang::DeclaratorChunk::PointerTypeInfo::operator=", NM="_ZN5clang15DeclaratorChunk15PointerTypeInfoaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk15PointerTypeInfoaSEOS1_")
    //</editor-fold>
    public /*inline*/ PointerTypeInfo /*&*/ $assignMove(final PointerTypeInfo /*&&*/$Prm0) {
      /*Deref*/super.$assignMove($Prm0);
      this.TypeQuals = $uint2uint_5bits($Prm0.TypeQuals);
      this.ConstQualLoc = $Prm0.ConstQualLoc;
      this.VolatileQualLoc = $Prm0.VolatileQualLoc;
      this.RestrictQualLoc = $Prm0.RestrictQualLoc;
      this.AtomicQualLoc = $Prm0.AtomicQualLoc;
      this.UnalignedQualLoc = $Prm0.UnalignedQualLoc;
      return /*Deref*/this;
    }
    
    @Override public String toString() {
      return "" + "TypeQuals=" + $uchar2uint(TypeQuals) // NOI18N
                + ", ConstQualLoc=" + ConstQualLoc // NOI18N
                + ", VolatileQualLoc=" + VolatileQualLoc // NOI18N
                + ", RestrictQualLoc=" + RestrictQualLoc // NOI18N
                + ", AtomicQualLoc=" + AtomicQualLoc // NOI18N
                + ", UnalignedQualLoc=" + UnalignedQualLoc // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::ReferenceTypeInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*DelegatingTypeInfoCommon*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1144,
   FQN="clang::DeclaratorChunk::ReferenceTypeInfo", NM="_ZN5clang15DeclaratorChunk17ReferenceTypeInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk17ReferenceTypeInfoE")
  //</editor-fold>
  public static class/*struct*/ ReferenceTypeInfo extends /**/ DelegatingTypeInfoCommon {
    /// The type qualifier: restrict. [GNU] C++ extension
    public /*JBIT bool*/ boolean HasRestrict /*: 1*/;
    /// True if this is an lvalue reference, false if it's an rvalue reference.
    public /*JBIT bool*/ boolean LValueRef /*: 1*/;

    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    private ReferenceTypeInfo(TypeInfoCommonImpl $Prm0) {
      super($Prm0);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::ReferenceTypeInfo::destroy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1149,
     FQN="clang::DeclaratorChunk::ReferenceTypeInfo::destroy", NM="_ZN5clang15DeclaratorChunk17ReferenceTypeInfo7destroyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk17ReferenceTypeInfo7destroyEv")
    //</editor-fold>
    public void destroy() {
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::ReferenceTypeInfo::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*call super*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1144,
     FQN="clang::DeclaratorChunk::ReferenceTypeInfo::operator=", NM="_ZN5clang15DeclaratorChunk17ReferenceTypeInfoaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk17ReferenceTypeInfoaSERKS1_")
    //</editor-fold>
    public /*inline*/ ReferenceTypeInfo /*&*/ $assign(final /*const*/ ReferenceTypeInfo /*&*/ $Prm0) {
      /*Deref*/super.$assign($Prm0);
      this.HasRestrict = $Prm0.HasRestrict;
      this.LValueRef = $Prm0.LValueRef;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::ReferenceTypeInfo::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*call super*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1144,
     FQN="clang::DeclaratorChunk::ReferenceTypeInfo::operator=", NM="_ZN5clang15DeclaratorChunk17ReferenceTypeInfoaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk17ReferenceTypeInfoaSEOS1_")
    //</editor-fold>
    public /*inline*/ ReferenceTypeInfo /*&*/ $assignMove(final ReferenceTypeInfo /*&&*/$Prm0) {
      /*Deref*/super.$assignMove($Prm0);
      this.HasRestrict = $Prm0.HasRestrict;
      this.LValueRef = $Prm0.LValueRef;
      return /*Deref*/this;
    }
    
    @Override public String toString() {
      return "" + "HasRestrict=" + HasRestrict // NOI18N
                + ", LValueRef=" + LValueRef // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::ArrayTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1153,
   FQN="clang::DeclaratorChunk::ArrayTypeInfo", NM="_ZN5clang15DeclaratorChunk13ArrayTypeInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk13ArrayTypeInfoE")
  //</editor-fold>
  public static class/*struct*/ ArrayTypeInfo extends /**/ DelegatingTypeInfoCommon {
    /// The type qualifiers for the array:
    /// const/volatile/restrict/__unaligned/_Atomic.
    public /*JBYTE unsigned int*/ byte TypeQuals /*: 5*/;
    
    /// True if this dimension included the 'static' keyword.
    public /*JBIT unsigned int*/ boolean hasStatic /*: 1*/;
    
    /// True if this dimension was [*].  In this case, NumElts is null.
    public /*JBIT unsigned int*/ boolean isStar /*: 1*/;
    
    /// This is the size of the array, or null if [] or [*] was specified.
    /// Since the parser is multi-purpose, and we don't want to impose a root
    /// expression class on all clients, NumElts is untyped.
    public Expr /*P*/ NumElts;
    
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    private ArrayTypeInfo(TypeInfoCommonImpl $Prm0) {
      super($Prm0);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::ArrayTypeInfo::destroy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1169,
     FQN="clang::DeclaratorChunk::ArrayTypeInfo::destroy", NM="_ZN5clang15DeclaratorChunk13ArrayTypeInfo7destroyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk13ArrayTypeInfo7destroyEv")
    //</editor-fold>
    public void destroy() {
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::ArrayTypeInfo::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*call super*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1153,
     FQN="clang::DeclaratorChunk::ArrayTypeInfo::operator=", NM="_ZN5clang15DeclaratorChunk13ArrayTypeInfoaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk13ArrayTypeInfoaSERKS1_")
    //</editor-fold>
    public /*inline*/ ArrayTypeInfo /*&*/ $assign(final /*const*/ ArrayTypeInfo /*&*/ $Prm0) {
      /*Deref*/super.$assign($Prm0);
      this.TypeQuals = $uint2uint_5bits($Prm0.TypeQuals);
      this.hasStatic = $Prm0.hasStatic;
      this.isStar = $Prm0.isStar;
      this.NumElts = $Prm0.NumElts;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::ArrayTypeInfo::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*call super*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1153,
     FQN="clang::DeclaratorChunk::ArrayTypeInfo::operator=", NM="_ZN5clang15DeclaratorChunk13ArrayTypeInfoaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk13ArrayTypeInfoaSEOS1_")
    //</editor-fold>
    public /*inline*/ ArrayTypeInfo /*&*/ $assignMove(final ArrayTypeInfo /*&&*/$Prm0) {
      /*Deref*/super.$assignMove($Prm0);
      this.TypeQuals = $uint2uint_5bits($Prm0.TypeQuals);
      this.hasStatic = $Prm0.hasStatic;
      this.isStar = $Prm0.isStar;
      this.NumElts = $Prm0.NumElts;
      return /*Deref*/this;
    }
    
    @Override public String toString() {
      return "" + "TypeQuals=" + $uchar2uint(TypeQuals) // NOI18N
                + ", hasStatic=" + hasStatic // NOI18N
                + ", isStar=" + isStar // NOI18N
                + ", NumElts=" + NumElts // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  /// ParamInfo - An array of paraminfo objects is allocated whenever a function
  /// declarator is parsed.  There are two interesting styles of parameters
  /// here:
  /// K&R-style identifier lists and parameter type lists.  K&R-style identifier
  /// lists will have information about the identifier, but no type information.
  /// Parameter type lists will have type info (if the actions module provides
  /// it), but may have null identifier info: e.g. for 'void foo(int X, int)'.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::ParamInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1179,
   FQN="clang::DeclaratorChunk::ParamInfo", NM="_ZN5clang15DeclaratorChunk9ParamInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk9ParamInfoE")
  //</editor-fold>
  public static class/*struct*/ ParamInfo implements NativePOD<ParamInfo> {
    public IdentifierInfo /*P*/ Ident;
    public SourceLocation IdentLoc;
    public Decl /*P*/ Param;
    
    /// DefaultArgTokens - When the parameter's default argument
    /// cannot be parsed immediately (because it occurs within the
    /// declaration of a member function), it will be stored here as a
    /// sequence of tokens to be parsed once the class definition is
    /// complete. Non-NULL indicates that there is a default argument.
    public SmallVectorToken /*P*/ DefaultArgTokens;
    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::ParamInfo::ParamInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1191,
     FQN="clang::DeclaratorChunk::ParamInfo::ParamInfo", NM="_ZN5clang15DeclaratorChunk9ParamInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk9ParamInfoC1Ev")
    //</editor-fold>
    public ParamInfo() {
      // : IdentLoc() 
      //START JInit
      this.IdentLoc = new SourceLocation();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::ParamInfo::ParamInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1192,
     FQN="clang::DeclaratorChunk::ParamInfo::ParamInfo", NM="_ZN5clang15DeclaratorChunk9ParamInfoC1EPNS_14IdentifierInfoENS_14SourceLocationEPNS_4DeclEPN4llvm11SmallVectorINS_5TokenELj4EEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk9ParamInfoC1EPNS_14IdentifierInfoENS_14SourceLocationEPNS_4DeclEPN4llvm11SmallVectorINS_5TokenELj4EEE")
    //</editor-fold>
    public ParamInfo(IdentifierInfo /*P*/ ident, SourceLocation iloc, 
        Decl /*P*/ param) {
      this(ident, iloc, 
        param, 
        (SmallVectorToken /*P*/)null);
    }
    public ParamInfo(IdentifierInfo /*P*/ ident, SourceLocation iloc, 
        Decl /*P*/ param, 
        SmallVectorToken /*P*/ DefArgTokens/*= null*/) {
      // : Ident(ident), IdentLoc(iloc), Param(param), DefaultArgTokens(DefArgTokens) 
      //START JInit
      this.Ident = ident;
      this.IdentLoc = new SourceLocation(iloc);
      this.Param = param;
      this.DefaultArgTokens = DefArgTokens;
      //END JInit
    }

    @Override public ParamInfo $assign(ParamInfo $Prm0) {
      this.Ident = $Prm0.Ident;
      this.IdentLoc.$assign($Prm0.IdentLoc);
      this.Param = $Prm0.Param;
      this.DefaultArgTokens = $Prm0.DefaultArgTokens;
      return this;
    }
    
    @Override public ParamInfo clone() { return new ParamInfo(this.Ident, this.IdentLoc, this.Param, this.DefaultArgTokens); }
    
    @Override public String toString() {
      return "" + "Ident=" + Ident // NOI18N
                + ", IdentLoc=" + IdentLoc // NOI18N
                + ", Param=" + Param // NOI18N
                + ", DefaultArgTokens=" + DefaultArgTokens; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::TypeAndRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1199,
   FQN="clang::DeclaratorChunk::TypeAndRange", NM="_ZN5clang15DeclaratorChunk12TypeAndRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk12TypeAndRangeE")
  //</editor-fold>
  public static class/*struct*/ TypeAndRange {
    public OpaquePtr<QualType> Ty;
    public SourceRange Range;
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::TypeAndRange::TypeAndRange">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1199,
     FQN="clang::DeclaratorChunk::TypeAndRange::TypeAndRange", NM="_ZN5clang15DeclaratorChunk12TypeAndRangeC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk12TypeAndRangeC1Ev")
    //</editor-fold>
    public /*inline*/ TypeAndRange() {
      // : Ty(), Range() 
      //START JInit
      this.Ty = new OpaquePtr<QualType>();
      this.Range = new SourceRange();
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "Ty=" + Ty // NOI18N
                + ", Range=" + Range; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::FunctionTypeInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*DelegatingTypeInfoCommon*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1204,
   FQN="clang::DeclaratorChunk::FunctionTypeInfo", NM="_ZN5clang15DeclaratorChunk16FunctionTypeInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk16FunctionTypeInfoE")
  //</editor-fold>
  public static class/*struct*/ FunctionTypeInfo extends /**/ DelegatingTypeInfoCommon {
    /// hasPrototype - This is true if the function had at least one typed
    /// parameter.  If the function is () or (a,b,c), then it has no prototype,
    /// and is treated as a K&R-style function.
    public /*JBIT unsigned int*/ boolean hasPrototype /*: 1*/;
    
    /// isVariadic - If this function has a prototype, and if that
    /// proto ends with ',...)', this is true. When true, EllipsisLoc
    /// contains the location of the ellipsis.
    public /*JBIT unsigned int*/ boolean isVariadic /*: 1*/;
    
    /// Can this declaration be a constructor-style initializer?
    public /*JBIT unsigned int*/ boolean isAmbiguous /*: 1*/;
    
    /// \brief Whether the ref-qualifier (if any) is an lvalue reference.
    /// Otherwise, it's an rvalue reference.
    public /*JBIT unsigned int*/ boolean RefQualifierIsLValueRef /*: 1*/;
    
    /// The type qualifiers: const/volatile/restrict/__unaligned
    /// The qualifier bitmask values are the same as in QualType.
    public /*JBYTE unsigned int*/ byte TypeQuals /*: 4*/;
    
    /// ExceptionSpecType - An ExceptionSpecificationType value.
    public /*JBYTE unsigned int*/ byte ExceptionSpecType /*: 4*/;
    
    /// DeleteParams - If this is true, we need to delete[] Params.
    public /*JBIT unsigned int*/ boolean DeleteParams /*: 1*/;
    
    /// HasTrailingReturnType - If this is true, a trailing return type was
    /// specified.
    public /*JBIT unsigned int*/ boolean HasTrailingReturnType /*: 1*/;
    
    /// The location of the left parenthesis in the source.
    public /*uint*/int LParenLoc;
    
    /// When isVariadic is true, the location of the ellipsis in the source.
    public /*uint*/int EllipsisLoc;
    
    /// The location of the right parenthesis in the source.
    public /*uint*/int RParenLoc;
    
    /// NumParams - This is the number of formal parameters specified by the
    /// declarator.
    public /*uint*/int NumParams;
    
    /// NumExceptions - This is the number of types in the dynamic-exception-
    /// decl, if the function has one.
    public /*uint*/int NumExceptions;
    
    /// \brief The location of the ref-qualifier, if any.
    ///
    /// If this is an invalid location, there is no ref-qualifier.
    public /*uint*/int RefQualifierLoc;
    
    /// \brief The location of the const-qualifier, if any.
    ///
    /// If this is an invalid location, there is no const-qualifier.
    public /*uint*/int ConstQualifierLoc;
    public final uint$ref ConstQualifierLoc$Ref = new uint$ref() {
      @Override public /*uint*/int $deref() { return ConstQualifierLoc; }
      @Override public /*uint*/int $set(/*uint*/int value) { return ConstQualifierLoc = value; }
    };     
    
    /// \brief The location of the volatile-qualifier, if any.
    ///
    /// If this is an invalid location, there is no volatile-qualifier.
    public /*uint*/int VolatileQualifierLoc;
    public final uint$ref VolatileQualifierLoc$Ref = new uint$ref() {
      @Override public /*uint*/int $deref() { return VolatileQualifierLoc; }
      @Override public /*uint*/int $set(/*uint*/int value) { return VolatileQualifierLoc = value; }
    };     
    
    /// \brief The location of the restrict-qualifier, if any.
    ///
    /// If this is an invalid location, there is no restrict-qualifier.
    public /*uint*/int RestrictQualifierLoc;
    public final uint$ref RestrictQualifierLoc$Ref = new uint$ref() {
      @Override public /*uint*/int $deref() { return RestrictQualifierLoc; }
      @Override public /*uint*/int $set(/*uint*/int value) { return RestrictQualifierLoc = value; }
    };     
    
    /// \brief The location of the 'mutable' qualifer in a lambda-declarator, if
    /// any.
    public /*uint*/int MutableLoc;
    
    /// \brief The beginning location of the exception specification, if any.
    public /*uint*/int ExceptionSpecLocBeg;
    
    /// \brief The end location of the exception specification, if any.
    public /*uint*/int ExceptionSpecLocEnd;
    
    /// Params - This is a pointer to a new[]'d array of ParamInfo objects that
    /// describe the parameters specified by this function declarator.  null if
    /// there are no parameters specified.
    public type$ptr<ParamInfo> /*P*/ Params;
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::FunctionTypeInfo::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1288,
     FQN="clang::DeclaratorChunk::FunctionTypeInfo::(anonymous)", NM="_ZN5clang15DeclaratorChunk16FunctionTypeInfoE_Unnamed_union1",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk16FunctionTypeInfoE_Unnamed_union1")
    //</editor-fold>
    public static class/*union*/ Unnamed_union1 {
      /// \brief Pointer to a new[]'d array of TypeAndRange objects that
      /// contain the types in the function's dynamic exception specification
      /// and their locations, if there is one.
      public type$ptr<TypeAndRange /*P*/> Exceptions;
      
      /// \brief Pointer to the expression in the noexcept-specifier of this
      /// function, if it has one.
      public Expr /*P*/ NoexceptExpr;
      
      /// \brief Pointer to the cached tokens for an exception-specification
      /// that has not yet been parsed.
      public SmallVectorToken /*P*/ ExceptionSpecTokens;
      
      //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::FunctionTypeInfo::(anonymous union)::operator=">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1288,
       FQN="clang::DeclaratorChunk::FunctionTypeInfo::(anonymous union)::operator=", NM="_ZN5clang15DeclaratorChunk16FunctionTypeInfoUt_aSERKS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk16FunctionTypeInfoUt_aSERKS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_union1 $assign(final Unnamed_union1 $Prm0) {
        
        this.Exceptions = $tryClone($Prm0.Exceptions);
        
        this.NoexceptExpr = $Prm0.NoexceptExpr;
        
        this.ExceptionSpecTokens = $Prm0.ExceptionSpecTokens;
        
        return /*Deref*/this;
      }

      
      //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::FunctionTypeInfo::(anonymous union)::operator=">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1288,
       FQN="clang::DeclaratorChunk::FunctionTypeInfo::(anonymous union)::operator=", NM="_ZN5clang15DeclaratorChunk16FunctionTypeInfoUt_aSEOS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk16FunctionTypeInfoUt_aSEOS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_union1 $assignMove(final Unnamed_union1 $Prm0) {
        
        this.Exceptions = $Prm0.Exceptions;
        
        this.NoexceptExpr = $Prm0.NoexceptExpr;
        
        this.ExceptionSpecTokens = $Prm0.ExceptionSpecTokens;
        
        return /*Deref*/this;
      }


      //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::FunctionTypeInfo::(anonymous union)::">
      @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*assign fields*/,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1288,
       FQN="clang::DeclaratorChunk::FunctionTypeInfo::(anonymous union)::", NM="_ZN5clang15DeclaratorChunk16FunctionTypeInfoUt_C1ERKS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang15DeclaratorChunk16FunctionTypeInfoUt_C1ERKS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_union1(final Unnamed_union1 $Prm0) {
        $assign($Prm0);
      }
      public /*inline*/ Unnamed_union1() {
      }

      
      @Override public String toString() {
        return "" + "Exceptions=" + Exceptions // NOI18N
                  + ", NoexceptExpr=" + NoexceptExpr // NOI18N
                  + ", ExceptionSpecTokens=" + ExceptionSpecTokens; // NOI18N
      }
    };
    public Unnamed_union1 Unnamed_field21 = new Unnamed_union1();
    
    /// \brief If HasTrailingReturnType is true, this is the trailing return
    /// type specified.
    public UnionOpaquePtr<QualType> TrailingReturnType = new UnionOpaquePtr();
    
    /// \brief Reset the parameter list to having zero parameters.
    ///
    /// This is used in various places for error recovery.
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::FunctionTypeInfo::freeParams">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1310,
     FQN="clang::DeclaratorChunk::FunctionTypeInfo::freeParams", NM="_ZN5clang15DeclaratorChunk16FunctionTypeInfo10freeParamsEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk16FunctionTypeInfo10freeParamsEv")
    //</editor-fold>
    public void freeParams() {
      for (/*uint*/int I = 0; $less_uint(I, NumParams); ++I) {
        if (Params.$at(I).DefaultArgTokens != null) { Params.$at(I).DefaultArgTokens.$destroy();};
        Params.$at(I).DefaultArgTokens = null;
      }
      if (DeleteParams) {
        /*delete[]*/Destructors.$destroyArray(Params);
        DeleteParams = false;
      }
      NumParams = 0;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::FunctionTypeInfo::destroy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1322,
     FQN="clang::DeclaratorChunk::FunctionTypeInfo::destroy", NM="_ZN5clang15DeclaratorChunk16FunctionTypeInfo7destroyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk16FunctionTypeInfo7destroyEv")
    //</editor-fold>
    public void destroy() {
      if (DeleteParams) {
        /*delete[]*/Destructors.$destroyArray(Params);
      }
      if (getExceptionSpecType() == ExceptionSpecificationType.EST_Dynamic) {
        /*delete[]*/Destructors.$destroyArray(Unnamed_field21.Exceptions);
      } else if (getExceptionSpecType() == ExceptionSpecificationType.EST_Unparsed) {
        if (Unnamed_field21.ExceptionSpecTokens != null) { Unnamed_field21.ExceptionSpecTokens.$destroy();};
      }
    }

    
    /// isKNRPrototype - Return true if this is a K&R style identifier list,
    /// like "void foo(a,b,c)".  In a function definition, this will be followed
    /// by the parameter type definitions.
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::FunctionTypeInfo::isKNRPrototype">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1334,
     FQN="clang::DeclaratorChunk::FunctionTypeInfo::isKNRPrototype", NM="_ZNK5clang15DeclaratorChunk16FunctionTypeInfo14isKNRPrototypeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang15DeclaratorChunk16FunctionTypeInfo14isKNRPrototypeEv")
    //</editor-fold>
    public boolean isKNRPrototype() /*const*/ {
      return !hasPrototype && NumParams != 0;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::FunctionTypeInfo::getLParenLoc">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1336,
     FQN="clang::DeclaratorChunk::FunctionTypeInfo::getLParenLoc", NM="_ZNK5clang15DeclaratorChunk16FunctionTypeInfo12getLParenLocEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang15DeclaratorChunk16FunctionTypeInfo12getLParenLocEv")
    //</editor-fold>
    public SourceLocation getLParenLoc() /*const*/ {
      return SourceLocation.getFromRawEncoding(LParenLoc);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::FunctionTypeInfo::getEllipsisLoc">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1340,
     FQN="clang::DeclaratorChunk::FunctionTypeInfo::getEllipsisLoc", NM="_ZNK5clang15DeclaratorChunk16FunctionTypeInfo14getEllipsisLocEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang15DeclaratorChunk16FunctionTypeInfo14getEllipsisLocEv")
    //</editor-fold>
    public SourceLocation getEllipsisLoc() /*const*/ {
      return SourceLocation.getFromRawEncoding(EllipsisLoc);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::FunctionTypeInfo::getRParenLoc">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1344,
     FQN="clang::DeclaratorChunk::FunctionTypeInfo::getRParenLoc", NM="_ZNK5clang15DeclaratorChunk16FunctionTypeInfo12getRParenLocEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang15DeclaratorChunk16FunctionTypeInfo12getRParenLocEv")
    //</editor-fold>
    public SourceLocation getRParenLoc() /*const*/ {
      return SourceLocation.getFromRawEncoding(RParenLoc);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::FunctionTypeInfo::getExceptionSpecLocBeg">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1348,
     FQN="clang::DeclaratorChunk::FunctionTypeInfo::getExceptionSpecLocBeg", NM="_ZNK5clang15DeclaratorChunk16FunctionTypeInfo22getExceptionSpecLocBegEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang15DeclaratorChunk16FunctionTypeInfo22getExceptionSpecLocBegEv")
    //</editor-fold>
    public SourceLocation getExceptionSpecLocBeg() /*const*/ {
      return SourceLocation.getFromRawEncoding(ExceptionSpecLocBeg);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::FunctionTypeInfo::getExceptionSpecLocEnd">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1352,
     FQN="clang::DeclaratorChunk::FunctionTypeInfo::getExceptionSpecLocEnd", NM="_ZNK5clang15DeclaratorChunk16FunctionTypeInfo22getExceptionSpecLocEndEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang15DeclaratorChunk16FunctionTypeInfo22getExceptionSpecLocEndEv")
    //</editor-fold>
    public SourceLocation getExceptionSpecLocEnd() /*const*/ {
      return SourceLocation.getFromRawEncoding(ExceptionSpecLocEnd);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::FunctionTypeInfo::getExceptionSpecRange">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1356,
     FQN="clang::DeclaratorChunk::FunctionTypeInfo::getExceptionSpecRange", NM="_ZNK5clang15DeclaratorChunk16FunctionTypeInfo21getExceptionSpecRangeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang15DeclaratorChunk16FunctionTypeInfo21getExceptionSpecRangeEv")
    //</editor-fold>
    public SourceRange getExceptionSpecRange() /*const*/ {
      return new SourceRange(getExceptionSpecLocBeg(), getExceptionSpecLocEnd());
    }

    
    /// \brief Retrieve the location of the ref-qualifier, if any.
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::FunctionTypeInfo::getRefQualifierLoc">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1361,
     FQN="clang::DeclaratorChunk::FunctionTypeInfo::getRefQualifierLoc", NM="_ZNK5clang15DeclaratorChunk16FunctionTypeInfo18getRefQualifierLocEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang15DeclaratorChunk16FunctionTypeInfo18getRefQualifierLocEv")
    //</editor-fold>
    public SourceLocation getRefQualifierLoc() /*const*/ {
      return SourceLocation.getFromRawEncoding(RefQualifierLoc);
    }

    
    /// \brief Retrieve the location of the 'const' qualifier, if any.
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::FunctionTypeInfo::getConstQualifierLoc">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1366,
     FQN="clang::DeclaratorChunk::FunctionTypeInfo::getConstQualifierLoc", NM="_ZNK5clang15DeclaratorChunk16FunctionTypeInfo20getConstQualifierLocEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang15DeclaratorChunk16FunctionTypeInfo20getConstQualifierLocEv")
    //</editor-fold>
    public SourceLocation getConstQualifierLoc() /*const*/ {
      return SourceLocation.getFromRawEncoding(ConstQualifierLoc);
    }

    
    /// \brief Retrieve the location of the 'volatile' qualifier, if any.
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::FunctionTypeInfo::getVolatileQualifierLoc">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1371,
     FQN="clang::DeclaratorChunk::FunctionTypeInfo::getVolatileQualifierLoc", NM="_ZNK5clang15DeclaratorChunk16FunctionTypeInfo23getVolatileQualifierLocEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang15DeclaratorChunk16FunctionTypeInfo23getVolatileQualifierLocEv")
    //</editor-fold>
    public SourceLocation getVolatileQualifierLoc() /*const*/ {
      return SourceLocation.getFromRawEncoding(VolatileQualifierLoc);
    }

    
    /// \brief Retrieve the location of the 'restrict' qualifier, if any.
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::FunctionTypeInfo::getRestrictQualifierLoc">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1376,
     FQN="clang::DeclaratorChunk::FunctionTypeInfo::getRestrictQualifierLoc", NM="_ZNK5clang15DeclaratorChunk16FunctionTypeInfo23getRestrictQualifierLocEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang15DeclaratorChunk16FunctionTypeInfo23getRestrictQualifierLocEv")
    //</editor-fold>
    public SourceLocation getRestrictQualifierLoc() /*const*/ {
      return SourceLocation.getFromRawEncoding(RestrictQualifierLoc);
    }

    
    /// \brief Retrieve the location of the 'mutable' qualifier, if any.
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::FunctionTypeInfo::getMutableLoc">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1381,
     FQN="clang::DeclaratorChunk::FunctionTypeInfo::getMutableLoc", NM="_ZNK5clang15DeclaratorChunk16FunctionTypeInfo13getMutableLocEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang15DeclaratorChunk16FunctionTypeInfo13getMutableLocEv")
    //</editor-fold>
    public SourceLocation getMutableLoc() /*const*/ {
      return SourceLocation.getFromRawEncoding(MutableLoc);
    }

    
    /// \brief Determine whether this function declaration contains a 
    /// ref-qualifier.
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::FunctionTypeInfo::hasRefQualifier">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1387,
     FQN="clang::DeclaratorChunk::FunctionTypeInfo::hasRefQualifier", NM="_ZNK5clang15DeclaratorChunk16FunctionTypeInfo15hasRefQualifierEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang15DeclaratorChunk16FunctionTypeInfo15hasRefQualifierEv")
    //</editor-fold>
    public boolean hasRefQualifier() /*const*/ {
      return getRefQualifierLoc().isValid();
    }

    
    /// \brief Determine whether this lambda-declarator contains a 'mutable'
    /// qualifier.
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::FunctionTypeInfo::hasMutableQualifier">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1391,
     FQN="clang::DeclaratorChunk::FunctionTypeInfo::hasMutableQualifier", NM="_ZNK5clang15DeclaratorChunk16FunctionTypeInfo19hasMutableQualifierEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang15DeclaratorChunk16FunctionTypeInfo19hasMutableQualifierEv")
    //</editor-fold>
    public boolean hasMutableQualifier() /*const*/ {
      return getMutableLoc().isValid();
    }

    
    /// \brief Get the type of exception specification this function has.
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::FunctionTypeInfo::getExceptionSpecType">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1394,
     FQN="clang::DeclaratorChunk::FunctionTypeInfo::getExceptionSpecType", NM="_ZNK5clang15DeclaratorChunk16FunctionTypeInfo20getExceptionSpecTypeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang15DeclaratorChunk16FunctionTypeInfo20getExceptionSpecTypeEv")
    //</editor-fold>
    public ExceptionSpecificationType getExceptionSpecType() /*const*/ {
      return /*static_cast*/ExceptionSpecificationType.valueOf(ExceptionSpecType);
    }

    
    /// \brief Determine whether this function declarator had a
    /// trailing-return-type.
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::FunctionTypeInfo::hasTrailingReturnType">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1400,
     FQN="clang::DeclaratorChunk::FunctionTypeInfo::hasTrailingReturnType", NM="_ZNK5clang15DeclaratorChunk16FunctionTypeInfo21hasTrailingReturnTypeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang15DeclaratorChunk16FunctionTypeInfo21hasTrailingReturnTypeEv")
    //</editor-fold>
    public boolean hasTrailingReturnType() /*const*/ {
      return HasTrailingReturnType;
    }

    
    /// \brief Get the trailing-return-type for this function declarator.
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::FunctionTypeInfo::getTrailingReturnType">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1403,
     FQN="clang::DeclaratorChunk::FunctionTypeInfo::getTrailingReturnType", NM="_ZNK5clang15DeclaratorChunk16FunctionTypeInfo21getTrailingReturnTypeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang15DeclaratorChunk16FunctionTypeInfo21getTrailingReturnTypeEv")
    //</editor-fold>
    public OpaquePtr<QualType> getTrailingReturnType() /*const*/ {
      return TrailingReturnType.$OpaquePtr$T();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::FunctionTypeInfo::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1204,
     FQN="clang::DeclaratorChunk::FunctionTypeInfo::operator=", NM="_ZN5clang15DeclaratorChunk16FunctionTypeInfoaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk16FunctionTypeInfoaSERKS1_")
    //</editor-fold>
    public /*inline*/ FunctionTypeInfo /*&*/ $assign(final /*const*/ FunctionTypeInfo /*&*/ $Prm0) {
      /*Deref*/super.$assign($Prm0);
      this.hasPrototype = $Prm0.hasPrototype;
      this.isVariadic = $Prm0.isVariadic;
      this.isAmbiguous = $Prm0.isAmbiguous;
      this.RefQualifierIsLValueRef = $Prm0.RefQualifierIsLValueRef;
      this.TypeQuals = $uint2uint_4bits($Prm0.TypeQuals);
      this.ExceptionSpecType = $uint2uint_4bits($Prm0.ExceptionSpecType);
      this.DeleteParams = $Prm0.DeleteParams;
      this.HasTrailingReturnType = $Prm0.HasTrailingReturnType;
      this.LParenLoc = $Prm0.LParenLoc;
      this.EllipsisLoc = $Prm0.EllipsisLoc;
      this.RParenLoc = $Prm0.RParenLoc;
      this.NumParams = $Prm0.NumParams;
      this.NumExceptions = $Prm0.NumExceptions;
      this.RefQualifierLoc = $Prm0.RefQualifierLoc;
      this.ConstQualifierLoc = $Prm0.ConstQualifierLoc;
      this.VolatileQualifierLoc = $Prm0.VolatileQualifierLoc;
      this.RestrictQualifierLoc = $Prm0.RestrictQualifierLoc;
      this.MutableLoc = $Prm0.MutableLoc;
      this.ExceptionSpecLocBeg = $Prm0.ExceptionSpecLocBeg;
      this.ExceptionSpecLocEnd = $Prm0.ExceptionSpecLocEnd;
      this.Params = $tryClone($Prm0.Params);
      this.Unnamed_field21.$assign($Prm0.Unnamed_field21);
      this.TrailingReturnType.$assign($Prm0.TrailingReturnType);
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::FunctionTypeInfo::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1204,
     FQN="clang::DeclaratorChunk::FunctionTypeInfo::operator=", NM="_ZN5clang15DeclaratorChunk16FunctionTypeInfoaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk16FunctionTypeInfoaSEOS1_")
    //</editor-fold>
    public /*inline*/ FunctionTypeInfo /*&*/ $assignMove(final FunctionTypeInfo /*&&*/$Prm0) {
      /*Deref*/super.$assignMove($Prm0);
      this.hasPrototype = $Prm0.hasPrototype;
      this.isVariadic = $Prm0.isVariadic;
      this.isAmbiguous = $Prm0.isAmbiguous;
      this.RefQualifierIsLValueRef = $Prm0.RefQualifierIsLValueRef;
      this.TypeQuals = $uint2uint_4bits($Prm0.TypeQuals);
      this.ExceptionSpecType = $uint2uint_4bits($Prm0.ExceptionSpecType);
      this.DeleteParams = $Prm0.DeleteParams;
      this.HasTrailingReturnType = $Prm0.HasTrailingReturnType;
      this.LParenLoc = $Prm0.LParenLoc;
      this.EllipsisLoc = $Prm0.EllipsisLoc;
      this.RParenLoc = $Prm0.RParenLoc;
      this.NumParams = $Prm0.NumParams;
      this.NumExceptions = $Prm0.NumExceptions;
      this.RefQualifierLoc = $Prm0.RefQualifierLoc;
      this.ConstQualifierLoc = $Prm0.ConstQualifierLoc;
      this.VolatileQualifierLoc = $Prm0.VolatileQualifierLoc;
      this.RestrictQualifierLoc = $Prm0.RestrictQualifierLoc;
      this.MutableLoc = $Prm0.MutableLoc;
      this.ExceptionSpecLocBeg = $Prm0.ExceptionSpecLocBeg;
      this.ExceptionSpecLocEnd = $Prm0.ExceptionSpecLocEnd;
      this.Params = $Prm0.Params;
      this.Unnamed_field21.$assignMove($Prm0.Unnamed_field21);
      this.TrailingReturnType.$assignMove($Prm0.TrailingReturnType);
      return /*Deref*/this;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::FunctionTypeInfo::FunctionTypeInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1204,
     FQN="clang::DeclaratorChunk::FunctionTypeInfo::FunctionTypeInfo", NM="_ZN5clang15DeclaratorChunk16FunctionTypeInfoC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang15DeclaratorChunk16FunctionTypeInfoC1ERKS1_")
    //</editor-fold>
    public /*inline*/ FunctionTypeInfo(final /*const*/ FunctionTypeInfo /*&*/ $Prm0) {
      // : TypeInfoCommon(), hasPrototype(.hasPrototype), isVariadic(.isVariadic), isAmbiguous(.isAmbiguous), RefQualifierIsLValueRef(.RefQualifierIsLValueRef), TypeQuals(.TypeQuals), ExceptionSpecType(.ExceptionSpecType), DeleteParams(.DeleteParams), HasTrailingReturnType(.HasTrailingReturnType), LParenLoc(.LParenLoc), EllipsisLoc(.EllipsisLoc), RParenLoc(.RParenLoc), NumParams(.NumParams), NumExceptions(.NumExceptions), RefQualifierLoc(.RefQualifierLoc), ConstQualifierLoc(.ConstQualifierLoc), VolatileQualifierLoc(.VolatileQualifierLoc), RestrictQualifierLoc(.RestrictQualifierLoc), MutableLoc(.MutableLoc), ExceptionSpecLocBeg(.ExceptionSpecLocBeg), ExceptionSpecLocEnd(.ExceptionSpecLocEnd), Params(.Params), Unnamed_field21(.), TrailingReturnType(.TrailingReturnType) 
      //START JInit
      super($Prm0.delegate);
      this.hasPrototype = $Prm0.hasPrototype;
      this.isVariadic = $Prm0.isVariadic;
      this.isAmbiguous = $Prm0.isAmbiguous;
      this.RefQualifierIsLValueRef = $Prm0.RefQualifierIsLValueRef;
      this.TypeQuals = $uint2uint_4bits($Prm0.TypeQuals);
      this.ExceptionSpecType = $uint2uint_4bits($Prm0.ExceptionSpecType);
      this.DeleteParams = $Prm0.DeleteParams;
      this.HasTrailingReturnType = $Prm0.HasTrailingReturnType;
      this.LParenLoc = $Prm0.LParenLoc;
      this.EllipsisLoc = $Prm0.EllipsisLoc;
      this.RParenLoc = $Prm0.RParenLoc;
      this.NumParams = $Prm0.NumParams;
      this.NumExceptions = $Prm0.NumExceptions;
      this.RefQualifierLoc = $Prm0.RefQualifierLoc;
      this.ConstQualifierLoc = $Prm0.ConstQualifierLoc;
      this.VolatileQualifierLoc = $Prm0.VolatileQualifierLoc;
      this.RestrictQualifierLoc = $Prm0.RestrictQualifierLoc;
      this.MutableLoc = $Prm0.MutableLoc;
      this.ExceptionSpecLocBeg = $Prm0.ExceptionSpecLocBeg;
      this.ExceptionSpecLocEnd = $Prm0.ExceptionSpecLocEnd;
      this.Params = $Prm0.Params;
      this.Unnamed_field21 = new Unnamed_union1($Prm0.Unnamed_field21);
      this.TrailingReturnType = new UnionOpaquePtr<QualType>($Prm0.TrailingReturnType);
      //END JInit
    }
    
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    private FunctionTypeInfo(TypeInfoCommonImpl delegate) {
      super(delegate);
    }
    
    @Override public String toString() {
      return "" + "hasPrototype=" + hasPrototype // NOI18N
                + ", isVariadic=" + isVariadic // NOI18N
                + ", isAmbiguous=" + isAmbiguous // NOI18N
                + ", RefQualifierIsLValueRef=" + RefQualifierIsLValueRef // NOI18N
                + ", TypeQuals=" + $uchar2uint(TypeQuals) // NOI18N
                + ", ExceptionSpecType=" + $uchar2uint(ExceptionSpecType) // NOI18N
                + ", DeleteParams=" + DeleteParams // NOI18N
                + ", HasTrailingReturnType=" + HasTrailingReturnType // NOI18N
                + ", LParenLoc=" + LParenLoc // NOI18N
                + ", EllipsisLoc=" + EllipsisLoc // NOI18N
                + ", RParenLoc=" + RParenLoc // NOI18N
                + ", NumParams=" + NumParams // NOI18N
                + ", NumExceptions=" + NumExceptions // NOI18N
                + ", RefQualifierLoc=" + RefQualifierLoc // NOI18N
                + ", ConstQualifierLoc=" + ConstQualifierLoc // NOI18N
                + ", VolatileQualifierLoc=" + VolatileQualifierLoc // NOI18N
                + ", RestrictQualifierLoc=" + RestrictQualifierLoc // NOI18N
                + ", MutableLoc=" + MutableLoc // NOI18N
                + ", ExceptionSpecLocBeg=" + ExceptionSpecLocBeg // NOI18N
                + ", ExceptionSpecLocEnd=" + ExceptionSpecLocEnd // NOI18N
                + ", Params=" + Params // NOI18N
                + ", Unnamed_field21=" + Unnamed_field21 // NOI18N
                + ", TrailingReturnType=" + TrailingReturnType // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::BlockPointerTypeInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*DelegatingTypeInfoCommon*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1406,
   FQN="clang::DeclaratorChunk::BlockPointerTypeInfo", NM="_ZN5clang15DeclaratorChunk20BlockPointerTypeInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk20BlockPointerTypeInfoE")
  //</editor-fold>
  public static class/*struct*/ BlockPointerTypeInfo extends /**/ DelegatingTypeInfoCommon {
    /// For now, sema will catch these as invalid.
    /// The type qualifiers: const/volatile/restrict/__unaligned/_Atomic.
    public /*JBYTE unsigned int*/ byte TypeQuals /*: 5*/;
    
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    private BlockPointerTypeInfo(TypeInfoCommonImpl $Prm0) {
      super($Prm0);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::BlockPointerTypeInfo::destroy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1411,
     FQN="clang::DeclaratorChunk::BlockPointerTypeInfo::destroy", NM="_ZN5clang15DeclaratorChunk20BlockPointerTypeInfo7destroyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk20BlockPointerTypeInfo7destroyEv")
    //</editor-fold>
    public void destroy() {
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::BlockPointerTypeInfo::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*call super*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1406,
     FQN="clang::DeclaratorChunk::BlockPointerTypeInfo::operator=", NM="_ZN5clang15DeclaratorChunk20BlockPointerTypeInfoaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk20BlockPointerTypeInfoaSERKS1_")
    //</editor-fold>
    public /*inline*/ BlockPointerTypeInfo /*&*/ $assign(final /*const*/ BlockPointerTypeInfo /*&*/ $Prm0) {
      /*Deref*/super.$assign($Prm0);
      this.TypeQuals = $uint2uint_5bits($Prm0.TypeQuals);
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::BlockPointerTypeInfo::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*call super*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1406,
     FQN="clang::DeclaratorChunk::BlockPointerTypeInfo::operator=", NM="_ZN5clang15DeclaratorChunk20BlockPointerTypeInfoaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk20BlockPointerTypeInfoaSEOS1_")
    //</editor-fold>
    public /*inline*/ BlockPointerTypeInfo /*&*/ $assignMove(final BlockPointerTypeInfo /*&&*/$Prm0) {
      /*Deref*/super.$assignMove($Prm0);
      this.TypeQuals = $uint2uint_5bits($Prm0.TypeQuals);
      return /*Deref*/this;
    }

    @Override public String toString() {
      return "" + "TypeQuals=" + $uchar2uint(TypeQuals) // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::MemberPointerTypeInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*DelegatingTypeInfoCommon*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1415,
   FQN="clang::DeclaratorChunk::MemberPointerTypeInfo", NM="_ZN5clang15DeclaratorChunk21MemberPointerTypeInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk21MemberPointerTypeInfoE")
  //</editor-fold>
  public static class/*struct*/ MemberPointerTypeInfo extends /**/ DelegatingTypeInfoCommon {
    /// The type qualifiers: const/volatile/restrict/__unaligned/_Atomic.
    public /*JBYTE unsigned int*/ byte TypeQuals /*: 5*/;

    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    private MemberPointerTypeInfo(TypeInfoCommonImpl $Prm0) {
      super($Prm0);
    }

    // CXXScopeSpec has a constructor, so it can't be a direct member.
    // So we need some pointer-aligned storage and a bit of trickery.
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::MemberPointerTypeInfo::(anonymous)">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*explicit type*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1420,
     FQN="clang::DeclaratorChunk::MemberPointerTypeInfo::(anonymous)", NM="_ZN5clang15DeclaratorChunk21MemberPointerTypeInfoE_Unnamed_union1",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk21MemberPointerTypeInfoE_Unnamed_union1")
    //</editor-fold>
    public static class/*union*/ Unnamed_union1 {
      public Object/*void P*/ Aligner;
      // JAVA: use explicit type
      public /*char*/CXXScopeSpec Mem = new CXXScopeSpec();
      //public /*char*/byte Mem[/*24*/] = new$char(24);
      //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::MemberPointerTypeInfo::(anonymous union)::operator=">
      @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1420,
       FQN="clang::DeclaratorChunk::MemberPointerTypeInfo::(anonymous union)::operator=", NM="_ZN5clang15DeclaratorChunk21MemberPointerTypeInfoUt_aSERKS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk21MemberPointerTypeInfoUt_aSERKS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_union1 $assign(final Unnamed_union1 $Prm0) {
        this.Aligner = $MemoryCopyAligner($Prm0.Aligner);
        this.Mem.$MemoryCopy($Prm0.Mem);
        //__builtin_memcpy(/*AddrOf*/this.Mem, /*AddrOf*/$Prm0.Mem, $Prm0.Mem.length/*U*/);
        return /*Deref*/this;
      }

      //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::MemberPointerTypeInfo::(anonymous union)::operator=">
      @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1420,
       FQN="clang::DeclaratorChunk::MemberPointerTypeInfo::(anonymous union)::operator=", NM="_ZN5clang15DeclaratorChunk21MemberPointerTypeInfoUt_aSEOS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk21MemberPointerTypeInfoUt_aSEOS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_union1 $assignMove(final Unnamed_union1 $Prm0) {
        this.Aligner = $MemoryCopyAligner($Prm0.Aligner);;
        this.Mem.$MemoryCopy($Prm0.Mem);
        //__builtin_memcpy(/*AddrOf*/this.Mem, /*AddrOf*/$Prm0.Mem, $Prm0.Mem.length/*U*/);
        return /*Deref*/this;
      }

      @Converted(kind = Converted.Kind.MANUAL_ADDED)
      private Object $MemoryCopyAligner(Object/*void P*/ Aligner) {
        if (Aligner instanceof abstract_iterator) {
          return $tryClone(Aligner);
        }
        return Aligner;
      }
      
      @Override public String toString() {
        return "" + "Aligner=" + Aligner // NOI18N
                  + ", Mem=" + Mem; // NOI18N
      }
    };
    public Unnamed_union1 ScopeMem = new Unnamed_union1();
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::MemberPointerTypeInfo::Scope">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1424,
     FQN="clang::DeclaratorChunk::MemberPointerTypeInfo::Scope", NM="_ZN5clang15DeclaratorChunk21MemberPointerTypeInfo5ScopeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk21MemberPointerTypeInfo5ScopeEv")
    //</editor-fold>
    public CXXScopeSpec /*&*/ Scope() {
      return $Deref(reinterpret_cast(CXXScopeSpec /*P*/ .class, ScopeMem.Mem));
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::MemberPointerTypeInfo::Scope">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1427,
     FQN="clang::DeclaratorChunk::MemberPointerTypeInfo::Scope", NM="_ZNK5clang15DeclaratorChunk21MemberPointerTypeInfo5ScopeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang15DeclaratorChunk21MemberPointerTypeInfo5ScopeEv")
    //</editor-fold>
    public /*const*/ CXXScopeSpec /*&*/ Scope$Const() /*const*/ {
      return $Deref(reinterpret_cast(/*const*/ CXXScopeSpec /*P*/ .class, ScopeMem.Mem));
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::MemberPointerTypeInfo::destroy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1430,
     FQN="clang::DeclaratorChunk::MemberPointerTypeInfo::destroy", NM="_ZN5clang15DeclaratorChunk21MemberPointerTypeInfo7destroyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk21MemberPointerTypeInfo7destroyEv")
    //</editor-fold>
    public void destroy() {
      Scope().$destroy();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::MemberPointerTypeInfo::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*call super*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1415,
     FQN="clang::DeclaratorChunk::MemberPointerTypeInfo::operator=", NM="_ZN5clang15DeclaratorChunk21MemberPointerTypeInfoaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk21MemberPointerTypeInfoaSERKS1_")
    //</editor-fold>
    public /*inline*/ MemberPointerTypeInfo /*&*/ $assign(final /*const*/ MemberPointerTypeInfo /*&*/ $Prm0) {
      /*Deref*/super.$assign($Prm0);
      this.TypeQuals = $uint2uint_5bits($Prm0.TypeQuals);
      this.ScopeMem.$assign($Prm0.ScopeMem);
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::MemberPointerTypeInfo::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*call super*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1415,
     FQN="clang::DeclaratorChunk::MemberPointerTypeInfo::operator=", NM="_ZN5clang15DeclaratorChunk21MemberPointerTypeInfoaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk21MemberPointerTypeInfoaSEOS1_")
    //</editor-fold>
    public /*inline*/ MemberPointerTypeInfo /*&*/ $assignMove(final MemberPointerTypeInfo /*&&*/$Prm0) {
      /*Deref*/super.$assignMove($Prm0);
      this.TypeQuals = $uint2uint_5bits($Prm0.TypeQuals);
      this.ScopeMem.$assignMove($Prm0.ScopeMem);
      return /*Deref*/this;
    }
    
    @Override public String toString() {
      return "" + "TypeQuals=" + $uchar2uint(TypeQuals) // NOI18N
                + ", ScopeMem=" + ScopeMem // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::PipeTypeInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*DelegatingTypeInfoCommon*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1435,
   FQN="clang::DeclaratorChunk::PipeTypeInfo", NM="_ZN5clang15DeclaratorChunk12PipeTypeInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk12PipeTypeInfoE")
  //</editor-fold>
  public static class/*struct*/ PipeTypeInfo extends /**/ DelegatingTypeInfoCommon {
    /// The access writes.
    public /*JBYTE unsigned int*/ byte AccessWrites /*: 3*/;
    
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    private PipeTypeInfo(TypeInfoCommonImpl $Prm0) {
      super($Prm0);
    }
    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::PipeTypeInfo::destroy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1439,
     FQN="clang::DeclaratorChunk::PipeTypeInfo::destroy", NM="_ZN5clang15DeclaratorChunk12PipeTypeInfo7destroyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk12PipeTypeInfo7destroyEv")
    //</editor-fold>
    public void destroy() {
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::PipeTypeInfo::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*call super*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1435,
     FQN="clang::DeclaratorChunk::PipeTypeInfo::operator=", NM="_ZN5clang15DeclaratorChunk12PipeTypeInfoaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk12PipeTypeInfoaSERKS1_")
    //</editor-fold>
    public /*inline*/ PipeTypeInfo /*&*/ $assign(final /*const*/ PipeTypeInfo /*&*/ $Prm0) {
      /*Deref*/super.$assign($Prm0);
      this.AccessWrites = $uint2uint_3bits($Prm0.AccessWrites);
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::PipeTypeInfo::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*call super*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1435,
     FQN="clang::DeclaratorChunk::PipeTypeInfo::operator=", NM="_ZN5clang15DeclaratorChunk12PipeTypeInfoaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk12PipeTypeInfoaSEOS1_")
    //</editor-fold>
    public /*inline*/ PipeTypeInfo /*&*/ $assignMove(final PipeTypeInfo /*&&*/$Prm0) {
      /*Deref*/super.$assignMove($Prm0);
      this.AccessWrites = $uint2uint_3bits($Prm0.AccessWrites);
      return /*Deref*/this;
    }

    @Override public String toString() {
      return "" + "AccessWrites=" + $uchar2uint(AccessWrites) // NOI18N
                + super.toString(); // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::(anonymous)">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*inititlaization*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1442,
   FQN="clang::DeclaratorChunk::(anonymous)", NM="_ZN5clang15DeclaratorChunkE_Unnamed_union11",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunkE_Unnamed_union11")
  //</editor-fold>
  public static class/*union*/ Unnamed_union11 {
    public TypeInfoCommonImpl Common = new TypeInfoCommonImpl();
    public PointerTypeInfo Ptr = new PointerTypeInfo(Common);
    public ReferenceTypeInfo Ref = new ReferenceTypeInfo(Common);
    public ArrayTypeInfo Arr = new ArrayTypeInfo(Common);
    public FunctionTypeInfo Fun = new FunctionTypeInfo(Common);
    public BlockPointerTypeInfo Cls = new BlockPointerTypeInfo(Common);
    public MemberPointerTypeInfo Mem = new MemberPointerTypeInfo(Common);
    public PipeTypeInfo PipeInfo = new PipeTypeInfo(Common);
    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::(anonymous union)::">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1442,
     FQN="clang::DeclaratorChunk::(anonymous union)::", NM="_ZN5clang15DeclaratorChunkUt0_C1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunkUt0_C1EOS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union11(JD$Move _dparam, final Unnamed_union11 $Prm0) {
      $assignMove($Prm0);
    }
    public /*inline*/ Unnamed_union11() {
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::(anonymous union)::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1442,
     FQN="clang::DeclaratorChunk::(anonymous union)::operator=", NM="_ZN5clang15DeclaratorChunkUt0_aSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunkUt0_aSERKS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union11 $assign(final Unnamed_union11 $Prm0) {
      
      this.Common.$assign($Prm0.Common);
      
      this.Ptr.$assign($Prm0.Ptr);
      
      this.Ref.$assign($Prm0.Ref);
      
      this.Arr.$assign($Prm0.Arr);
      
      this.Fun.$assign($Prm0.Fun);
      
      this.Cls.$assign($Prm0.Cls);
      
      this.Mem.$assign($Prm0.Mem);
      
      this.PipeInfo.$assign($Prm0.PipeInfo);
      
      return /*Deref*/this;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::(anonymous union)::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1442,
     FQN="clang::DeclaratorChunk::(anonymous union)::operator=", NM="_ZN5clang15DeclaratorChunkUt0_aSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunkUt0_aSEOS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union11 $assignMove(final Unnamed_union11 $Prm0) {
      
      this.Common.$assignMove($Prm0.Common);
      
      this.Ptr.$assignMove($Prm0.Ptr);
      
      this.Ref.$assignMove($Prm0.Ref);
      
      this.Arr.$assignMove($Prm0.Arr);
      
      this.Fun.$assignMove($Prm0.Fun);
      
      this.Cls.$assignMove($Prm0.Cls);
      
      this.Mem.$assignMove($Prm0.Mem);
      
      this.PipeInfo.$assignMove($Prm0.PipeInfo);
      
      return /*Deref*/this;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1442,
     FQN="clang::DeclaratorChunk::(anonymous union)::", NM="_ZN5clang15DeclaratorChunkUt0_C1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang15DeclaratorChunkUt0_C1ERKS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union11(final Unnamed_union11 $Prm0) {
      $assign($Prm0);
    }

    
    @Override public String toString() {
      return "" + "Common=" + Common // NOI18N
                + ", Ptr=" + Ptr // NOI18N
                + ", Ref=" + Ref // NOI18N
                + ", Arr=" + Arr // NOI18N
                + ", Fun=" + Fun // NOI18N
                + ", Cls=" + Cls // NOI18N
                + ", Mem=" + Mem // NOI18N
                + ", PipeInfo=" + PipeInfo; // NOI18N
    }
  };
  public Unnamed_union11 Unnamed_field3 = new Unnamed_union11();
  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::destroy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1453,
   FQN="clang::DeclaratorChunk::destroy", NM="_ZN5clang15DeclaratorChunk7destroyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk7destroyEv")
  //</editor-fold>
  public void destroy() {
    switch (Kind) {
     case Function:
      Unnamed_field3.Fun.destroy();
      return;
     case Pointer:
      Unnamed_field3.Ptr.destroy();
      return;
     case BlockPointer:
      Unnamed_field3.Cls.destroy();
      return;
     case Reference:
      Unnamed_field3.Ref.destroy();
      return;
     case Array:
      Unnamed_field3.Arr.destroy();
      return;
     case MemberPointer:
      Unnamed_field3.Mem.destroy();
      return;
     case Paren:
      return;
     case Pipe:
      Unnamed_field3.PipeInfo.destroy();
      return;
    }
  }

  
  /// \brief If there are attributes applied to this declaratorchunk, return
  /// them.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::getAttrs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1468,
   FQN="clang::DeclaratorChunk::getAttrs", NM="_ZNK5clang15DeclaratorChunk8getAttrsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang15DeclaratorChunk8getAttrsEv")
  //</editor-fold>
  public /*const*/ AttributeList /*P*/ getAttrs() /*const*/ {
    return Unnamed_field3.Common.AttrList;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::getAttrListRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1472,
   FQN="clang::DeclaratorChunk::getAttrListRef", NM="_ZN5clang15DeclaratorChunk14getAttrListRefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk14getAttrListRefEv")
  //</editor-fold>
  public type$ref<AttributeList/*P*/>/*&*/ getAttrListRef() {
    return Unnamed_field3.Common.AttrList$Ref;
  }

  
  /// \brief Return a DeclaratorChunk for a pointer.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::getPointer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*accessors*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1477,
   FQN="clang::DeclaratorChunk::getPointer", NM="_ZN5clang15DeclaratorChunk10getPointerEjNS_14SourceLocationES1_S1_S1_S1_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk10getPointerEjNS_14SourceLocationES1_S1_S1_S1_S1_")
  //</editor-fold>
  public static DeclaratorChunk getPointer(/*uint*/int TypeQuals, SourceLocation Loc, 
            SourceLocation ConstQualLoc, 
            SourceLocation VolatileQualLoc, 
            SourceLocation RestrictQualLoc, 
            SourceLocation AtomicQualLoc, 
            SourceLocation UnalignedQualLoc) {
    DeclaratorChunk I/*J*/= new DeclaratorChunk();
    I.Kind = Unnamed_enum.Pointer;
    I.Loc.$assign(Loc);
    I.Unnamed_field3.Ptr.TypeQuals = $uint2uint_5bits(TypeQuals);
    I.Unnamed_field3.Ptr.ConstQualLoc = ConstQualLoc.getRawEncoding();
    I.Unnamed_field3.Ptr.VolatileQualLoc = VolatileQualLoc.getRawEncoding();
    I.Unnamed_field3.Ptr.RestrictQualLoc = RestrictQualLoc.getRawEncoding();
    I.Unnamed_field3.Ptr.AtomicQualLoc = AtomicQualLoc.getRawEncoding();
    I.Unnamed_field3.Ptr.UnalignedQualLoc = UnalignedQualLoc.getRawEncoding();
    I.Unnamed_field3.Ptr.$setAttrList(null);
    return I;
  }

  
  /// \brief Return a DeclaratorChunk for a reference.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::getReference">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*accessors*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1497,
   FQN="clang::DeclaratorChunk::getReference", NM="_ZN5clang15DeclaratorChunk12getReferenceEjNS_14SourceLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk12getReferenceEjNS_14SourceLocationEb")
  //</editor-fold>
  public static DeclaratorChunk getReference(/*uint*/int TypeQuals, SourceLocation Loc, 
              boolean lvalue) {
    DeclaratorChunk I/*J*/= new DeclaratorChunk();
    I.Kind = Unnamed_enum.Reference;
    I.Loc.$assign(Loc);
    I.Unnamed_field3.Ref.HasRestrict = (TypeQuals & DeclSpec.TQ.TQ_restrict.getValue()) != 0;
    I.Unnamed_field3.Ref.LValueRef = lvalue;
    I.Unnamed_field3.Ref.$setAttrList(null);
    return I;
  }

  
  /// \brief Return a DeclaratorChunk for an array.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::getArray">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*accessors*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1509,
   FQN="clang::DeclaratorChunk::getArray", NM="_ZN5clang15DeclaratorChunk8getArrayEjbbPNS_4ExprENS_14SourceLocationES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk8getArrayEjbbPNS_4ExprENS_14SourceLocationES3_")
  //</editor-fold>
  public static DeclaratorChunk getArray(/*uint*/int TypeQuals, 
          boolean isStatic, boolean isStar, Expr /*P*/ NumElts, 
          SourceLocation LBLoc, SourceLocation RBLoc) {
    DeclaratorChunk I/*J*/= new DeclaratorChunk();
    I.Kind = Unnamed_enum.Array;
    I.Loc.$assign(LBLoc);
    I.EndLoc.$assign(RBLoc);
    I.Unnamed_field3.Arr.$setAttrList(null);
    I.Unnamed_field3.Arr.TypeQuals = $uint2uint_5bits(TypeQuals);
    I.Unnamed_field3.Arr.hasStatic = isStatic;
    I.Unnamed_field3.Arr.isStar = isStar;
    I.Unnamed_field3.Arr.NumElts = NumElts;
    return I;
  }

  
  /// DeclaratorChunk::getFunction - Return a DeclaratorChunk for a function.
  /// "TheDeclarator" is the declarator that this will be added to.
  
  /// DeclaratorChunk::getFunction - Return a DeclaratorChunk for a function.
  /// "TheDeclarator" is the declarator that this will be added to.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::getFunction">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 152,
   FQN="clang::DeclaratorChunk::getFunction", NM="_ZN5clang15DeclaratorChunk11getFunctionEbbNS_14SourceLocationEPNS0_9ParamInfoEjS1_S1_jbS1_S1_S1_S1_S1_NS_26ExceptionSpecificationTypeENS_11SourceRangeEPNS_9OpaquePtrINS_8QualTypeEEEPS5_jPNS_4ExprEPN4llvm11SmallVectorINS_5TokenELj4EEES1_S1_RNS_10DeclaratorENS_12ActionResultIS8_Lb0EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk11getFunctionEbbNS_14SourceLocationEPNS0_9ParamInfoEjS1_S1_jbS1_S1_S1_S1_S1_NS_26ExceptionSpecificationTypeENS_11SourceRangeEPNS_9OpaquePtrINS_8QualTypeEEEPS5_jPNS_4ExprEPN4llvm11SmallVectorINS_5TokenELj4EEES1_S1_RNS_10DeclaratorENS_12ActionResultIS8_Lb0EEE")
  //</editor-fold>
  public static DeclaratorChunk getFunction(boolean hasProto, 
             boolean isAmbiguous, 
             SourceLocation LParenLoc, 
             type$ptr<ParamInfo>/*P*/ Params, 
             /*uint*/int NumParams, 
             SourceLocation EllipsisLoc, 
             SourceLocation RParenLoc, 
             /*uint*/int TypeQuals, 
             boolean RefQualifierIsLvalueRef, 
             SourceLocation RefQualifierLoc, 
             SourceLocation ConstQualifierLoc, 
             SourceLocation VolatileQualifierLoc, 
             SourceLocation RestrictQualifierLoc, 
             SourceLocation MutableLoc, 
             ExceptionSpecificationType ESpecType, 
             SourceRange ESpecRange, 
             type$ptr<OpaquePtr<QualType>> /*P*/ Exceptions, 
             type$ptr<SourceRange> ExceptionRanges, 
             /*uint*/int NumExceptions, 
             Expr /*P*/ NoexceptExpr, 
             SmallVectorToken /*P*/ ExceptionSpecTokens, 
             SourceLocation LocalRangeBegin, 
             SourceLocation LocalRangeEnd, 
             final Declarator /*&*/ TheDeclarator) {
    return getFunction(hasProto, 
             isAmbiguous, 
             LParenLoc, 
             Params, 
             NumParams, 
             EllipsisLoc, 
             RParenLoc, 
             TypeQuals, 
             RefQualifierIsLvalueRef, 
             RefQualifierLoc, 
             ConstQualifierLoc, 
             VolatileQualifierLoc, 
             RestrictQualifierLoc, 
             MutableLoc, 
             ESpecType, 
             ESpecRange, 
             Exceptions, 
             ExceptionRanges, 
             NumExceptions, 
             NoexceptExpr, 
             ExceptionSpecTokens, 
             LocalRangeBegin, 
             LocalRangeEnd, 
             TheDeclarator, 
             new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, new OpaquePtr<QualType>()));// ActionResult for POD type must be initied
  }
  public static DeclaratorChunk getFunction(boolean hasProto, 
             boolean isAmbiguous, 
             SourceLocation LParenLoc, 
             type$ptr<ParamInfo>/*P*/ Params, 
             /*uint*/int NumParams, 
             SourceLocation EllipsisLoc, 
             SourceLocation RParenLoc, 
             /*uint*/int TypeQuals, 
             boolean RefQualifierIsLvalueRef, 
             SourceLocation RefQualifierLoc, 
             SourceLocation ConstQualifierLoc, 
             SourceLocation VolatileQualifierLoc, 
             SourceLocation RestrictQualifierLoc, 
             SourceLocation MutableLoc, 
             ExceptionSpecificationType ESpecType, 
             SourceRange ESpecRange, 
             type$ptr<OpaquePtr<QualType>> /*P*/ Exceptions, 
             type$ptr<SourceRange> /*P*/ ExceptionRanges, 
             /*uint*/int NumExceptions, 
             Expr /*P*/ NoexceptExpr, 
             SmallVectorToken /*P*/ ExceptionSpecTokens, 
             SourceLocation LocalRangeBegin, 
             SourceLocation LocalRangeEnd, 
             final Declarator /*&*/ TheDeclarator, 
             ActionResult<OpaquePtr<QualType> > TrailingReturnType/*= TypeResult()*/) {
    assert (!((TypeQuals & DeclSpec.TQ.TQ_atomic.getValue()) != 0)) : "function cannot have _Atomic qualifier";
    
    DeclaratorChunk I/*J*/= new DeclaratorChunk();
    I.Kind = Unnamed_enum.Function;
    I.Loc.$assign(LocalRangeBegin);
    I.EndLoc.$assign(LocalRangeEnd);
    I.Unnamed_field3.Fun.$setAttrList(null);
    I.Unnamed_field3.Fun.hasPrototype = hasProto;
    I.Unnamed_field3.Fun.isVariadic = EllipsisLoc.isValid();
    I.Unnamed_field3.Fun.isAmbiguous = isAmbiguous;
    I.Unnamed_field3.Fun.LParenLoc = LParenLoc.getRawEncoding();
    I.Unnamed_field3.Fun.EllipsisLoc = EllipsisLoc.getRawEncoding();
    I.Unnamed_field3.Fun.RParenLoc = RParenLoc.getRawEncoding();
    I.Unnamed_field3.Fun.DeleteParams = false;
    I.Unnamed_field3.Fun.TypeQuals = $uint2uint_4bits(TypeQuals);
    I.Unnamed_field3.Fun.NumParams = NumParams;
    I.Unnamed_field3.Fun.Params = null;
    I.Unnamed_field3.Fun.RefQualifierIsLValueRef = RefQualifierIsLvalueRef;
    I.Unnamed_field3.Fun.RefQualifierLoc = RefQualifierLoc.getRawEncoding();
    I.Unnamed_field3.Fun.ConstQualifierLoc = ConstQualifierLoc.getRawEncoding();
    I.Unnamed_field3.Fun.VolatileQualifierLoc = VolatileQualifierLoc.getRawEncoding();
    I.Unnamed_field3.Fun.RestrictQualifierLoc = RestrictQualifierLoc.getRawEncoding();
    I.Unnamed_field3.Fun.MutableLoc = MutableLoc.getRawEncoding();
    I.Unnamed_field3.Fun.ExceptionSpecType = $uint2uint_4bits(ESpecType.getValue());
    I.Unnamed_field3.Fun.ExceptionSpecLocBeg = ESpecRange.getBegin().getRawEncoding();
    I.Unnamed_field3.Fun.ExceptionSpecLocEnd = ESpecRange.getEnd().getRawEncoding();
    I.Unnamed_field3.Fun.NumExceptions = 0;
    I.Unnamed_field3.Fun.Unnamed_field21.Exceptions = null;
    I.Unnamed_field3.Fun.Unnamed_field21.NoexceptExpr = null;
    I.Unnamed_field3.Fun.HasTrailingReturnType = TrailingReturnType.isUsable()
       || TrailingReturnType.isInvalid();
    I.Unnamed_field3.Fun.TrailingReturnType.$assign(TrailingReturnType.get());
    assert (I.Unnamed_field3.Fun.TypeQuals == $uint2uint_4bits(TypeQuals)) : "bitfield overflow";
    assert (I.Unnamed_field3.Fun.ExceptionSpecType == $int2uint_4bits(ESpecType.getValue())) : "bitfield overflow";
    
    // new[] a parameter array if needed.
    if ((NumParams != 0)) {
      // If the 'InlineParams' in Declarator is unused and big enough, put our
      // parameter list there (in an effort to avoid new/delete traffic).  If it
      // is already used (consider a function returning a function pointer) or too
      // small (function with too many parameters), go to the heap.
      if (!TheDeclarator.InlineParamsUsed
         && $lesseq_uint(NumParams, llvm.array_lengthof(TheDeclarator.InlineParams))) {
        I.Unnamed_field3.Fun.Params = create_type$ptr(TheDeclarator.InlineParams);
        I.Unnamed_field3.Fun.DeleteParams = false;
        TheDeclarator.InlineParamsUsed = true;
      } else {
        I.Unnamed_field3.Fun.Params = create_type$ptr(new$T(new DeclaratorChunk.ParamInfo [NumParams],()->new DeclaratorChunk.ParamInfo()));
        I.Unnamed_field3.Fun.DeleteParams = true;
      }
      if (false) {
        memcpy(I.Unnamed_field3.Fun.Params, Params, (true/*java*/ ? 1 : $sizeof_ParamInfo()) * NumParams, false);
      } else {
        // JAVA
        for (int i = 0; i < NumParams; i++) {
          I.Unnamed_field3.Fun.Params.$at(i).$assign(Params.$at(i));
        }
      }
    }
    
    // Check what exception specification information we should actually store.
    switch (ESpecType) {
     default:
      break; // By default, save nothing.
     case EST_Dynamic:
      // new[] an exception array if needed
      if ((NumExceptions != 0)) {
        I.Unnamed_field3.Fun.NumExceptions = NumExceptions;
        I.Unnamed_field3.Fun.Unnamed_field21.Exceptions = create_type$ptr(new$T(new DeclaratorChunk.TypeAndRange [NumExceptions], DeclaratorChunk.TypeAndRange::new));
        for (/*uint*/int i = 0; i != NumExceptions; ++i) {
          I.Unnamed_field3.Fun.Unnamed_field21.Exceptions.$at(i).Ty.$assign(Exceptions.$at(i));
          I.Unnamed_field3.Fun.Unnamed_field21.Exceptions.$at(i).Range.$assign(ExceptionRanges.$at(i));
        }
      }
      break;
     case EST_ComputedNoexcept:
      I.Unnamed_field3.Fun.Unnamed_field21.NoexceptExpr = NoexceptExpr;
      break;
     case EST_Unparsed:
      I.Unnamed_field3.Fun.Unnamed_field21.ExceptionSpecTokens = ExceptionSpecTokens;
      break;
    }
    return I;
  }

  
  /// \brief Return a DeclaratorChunk for a block.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::getBlockPointer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*accessors*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1553,
   FQN="clang::DeclaratorChunk::getBlockPointer", NM="_ZN5clang15DeclaratorChunk15getBlockPointerEjNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk15getBlockPointerEjNS_14SourceLocationE")
  //</editor-fold>
  public static DeclaratorChunk getBlockPointer(/*uint*/int TypeQuals, 
                 SourceLocation Loc) {
    DeclaratorChunk I/*J*/= new DeclaratorChunk();
    I.Kind = Unnamed_enum.BlockPointer;
    I.Loc.$assign(Loc);
    I.Unnamed_field3.Cls.TypeQuals = $uint2uint_5bits(TypeQuals);
    I.Unnamed_field3.Cls.$setAttrList(null);
    return I;
  }

  
  /// \brief Return a DeclaratorChunk for a block.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::getPipe">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1564,
   FQN="clang::DeclaratorChunk::getPipe", NM="_ZN5clang15DeclaratorChunk7getPipeEjNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk7getPipeEjNS_14SourceLocationE")
  //</editor-fold>
  public static DeclaratorChunk getPipe(/*uint*/int TypeQuals, 
         SourceLocation Loc) {
    DeclaratorChunk I/*J*/= new DeclaratorChunk();
    I.Kind = Unnamed_enum.Pipe;
    I.Loc.$assign(Loc);
    I.Unnamed_field3.Cls.TypeQuals = $uint2uint_5bits(TypeQuals);
    I.Unnamed_field3.Cls.$setAttrList(null);
    return I;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::getMemberPointer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Mem init, accessors*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1574,
   FQN="clang::DeclaratorChunk::getMemberPointer", NM="_ZN5clang15DeclaratorChunk16getMemberPointerERKNS_12CXXScopeSpecEjNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk16getMemberPointerERKNS_12CXXScopeSpecEjNS_14SourceLocationE")
  //</editor-fold>
  public static DeclaratorChunk getMemberPointer(final /*const*/ CXXScopeSpec /*&*/ SS, 
                  /*uint*/int TypeQuals, 
                  SourceLocation Loc) {
    DeclaratorChunk I/*J*/= new DeclaratorChunk();
    I.Kind = Unnamed_enum.MemberPointer;
    I.Loc.$assignMove(SS.getBeginLoc());
    I.EndLoc.$assign(Loc);
    I.Unnamed_field3.Mem.TypeQuals = $uint2uint_5bits(TypeQuals);
    I.Unnamed_field3.Mem.$setAttrList(null);
    I.Unnamed_field3.Mem.ScopeMem.Mem.$MemoryCopy(SS);
    return I;
  }

  
  /// \brief Return a DeclaratorChunk for a paren.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::getParen">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1588,
   FQN="clang::DeclaratorChunk::getParen", NM="_ZN5clang15DeclaratorChunk8getParenENS_14SourceLocationES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunk8getParenENS_14SourceLocationES1_")
  //</editor-fold>
  public static DeclaratorChunk getParen(SourceLocation LParenLoc, 
          SourceLocation RParenLoc) {
    DeclaratorChunk I/*J*/= new DeclaratorChunk();
    I.Kind = Unnamed_enum.Paren;
    I.Loc.$assign(LParenLoc);
    I.EndLoc.$assign(RParenLoc);
    I.Unnamed_field3.Common.AttrList = null;
    return I;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::isParen">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1598,
   FQN="clang::DeclaratorChunk::isParen", NM="_ZNK5clang15DeclaratorChunk7isParenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang15DeclaratorChunk7isParenEv")
  //</editor-fold>
  public boolean isParen() /*const*/ {
    return Kind == Unnamed_enum.Paren;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::DeclaratorChunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1101,
   FQN="clang::DeclaratorChunk::DeclaratorChunk", NM="_ZN5clang15DeclaratorChunkC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunkC1Ev")
  //</editor-fold>
  public /*inline*/ DeclaratorChunk() {
    // : Loc(), EndLoc() 
    //START JInit
    this.Loc = new SourceLocation();
    this.EndLoc = new SourceLocation();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::DeclaratorChunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1101,
   FQN="clang::DeclaratorChunk::DeclaratorChunk", NM="_ZN5clang15DeclaratorChunkC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunkC1EOS0_")
  //</editor-fold>
  public /*inline*/ DeclaratorChunk(JD$Move _dparam, final DeclaratorChunk /*&&*/$Prm0) {
    // : Kind(static_cast<DeclaratorChunk &&>().Kind), Loc(static_cast<DeclaratorChunk &&>().Loc), EndLoc(static_cast<DeclaratorChunk &&>().EndLoc), Unnamed_field3(static_cast<DeclaratorChunk &&>().) 
    //START JInit
    this.Kind = $Prm0.Kind;
    this.Loc = new SourceLocation(JD$Move.INSTANCE, $Prm0.Loc);
    this.EndLoc = new SourceLocation(JD$Move.INSTANCE, $Prm0.EndLoc);
    this.Unnamed_field3 = new Unnamed_union11(JD$Move.INSTANCE, $Prm0.Unnamed_field3);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1101,
   FQN="clang::DeclaratorChunk::operator=", NM="_ZN5clang15DeclaratorChunkaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunkaSERKS0_")
  //</editor-fold>
  public /*inline*/ DeclaratorChunk /*&*/ $assign(final /*const*/ DeclaratorChunk /*&*/ $Prm0) {
    this.Kind = $Prm0.Kind;
    this.Loc.$assign($Prm0.Loc);
    this.EndLoc.$assign($Prm0.EndLoc);
    this.Unnamed_field3.$assign($Prm0.Unnamed_field3);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1101,
   FQN="clang::DeclaratorChunk::operator=", NM="_ZN5clang15DeclaratorChunkaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang15DeclaratorChunkaSEOS0_")
  //</editor-fold>
  public /*inline*/ DeclaratorChunk /*&*/ $assignMove(final DeclaratorChunk /*&&*/$Prm0) {
    this.Kind = $Prm0.Kind;
    this.Loc.$assignMove($Prm0.Loc);
    this.EndLoc.$assignMove($Prm0.EndLoc);
    this.Unnamed_field3.$assignMove($Prm0.Unnamed_field3);
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::~DeclaratorChunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1101,
   FQN="clang::DeclaratorChunk::~DeclaratorChunk", NM="_ZN5clang15DeclaratorChunkD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang15DeclaratorChunkD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorChunk::DeclaratorChunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1101,
   FQN="clang::DeclaratorChunk::DeclaratorChunk", NM="_ZN5clang15DeclaratorChunkC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang15DeclaratorChunkC1ERKS0_")
  //</editor-fold>
  public /*inline*/ DeclaratorChunk(final /*const*/ DeclaratorChunk /*&*/ $Prm0) {
    // : Kind(.Kind), Loc(.Loc), EndLoc(.EndLoc), Unnamed_field3(.) 
    //START JInit
    this.Kind = $Prm0.Kind;
    this.Loc = new SourceLocation($Prm0.Loc);
    this.EndLoc = new SourceLocation($Prm0.EndLoc);
    this.Unnamed_field3 = new Unnamed_union11($Prm0.Unnamed_field3);
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", EndLoc=" + EndLoc // NOI18N
              + ", Unnamed_field3=" + Unnamed_field3; // NOI18N
  }
}
