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

package org.clang.lex;

import org.clank.support.*;
import org.clang.basic.*;
import static org.clang.lex.PreprocessingRecordGlobals.*;

/// \brief Base class that describes a preprocessed entity, which may be a
/// preprocessor directive or macro expansion.
//<editor-fold defaultstate="collapsed" desc="clang::PreprocessedEntity">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 48,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", old_line = 47,
 FQN="clang::PreprocessedEntity", NM="_ZN5clang18PreprocessedEntityE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang18PreprocessedEntityE")
//</editor-fold>
public class PreprocessedEntity {
/*public:*/
  /// \brief The kind of preprocessed entity an object describes.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessedEntity::EntityKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 51,
   FQN="clang::PreprocessedEntity::EntityKind", NM="_ZN5clang18PreprocessedEntity10EntityKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang18PreprocessedEntity10EntityKindE")
  //</editor-fold>
  public enum EntityKind implements Native.ComparableLower {
    /// \brief Indicates a problem trying to load the preprocessed entity.
    InvalidKind(0),
    
    /// \brief A macro expansion.
    MacroExpansionKind(InvalidKind.getValue() + 1),
    
    /// \defgroup Preprocessing directives
    /// @{
    
    /// \brief A macro definition.
    MacroDefinitionKind(MacroExpansionKind.getValue() + 1),
    
    /// \brief An inclusion directive, such as \c \#include, \c
    /// \#import, or \c \#include_next.
    InclusionDirectiveKind(MacroDefinitionKind.getValue() + 1),
    
    /// @}
    FirstPreprocessingDirective(EntityKind.MacroDefinitionKind.getValue()),
    LastPreprocessingDirective(EntityKind.InclusionDirectiveKind.getValue());

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static EntityKind valueOf(int val) {
      EntityKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final EntityKind[] VALUES;
      private static final EntityKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (EntityKind kind : EntityKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new EntityKind[min < 0 ? (1-min) : 0];
        VALUES = new EntityKind[max >= 0 ? (1+max) : 0];
        for (EntityKind kind : EntityKind.values()) {
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
    private EntityKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((EntityKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((EntityKind)obj).value);}
    //</editor-fold>
  };
/*private:*/
  /// \brief The kind of preprocessed entity that this object describes.
  private EntityKind Kind;
  
  /// \brief The source range that covers this preprocessed entity.
  private SourceRange Range;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessedEntity::PreprocessedEntity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 82,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", old_line = 81,
   FQN="clang::PreprocessedEntity::PreprocessedEntity", NM="_ZN5clang18PreprocessedEntityC1ENS0_10EntityKindENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang18PreprocessedEntityC1ENS0_10EntityKindENS_11SourceRangeE")
  //</editor-fold>
  protected PreprocessedEntity(EntityKind Kind, SourceRange Range) {
    /* : Kind(Kind), Range(Range)*/ 
    //START JInit
    this.Kind = Kind;
    this.Range = new SourceRange(Range);
    //END JInit
  }

  
  /*friend  class PreprocessingRecord*/
/*public:*/
  /// \brief Retrieve the kind of preprocessed entity stored in this object.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessedEntity::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 89,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", old_line = 88,
   FQN="clang::PreprocessedEntity::getKind", NM="_ZNK5clang18PreprocessedEntity7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZNK5clang18PreprocessedEntity7getKindEv")
  //</editor-fold>
  public EntityKind getEntityKind() /*const*/ {
    return Kind;
  }

  
  /// \brief Retrieve the source range that covers this entire preprocessed 
  /// entity.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessedEntity::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 93,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", old_line = 92,
   FQN="clang::PreprocessedEntity::getSourceRange", NM="_ZNK5clang18PreprocessedEntity14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZNK5clang18PreprocessedEntity14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*//* __attribute__((pure))*/ {
    return Range;
  }

  
  /// \brief Returns true if there was a problem loading the preprocessed
  /// entity.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessedEntity::isInvalid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 97,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", old_line = 96,
   FQN="clang::PreprocessedEntity::isInvalid", NM="_ZNK5clang18PreprocessedEntity9isInvalidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZNK5clang18PreprocessedEntity9isInvalidEv")
  //</editor-fold>
  public boolean isInvalid() /*const*/ {
    return Kind == EntityKind.InvalidKind;
  }

  
  // Only allow allocation of preprocessed entities using the allocator 
  // in PreprocessingRecord or by doing a placement new.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessedEntity::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 101,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", old_line = 100,
   FQN="clang::PreprocessedEntity::operator new", NM="_ZN5clang18PreprocessedEntitynwEjRNS_19PreprocessingRecordEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang18PreprocessedEntitynwEjRNS_19PreprocessingRecordEj")
  //</editor-fold>
  public static Object/*void P*/ $new(/*size_t*/int bytes, PreprocessingRecord /*&*/ PR) {
    return $new(bytes, PR, 
      8);
  }
  public static Object/*void P*/ $new(/*size_t*/int bytes, PreprocessingRecord /*&*/ PR, 
      /*uint*/int alignment/*= 8*/) {
    return /*::*/$new_uint_PreprocessingRecord_uint(bytes, PR, alignment);
  }
  public static <T> T $new(PreprocessingRecord /*&*/ PR, NativeCallback.New$ConstructorCallback<T> supplier) {
    return supplier.$call(null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessedEntity::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 106,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", old_line = 105,
   FQN="clang::PreprocessedEntity::operator new", NM="_ZN5clang18PreprocessedEntitynwEjPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang18PreprocessedEntitynwEjPv")
  //</editor-fold>
  public static Object/*void P*/ $new(/*size_t*/int bytes, Object/*void P*/ mem) {
    return mem;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessedEntity::operator delete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 108,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", old_line = 109,
   FQN="clang::PreprocessedEntity::operator delete", NM="_ZN5clang18PreprocessedEntitydlEPvRNS_19PreprocessingRecordEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang18PreprocessedEntitydlEPvRNS_19PreprocessingRecordEj")
  //</editor-fold>
  public static void $delete(Object/*void P*/ ptr, PreprocessingRecord /*&*/ PR, 
         /*uint*/int alignment) {
    /*::*/$delete_Object_PreprocessingRecord_uint(ptr, PR, alignment);
    return;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessedEntity::operator delete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 113,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", old_line = 114,
   FQN="clang::PreprocessedEntity::operator delete", NM="_ZN5clang18PreprocessedEntitydlEPvj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang18PreprocessedEntitydlEPvj")
  //</editor-fold>
  public static void $delete(Object/*void P*/ $Prm0, /*uint*/int $Prm1) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessedEntity::operator delete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 114,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", old_line = 115,
   FQN="clang::PreprocessedEntity::operator delete", NM="_ZN5clang18PreprocessedEntitydlEPvS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang18PreprocessedEntitydlEPvS1_")
  //</editor-fold>
  public static void $delete(Object/*void P*/ $Prm0, Object/*void P*/ $Prm1) {
  }

/*private:*/
  // Make vanilla 'new' and 'delete' illegal for preprocessed entities.
  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessedEntity::operator new">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 118,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", old_line = 119,
   FQN="clang::PreprocessedEntity::operator new", NM="_ZN5clang18PreprocessedEntitynwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang18PreprocessedEntitynwEj")
  //</editor-fold>
  private static Object/*void P*/ $new(/*size_t*/int bytes)/* throw()*/ {throw new IllegalStateException();}


  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessedEntity::operator delete">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 119,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", old_line = 120,
   FQN="clang::PreprocessedEntity::operator delete", NM="_ZN5clang18PreprocessedEntitydlEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang18PreprocessedEntitydlEPv")
  //</editor-fold>
  private static void $delete(Object/*void P*/ data)/* throw()*/ {throw new IllegalStateException();}

  
  public String toString() {
    return this.getClass().getSimpleName() + "{Kind=" + Kind // NOI18N
              + ", Range=" + Range + '}'; // NOI18N
  }
}
