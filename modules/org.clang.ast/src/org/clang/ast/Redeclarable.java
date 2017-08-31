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
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.ast.java.AstJavaDifferentiators.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

/// \brief Provides common interface for the Decls that can be redeclared.
/*template <typename decl_type> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::Redeclarable">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 26,
 FQN="clang::Redeclarable", NM="_ZN5clang12RedeclarableE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang12RedeclarableE")
//</editor-fold>
public interface/*class*/ Redeclarable</*typename*/ decl_type extends Decl & Redeclarable>  {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::DeclLink">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 29,
   FQN="clang::Redeclarable::DeclLink", NM="_ZN5clang12Redeclarable8DeclLinkE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang12Redeclarable8DeclLinkE")
  //</editor-fold>
  public/*protected*/ static class DeclLink<decl_type extends Decl & Redeclarable> {
    /// A pointer to a known latest declaration, either statically known or
    /// generationally updated as decls are added by an external source.
    /*typedef LazyGenerationalUpdatePtr<const Decl *, Decl *, &ExternalASTSource::CompleteRedeclChain> KnownLatest*/
//    public final class KnownLatest extends LazyGenerationalUpdatePtr</*const*/ Decl /*P*/ , Decl /*P*/ , /*AddrOf*/ExternalASTSource.CompleteRedeclChain>{ };
    
    /// We store a pointer to the ASTContext in the UninitializedLatest
    /// pointer, but to avoid circular type dependencies when we steal the low
    /// bits of this pointer, we use a raw void* here.
    /*typedef const void *UninitializedLatest*/;
    
    /*typedef Decl *Previous*/
//    public final class Previous extends Decl /*P*/ { };
    
    /// A pointer to either an uninitialized latest declaration (where either
    /// we've not yet set the previous decl or there isn't one), or to a known
    /// previous declaration.
    /*typedef llvm::PointerUnion<Previous, UninitializedLatest> NotKnownLatest*/
//    public final class NotKnownLatest extends PointerUnion<Decl /*P*/ , /*const*/Object/*void P*/ >{ };
    
    private final /*mutable */PointerUnion<PointerUnion<Decl /*P*/ , /*const*/Object/*void P*/ >, LazyGenerationalUpdatePtr</*const*/ Decl /*P*/ , Decl /*P*/> > Next;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::DeclLink::PreviousTag">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 51,
     FQN="clang::Redeclarable::DeclLink::PreviousTag", NM="_ZN5clang12Redeclarable8DeclLink11PreviousTagE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang12Redeclarable8DeclLink11PreviousTagE")
    //</editor-fold>
    public enum PreviousTag implements Native.ComparableLower {
      PreviousLink(0);

      //<editor-fold defaultstate="collapsed" desc="hidden">
//      public static PreviousTag valueOf(/*<dependent type>*/int val) {
//        PreviousTag out = valueOf((int)val);
//        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]. Int not capable to keep values?";
//        return out;
//      }
      public static PreviousTag valueOf(int val) {
        PreviousTag out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final PreviousTag[] VALUES;
        private static final PreviousTag[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (PreviousTag kind : PreviousTag.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new PreviousTag[min < 0 ? (1-min) : 0];
          VALUES = new PreviousTag[max >= 0 ? (1+max) : 0];
          for (PreviousTag kind : PreviousTag.values()) {
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

      private final /*<dependent type>uint*/int value;
      private PreviousTag(int val) { this.value = (/*<dependent type>*/int)val;}
      public /*<dependent type>*/int getValue() { return value;}
      @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((PreviousTag)obj).value);}
      @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((PreviousTag)obj).value);}
      //</editor-fold>
    };
    //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::DeclLink::LatestTag">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 52,
     FQN="clang::Redeclarable::DeclLink::LatestTag", NM="_ZN5clang12Redeclarable8DeclLink9LatestTagE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang12Redeclarable8DeclLink9LatestTagE")
    //</editor-fold>
    public enum LatestTag implements Native.ComparableLower {
      LatestLink(0);

      //<editor-fold defaultstate="collapsed" desc="hidden">
//      public static LatestTag valueOf(/*<dependent type>uint*/int val) {
//        LatestTag out = valueOf((int)val);
//        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]. Int not capable to keep values?";
//        return out;
//      }
      public static LatestTag valueOf(int val) {
        LatestTag out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final LatestTag[] VALUES;
        private static final LatestTag[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (LatestTag kind : LatestTag.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new LatestTag[min < 0 ? (1-min) : 0];
          VALUES = new LatestTag[max >= 0 ? (1+max) : 0];
          for (LatestTag kind : LatestTag.values()) {
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

      private final /*<dependent type>uint*/int value;
      private LatestTag(int val) { this.value = (/*<dependent type>uint*/int)val;}
      public /*<dependent type>uint*/int getValue() { return value;}
      @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((LatestTag)obj).value);}
      @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((LatestTag)obj).value);}
      //</editor-fold>
    };
    
    //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::DeclLink::DeclLink">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 54,
     FQN="clang::Redeclarable::DeclLink::DeclLink", NM="_ZN5clang12Redeclarable8DeclLinkC1ENS1_9LatestTagERKNS_10ASTContextE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang12Redeclarable8DeclLinkC1ENS1_9LatestTagERKNS_10ASTContextE")
    //</editor-fold>
    public DeclLink(JD$LatestTag_ASTContext$C _dparam, LatestTag $Prm0, final /*const*/ ASTContext /*&*/ Ctx) {
      // : Next(NotKnownLatest(reinterpret_cast<UninitializedLatest>(&Ctx))) 
      //START JInit
      this.Next = new PointerUnion(JD$T.INSTANCE, PointerUnion.class, new PointerUnion(JD$T1.INSTANCE, /*const*/Object/*void P*/ .class, reinterpret_cast(/*const*/Object/*void P*/ .class, $AddrOf(Ctx))));
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::DeclLink::DeclLink">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 56,
     FQN="clang::Redeclarable::DeclLink::DeclLink", NM="_ZN5clang12Redeclarable8DeclLinkC1ENS1_11PreviousTagEPT_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang12Redeclarable8DeclLinkC1ENS1_11PreviousTagEPT_")
    //</editor-fold>
    public DeclLink(JD$PreviousTag_T$P _dparam, PreviousTag $Prm0, decl_type /*P*/ D) {
      // : Next(NotKnownLatest(Previous(D))) 
      //START JInit
      this.Next = new PointerUnion(JD$T.INSTANCE, PointerUnion.class, new PointerUnion(JD$T.INSTANCE, Decl /*P*/.class, (Decl /*P*/) D));
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::DeclLink::NextIsPrevious">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 59,
     FQN="clang::Redeclarable::DeclLink::NextIsPrevious", NM="_ZNK5clang12Redeclarable8DeclLink14NextIsPreviousEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang12Redeclarable8DeclLink14NextIsPreviousEv")
    //</editor-fold>
    public boolean NextIsPrevious() /*const*/ {
      return Native.$bool(Next.is(PointerUnion.class))
        // FIXME: 'template' is required on the next line due to an
        // apparent clang bug.
         && Native.$bool(Next.get(PointerUnion.class)./*template */is(Decl /*P*/.class));
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::DeclLink::NextIsLatest">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 66,
     FQN="clang::Redeclarable::DeclLink::NextIsLatest", NM="_ZNK5clang12Redeclarable8DeclLink12NextIsLatestEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang12Redeclarable8DeclLink12NextIsLatestEv")
    //</editor-fold>
    public boolean NextIsLatest() /*const*/ {
      return Native.$not(NextIsPrevious());
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::DeclLink::getNext">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*used instantiation*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 68,
     FQN="clang::Redeclarable::DeclLink::getNext", NM="_ZNK5clang12Redeclarable8DeclLink7getNextEPKT_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang12Redeclarable8DeclLink7getNextEPKT_")
    //</editor-fold>
    public decl_type /*P*/ getNext(/*const*/ decl_type /*P*/ D) /*const*/ {
      if ((Next.is(PointerUnion.class) != 0)) {
        PointerUnion<Decl /*P*/ , /*const*/Object/*void P*/ > NKL = Next.get(PointerUnion.class);
        if ((NKL.is(Decl /*P*/.class) != 0)) {
          return ((/*static_cast*/decl_type /*P*/ )(NKL.get(Decl /*P*/.class)));
        }
        
        // Allocate the generational 'most recent' cache now, if needed.
        ((PointerUnion)Next).$assign_T1$C$R(LazyGenerationalUpdatePtr.class, new LazyGenerationalUpdatePtr(/*AddrOf*//*FPtr*/ExternalASTSource::CompleteRedeclChain, $Deref(reinterpret_cast(/*const*/ ASTContext /*P*/ .class, NKL.get(/*const*/Object/*void P*/.class))), 
                ((/*const_cast*/decl_type /*P*/ )(D))));
      }
      
      return ((/*static_cast*/decl_type /*P*/ )(Next.get(LazyGenerationalUpdatePtr.class).get(D)));
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::DeclLink::setPrevious">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*used Serialization/ASTReaderDecl.cpp to see instantiation*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 83,
     FQN="clang::Redeclarable::DeclLink::setPrevious", NM="_ZN5clang12Redeclarable8DeclLink11setPreviousEPT_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang12Redeclarable8DeclLink11setPreviousEPT_")
    //</editor-fold>
    public void setPrevious(decl_type /*P*/ D) {
      assert Native.$bool(NextIsPrevious()) : "decl became non-canonical unexpectedly";
      ((PointerUnion)Next).$assign_T$C$R(PointerUnion.class, new PointerUnion<Decl /*P*/ , /*const*/Object/*void P*/ >(JD$T.INSTANCE, Decl /*P*/ .class, ((Decl /*P*/ )(D))));
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::DeclLink::setLatest">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*used Serialization/ASTReaderDecl.cpp to see instantiation*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 88,
     FQN="clang::Redeclarable::DeclLink::setLatest", NM="_ZN5clang12Redeclarable8DeclLink9setLatestEPT_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang12Redeclarable8DeclLink9setLatestEPT_")
    //</editor-fold>
    public void setLatest(decl_type /*P*/ D) {
      assert (NextIsLatest()) : "decl became canonical unexpectedly";
      if ((Next.is(PointerUnion.class) != 0)) {
        PointerUnion<Decl /*P*/ , /*const*/Object/*void P*/ > NKL = Next.get(PointerUnion.class);
        ((PointerUnion)Next).$assign_T1$C$R(LazyGenerationalUpdatePtr.class, new LazyGenerationalUpdatePtr</*const*/ Decl /*P*/ , Decl /*P*/ >(/*AddrOf*//*FPtr*/ExternalASTSource::CompleteRedeclChain, $Deref(reinterpret_cast(/*const*/ ASTContext /*P*/ .class, NKL.get(/*const*/Object/*void P*/.class))), 
                D));
      } else {
        LazyGenerationalUpdatePtr</*const*/ Decl /*P*/ , Decl /*P*//* , CompleteRedeclChain*/> Latest = Next.get(LazyGenerationalUpdatePtr.class);
        Latest.set(D);
        ((PointerUnion)Next).$assign_T1$C$R(LazyGenerationalUpdatePtr.class, Latest);
      }
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::DeclLink::markIncomplete">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 102,
     FQN="clang::Redeclarable::DeclLink::markIncomplete", NM="_ZN5clang12Redeclarable8DeclLink14markIncompleteEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang12Redeclarable8DeclLink14markIncompleteEv")
    //</editor-fold>
    public void markIncomplete() {
      Next.get(LazyGenerationalUpdatePtr.class).markIncomplete();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::DeclLink::getLatestNotUpdated">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 104,
     FQN="clang::Redeclarable::DeclLink::getLatestNotUpdated", NM="_ZNK5clang12Redeclarable8DeclLink19getLatestNotUpdatedEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang12Redeclarable8DeclLink19getLatestNotUpdatedEv")
    //</editor-fold>
    public Decl /*P*/ getLatestNotUpdated() /*const*/ {
      assert Native.$bool(NextIsLatest()) : "expected a canonical decl";
      if (Next.is(PointerUnion.class) != 0) {
        return null;
      }
      return (Decl)Next.get(LazyGenerationalUpdatePtr.class).getNotUpdated();
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public DeclLink<decl_type> $assignMove(DeclLink<decl_type> $Prm0) { this.Next.$assignMove($Prm0.Next); return this; }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Next=" + Next; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::PreviousDeclLink">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*used Serialization/ASTReaderDecl.cpp to see instantiation*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 112,
   FQN="clang::Redeclarable::PreviousDeclLink", NM="_ZN5clang12Redeclarable16PreviousDeclLinkEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang12Redeclarable16PreviousDeclLinkEPT_")
  //</editor-fold>
  public/*protected*/ /*interface*/ static </*typename*/ decl_type extends Decl & Redeclarable> DeclLink PreviousDeclLink(decl_type /*P*/ D) {
    return new DeclLink(JD$PreviousTag_T$P.INSTANCE, DeclLink.PreviousTag.PreviousLink, D);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::LatestDeclLink">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*used Serialization/ASTReaderDecl.cpp to see instantiation*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 116,
   FQN="clang::Redeclarable::LatestDeclLink", NM="_ZN5clang12Redeclarable14LatestDeclLinkERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang12Redeclarable14LatestDeclLinkERKNS_10ASTContextE")
  //</editor-fold>
  public/*protected*/ /*interface*/ static </*typename*/ decl_type extends Decl & Redeclarable> DeclLink LatestDeclLink(final /*const*/ ASTContext /*&*/ Ctx) {
    return new DeclLink(JD$LatestTag_ASTContext$C.INSTANCE, DeclLink.LatestTag.LatestLink, Ctx);
  }

  
  /// \brief Points to the next redeclaration in the chain.
  ///
  /// If NextIsPrevious() is true, this is a link to the previous declaration
  /// of this same Decl. If NextIsLatest() is true, this is the first
  /// declaration and Link points to the latest declaration. For example:
  ///
  ///  #1 int f(int x, int y = 1); // <pointer to #3, true>
  ///  #2 int f(int x = 0, int y); // <pointer to #1, false>
  ///  #3 int f(int x, int y) { return x + y; } // <pointer to #2, false>
  ///
  /// If there is only one declaration, it is <pointer to self, true>
  // JAVA: COMMENT OUT public DeclLink RedeclLink;
  // JAVA: COMMENT OUT public decl_type /*P*/ First;
  
  //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::getNextRedeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 134,
   FQN="clang::Redeclarable::getNextRedeclaration", NM="_ZNK5clang12Redeclarable20getNextRedeclarationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang12Redeclarable20getNextRedeclarationEv")
  //</editor-fold>
  public/*protected*/ default/*interface*/ decl_type /*P*/ getNextRedeclaration() /*const*/ {
    return $Redeclarable$Fields().RedeclLink.getNext(((/*static_cast*//*const*/ decl_type /*P*/ )(this)));
  }

