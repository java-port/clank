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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clank.java.stdimpl.aliases.*;
import org.llvm.adt.ADTFunctionPointers.*;
import static org.llvm.adt.java.ADTRTTI.*;



///
/// The Input class is used to parse a yaml document into in-memory structs
/// and vectors.
///
/// It works by using YAMLParser to do a syntax parse of the entire yaml
/// document, then the Input class builds a graph of HNodes which wraps
/// each yaml Node.  The extra layer is buffering.  The low level yaml
/// parser only lets you look at each node once.  The buffering layer lets
/// you search and interate multiple times.  This is necessary because
/// the mapRequired() method calls may not be in the same order
/// as the keys in the document.
///
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 968,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 939,
 FQN="llvm::yaml::Input", NM="_ZN4llvm4yaml5InputE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5InputE")
//</editor-fold>
public class Input extends /*public*/ IO implements Destructors.ClassWithDestructor {
/*public:*/
  // Construct a yaml Input object from a StringRef and optional
  // user-data. The DiagHandler can be specified to provide
  // alternative error reporting.
  
  //===----------------------------------------------------------------------===//
  //  Input
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::Input">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 47,
   FQN="llvm::yaml::Input::Input", NM="_ZN4llvm4yaml5InputC1ENS_9StringRefEPvPFvRKNS_12SMDiagnosticES3_ES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5InputC1ENS_9StringRefEPvPFvRKNS_12SMDiagnosticES3_ES3_")
  //</editor-fold>
  public Input(StringRef InputContent) {
    this(InputContent, 
      (Object/*void P*/ )null, 
      (DiagHandlerTy)null, 
      (Object/*void P*/ )null);
  }
  public Input(StringRef InputContent, 
      Object/*void P*/ Ctxt/*= null*/) {
    this(InputContent, 
      Ctxt, 
      (DiagHandlerTy)null, 
      (Object/*void P*/ )null);
  }
  public Input(StringRef InputContent, 
      Object/*void P*/ Ctxt/*= null*/, 
      DiagHandlerTy DiagHandler/*= null*/) {
    this(InputContent, 
      Ctxt, 
      DiagHandler, 
      (Object/*void P*/ )null);
  }
  public Input(StringRef InputContent, 
      Object/*void P*/ Ctxt/*= null*/, 
      DiagHandlerTy DiagHandler/*= null*/, 
      Object/*void P*/ DiagHandlerCtxt/*= null*/) {
    // : IO(Ctxt), SrcMgr(), Strm(new Stream(InputContent, SrcMgr)), TopNode(), EC(), StringAllocator(), DocIterator(), BitValuesUsed(), CurrentNode(null) 
    //START JInit
    super(Ctxt);
    this.SrcMgr = new SourceMgr();
    this.Strm = new std.unique_ptr<Stream>(new Stream(new StringRef(InputContent), SrcMgr));
    this.TopNode = new std.unique_ptr<HNode>();
    this.EC = new std.error_code();
    this.StringAllocator = new BumpPtrAllocatorImpl();
    this.DocIterator = new document_iterator();
    this.BitValuesUsed = new std.vectorBool();
    this.CurrentNode = null;
    //END JInit
    if ((DiagHandler != null)) {
      SrcMgr.setDiagHandler(DiagHandler, DiagHandlerCtxt);
    }
    DocIterator.$assignMove(Strm.$arrow().begin());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::~Input">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 59,
   FQN="llvm::yaml::Input::~Input", NM="_ZN4llvm4yaml5InputD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5InputD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    //START JDestroy
    BitValuesUsed.$destroy();
    StringAllocator.$destroy();
    TopNode.$destroy();
    Strm.$destroy();
    SrcMgr.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  // Check if there was an syntax or semantic error during parsing.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::error">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 62,
   FQN="llvm::yaml::Input::error", NM="_ZN4llvm4yaml5Input5errorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input5errorEv")
  //</editor-fold>
  public std.error_code error() {
    return new std.error_code(EC);
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::outputting">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 71,
   FQN="llvm::yaml::Input::outputting", NM="_ZN4llvm4yaml5Input10outputtingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input10outputtingEv")
  //</editor-fold>
  @Override public/*private*/ boolean outputting()/* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::mapTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 104,
   FQN="llvm::yaml::Input::mapTag", NM="_ZN4llvm4yaml5Input6mapTagENS_9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input6mapTagENS_9StringRefEb")
  //</editor-fold>
  @Override public/*private*/ boolean mapTag(StringRef Tag, boolean Default)/* override*/ {
    std.string foundTag = CurrentNode._node.getVerbatimTag();
    if (foundTag.empty()) {
      // If no tag found and 'Tag' is the default, say it was found.
      return Default;
    }
    // Return true iff found tag matches supplied tag.
    return Tag.equals(new StringRef(foundTag));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::beginMapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 114,
   FQN="llvm::yaml::Input::beginMapping", NM="_ZN4llvm4yaml5Input12beginMappingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input12beginMappingEv")
  //</editor-fold>
  @Override public/*private*/ void beginMapping()/* override*/ {
    if (EC.$bool()) {
      return;
    }
    // CurrentNode can be null if the document is empty.
    MapHNode /*P*/ MN = dyn_cast_or_null_MapHNode(CurrentNode);
    if ((MN != null)) {
      MN.ValidKeys.clear();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::endMapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 161,
   FQN="llvm::yaml::Input::endMapping", NM="_ZN4llvm4yaml5Input10endMappingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input10endMappingEv")
  //</editor-fold>
  @Override public/*private*/ void endMapping()/* override*/ {
    if (EC.$bool()) {
      return;
    }
    // CurrentNode can be null if the document is empty.
    MapHNode /*P*/ MN = dyn_cast_or_null_MapHNode(CurrentNode);
    if (!(MN != null)) {
      return;
    }
    for (final /*const*/ StringMapEntry<unique_ptr<HNode> > /*&*/ NN : MN.Mapping) {
      if (!MN.isValidKey(NN.first())) {
        setError(NN.second.get(), $add_Twine$C($add_Twine$C(new Twine(/*KEEP_STR*/"unknown key '"), new Twine(NN.first())), new Twine(/*KEEP_STR*/$SGL_QUOTE)));
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::preflightKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 124,
   FQN="llvm::yaml::Input::preflightKey", NM="_ZN4llvm4yaml5Input12preflightKeyEPKcbbRbRPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input12preflightKeyEPKcbbRbRPv")
  //</editor-fold>
  @Override public/*private*/ boolean preflightKey(/*const*/char$ptr/*char P*/ Key, boolean Required, boolean $Prm2, final bool$ref/*bool &*/ UseDefault, 
              final type$ref<Object>/*void P&*/ SaveInfo)/* override*/ {
    UseDefault.$set(false);
    if (EC.$bool()) {
      return false;
    }
    
    // CurrentNode is null for empty documents, which is an error in case required
    // nodes are present.
    if (!(CurrentNode != null)) {
      if (Required) {
        EC.$assignMove(make_error_code(errc.invalid_argument));
      }
      return false;
    }
    
    MapHNode /*P*/ MN = dyn_cast_MapHNode(CurrentNode);
    if (!(MN != null)) {
      setError(CurrentNode, new Twine(/*KEEP_STR*/"not a mapping"));
      return false;
    }
    MN.ValidKeys.push_back(Key);
    HNode /*P*/ Value = MN.Mapping.$at(/*STRINGREF_STR*/Key).get();
    if (!(Value != null)) {
      if (Required) {
        setError(CurrentNode, $add_Twine$C($add_Twine$C(new Twine(/*KEEP_STR*/"missing required key '"), new Twine(Key)), new Twine(/*KEEP_STR*/$SGL_QUOTE)));
      } else {
        UseDefault.$set(true);
      }
      return false;
    }
    SaveInfo.$set(CurrentNode);
    CurrentNode = Value;
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::postflightKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 157,
   FQN="llvm::yaml::Input::postflightKey", NM="_ZN4llvm4yaml5Input13postflightKeyEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input13postflightKeyEPv")
  //</editor-fold>
  @Override public/*private*/ void postflightKey(Object/*void P*/ saveInfo)/* override*/ {
    CurrentNode = reinterpret_cast(HNode /*P*/ .class, saveInfo);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::beginFlowMapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 176,
   FQN="llvm::yaml::Input::beginFlowMapping", NM="_ZN4llvm4yaml5Input16beginFlowMappingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input16beginFlowMappingEv")
  //</editor-fold>
  @Override public/*private*/ void beginFlowMapping()/* override*/ {
    beginMapping();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::endFlowMapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 178,
   FQN="llvm::yaml::Input::endFlowMapping", NM="_ZN4llvm4yaml5Input14endFlowMappingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input14endFlowMappingEv")
  //</editor-fold>
  @Override public/*private*/ void endFlowMapping()/* override*/ {
    endMapping();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::beginSequence">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 180,
   FQN="llvm::yaml::Input::beginSequence", NM="_ZN4llvm4yaml5Input13beginSequenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input13beginSequenceEv")
  //</editor-fold>
  @Override public/*private*/ /*uint*/int beginSequence()/* override*/ {
    {
      SequenceHNode /*P*/ SQ = dyn_cast_SequenceHNode(CurrentNode);
      if ((SQ != null)) {
        return SQ.Entries.size();
      }
    }
    if (isa_EmptyHNode(CurrentNode)) {
      return 0;
    }
    {
      // Treat case where there's a scalar "null" value as an empty sequence.
      ScalarHNode /*P*/ SN = dyn_cast_ScalarHNode(CurrentNode);
      if ((SN != null)) {
        if (YamlGlobals.isNull(SN.value())) {
          return 0;
        }
      }
    }
    // Any other type of HNode is an error.
    setError(CurrentNode, new Twine(/*KEEP_STR*/"not a sequence"));
    return 0;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::endSequence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 195,
   FQN="llvm::yaml::Input::endSequence", NM="_ZN4llvm4yaml5Input11endSequenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input11endSequenceEv")
  //</editor-fold>
  @Override public/*private*/ void endSequence()/* override*/ {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::preflightElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 198,
   FQN="llvm::yaml::Input::preflightElement", NM="_ZN4llvm4yaml5Input16preflightElementEjRPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input16preflightElementEjRPv")
  //</editor-fold>
  @Override public/*private*/ boolean preflightElement(/*uint*/int Index, final type$ref<Object>/*void P&*/ SaveInfo)/* override*/ {
    if (EC.$bool()) {
      return false;
    }
    {
      SequenceHNode /*P*/ SQ = dyn_cast_SequenceHNode(CurrentNode);
      if ((SQ != null)) {
        SaveInfo.$set(CurrentNode);
        CurrentNode = SQ.Entries.$at(Index).get();
        return true;
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::postflightElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 209,
   FQN="llvm::yaml::Input::postflightElement", NM="_ZN4llvm4yaml5Input17postflightElementEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input17postflightElementEPv")
  //</editor-fold>
  @Override public/*private*/ void postflightElement(Object/*void P*/ SaveInfo)/* override*/ {
    CurrentNode = reinterpret_cast(HNode /*P*/ .class, SaveInfo);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::beginFlowSequence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 213,
   FQN="llvm::yaml::Input::beginFlowSequence", NM="_ZN4llvm4yaml5Input17beginFlowSequenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input17beginFlowSequenceEv")
  //</editor-fold>
  @Override public/*private*/ /*uint*/int beginFlowSequence()/* override*/ {
    return beginSequence();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::preflightFlowElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 215,
   FQN="llvm::yaml::Input::preflightFlowElement", NM="_ZN4llvm4yaml5Input20preflightFlowElementEjRPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input20preflightFlowElementEjRPv")
  //</editor-fold>
  @Override public/*private*/ boolean preflightFlowElement(/*uint*/int index, final type$ref<Object>/*void P&*/ SaveInfo)/* override*/ {
    if (EC.$bool()) {
      return false;
    }
    {
      SequenceHNode /*P*/ SQ = dyn_cast_SequenceHNode(CurrentNode);
      if ((SQ != null)) {
        SaveInfo.$set(CurrentNode);
        CurrentNode = SQ.Entries.$at(index).get();
        return true;
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::postflightFlowElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 226,
   FQN="llvm::yaml::Input::postflightFlowElement", NM="_ZN4llvm4yaml5Input21postflightFlowElementEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input21postflightFlowElementEPv")
  //</editor-fold>
  @Override public/*private*/ void postflightFlowElement(Object/*void P*/ SaveInfo)/* override*/ {
    CurrentNode = reinterpret_cast(HNode /*P*/ .class, SaveInfo);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::endFlowSequence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 230,
   FQN="llvm::yaml::Input::endFlowSequence", NM="_ZN4llvm4yaml5Input15endFlowSequenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input15endFlowSequenceEv")
  //</editor-fold>
  @Override public/*private*/ void endFlowSequence()/* override*/ {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::beginEnumScalar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 233,
   FQN="llvm::yaml::Input::beginEnumScalar", NM="_ZN4llvm4yaml5Input15beginEnumScalarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input15beginEnumScalarEv")
  //</editor-fold>
  @Override public/*private*/ void beginEnumScalar()/* override*/ {
    ScalarMatchFound = false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::matchEnumScalar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 237,
   FQN="llvm::yaml::Input::matchEnumScalar", NM="_ZN4llvm4yaml5Input15matchEnumScalarEPKcb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input15matchEnumScalarEPKcb")
  //</editor-fold>
  @Override public/*private*/ boolean matchEnumScalar(/*const*/char$ptr/*char P*/ Str, boolean $Prm1)/* override*/ {
    if (ScalarMatchFound) {
      return false;
    }
    {
      ScalarHNode /*P*/ SN = dyn_cast_ScalarHNode(CurrentNode);
      if ((SN != null)) {
        if (SN.value().equals(/*STRINGREF_STR*/Str)) {
          ScalarMatchFound = true;
          return true;
        }
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::matchEnumFallback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 249,
   FQN="llvm::yaml::Input::matchEnumFallback", NM="_ZN4llvm4yaml5Input17matchEnumFallbackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input17matchEnumFallbackEv")
  //</editor-fold>
  @Override public/*private*/ boolean matchEnumFallback()/* override*/ {
    if (ScalarMatchFound) {
      return false;
    }
    ScalarMatchFound = true;
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::endEnumScalar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 256,
   FQN="llvm::yaml::Input::endEnumScalar", NM="_ZN4llvm4yaml5Input13endEnumScalarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input13endEnumScalarEv")
  //</editor-fold>
  @Override public/*private*/ void endEnumScalar()/* override*/ {
    if (!ScalarMatchFound) {
      setError(CurrentNode, new Twine(/*KEEP_STR*/"unknown enumerated scalar"));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::beginBitSetScalar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 262,
   FQN="llvm::yaml::Input::beginBitSetScalar", NM="_ZN4llvm4yaml5Input17beginBitSetScalarERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input17beginBitSetScalarERb")
  //</editor-fold>
  @Override public/*private*/ boolean beginBitSetScalar(final bool$ref/*bool &*/ DoClear)/* override*/ {
    BitValuesUsed.clear();
    {
      SequenceHNode /*P*/ SQ = dyn_cast_SequenceHNode(CurrentNode);
      if ((SQ != null)) {
        BitValuesUsed.insert(new StdVectorBool.iterator(BitValuesUsed.begin()), SQ.Entries.size(), false);
      } else {
        setError(CurrentNode, new Twine(/*KEEP_STR*/"expected sequence of bit values"));
      }
    }
    DoClear.$set(true);
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::bitSetMatch">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 273,
   FQN="llvm::yaml::Input::bitSetMatch", NM="_ZN4llvm4yaml5Input11bitSetMatchEPKcb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input11bitSetMatchEPKcb")
  //</editor-fold>
  @Override public/*private*/ boolean bitSetMatch(/*const*/char$ptr/*char P*/ Str, boolean $Prm1)/* override*/ {
    if (EC.$bool()) {
      return false;
    }
    {
      SequenceHNode /*P*/ SQ = dyn_cast_SequenceHNode(CurrentNode);
      if ((SQ != null)) {
        /*uint*/int Index = 0;
        for (final unique_ptr<HNode> /*&*/ N : SQ.Entries) {
          {
            ScalarHNode /*P*/ SN = dyn_cast_ScalarHNode(N.get());
            if ((SN != null)) {
              if (SN.value().equals(/*STRINGREF_STR*/Str)) {
                BitValuesUsed.assign(Index, /*KEEP_BOOL*/true);
                return true;
              }
            } else {
              setError(CurrentNode, new Twine(/*KEEP_STR*/"unexpected scalar in sequence of bit values"));
            }
          }
          ++Index;
        }
      } else {
        setError(CurrentNode, new Twine(/*KEEP_STR*/"expected sequence of bit values"));
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::endBitSetScalar">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 295,
   FQN="llvm::yaml::Input::endBitSetScalar", NM="_ZN4llvm4yaml5Input15endBitSetScalarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input15endBitSetScalarEv")
  //</editor-fold>
  @Override public/*private*/ void endBitSetScalar()/* override*/ {
    if (EC.$bool()) {
      return;
    }
    {
      SequenceHNode /*P*/ SQ = dyn_cast_SequenceHNode(CurrentNode);
      if ((SQ != null)) {
        assert (BitValuesUsed.size() == SQ.Entries.size());
        for (/*uint*/int i = 0; $less_uint(i, SQ.Entries.size()); ++i) {
          if (!BitValuesUsed.$at(i)) {
            setError(SQ.Entries.$at(i).get(), new Twine(/*KEEP_STR*/"unknown bit value"));
            return;
          }
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::scalarString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 309,
   FQN="llvm::yaml::Input::scalarString", NM="_ZN4llvm4yaml5Input12scalarStringERNS_9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input12scalarStringERNS_9StringRefEb")
  //</editor-fold>
  @Override public/*private*/ void scalarString(final StringRef /*&*/ S, boolean $Prm1)/* override*/ {
    {
      ScalarHNode /*P*/ SN = dyn_cast_ScalarHNode(CurrentNode);
      if ((SN != null)) {
        S.$assignMove(SN.value());
      } else {
        setError(CurrentNode, new Twine(/*KEEP_STR*/"unexpected scalar"));
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::blockScalarString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 317,
   FQN="llvm::yaml::Input::blockScalarString", NM="_ZN4llvm4yaml5Input17blockScalarStringERNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input17blockScalarStringERNS_9StringRefE")
  //</editor-fold>
  @Override public/*private*/ void blockScalarString(final StringRef /*&*/ S)/* override*/ {
    scalarString(S, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::setError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 387,
   FQN="llvm::yaml::Input::setError", NM="_ZN4llvm4yaml5Input8setErrorERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input8setErrorERKNS_5TwineE")
  //</editor-fold>
  @Override public/*private*/ void setError(final /*const*/ Twine /*&*/ Message)/* override*/ {
    this.setError(CurrentNode, Message);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::canElideEmptySequence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 391,
   FQN="llvm::yaml::Input::canElideEmptySequence", NM="_ZN4llvm4yaml5Input21canElideEmptySequenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input21canElideEmptySequenceEv")
  //</editor-fold>
  @Override public/*private*/ boolean canElideEmptySequence()/* override*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::HNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1011,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 982,
   FQN="llvm::yaml::Input::HNode", NM="_ZN4llvm4yaml5Input5HNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input5HNodeE")
  //</editor-fold>
  /*friend*/public/*private*/ static class HNode implements Destructors.ClassWithDestructor {
    
    // Pin the vtables to this file.
    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::HNode::anchor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 65,
     FQN="llvm::yaml::Input::HNode::anchor", NM="_ZN4llvm4yaml5Input5HNode6anchorEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input5HNode6anchorEv")
    //</editor-fold>
    protected/*private*/ void anchor() {
    }

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::HNode::HNode">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1014,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 985,
     FQN="llvm::yaml::Input::HNode::HNode", NM="_ZN4llvm4yaml5Input5HNodeC1EPNS0_4NodeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input5HNodeC1EPNS0_4NodeE")
    //</editor-fold>
    public HNode(Node /*P*/ n) {
      // : _node(n) 
      //START JInit
      this._node = n;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::HNode::~HNode">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1015,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 986,
     FQN="llvm::yaml::Input::HNode::~HNode", NM="_ZN4llvm4yaml5Input5HNodeD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input5HNodeD0Ev")
    //</editor-fold>
    public /*virtual*/ void $destroy() {
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::HNode::classof">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1016,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 987,
     FQN="llvm::yaml::Input::HNode::classof", NM="_ZN4llvm4yaml5Input5HNode7classofEPKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input5HNode7classofEPKS2_")
    //</editor-fold>
    public static /*inline*/ boolean classof(/*const*/ HNode /*P*/ $Prm0) {
      return true;
    }

    
    public Node /*P*/ _node;
    
    @Override public String toString() {
      return "" + "_node=" + _node; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::EmptyHNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1021,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 992,
   FQN="llvm::yaml::Input::EmptyHNode", NM="_ZN4llvm4yaml5Input10EmptyHNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input10EmptyHNodeE")
  //</editor-fold>
  /*friend*/public/*private*/ static class EmptyHNode extends /*public*/ HNode implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::EmptyHNode::anchor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 66,
     FQN="llvm::yaml::Input::EmptyHNode::anchor", NM="_ZN4llvm4yaml5Input10EmptyHNode6anchorEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input10EmptyHNode6anchorEv")
    //</editor-fold>
    @Override protected/*private*/ void anchor()/* override*/ {
    }

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::EmptyHNode::EmptyHNode">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1024,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 995,
     FQN="llvm::yaml::Input::EmptyHNode::EmptyHNode", NM="_ZN4llvm4yaml5Input10EmptyHNodeC1EPNS0_4NodeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input10EmptyHNodeC1EPNS0_4NodeE")
    //</editor-fold>
    public EmptyHNode(Node /*P*/ n) {
      // : HNode(n) 
      //START JInit
      super(n);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::EmptyHNode::classof">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1025,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 996,
     FQN="llvm::yaml::Input::EmptyHNode::classof", NM="_ZN4llvm4yaml5Input10EmptyHNode7classofEPKNS1_5HNodeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input10EmptyHNode7classofEPKNS1_5HNodeE")
    //</editor-fold>
    public static /*inline*/ boolean classof(/*const*/ HNode /*P*/ n) {
      return NullNode.classof(n._node);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::EmptyHNode::classof">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1028,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 999,
     FQN="llvm::yaml::Input::EmptyHNode::classof", NM="_ZN4llvm4yaml5Input10EmptyHNode7classofEPKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input10EmptyHNode7classofEPKS2_")
    //</editor-fold>
    public static /*inline*/ boolean classof(/*const*/ EmptyHNode /*P*/ $Prm0) {
      return true;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::EmptyHNode::~EmptyHNode">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1021,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 992,
     FQN="llvm::yaml::Input::EmptyHNode::~EmptyHNode", NM="_ZN4llvm4yaml5Input10EmptyHNodeD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input10EmptyHNodeD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      super.$destroy();
    }

    
    @Override public String toString() {
      return "" + super.toString(); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::ScalarHNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1031,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1002,
   FQN="llvm::yaml::Input::ScalarHNode", NM="_ZN4llvm4yaml5Input11ScalarHNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input11ScalarHNodeE")
  //</editor-fold>
  /*friend*/public/*private*/ static class ScalarHNode extends /*public*/ HNode implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::ScalarHNode::anchor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 67,
     FQN="llvm::yaml::Input::ScalarHNode::anchor", NM="_ZN4llvm4yaml5Input11ScalarHNode6anchorEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input11ScalarHNode6anchorEv")
    //</editor-fold>
    @Override protected/*private*/ void anchor()/* override*/ {
    }

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::ScalarHNode::ScalarHNode">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1034,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1005,
     FQN="llvm::yaml::Input::ScalarHNode::ScalarHNode", NM="_ZN4llvm4yaml5Input11ScalarHNodeC1EPNS0_4NodeENS_9StringRefE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input11ScalarHNodeC1EPNS0_4NodeENS_9StringRefE")
    //</editor-fold>
    public ScalarHNode(Node /*P*/ n, StringRef s) {
      // : HNode(n), _value(s) 
      //START JInit
      super(n);
      this._value = new StringRef(s);
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::ScalarHNode::value">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1036,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1007,
     FQN="llvm::yaml::Input::ScalarHNode::value", NM="_ZNK4llvm4yaml5Input11ScalarHNode5valueEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZNK4llvm4yaml5Input11ScalarHNode5valueEv")
    //</editor-fold>
    public StringRef value() /*const*/ {
      return new StringRef(_value);
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::ScalarHNode::classof">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1038,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1009,
     FQN="llvm::yaml::Input::ScalarHNode::classof", NM="_ZN4llvm4yaml5Input11ScalarHNode7classofEPKNS1_5HNodeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input11ScalarHNode7classofEPKNS1_5HNodeE")
    //</editor-fold>
    public static /*inline*/ boolean classof(/*const*/ HNode /*P*/ n) {
      return ScalarNode.classof(n._node)
         || BlockScalarNode.classof(n._node);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::ScalarHNode::classof">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1042,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1013,
     FQN="llvm::yaml::Input::ScalarHNode::classof", NM="_ZN4llvm4yaml5Input11ScalarHNode7classofEPKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input11ScalarHNode7classofEPKS2_")
    //</editor-fold>
    public static /*inline*/ boolean classof(/*const*/ ScalarHNode /*P*/ $Prm0) {
      return true;
    }

  /*protected:*/
    protected StringRef _value;
    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::ScalarHNode::~ScalarHNode">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1031,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1002,
     FQN="llvm::yaml::Input::ScalarHNode::~ScalarHNode", NM="_ZN4llvm4yaml5Input11ScalarHNodeD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input11ScalarHNodeD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      super.$destroy();
    }

    
    @Override public String toString() {
      return "" + "_value=" + _value // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::MapHNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1047,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1018,
   FQN="llvm::yaml::Input::MapHNode", NM="_ZN4llvm4yaml5Input8MapHNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input8MapHNodeE")
  //</editor-fold>
  /*friend*/public/*private*/ static class MapHNode extends /*public*/ HNode implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::MapHNode::anchor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 68,
     FQN="llvm::yaml::Input::MapHNode::anchor", NM="_ZN4llvm4yaml5Input8MapHNode6anchorEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input8MapHNode6anchorEv")
    //</editor-fold>
    @Override protected/*private*/ void anchor()/* override*/ {
    }

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::MapHNode::MapHNode">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1051,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1022,
     FQN="llvm::yaml::Input::MapHNode::MapHNode", NM="_ZN4llvm4yaml5Input8MapHNodeC1EPNS0_4NodeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input8MapHNodeC1EPNS0_4NodeE")
    //</editor-fold>
    public MapHNode(Node /*P*/ n) {
      // : HNode(n), Mapping(), ValidKeys() 
      //START JInit
      super(n);
      this.Mapping = new StringMap<std.unique_ptr<HNode>>(new std.unique_ptr<HNode>());
      this.ValidKeys = new SmallVector</*const*/char$ptr/*char P*//*,  6*/>(6, null);
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::MapHNode::classof">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1053,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1024,
     FQN="llvm::yaml::Input::MapHNode::classof", NM="_ZN4llvm4yaml5Input8MapHNode7classofEPKNS1_5HNodeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input8MapHNode7classofEPKNS1_5HNodeE")
    //</editor-fold>
    public static /*inline*/ boolean classof(/*const*/ HNode /*P*/ n) {
      return MappingNode.classof(n._node);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::MapHNode::classof">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1056,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1027,
     FQN="llvm::yaml::Input::MapHNode::classof", NM="_ZN4llvm4yaml5Input8MapHNode7classofEPKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input8MapHNode7classofEPKS2_")
    //</editor-fold>
    public static /*inline*/ boolean classof(/*const*/ MapHNode /*P*/ $Prm0) {
      return true;
    }

    
    // JAVA: typedef llvm::StringMap<std::unique_ptr<HNode> > NameToNode
//    public final class NameToNode extends StringMap<std.unique_ptr<HNode>>{ };
    
    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::MapHNode::isValidKey">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 379,
     FQN="llvm::yaml::Input::MapHNode::isValidKey", NM="_ZN4llvm4yaml5Input8MapHNode10isValidKeyENS_9StringRefE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input8MapHNode10isValidKeyENS_9StringRefE")
    //</editor-fold>
    public boolean isValidKey(StringRef Key) {
      for (/*const*/char$ptr/*char P*/ K : ValidKeys) {
        if (Key.equals(/*STRINGREF_STR*/K)) {
          return true;
        }
      }
      return false;
    }

    
    public StringMap<std.unique_ptr<HNode>> Mapping;
    public SmallVector</*const*/char$ptr/*char P*//*,  6*/> ValidKeys;
    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::MapHNode::~MapHNode">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1047,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1018,
     FQN="llvm::yaml::Input::MapHNode::~MapHNode", NM="_ZN4llvm4yaml5Input8MapHNodeD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input8MapHNodeD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      //START JDestroy
      ValidKeys.$destroy();
      Mapping.$destroy();
      super.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "Mapping=" + Mapping // NOI18N
                + ", ValidKeys=" + ValidKeys // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::SequenceHNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1066,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1037,
   FQN="llvm::yaml::Input::SequenceHNode", NM="_ZN4llvm4yaml5Input13SequenceHNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input13SequenceHNodeE")
  //</editor-fold>
  /*friend*/public/*private*/ static class SequenceHNode extends /*public*/ HNode implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::SequenceHNode::anchor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 69,
     FQN="llvm::yaml::Input::SequenceHNode::anchor", NM="_ZN4llvm4yaml5Input13SequenceHNode6anchorEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input13SequenceHNode6anchorEv")
    //</editor-fold>
    @Override protected/*private*/ void anchor()/* override*/ {
    }

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::SequenceHNode::SequenceHNode">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1070,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1041,
     FQN="llvm::yaml::Input::SequenceHNode::SequenceHNode", NM="_ZN4llvm4yaml5Input13SequenceHNodeC1EPNS0_4NodeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input13SequenceHNodeC1EPNS0_4NodeE")
    //</editor-fold>
    public SequenceHNode(Node /*P*/ n) {
      // : HNode(n), Entries() 
      //START JInit
      super(n);
      this.Entries = new std.vector<std.unique_ptr<HNode>>(new std.unique_ptr<HNode>());
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::SequenceHNode::classof">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1072,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1043,
     FQN="llvm::yaml::Input::SequenceHNode::classof", NM="_ZN4llvm4yaml5Input13SequenceHNode7classofEPKNS1_5HNodeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input13SequenceHNode7classofEPKNS1_5HNodeE")
    //</editor-fold>
    public static /*inline*/ boolean classof(/*const*/ HNode /*P*/ n) {
      return SequenceNode.classof(n._node);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::SequenceHNode::classof">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1075,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1046,
     FQN="llvm::yaml::Input::SequenceHNode::classof", NM="_ZN4llvm4yaml5Input13SequenceHNode7classofEPKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input13SequenceHNode7classofEPKS2_")
    //</editor-fold>
    public static /*inline*/ boolean classof(/*const*/ SequenceHNode /*P*/ $Prm0) {
      return true;
    }

    
    public std.vector<std.unique_ptr<HNode>> Entries;
    //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::SequenceHNode::~SequenceHNode">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1066,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1037,
     FQN="llvm::yaml::Input::SequenceHNode::~SequenceHNode", NM="_ZN4llvm4yaml5Input13SequenceHNodeD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input13SequenceHNodeD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      //START JDestroy
      Entries.$destroy();
      super.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "Entries=" + Entries // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::createHNodes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 329,
   FQN="llvm::yaml::Input::createHNodes", NM="_ZN4llvm4yaml5Input12createHNodesEPNS0_4NodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input12createHNodesEPNS0_4NodeE")
  //</editor-fold>
  private std.unique_ptr<Input.HNode> createHNodes(Node /*P*/ N) {
    SmallString/*128*/ StringStorage/*J*/= new SmallString/*128*/(128);
    {
      ScalarNode /*P*/ SN = dyn_cast_ScalarNode(N);
      if ((SN != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          StringRef KeyStr = SN.getValue(StringStorage);
          if (!StringStorage.empty()) {
            // Copy string to permanent storage
            KeyStr.$assignMove(StringStorage.str().copy(StringAllocator));
          }
          return $c$.clean(new std.unique_ptr<Input.HNode>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new ScalarHNode(N, KeyStr)))));
        } finally {
          $c$.$destroy();
        }
      } else {
        BlockScalarNode /*P*/ BSN = dyn_cast_BlockScalarNode(N);
        if ((BSN != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            StringRef ValueCopy = BSN.getValue().copy(StringAllocator);
            return $c$.clean(new std.unique_ptr<Input.HNode>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new ScalarHNode(N, ValueCopy)))));
          } finally {
            $c$.$destroy();
          }
        } else {
          SequenceNode /*P*/ SQ = dyn_cast_SequenceNode(N);
          if ((SQ != null)) {
            unique_ptr<SequenceHNode> SQHNode = null;
            try {
              SQHNode = llvm.make_unique(new SequenceHNode(N));
              for (final Node /*&*/ SN$1 : $Deref(SQ)) {
                unique_ptr<HNode> Entry = null;
                try {
                  Entry = this.createHNodes($AddrOf(SN$1));
                  if (EC.$bool()) {
                    break;
                  }
                  SQHNode.$arrow().Entries.push_back_T$RR(std.move(Entry));
                } finally {
                  if (Entry != null) { Entry.$destroy(); }
                }
              }
              return new std.unique_ptr<Input.HNode>(JD$Unique_ptr$_Up$_Ep.INSTANCE, std.move(SQHNode));
            } finally {
              if (SQHNode != null) { SQHNode.$destroy(); }
            }
          } else {
            MappingNode /*P*/ Map = dyn_cast_MappingNode(N);
            if ((Map != null)) {
              unique_ptr<MapHNode> mapHNode = null;
              try {
                mapHNode = llvm.make_unique(new MapHNode(N));
                for (final KeyValueNode /*&*/ KVN : $Deref(Map)) {
                  unique_ptr<HNode> ValueHNode = null;
                  try {
                    Node /*P*/ KeyNode = KVN.getKey();
                    ScalarNode /*P*/ KeyScalar = dyn_cast_ScalarNode(KeyNode);
                    if (!(KeyScalar != null)) {
                      setError(KeyNode, new Twine(/*KEEP_STR*/"Map key must be a scalar"));
                      break;
                    }
                    StringStorage.clear();
                    StringRef KeyStr = KeyScalar.getValue(StringStorage);
                    if (!StringStorage.empty()) {
                      // Copy string to permanent storage
                      KeyStr.$assignMove(StringStorage.str().copy(StringAllocator));
                    }
                    ValueHNode = this.createHNodes(KVN.getValue());
                    if (EC.$bool()) {
                      break;
                    }
                    mapHNode.$arrow().Mapping.$at(/*NO_COPY*/KeyStr).$assignMove(std.move(ValueHNode));
                  } finally {
                    if (ValueHNode != null) { ValueHNode.$destroy(); }
                  }
                }
                return new std.unique_ptr<Input.HNode>(JD$Unique_ptr$_Up$_Ep.INSTANCE, std.move(mapHNode));
              } finally {
                if (mapHNode != null) { mapHNode.$destroy(); }
              }
            } else if (isa_NullNode(N)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                return $c$.clean(new std.unique_ptr<Input.HNode>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new EmptyHNode(N)))));
              } finally {
                $c$.$destroy();
              }
            } else {
              setError(N, new Twine(/*KEEP_STR*/"unknown node kind"));
              return new std.unique_ptr<Input.HNode>(JD$NullPtr.INSTANCE, null);
            }
          }
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::setError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 319,
   FQN="llvm::yaml::Input::setError", NM="_ZN4llvm4yaml5Input8setErrorEPNS1_5HNodeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input8setErrorEPNS1_5HNodeERKNS_5TwineE")
  //</editor-fold>
  private void setError(HNode /*P*/ hnode, final /*const*/ Twine /*&*/ message) {
    assert ((hnode != null)) : "HNode must not be NULL";
    this.setError(hnode._node, message);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::setError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 324,
   FQN="llvm::yaml::Input::setError", NM="_ZN4llvm4yaml5Input8setErrorEPNS0_4NodeERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input8setErrorEPNS0_4NodeERKNS_5TwineE")
  //</editor-fold>
  private void setError(Node /*P*/ node, final /*const*/ Twine /*&*/ message) {
    Strm.$arrow().printError(node, message);
    EC.$assignMove(make_error_code(errc.invalid_argument));
  }

