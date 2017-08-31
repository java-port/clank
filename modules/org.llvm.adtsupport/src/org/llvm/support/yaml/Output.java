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

package org.llvm.support.yaml;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;


///
/// The Output class is used to generate a yaml document from in-memory structs
/// and vectors.
///
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1109,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1080,
 FQN="llvm::yaml::Output", NM="_ZN4llvm4yaml6OutputE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6OutputE")
//</editor-fold>
public class Output extends /*public*/ IO implements Destructors.ClassWithDestructor {
/*public:*/
  
  //===----------------------------------------------------------------------===//
  //  Output
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::Output">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 399,
   FQN="llvm::yaml::Output::Output", NM="_ZN4llvm4yaml6OutputC1ERNS_11raw_ostreamEPvi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6OutputC1ERNS_11raw_ostreamEPvi")
  //</editor-fold>
  public Output(final raw_ostream /*&*/ yout) {
    this(yout, (Object/*void P*/ )null, 70);
  }
  public Output(final raw_ostream /*&*/ yout, Object/*void P*/ context/*= null*/) {
    this(yout, context, 70);
  }
  public Output(final raw_ostream /*&*/ yout, Object/*void P*/ context/*= null*/, int WrapColumn/*= 70*/) {
    // : IO(context), Out(yout), WrapColumn(WrapColumn), StateStack(), Column(0), ColumnAtFlowStart(0), ColumnAtMapFlowStart(0), NeedBitValueComma(false), NeedFlowSequenceComma(false), EnumerationMatchFound(false), NeedsNewLine(false) 
    //START JInit
    super(context);
    this./*&*/Out=/*&*/yout;
    this.WrapColumn = WrapColumn;
    this.StateStack = new SmallVector<InState/*, 8*/>(8, InState.inSeq);
    this.Column = 0;
    this.ColumnAtFlowStart = 0;
    this.ColumnAtMapFlowStart = 0;
    this.NeedBitValueComma = false;
    this.NeedFlowSequenceComma = false;
    this.EnumerationMatchFound = false;
    this.NeedsNewLine = false;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::~Output">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 412,
   FQN="llvm::yaml::Output::~Output", NM="_ZN4llvm4yaml6OutputD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6OutputD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    //START JDestroy
    StateStack.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::outputting">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 415,
   FQN="llvm::yaml::Output::outputting", NM="_ZN4llvm4yaml6Output10outputtingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output10outputtingEv")
  //</editor-fold>
  @Override public boolean outputting()/* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::mapTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 424,
   FQN="llvm::yaml::Output::mapTag", NM="_ZN4llvm4yaml6Output6mapTagENS_9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output6mapTagENS_9StringRefEb")
  //</editor-fold>
  @Override public boolean mapTag(StringRef Tag, boolean Use)/* override*/ {
    if (Use) {
      // If this tag is being written inside a sequence we should write the start
      // of the sequence before writing the tag, otherwise the tag won't be
      // attached to the element in the sequence, but rather the sequence itself.
      boolean SequenceElement = $greater_uint(StateStack.size(), 1) && (StateStack.$at(StateStack.size() - 2) == InState.inSeq
         || StateStack.$at(StateStack.size() - 2) == InState.inFlowSeq);
      if (SequenceElement && StateStack.back() == InState.inMapFirstKey) {
        this.newLineCheck();
      } else {
        this.output(new StringRef(/*KEEP_STR*/$SPACE));
      }
      this.output(new StringRef(Tag));
      if (SequenceElement) {
        // If we're writing the tag during the first element of a map, the tag
        // takes the place of the first element in the sequence.
        if (StateStack.back() == InState.inMapFirstKey) {
          StateStack.pop_back();
          StateStack.push_back(InState.inMapOtherKey);
        }
        // Tags inside maps in sequences should act as keys in the map from a
        // formatting perspective, so we always want a newline in a sequence.
        NeedsNewLine = true;
      }
    }
    return Use;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::beginMapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 419,
   FQN="llvm::yaml::Output::beginMapping", NM="_ZN4llvm4yaml6Output12beginMappingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output12beginMappingEv")
  //</editor-fold>
  @Override public void beginMapping()/* override*/ {
    StateStack.push_back(InState.inMapFirstKey);
    NeedsNewLine = true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::endMapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 453,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 432,
   FQN="llvm::yaml::Output::endMapping", NM="_ZN4llvm4yaml6Output10endMappingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output10endMappingEv")
  //</editor-fold>
  @Override public void endMapping()/* override*/ {
    StateStack.pop_back();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::preflightKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 457,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 436,
   FQN="llvm::yaml::Output::preflightKey", NM="_ZN4llvm4yaml6Output12preflightKeyEPKcbbRbRPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output12preflightKeyEPKcbbRbRPv")
  //</editor-fold>
  @Override public boolean preflightKey(/*const*/char$ptr/*char P*/ Key, boolean Required, boolean SameAsDefault, 
              final bool$ref/*bool &*/ UseDefault, final type$ref<Object>/*void P&*/ $Prm4)/* override*/ {
    UseDefault.$set(false);
    if (Required || !SameAsDefault) {
      InState State = StateStack.back();
      if (State == InState.inFlowMapFirstKey || State == InState.inFlowMapOtherKey) {
        flowKey(new StringRef(Key));
      } else {
        this.newLineCheck();
        this.paddedKey(new StringRef(Key));
      }
      return true;
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::postflightKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 473,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 452,
   FQN="llvm::yaml::Output::postflightKey", NM="_ZN4llvm4yaml6Output13postflightKeyEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output13postflightKeyEPv")
  //</editor-fold>
  @Override public void postflightKey(Object/*void P*/ $Prm0)/* override*/ {
    if (StateStack.back() == InState.inMapFirstKey) {
      StateStack.pop_back();
      StateStack.push_back(InState.inMapOtherKey);
    } else if (StateStack.back() == InState.inFlowMapFirstKey) {
      StateStack.pop_back();
      StateStack.push_back(InState.inFlowMapOtherKey);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::beginFlowMapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 483,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 462,
   FQN="llvm::yaml::Output::beginFlowMapping", NM="_ZN4llvm4yaml6Output16beginFlowMappingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output16beginFlowMappingEv")
  //</editor-fold>
  @Override public void beginFlowMapping()/* override*/ {
    StateStack.push_back(InState.inFlowMapFirstKey);
    this.newLineCheck();
    ColumnAtMapFlowStart = Column;
    output(new StringRef(/*KEEP_STR*/"{ "));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::endFlowMapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 490,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 469,
   FQN="llvm::yaml::Output::endFlowMapping", NM="_ZN4llvm4yaml6Output14endFlowMappingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output14endFlowMappingEv")
  //</editor-fold>
  @Override public void endFlowMapping()/* override*/ {
    StateStack.pop_back();
    this.outputUpToEndOfLine(new StringRef(/*KEEP_STR*/" }"));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::beginSequence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 512,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 491,
   FQN="llvm::yaml::Output::beginSequence", NM="_ZN4llvm4yaml6Output13beginSequenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output13beginSequenceEv")
  //</editor-fold>
  @Override public /*uint*/int beginSequence()/* override*/ {
    StateStack.push_back(InState.inSeq);
    NeedsNewLine = true;
    return 0;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::endSequence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 518,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 497,
   FQN="llvm::yaml::Output::endSequence", NM="_ZN4llvm4yaml6Output11endSequenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output11endSequenceEv")
  //</editor-fold>
  @Override public void endSequence()/* override*/ {
    StateStack.pop_back();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::preflightElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 522,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 501,
   FQN="llvm::yaml::Output::preflightElement", NM="_ZN4llvm4yaml6Output16preflightElementEjRPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output16preflightElementEjRPv")
  //</editor-fold>
  @Override public boolean preflightElement(/*uint*/int $Prm0, final type$ref<Object>/*void P&*/ $Prm1)/* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::postflightElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 526,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 505,
   FQN="llvm::yaml::Output::postflightElement", NM="_ZN4llvm4yaml6Output17postflightElementEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output17postflightElementEPv")
  //</editor-fold>
  @Override public void postflightElement(Object/*void P*/ $Prm0)/* override*/ {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::beginFlowSequence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 529,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 508,
   FQN="llvm::yaml::Output::beginFlowSequence", NM="_ZN4llvm4yaml6Output17beginFlowSequenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output17beginFlowSequenceEv")
  //</editor-fold>
  @Override public /*uint*/int beginFlowSequence()/* override*/ {
    StateStack.push_back(InState.inFlowSeq);
    this.newLineCheck();
    ColumnAtFlowStart = Column;
    output(new StringRef(/*KEEP_STR*/"[ "));
    NeedFlowSequenceComma = false;
    return 0;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::preflightFlowElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 543,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 522,
   FQN="llvm::yaml::Output::preflightFlowElement", NM="_ZN4llvm4yaml6Output20preflightFlowElementEjRPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output20preflightFlowElementEjRPv")
  //</editor-fold>
  @Override public boolean preflightFlowElement(/*uint*/int $Prm0, final type$ref<Object>/*void P&*/ $Prm1)/* override*/ {
    if (NeedFlowSequenceComma) {
      output(new StringRef(/*KEEP_STR*/$COMMA_SPACE));
    }
    if ((WrapColumn != 0) && Column > WrapColumn) {
      output(new StringRef(/*KEEP_STR*/$LF));
      for (int i = 0; i < ColumnAtFlowStart; ++i)  {
        output(new StringRef(/*KEEP_STR*/$SPACE));
      }
      Column = ColumnAtFlowStart;
      output(new StringRef(/*KEEP_STR*/"  "));
    }
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::postflightFlowElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 556,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 535,
   FQN="llvm::yaml::Output::postflightFlowElement", NM="_ZN4llvm4yaml6Output21postflightFlowElementEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output21postflightFlowElementEPv")
  //</editor-fold>
  @Override public void postflightFlowElement(Object/*void P*/ $Prm0)/* override*/ {
    NeedFlowSequenceComma = true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::endFlowSequence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 538,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 517,
   FQN="llvm::yaml::Output::endFlowSequence", NM="_ZN4llvm4yaml6Output15endFlowSequenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output15endFlowSequenceEv")
  //</editor-fold>
  @Override public void endFlowSequence()/* override*/ {
    StateStack.pop_back();
    this.outputUpToEndOfLine(new StringRef(/*KEEP_STR*/" ]"));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::beginEnumScalar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 560,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 539,
   FQN="llvm::yaml::Output::beginEnumScalar", NM="_ZN4llvm4yaml6Output15beginEnumScalarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output15beginEnumScalarEv")
  //</editor-fold>
  @Override public void beginEnumScalar()/* override*/ {
    EnumerationMatchFound = false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::matchEnumScalar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 564,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 543,
   FQN="llvm::yaml::Output::matchEnumScalar", NM="_ZN4llvm4yaml6Output15matchEnumScalarEPKcb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output15matchEnumScalarEPKcb")
  //</editor-fold>
  @Override public boolean matchEnumScalar(/*const*/char$ptr/*char P*/ Str, boolean Match)/* override*/ {
    if (Match && !EnumerationMatchFound) {
      this.newLineCheck();
      this.outputUpToEndOfLine(new StringRef(Str));
      EnumerationMatchFound = true;
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::matchEnumFallback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 573,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 552,
   FQN="llvm::yaml::Output::matchEnumFallback", NM="_ZN4llvm4yaml6Output17matchEnumFallbackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output17matchEnumFallbackEv")
  //</editor-fold>
  @Override public boolean matchEnumFallback()/* override*/ {
    if (EnumerationMatchFound) {
      return false;
    }
    EnumerationMatchFound = true;
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::endEnumScalar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 580,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 559,
   FQN="llvm::yaml::Output::endEnumScalar", NM="_ZN4llvm4yaml6Output13endEnumScalarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output13endEnumScalarEv")
  //</editor-fold>
  @Override public void endEnumScalar()/* override*/ {
    if (!EnumerationMatchFound) {
      throw new llvm_unreachable("bad runtime enum value");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::beginBitSetScalar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 585,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 564,
   FQN="llvm::yaml::Output::beginBitSetScalar", NM="_ZN4llvm4yaml6Output17beginBitSetScalarERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output17beginBitSetScalarERb")
  //</editor-fold>
  @Override public boolean beginBitSetScalar(final bool$ref/*bool &*/ DoClear)/* override*/ {
    this.newLineCheck();
    output(new StringRef(/*KEEP_STR*/"[ "));
    NeedBitValueComma = false;
    DoClear.$set(false);
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::bitSetMatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 593,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 572,
   FQN="llvm::yaml::Output::bitSetMatch", NM="_ZN4llvm4yaml6Output11bitSetMatchEPKcb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output11bitSetMatchEPKcb")
  //</editor-fold>
  @Override public boolean bitSetMatch(/*const*/char$ptr/*char P*/ Str, boolean Matches)/* override*/ {
    if (Matches) {
      if (NeedBitValueComma) {
        output(new StringRef(/*KEEP_STR*/$COMMA_SPACE));
      }
      this.output(new StringRef(Str));
      NeedBitValueComma = true;
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::endBitSetScalar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 603,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 582,
   FQN="llvm::yaml::Output::endBitSetScalar", NM="_ZN4llvm4yaml6Output15endBitSetScalarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output15endBitSetScalarEv")
  //</editor-fold>
  @Override public void endBitSetScalar()/* override*/ {
    this.outputUpToEndOfLine(new StringRef(/*KEEP_STR*/" ]"));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::scalarString">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 607,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 586,
   FQN="llvm::yaml::Output::scalarString", NM="_ZN4llvm4yaml6Output12scalarStringERNS_9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output12scalarStringERNS_9StringRefEb")
  //</editor-fold>
  @Override public void scalarString(final StringRef /*&*/ S, boolean MustQuote)/* override*/ {
    this.newLineCheck();
    if (S.empty()) {
      // Print '' for the empty string because leaving the field empty is not
      // allowed.
      this.outputUpToEndOfLine(new StringRef(/*KEEP_STR*/"''"));
      return;
    }
    if (!MustQuote) {
      // Only quote if we must.
      this.outputUpToEndOfLine(new StringRef(S));
      return;
    }
    /*uint*/int i = 0;
    /*uint*/int j = 0;
    /*uint*/int End = S.size();
    output(new StringRef(/*KEEP_STR*/$SGL_QUOTE)); // Starting single quote.
    /*const*/char$ptr/*char P*/ Base = $tryClone(S.data());
    while ($less_uint(j, End)) {
      // Escape a single quote by doubling it.
      if (S.$at(j) == $$SGL_QUOTE) {
        output(new StringRef(Base.$add(i), j - i + 1));
        output(new StringRef(/*KEEP_STR*/$SGL_QUOTE));
        i = j + 1;
      }
      ++j;
    }
    output(new StringRef(Base.$add(i), j - i));
    this.outputUpToEndOfLine(new StringRef(/*KEEP_STR*/$SGL_QUOTE)); // Ending single quote.
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::blockScalarString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 638,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 617,
   FQN="llvm::yaml::Output::blockScalarString", NM="_ZN4llvm4yaml6Output17blockScalarStringERNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output17blockScalarStringERNS_9StringRefE")
  //</editor-fold>
  @Override public void blockScalarString(final StringRef /*&*/ S)/* override*/ {
    unique_ptr<MemoryBuffer> Buffer = null;
    try {
      if (!StateStack.empty()) {
        newLineCheck();
      }
      output(new StringRef(/*KEEP_STR*/" |"));
      outputNewLine();
      
      /*uint*/int Indent = StateStack.empty() ? 1 : StateStack.size();
      
      Buffer = MemoryBuffer.getMemBuffer(new StringRef(S), new StringRef(/*KEEP_STR*/$EMPTY), false);
      for (line_iterator Lines/*J*/= new line_iterator(Buffer.$star(), false); !Lines.is_at_end(); Lines.$preInc()) {
        for (/*uint*/int I = 0; $less_uint(I, Indent); ++I) {
          output(new StringRef(/*KEEP_STR*/"  "));
        }
        output(Lines.$star());
        outputNewLine();
      }
    } finally {
      if (Buffer != null) { Buffer.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::setError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 656,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 635,
   FQN="llvm::yaml::Output::setError", NM="_ZN4llvm4yaml6Output8setErrorERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output8setErrorERKNS_5TwineE")
  //</editor-fold>
  @Override public void setError(final /*const*/ Twine /*&*/ message)/* override*/ {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::canElideEmptySequence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 659,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 638,
   FQN="llvm::yaml::Output::canElideEmptySequence", NM="_ZN4llvm4yaml6Output21canElideEmptySequenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output21canElideEmptySequenceEv")
  //</editor-fold>
  @Override public boolean canElideEmptySequence()/* override*/ {
    // Normally, with an optional key/value where the value is an empty sequence,
    // the whole key/value can be not written.  But, that produces wrong yaml
    // if the key/value is the only thing in the map and the map is used in
    // a sequence.  This detects if the this sequence is the first key/value
    // in map that itself is embedded in a sequnce.
    if ($less_uint(StateStack.size(), 2)) {
      return true;
    }
    if (StateStack.back() != InState.inMapFirstKey) {
      return true;
    }
    return (StateStack.$at(StateStack.size() - 2) != InState.inSeq);
  }

/*public:*/
  // These are only used by operator<<. They could be private
  // if that templated operator could be made a friend.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::beginDocuments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 495,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 474,
   FQN="llvm::yaml::Output::beginDocuments", NM="_ZN4llvm4yaml6Output14beginDocumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output14beginDocumentsEv")
  //</editor-fold>
  public void beginDocuments() {
    this.outputUpToEndOfLine(new StringRef(/*KEEP_STR*/"---"));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::preflightDocument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 499,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 478,
   FQN="llvm::yaml::Output::preflightDocument", NM="_ZN4llvm4yaml6Output17preflightDocumentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output17preflightDocumentEj")
  //</editor-fold>
  public boolean preflightDocument(/*uint*/int index) {
    if ($greater_uint(index, 0)) {
      this.outputUpToEndOfLine(new StringRef(/*KEEP_STR*/"\n---"));
    }
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::postflightDocument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 505,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 484,
   FQN="llvm::yaml::Output::postflightDocument", NM="_ZN4llvm4yaml6Output18postflightDocumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output18postflightDocumentEv")
  //</editor-fold>
  public void postflightDocument() {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::endDocuments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 508,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 487,
   FQN="llvm::yaml::Output::endDocuments", NM="_ZN4llvm4yaml6Output12endDocumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output12endDocumentsEv")
  //</editor-fold>
  public void endDocuments() {
    output(new StringRef(/*KEEP_STR*/"\n...\n"));
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::output">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 672,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 651,
   FQN="llvm::yaml::Output::output", NM="_ZN4llvm4yaml6Output6outputENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output6outputENS_9StringRefE")
  //</editor-fold>
  private void output(StringRef s) {
    Column += s.size();
    Out.$out(/*NO_COPY*/s);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::outputUpToEndOfLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 677,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 656,
   FQN="llvm::yaml::Output::outputUpToEndOfLine", NM="_ZN4llvm4yaml6Output19outputUpToEndOfLineENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output19outputUpToEndOfLineENS_9StringRefE")
  //</editor-fold>
  private void outputUpToEndOfLine(StringRef s) {
    this.output(new StringRef(s));
    if (StateStack.empty() || (StateStack.back() != InState.inFlowSeq
       && StateStack.back() != InState.inFlowMapFirstKey
       && StateStack.back() != InState.inFlowMapOtherKey)) {
      NeedsNewLine = true;
    }
  }

  
  // if seq at top, indent as if map, then add "- "
  // if seq in middle, use "- " if firstKey, else use "  "
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::newLineCheck">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 694,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 673,
   FQN="llvm::yaml::Output::newLineCheck", NM="_ZN4llvm4yaml6Output12newLineCheckEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output12newLineCheckEv")
  //</editor-fold>
  private void newLineCheck() {
    if (!NeedsNewLine) {
      return;
    }
    NeedsNewLine = false;
    
    this.outputNewLine();
    assert ($greater_uint(StateStack.size(), 0));
    /*uint*/int Indent = StateStack.size() - 1;
    boolean OutputDash = false;
    if (StateStack.back() == InState.inSeq) {
      OutputDash = true;
    } else if (($greater_uint(StateStack.size(), 1)) && ((StateStack.back() == InState.inMapFirstKey)
       || (StateStack.back() == InState.inFlowSeq)
       || (StateStack.back() == InState.inFlowMapFirstKey))
       && (StateStack.$at(StateStack.size() - 2) == InState.inSeq)) {
      --Indent;
      OutputDash = true;
    }
    
    for (/*uint*/int i = 0; $less_uint(i, Indent); ++i) {
      output(new StringRef(/*KEEP_STR*/"  "));
    }
    if (OutputDash) {
      output(new StringRef(/*KEEP_STR*/"- "));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::outputNewLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 685,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 664,
   FQN="llvm::yaml::Output::outputNewLine", NM="_ZN4llvm4yaml6Output13outputNewLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output13outputNewLineEv")
  //</editor-fold>
  private void outputNewLine() {
    Out.$out(/*KEEP_STR*/$LF);
    Column = 0;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::paddedKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 724,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 703,
   FQN="llvm::yaml::Output::paddedKey", NM="_ZN4llvm4yaml6Output9paddedKeyENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output9paddedKeyENS_9StringRefE")
  //</editor-fold>
  private void paddedKey(StringRef key) {
    output(new StringRef(key));
    output(new StringRef(/*KEEP_STR*/$COLON));
    /*const*/char$ptr/*char P*/ spaces = $("                ");
    if ($less_uint(key.size(), strlen(spaces))) {
      output(new StringRef(spaces.$add(key.size())));
    } else {
      output(new StringRef(/*KEEP_STR*/$SPACE));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::flowKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 734,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 713,
   FQN="llvm::yaml::Output::flowKey", NM="_ZN4llvm4yaml6Output7flowKeyENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output7flowKeyENS_9StringRefE")
  //</editor-fold>
  private void flowKey(StringRef Key) {
    if (StateStack.back() == InState.inFlowMapOtherKey) {
      output(new StringRef(/*KEEP_STR*/$COMMA_SPACE));
    }
    if ((WrapColumn != 0) && Column > WrapColumn) {
      output(new StringRef(/*KEEP_STR*/$LF));
      for (int I = 0; I < ColumnAtMapFlowStart; ++I)  {
        output(new StringRef(/*KEEP_STR*/$SPACE));
      }
      Column = ColumnAtMapFlowStart;
      output(new StringRef(/*KEEP_STR*/"  "));
    }
    output(new StringRef(Key));
    output(new StringRef(/*KEEP_STR*/": "));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Output::InState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1157,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1128,
   FQN="llvm::yaml::Output::InState", NM="_ZN4llvm4yaml6Output7InStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml6Output7InStateE")
  //</editor-fold>
  private enum InState implements Native.NativeUIntEnum {
    inSeq(0),
    inFlowSeq(inSeq.getValue() + 1),
    inMapFirstKey(inFlowSeq.getValue() + 1),
    inMapOtherKey(inMapFirstKey.getValue() + 1),
    inFlowMapFirstKey(inMapOtherKey.getValue() + 1),
    inFlowMapOtherKey(inFlowMapFirstKey.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static InState valueOf(int val) {
      InState out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final InState[] VALUES;
      private static final InState[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (InState kind : InState.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new InState[min < 0 ? (1-min) : 0];
        VALUES = new InState[max >= 0 ? (1+max) : 0];
        for (InState kind : InState.values()) {
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
    private InState(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  private final raw_ostream /*&*/ Out;
  private int WrapColumn;
  private SmallVector<InState/*, 8*/> StateStack;
  private int Column;
  private int ColumnAtFlowStart;
  private int ColumnAtMapFlowStart;
  private boolean NeedBitValueComma;
  private boolean NeedFlowSequenceComma;
  private boolean EnumerationMatchFound;
  private boolean NeedsNewLine;
  
  @Override public String toString() {
    return "" + "Out=" + Out // NOI18N
              + ", WrapColumn=" + WrapColumn // NOI18N
              + ", StateStack=" + StateStack // NOI18N
              + ", Column=" + Column // NOI18N
              + ", ColumnAtFlowStart=" + ColumnAtFlowStart // NOI18N
              + ", ColumnAtMapFlowStart=" + ColumnAtMapFlowStart // NOI18N
              + ", NeedBitValueComma=" + NeedBitValueComma // NOI18N
              + ", NeedFlowSequenceComma=" + NeedFlowSequenceComma // NOI18N
              + ", EnumerationMatchFound=" + EnumerationMatchFound // NOI18N
              + ", NeedsNewLine=" + NeedsNewLine // NOI18N
              + super.toString(); // NOI18N
  }
}