/*public:*/
  // JAVA: constructor was moved into Redeclarable$Fields above and delegate in extra members below
//  //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::Redeclarable<decl_type>">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 139,
//   FQN="clang::Redeclarable::Redeclarable<decl_type>", NM="_ZN5clang12RedeclarableC1ERKNS_10ASTContextE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang12RedeclarableC1ERKNS_10ASTContextE")
//  //</editor-fold>
//  public default/*interface*/ void $Redeclarable(/*const*/ ASTContext /*&*/ Ctx) {
//    // : RedeclLink(LatestDeclLink(Ctx)), First(static_cast<decl_type * >(this)) 
//    //START JInit
//    this.RedeclLink = /*ParenListExpr*/new DeclLink(LatestDeclLink(Ctx));
//    this.First = /*ParenListExpr*/((/*static_cast*/decl_type /*P*/ )(this));
//    //END JInit
//  }

  
  /// \brief Return the previous declaration of this declaration or NULL if this
  /// is the first declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::getPreviousDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 144,
   FQN="clang::Redeclarable::getPreviousDecl", NM="_ZN5clang12Redeclarable15getPreviousDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang12Redeclarable15getPreviousDeclEv")
  //</editor-fold>
  public default/*interface*/ decl_type /*P*/ getPreviousDecl$Redeclarable() {
    if ($Redeclarable$Fields().RedeclLink.NextIsPrevious()) {
      return this.getNextRedeclaration();
    }
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::getPreviousDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*just redirect to non-const*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 149,
   FQN="clang::Redeclarable::getPreviousDecl", NM="_ZNK5clang12Redeclarable15getPreviousDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang12Redeclarable15getPreviousDeclEv")
  //</editor-fold>
  public default/*interface*/ /*const*/ decl_type /*P*/ getPreviousDecl$Redeclarable$Const() /*const*/ {
    return getPreviousDecl$Redeclarable();
  }

  
  /// \brief Return the first declaration of this declaration or itself if this
  /// is the only declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::getFirstDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 156,
   FQN="clang::Redeclarable::getFirstDecl", NM="_ZN5clang12Redeclarable12getFirstDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang12Redeclarable12getFirstDeclEv")
  //</editor-fold>
  public default/*interface*/ decl_type /*P*/ getFirstDecl() {
    return $Redeclarable$Fields().First;
  }

  
  /// \brief Return the first declaration of this declaration or itself if this
  /// is the only declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::getFirstDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 160,
   FQN="clang::Redeclarable::getFirstDecl", NM="_ZNK5clang12Redeclarable12getFirstDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang12Redeclarable12getFirstDeclEv")
  //</editor-fold>
  public default/*interface*/ /*const*/ decl_type /*P*/ getFirstDecl$Const() /*const*/ {
    return $Redeclarable$Fields().First;
  }

  
  /// \brief True if this is the first declaration in its redeclaration chain.
  //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::isFirstDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 163,
   FQN="clang::Redeclarable::isFirstDecl", NM="_ZNK5clang12Redeclarable11isFirstDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang12Redeclarable11isFirstDeclEv")
  //</editor-fold>
  public default/*interface*/ boolean isFirstDecl$Redeclarable() /*const*/ {
    return $Redeclarable$Fields().RedeclLink.NextIsLatest();
  }

  
  /// \brief Returns the most recent (re)declaration of this declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::getMostRecentDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 166,
   FQN="clang::Redeclarable::getMostRecentDecl", NM="_ZN5clang12Redeclarable17getMostRecentDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang12Redeclarable17getMostRecentDeclEv")
  //</editor-fold>
  public default/*interface*/ decl_type /*P*/ getMostRecentDecl$Redeclarable() {
    return ((Redeclarable<decl_type>)getFirstDecl()).getNextRedeclaration();
  }

  
  /// \brief Returns the most recent (re)declaration of this declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::getMostRecentDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*delegate to non-const*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 171,
   FQN="clang::Redeclarable::getMostRecentDecl", NM="_ZNK5clang12Redeclarable17getMostRecentDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang12Redeclarable17getMostRecentDeclEv")
  //</editor-fold>
  public default/*interface*/ /*const*/ decl_type /*P*/ getMostRecentDecl$Redeclarable$Const() /*const*/ {
    return getMostRecentDecl$Redeclarable();
  }

  
  /// \brief Set the previous declaration. If PrevDecl is NULL, set this as the
  /// first and only declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::setPreviousDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*used instantiation*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3817,
   FQN="clang::Redeclarable::setPreviousDecl", NM="_ZN5clang12Redeclarable15setPreviousDeclEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang12Redeclarable15setPreviousDeclEPT_")
  //</editor-fold>
  public default/*interface*/ void setPreviousDecl(decl_type /*P*/ PrevDecl) {
    // Note: This routine is implemented here because we need both NamedDecl
    // and Redeclarable to be defined.
    assert ($Redeclarable$Fields().RedeclLink.NextIsLatest()) : "setPreviousDecl on a decl already in a redeclaration chain";
    if ((PrevDecl != null)) {
      // Point to previous. Make sure that this is actually the most recent
      // redeclaration, or we can build invalid chains. If the most recent
      // redeclaration is invalid, it won't be PrevDecl, but we want it anyway.
      $Redeclarable$Fields().First = (decl_type)PrevDecl.getFirstDecl();
      assert ($Redeclarable$Fields().First.$Redeclarable$Fields().RedeclLink.NextIsLatest()) : "Expected first";
      decl_type /*P*/ MostRecent = (decl_type)$Redeclarable$Fields().First.getNextRedeclaration();
      $Redeclarable$Fields().RedeclLink.$assignMove(PreviousDeclLink(/*cast_decl_type*/(decl_type)(MostRecent)));
      
      // If the declaration was previously visible, a redeclaration of it remains
      // visible even if it wouldn't be visible by itself.
      ((/*static_cast*/decl_type /*P*/ )(this)).IdentifierNamespace_field |= $uint2uint_13bits(MostRecent.getIdentifierNamespace()
         & (Decl.IdentifierNamespace.IDNS_Ordinary | Decl.IdentifierNamespace.IDNS_Tag | Decl.IdentifierNamespace.IDNS_Type));
    } else {
      // Make this first.
      $Redeclarable$Fields().First = ((/*static_cast*/decl_type /*P*/ )(this));
    }
    
    // First one will point to this one as latest.
    $Redeclarable$Fields().First.$Redeclarable$Fields().RedeclLink.setLatest(((/*static_cast*/decl_type /*P*/ )(this)));
    assert (!isa_NamedDecl(((/*static_cast*/decl_type /*P*/ )(this))) || cast_NamedDecl(((/*static_cast*/decl_type /*P*/ )(this))).isLinkageValid());
  }

  
  /// \brief Iterates through all the redeclarations of the same decl.
  //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::redecl_iterator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 180,
   FQN="clang::Redeclarable::redecl_iterator", NM="_ZN5clang12Redeclarable15redecl_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang12Redeclarable15redecl_iteratorE")
  //</editor-fold>
  public static class redecl_iterator<decl_type extends Decl & Redeclarable> implements type$iterator<redecl_iterator<decl_type>, decl_type> {
    /// Current - The current declaration.
    private decl_type /*P*/ Current;
    private decl_type /*P*/ Starter;
    private boolean PassedFirst;
  /*public:*/
    /*typedef decl_type *value_type*/
//    public final class value_type extends decl_type /*P*/ { };
    /*typedef decl_type *reference*/
//    public final class reference extends decl_type /*P*/ { };
    /*typedef decl_type *pointer*/
//    public final class pointer extends decl_type /*P*/ { };
    /*typedef std::forward_iterator_tag iterator_category*/
//    public final class iterator_category extends std.forward_iterator_tag{ };
    /*typedef std::ptrdiff_t difference_type*/;
    
    //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::redecl_iterator::redecl_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 193,
     FQN="clang::Redeclarable::redecl_iterator::redecl_iterator", NM="_ZN5clang12Redeclarable15redecl_iteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang12Redeclarable15redecl_iteratorC1Ev")
    //</editor-fold>
    public redecl_iterator() {
      // : Current(null) 
      //START JInit
      this.Current = /*ParenListExpr*/null;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::redecl_iterator::redecl_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 194,
     FQN="clang::Redeclarable::redecl_iterator::redecl_iterator", NM="_ZN5clang12Redeclarable15redecl_iteratorC1EPT_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang12Redeclarable15redecl_iteratorC1EPT_")
    //</editor-fold>
    public /*explicit*/ redecl_iterator(decl_type /*P*/ C) {
      // : Current(C), Starter(C), PassedFirst(false) 
      //START JInit
      this.Current = /*ParenListExpr*/C;
      this.Starter = /*ParenListExpr*/C;
      this.PassedFirst = false;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::redecl_iterator::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 197,
     FQN="clang::Redeclarable::redecl_iterator::operator*", NM="_ZNK5clang12Redeclarable15redecl_iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang12Redeclarable15redecl_iteratordeEv")
    //</editor-fold>
    public decl_type /*P*/ $star() /*const*/ {
      return Current;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::redecl_iterator::operator->">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 198,
     FQN="clang::Redeclarable::redecl_iterator::operator->", NM="_ZNK5clang12Redeclarable15redecl_iteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang12Redeclarable15redecl_iteratorptEv")
    //</editor-fold>
    public decl_type /*P*/ $arrow() /*const*/ {
      return Current;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::redecl_iterator::operator++">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*used AST/Decl.cpp to see instantiation*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 200,
     FQN="clang::Redeclarable::redecl_iterator::operator++", NM="_ZN5clang12Redeclarable15redecl_iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang12Redeclarable15redecl_iteratorppEv")
    //</editor-fold>
    public redecl_iterator<decl_type> /*&*/ $preInc() {
      assert ((Current != null)) : "Advancing while iterator has reached end";
      // Sanity check to avoid infinite loop on invalid redecl chain.
      if (Current.isFirstDecl()) {
        if (PassedFirst) {
          assert (false) : "Passed first decl twice, invalid redecl chain!";
          Current = null;
          return /*Deref*/this;
        }
        PassedFirst = true;
      }
      
      // Get either previous decl or latest decl.
      decl_type /*P*/ Next = (decl_type)Current.getNextRedeclaration();
      Current = (Next != Starter) ? Next : null;
      return /*Deref*/this;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::redecl_iterator::operator++">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 218,
     FQN="clang::Redeclarable::redecl_iterator::operator++", NM="_ZN5clang12Redeclarable15redecl_iteratorppEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang12Redeclarable15redecl_iteratorppEi")
    //</editor-fold>
    public redecl_iterator<decl_type> $postInc(int $Prm0) {
      redecl_iterator<decl_type> tmp/*J*/= /*ParenList*/new redecl_iterator(this);
      this.$preInc();
      return tmp;
    }

    
    /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 224,
     FQN="clang::operator==", NM="_ZN5clangeqENS_12Redeclarable15redecl_iteratorES1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clangeqENS_12Redeclarable15redecl_iteratorES1_")
    //</editor-fold>
    public static boolean $eq_redecl_iterator(redecl_iterator<?> x, redecl_iterator<?> y) {
      return Native.$eq(x.Current, y.Current);
    }

    /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 227,
     FQN="clang::operator!=", NM="_ZN5clangneENS_12Redeclarable15redecl_iteratorES1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clangneENS_12Redeclarable15redecl_iteratorES1_")
    //</editor-fold>
    public static boolean $noteq_redecl_iterator(redecl_iterator<?> x, redecl_iterator<?> y) {
      return Native.$noteq(x.Current, y.Current);
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public /*explicit*/ redecl_iterator(redecl_iterator<decl_type> $Prm0) {
      //START JInit
      this.Current = $Prm0.Current;
      this.Starter = $Prm0.Starter;
      this.PassedFirst = $Prm0.PassedFirst;
      //END JInit
    }

    @Override
    public boolean $eq(Object other) {
      return $eq_redecl_iterator(this, (redecl_iterator)other);
    }

    @Override
    public boolean $noteq(Object other) {
      return $noteq_redecl_iterator(this, (redecl_iterator)other);
    }
    
    @Override public redecl_iterator<decl_type> clone() { 
      return new redecl_iterator(this); 
    }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Current=" + Current // NOI18N
                + ", Starter=" + Starter // NOI18N
                + ", PassedFirst=" + PassedFirst; // NOI18N
    }
  };
  
  /*typedef llvm::iterator_range<redecl_iterator> redecl_range*/
