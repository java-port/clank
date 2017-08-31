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

package org.clang.tooling.llvm.yaml;

import org.clank.java.*;
import org.clank.support.*;
import org.clang.tooling.core.*;
import org.llvm.support.yaml.*;


/// \brief Specialized MappingTraits to describe how a Replacement is
/// (de)serialized.
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::MappingTraits<clang::tooling::Replacement>">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/ReplacementsYaml.h", line = 31,
 FQN="llvm::yaml::MappingTraits<clang::tooling::Replacement>", NM="_ZN4llvm4yaml13MappingTraitsIN5clang7tooling11ReplacementEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/ClangTidy.cpp -nm=_ZN4llvm4yaml13MappingTraitsIN5clang7tooling11ReplacementEEE")
//</editor-fold>
public class/*struct*/ MappingTraitsReplacement {
  /// \brief Helper to (de)serialize a Replacement since we don't have direct
  /// access to its data members.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::MappingTraits<clang::tooling::Replacement>::NormalizedReplacement">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/ReplacementsYaml.h", line = 34,
   FQN="llvm::yaml::MappingTraits<clang::tooling::Replacement>::NormalizedReplacement", NM="_ZN4llvm4yaml13MappingTraitsIN5clang7tooling11ReplacementEE21NormalizedReplacementE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/ClangTidy.cpp -nm=_ZN4llvm4yaml13MappingTraitsIN5clang7tooling11ReplacementEE21NormalizedReplacementE")
  //</editor-fold>
  public static class/*struct*/ NormalizedReplacement implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::MappingTraits<clang::tooling::Replacement>::NormalizedReplacement::NormalizedReplacement">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/ReplacementsYaml.h", line = 35,
     FQN="llvm::yaml::MappingTraits<clang::tooling::Replacement>::NormalizedReplacement::NormalizedReplacement", NM="_ZN4llvm4yaml13MappingTraitsIN5clang7tooling11ReplacementEE21NormalizedReplacementC1ERKNS0_2IOE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/ClangTidy.cpp -nm=_ZN4llvm4yaml13MappingTraitsIN5clang7tooling11ReplacementEE21NormalizedReplacementC1ERKNS0_2IOE")
    //</editor-fold>
    public NormalizedReplacement(final /*const*/ IO /*&*/ $Prm0) {
      // : FilePath(""), Offset(0), Length(0), ReplacementText("") 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::MappingTraits<clang::tooling::Replacement>::NormalizedReplacement::NormalizedReplacement">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/ReplacementsYaml.h", line = 38,
     FQN="llvm::yaml::MappingTraits<clang::tooling::Replacement>::NormalizedReplacement::NormalizedReplacement", NM="_ZN4llvm4yaml13MappingTraitsIN5clang7tooling11ReplacementEE21NormalizedReplacementC1ERKNS0_2IOERKS4_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/ClangTidy.cpp -nm=_ZN4llvm4yaml13MappingTraitsIN5clang7tooling11ReplacementEE21NormalizedReplacementC1ERKNS0_2IOERKS4_")
    //</editor-fold>
    public NormalizedReplacement(final /*const*/ IO /*&*/ $Prm0, final /*const*/ Replacement /*&*/ R) {
      // : FilePath(R.getFilePath().operator basic_string()), Offset(R.getOffset()), Length(R.getLength()), ReplacementText(R.getReplacementText().operator basic_string()) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::MappingTraits<clang::tooling::Replacement>::NormalizedReplacement::denormalize">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/ReplacementsYaml.h", line = 42,
     FQN="llvm::yaml::MappingTraits<clang::tooling::Replacement>::NormalizedReplacement::denormalize", NM="_ZN4llvm4yaml13MappingTraitsIN5clang7tooling11ReplacementEE21NormalizedReplacement11denormalizeERKNS0_2IOE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/ClangTidy.cpp -nm=_ZN4llvm4yaml13MappingTraitsIN5clang7tooling11ReplacementEE21NormalizedReplacement11denormalizeERKNS0_2IOE")
    //</editor-fold>
    public Replacement denormalize(final /*const*/ IO /*&*/ $Prm0) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    public std.string FilePath;
    public /*uint*/int Offset;
    public /*uint*/int Length;
    public std.string ReplacementText;
    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::MappingTraits<clang::tooling::Replacement>::NormalizedReplacement::~NormalizedReplacement">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/ReplacementsYaml.h", line = 34,
     FQN="llvm::yaml::MappingTraits<clang::tooling::Replacement>::NormalizedReplacement::~NormalizedReplacement", NM="_ZN4llvm4yaml13MappingTraitsIN5clang7tooling11ReplacementEE21NormalizedReplacementD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/ClangTidy.cpp -nm=_ZN4llvm4yaml13MappingTraitsIN5clang7tooling11ReplacementEE21NormalizedReplacementD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "FilePath=" + FilePath // NOI18N
                + ", Offset=" + Offset // NOI18N
                + ", Length=" + Length // NOI18N
                + ", ReplacementText=" + ReplacementText; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::MappingTraits<clang::tooling::Replacement>::mapping">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/ReplacementsYaml.h", line = 53,
   FQN="llvm::yaml::MappingTraits<clang::tooling::Replacement>::mapping", NM="_ZN4llvm4yaml13MappingTraitsIN5clang7tooling11ReplacementEE7mappingERNS0_2IOERS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/ClangTidy.cpp -nm=_ZN4llvm4yaml13MappingTraitsIN5clang7tooling11ReplacementEE7mappingERNS0_2IOERS4_")
  //</editor-fold>
  public static void mapping(final IO /*&*/ Io, final Replacement /*&*/ R) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
