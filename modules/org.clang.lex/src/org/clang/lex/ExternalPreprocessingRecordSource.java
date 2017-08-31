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

import org.clank.java.*;
import org.clank.support.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import org.clang.basic.*;


/// \brief An abstract class that should be subclassed by any external source
/// of preprocessing record entries.
//<editor-fold defaultstate="collapsed" desc="clang::ExternalPreprocessingRecordSource">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 264,
 FQN="clang::ExternalPreprocessingRecordSource", NM="_ZN5clang33ExternalPreprocessingRecordSourceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang33ExternalPreprocessingRecordSourceE")
//</editor-fold>
public abstract interface/*class*/ ExternalPreprocessingRecordSource extends Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalPreprocessingRecordSource::~ExternalPreprocessingRecordSource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp", line = 22,
   FQN="clang::ExternalPreprocessingRecordSource::~ExternalPreprocessingRecordSource", NM="_ZN5clang33ExternalPreprocessingRecordSourceD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -nm=_ZN5clang33ExternalPreprocessingRecordSourceD0Ev")
  //</editor-fold>
  public default/*interface*/ void $destroy$ExternalPreprocessingRecordSource() {
  }


  
  /// \brief Read a preallocated preprocessed entity from the external source.
  ///
  /// \returns null if an error occurred that prevented the preprocessed
  /// entity from being loaded.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalPreprocessingRecordSource::ReadPreprocessedEntity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 272,
   FQN="clang::ExternalPreprocessingRecordSource::ReadPreprocessedEntity", NM="_ZN5clang33ExternalPreprocessingRecordSource22ReadPreprocessedEntityEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang33ExternalPreprocessingRecordSource22ReadPreprocessedEntityEj")
  //</editor-fold>
  public /*interface*/ abstract /*virtual*/ PreprocessedEntity /*P*/ ReadPreprocessedEntity(/*uint*/int Index)/* = 0*/;

  
  /// \brief Returns a pair of [Begin, End) indices of preallocated
  /// preprocessed entities that \p Range encompasses.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalPreprocessingRecordSource::findPreprocessedEntitiesInRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 276,
   FQN="clang::ExternalPreprocessingRecordSource::findPreprocessedEntitiesInRange", NM="_ZN5clang33ExternalPreprocessingRecordSource31findPreprocessedEntitiesInRangeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang33ExternalPreprocessingRecordSource31findPreprocessedEntitiesInRangeENS_11SourceRangeE")
  //</editor-fold>
  public /*interface*/ abstract /*virtual*/ std.pairUIntUInt findPreprocessedEntitiesInRange(SourceRange Range)/* = 0*/;

  
  /// \brief Optionally returns true or false if the preallocated preprocessed
  /// entity with index \p Index came from file \p FID.
  //<editor-fold defaultstate="collapsed" desc="clang::ExternalPreprocessingRecordSource::isPreprocessedEntityInFileID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 281,
   FQN="clang::ExternalPreprocessingRecordSource::isPreprocessedEntityInFileID", NM="_ZN5clang33ExternalPreprocessingRecordSource28isPreprocessedEntityInFileIDEjNS_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang33ExternalPreprocessingRecordSource28isPreprocessedEntityInFileIDEjNS_6FileIDE")
  //</editor-fold>
  public default/*interface*/ /*virtual*/ OptionalBool isPreprocessedEntityInFileID(/*uint*/int Index, 
                              FileID FID) {
    return new OptionalBool(None);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ExternalPreprocessingRecordSource::ExternalPreprocessingRecordSource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 264,
   FQN="clang::ExternalPreprocessingRecordSource::ExternalPreprocessingRecordSource", NM="_ZN5clang33ExternalPreprocessingRecordSourceC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang33ExternalPreprocessingRecordSourceC1Ev")
  //</editor-fold>
  public default/*interface*/ /*inline*/ void $ExternalPreprocessingRecordSource() {
  }

}
