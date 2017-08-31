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
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.lex.*;


/// \brief Record the location of an inclusion directive, such as an
/// \c \#include or \c \#import statement.
//<editor-fold defaultstate="collapsed" desc="clang::InclusionDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 196,
 FQN="clang::InclusionDirective", NM="_ZN5clang18InclusionDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang18InclusionDirectiveE")
//</editor-fold>
public class InclusionDirective extends /*public*/ PreprocessingDirective {
/*public:*/
  /// \brief The kind of inclusion directives known to the
  /// preprocessor.
  //<editor-fold defaultstate="collapsed" desc="clang::InclusionDirective::InclusionKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 200,
   FQN="clang::InclusionDirective::InclusionKind", NM="_ZN5clang18InclusionDirective13InclusionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang18InclusionDirective13InclusionKindE")
  //</editor-fold>
  public enum InclusionKind implements Native.ComparableLower {
    /// \brief An \c \#include directive.
    Include(0),
    /// \brief An Objective-C \c \#import directive.
    Import(Include.getValue() + 1),
    /// \brief A GNU \c \#include_next directive.
    IncludeNext(Import.getValue() + 1),
    /// \brief A Clang \c \#__include_macros directive.
    IncludeMacros(IncludeNext.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static InclusionKind valueOf(int val) {
      InclusionKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final InclusionKind[] VALUES;
      private static final InclusionKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (InclusionKind kind : InclusionKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new InclusionKind[min < 0 ? (1-min) : 0];
        VALUES = new InclusionKind[max >= 0 ? (1+max) : 0];
        for (InclusionKind kind : InclusionKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private InclusionKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((InclusionKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((InclusionKind)obj).value);}
    //</editor-fold>
  };
/*private:*/
  /// \brief The name of the file that was included, as written in
  /// the source.
  private StringRef FileName;
  
  /// \brief Whether the file name was in quotation marks; otherwise, it was
  /// in angle brackets.
  private /*JBIT unsigned int*/ boolean InQuotes /*: 1*/;
  
  /// \brief The kind of inclusion directive we have.
  ///
  /// This is a value of type InclusionKind.
  private /*JBYTE unsigned int*/ byte Kind /*: 2*/;
  
  /// \brief Whether the inclusion directive was automatically turned into
  /// a module import.
  private /*JBIT unsigned int*/ boolean ImportedModule /*: 1*/;
  
  /// \brief The file that was included.
  private /*const*/ FileEntry /*P*/ File;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::InclusionDirective::InclusionDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 25,
   FQN="clang::InclusionDirective::InclusionDirective", NM="_ZN5clang18InclusionDirectiveC1ERNS_19PreprocessingRecordENS0_13InclusionKindEN4llvm9StringRefEbbPKNS_9FileEntryENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang18InclusionDirectiveC1ERNS_19PreprocessingRecordENS0_13InclusionKindEN4llvm9StringRefEbbPKNS_9FileEntryENS_11SourceRangeE")
  //</editor-fold>
  public InclusionDirective(PreprocessingRecord /*&*/ PPRec, 
      InclusionKind Kind, 
      StringRef FileName, 
      boolean InQuotes, boolean ImportedModule, 
      /*const*/ FileEntry /*P*/ File, 
      SourceRange Range) {
    /* : PreprocessingDirective(InclusionDirectiveKind, Range), FileName(), InQuotes(InQuotes), Kind(Kind), ImportedModule(ImportedModule), File(File)*/ 
    //START JInit
    super(EntityKind.InclusionDirectiveKind, /*NO_COPY*/Range);
    this.FileName = new StringRef();
    this.InQuotes = InQuotes;
    this.Kind = (byte) Kind.getValue();
    this.ImportedModule = ImportedModule;
    this.File = File;
    //END JInit
    char$ptr/*char P*/ Memory = (char$ptr/*char P*/ )PPRec.Allocate(FileName.size() + 1, llvm.alignOf(/*char*/byte.class));
    memcpy(Memory, FileName.data(), FileName.size());
    Memory.$set(FileName.size(), $$TERM);
    this.FileName.$assignMove(new StringRef(Memory, FileName.size()));
  }

  
  /// \brief Determine what kind of inclusion directive this is.
  //<editor-fold defaultstate="collapsed" desc="clang::InclusionDirective::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 239,
   FQN="clang::InclusionDirective::getKind", NM="_ZNK5clang18InclusionDirective7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZNK5clang18InclusionDirective7getKindEv")
  //</editor-fold>
  public InclusionKind getInclusionKind() /*const*/ {
    return InclusionKind.valueOf(Kind);
  }

  
  /// \brief Retrieve the included file name as it was written in the source.
  //<editor-fold defaultstate="collapsed" desc="clang::InclusionDirective::getFileName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 242,
   FQN="clang::InclusionDirective::getFileName", NM="_ZNK5clang18InclusionDirective11getFileNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZNK5clang18InclusionDirective11getFileNameEv")
  //</editor-fold>
  public StringRef getFileName() /*const*/ {
    return FileName;
  }

  
  /// \brief Determine whether the included file name was written in quotes;
  /// otherwise, it was written in angle brackets.
  //<editor-fold defaultstate="collapsed" desc="clang::InclusionDirective::wasInQuotes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 246,
   FQN="clang::InclusionDirective::wasInQuotes", NM="_ZNK5clang18InclusionDirective11wasInQuotesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZNK5clang18InclusionDirective11wasInQuotesEv")
  //</editor-fold>
  public boolean wasInQuotes() /*const*/ {
    return InQuotes;
  }

  
  /// \brief Determine whether the inclusion directive was automatically
  /// turned into a module import.
  //<editor-fold defaultstate="collapsed" desc="clang::InclusionDirective::importedModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 250,
   FQN="clang::InclusionDirective::importedModule", NM="_ZNK5clang18InclusionDirective14importedModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZNK5clang18InclusionDirective14importedModuleEv")
  //</editor-fold>
  public boolean importedModule() /*const*/ {
    return ImportedModule;
  }

  
  /// \brief Retrieve the file entry for the actual file that was included
  /// by this directive.
  //<editor-fold defaultstate="collapsed" desc="clang::InclusionDirective::getFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 254,
   FQN="clang::InclusionDirective::getFile", NM="_ZNK5clang18InclusionDirective7getFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZNK5clang18InclusionDirective7getFileEv")
  //</editor-fold>
  public /*const*/ FileEntry /*P*/ getFile() /*const*/ {
    return File;
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::InclusionDirective::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 257,
   FQN="clang::InclusionDirective::classof", NM="_ZN5clang18InclusionDirective7classofEPKNS_18PreprocessedEntityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang18InclusionDirective7classofEPKNS_18PreprocessedEntityE")
  //</editor-fold>
  public static boolean classof(/*const*/ PreprocessedEntity /*P*/ PE) {
    return PE.getEntityKind() == EntityKind.InclusionDirectiveKind;
  }

  
  public String toString() {
    return "" + "FileName=" + FileName // NOI18N
              + ", InQuotes=" + InQuotes // NOI18N
              + ", Kind=" + Kind // NOI18N
              + ", ImportedModule=" + ImportedModule // NOI18N
              + ", File=" + File // NOI18N
              + super.toString(); // NOI18N
  }
}