/*public:*/
  // These are only used by operator>>. They could be private
  // if those templated things could be made friends.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::setCurrentDocument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 75,
   FQN="llvm::yaml::Input::setCurrentDocument", NM="_ZN4llvm4yaml5Input18setCurrentDocumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input18setCurrentDocumentEv")
  //</editor-fold>
  public boolean setCurrentDocument() {
    if (DocIterator.$noteq(Strm.$arrow().end())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Node /*P*/ N = DocIterator.$arrow().$arrow().getRoot();
        if (!(N != null)) {
          assert (Strm.$arrow().failed()) : "Root is NULL iff parsing failed";
          EC.$assignMove(make_error_code(errc.invalid_argument));
          return false;
        }
        if (isa_NullNode(N)) {
          // Empty files are allowed and ignored
          DocIterator.$preInc();
          return setCurrentDocument();
        }
        $c$.clean(TopNode.$assignMove($c$.track(this.createHNodes(N))));
        CurrentNode = TopNode.get();
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::nextDocument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 96,
   FQN="llvm::yaml::Input::nextDocument", NM="_ZN4llvm4yaml5Input12nextDocumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml5Input12nextDocumentEv")
  //</editor-fold>
  public boolean nextDocument() {
    return DocIterator.$preInc().$noteq(Strm.$arrow().end());
  }

  
  /// Returns the current node that's being parsed by the YAML Parser.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::Input::getCurrentNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 100,
   FQN="llvm::yaml::Input::getCurrentNode", NM="_ZNK4llvm4yaml5Input14getCurrentNodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZNK4llvm4yaml5Input14getCurrentNodeEv")
  //</editor-fold>
  public /*const*/ Node /*P*/ getCurrentNode() /*const*/ {
    return (CurrentNode != null) ? CurrentNode._node : null;
  }

/*private:*/
  private SourceMgr SrcMgr; // must be before Strm
  private std.unique_ptr<Stream> Strm;
  private std.unique_ptr<HNode> TopNode;
  private std.error_code EC;
  private BumpPtrAllocatorImpl StringAllocator;
  private document_iterator DocIterator;
  private std.vectorBool BitValuesUsed;
  private HNode /*P*/ CurrentNode;
  private boolean ScalarMatchFound;
  
  @Override public String toString() {
    return "" + "SrcMgr=" + SrcMgr // NOI18N
              //+ ", Strm=" + Strm // NOI18N
              + ", TopNode=" + TopNode // NOI18N
              + ", EC=" + EC // NOI18N
              + ", StringAllocator=" + "[BumpPtrAllocatorImpl]" // NOI18N
              //+ ", DocIterator=" + DocIterator // NOI18N
              + ", BitValuesUsed=" + BitValuesUsed // NOI18N
              + ", CurrentNode=" + CurrentNode // NOI18N
              + ", ScalarMatchFound=" + ScalarMatchFound // NOI18N
              + super.toString(); // NOI18N
  }
}
