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

package org.clang.tooling.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;


/// \brief A parser for escaped strings of command line arguments.
///
/// Assumes \-escaping for quoted arguments (see the documentation of
/// unescapeCommandLine(...)).
//<editor-fold defaultstate="collapsed" desc="clang::tooling::(anonymous namespace)::CommandLineArgumentParser">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp", line = 31,
 FQN="clang::tooling::(anonymous namespace)::CommandLineArgumentParser", NM="_ZN5clang7tooling12_GLOBAL__N_125CommandLineArgumentParserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp -nm=_ZN5clang7tooling12_GLOBAL__N_125CommandLineArgumentParserE")
//</editor-fold>
public class CommandLineArgumentParser implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::(anonymous namespace)::CommandLineArgumentParser::CommandLineArgumentParser">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp", line = 33,
   FQN="clang::tooling::(anonymous namespace)::CommandLineArgumentParser::CommandLineArgumentParser", NM="_ZN5clang7tooling12_GLOBAL__N_125CommandLineArgumentParserC1EN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp -nm=_ZN5clang7tooling12_GLOBAL__N_125CommandLineArgumentParserC1EN4llvm9StringRefE")
  //</editor-fold>
  public CommandLineArgumentParser(StringRef CommandLine) {
    // : Input(CommandLine), Position(Input.begin() - 1), CommandLine() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::(anonymous namespace)::CommandLineArgumentParser::parse">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp", line = 36,
   FQN="clang::tooling::(anonymous namespace)::CommandLineArgumentParser::parse", NM="_ZN5clang7tooling12_GLOBAL__N_125CommandLineArgumentParser5parseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp -nm=_ZN5clang7tooling12_GLOBAL__N_125CommandLineArgumentParser5parseEv")
  //</editor-fold>
  public std.vectorString parse() {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  // All private methods return true if there is more input available.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::(anonymous namespace)::CommandLineArgumentParser::parseStringInto">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp", line = 49,
   FQN="clang::tooling::(anonymous namespace)::CommandLineArgumentParser::parseStringInto", NM="_ZN5clang7tooling12_GLOBAL__N_125CommandLineArgumentParser15parseStringIntoERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp -nm=_ZN5clang7tooling12_GLOBAL__N_125CommandLineArgumentParser15parseStringIntoERSs")
  //</editor-fold>
  private boolean parseStringInto(final std.string/*&*/ String) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::(anonymous namespace)::CommandLineArgumentParser::parseDoubleQuotedStringInto">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp", line = 62,
   FQN="clang::tooling::(anonymous namespace)::CommandLineArgumentParser::parseDoubleQuotedStringInto", NM="_ZN5clang7tooling12_GLOBAL__N_125CommandLineArgumentParser27parseDoubleQuotedStringIntoERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp -nm=_ZN5clang7tooling12_GLOBAL__N_125CommandLineArgumentParser27parseDoubleQuotedStringIntoERSs")
  //</editor-fold>
  private boolean parseDoubleQuotedStringInto(final std.string/*&*/ String) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::(anonymous namespace)::CommandLineArgumentParser::parseSingleQuotedStringInto">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp", line = 72,
   FQN="clang::tooling::(anonymous namespace)::CommandLineArgumentParser::parseSingleQuotedStringInto", NM="_ZN5clang7tooling12_GLOBAL__N_125CommandLineArgumentParser27parseSingleQuotedStringIntoERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp -nm=_ZN5clang7tooling12_GLOBAL__N_125CommandLineArgumentParser27parseSingleQuotedStringIntoERSs")
  //</editor-fold>
  private boolean parseSingleQuotedStringInto(final std.string/*&*/ String) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::(anonymous namespace)::CommandLineArgumentParser::parseFreeStringInto">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp", line = 81,
   FQN="clang::tooling::(anonymous namespace)::CommandLineArgumentParser::parseFreeStringInto", NM="_ZN5clang7tooling12_GLOBAL__N_125CommandLineArgumentParser19parseFreeStringIntoERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp -nm=_ZN5clang7tooling12_GLOBAL__N_125CommandLineArgumentParser19parseFreeStringIntoERSs")
  //</editor-fold>
  private boolean parseFreeStringInto(final std.string/*&*/ String) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::(anonymous namespace)::CommandLineArgumentParser::skipEscapeCharacter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp", line = 90,
   FQN="clang::tooling::(anonymous namespace)::CommandLineArgumentParser::skipEscapeCharacter", NM="_ZN5clang7tooling12_GLOBAL__N_125CommandLineArgumentParser19skipEscapeCharacterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp -nm=_ZN5clang7tooling12_GLOBAL__N_125CommandLineArgumentParser19skipEscapeCharacterEv")
  //</editor-fold>
  private boolean skipEscapeCharacter() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::(anonymous namespace)::CommandLineArgumentParser::nextNonWhitespace">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp", line = 97,
   FQN="clang::tooling::(anonymous namespace)::CommandLineArgumentParser::nextNonWhitespace", NM="_ZN5clang7tooling12_GLOBAL__N_125CommandLineArgumentParser17nextNonWhitespaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp -nm=_ZN5clang7tooling12_GLOBAL__N_125CommandLineArgumentParser17nextNonWhitespaceEv")
  //</editor-fold>
  private boolean nextNonWhitespace() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::(anonymous namespace)::CommandLineArgumentParser::next">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp", line = 104,
   FQN="clang::tooling::(anonymous namespace)::CommandLineArgumentParser::next", NM="_ZN5clang7tooling12_GLOBAL__N_125CommandLineArgumentParser4nextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp -nm=_ZN5clang7tooling12_GLOBAL__N_125CommandLineArgumentParser4nextEv")
  //</editor-fold>
  private boolean next() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  private /*const*/ StringRef Input;
  private char$ptr Position;
  private std.vectorString CommandLine;
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::(anonymous namespace)::CommandLineArgumentParser::~CommandLineArgumentParser">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp", line = 31,
   FQN="clang::tooling::(anonymous namespace)::CommandLineArgumentParser::~CommandLineArgumentParser", NM="_ZN5clang7tooling12_GLOBAL__N_125CommandLineArgumentParserD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp -nm=_ZN5clang7tooling12_GLOBAL__N_125CommandLineArgumentParserD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Input=" + Input // NOI18N
              + ", Position=" + Position // NOI18N
              + ", CommandLine=" + CommandLine; // NOI18N
  }
}