//  public final class redecl_range extends iterator_range<decl_type /*P*/ >{ };
  
  /// \brief Returns an iterator range for all the redeclarations of the same
  /// decl. It will iterate at least once (when this decl is the only one).
  //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::redecls">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*used AST/Decl.cpp to see instantiation*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 236,
   FQN="clang::Redeclarable::redecls", NM="_ZNK5clang12Redeclarable7redeclsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang12Redeclarable7redeclsEv")
  //</editor-fold>
  public default/*interface*/ iterator_range<decl_type /*P*/ > redeclarable_redecls() /*const*/ {
    return new iterator_range<decl_type /*P*/ >(
              new redecl_iterator<decl_type>((decl_type)((Object)this)), 
              new redecl_iterator<decl_type>()
           );
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::redecls_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 242,
   FQN="clang::Redeclarable::redecls_begin", NM="_ZNK5clang12Redeclarable13redecls_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang12Redeclarable13redecls_beginEv")
  //</editor-fold>
  public default/*interface*/ redecl_iterator<decl_type> redeclarable_redecls_begin() /*const*/ {
    return (redecl_iterator<decl_type>)this.redeclarable_redecls().begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::redecls_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 243,
   FQN="clang::Redeclarable::redecls_end", NM="_ZNK5clang12Redeclarable11redecls_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang12Redeclarable11redecls_endEv")
  //</editor-fold>
  public default/*interface*/ redecl_iterator<decl_type> redeclarable_redecls_end() /*const*/ {
    return (redecl_iterator<decl_type>)this.redeclarable_redecls().end();
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static class Redeclarable$Fields<decl_type extends Decl & Redeclarable> {
    public/*protected*/ DeclLink<decl_type> RedeclLink;
    public/*protected*/ decl_type /*P*/ First;
  
    //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::Redeclarable<decl_type>">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 139,
     FQN="clang::Redeclarable::Redeclarable<decl_type>", NM="_ZN5clang12RedeclarableC1ERKNS_10ASTContextE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang12RedeclarableC1ERKNS_10ASTContextE")
    //</editor-fold>
    public Redeclarable$Fields(final /*const*/ ASTContext /*&*/ Ctx, decl_type $this) {
      // : RedeclLink(LatestDeclLink(Ctx)), First(static_cast<decl_type * >(this)) 
      //START JInit
      this.RedeclLink = /*ParenListExpr*//*NO_COPY*/LatestDeclLink(Ctx);
      this.First = /*ParenListExpr*/((/*static_cast*/decl_type /*P*/ )($this));
      //END JInit
    }    

    @Override public String toString() {
      return "" + "RedeclLink=" + RedeclLink // NOI18N
                + ", First=" + NativeTrace.getIdentityStr(First); // NOI18N
    }
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  /*private*/ default Redeclarable$Fields<decl_type> $Redeclarable$Fields() {
    throw new UnsupportedOperationException("Why not implemented in derived? Keep what was returned from $Redeclarable in your final field and just return it here.");
  }  
  
  //<editor-fold defaultstate="collapsed" desc="clang::Redeclarable::Redeclarable<decl_type>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Redeclarable.h", line = 139,
   FQN="clang::Redeclarable::Redeclarable<decl_type>", NM="_ZN5clang12RedeclarableC1ERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang12RedeclarableC1ERKNS_10ASTContextE")
  //</editor-fold>
  public/*protected*/ default/*interface*/ Redeclarable$Fields<decl_type> $Redeclarable(final /*const*/ ASTContext /*&*/ Ctx) {
    assert !(this instanceof Mergeable) : "can not be Mergeable and Redeclarable at the same time" + this.getClass();
    // : RedeclLink(LatestDeclLink(Ctx)), First(static_cast<decl_type * >(this)) 
    //START JInit
    return new Redeclarable$Fields(Ctx, (Decl)this);
    //END JInit
  }  
  
  public default void $destroy$Redeclarable() {
  }
  
  //public default/*interface*/ decl_type /*P*/ getFirstDecl() { return getFirstDecl$Redeclarable(); }
  
  //public default/*interface*/ /*const*/ decl_type /*P*/ getFirstDecl$Const() /*const*/ { return getFirstDecl$Redeclarable$Const(); }
  
  public default/*interface*/ decl_type /*P*/ getPreviousDecl() { return getPreviousDecl$Redeclarable(); }
  
  public default/*interface*/ /*const*/ decl_type /*P*/ getPreviousDecl$Const() /*const*/ { return this.getPreviousDecl$Redeclarable$Const(); }
  
  public default/*interface*/ decl_type /*P*/ getMostRecentDecl() { return getMostRecentDecl$Redeclarable(); }
  
  public default/*interface*/ /*const*/ decl_type /*P*/ getMostRecentDecl$Const() /*const*/ { return getMostRecentDecl$Redeclarable$Const(); }
  
  public default/*interface*/ boolean isFirstDecl() /*const*/ { return isFirstDecl$Redeclarable(); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
}
